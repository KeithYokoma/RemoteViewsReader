package jp.yokomark.remoteview.reader.unmarshaller;

import android.os.Parcel;
import android.os.Parcelable;

import jp.yokomark.remoteview.reader.action.TextViewSizeAction;

/**
 * @author KeishinYokomaku
 */
public class TextViewSizeActionUnmarshaller implements Unmarshaller {
    @Override
    public TextViewSizeAction unmarshal(Parcelable p, Parcel action) {
        int id = action.readInt();
        int units = action.readInt();
        float size = action.readFloat();
        return new TextViewSizeAction(id, units, size);
    }
}
