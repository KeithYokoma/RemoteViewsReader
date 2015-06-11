package jp.yokomark.remoteview.reader.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.RemoteViews;

import java.lang.reflect.Field;

/**
 * @author KeishinYokomaku
 */
public final class ClassUtils {
    public static final String TAG = ClassUtils.class.getSimpleName();

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

    public static @Nullable ApplicationInfo getApplicationInfo(Context context, RemoteViews remoteViews, Class<? extends RemoteViews> clazz) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return getApplicationInfoLollipop(remoteViews, clazz);
        } else {
            return getApplicationInfoDefault(context, remoteViews, clazz);
        }
    }

    private static @Nullable ApplicationInfo getApplicationInfoLollipop(RemoteViews remoteViews, Class<? extends RemoteViews> clazz) {
        try {
            Field applicationField = clazz.getDeclaredField("mApplication");
            applicationField.setAccessible(true);
            return (ApplicationInfo) applicationField.get(remoteViews);
        } catch (NoSuchFieldException e) {
            Log.e(TAG, "no such field: ", e);
            return null;
        } catch (IllegalAccessException e) {
            Log.e(TAG, "cannot access to the field: ", e);
            return null;
        }
    }

    private static @Nullable ApplicationInfo getApplicationInfoDefault(Context context, RemoteViews remoteViews, Class<? extends RemoteViews> clazz) {
        try {
            Field applicationField = clazz.getDeclaredField("mPackage");
            applicationField.setAccessible(true);
            String pkg = (String) applicationField.get(remoteViews);
            PackageManager pm = context.getPackageManager();
            return pm.getApplicationInfo(pkg, 0);
        } catch (NoSuchFieldException e) {
            Log.e(TAG, "no such field: ", e);
            return null;
        } catch (IllegalAccessException e) {
            Log.e(TAG, "cannot access to the field: ", e);
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "no such package is installed: ", e);
            return null;
        }
    }
}
