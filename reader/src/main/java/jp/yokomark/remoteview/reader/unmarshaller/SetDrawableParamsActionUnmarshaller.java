package jp.yokomark.remoteview.reader.unmarshaller;

import android.graphics.PorterDuff;
import android.os.Parcel;
import android.os.Parcelable;

import jp.yokomark.remoteview.reader.action.SetDrawableParamsAction;

/**
 * @author KeishinYokomaku
 */
public class SetDrawableParamsActionUnmarshaller implements Unmarshaller {
    public static final String TAG = SetDrawableParamsActionUnmarshaller.class.getSimpleName();

    @Override
    public SetDrawableParamsAction unmarshal(Parcelable p, Parcel action) {
        int id = action.readInt();
        boolean target = action.readInt() == 1;
        int alpha = action.readInt();
        int colorFilter = action.readInt();
        boolean hasMode = action.readInt() == 1;
        PorterDuff.Mode mode = hasMode ? PorterDuff.Mode.valueOf(action.readString()) : null;
        int level = action.readInt();
        return new SetDrawableParamsAction(id, target, alpha, colorFilter, mode, level);
    }
}
