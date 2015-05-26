package jp.yokomark.remoteview.reader.action;

/**
 * @author KeishinYokomaku
 */
public abstract class RemoteViewsAction {
    private final int tag;
    private final int viewId;

    /* package */ RemoteViewsAction(int tag, int viewId) {
        this.tag = tag;
        this.viewId = viewId;
    }

    public int getTag() {
        return tag;
    }

    public int getViewId() {
        return viewId;
    }

    public abstract String getActionName();
}
