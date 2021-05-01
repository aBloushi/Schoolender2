package com.example.schoo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.schoolender.R;

public class ReminderBroadcast extends BroadcastReceiver {
    public static String fols = "";
    @Override
    public void onReceive(Context context, Intent intent){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context ,"notifyLemubit")
                .setSmallIcon(R.drawable.alarm)
                .setContentTitle("Schooldender")
                .setContentText("Don't forget You have a " + fols)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);


        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        notificationManager.notify(20,builder.build());
    }
}
