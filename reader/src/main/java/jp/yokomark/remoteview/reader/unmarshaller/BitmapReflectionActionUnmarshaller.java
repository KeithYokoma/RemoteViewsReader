package jp.yokomark.remoteview.reader.unmarshaller;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.lang.reflect.Field;

import jp.yokomark.remoteview.reader.action.BitmapReflectionAction;

/**
 * @author KeishinYokomaku
 */
public class BitmapReflectionActionUnmarshaller implements Unmarshaller {
    public static final String TAG = BitmapReflectionActionUnmarshaller.class.getSimpleName();

    @Override
    public BitmapReflectionAction unmarshal(Parcelable p, Parcel action) {
        try {
            int id = action.readInt();
            String methodName = action.readString();
            Field bitmapField = p.getClass().getDeclaredField("bitmap");
            bitmapField.setAccessible(true);
            Bitmap bitmap = (Bitmap) bitmapField.get(p);
            return new BitmapReflectionAction(id, methodName, bitmap);
        } catch (NoSuchFieldException e) {
            Log.e(TAG, "", e);
        } catch (IllegalAccessException e) {
            Log.e(TAG, "", e);
        }
        return null;
    }
}
