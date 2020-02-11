package com.egov.win10.simpelv;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.StrictMode;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.egov.win10.simpelv.TTD.DaftarTTD;
import com.github.clans.fab.FloatingActionButton;

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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DetailSuratMasuk extends AppCompatActivity {
    public static final String PREFS_NAME = "MyPrefsFile";

    private String Url = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/model_detail_surat_masuk.php?token_surat=";
    private String URL_VERIF_TTD = "http://103.124.89.210/api/sign/verify";
    private String api_pdf_surat_masuk = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/get_file_pdf_disposisi_masuk.php?id_surat=";
    private String READ_SM = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/update_read_surat_masuk.php?id_surat=";
    public String url_pdf_surat_masuk = "";
    String Tag = "DetailSuratMasuk";
    public String id_suratt = "";
    String URL_FILE = "";
    String nama_surat = "";
    String token_surat_url = "";
    String url_detail_surat_masuk = "";
    String no_surat_manual = "";
    String perihalSurat = "";
    String tgl_surat = "";
    String tgl_surat_masuk = "";
    TextView hasilNomorAgendaSM, hasilTanggalPenerimaanSM, hasilPengirimSM, hasilStatusSM, hasilNomorSuratSM, hasilTanggalSuratSM, hasilTujuanSM, hasilJudulSuratSM, hasiljenisNotaSM;

    String judul_surat;


    String nama_naskah="";
    String URL_READ_SM="";

    String id_user;

    private FloatingActionButton fab;
    private FloatingActionButton fabVerif;
    Intent intent;
    private ProgressDialog progressDialog;
    Button btnBukaSuratSM;



    String token_disposisi;

    File signed_file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);






        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        setContentView(R.layout.activity_detail_surat_masuk);
        progressDialog = new ProgressDialog(DetailSuratMasuk.this);
        progressDialog.setMessage("Loading....");
        progressDialog.setCancelable(false);
        progressDialog.show();


        tgl_surat_masuk = getIntent().getStringExtra("tanggal_surat_masuk");
        nama_naskah = getIntent().getStringExtra("nama_naskah");

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());


        token_disposisi = getIntent().getStringExtra("token_disposisi");
     //   Toast.makeText(DetailSuratMasuk.this, "token disposisi "+token_disposisi, Toast.LENGTH_SHORT).show();

        hasilNomorAgendaSM = (TextView) findViewById(R.id.tv_hasil_nomor_agenda_surat_masuk_SM);
        hasilTanggalPenerimaanSM = (TextView) findViewById(R.id.tv_hasil_tanggal_penerimaan_surat_SM);
        hasilPengirimSM = (TextView) findViewById(R.id.tv_hasil_pengirim_SM);
        hasilNomorSuratSM = (TextView) findViewById(R.id.tv_hasil_nomor_surat_SM);
        hasilTanggalSuratSM = (TextView) findViewById(R.id.tv_hasil_tanggal_surat_SM);
        hasilTujuanSM = (TextView) findViewById(R.id.tv_hasil_tujuan_SM);
        hasilJudulSuratSM = (TextView) findViewById(R.id.tv_hasil_judul_surat_SM);
        hasiljenisNotaSM = (TextView) findViewById(R.id.tv_hasil_jenis_nota_dinas_SM);

        hasilTanggalPenerimaanSM.setText(tgl_surat_masuk);

        tgl_surat = getIntent().getStringExtra("tanggal_surat");

        fab = (FloatingActionButton) findViewById(R.id.fabBuatDisposisi_SM);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), BuatDisposisiSM.class);
                in.putExtra("nomor_surat", no_surat_manual);
                in.putExtra("tanggal_surat", tgl_surat);
                in.putExtra("token_disposisi", token_disposisi);
                in.putExtra("id_surat", id_suratt);
                in.putExtra("token_surat", token_surat_url);
                in.putExtra("nama_surat", nama_surat);
                in.putExtra("nama_naskah", nama_naskah);
                in.putExtra("pengirim", nama_naskah);
                in.putExtra("jenis_nota_dinas", nama_naskah);

                startActivity(in);
            }
        });
        fabVerif = (FloatingActionButton) findViewById(R.id.fabVerifikasiTTD_SM);
        fabVerif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(DetailSuratMasuk.this, ""+Environment.getExternalStorageDirectory() + "/" + nama_surat, Toast.LENGTH_SHORT).show();
                progressDialog = new ProgressDialog(DetailSuratMasuk.this);
                progressDialog.setMessage("Mohon Tunggu....");
                progressDialog.setCancelable(false);
                progressDialog.show();

                VerifTTD();

            }
        });



        btnBukaSuratSM = (Button) findViewById(R.id.btnBukaSuratSM);
        btnBukaSuratSM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


/*                File pdfFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/SiMPEL/Surat Masuk/"+nama_surat);
                Uri path = Uri.fromFile(pdfFile);

                Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
                pdfIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                pdfIntent.setDataAndType(path, "application/pdf");
                pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(pdfIntent);


                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/SiMPEL/Surat Masuk/"+nama_surat);
                    Uri uri = FileProvider.getUriForFile(getApplicationContext(), getPackageName() + ".provider", file);
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(uri);
                    intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(intent);
                } else {
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.parse(Environment.getExternalStorageDirectory().getAbsolutePath()+"/SiMPEL/Surat Masuk/"+nama_surat), "application/pdf");
                    intent = Intent.createChooser(intent, "Open File");
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }

                File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/SiMPEL/Surat Masuk/"+nama_surat);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(Uri.fromFile(file), "application/pdf");
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);*/


                openPdf(nama_surat);


            }
        });


        // Toast.makeText(DetailSuratMasuk.this, "/SiMPEL/Surat Masuk/"+nama_surat, Toast.LENGTH_SHORT).show();
        token_surat_url = getIntent().getStringExtra("token_surat");
        String ts = no_surat_manual;
        no_surat_manual = getIntent().getStringExtra("no_surat_manual");


        perihalSurat = getIntent().getStringExtra("perihal_surat");
        //hasiljenisNotaSM.setText(perihalSurat);
        hasiljenisNotaSM.setText(nama_naskah);

        id_suratt = getIntent().getStringExtra("id_surat");
        url_pdf_surat_masuk = api_pdf_surat_masuk + id_suratt;
        id_user = settings.getString("id_user", "default");
        URL_READ_SM = READ_SM + id_suratt +"$id_user="+id_user;


        url_detail_surat_masuk = Url + token_surat_url;

        hasilNomorSuratSM.setText(ts);


        String n = settings.getString("name", "defaultName");
        hasilTujuanSM.setText(n);


        AmbilDataSuratMasuk();


        ambilPdfSuratMasuk();
        readSuratMasuk();


    }

    public void VerifTTD(){

        signed_file = new File(Environment.getExternalStorageDirectory() + "/" + nama_surat);

        AndroidNetworking.upload(URL_VERIF_TTD)
                .addMultipartFile("signed_file", signed_file)
                .setTag("Registrasi")
                .setPriority(Priority.HIGH)
                .addHeaders("Authorization", "Basic YnNyZTpzZWN1cmV0cmFuc2FjdGlvbnMhISE=")
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        if (response != null) {
                            try {
                                progressDialog.dismiss();
                                String responseString = response.get("notes").toString();


                                if(responseString.equals("null")){
                                    Toast.makeText(DetailSuratMasuk.this, "Dokumen tidak dapat diverifikasi", Toast.LENGTH_SHORT).show();
                                }else {

                                    Toast.makeText(DetailSuratMasuk.this, "" + responseString, Toast.LENGTH_SHORT).show();
                                }




                            } catch (Exception e) {
                                e.printStackTrace();
                                Toast.makeText(DetailSuratMasuk.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        anError.printStackTrace();
                        Toast.makeText(DetailSuratMasuk.this, "ERROR : " + anError.getErrorDetail(), Toast.LENGTH_SHORT).show();
                        Log.e("ERROR  : ", ""+anError.getErrorDetail());
                    }
                });

    }

    public void readSuratMasuk(){

        Date c = Calendar.getInstance().getTime();
//                System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("y-MM-d HH:mm:ss");
        final String formattedDate = df.format(c);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_READ_SM, new Response.Listener<String>() {
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
                params.put("id_surat", id_suratt);     // sesuaikan dengan $_POST pada PHP
                params.put("id_user", id_user);     // sesuaikan dengan $_POST pada PHP
                params.put("create_date", formattedDate);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }


    public void DownloadFiles() {

        try {
            URL u = new URL(URL_FILE);
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
      //  Toast.makeText(DetailSuratMasuk.this, ""+nama_surat, Toast.LENGTH_SHORT).show();
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
            Toast.makeText(getApplicationContext(), "Anda Tidak Memiliki Aplikasi Pembaca Berkas PDF", Toast.LENGTH_SHORT).show();
        }
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
                       // nama_naskah = jsonObject.getString("nama_naskah");
                        String no_agenda_masuk = jsonObject.getString("no_agenda_masuk");
                        String no_surat_manuall = jsonObject.getString("no_surat_manual");
                        String tgl_surat = jsonObject.getString("tgl_surat");
                        String tgl_surat_masuk = jsonObject.getString("tgl_surat_masuk");
                        String nama_pengirim = jsonObject.getString("nama_pengirim");

                        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putString("namapengirim", nama_pengirim);
                        editor.putString("namanaskah", nama_naskah);
                        editor.commit();


                        //Toast.makeText(DetailSuratMasuk.this, "no "+ no_agenda_masuk, Toast.LENGTH_SHORT).show();


                        hasilTanggalSuratSM.setText(tgl_surat);
                        hasilNomorSuratSM.setText(no_surat_manual);
                        hasilNomorAgendaSM.setText(no_agenda_masuk);
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
                        judul_surat = jsonObject.getString("surat_name");
                        String link_surat = jsonObject.getString("surat_link");



                        URL_FILE = link_surat;
                        nama_surat = judul_surat;
                        hasilJudulSuratSM.setText(judul_surat);
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



    private class DownloadFile extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... strings) {
            String fileUrl = strings[0];   // -> http://maven.apache.org/maven-1.x/maven.pdf
            String fileName = strings[1];  // -> maven.pdf
            String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
            File folder = new File(extStorageDirectory);
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
