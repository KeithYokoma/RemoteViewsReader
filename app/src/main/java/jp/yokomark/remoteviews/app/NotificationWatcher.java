package jp.yokomark.remoteviews.app;

import android.annotation.TargetApi;
import android.os.Build;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import android.widget.RemoteViews;

import java.util.List;

import jp.yokomark.remoteview.reader.RemoteViewsInfo;
import jp.yokomark.remoteview.reader.RemoteViewsReader;
import jp.yokomark.remoteview.reader.action.RemoteViewsAction;

/**
 * @author KeishinYokomaku
 */
@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
public class NotificationWatcher extends NotificationListenerService {
	@Override
	public void onNotificationPosted(StatusBarNotification sbn) {
		RemoteViews views = sbn.getNotification().contentView;
		RemoteViewsInfo info = RemoteViewsReader.read(this, views);
		if (info == null)
			return;
		List<RemoteViewsAction> actions = info.getActions();
		for (RemoteViewsAction action : actions)
			Log.v("NotificationWatcher", action.getActionName());
	}

	@Override
	public void onNotificationRemoved(StatusBarNotification sbn) {}
}
