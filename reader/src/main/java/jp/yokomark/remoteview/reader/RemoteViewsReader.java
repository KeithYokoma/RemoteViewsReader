package jp.yokomark.remoteview.reader;

import android.content.pm.ApplicationInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.RemoteViews;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import jp.yokomark.remoteview.reader.action.RemoteViewsAction;

/**
 * @author KeishinYokomaku
 */
public class RemoteViewsReader {
    public static final String TAG = RemoteViewsReader.class.getSimpleName();

    public static @Nullable RemoteViewsInfo read(@NonNull RemoteViews remoteViews) {
        if (remoteViews == null) {
            return null;
        }
        try {
            Field actionsField = remoteViews.getClass().getDeclaredField("mActions");
            actionsField.setAccessible(true);
            @SuppressWarnings("unchecked")
            ArrayList<Parcelable> list = (ArrayList<Parcelable>) actionsField.get(remoteViews);
            Field applicationField = remoteViews.getClass().getDeclaredField("mApplication");
            applicationField.setAccessible(true);
            ApplicationInfo applicationInfo = (ApplicationInfo) applicationField.get(remoteViews);
            int layoutId = remoteViews.getLayoutId();
            List<RemoteViewsAction> actions = new ArrayList<>(list.size());
            for (Parcelable p : list) {
                Parcel action = Parcel.obtain();
                p.writeToParcel(action, 0);
                action.setDataPosition(0);

                ActionMap mapped = ActionMap.find(action.readInt());
                actions.add(mapped.getUnmarshaller().unmarshal(p, action));
            }
            return new RemoteViewsInfo(applicationInfo, layoutId, actions);
        } catch (NoSuchFieldException e) {
            Log.e(TAG, "", e);
        } catch (IllegalAccessException e) {
            Log.e(TAG, "", e);
        }
        return null;
    }
}
