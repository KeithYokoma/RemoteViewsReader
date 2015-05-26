package jp.yokomark.remoteview.reader.action;

import android.graphics.Bitmap;

import jp.yokomark.remoteview.reader.ActionMap;

/**
 * @author KeishinYokomaku
 */
public class BitmapReflectionAction extends RemoteViewsAction {
    public static final String TAG = BitmapReflectionAction.class.getSimpleName();
    private final String methodName;
    private final Bitmap bitmap;

    public BitmapReflectionAction(int viewId, String methodName, Bitmap bitmap) {
        super(ActionMap.BITMAP_REFLECTION.getTag(), viewId);
        this.methodName = methodName;
        this.bitmap = bitmap;
    }

    @Override
    public String getActionName() {
        return "BitmapReflectionAction";
    }

    public String getMethodName() {
        return methodName;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }
}
