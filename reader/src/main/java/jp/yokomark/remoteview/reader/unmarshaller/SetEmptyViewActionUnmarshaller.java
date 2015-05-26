package jp.yokomark.remoteview.reader.unmarshaller;

import android.os.Parcel;
import android.os.Parcelable;

import jp.yokomark.remoteview.reader.action.SetEmptyViewAction;

/**
 * @author KeishinYokomaku
 */
public class SetEmptyViewActionUnmarshaller implements Unmarshaller {
    public static final String TAG = SetEmptyViewActionUnmarshaller.class.getSimpleName();

    @Override
    public SetEmptyViewAction unmarshal(Parcelable p, Parcel action) {
        int id = action.readInt();
        int emptyViewId = action.readInt();
        return new SetEmptyViewAction(id, emptyViewId);
    }
}
