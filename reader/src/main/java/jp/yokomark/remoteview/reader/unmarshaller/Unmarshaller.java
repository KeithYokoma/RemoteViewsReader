package jp.yokomark.remoteview.reader.unmarshaller;

import android.os.Parcel;
import android.os.Parcelable;

import jp.yokomark.remoteview.reader.action.RemoteViewsAction;

/**
 * @author KeishinYokomaku
 */
public interface Unmarshaller {
    RemoteViewsAction unmarshal(Parcelable p, Parcel action);
}
