package com.egov.win10.simpelv;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.egov.win10.simpelv.TU.ListAgendaKeluar;
import com.egov.win10.simpelv.TU.ListAgendaMasuk;
import com.egov.win10.simpelv.TU.ListSuratMasukTU;
import com.egov.win10.simpelv.list.ListDisposisiKeluar;
import com.egov.win10.simpelv.list.ListDisposisiMasuk;
import com.egov.win10.simpelv.list.ListKonsep;
import com.egov.win10.simpelv.list.ListSuratKeluar;
import com.egov.win10.simpelv.list.ListSuratMasuk;
import com.egov.win10.simpelv.list.ListTandaTanganSurat;
import com.egov.win10.simpelv.list.ListTembusan;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private String url_get_token = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/fcm_insert.php";



    String gcm_instance = " ";
    String name = " ";
    String created_at = " ";

    public static final String PREFS_NAME = "MyPrefsFile";


    String id_user;


    CardView cvSuratMasuk;
    CardView cvDisposisiMasuk;
    CardView cvTembusan;
    CardView cvAgendaMasuk;
    CardView cvAgendaKeluar;
    CardView cvDisposisiTembusan;
    CardView cvSuratKeluar;
    CardView cvSuratKeluarTU;
    CardView cvDisposisiKeluar;
    CardView cvKonsep;
    CardView cvTandaTangan;

    String id_groups;
    String id_kategori;

    TextView pesan;


    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);






        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences mSettings = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        String cookieName = settings.getString("message", "default");
        id_kategori = settings.getString("id_kategori", "default");
        id_groups = settings.getString("id_groups", "default");



        if(id_kategori.equals("4") && id_groups.equals("4") ){
            setContentView(R.layout.activity_main_tu);
            pesan = (TextView)findViewById(R.id.tvNama);
            pesan.setText(cookieName);

            cvSuratMasuk = (CardView)findViewById(R.id.SuratMasukIdTU);
            cvSuratMasuk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(MainActivity.this, ListSuratMasukTU.class);
                    startActivity(in);
                }
            });

            cvAgendaMasuk = (CardView) findViewById(R.id.AgendaMasukId);
            cvAgendaMasuk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(MainActivity.this, ListAgendaMasuk.class);
                    startActivity(in);
                }
            });


            cvAgendaKeluar = (CardView) findViewById(R.id.AgendaKeluarId);
            cvAgendaKeluar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(MainActivity.this, ListAgendaKeluar.class);
                    startActivity(in);
                }
            });

            cvSuratKeluarTU = (CardView) findViewById(R.id.SuratKeluarIdTU);
            cvSuratKeluarTU.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(MainActivity.this, ListSuratKeluar.class);
                    startActivity(in);
                }
            });
            id_user = settings.getString("id_user", "");




            getToken();





        }else {
            setContentView(R.layout.activity_main);
            pesan = (TextView)findViewById(R.id.tvNama);
            pesan.setText(cookieName);

            cvSuratMasuk = (CardView)findViewById(R.id.SuratMasukId);
            cvSuratMasuk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(MainActivity.this, ListSuratMasuk.class);
                    startActivity(in);
                }
            });

            cvDisposisiMasuk = (CardView)findViewById(R.id.DisposisiMasukId);
            cvDisposisiMasuk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(MainActivity.this, ListDisposisiMasuk.class);
                    startActivity(in);
                }
            });

            cvKonsep = (CardView)findViewById(R.id.KonsepId);
            cvKonsep.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(MainActivity.this, ListKonsep.class);
                    startActivity(in);
                }
            });

            cvTandaTangan = (CardView) findViewById(R.id.TandaTanganId);
            cvTandaTangan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(MainActivity.this, ListTandaTanganSurat.class);
                    startActivity(in);
                }
            });

            cvDisposisiKeluar = (CardView) findViewById(R.id.DisposisiKeluarId);
            cvDisposisiKeluar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(MainActivity.this, ListDisposisiKeluar.class);
                    startActivity(in);
                }
            });




            cvSuratKeluar = (CardView) findViewById(R.id.SuratKeluarId);
            cvSuratKeluar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(MainActivity.this, ListSuratKeluar.class);
                    startActivity(in);
                }
            });

            cvTembusan = (CardView) findViewById(R.id.TembusanId);
            cvTembusan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(MainActivity.this, ListTembusan.class);
                    startActivity(in);
                }
            });



            String cekLogin = "";

            if(cekLogin.equals("1")){
                Intent in = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(in);
            }else if(cekLogin.equals("2")){
                Intent in = new Intent(getApplicationContext(), Login.class);
                startActivity(in);
            }

            id_user = settings.getString("id_user", "");


            getToken();



        }





    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Ingin keluar dari aplikasi SiMPEL?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        moveTaskToBack(true);
                        MainActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    public void getToken(){




        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.FCM_REF), Context.MODE_PRIVATE);
        final String token = sharedPreferences.getString(getString(R.string.FCM_TOKEN), "");
      //Toast.makeText(getApplicationContext(), "Token :" + token, Toast.LENGTH_SHORT).show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_get_token, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
               // Toast.makeText(MainActivity.this, "OKE", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, ""+error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("id_user", id_user);     // sesuaikan dengan $_POST pada PHP
                params.put("gcm_regid", token);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
/*
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
            /*case R.id.disposisikeluar_menu:
                fragment = new FragmentSuratKeluar();
                break;
            case R.id.konsep_menu:
                fragment = new FragmentKonsep();
                break;
            case R.id.personal_menu:
                fragment = new FragmentPersonal();
                break;

        }
        return loadFragment(fragment);
    }*/
}