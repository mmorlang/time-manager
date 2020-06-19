# Time Manager

## Introduction
The purpose of this app is to help manage your electronic notifications, whether its to 
use your free time in a more relaxed, organized, purposeful or productive way, 
by the limitation of screen time distractions.

- Works with device notification system to let the user block notifications during set time frames.

- Retains previous time frames set by users.

- Retains previously connected apps.

- Displays notifications summary of items that were blocked during time frame after it is over.




#### Design documentation


###### [User Stories](user-stories.md)

###### [Wireframe diagram](wireframe.md)

###### [ERD diagram](erd.md)


#### Cloud Based Services

#####Google OpenID API
* https://www.programmableweb.com/api/google-openid
* Device will use Google OpenID API to be able to sign in/create account with their google credentials.
* The app will be able to function without constantly connecting to the Google OpenID API.

##Device Based Services
###Notification Manager
* https://developer.android.com/reference/android/app/NotificationManager
* App connect to the default notifications system on the device.
* The app will not be able to function without maintaining contact with notification system.

###AlarmManager
* https://developer.android.com/reference/android/app/AlarmManager
* The app will use the AlarmManager to keep track of scheduled time frames the user has set to block notifications.
* The app will not be able to function without maintaining contact with notification system.



