package jp.yokomark.remoteview.reader.unmarshaller;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.lang.reflect.Field;

import jp.yokomark.remoteview.reader.action.SetRemoteViewsAdapterIntentAction;

/**
 * @author KeishinYokomaku
 */
public class SetRemoteViewsAdapterIntentActionUnmarshaller implements Unmarshaller {
    public static final String TAG = SetRemoteViewsAdapterIntentActionUnmarshaller.class.getSimpleName();

    @Override
    public SetRemoteViewsAdapterIntentAction unmarshal(Parcelable p, Parcel action) {
        try {
            int id = action.readInt();
            Field intentField = p.getClass().getDeclaredField("intent");
            intentField.setAccessible(true);
            Intent intent = (Intent) intentField.get(p);
            return new SetRemoteViewsAdapterIntentAction(id, intent);
        } catch (IllegalAccessException e) {
            Log.e(TAG, "", e);
        } catch (NoSuchFieldException e) {
            Log.e(TAG, "", e);
        }
        return null;
    }
}
