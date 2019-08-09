package com.egov.win10.simpelv;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Environment;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
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
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.sdsmdg.tastytoast.TastyToast;

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



public class DetailSignature extends AppCompatActivity {

    private String URL = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/model_detail_konsep.php?token_surat=";
    private String URL_DETAIL_KONSEP = "";

    private String URLL = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/model_penerima_tanda_tangan.php?id_surat=";
    private String URL_TTD = "";

    private String api_pdf_konsep = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/get_file_pdf_disposisi_masuk.php?id_surat=";
    public String url_pdf_konsep = "";

    public static final String url_fcm = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/push_fcm_tu_penerima_ttd.php?id_user=";

    private String URL_TANDA_TANGAN = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/kirim_surat_signature.php";

    private String API_NOTIFIKASI_WEB_TU = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/notifikasi_web_surat_masuk_TU.php";

    String Tag = "Signature";
    String URL_FILE = "";
    String nama_surat = "";

    public static final String PREFS_NAME = "MyPrefsFile";


    String id_surat = "";
    String token_surat = "";
    String nama_tujuan = "";
    String nama_pengirim = "";
    String judul_surat = "";
    String nomor_surat = "";
    String agenda_nomor_surat_keluar = "";
    String tgl_surat = "";
    String jenis_nota_dinas = "";

    String username = "";
    String id_instansi = "";

    String date = "2019-06-26 06:44:24";
    String ip = "192.168.23.2";

    public String id_pengirim;

    String tembusan = "Tidak Ada";


    private String URLLL = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/menu_penerima_tembusan.php?id_surat=";
    private String URL_TEMBUSAN = "";

    private ProgressDialog progressDialog;

    TextView tvJudulSurat, tvNoAgendaSuratKeluar, tvNomorSurat, tvTglSurat, tvPengirim, tvTujuan, tvIsiSurat, tvJenisNota, tvTembusan;
    Button btnBukaSuratSignature, btnTandaTanganSignature;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_signature);

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder(); StrictMode.setVmPolicy(builder.build());
/*
        Fragment fragment = null;
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fl_container, fragment);
            ft.addToBackStack(null);
            ft.commit();
        }
*/

        id_surat = getIntent().getStringExtra("id_surat");
        token_surat = getIntent().getStringExtra("token_surat");
        nama_tujuan = getIntent().getStringExtra("nama_tujuan");
        nama_pengirim = getIntent().getStringExtra("nama_pengirim");
        judul_surat = getIntent().getStringExtra("judul_surat");
        id_instansi = getIntent().getStringExtra("id_instansi");
        nomor_surat = getIntent().getStringExtra("nomor_surat");
        agenda_nomor_surat_keluar = getIntent().getStringExtra("no_agenda_surat_keluar");
        tgl_surat = getIntent().getStringExtra("tanggal_surat");
        jenis_nota_dinas = getIntent().getStringExtra("jenis_nota_dinas");
        String tgl_surat_format = getIntent().getStringExtra("tanggal_surat_format");
        tembusan = getIntent().getStringExtra("nama_tembusan");

        URL_TTD = URLL + id_surat;

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        username = settings.getString("username", "default");
        id_pengirim = settings.getString("id_user", "default");

       // id_instansi = settings.getString("id_instansi", "default");


        progressDialog = new ProgressDialog(DetailSignature.this);
        progressDialog.setMessage("Loading....");
        progressDialog.setCancelable(false);
        progressDialog.show();

        url_pdf_konsep = api_pdf_konsep + id_surat;

        URL_DETAIL_KONSEP = URL + token_surat;
        URL_TEMBUSAN = URLLL + id_surat;


        tvJudulSurat = (TextView) findViewById(R.id.hasil_judul_surat_signature);
        tvNoAgendaSuratKeluar = (TextView) findViewById(R.id.hasil_no_agenda_surat_keluar_signature);
        tvNomorSurat = (TextView) findViewById(R.id.hasil_nomor_surat_signature);
        tvTglSurat = (TextView) findViewById(R.id.hasil_tgl_surat_signature);
        tvPengirim = (TextView) findViewById(R.id.tv_hasil_pengirim_signature);
        tvTujuan = (TextView) findViewById(R.id.tv_hasil_tujuan_signature);
        tvIsiSurat = (TextView) findViewById(R.id.tv_hasil_isi_surat_signature);
        tvJenisNota = (TextView) findViewById(R.id.hasil_jenis_nota_dinas_signature);
        tvTembusan = (TextView) findViewById(R.id.tv_hasil_tembusan_signature);


        tvTujuan.setMovementMethod(new ScrollingMovementMethod());

        tvJudulSurat.setText(judul_surat);
        tvNoAgendaSuratKeluar.setText(agenda_nomor_surat_keluar);
        tvNomorSurat.setText(nomor_surat);
        tvTglSurat.setText(tgl_surat_format);
        tvPengirim.setText(nama_pengirim);
       // tvTembusan.setText(tembusan);
       // tvTujuan.setText(nama_tujuan);
        tvJenisNota.setText(jenis_nota_dinas);

        btnBukaSuratSignature = (Button) findViewById(R.id.btnBukaSuratSignature);
        btnTandaTanganSignature = (Button) findViewById(R.id.btn_tanda_tangan);


        btnBukaSuratSignature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPdf(nama_surat);
            }
        });

        btnTandaTanganSignature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date c = Calendar.getInstance().getTime();
//                System.out.println("Current time => " + c);

                SimpleDateFormat df = new SimpleDateFormat("y-MM-dd HH:mm:ss");
                String formattedDate = df.format(c);



                //Toast.makeText(DetailSignature.this, ""+c+"\n"+formattedDate, Toast.LENGTH_SHORT).show();
                //Toast.makeText(DetailSignature.this, "id_surat :"+id_surat+"\ntoken surat :"+token_surat+"\ncreate by :"+username+"\ncreate date :"+formattedDate+"\ncreate ip :"+ip+"\nmod by :"+username+"\nmod date :"+formattedDate+"\nmod ip :"+ip+"\n tgl surat masuk : "+formattedDate+"\nid instansi :"+id_instansi, Toast.LENGTH_SHORT).show();
               TandaTangan(id_surat, token_surat, username, formattedDate, ip, username, formattedDate, ip, formattedDate, id_instansi);
                AmbilPenerimaTU();
                //Toast.makeText(DetailSignature.this, "id_pengirim"+id_pengirim+"\nid_surat"+id_surat+"\ntgl_notifikasi"+formattedDate+"\ntoken_surat"+token_surat, Toast.LENGTH_SHORT).show();



            }
        });

        getPdf();

        PenerimaTembusan();
        AmbilDataDetailKonsep();
        AmbilTujuan();


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
                            tvTembusan.setText(sb.toString());






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
    public void notifikasiPenerimaTU(final String id_user_fcm){

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

    public void AmbilPenerimaTU(){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL_TTD, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {



                if (response.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < response.length(); i++) {
                        try {

                            JSONObject jsonObject = response.getJSONObject(i);


                            String idUserTu = jsonObject.getString("id_user_tu");
                            notifikasiPenerimaTU(idUserTu);







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
                            tvTujuan.setText(sb.toString());






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


    public void TandaTangan(final String id_suratA, final String token_suratA, final String create_byA, final String create_dateA, final String create_ipA, final String mod_byA, final String mod_dateA, final String mod_ipA, final String tgl_surat_masukA, final String id_instansiA){
        progressDialog = new ProgressDialog(DetailSignature.this);
        progressDialog.setMessage("Sedang Mengirim Surat....");
        progressDialog.setCancelable(false);
        progressDialog.show();
        StringRequest  stringRequest = new StringRequest(Request.Method.POST, URL_TANDA_TANGAN, new Response.Listener<String>() {
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

                        TastyToast.makeText(getApplicationContext(), "Sukses", Toast.LENGTH_LONG, TastyToast.SUCCESS).show();
                        NotifikasiWeb(id_surat, id_pengirim, token_surat, formattedDate);
                        AmbilPenerimaTU();
                        Intent in = new Intent(DetailSignature.this, MainActivity.class);
                        startActivity(in);
                        //Toasty.success(DetailSignature.this,
                              //  "Sukses ",
                              //  Toast.LENGTH_SHORT, true)
                                //.show();
                    }else if(success.equals("0")){
                        TastyToast.makeText(getApplicationContext(), "Gagal", Toast.LENGTH_LONG, TastyToast.ERROR).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();

                    TastyToast.makeText(getApplicationContext(), "Error : "+e.toString(), Toast.LENGTH_LONG, TastyToast.ERROR).show();
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
                params.put("id_surat", id_suratA);
                params.put("token_surat", token_suratA);
                params.put("create_by", create_byA);
                params.put("create_date", create_dateA);
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

    public void NotifikasiWeb(final String id_suratA, final String id_pengirimA, final String token_suratA, final String tgl_notifikasiA){
        StringRequest  stringRequest = new StringRequest(Request.Method.POST, API_NOTIFIKASI_WEB_TU, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
              /*  try {
                    progressDialog.dismiss();
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("code");
//                    JSONArray jsonArray = jsonObject.getJSONArray("response");
                    if (success.equals("1")) {

                        Toasty.success(DetailKonsep.this, "Sukes", Toast.LENGTH_SHORT, true).show();
                        /*Toast.makeText(DetailKonsep.this,
                                "Sukses ",
                                Toast.LENGTH_SHORT)
                                .show();
                    }else if(success.equals("0")){

                        Toasty.error(DetailKonsep.this, "Gagal", Toast.LENGTH_SHORT, true).show();

                      /*  Toast.makeText(DetailKonsep.this,
                                "Gagal ",
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toasty.error(DetailKonsep.this, "Gagal :"+e.toString(), Toast.LENGTH_SHORT, true).show();
                   /* Toast.makeText(DetailKonsep.this,
                            "Error  : " + e.toString(),
                            Toast.LENGTH_SHORT)
                            .show();*
                }*/


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("id_surat", id_suratA);
                params.put("id_pengirim", id_pengirimA);
                params.put("token_surat", token_suratA);
                params.put("tgl_notifikasi", tgl_notifikasiA);





                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }
    public void getPdf(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_pdf_konsep, new Response.Listener<String>() {
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

                        tvIsiSurat.setText(surat_name);

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


    public void AmbilDataDetailKonsep(){

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DETAIL_KONSEP, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    Log.d(Tag, object.getString("result"));
                    JSONArray jsonArray = object.getJSONArray("result");


                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String nama_pengirim = jsonObject.getString("nama_pengirim");
                        String nama_penerima = jsonObject.getString("nama_penerima");
                        String tgl_surat = jsonObject.getString("tanggal_surat");
                        String perihal = jsonObject.getString("perihal_surat");
                        String id_naskah = jsonObject.getString("id_naskah");
                        String judul_surat = jsonObject.getString("judul_surat");
                        String nama_naskah = jsonObject.getString("nama_naskah");
                        String nama_status_surat = jsonObject.getString("nama_status surat");
                        String nama_pemeriksa = jsonObject.getString("nama_pemeriksa");




                        //   editPerihal.setText(perihal);





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
