package jp.yokomark.remoteview.reader.action;

import android.content.Intent;
import android.support.annotation.Nullable;

import jp.yokomark.remoteview.reader.ActionMap;

/**
 * @author KeishinYokomaku
 */
public class SetRemoteViewsAdapterIntentAction extends RemoteViewsAction implements IntentContainer {
    public static final String TAG = SetRemoteViewsAdapterIntentAction.class.getSimpleName();
    private final Intent intent;

    public SetRemoteViewsAdapterIntentAction(int viewId, Intent intent) {
        super(ActionMap.SET_REMOTE_VIEWS_ADAPTER_INTENT.getTag(), viewId);
        this.intent = intent;
    }

    @Override
    public String getActionName() {
        return "SetRemoteViewsAdapterIntentAction";
    }

    @Override
    @Nullable
    public Intent getContentIntent() {
        return intent;
    }
}
