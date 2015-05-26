# RemoteViewsReader

Read RemoteViews information with some black magic way.

## Reference

See [RemoteViews](https://android.googlesource.com/platform/frameworks/base/+/refs/heads/master/core/java/android/widget/RemoteViews.java).

## Usage

```
public class NotificationWatcher extends NotificationListenerService {
  @TargetApi(Build.VERSION_CODES.KITKAT)
  @Override
  public void onNotificationPosted(StatusBarNotification sbn) {
    super.onNotificationPosted(sbn);
    RemoteViews remoteViews = sbn.getNotification().contentView;
    RemoteViewsInfo info = RemoteViewsReader.read(remoteViews);

    // you can read informations from `info` object.
  }

  @Override
  public void onNotificationRemoved(StatusBarNotification sbn) {
    super.onNotificationRemoved(sbn);
  }
}
```

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
