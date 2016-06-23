package jp.yokomark.remoteview.reader.action;

import android.app.PendingIntent;

/**
 * @author KeishinYokomaku
 */
public interface PendingIntentContainer extends IntentContainer {
	PendingIntent getPendingIntent();
}
