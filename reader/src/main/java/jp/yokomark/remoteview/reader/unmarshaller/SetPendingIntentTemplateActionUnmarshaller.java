package jp.yokomark.remoteview.reader.unmarshaller;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.lang.reflect.Field;

import jp.yokomark.remoteview.reader.action.SetPendingIntentTemplateAction;

/**
 * @author KeishinYokomaku
 */
public class SetPendingIntentTemplateActionUnmarshaller implements Unmarshaller {
    public static final String TAG = SetPendingIntentTemplateActionUnmarshaller.class.getSimpleName();

    @Override
    public SetPendingIntentTemplateAction unmarshal(Parcelable p, Parcel action) {
        try {
            int id = action.readInt();
            Field nestedField = p.getClass().getDeclaredField("pendingIntentTemplate");
            nestedField.setAccessible(true);
            PendingIntent pendingIntent = (PendingIntent) nestedField.get(p);
            return new SetPendingIntentTemplateAction(id, pendingIntent);
        } catch (NoSuchFieldException e) {
            Log.e(TAG, "", e);
        } catch (IllegalAccessException e) {
            Log.e(TAG, "", e);
        }
        return null;
    }
}
