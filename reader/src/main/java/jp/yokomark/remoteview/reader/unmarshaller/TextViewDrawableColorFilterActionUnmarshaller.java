package jp.yokomark.remoteview.reader.unmarshaller;

import android.graphics.PorterDuff;
import android.os.Parcel;
import android.os.Parcelable;

import jp.yokomark.remoteview.reader.action.TextViewDrawableColorFilterAction;

/**
 * @author KeishinYokomaku
 */
public class TextViewDrawableColorFilterActionUnmarshaller implements Unmarshaller {
    public static final String TAG = TextViewDrawableColorFilterActionUnmarshaller.class.getSimpleName();

    @Override
    public TextViewDrawableColorFilterAction unmarshal(Parcelable p, Parcel action) {
        int id = action.readInt();
        boolean relative = action.readInt() == 1;
        int index = action.readInt();
        int color = action.readInt();
        PorterDuff.Mode mode = readPorterDuffMode(action);
        return new TextViewDrawableColorFilterAction(id, relative, index, color, mode);
    }

    private PorterDuff.Mode readPorterDuffMode(Parcel parcel) {
        int mode = parcel.readInt();
        if (mode >= 0 && mode < PorterDuff.Mode.values().length) {
            return PorterDuff.Mode.values()[mode];
        } else {
            return PorterDuff.Mode.CLEAR;
        }
    }
}
