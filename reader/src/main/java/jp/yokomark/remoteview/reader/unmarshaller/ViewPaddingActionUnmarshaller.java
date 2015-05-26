package jp.yokomark.remoteview.reader.unmarshaller;

import android.os.Parcel;
import android.os.Parcelable;

import jp.yokomark.remoteview.reader.action.ViewPaddingAction;

/**
 * @author KeishinYokomaku
 */
public class ViewPaddingActionUnmarshaller implements Unmarshaller {
    public static final String TAG = ViewPaddingActionUnmarshaller.class.getSimpleName();

    @Override
    public ViewPaddingAction unmarshal(Parcelable p, Parcel action) {
        int id = action.readInt();
        int left = action.readInt();
        int top = action.readInt();
        int right = action.readInt();
        int bottom = action.readInt();
        return new ViewPaddingAction(id, left, top, right, bottom);
    }
}
