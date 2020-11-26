package com.marcelolissa.cardview.firebase;

import android.util.Log;

import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class NotificaciónIdTokenService extends FirebaseInstanceIdService {

    String token;
    private static final String TAG = "FIREBASE_TOKEN";

    @Override
    public void onTokenRefresh() {
        //super.onTokenRefresh();
        token = FirebaseInstanceId.getInstance().getToken();
    }

    public String getToken(){
        token = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, token);
        return token;
    }

    private void enviarTokenDeRegistro (String token){
        Log.d(TAG, token);
    }
}
