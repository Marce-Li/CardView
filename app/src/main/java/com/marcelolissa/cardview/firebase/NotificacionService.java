package com.marcelolissa.cardview.firebase;

import android.app.Notification;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.NotificationCompat.WearableExtender;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.marcelolissa.cardview.R;
import com.marcelolissa.cardview.activity.MainActivity2;


public class NotificacionService extends FirebaseMessagingService {

    private static final String TAG = "FIREBASE";
    public static final int NOTIFICACION_ID = 001;

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        //super.onMessageReceived(remoteMessage);
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        // Check if message contains a notification payload.
        Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());

        Intent i = new Intent(this, MainActivity2.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, PendingIntent.FLAG_ONE_SHOT);

        Uri sonido = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Action action = new NotificationCompat.Action.Builder(R.drawable.ic_full_huesoblanco,
                getString(R.string.Notificaicon), pendingIntent)
                .build();

        NotificationCompat.WearableExtender wearableExtender = new NotificationCompat.WearableExtender();

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.huesoblanco)
                .setContentTitle(remoteMessage.getNotification().getTitle())
                .setContentText(remoteMessage.getNotification().getBody())
                .setSound(sonido)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .extend(wearableExtender.addAction(action))
                //.addAction(R.drawable.ic_full_huesoblanco,getString(R.string.Notificaicon), pendingIntent)
                ;

        NotificationManagerCompat notificationManagerCompat =
                NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(NOTIFICACION_ID, notificationBuilder.build());

    }
}
