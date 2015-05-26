package jp.yokomark.remoteview.reader.unmarshaller;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.lang.reflect.Field;

import jp.yokomark.remoteview.reader.action.SetOnClickFillInIntentAction;

/**
 * @author KeishinYokomaku
 */
public class SetOnClickFillInIntentActionUnmarshaller implements Unmarshaller {
    public static final String TAG = SetOnClickFillInIntentActionUnmarshaller.class.getSimpleName();

    @Override
    public SetOnClickFillInIntentAction unmarshal(Parcelable p, Parcel action) {
        try {
            int id = action.readInt();
            Field intentField = p.getClass().getDeclaredField("fillInIntent");
            intentField.setAccessible(true);
            Intent intent = (Intent) intentField.get(p);
            return new SetOnClickFillInIntentAction(id, intent);
        } catch (IllegalAccessException e) {
            Log.e(TAG, "", e);
        } catch (NoSuchFieldException e) {
            Log.e(TAG, "", e);
        }
        return null;
    }
}
