package jp.yokomark.remoteview.reader.unmarshaller;

import android.os.Parcel;
import android.os.Parcelable;

import jp.yokomark.remoteview.reader.action.RemoteViewsAction;

/**
 * @author KeishinYokomaku
 */
public class UnknownActionUnmarshaller implements Unmarshaller {
    public static final String TAG = UnknownActionUnmarshaller.class.getSimpleName();

    @Override
    public RemoteViewsAction unmarshal(Parcelable p, Parcel action) {
        return null;
    }
}
