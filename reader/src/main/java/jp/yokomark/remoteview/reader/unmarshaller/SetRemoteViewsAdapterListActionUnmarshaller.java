package jp.yokomark.remoteview.reader.unmarshaller;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.RemoteViews;

import java.util.ArrayList;
import java.util.List;

import jp.yokomark.remoteview.reader.action.SetRemoteViewsAdapterListAction;

/**
 * @author KeishinYokomaku
 */
public class SetRemoteViewsAdapterListActionUnmarshaller implements Unmarshaller {
    public static final String TAG = SetRemoteViewsAdapterListActionUnmarshaller.class.getSimpleName();

    @Override
    public SetRemoteViewsAdapterListAction unmarshal(Parcelable p, Parcel action) {
        int id = action.readInt();
        int viewTypeCount = action.readInt();
        int count = action.readInt();
        List<RemoteViews> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            RemoteViews rv = RemoteViews.CREATOR.createFromParcel(action);
            list.add(rv);
        }
        return new SetRemoteViewsAdapterListAction(id, count, viewTypeCount, list);
    }
}
