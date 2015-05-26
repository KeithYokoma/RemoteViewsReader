package jp.yokomark.remoteview.reader.action;

import jp.yokomark.remoteview.reader.ActionMap;

/**
 * @author KeishinYokomaku
 */
public class ReflectionWithoutParamsAction extends RemoteViewsAction {
    public static final String TAG = ReflectionWithoutParamsAction.class.getSimpleName();
    private final String methodName;

    public ReflectionWithoutParamsAction(int viewId, String methodName) {
        super(ActionMap.REFLECTION_WITHOUT_PARAMS.getTag(), viewId);
        this.methodName = methodName;
    }

    @Override
    public String getActionName() {
        return "ReflectionWithoutParamsAction";
    }

    public String getMethodName() {
        return methodName;
    }
}
