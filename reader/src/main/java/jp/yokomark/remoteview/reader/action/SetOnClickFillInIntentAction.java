package jp.yokomark.remoteview.reader.action;

import android.content.Intent;
import android.support.annotation.Nullable;

import jp.yokomark.remoteview.reader.ActionMap;

/**
 * @author KeishinYokomaku
 */
public class SetOnClickFillInIntentAction extends RemoteViewsAction implements IntentContainer {
    public static final String TAG = SetOnClickFillInIntentAction.class.getSimpleName();
    private final Intent intent;

    public SetOnClickFillInIntentAction(int viewId, Intent intent) {
        super(ActionMap.SET_FILL_IN_INTENT.getTag(), viewId);
        this.intent = intent;
    }

    @Override
    public String getActionName() {
        return "SetOnClickFillInIntentAction";
    }

    @Override
    @Nullable
    public Intent getContentIntent() {
        return intent;
    }
}
