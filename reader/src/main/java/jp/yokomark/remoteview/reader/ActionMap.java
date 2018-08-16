package jp.yokomark.remoteview.reader;

import android.support.annotation.NonNull;

import jp.yokomark.remoteview.reader.unmarshaller.BitmapReflectionActionUnmarshaller;
import jp.yokomark.remoteview.reader.unmarshaller.ReflectionActionUnmarshaller;
import jp.yokomark.remoteview.reader.unmarshaller.ReflectionWithoutParamsActionUnmarshaller;
import jp.yokomark.remoteview.reader.unmarshaller.SetDrawableParamsActionUnmarshaller;
import jp.yokomark.remoteview.reader.unmarshaller.SetEmptyViewActionUnmarshaller;
import jp.yokomark.remoteview.reader.unmarshaller.SetLaunchPendingIntentActionUnmarshaller;
import jp.yokomark.remoteview.reader.unmarshaller.SetOnClickFillInIntentActionUnmarshaller;
import jp.yokomark.remoteview.reader.unmarshaller.SetOnClickPendingIntentActionUnmarshaller;
import jp.yokomark.remoteview.reader.unmarshaller.SetPendingIntentTemplateActionUnmarshaller;
import jp.yokomark.remoteview.reader.unmarshaller.SetRemoteViewsAdapterIntentActionUnmarshaller;
import jp.yokomark.remoteview.reader.unmarshaller.SetRemoteViewsAdapterListActionUnmarshaller;
import jp.yokomark.remoteview.reader.unmarshaller.TextViewDrawableActionUnmarshaller;
import jp.yokomark.remoteview.reader.unmarshaller.TextViewDrawableColorFilterActionUnmarshaller;
import jp.yokomark.remoteview.reader.unmarshaller.TextViewSizeActionUnmarshaller;
import jp.yokomark.remoteview.reader.unmarshaller.UnknownActionUnmarshaller;
import jp.yokomark.remoteview.reader.unmarshaller.Unmarshaller;
import jp.yokomark.remoteview.reader.unmarshaller.ViewGroupActionUnmarshaller;
import jp.yokomark.remoteview.reader.unmarshaller.ViewPaddingActionUnmarshaller;

/**
 * @author KeishinYokomaku
 */
public enum ActionMap {
    SET_PENDING_INTENT("SetOnClickPendingIntent", 1, new SetOnClickPendingIntentActionUnmarshaller()),
    REFLECTION("ReflectionAction", 2, new ReflectionActionUnmarshaller()),
    SET_DRAWABLE_PARAMS("SetDrawableParamsAction", 3, new SetDrawableParamsActionUnmarshaller()),
    VIEW_GROUP("ViewGroupAction", 4, new ViewGroupActionUnmarshaller()),
    REFLECTION_WITHOUT_PARAMS("ReflectionWithoutParamsAction", 5, new ReflectionWithoutParamsActionUnmarshaller()),
    SET_EMPTY_VIEW("SetEmptyViewAction", 6, new SetEmptyViewActionUnmarshaller()),
    SET_PENDING_INTENT_TEMPLATE("SetPendingIntentTemplateAction", 8, new SetPendingIntentTemplateActionUnmarshaller()),
    SET_FILL_IN_INTENT("SetOnClickFillInIntent", 9, new SetOnClickFillInIntentActionUnmarshaller()),
    SET_REMOTE_VIEWS_ADAPTER_INTENT("SetRemoteViewsAdapterIntent", 10, new SetRemoteViewsAdapterIntentActionUnmarshaller()),
    TEXT_VIEW_DRAWABLE("TextViewDrawableAction", 11, new TextViewDrawableActionUnmarshaller()),
    BITMAP_REFLECTION("BitmapReflectionAction", 12, new BitmapReflectionActionUnmarshaller()),
    TEXT_VIEW_SIZE("TextViewSizeAction", 13, new TextViewSizeActionUnmarshaller()),
    VIEW_PADDING("ViewPaddingAction", 14, new ViewPaddingActionUnmarshaller()),
    SET_REMOTE_VIEWS_ADAPTER_LIST("SetRemoteViewsAdapterList", 15, new SetRemoteViewsAdapterListActionUnmarshaller()),
    TEXT_VIEW_DRAWABLE_COLOR_FILTER_ACTION("TextViewDrawableColorFilterAction", 17, new TextViewDrawableColorFilterActionUnmarshaller()),
    SET_LAUNCH_PENDING_INTENT("SetLaunchPendingIntent", 20, new SetLaunchPendingIntentActionUnmarshaller()), // why do you do that to us ms samsung?
    UNKNOWN("", 0, new UnknownActionUnmarshaller());

    private final String simpleClassName;
    private final int tag;
    private final Unmarshaller unmarshaller;

    ActionMap(String simpleClassName, int tag, @NonNull Unmarshaller unmarshaller) {
        this.simpleClassName = simpleClassName;
        this.tag = tag;
        this.unmarshaller = unmarshaller;
    }

    public static ActionMap find(int tag, String simpleClassName) {
        for (ActionMap actionMap : values()) {
            if (actionMap.tag == tag || actionMap.simpleClassName.equals(simpleClassName)) {
                return actionMap;
            }
        }
        return UNKNOWN;
    }

    public int getTag() {
        return tag;
    }

    public Unmarshaller getUnmarshaller() {
        return unmarshaller;
    }
}
