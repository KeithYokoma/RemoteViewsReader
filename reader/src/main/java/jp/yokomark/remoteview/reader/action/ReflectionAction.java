package jp.yokomark.remoteview.reader.action;

import jp.yokomark.remoteview.reader.ActionMap;

/**
 * @author KeishinYokomaku
 */
public class ReflectionAction extends RemoteViewsAction {
    public static final String TAG = ReflectionAction.class.getSimpleName();
    private final String methodName;
    private final Object value;

    public ReflectionAction(int viewId, String methodName, Object value) {
        super(ActionMap.REFLECTION.getTag(), viewId);
        this.methodName = methodName;
        this.value = value;
    }

    @Override
    public String getActionName() {
        return "ReflectionAction";
    }

    public String getMethodName() {
        return methodName;
    }

    public Object getValue() {
        return value;
    }
}
