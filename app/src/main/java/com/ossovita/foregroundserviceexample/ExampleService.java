package com.ossovita.foregroundserviceexample;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class ExampleService extends Service {

    private static final String CHANNEL_ID = "";

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
       String input = intent.getStringExtra("inputExtra");
       Intent notificationIntent = new Intent(this,MainActivity.class);
       PendingIntent pendingIntent = PendingIntent.getActivity(this,0,notificationIntent,0);


       Notification notification = new NotificationCompat.Builder(this,CHANNEL_ID)
               .setContentTitle("Belediye Calisiyor")
               .setContentText(input)
               .setSmallIcon(R.drawable.ic_android)
               .setContentIntent(pendingIntent)
               .build();
       //startForeground(1,notification);
       //stopSelf();
        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
