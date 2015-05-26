package jp.yokomark.remoteview.reader.unmarshaller;

import android.os.Parcel;
import android.os.Parcelable;

import jp.yokomark.remoteview.reader.action.TextViewDrawableAction;

/**
 * @author KeishinYokomaku
 */
public class TextViewDrawableActionUnmarshaller implements Unmarshaller {
    public static final String TAG = TextViewDrawableActionUnmarshaller.class.getSimpleName();

    @Override
    public TextViewDrawableAction unmarshal(Parcelable p, Parcel action) {
        int id = action.readInt();
        boolean relative = action.readInt() == 1;
        int left = action.readInt();
        int top = action.readInt();
        int right = action.readInt();
        int bottom = action.readInt();
        return new TextViewDrawableAction(id, relative, left, top, right, bottom);
    }
}
