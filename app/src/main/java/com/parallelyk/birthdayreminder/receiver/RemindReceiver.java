package com.parallelyk.birthdayreminder.receiver;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.parallelyk.birthdayreminder.R;

/**
 * Created by YK on 2016/5/27.
 */
public class RemindReceiver extends BroadcastReceiver {
    private NotificationManager notificationManager;
    @SuppressLint("NewApi")
    @Override
    public void onReceive(Context context, Intent intent) {
        Notification notification = new Notification.Builder(context).setContentTitle("提醒").
                setContentText("您的好友xx马上要生日啦").setSmallIcon(R.mipmap.ic_launcher).build();


        notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notification);
        Toast.makeText(context, "laile", Toast.LENGTH_SHORT).show();
        //Toast.makeText(context,"laile",Toast.LENGTH_SHORT).show();
    }
}
