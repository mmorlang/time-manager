

## Introduction/Description
The basic function of the time manager app is to allow the scheduling of time frames where certain notifications are being blocked from selected apps, via user discretion.
The motivation/inspiration for this app was on more of a personal level, where I could see myself, well as others using the app for better time management, allotting screen free time and better focus time by limiting distractions.
Some of the key elements of this app are as following.

- Retains previously connected apps chosen by user.

- Retains previous time frames set by users.

- Works with device notification system to let the user block notifications from specified app/apps during set time frame/time frames.

- Displays notifications summary of items that were blocked, after time frame has ended.

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
* [Time Manager Database](https://github.com/mmorlang/time-manager/blob/master/docs/TimeManagerDatabase.md)

### DDL
* [ddl.md](ddl.md)


### User Instructions
* [User Instructions](user-instructions.md)


#### Cloud Based Services

##### Google SignIn
* [https://developers.google.com/android/reference/com/google/android/gms/auth/api/signin/GoogleSignInApi](https://developers.google.com/android/reference/com/google/android/gms/auth/api/signin/GoogleSignInApi)
* Device will use Google SignIn to be able to sign in/create account with their google credentials.
* The app will be able to function without constantly connecting to Google.

#### Device Based Services
##### Notification Manager
* [https://developer.android.com/reference/android/app/NotificationManager](https://developer.android.com/reference/android/app/NotificationManager)
* App connect to the default notifications system on the device.
* The app will not be able to function without maintaining contact with notification system.

##### AlarmManager
* [https://developer.android.com/reference/android/app/AlarmManager](https://developer.android.com/reference/android/app/AlarmManager)
* The app will use the AlarmManager to keep track of scheduled time frames the user has set to block notifications.
* The app will not be able to function without maintaining contact with notification system.



