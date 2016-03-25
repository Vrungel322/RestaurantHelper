package com.nanddgroup.restauranthelper.Utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;

import com.nanddgroup.restauranthelper.Activities.MainActivity;
import com.nanddgroup.restauranthelper.R;

/**
 * Created by Nikita on 18.03.2016.
 */
public class NotificationHelper {
    private Intent notificationIntent;
    private PendingIntent contentIntent;
    private Notification.Builder builder;
    private Context context;
    private int res;
    private static final int NOTIFY_ID = 101;

    public NotificationHelper(Context context, int res) {
        this.context = context;
        this.res = res;

        notificationIntent = new Intent(context, MainActivity.class);

        notificationIntent.addFlags(Intent.FLAG_ACTIVITY_TASK_ON_HOME);
        contentIntent = PendingIntent.getActivity(context,
                0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder = new Notification.Builder(context);
        builder.setContentIntent(contentIntent)
                .setSmallIcon(res)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(),
                        R.drawable.restaurant_logo))
                .setTicker("New Request!")
                .setContentTitle("Guest need you.")
                .setVibrate(new long[]{100, 500})
                .setLights(Color.RED, 3000, 3000);
    }

    public void show() {
        Notification notification = builder.build();
        notification.flags = Notification.FLAG_SHOW_LIGHTS | Notification.FLAG_AUTO_CANCEL;
        NotificationManager notificationManager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFY_ID, notification);
    }
}
