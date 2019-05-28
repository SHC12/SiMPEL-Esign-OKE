package com.example.win10.simpelv;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.win10.simpelv.fragment.FragmentHome;
import com.example.win10.simpelv.fragment.FragmentPersonal;
import com.example.win10.simpelv.fragment.FragmentSuratDisposisiMasuk;
import com.example.win10.simpelv.fragment.FragmentSuratKeluar;
import com.example.win10.simpelv.fragment.FragmentSuratMasuk;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private String url_get_token = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/fcm_insert.php";



    String id_user;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment (new FragmentHome());

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bn_main);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home_menu);

      /*  bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home :
                        Toast.makeText(MainActivity.this, "Home clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_surat_masuk :
                        Toast.makeText(MainActivity.this, "Star clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_disposisi_masuk :
                        Toast.makeText(MainActivity.this, "Money clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_disposisi_keluar :
                        Toast.makeText(MainActivity.this, "Star clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_personal :
                        Toast.makeText(MainActivity.this, "Money clicked", Toast.LENGTH_SHORT).show();
                        break;
                }

                return true;
            }
        });*/

        if (getIntent().getBooleanExtra("LOGOUT", false))
        {
            finish();
        }

      id_user = getIntent().getStringExtra("id_user");
       // Toast.makeText(getApplicationContext(), "id user : "+id_user, Toast.LENGTH_SHORT).show();
        getToken();

    }

    public void getToken(){



        SharedPreferences sharedPreferences = getApplication().getSharedPreferences(getString(R.string.FCM_REF), Context.MODE_PRIVATE);
        final String token = sharedPreferences.getString(getString(R.string.FCM_TOKEN), "");
      //Toast.makeText(getApplicationContext(), "Token :" + token, Toast.LENGTH_SHORT).show();

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
                params.put("id_user", id_user);     // sesuaikan dengan $_POST pada PHP
                params.put("fcm_token", token);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
            return true;
        }

        return false;
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {

            case R.id.suratmasuk_menu:
                fragment = new FragmentSuratMasuk();
                break;
            case R.id.disposisimasuk_menu:
                fragment = new FragmentSuratDisposisiMasuk();
                break;
            case R.id.home_menu:
                fragment = new FragmentHome();
                break;
            case R.id.disposisikeluar_menu:
                fragment = new FragmentSuratKeluar();
                break;
            case R.id.personal_menu:
                fragment = new FragmentPersonal();
                break;

        }
        return loadFragment(fragment);
    }
}