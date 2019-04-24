package com.example.win10.simpelv;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.clans.fab.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DetailSuratMasuk extends AppCompatActivity {
    public static final String PREFS_NAME = "MyPrefsFile";

    private String Url = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/model_detail_surat_masuk.php?token_surat=";
    private String api_pdf_surat_masuk = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/get_file_pdf_disposisi_masuk.php?id_surat=";
    public String url_pdf_surat_masuk = "";
    String Tag = "DetailSuratMasuk";
    public String id_suratt = "";
    String URL_FILE = "";
    String nama_surat = "";
    String token_surat_url = "";
    String url_detail_surat_masuk = "";
    String no_surat_manual = "";
    String perihalSurat = "";
    TextView hasilNomorAgendaSM, hasilTanggalPenerimaanSM, hasilPengirimSM, hasilStatusSM, hasilNomorSuratSM, hasilTanggalSuratSM, hasilTujuanSM, hasilJudulSuratSM, hasiljenisNotaSM;
    Button btnBukaSuratSM;

    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_surat_masuk);


        hasilNomorAgendaSM = (TextView)findViewById(R.id.tv_hasil_nomor_agenda_surat_masuk_SM);
        hasilTanggalPenerimaanSM = (TextView)findViewById(R.id.tv_hasil_tanggal_penerimaan_surat_SM);
        hasilPengirimSM = (TextView)findViewById(R.id.tv_hasil_pengirim_SM);
        hasilNomorSuratSM = (TextView)findViewById(R.id.tv_hasil_nomor_surat_SM);
        hasilTanggalSuratSM = (TextView)findViewById(R.id.tv_hasil_tanggal_surat_SM);
        hasilTujuanSM = (TextView)findViewById(R.id.tv_hasil_tujuan_SM);
        hasilJudulSuratSM = (TextView)findViewById(R.id.tv_hasil_judul_surat_SM);
        hasiljenisNotaSM = (TextView)findViewById(R.id.tv_hasil_jenis_nota_dinas_SM);

        btnBukaSuratSM = (Button)findViewById(R.id.btnBukaSuratSM);
        btnBukaSuratSM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DownloadFile().execute(URL_FILE, nama_surat);
            }
        });
        token_surat_url = getIntent().getStringExtra("token_surat");
        String ts = no_surat_manual;
        no_surat_manual = getIntent().getStringExtra("no_surat_manual");


        perihalSurat = getIntent().getStringExtra("perihal_surat");
        hasiljenisNotaSM.setText(perihalSurat);

        id_suratt = getIntent().getStringExtra("id_surat");
        url_pdf_surat_masuk = api_pdf_surat_masuk + id_suratt;


        url_detail_surat_masuk = Url + token_surat_url;

        hasilNomorSuratSM.setText(ts);
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String n = settings.getString("name", "defaultName");
        hasilTujuanSM.setText(n);
        Toast.makeText(getApplicationContext(), "No Surat : "+ no_surat_manual, Toast.LENGTH_SHORT).show();


        AmbilDataSuratMasuk();
        ambilPdfSuratMasuk();


    }
    public void AmbilDataSuratMasuk(){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_detail_surat_masuk, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);

                    JSONArray jsonArray = object.getJSONArray("result");
                    for (int i = 0; i<jsonArray.length(); i++){

                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String id_surat = jsonObject.getString("id_surat");
                        String token_surat = jsonObject.getString("token_surat");
                        String nama_naskah = jsonObject.getString("nama_naskah");
                        String no_surat_manuall = jsonObject.getString("no_surat_manual");
                        String tgl_surat = jsonObject.getString("tgl_surat");
                        String tgl_surat_masuk = jsonObject.getString("tgl_surat_masuk");
                        String nama_pengirim = jsonObject.getString("nama_pengirim");

                        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putString("namapengirim", nama_pengirim);
                        editor.commit();



                        hasilTanggalSuratSM.setText(tgl_surat);
                        hasilNomorSuratSM.setText(no_surat_manual);
                        hasilPengirimSM.setText(nama_pengirim);
                        //     hasilNomorSuratSM.setText(no_surat_manual);



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
    public void ambilPdfSuratMasuk(){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_pdf_surat_masuk, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);

                    JSONArray jsonArray = object.getJSONArray("response");
                    for (int i = 0; i<jsonArray.length(); i++){

                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        //id_suratt = jsonObject.getString("id_surat");
                        String judul_surat = jsonObject.getString("surat_name");
                        String link_surat = jsonObject.getString("surat_link");



                        URL_FILE = link_surat;
                        nama_surat = judul_surat;
                        hasilJudulSuratSM.setText(judul_surat);

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



    private class DownloadFile extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... strings) {
            String fileUrl = strings[0];   // -> http://maven.apache.org/maven-1.x/maven.pdf
            String fileName = strings[1];  // -> maven.pdf
            String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
            File folder = new File(extStorageDirectory, "SiMPEL/Surat Masuk");
            folder.mkdir();

            File pdfFile = new File(folder, fileName);

            try{
                pdfFile.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
            DownloadTask.downloadFile(fileUrl, pdfFile);
            return null;
        }
    }



}
