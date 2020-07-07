

## Introduction
This app is to help manage your electronic notifications, by connecting to your device scheduling and notification systems and blocking certain app notifications you've selected.
Resulting in your undivided time to be used in a more relaxed, organized, purposeful or productive way of your choosing, 
by the limitation of those screen time distractions.


- Retains previously connected apps.

- Retains previous time frames set by users.

- Works with device notification system to let the user block notifications from specified app/apps during set time frame/time frames.

- Displays notifications summary of items that were blocked during time frame after it has ended.

#### Types Of Users
###### [User Stories](user-stories.md)

#### Design documentation


###### [Wireframe diagram](wireframe.md)

###### [ERD diagram](erd.md)


### Entities

##### [Notification Entity](https://github.com/mmorlang/time-manager/blob/master/app/src/main/java/edu/cnm/deepdive/timemanager/model/entity/Notification.java)
##### [Timeframe Entity](https://github.com/mmorlang/time-manager/blob/master/app/src/main/java/edu/cnm/deepdive/timemanager/model/entity/Timeframe.java)
##### [Connected App Entity](https://github.com/mmorlang/time-manager/blob/master/app/src/main/java/edu/cnm/deepdive/timemanager/model/entity/ConnectedApp.java)

### Daos

##### [Notification Dao](https://github.com/mmorlang/time-manager/blob/master/app/src/main/java/edu/cnm/deepdive/timemanager/dao/NotificationDao.java)
##### [Timeframe Dao](https://github.com/mmorlang/time-manager/blob/master/app/src/main/java/edu/cnm/deepdive/timemanager/dao/TimeframeDao.java)
##### [Connected App Dao](https://github.com/mmorlang/time-manager/blob/master/app/src/main/java/edu/cnm/deepdive/timemanager/dao/ConnectedAppDao.java)

### Repositories

##### [Notification Repository](https://github.com/mmorlang/time-manager/blob/master/app/src/main/java/edu/cnm/deepdive/timemanager/service/NotificationRepository.java)
##### [TimeFrame Repository](https://github.com/mmorlang/time-manager/blob/master/app/src/main/java/edu/cnm/deepdive/timemanager/service/TimeframeRepository.java)
##### [Connected App Repository](https://github.com/mmorlang/time-manager/blob/master/app/src/main/java/edu/cnm/deepdive/timemanager/service/ConnectedAppRepository.java)

### Databases
* [Time Manager Database](TimeManagerDatabase.md)

### DDL
* [Data Definition Language](ddl.md)


#### Cloud Based Services

##### Google OpenID API
* [https://www.programmableweb.com/api/google-openid](https://www.programmableweb.com/api/google-openid)
* Device will use Google OpenID API to be able to sign in/create account with their google credentials.
* The app will be able to function without constantly connecting to the Google OpenID API.

#### Device Based Services
##### Notification Manager
* [https://developer.android.com/reference/android/app/NotificationManager](https://developer.android.com/reference/android/app/NotificationManager)
* App connect to the default notifications system on the device.
* The app will not be able to function without maintaining contact with notification system.

##### AlarmManager
* [https://developer.android.com/reference/android/app/AlarmManager](https://developer.android.com/reference/android/app/AlarmManager)
* The app will use the AlarmManager to keep track of scheduled time frames the user has set to block notifications.
* The app will not be able to function without maintaining contact with notification system.



