package jp.yokomark.remoteview.reader.action;

import android.widget.RemoteViews;

import java.util.List;

import jp.yokomark.remoteview.reader.ActionMap;

/**
 * @author KeishinYokomaku
 */
public class SetRemoteViewsAdapterListAction extends RemoteViewsAction {
    public static final String TAG = SetRemoteViewsAdapterListAction.class.getSimpleName();
    private final int count;
    private final int viewTypeCount;
    private final List<RemoteViews> views;

    public SetRemoteViewsAdapterListAction(int viewId, int count, int viewTypeCount, List<RemoteViews> views) {
        super(ActionMap.SET_REMOTE_VIEWS_ADAPTER_LIST.getTag(), viewId);
        this.count = count;
        this.viewTypeCount = viewTypeCount;
        this.views = views;
    }

    @Override
    public String getActionName() {
        return "SetRemoteViewsAdapterListAction";
    }

    public int getCount() {
        return count;
    }

    public int getViewTypeCount() {
        return viewTypeCount;
    }

    public List<RemoteViews> getViews() {
        return views;
    }
}
