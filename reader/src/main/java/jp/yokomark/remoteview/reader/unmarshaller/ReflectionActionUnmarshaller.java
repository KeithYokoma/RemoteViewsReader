package jp.yokomark.remoteview.reader.unmarshaller;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.lang.reflect.Field;

import jp.yokomark.remoteview.reader.action.ReflectionAction;

/**
 * @author KeishinYokomaku
 */
public class ReflectionActionUnmarshaller implements Unmarshaller {
    public static final String TAG = ReflectionActionUnmarshaller.class.getSimpleName();

    @Override
    public ReflectionAction unmarshal(Parcelable p, Parcel action) {
        try {
            int id = action.readInt();
            String methodName = action.readString();
            Field valueField = p.getClass().getDeclaredField("value");
            valueField.setAccessible(true);
            return new ReflectionAction(id, methodName, valueField.get(p));
        } catch (NoSuchFieldException e) {
            Log.e(TAG, "", e);
        } catch (IllegalAccessException e) {
            Log.e(TAG, "", e);
        }
        return null;
    }
}
