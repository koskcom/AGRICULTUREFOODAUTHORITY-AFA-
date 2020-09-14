package co.ke.bsl.receivers;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import co.ke.bsl.R;
import co.ke.bsl.services.DataSetupService;
import co.ke.bsl.ui.common.DashboardActivity;



public class DataBroadcastReceiver extends BroadcastReceiver {

    private final int notificationID = 1;
    private static final String CHANNEL_ID = "1000000";

    public DataBroadcastReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        triggerNotification(context);
    }


    private Notification buildNotification(Context context, String title, String content, Intent intent) {

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        return new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.logo)
                .setContentTitle(title)
                .setContentText(content)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .build();
    }

    private void showNotification(Context context, Notification notification) {
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        // notificationId is a unique int for each notification that you must define
        notificationManager.notify((int)System.currentTimeMillis(), notification);
    }

    private void triggerNotification(Context context){
        Intent intent = new Intent(context, DashboardActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        Notification notification = buildNotification(context, " New Inspections Pending", "You have a new inspection pending. please log into the app to view", intent);
        showNotification(context, notification);
    }
}
