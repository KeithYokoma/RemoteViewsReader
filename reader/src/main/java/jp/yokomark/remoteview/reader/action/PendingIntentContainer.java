package jp.yokomark.remoteview.reader.action;

import android.app.PendingIntent;
import android.content.Intent;

/**
 * @author KeishinYokomaku
 */
public interface PendingIntentContainer {
	PendingIntent getPendingIntent();
	Intent getContentIntent();
}
