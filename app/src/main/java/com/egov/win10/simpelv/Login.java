package com.egov.win10.simpelv;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.messaging.FirebaseMessaging;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    private String url_get_token = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/fcm_insert.php";



    private static final String TAG = "LoginActivity";
    Button btnLogin1;
    ConnectivityManager conMgr;
    EditText editPassword1;
    EditText editUsername1;
    String idUser;
    String instansiId;
    String instansiUser;
    String namaLengkap;
    ProgressDialog pDialog;
    Boolean session = Boolean.valueOf(false);
    SharedPreferences sharedpreferences;
    int success;
    String tag_json_obj = "json_obj_req";
    String usernameUser;
    private ProgressDialog progressDialog;
    public static final String PREFS_NAME = "MyPrefsFile";

    TextInputLayout valUsername, valPassword;
    String id_username, password, id_user;

    int autoSave;




    EditText txtEmail, txtPassword;
    Button btnLogin;

    public static String URL = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/model_login.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.M&& checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[] {android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1001);
        }
/*
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("MyNotification", "MyNotification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        FirebaseMessaging.getInstance().subscribeToTopic().;*/


        SharedPreferences sharedPreferences = getApplication().getSharedPreferences(getString(R.string.FCM_REF), Context.MODE_PRIVATE);
        final String token = sharedPreferences.getString(getString(R.string.FCM_TOKEN), "");


      //  Toast.makeText(Login.this, "Token : " + token, Toast.LENGTH_SHORT).show();
        txtEmail = (EditText) findViewById(R.id.et_email);
        txtPassword = (EditText) findViewById(R.id.et_password);
        btnLogin = (Button)findViewById(R.id.btn_login);


        progressDialog = new ProgressDialog(Login.this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id_username = txtEmail.getText().toString().trim();
                password = txtPassword.getText().toString().trim();

                progressDialog.setMessage("Mohon Tunggu....");
                progressDialog.show();
                if(id_username.isEmpty()){
                    txtEmail.setError("Username tidak boleh kosong !");
                }else if(password.isEmpty()){
                    txtPassword.setError("Password tidak boleh kosong !");
                }else {

                    auth_user(id_username, password);
                }


            }
        });

    }

    public void getToken(){



        SharedPreferences sharedPreferences = getApplication().getSharedPreferences(getString(R.string.FCM_REF), Context.MODE_PRIVATE);
        final String token = sharedPreferences.getString(getString(R.string.FCM_TOKEN), "");

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_get_token, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("id_user", id_username);     // sesuaikan dengan $_POST pada PHP
                params.put("fcm_token", token);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    public void auth_user(final String id_username, final String password) {


        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    progressDialog.dismiss();
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
//                    JSONArray jsonArray = jsonObject.getJSONArray("response");
                    if (success.equals("1")) {
                        for (int i = 0; i < 10; i++) {
//                            JSONObject jsonObject1 = jsonObject.getJSONObject();

                            String nama_user = jsonObject.getString("nama_lengkap").trim();
                            String nama_instansi = jsonObject.getString("nama_instansi").trim();
                            id_user = jsonObject.getString("id_user").trim();
                            String id_instansi = jsonObject.getString("id_instansi").trim();
                            String id_groups = jsonObject.getString("id_groups").trim();
                            String nama_lengkap = jsonObject.getString("nama_lengkap").trim();
                            String username = jsonObject.getString("username").trim();
                            String message = jsonObject.getString("message");
                            String id_kategori = jsonObject.getString("id_kategori").trim();
                            String id_jenjang_jabatan = jsonObject.getString("id_jenjang_jabatan");




                            SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = settings.edit();
                            editor.putString("id_user", id_user);
                            editor.putString("nama_lengkap", nama_lengkap);
                            editor.putString("id_instansi", id_instansi);
                            editor.putString("id_jenjang_jabatan", id_jenjang_jabatan);
                            editor.putString("id_groups", id_groups);
                            editor.putString("id_kategori", id_kategori);
                            editor.putString("nama_instansi", nama_instansi);
                            editor.putString("username", username);
                            editor.putString("name", nama_user);
                            editor.putString("message", message);
                            editor.commit();


                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            intent.putExtra("username", nama_user);
                            intent.putExtra("message", message);

                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("id_user", id_user);
                            intent.putExtra("id_groups", id_groups);
                            intent.putExtra("id_user", id_user);

                            startActivity(intent);
                        }
                    } else {
                        Toast.makeText(Login.this,
                                "ID. User dan Password tidak ditemukan! ",
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(Login.this,
                            "Error login : " + e.toString(),
                            Toast.LENGTH_SHORT)
                            .show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Login.this,
                        "Error login : " + error.toString(),
                        Toast.LENGTH_SHORT)
                        .show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username", id_username);     // sesuaikan dengan $_POST pada PHP
                params.put("password", password);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1001:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Ijin DIterima!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Ijin Ditolak!", Toast.LENGTH_SHORT).show();
                    finish();
                }
        }
    }
}
