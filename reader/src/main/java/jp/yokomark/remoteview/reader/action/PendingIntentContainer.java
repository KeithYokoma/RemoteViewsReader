package jp.yokomark.remoteview.reader.action;

import android.app.PendingIntent;
import androidx.annotation.Nullable;

/**
 * @author KeishinYokomaku
 */
public interface PendingIntentContainer extends IntentContainer {
	@Nullable
	PendingIntent getPendingIntent();
}
