package jp.yokomark.remoteview.reader.action;

import android.graphics.PorterDuff;

import jp.yokomark.remoteview.reader.ActionMap;

/**
 * @author KeishinYokomaku
 */
public class SetDrawableParamsAction extends RemoteViewsAction {
    public static final String TAG = SetDrawableParamsAction.class.getSimpleName();
    private final boolean target;
    private final int alpha;
    private final int colorFilter;
    private final PorterDuff.Mode mode;
    private final int level;

    public SetDrawableParamsAction(int viewId, boolean target, int alpha, int colorFilter, PorterDuff.Mode mode, int level) {
        super(ActionMap.SET_DRAWABLE_PARAMS.getTag(), viewId);
        this.target = target;
        this.alpha = alpha;
        this.colorFilter = colorFilter;
        this.mode = mode;
        this.level = level;
    }

    @Override
    public String getActionName() {
        return "SetDrawableParams";
    }

    public boolean isTarget() {
        return target;
    }

    public int getAlpha() {
        return alpha;
    }

    public int getColorFilter() {
        return colorFilter;
    }

    public PorterDuff.Mode getMode() {
        return mode;
    }

    public int getLevel() {
        return level;
    }
}
