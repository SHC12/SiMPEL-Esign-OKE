package com.egov.win10.simpelv.fcm;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationCompat;

import android.text.TextUtils;
import android.util.Log;

import com.egov.win10.simpelv.Login;
import com.egov.win10.simpelv.R;
import com.egov.win10.simpelv.SplashScreen;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String CHANNEL_ID = "Bestmarts";
    private static final String CHANNEL_NAME = "Bestmarts";
    private static final String TAG = "MyGcmListenerService";
    private NotificationManager notifManager;
    private NotificationChannel mChannel;

    public MyFirebaseMessagingService() {
    }
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // ...

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d("MyMessage", "From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d("MyMessage", "Message data payload: " + remoteMessage.getData());
        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d("MyMessage", "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }

        if(remoteMessage.getData() != null)
            sendNotificationAPI(remoteMessage);




//        showNotification(remoteMessage.getData().get("message"));
        //createNotificationChannels(remoteMessage.getData().get("message"));
      //  sendNotificationn (remoteMessage.getData().get("message"));
       // sendMyNotification(remoteMessage.getData().get("message"));
       // Notif(remoteMessage.getData().get("message"));
        //sendNotificationnn(remoteMessage.getData().get("message"));
    }

    private void sendNotificationAPI(RemoteMessage remoteMessage) {
        Intent intent = new Intent(this, SplashScreen.class);
        // intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //  PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        Map<String,String> data = remoteMessage.getData();
        String title = data.get("title");
        String content = data.get("content");
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        String NOTIFICATION_CHANNEL_ID = "SiMPEL";

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            @SuppressLint("WrongConstant")
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "SiMPEL Notification", NotificationManager.IMPORTANCE_MAX);

            notificationChannel.setDescription("Channle Notifikasi SiMPEL");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setVibrationPattern(new long[]{0,1000,500,1000});
            notificationChannel.enableVibration(true);

            notificationManager.createNotificationChannel(notificationChannel);
        }

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);


        notificationBuilder.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(androidx.core.R.drawable.notification_icon_background)
                .setTicker("Hearty365")
                .setContentTitle(title)
                .setContentIntent(pendingIntent)
                .setContentText(content)
                .setPriority(NotificationManager.IMPORTANCE_HIGH)
                .setContentInfo("info");

        notificationManager.notify(1, notificationBuilder.build());
    }


    private void sendNotificationnn(String messageBody) {
        Intent notificationIntent = new Intent(this, Login.class);

        notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

        Uri notificationSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationManager notificationManager =
                (NotificationManager) MyFirebaseMessagingService.this.getSystemService(Context.NOTIFICATION_SERVICE);

        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence nameChannel = MyFirebaseMessagingService.this.getString(R.string.app_name);
            String descChannel = MyFirebaseMessagingService.this.getString(R.string.app_name);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(MyFirebaseMessagingService.this.getString(R.string.app_name), nameChannel, importance);
            channel.setDescription(messageBody);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            assert notificationManager != null;
            notificationManager.createNotificationChannel(channel);
        }

        PendingIntent pendingIntent = PendingIntent.getActivity((MyFirebaseMessagingService.this), 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        // Create Notification
        NotificationCompat.Builder notification = new NotificationCompat.Builder(MyFirebaseMessagingService.this, MyFirebaseMessagingService.this.getString(R.string.app_name))
                .setChannelId(MyFirebaseMessagingService.this.getString(R.string.app_name))
                .setContentTitle(TextUtils.isEmpty("SimPEL") ? getString(R.string.app_name) : "SiMPEL")
                .setContentText(messageBody)
                .setTicker(MyFirebaseMessagingService.this.getString(R.string.app_name))
                .setSmallIcon(R.drawable.ic_stat_name)
                .setSound(notificationSound)
                .setLights(Color.RED, 3000, 3000)
                .setVibrate(new long[]{500, 500})
                .setWhen(System.currentTimeMillis())
                .setDefaults(Notification.DEFAULT_SOUND)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent);



        assert notificationManager != null;
        notificationManager.notify(100, notification.build());
    }
    private void sendMyNotification(String message) {
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent = new Intent(this, Login.class);
       // intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
      //  PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            @SuppressLint("WrongConstant")
            NotificationChannel notificationChannel=new NotificationChannel("my_notification","n_channel",NotificationManager.IMPORTANCE_MAX);
            notificationChannel.setDescription(message);
            notificationChannel.setName("SiMPEL");
            notificationManager.createNotificationChannel(notificationChannel);
        }
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_account_box_black_24dp)

                .setContentTitle("SiMPEL")
                .setContentText(message)
                .setAutoCancel(true)

                .setContentIntent(pendingIntent)
                .setDefaults(Notification.DEFAULT_ALL)
                .setPriority(NotificationManager.IMPORTANCE_HIGH)
                .setOnlyAlertOnce(true)
                .setChannelId("my_notification")
                .setColor(Color.parseColor("#3F5996"));
        //.setProgress(100,50,false);
        notificationManager.notify(0, notificationBuilder.build());
    }
    public void sendNotificationn(String messageBody) {

        String channel_name = "simpel";
        String channel_description = "desc";
       if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {


        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel channel = new NotificationChannel(NotificationChannel.DEFAULT_CHANNEL_ID, channel_name, importance);
        channel.setDescription(channel_description);
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
    }

        NotificationCompat.Builder mBuilder =   new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_action_disposisikeluar) // notification icon
                .setContentTitle("Notification!") // title for notification
                .setContentText(messageBody) // message for notification
                .setAutoCancel(true); // clear notification after click
        Intent intent = new Intent(this, Login.class);
        PendingIntent pi = PendingIntent.getActivity(this,0,intent, PendingIntent.FLAG_UPDATE_CURRENT);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mBuilder.setContentIntent(pi);
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(1, mBuilder.build());
    }


    private void showNotification(String message) {


        Intent i = new Intent(this, Login.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,i,PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setAutoCancel(true)
                .setContentTitle("SiMPEL")
                .setContentText(message)
                .setSmallIcon(R.drawable.ic_account_box_black_24dp)
                .setContentIntent(pendingIntent)
                .setDefaults(Notification.DEFAULT_ALL)
                .setPriority(NotificationManager.IMPORTANCE_HIGH);

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        manager.notify(0,builder.build());
    }
    private void sendNotification (String message) {
        Intent intent;
        PendingIntent pendingIntent;
        NotificationCompat.Builder builder;
        if (notifManager == null) {
            notifManager = (NotificationManager) getSystemService

                    (Context.NOTIFICATION_SERVICE);
        }
        builder = new NotificationCompat.Builder(MyFirebaseMessagingService.this);
        intent = new Intent (this, Login.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_HIGH;
            if (mChannel == null) {
                NotificationChannel mChannel = new NotificationChannel

                        ("0", "SiMPEL", importance);
                mChannel.setDescription (message);

                notifManager.createNotificationChannel (mChannel);
            }


            intent.setFlags (Intent.FLAG_ACTIVITY_CLEAR_TOP |

                    Intent.FLAG_ACTIVITY_SINGLE_TOP);
            pendingIntent = PendingIntent.getActivity (this, 0, intent, 0);
            builder.setContentTitle ("SiMPEL")  // flare_icon_30

                    .setSmallIcon (R.drawable.ic_account_box_black_24dp) // required

                    .setContentText (message)  // required

                    .setDefaults (Notification.DEFAULT_ALL)
                    .setAutoCancel (true)

                    .setContentIntent (pendingIntent);

        } else {

            builder = new NotificationCompat.Builder (this);

            intent.setFlags (Intent.FLAG_ACTIVITY_CLEAR_TOP |

                    Intent.FLAG_ACTIVITY_SINGLE_TOP);
            pendingIntent = PendingIntent.getActivity (this, 0, intent, 0);
            builder.setContentTitle ("SiMPEL")
                    .setSmallIcon (R.drawable.ic_account_box_black_24dp) // required

                    .setContentText (message)  // required

                    .setDefaults (Notification.DEFAULT_ALL)
                    .setAutoCancel (true)
                    .setContentIntent (pendingIntent)

                    .setPriority (Notification.PRIORITY_HIGH);
        } // else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        Notification notification = builder.build ();
        notifManager.notify (0, notification);
    }
}
