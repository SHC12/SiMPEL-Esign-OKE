package com.egov.win10.simpelv;

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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

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

public class DetailTembusan extends AppCompatActivity {


    private String URL = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/model_detail_surat_keluar.php?token_surat=";
    private String URL_DETAIL_SURAT_KELUAR = "";

    private String api_pdf_SK = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/get_file_pdf_disposisi_masuk.php?id_surat=";
    public String url_pdf_SK = "";

    String Tag = "SK";
    String URL_FILE = "";
    String nama_surat = "";


    String token_surat, no_surat_masuk, tgl_suratt, penerima, pengirimm, judul_suratt, nota_dinas, no_agenda, id_surat;

    TextView no_agenda_surat_keluar, no_surat, tujuan, tgl_penerimaan, tgl_surat, pengirim, jenis_nota_dinas, judul_surat;

    Button btnBukaSurat;

    private ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tembusan);

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder(); StrictMode.setVmPolicy(builder.build());

        progressDialog = new ProgressDialog(DetailTembusan.this);
        progressDialog.setMessage("Loading....");
        progressDialog.setCancelable(false);
        progressDialog.show();

        no_agenda_surat_keluar = (TextView) findViewById(R.id.tv_hasil_nomor_agenda_surat_masuk_tembusan2);
        no_surat = (TextView) findViewById(R.id.tv_hasil_nomor_surat_tembusan2);
        tujuan = (TextView) findViewById(R.id.tv_hasil_tujuan_surat_tembusan2);
        tgl_surat = (TextView) findViewById(R.id.tv_hasil_tanggal_surat_tembusan);
        pengirim = (TextView) findViewById(R.id.tv_hasil_pengirim_surat_tembusan2);
        jenis_nota_dinas = (TextView) findViewById(R.id.tv_hasil_jenis_nota_dinas_surat_tembusan2);
        judul_surat = (TextView) findViewById(R.id.tv_hasil_judul_surat_tembusan2);

        btnBukaSurat = (Button) findViewById(R.id.btnBukaSuratSuratTembusan);
        btnBukaSurat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPdf(nama_surat);
            }
        });



        no_surat_masuk = getIntent().getStringExtra("nomor_surat");
        tgl_suratt = getIntent().getStringExtra("tgl_surat_format");
        pengirimm = getIntent().getStringExtra("nama_pengirim");
        penerima = getIntent().getStringExtra("nama_tujuan");
        judul_suratt = getIntent().getStringExtra("judul_surat");
        nota_dinas = getIntent().getStringExtra("jenis_surat");
        no_agenda = getIntent().getStringExtra("no_agenda_masuk");
        id_surat = getIntent().getStringExtra("id_surat");

        no_surat.setText(no_surat_masuk);
        tujuan.setText(penerima);
        pengirim.setText(pengirimm);
        tgl_surat.setText(tgl_suratt);
        jenis_nota_dinas.setText(nota_dinas);
        judul_surat.setText(judul_suratt);
        no_agenda_surat_keluar.setText(no_agenda);

       // Toast.makeText(this, ""+no_agenda+"\n"+penerima+"\n"+nota_dinas, Toast.LENGTH_SHORT).show();


        url_pdf_SK = api_pdf_SK + id_surat;

        getPdf();


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
            Toast.makeText(getApplicationContext(), "Anda Tidak Memiliki Aplikasi Pembaca Berkas Dokumen Doc", Toast.LENGTH_SHORT).show();
        }
    }

}
