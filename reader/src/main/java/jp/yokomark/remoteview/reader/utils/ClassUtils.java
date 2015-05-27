package jp.yokomark.remoteview.reader.utils;

import android.widget.RemoteViews;

/**
 * @author KeishinYokomaku
 */
public final class ClassUtils {
    private ClassUtils() {
        throw new AssertionError();
    }

    public static Class getRemoteViewsClass(Class<? extends RemoteViews> clazz) {
        if (clazz.equals(RemoteViews.class))
            return clazz;
        Class superClass = clazz.getSuperclass();
        while (!superClass.equals(RemoteViews.class)) {
            superClass = superClass.getSuperclass();
        }
        return superClass;
    }
}
