package jp.yokomark.remoteview.reader.unmarshaller;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.widget.RemoteViews;

import java.lang.reflect.Field;

import jp.yokomark.remoteview.reader.action.ViewGroupAction;

/**
 * @author KeishinYokomaku
 */
public class ViewGroupActionUnmarshaller implements Unmarshaller {
    public static final String TAG = ViewGroupActionUnmarshaller.class.getSimpleName();

    @Override
    public final ViewGroupAction unmarshal(Parcelable p, Parcel action) {
        try {
            int id = action.readInt();
            Field nestedField = p.getClass().getDeclaredField("nestedViews");
            nestedField.setAccessible(true);
            RemoteViews nested = (RemoteViews) nestedField.get(p);
            return new ViewGroupAction(id, nested);
        } catch (NoSuchFieldException e) {
            Log.e(TAG, "", e);
        } catch (IllegalAccessException e) {
            Log.e(TAG, "", e);
        }
        return null;
    }

}
