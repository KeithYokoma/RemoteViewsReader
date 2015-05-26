package jp.yokomark.remoteview.reader.unmarshaller;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.lang.reflect.Field;

import jp.yokomark.remoteview.reader.action.SetOnClickPendingIntentAction;

/**
 * @author KeishinYokomaku
 */
public class SetOnClickPendingIntentActionUnmarshaller implements Unmarshaller {
    public static final String TAG = SetOnClickPendingIntentActionUnmarshaller.class.getSimpleName();

    @Override
    public SetOnClickPendingIntentAction unmarshal(Parcelable p, Parcel action) {
        try {
            int id = action.readInt();
            Field nestedField = p.getClass().getDeclaredField("pendingIntent");
            nestedField.setAccessible(true);
            PendingIntent pendingIntent = (PendingIntent) nestedField.get(p);
            return new SetOnClickPendingIntentAction(id, pendingIntent);
        } catch (NoSuchFieldException e) {
            Log.e(TAG, "", e);
        } catch (IllegalAccessException e) {
            Log.e(TAG, "", e);
        }
        return null;
    }
}
