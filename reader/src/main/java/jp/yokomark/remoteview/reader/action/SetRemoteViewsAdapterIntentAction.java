package jp.yokomark.remoteview.reader.action;

import android.content.Intent;

import jp.yokomark.remoteview.reader.ActionMap;

/**
 * @author KeishinYokomaku
 */
public class SetRemoteViewsAdapterIntentAction extends RemoteViewsAction {
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

    public Intent getIntent() {
        return intent;
    }
}
