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

public class DetailDisposisiKeluar extends AppCompatActivity {

    public String URL = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/model_detail_disposisi_keluar_new.php?id_disposisi=";
    public String URLL = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/model_detail_disposisi_masuk_new2.php?token_disposisi=";
    String URL_DETAIL_DISPOSISI_KELUAR = "";
    String URL_DETAIL_DISPOSISI_MASUK = "";
    String id_disposisi = "";

    String id_suratt = "";


    private String api_pdf_surat_masuk = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/get_file_pdf_disposisi_masuk.php?id_surat=";
    public String url_pdf_surat_masuk = "";


    private final String Tag = "DDK";
    private TextView nomoragendasuratmasuk, nomorsurat, tujuan, tanggalpenerimaansurat, tanggalsurat, pengirim, jenisnotadinas,
            judulsurat, halamansurat, tanggaldisposisi, pengirimdisposisi, instruksi, tanggalselesai, penerima, pesan, namajabatanpenerima;


    private ProgressDialog progressDialog;

    Button buttonBukaSurat;

    public String No_surat_manual = "";
    public String Id_surat = "";
    public String token_surat = "";
    String token_disposisii = "";
    public String Nama_lengkap_penerima = "";
    public String Tgl_surat = "";
    public String Tgl_selesai = "";
    public String Nama_naskah = "";

    String URL_FILE = "";
    String nama_surat = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_disposisi_keluar);
        progressDialog = new ProgressDialog(DetailDisposisiKeluar.this);
        progressDialog.setMessage("Loading....");
        progressDialog.setCancelable(false);
        progressDialog.show();

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());


        nomoragendasuratmasuk = (TextView) findViewById(R.id.tv_hasil_nomor_agenda_surat_masuk_DK);
        nomorsurat = (TextView)findViewById(R.id.tv_hasil_nomor_surat_DK);
        tujuan = (TextView)findViewById(R.id.tv_hasil_tujuan_DK);
        tanggalpenerimaansurat = (TextView)findViewById(R.id.tv_hasil_tanggal_penerimaan_surat_DK);
        tanggalsurat = (TextView)findViewById(R.id.tv_hasil_tanggal_surat_DK);
        pengirim = (TextView)findViewById(R.id.tv_hasil_pengirim_DK);
        jenisnotadinas = (TextView)findViewById(R.id.tv_hasil_jenis_nota_dinas_DK);
        judulsurat = (TextView)findViewById(R.id.tv_hasil_judul_surat_DK);
        halamansurat = (TextView)findViewById(R.id.hasil_halaman_surat);
        tanggaldisposisi = (TextView)findViewById(R.id.tv_hasil_tanggal_disposisi_DK);
        pengirimdisposisi = (TextView)findViewById(R.id.tv_hasil_pengirim_detail_disposisi_DK);
        instruksi = (TextView)findViewById(R.id.tv_hasil_instruksi_DK);
        tanggalselesai = (TextView)findViewById(R.id.tv_hasil_tanggal_selesai_DK);
        penerima = (TextView)findViewById(R.id.tv_hasil_penerima_DK);
        pesan = (TextView)findViewById(R.id.tv_hasil_pesan_DK);
        namajabatanpenerima = (TextView)findViewById(R.id.tv_hasil_nama_jabatan_penerima_DK);

        buttonBukaSurat = (Button)findViewById(R.id.btnBukaSurat_DK);
        buttonBukaSurat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPdf(nama_surat);
            }
        });

        id_suratt = getIntent().getStringExtra("id_surat");
        url_pdf_surat_masuk = api_pdf_surat_masuk + id_suratt;
    //    Toast.makeText(DetailDisposisiKeluar.this, ""+id_suratt, Toast.LENGTH_SHORT).show();


        token_disposisii = getIntent().getStringExtra("token_disposisi");
        URL_DETAIL_DISPOSISI_MASUK = URLL + token_disposisii;
      //  Toast.makeText(DetailDisposisiKeluar.this, "URL "+URL_DETAIL_DISPOSISI_MASUK, Toast.LENGTH_SHORT).show();
        id_disposisi = getIntent().getStringExtra("id_disposisi");
        URL_DETAIL_DISPOSISI_KELUAR = URL + id_disposisi;
        AmbilDataDetailDisposisiKeluar();



        ambilPdfSuratMasuk();
        AmbilDataDetailDisposisiMasuk();
        id_suratt = Id_surat;
   //     Toast.makeText(DetailDisposisiKeluar.this, ""+id_suratt, Toast.LENGTH_SHORT).show();

    }

    public void AmbilDataDetailDisposisiKeluar(){


        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_DETAIL_DISPOSISI_KELUAR, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    Log.d(Tag, object.getString("result"));
                    JSONArray jsonArray = object.getJSONArray("result");


                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Id_surat = jsonObject.getString("id_surat");
                        String Token_disposisi = jsonObject.getString("token_disposisi").trim();
                        token_surat = jsonObject.getString("token_surat");
                        String no_surat_manual = jsonObject.getString("no_surat_manual");
                        String tgl_disposisi = jsonObject.getString("tgl_disposisi");
                        String tgl_selesai = jsonObject.getString("tgl_selesai");
                        String nama_naskah = jsonObject.getString("nama_naskah");
                        String nama_penerima_disposisi = jsonObject.getString("nama_penerima_disposisi");
                        String nama_status_penerima = jsonObject.getString("nama_status_penerima");
                        String isi_disposisi = jsonObject.getString("isi_disposisi");
                        String nama_instruksi = jsonObject.getString("nama_instruksi");


                    //   Toast.makeText(getApplicationContext(), ""+token_disposisi, Toast.LENGTH_SHORT).show();

                        /*

                        Date date = new SimpleDateFormat("dd/mm/yyyy").parse(Tgl_selesai);
                        String formattedDate = new SimpleDateFormat("dd mm yyyy").format(date);
*/


                        nomorsurat.setText(no_surat_manual);
                        tujuan.setText(Nama_lengkap_penerima);
                        tanggalsurat.setText(Tgl_surat);
                        jenisnotadinas.setText(Nama_naskah);
                        instruksi.setText(nama_instruksi);
                        penerima.setText(nama_penerima_disposisi);
                        pengirimdisposisi.setText(Nama_lengkap_penerima);
                        tanggaldisposisi.setText(tgl_disposisi);
                        tanggalselesai.setText(tgl_selesai);


                //        Toast.makeText(getApplicationContext(), ""+URL_DETAIL_DISPOSISI_MASUK, Toast.LENGTH_SHORT).show();


                        //   url_detail_get_pengirim = getPengirim + Token_surat;

                        //    no_surat = getIntent().getStringExtra("no_surat_manual");

//                        nomorsurat.setText(no_surat.toString());


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


    public void AmbilDataDetailDisposisiMasuk(){




        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_DETAIL_DISPOSISI_MASUK, new Response.Listener<String>() {
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
                        Nama_lengkap_penerima = jsonObject.getString("nama_lengkap_penerima").trim();
                        String Nama_jabatan_penerima = jsonObject.getString("nama_jabatan_penerima");
                        String Nama_golongan_penerima = jsonObject.getString("nama_golongan_penerima");
                        String Nama_pengirim = jsonObject.getString("nama_pengirim");
                        String Instansi_pengirim = jsonObject.getString("instansi_pengirim");
                        String Alamat_instansi = jsonObject.getString("alamat_instansi");
                        String Isi_disposisi = jsonObject.getString("isi_disposisi");


                        String Nama_instruksi = jsonObject.getString("nama_instruksi");

/*
                        Date date = new SimpleDateFormat("dd/mm/yyyy").parse(Tgl_selesai);
                        String formattedDate = new SimpleDateFormat("dd mm yyyy").format(date);
*/
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
   //     Toast.makeText(DetailDisposisiKeluar.this, ""+nama_surat, Toast.LENGTH_SHORT).show();
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
                        //hasilJudulSuratSM.setText(judul_surat);
                        judulsurat.setText(nama_surat);
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

}
