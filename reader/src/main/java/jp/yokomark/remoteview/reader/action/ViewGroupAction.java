package jp.yokomark.remoteview.reader.action;

import android.content.Context;
import android.widget.RemoteViews;

import jp.yokomark.remoteview.reader.ActionMap;
import jp.yokomark.remoteview.reader.RemoteViewsInfo;
import jp.yokomark.remoteview.reader.RemoteViewsReader;

/**
 * @author KeishinYokomaku
 */
public class ViewGroupAction extends RemoteViewsAction {
    public static final String TAG = ViewGroupAction.class.getSimpleName();
    private final RemoteViews nested;

    public ViewGroupAction(int viewId, RemoteViews nested) {
        super(ActionMap.VIEW_GROUP.getTag(), viewId);
        this.nested = nested;
    }

    @Override
    public String getActionName() {
        return "ViewGroupAction";
    }

    public RemoteViews getNestedViews() {
        return nested;
    }

    public RemoteViewsInfo getNestedViewsInfo(Context context) {
        if (nested == null) {
            return null;
        }
        return RemoteViewsReader.read(context, nested);
    }
}
