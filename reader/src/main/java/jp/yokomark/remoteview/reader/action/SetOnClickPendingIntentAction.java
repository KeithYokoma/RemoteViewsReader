package jp.yokomark.remoteview.reader.action;

import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import jp.yokomark.remoteview.reader.ActionMap;

/**
 * @author KeishinYokomaku
 */
public class SetOnClickPendingIntentAction extends RemoteViewsAction {
    public static final String TAG = SetOnClickPendingIntentAction.class.getSimpleName();
    private final PendingIntent pendingIntent;

    public SetOnClickPendingIntentAction(int viewId, PendingIntent pendingIntent) {
        super(ActionMap.SET_PENDING_INTENT.getTag(), viewId);
        this.pendingIntent = pendingIntent;
    }

    @Override
    public String getActionName() {
        return "SetOnClickPendingIntentAction";
    }

    public PendingIntent getPendingIntent() {
        return pendingIntent;
    }

    public Intent getContentIntent() {
        try {
            Method getIntent = pendingIntent.getClass().getDeclaredMethod("getIntent");
            getIntent.setAccessible(true);
            return (Intent) getIntent.invoke(pendingIntent);
        } catch (NoSuchMethodException e) {
            Log.e(TAG, "", e);
        } catch (InvocationTargetException e) {
            Log.e(TAG, "", e);
        } catch (IllegalAccessException e) {
            Log.e(TAG, "", e);
        }
        return null;
    }
}
