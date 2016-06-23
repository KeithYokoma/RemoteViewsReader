package jp.yokomark.remoteview.reader.action;

import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import jp.yokomark.remoteview.reader.ActionMap;

public class SetLaunchPendingIntentAction extends RemoteViewsAction implements PendingIntentContainer {
    public static final String TAG = SetLaunchPendingIntentAction.class.getSimpleName();
    private final PendingIntent pendingIntent;

    public SetLaunchPendingIntentAction(int viewId, PendingIntent pendingIntent) {
        super(ActionMap.SET_PENDING_INTENT.getTag(), viewId);
        this.pendingIntent = pendingIntent;
    }

    @Override
    public String getActionName() {
        return "SetLaunchPendingIntentAction";
    }

    @Override
    public PendingIntent getPendingIntent() {
        return pendingIntent;
    }

    @Override
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
