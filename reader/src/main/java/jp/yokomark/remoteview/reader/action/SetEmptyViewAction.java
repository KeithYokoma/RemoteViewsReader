package jp.yokomark.remoteview.reader.action;

import jp.yokomark.remoteview.reader.ActionMap;

/**
 * @author KeishinYokomaku
 */
public class SetEmptyViewAction extends RemoteViewsAction {
    public static final String TAG = SetEmptyViewAction.class.getSimpleName();
    private final int emptyViewId;

    public SetEmptyViewAction(int viewId, int emptyViewId) {
        super(ActionMap.SET_EMPTY_VIEW.getTag(), viewId);
        this.emptyViewId = emptyViewId;
    }

    @Override
    public String getActionName() {
        return "SetEmptyViewAction";
    }

    public int getEmptyViewId() {
        return emptyViewId;
    }
}
