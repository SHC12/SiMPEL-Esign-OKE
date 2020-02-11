package com.egov.win10.simpelv.TU;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.egov.win10.simpelv.MainActivity;
import com.egov.win10.simpelv.R;
import com.sdsmdg.tastytoast.TastyToast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DetailSuratMasukTU extends AppCompatActivity {


    private String URL_AGENDA = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/cek_no_agenda_masuk_terakhir.php?id_instansi=";
    String URL_CEK_NO_AGENDA;
    String id_instansi;
    public static final String PREFS_NAME = "MyPrefsFile";

    private String url_notif_penerima_surat_masuk = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/get_penerima_surat_masuk_tu.php?id_surat=";
    String notif_penerima_surat_masuk = "";
    private String URL_TERIMA_SURAT = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/kirim_surat_masuk_tu.php";



    private String URL_VALIDASI = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/cek_validasi_no_agenda_masuk.php?no_agenda=";
    private String VALIDASI_AGENDA = "";

    String no_agenda;
    String tgl_surat_masuk;


    public static final String url_fcm = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/push_fcm_surat_masuk_tu.php?id_user=";
    String id_user_notif;

    private String URLL = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/model_penerima_tanda_tangan.php?id_surat=";
    private String URL_TTD = "";

    private String URLLL = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/menu_penerima_tembusan.php?id_surat=";
    private String URL_TEMBUSAN = "";

    String id_surat;
    String username;

    String ip = "192.168.2.22";

    TextView atas_nama, penerima, tembusan, tgl_surat, nomor_surat, jenis_surat, nomor_agenda_masuk_terakhir;
    Button TerimaSurat;
    EditText editNomorAgenda;
    private ProgressDialog progressDialog;
    String no_agenda_terakhir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_surat_masuk_tu);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        id_instansi = settings.getString("id_instansi", "");
        username = settings.getString("username", "");
        id_surat = getIntent().getStringExtra("id_surat");



        notif_penerima_surat_masuk = url_notif_penerima_surat_masuk +id_surat+"&id_instansi="+id_instansi;



        editNomorAgenda = (EditText) findViewById(R.id.editNoAgendaMasuk);

        atas_nama = (TextView) findViewById(R.id.tv_hasil_atas_nama_SM_TU);
        penerima = (TextView) findViewById(R.id.tv_hasil_penerima_SM_TU);
        tembusan = (TextView) findViewById(R.id.tv_hasil_tembusan_SM_TU);
        tgl_surat = (TextView) findViewById(R.id.tv_hasil_tanggal_surat_SM_TU);
        nomor_surat = (TextView) findViewById(R.id.tv_hasil_nomor_surat_SM_TU);
        jenis_surat = (TextView) findViewById(R.id.tv_hasil_perihal_SM_TU);
        nomor_agenda_masuk_terakhir = (TextView) findViewById(R.id.tv_hasil_nomor_agenda_masuk_terakhir_SM_TU);


        atas_nama.setText(getIntent().getStringExtra("pengirim"));
        tgl_surat.setText(getIntent().getStringExtra("tanggal_surat_masuk"));
        nomor_surat.setText(getIntent().getStringExtra("no_surat_masuk"));
        jenis_surat.setText(getIntent().getStringExtra("perihal_surat"));

        tgl_surat_masuk = getIntent().getStringExtra("tanggal_surat");

        URL_CEK_NO_AGENDA = URL_AGENDA + id_instansi;
        URL_TTD = URLL + id_surat;
        URL_TEMBUSAN = URLLL + id_surat;

       // Toast.makeText(this, ""+notif_penerima_surat_masuk, Toast.LENGTH_SHORT).show();
        TerimaSurat = (Button) findViewById(R.id.btnTerimaSuratSMTU);
        TerimaSurat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                no_agenda = editNomorAgenda.getText().toString();
                VALIDASI_AGENDA = URL_VALIDASI + no_agenda +"&id_instansi="+id_instansi;
                id_user_penerima_SM();
                validasiCekAgenda();

            }
        });



        AmbilDataCekNoAgenda();
        PenerimaTembusan();
        AmbilTujuan();


    }

    public void id_user_penerima_SM(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, notif_penerima_surat_masuk, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);

                    JSONArray jsonArray = object.getJSONArray("result");


                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        id_user_notif = jsonObject.getString("id_user");
                        notifikasi(id_user_notif);
                        Toast.makeText(DetailSuratMasukTU.this, "id_penerima"+id_user_notif, Toast.LENGTH_SHORT).show();

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(this).add(stringRequest);

    }

    public void notifikasi(final String id_user_fcm){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_fcm, new Response.Listener<String>() {
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
                params.put("id_user", id_user_fcm);     // sesuaikan dengan $_POST pada PHP

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    public void TerimaSurat(final String no_agenda_masukA, final String id_suratA, final String tgl_surat_masukA, final String create_ipA, final String mod_byA, final String mod_dateA, final String mod_ipA, final String id_instansiA){
        progressDialog = new ProgressDialog(DetailSuratMasukTU.this);
        progressDialog.setMessage("Mohon Tunggu....");
        progressDialog.setCancelable(false);
        progressDialog.show();
        StringRequest  stringRequest = new StringRequest(Request.Method.POST, URL_TERIMA_SURAT, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    progressDialog.dismiss();
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("code");
//                    JSONArray jsonArray = jsonObject.getJSONArray("response");
                    Date c = Calendar.getInstance().getTime();
//                System.out.println("Current time => " + c);

                    SimpleDateFormat df = new SimpleDateFormat("y-MM-dd HH:mm:ss");
                    String formattedDate = df.format(c);

                    if (success.equals("1")) {

                    }else if(success.equals("0")){

                    }
                } catch (JSONException e) {
                    e.printStackTrace();

                    Toast.makeText(DetailSuratMasukTU.this,
                            "Error  : " + e.toString(),
                            Toast.LENGTH_SHORT)
                            .show();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("no_agenda_masuk", no_agenda_masukA);
                params.put("id_surat", id_suratA);

                params.put("create_ip", create_ipA);
                params.put("mod_by", mod_byA);
                params.put("mod_date", mod_dateA);
                params.put("mod_ip", mod_ipA);
                params.put("tgl_surat_masuk", tgl_surat_masukA);
                params.put("id_instansi", id_instansiA);




                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }

    public void validasiCekAgenda(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, VALIDASI_AGENDA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);

                    JSONArray jsonArray = object.getJSONArray("result");


                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String status = jsonObject.getString("status");
                        if(status.equals("null")){
                            //Toast.makeText(DetailSuratMasukTU.this, "Sukses", Toast.LENGTH_SHORT).show();
                            Date c = Calendar.getInstance().getTime();


                            SimpleDateFormat df = new SimpleDateFormat("y-MM-dd HH:mm:ss");
                            String formattedDate = df.format(c);

                            TerimaSurat(no_agenda, id_surat, tgl_surat_masuk, ip, username, formattedDate, ip, id_instansi);
                            TastyToast.makeText(getApplicationContext(), "Sukses", Toast.LENGTH_LONG, TastyToast.SUCCESS).show();
                            Intent in = new Intent(DetailSuratMasukTU.this, MainActivity.class);
                            startActivity(in);
                        }else {
                            Toast.makeText(DetailSuratMasukTU.this, "Nomor agenda masuk sudah digunakan sebelumnya", Toast.LENGTH_SHORT).show();

                        }
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(this).add(stringRequest);


    }
    public void PenerimaTembusan(){


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL_TEMBUSAN, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {



                if (response.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < response.length(); i++) {
                        try {

                            JSONObject jsonObject = response.getJSONObject(i);


                            String namaTu = jsonObject.getString("nam_tujuan");
                            sb.append(namaTu + "\n");

                            //tvTujuan.setText(namaTu);
                            tembusan.setText(sb.toString());






/*
                            Intent intent = new Intent(getActivity().getBaseContext(), DetailDisposisiMasuk.class);
                            intent.putExtra("id_surat", id_surat);
                            getActivity().startActivity(intent);

*/







                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }else{

                }



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(this).add(jsonArrayRequest);
    }

    public void AmbilTujuan(){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL_TTD, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {



                if (response.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < response.length(); i++) {
                        try {

                            JSONObject jsonObject = response.getJSONObject(i);


                            String namaTu = jsonObject.getString("nam_tujuan");
                            sb.append(namaTu + "\n");

                            //tvTujuan.setText(namaTu);
                            penerima.setText(sb.toString());






/*
                            Intent intent = new Intent(getActivity().getBaseContext(), DetailDisposisiMasuk.class);
                            intent.putExtra("id_surat", id_surat);
                            getActivity().startActivity(intent);

*/







                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }else{

                }



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(this).add(jsonArrayRequest);
    }

    public void AmbilDataCekNoAgenda(){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_CEK_NO_AGENDA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);

                    JSONArray jsonArray = object.getJSONArray("result");


                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String no_agenda_terakhir = jsonObject.getString("no_agenda_masuk");
                        if(no_agenda_terakhir.equals("null")){
                            nomor_agenda_masuk_terakhir.setText("");
                        }else {
                            nomor_agenda_masuk_terakhir.setText(no_agenda_terakhir);

                        }
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(this).add(stringRequest);
    }
}
