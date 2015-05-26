package jp.yokomark.remoteview.reader.action;

import jp.yokomark.remoteview.reader.ActionMap;

/**
 * @author KeishinYokomaku
 */
public class TextViewSizeAction extends RemoteViewsAction {
    public static final String TAG = TextViewSizeAction.class.getSimpleName();
    private final int units;
    private final float size;

    public TextViewSizeAction(int viewId, int units, float size) {
        super(ActionMap.TEXT_VIEW_SIZE.getTag(), viewId);
        this.units = units;
        this.size = size;
    }

    @Override
    public String getActionName() {
        return "TextViewSizeAction";
    }

    public int getUnits() {
        return units;
    }

    public float getSize() {
        return size;
    }
}
