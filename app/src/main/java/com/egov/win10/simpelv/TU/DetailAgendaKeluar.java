package com.egov.win10.simpelv.TU;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.StrictMode;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.egov.win10.simpelv.DetailSuratKeluar;
import com.egov.win10.simpelv.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class DetailAgendaKeluar extends AppCompatActivity {


    private String URL = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/model_detail_surat_keluar.php?token_surat=";
    private String URL_DETAIL_SURAT_KELUAR = "";

    private String api_pdf_SK = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/get_file_pdf_disposisi_masuk.php?id_surat=";
    public String url_pdf_SK = "";



    private String URLL = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/model_penerima_tanda_tangan.php?id_surat=";
    private String URL_TTD = "";


    String Tag = "SK";
    String URL_FILE = "";
    String nama_surat = "";


    String token_surat, no_surat_keluar, tgl_suratt, penerima, pengirimm, judul_suratt, nota_dinas, no_agenda, id_surat, perihall;

    TextView no_agenda_surat_keluar, no_surat, tujuan, tgl_penerimaan, tgl_surat, pengirim, jenis_nota_dinas, judul_surat, perihal;

    Button btnBukaSurat;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_agenda_keluar);

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        progressDialog = new ProgressDialog(DetailAgendaKeluar.this);
        progressDialog.setMessage("Loading....");
        progressDialog.setCancelable(false);
        progressDialog.show();

        no_agenda_surat_keluar = (TextView) findViewById(R.id.tv_hasil_nomor_agenda_surat_keluar3_AK);
        no_surat = (TextView) findViewById(R.id.tv_hasil_nomor_surat_keluar3_AK);
        tujuan = (TextView) findViewById(R.id.tv_hasil_tujuan_surat_keluar3_AK);
        tgl_surat = (TextView) findViewById(R.id.tv_hasil_tanggal_surat_keluar3_AK);
        pengirim = (TextView) findViewById(R.id.tv_hasil_pengirim_surat_keluar3_AK);
        jenis_nota_dinas = (TextView) findViewById(R.id.tv_hasil_jenis_nota_dinas_surat_keluar3_AK);
        judul_surat = (TextView) findViewById(R.id.tv_hasil_judul_surat_keluar3_AK);
        perihal = (TextView) findViewById(R.id.tv_hasil_perihal_surat_keluar3_AK);

        btnBukaSurat = (Button) findViewById(R.id.btnBukaSuratSuratKeluar_AK);
        btnBukaSurat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPdf(nama_surat);
            }
        });

        token_surat = getIntent().getStringExtra("token_surat");
        no_surat_keluar = getIntent().getStringExtra("no_surat_masuk");
        tgl_suratt = getIntent().getStringExtra("tanggal_surat");
        pengirimm = getIntent().getStringExtra("atas_nama");
        penerima = getIntent().getStringExtra("penerima_surat");
        judul_suratt = getIntent().getStringExtra("judul_surat");
        nota_dinas = getIntent().getStringExtra("nama_naskah");
        no_agenda = getIntent().getStringExtra("no_agenda_keluar");
        id_surat = getIntent().getStringExtra("id_surat");
        perihall = getIntent().getStringExtra("perihal");

        perihal.setText(perihall);

        URL_DETAIL_SURAT_KELUAR = URL + token_surat;



        no_surat.setText(no_surat_keluar);

        pengirim.setText(pengirimm);
        tgl_surat.setText(tgl_suratt);
        jenis_nota_dinas.setText(nota_dinas);
        judul_surat.setText(judul_suratt);
        no_agenda_surat_keluar.setText(no_agenda);

        url_pdf_SK = api_pdf_SK + id_surat;
        URL_TTD = URLL + id_surat;

        getPdf();

        AmbilTujuan();

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
                            tujuan.setText(sb.toString());






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


    public void getPdf(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_pdf_SK, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    Log.d(Tag, object.getString("response"));
                    JSONArray jsonArray = object.getJSONArray("response");


                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String surat_name = jsonObject.getString("surat_name");
                        String surat_link = jsonObject.getString("surat_link");

                        URL_FILE = surat_link;
                        nama_surat = surat_name;



                        // Toast.makeText(DetailKonsep.this, ""+URL_FILE, Toast.LENGTH_SHORT).show();
                        new Thread(new Runnable() {
                            public void run() {
                                DownloadFiles();
                                progressDialog.dismiss();

                            }
                        }).start();


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

    public void DownloadFiles() {

        try {
            java.net.URL u = new URL(URL_FILE);
            InputStream is = u.openStream();

            DataInputStream dis = new DataInputStream(is);

            byte[] buffer = new byte[1024];
            int length;

            FileOutputStream fos = new FileOutputStream(new File(Environment.getExternalStorageDirectory() + "/" + nama_surat));

            while ((length = dis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }




        } catch (MalformedURLException mue) {
            Log.e("SYNC getUpdate", "malformed url error", mue);
        } catch (IOException ioe) {
            Log.e("SYNC getUpdate", "io error", ioe);
        } catch (SecurityException se) {
            Log.e("SYNC getUpdate", "security error", se);
        }
    }
    public void openPdf(String filename){
        Log.w("IR", "TRYING TO RENDER: " + Environment.getExternalStorageDirectory().getAbsolutePath()+nama_surat);
        //  Toast.makeText(DetailDisposisiMasuk.this, ""+nama_surat, Toast.LENGTH_SHORT).show();
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), filename);// Here you declare your pdf path

        Intent pdfViewIntent = new Intent(Intent.ACTION_VIEW);
        pdfViewIntent.setDataAndType(Uri.fromFile(file),"application/pdf");
        pdfViewIntent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        pdfViewIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        pdfViewIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Intent intent = Intent.createChooser(pdfViewIntent, "Open File");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(getApplicationContext(), "Anda Tidak Memiliki Aplikasi Pembaca Berkas Dokumen PDF", Toast.LENGTH_SHORT).show();
        }
    }

}
