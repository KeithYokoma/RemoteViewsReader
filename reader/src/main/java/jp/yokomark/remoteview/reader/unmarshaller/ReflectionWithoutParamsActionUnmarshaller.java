package jp.yokomark.remoteview.reader.unmarshaller;

import android.os.Parcel;
import android.os.Parcelable;

import jp.yokomark.remoteview.reader.action.ReflectionWithoutParamsAction;

/**
 * @author KeishinYokomaku
 */
public class ReflectionWithoutParamsActionUnmarshaller implements Unmarshaller {
    public static final String TAG = ReflectionWithoutParamsActionUnmarshaller.class.getSimpleName();

    @Override
    public ReflectionWithoutParamsAction unmarshal(Parcelable p, Parcel action) {
        int id = action.readInt();
        String methodName = action.readString();
        return new ReflectionWithoutParamsAction(id, methodName);
    }
}
