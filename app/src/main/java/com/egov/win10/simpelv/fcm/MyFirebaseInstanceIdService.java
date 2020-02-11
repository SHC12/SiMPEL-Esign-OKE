package com.egov.win10.simpelv.fcm;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.egov.win10.simpelv.R;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by win10 on 24/04/2019.
 */

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        SharedPreferences sharedPreferences = getApplication().getSharedPreferences(getString(R.string.FCM_REF), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getString(R.string.FCM_TOKEN), refreshedToken);
        editor.commit();
        Log.d("MyToken", "Refreshed token: " + refreshedToken);

    }

}
