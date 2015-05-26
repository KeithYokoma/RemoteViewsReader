package jp.yokomark.remoteview.reader.action;

import android.graphics.PorterDuff;

import jp.yokomark.remoteview.reader.ActionMap;

/**
 * @author KeishinYokomaku
 */
public class TextViewDrawableColorFilterAction extends RemoteViewsAction {
    public static final String TAG = TextViewDrawableColorFilterAction.class.getSimpleName();
    private final boolean isRelative;
    private final int index;
    private final int color;
    private final PorterDuff.Mode mode;

    public TextViewDrawableColorFilterAction(int viewId, boolean isRelative, int index, int color, PorterDuff.Mode mode) {
        super(ActionMap.TEXT_VIEW_DRAWABLE_COLOR_FILTER_ACTION.getTag(), viewId);
        this.isRelative = isRelative;
        this.index = index;
        this.color = color;
        this.mode = mode;
    }

    @Override
    public String getActionName() {
        return "TextViewDrawableColorFilterAction";
    }

    public boolean isRelative() {
        return isRelative;
    }

    public int getIndex() {
        return index;
    }

    public int getColor() {
        return color;
    }

    public PorterDuff.Mode getMode() {
        return mode;
    }
}
