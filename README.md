# RemoteViewsReader

Read RemoteViews information with some black magic way.

## Reference

See [RemoteViews](https://android.googlesource.com/platform/frameworks/base/+/refs/heads/master/core/java/android/widget/RemoteViews.java).

## Usage

### Read informations

You can read `RemoteViews` information like this.

```
public class NotificationWatcher extends NotificationListenerService {
  @TargetApi(Build.VERSION_CODES.KITKAT)
  @Override
  public void onNotificationPosted(StatusBarNotification sbn) {
    super.onNotificationPosted(sbn);
    RemoteViews remoteViews = sbn.getNotification().contentView;
    RemoteViewsInfo info = RemoteViewsReader.read(this, remoteViews);

    // you can read informations from `info` object.
  }

  @Override
  public void onNotificationRemoved(StatusBarNotification sbn) {
    super.onNotificationRemoved(sbn);
  }
}
```

`RemoteViewsInfo` contains following informations.

1. ApplicationInfo: An information about an application which have built this `RemoteViews`.
2. Actions: A list of actions the application have committed on `RemoteViews`.
3. Layout Id: An identity of the `RemoteViews` layout.

### Read Actions

The operations for `RemoteViews` are stored as a list of `Action`.
So you can find the action you want like this.

```java

RemoteViewsInfo info = RemoteViewsReader.read(this, remoteViews);
for (RemoteViewsAction action : info.getActions()) {

}

```

RemoteViewsAction is an abstract type for each concrete operations.
We have several types by default, according to AOSP implementation.

- BitmapRefrectionAction  
  Action for `RemoteViews#setImageBitmap()`.
- RefrectionAction  
  Action for various methods declared on `RemoteViews`.
- RefrectionWithoutParamsAction  
  Action for various methods without any parameters declared on `RemoteViews`.
- SetDrawableParamsAction  
  Action for `RemoteViews#setDrawableParameters()`.
- SetEmptyViewAction  
  Action for `RemoteViews#setEmptyView()`.
- SetOnClickFillInIntentAction  
  Action for `RemoteViews#setOnClickFillInIntent()`.
- SetOnClickPendingIntentAction  
  Action for `RemoteViews#setOnClickPendingIntent()`.
- SetPendingIntentTemplateAction  
  Action for `RemoteViews#setPendingIntentTemplate()`.
- SetRemoteViewsAdapterIntentAction  
  Action for `RemoteViews#setRemoteAdapter()`.
- SetRemoteViewsAdapterListAction  
  Action for `RemoteViews#setRemoteAdapter()`.
- TextViewDrawableAction  
  Action for `RemoteViews#setTextViewCompoundDrawables()` and `RemoteViews#setTextViewCompoundDrawablesRelative()`, .
- TextViewDrawableColorFilterAction  
  Action for `RemoteViews#setTextViewCompoundDrawablesRelativeColorFilter()`.
- TextViewSizeAction  
  Action for `RemoteViews#setTextViewTextSize()`.
- ViewGroupAction  
  Action for `RemoteViews#addView()` and `RemoteViews#remoteView()`.
- ViewPaddingAction  
  Action for `RemoteViews#setViewPadding()`.

If you would like to use the specific type of action, you can deal with it like this.

```java

RemoteViewsInfo info = RemoteViewsReader.read(this, remoteViews);
for (RemoteViewsAction action : info.getActions()) {
  if (!(action instanceof BitmapRefrectionAction))
    continue;
  BitmapRefrectionAction concrete = (BitmapRefrectionAction)action;
  Bitmap bmp = concrete.getBitmap();
}

```

## Limitations

Currently this library contains default actions in AOSP.
I've found several types of additional customized actions on some devices, and they are not supported now.

## Download

Via Gradle

```
compile 'com.github.keithyokoma:RemoteViewsReader:1.0.0@aar'
```

## License

Apache License v2

```
Copyright (C) 2015 KeithYokoma, Inc. All rights reserved.

Licensed under the Apache License, Version 2.0 (the "License"); you may not use
this file except in compliance with the License. You may obtain a copy of the
License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed
under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
CONDITIONS OF ANY KIND, either express or implied. See the License for the
specific language governing permissions and limitations under the License.
```
