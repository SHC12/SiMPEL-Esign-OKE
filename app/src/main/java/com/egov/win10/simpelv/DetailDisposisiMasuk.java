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
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.egov.win10.simpelv.data.DataDetailDisposisiMasuk;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DetailDisposisiMasuk extends AppCompatActivity {
    public static final String PREFS_NAME = "MyPrefsFile";
    String Tag = "DetailDisposisiMasuk";

    //private String URL = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/model_detail_disposisi_masuk.php?token_disposisi=59c9a631372a13efa34b85298174a074";
    private String URL = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/model_detail_disposisi_masuk_new2.php?token_disposisi=";
    private String URL_READ = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/update_read_disposisi_masuk.php?id_disposisi_masuk=";
    private String getPDF = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/get_file_pdf_disposisi_masuk.php?id_surat=";
    private String getPengirim = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/model_detail_surat_masuk.php?token_surat=";
    private String token_disposisi = "";






    private String api_pdf_disposisi_masuk = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/get_file_pdf_disposisi_masuk.php?id_surat=";
    public String url_pdf_disposisi_masuk = "";
    public String url_id_disposisi_masuk = "";
    String URL_FILE = "";
    String nama_surat = "";
    public String file_url = "";

    private String id_surat = "";
    public String Id_surat = "";
    private String no_surat = "";
    private String id_disposisi_masuk = "";

    private String url_detail_disposisi_masuk = "";
    private String url_detail_get_surat = "";
    private String url_detail_get_pengirim = "";
    private ProgressDialog progressDialog;

    private ArrayList<DataDetailDisposisiMasuk> listData;


    private TextView nomoragendasuratmasuk, nomorsurat, tujuan, tanggalpenerimaansurat, tanggalsurat, pengirim, jenisnotadinas,
            judulsurat, halamansurat, tanggaldisposisi, pengirimdisposisi, instruksi, tanggalselesai, penerima, pesan, namajabatanpenerima;



    private FloatingActionButton fab;
    String token_surat;

    public String No_surat_manual = "";
    public String Nama_lengkap_penerima = "";
    public String Tgl_surat = "";
    public String Tgl_selesai = "";
    public String Nama_naskah = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_disposisi_masuk);


        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder(); StrictMode.setVmPolicy(builder.build());

        progressDialog = new ProgressDialog(DetailDisposisiMasuk.this);
        progressDialog.setMessage("Loading....");
        progressDialog.setCancelable(false);
        progressDialog.show();

        //progressDialog = new ProgressDialog(DetailDisposisiMasuk.this);
        //progressDialog.setMessage("Mohon Tunggu");
        // progressDialog.show();
     //   new DownloadFile().execute(URL_FILE, nama_surat);
        token_disposisi = getIntent().getStringExtra("token_disposisi");
        url_detail_disposisi_masuk = URL + token_disposisi;
        fab = (FloatingActionButton) findViewById(R.id.fabBuatDisposisi);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), BuatDisposisi.class);
                in.putExtra("no_surat_manual", no_surat);
                in.putExtra("nama_lengkap_penerima", Nama_lengkap_penerima);
                in.putExtra("tgl_selesai", Tgl_selesai);
                in.putExtra("tgl_surat", Tgl_surat);
                in.putExtra("id_surat", id_surat);
                in.putExtra("token_disposisi", token_disposisi);
                in.putExtra("nama_naskah", Nama_naskah);

                startActivity(in);
            }
        });


        id_disposisi_masuk = getIntent().getStringExtra("id_disposisi_masuk");

        url_id_disposisi_masuk = URL_READ + id_disposisi_masuk;

        /*String extStorageDirectory = Environment.getExternalStorageDirectory()
                .toString();
        File folder = new File(extStorageDirectory, "pdf");
        folder.mkdir();
        File file = new File(folder, "Read.pdf");
        try {
            file.createNewFile();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
       */

        Button btnBukaSurat = (Button)findViewById(R.id.btnBukaSurat);
        btnBukaSurat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new DownloadFile().execute(file_url, "file_f1b893a1b401b4875da179a2e20d7167.pdf");
                //showPdf();
                //new DownloadTask(DetailDisposisiMasuk.this, URL_FILE);
                /*String pdfurl = "http://simpel.pasamanbaratkab.go.id/upload/letter/mail/file_2751862d110b5b5801000775a96f87d0.pdf"; //YOUR URL TO PDF
                String googleDocsUrl = "http://docs.google.com/viewer?url=" + pdfurl;
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(Uri.parse(googleDocsUrl ), "text/html");
                startActivity(intent);*/
                openPdf(nama_surat);

            }
        });



        id_surat = getIntent().getStringExtra("id_surat");
        url_detail_get_surat = getPDF + id_surat;

        url_pdf_disposisi_masuk = api_pdf_disposisi_masuk + id_surat;




        nomoragendasuratmasuk = (TextView) findViewById(R.id.tv_hasil_nomor_agenda_surat_masuk);
        nomorsurat = (TextView)findViewById(R.id.tv_hasil_nomor_surat);
        tujuan = (TextView)findViewById(R.id.tv_hasil_tujuan);
        tanggalpenerimaansurat = (TextView)findViewById(R.id.tv_hasil_tanggal_penerimaan_surat);
        tanggalsurat = (TextView)findViewById(R.id.tv_hasil_tanggal_surat);
        pengirim = (TextView)findViewById(R.id.tv_hasil_pengirim);
        jenisnotadinas = (TextView)findViewById(R.id.tv_hasil_jenis_nota_dinas);
        judulsurat = (TextView)findViewById(R.id.tv_hasil_judul_surat);
        halamansurat = (TextView)findViewById(R.id.hasil_halaman_surat);
        tanggaldisposisi = (TextView)findViewById(R.id.tv_hasil_tanggal_disposisi);
        pengirimdisposisi = (TextView)findViewById(R.id.tv_hasil_pengirim_detail_disposisi);
        instruksi = (TextView)findViewById(R.id.tv_hasil_instruksi);
        tanggalselesai = (TextView)findViewById(R.id.tv_hasil_tanggal_selesai);
        penerima = (TextView)findViewById(R.id.tv_hasil_penerima);
        pesan = (TextView)findViewById(R.id.tv_hasil_pesan);
        namajabatanpenerima = (TextView)findViewById(R.id.tv_hasil_nama_jabatan_penerima);


        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String n = settings.getString("name", "defaultName");
        penerima.setText(n);


      //  Toast.makeText(getApplicationContext(), "Id surat"+ id_disposisi_masuk, Toast.LENGTH_SHORT).show();


        AmbilDataDetailDisposisiMasuk();
        ambilPdfDisposisiMasuk();
        getPdf();

        ambilPengirim();
        readDisposisiMasuk();

    }


    public void readDisposisiMasuk(){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_id_disposisi_masuk, new Response.Listener<String>() {
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
                params.put("id_disposisi_masuk", id_disposisi_masuk);     // sesuaikan dengan $_POST pada PHP

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

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
            Toast.makeText(getApplicationContext(), "Anda Tidak Memiliki Aplikasi Pembaca Berkas PDF", Toast.LENGTH_SHORT).show();
        }
    }
    public void AmbilDataDetailDisposisiMasuk(){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_detail_disposisi_masuk, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    Log.d(Tag, object.getString("result"));
                    JSONArray jsonArray = object.getJSONArray("result");


                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Id_surat = jsonObject.getString("id_surat");
                        String Token_disposisi = jsonObject.getString("token_disposisi");
                        String Token_surat = jsonObject.getString("token_surat");
                        No_surat_manual = jsonObject.getString("no_surat_manual");
                        Tgl_surat = jsonObject.getString("tgl_surat");
                        Tgl_selesai = jsonObject.getString("tgl_selesai");
                        Nama_naskah = jsonObject.getString("nama_naskah");
                        Nama_lengkap_penerima = jsonObject.getString("nama_lengkap_penerima");
                        String Nama_jabatan_penerima = jsonObject.getString("nama_jabatan_penerima");
                        String Nama_golongan_penerima = jsonObject.getString("nama_golongan_penerima");
                        String Nama_pengirim = jsonObject.getString("nama_pengirim");
                        String Instansi_pengirim = jsonObject.getString("instansi_pengirim");
                        String Alamat_instansi = jsonObject.getString("alamat_instansi");
                        String Isi_disposisi = jsonObject.getString("isi_disposisi");
                        String Nama_instruksi = jsonObject.getString("nama_instruksi");
                        DataDetailDisposisiMasuk data = new DataDetailDisposisiMasuk();
                        data.setId_surat(jsonObject.getString("id_surat"));
                        data.setToken_disposisi(jsonObject.getString("token_disposisi"));
                        data.setToken_surat(jsonObject.getString("token_surat"));
                        data.setNo_surat_manual(jsonObject.getString("no_surat_manual"));
                        data.setTgl_surat(jsonObject.getString("tgl_surat"));
                        data.setTgl_selesai(jsonObject.getString("tgl_selesai"));
                        data.setNama_naskah(jsonObject.getString("nama_naskah"));
                        data.setNama_lengkap_penerima(jsonObject.getString("nama_lengkap_penerima"));
                        data.setNama_jabatan_penerima(jsonObject.getString("nama_pengirim"));
                        data.setNama_golongan_penerima(jsonObject.getString("nama_golongan_penerima"));
                        data.setNama_pengirim(jsonObject.getString("nama_pengirim"));
                        data.setInstansi_pengirim(jsonObject.getString("instansi_pengirim"));
                        data.setAlamat_instansi(jsonObject.getString("alamat_instansi"));
                        data.setIsi_disposisi(jsonObject.getString("isi_disposisi"));
                        data.setNama_instruksi(jsonObject.getString("nama_instruksi"));
/*
                        Date date = new SimpleDateFormat("dd/mm/yyyy").parse(Tgl_selesai);
                        String formattedDate = new SimpleDateFormat("dd mm yyyy").format(date);
*/

/*
                        String strDate = Tgl_selesai;
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
                        Date datee = dateFormat.parse(strDate);
                        System.out.println(datee);*/

                        tujuan.setText(Nama_lengkap_penerima);
                        tanggalsurat.setText(Tgl_surat);
                        jenisnotadinas.setText(Nama_naskah);
                        instruksi.setText(Nama_instruksi);
                        pesan.setText(Isi_disposisi);
                        namajabatanpenerima.setText(Nama_jabatan_penerima);
                        pengirimdisposisi.setText(Nama_lengkap_penerima);
                        tanggaldisposisi.setText(Tgl_surat);
                        tanggalselesai.setText(Tgl_selesai);
                        pengirim.setText(Nama_pengirim);
                    //    Toast.makeText(DetailDisposisiMasuk.this, "nama pengirim"+Nama_pengirim, Toast.LENGTH_SHORT).show();



                        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = settings.edit();
                        token_surat = Token_surat;
                        editor.putString("tokensurat", token_surat);
                        editor.putString("tujuan_dm", Nama_lengkap_penerima);
                        editor.putString("pengirim_dm", Nama_pengirim);
                        editor.commit();



                        url_detail_get_pengirim = getPengirim + Token_surat;

                        no_surat = getIntent().getStringExtra("no_surat_manual");

                        nomorsurat.setText(no_surat.toString());


                        //tanggalselesai.setText(formattedDate);


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


    public void ambilPdfDisposisiMasuk(){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_pdf_disposisi_masuk, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);

                    JSONArray jsonArray = object.getJSONArray("response");
                    for (int i = 0; i<jsonArray.length(); i++){

                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String id_surat = jsonObject.getString("id_surat");
                        String judul_surat = jsonObject.getString("surat_name");
                        String link_surat = jsonObject.getString("surat_link");

                        judulsurat.setText(judul_surat);
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

    public void getPdf(){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_pdf_disposisi_masuk, new Response.Listener<String>() {
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

    private void ambilPengirim(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_detail_get_pengirim, new Response.Listener<String>() {
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
                        String no_surat_manual = jsonObject.getString("no_surat_manual");
                        String tgl_surat = jsonObject.getString("tgl_surat");
                        String tgl_surat_masuk = jsonObject.getString("tgl_surat_masuk");
                        String nama_pengirim = jsonObject.getString("nama_pengirim");


                        pengirim.setText(nama_pengirim);
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


    public void download(View v)
    {
        new DownloadFile().execute(URL_FILE, nama_surat);
    }

    public void view(View v)
    {
        File pdfFile = new File(Environment.getExternalStorageDirectory() + "/testthreepdf/" + "maven.pdf");  // -> filename = maven.pdf
        Uri path = Uri.fromFile(pdfFile);
        Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
        pdfIntent.setDataAndType(path, "application/pdf");
        pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        try{
            startActivity(pdfIntent);
        }catch(ActivityNotFoundException e){
            Toast.makeText(DetailDisposisiMasuk.this, "Anda Tidak Memiliki Aplikasi Pembaca Berkas PDF", Toast.LENGTH_SHORT).show();
        }
    }

    private class DownloadFile extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... strings) {
            String fileUrl = strings[0];   // -> http://maven.apache.org/maven-1.x/maven.pdf
            String fileName = strings[1];  // -> maven.pdf
            String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
            File folder = new File(extStorageDirectory, "SiMPEL/Disposisi Masuk");
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
