package com.marcelolissa.cardview.firebase;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.marcelolissa.cardview.R;
import com.marcelolissa.cardview.activity.MainActivity;
import com.marcelolissa.cardview.activity.MainActivity2;

import java.net.URI;

public class NotificacionService extends FirebaseMessagingService {

    private static final String TAG = "FIREBASE";

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        //super.onMessageReceived(remoteMessage);
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        // Check if message contains a notification payload.
        Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());

        Intent i = new Intent(this, MainActivity2.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, PendingIntent.FLAG_ONE_SHOT);

        Uri sonido = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.huesoblanco)
                        .setContentTitle("Notificación")
                        .setContentText(remoteMessage.getNotification().getBody())
                        .setAutoCancel(true)
                        .setSound(sonido)
                        .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notificationBuilder.build());
    }
}
