package jp.yokomark.remoteview.reader.action;

import android.support.annotation.DrawableRes;

import jp.yokomark.remoteview.reader.ActionMap;

/**
 * @author KeishinYokomaku
 */
public class TextViewDrawableAction extends RemoteViewsAction {
    public static final String TAG = TextViewDrawableAction.class.getSimpleName();
    private final boolean isRelative;
    private final int left;
    private final int top;
    private final int right;
    private final int bottom;

    public TextViewDrawableAction(int viewId, boolean isRelative, int left, int top, int right, int bottom) {
        super(ActionMap.TEXT_VIEW_DRAWABLE.getTag(), viewId);
        this.isRelative = isRelative;
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    @Override
    public String getActionName() {
        return "TextViewDrawableAction";
    }

    public boolean isRelative() {
        return isRelative;
    }

    public @DrawableRes int getLeft() {
        return left;
    }

    public @DrawableRes int getTop() {
        return top;
    }

    public @DrawableRes int getRight() {
        return right;
    }

    public @DrawableRes int getBottom() {
        return bottom;
    }
}
