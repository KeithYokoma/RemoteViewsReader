package jp.yokomark.remoteview.reader;

import android.content.pm.ApplicationInfo;

import java.util.ArrayList;
import java.util.List;

import jp.yokomark.remoteview.reader.action.RemoteViewsAction;

/**
 * @author KeishinYokomaku
 */
public class RemoteViewsInfo {
    private final ApplicationInfo hostApplicaiton;
    private final int layoutId;
    private final List<RemoteViewsAction> actions;

    public RemoteViewsInfo(ApplicationInfo hostApplicaiton, int layoutId, List<RemoteViewsAction> actions) {
        this.hostApplicaiton = hostApplicaiton;
        this.layoutId = layoutId;
        this.actions = actions;
    }

    /* package */ static RemoteViewsInfo emptyActions(ApplicationInfo hostApplicaiton, int layoutId) {
        return new RemoteViewsInfo(hostApplicaiton, layoutId, new ArrayList<RemoteViewsAction>());
    }

    /* package */ static RemoteViewsInfo noInfo() {
        return new RemoteViewsInfo(null, 0, new ArrayList<RemoteViewsAction>());
    }

    public void addAction(RemoteViewsAction action) {
        actions.add(action);
    }

    public List<RemoteViewsAction> getActions() {
        return actions;
    }

    public ApplicationInfo getHostApplicaiton() {
        return hostApplicaiton;
    }

    public int getLayoutId() {
        return layoutId;
    }
}
