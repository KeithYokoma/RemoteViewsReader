package jp.yokomark.remoteview.reader.action;

import jp.yokomark.remoteview.reader.ActionMap;

/**
 * @author KeishinYokomaku
 */
public class ViewPaddingAction extends RemoteViewsAction {
    public static final String TAG = ViewPaddingAction.class.getSimpleName();
    private final int left;
    private final int top;
    private final int right;
    private final int bottom;

    public ViewPaddingAction(int viewId, int left, int top, int right, int bottom) {
        super(ActionMap.VIEW_PADDING.getTag(), viewId);
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    @Override
    public String getActionName() {
        return "ViewPaddingAction";
    }

    public int getLeft() {
        return left;
    }

    public int getTop() {
        return top;
    }

    public int getRight() {
        return right;
    }

    public int getBottom() {
        return bottom;
    }
}
