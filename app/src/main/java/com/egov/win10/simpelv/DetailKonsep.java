package com.egov.win10.simpelv;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Environment;
import android.os.StrictMode;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.egov.win10.simpelv.data.DataSpinnerJenisTindakanKonsep;
import com.sdsmdg.tastytoast.TastyToast;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import fr.ganfra.materialspinner.MaterialSpinner;

public class DetailKonsep extends AppCompatActivity implements  DatePickerDialog.OnDateSetListener{

    public static final String PREFS_NAME = "MyPrefsFile";
    private String URL = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/model_detail_konsep.php?token_surat=";
    public static final String api_menu_jenis_naskah_dinas = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/menu_naskah_dinas.php";
    public static final String api_menu_status_pemeriksaan = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/menu_status_pemeriksaan.php";
    private String URL_DETAIL_KONSEP = "";

    private String api_pdf_konsep = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/get_file_pdf_disposisi_masuk.php?id_surat=";
    public String url_pdf_konsep = "";

    private String URL_PEMERIKSA = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/model_urutan_pemeriksa.php?urutan_pemeriksa=";
    String URL_LENGKAP_PEMERIKSA = "";

    private String URLL = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/model_penerima_tanda_tangan.php?id_surat=";
    private String URLLL = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/menu_penerima_tembusan.php?id_surat=";
    private String URL_TTD = "";
    private String URL_TEMBUSAN = "";




    private String API_NOTIFIKASI_WEB = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/notifikasi_web_konsep.php";
    private String API_NOTIFIKASI_WEB_TOLAK = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/notifikasi_web_konsep_tolak.php";
    private String API_NOTIFIKASI_WEB_ATAS_NAMA = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/notifikasi_web_konsep_atas_nama.php";


    public static final String url_fcm = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/push_fcm_konsep.php?id_user=";


    private String api_kirim_surat_konsep = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/kirim_surat_konsep.php";
    private String api_kirim_surat_konsep_tolak = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/kirim_surat_konsep_tolak.php";


    private String api_catatan_pemeriksa = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/model_catatan_pemeriksa.php?id_user_sebelumnya=";
    private String api_catatan_pemeriksa_tolak = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/model_catatan_pemeriksa_tolak.php?id_user_selanjutnya=";
    String URL_LENGKAP_CATATAN = "";
    String URL_LENGKAP_CATATAN_TOLAK = "";
    String id_user_sebelumnya = "";


    String token_surat;
    String id_surat;
    String namaTndakan;
    String valueTindakan;
    String NamaPemeriksaSelanjutnya;

    String Tag = "Konsep";

    String mod_ip = "103.124.89.210";


    TextView tvPenerima, tvAtasNama, tvJudulSurat, tvJenisNaskahDinas, tvPerihalKonsep, tvTanggalSuratKonsep, tvNamaTembusan, tvCatatan, tvCatatanTolak;
    EditText  editPesanPemeriksa;
    Button btnKirimSurat, btnBukaSurat;

    MaterialSpinner spinnerJenisNaskahDinas;
    MaterialSpinner spinnerTindakanPemeriksa;

    public String no;
    //public String id_surat;
    //public String urutan_pemeriksa;
    public String id_user_pemeriksa;
    public String id_user_pemeriksa_konsep;
    public String id_user_pemeriksa_tolak;
    public String surat_title;
    public String surat_name;
    public String surat_link;
    public String status_surat;
   // public String id_naskah;
   // public String token_surat;
    public String user_pemeriksa;
    public String atas_nama;
    public String id_tembusan;
    public String nama_tembusan;
    public String perihal_surat;
    public String nama_naskah;
    public String tgl_surat;
    public String id_atas_nama;


    String id_instansi;


    String id_naskahhh;
    String id_naskah2;
    int id_naskahh;
    String kode_pemeriksa;
    String urutan_pemeriksa;
    String URL_FILE = "";
    String nama_surat = "";

    public String UP;

    public JSONArray resulta;
    public JSONArray resultaa;
    private ArrayList<String> datass;
    private ArrayList<String> datasss;

    private ProgressDialog progressDialog;

    CardView cvKonsep;


    String namaNaskahDinas;

    String catatanPemeriksaa;


    String id_naskah_spin = "";

    String idd = "";
    String ussr = "";
    String datem = "2019-06-23 11:10:28";

    String id_user;

    int checkSpinner;

    public String ada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_konsep);


        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder(); StrictMode.setVmPolicy(builder.build());

        progressDialog = new ProgressDialog(DetailKonsep.this);
        progressDialog.setMessage("Loading....");
        progressDialog.setCancelable(false);
        progressDialog.show();



        datass = new ArrayList<String>();
        datasss = new ArrayList<String>();


        List<DataSpinnerJenisTindakanKonsep> dataListKonsep = new ArrayList<>();
        DataSpinnerJenisTindakanKonsep datakonsep1 = new DataSpinnerJenisTindakanKonsep("AG", "Setujui, lanjutkan ke pemeriksa berikutnya");
        dataListKonsep.add(datakonsep1);
        DataSpinnerJenisTindakanKonsep datakonsep2 = new DataSpinnerJenisTindakanKonsep("RJ", "Tolak, kembali ke pemeriksa sebelunmya");
        dataListKonsep.add(datakonsep2);

        ArrayAdapter<DataSpinnerJenisTindakanKonsep> adapterKonsep = new ArrayAdapter<DataSpinnerJenisTindakanKonsep>(this, android.R.layout.simple_spinner_item, dataListKonsep);
        adapterKonsep.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        idd = settings.getString("id_user", "default");
        ussr = settings.getString("username", "default");
        id_instansi = settings.getString("id_instansi", "default");



       // Toast.makeText(this, ""+idd+"\n"+ussr, Toast.LENGTH_SHORT).show();

        urutan_pemeriksa = getIntent().getStringExtra("urutan_pemeriksa");
        NamaPemeriksaSelanjutnya = getIntent().getStringExtra("id_user_pemeriksa");



        tvPenerima = (TextView)findViewById(R.id.tv_hasil_penerima_BK);
        tvAtasNama = (TextView)findViewById(R.id.tv_hasil_atas_nama_BK);
        tvJudulSurat = (TextView)findViewById(R.id.tv_hasil_judul_surat_konsep);
        tvJenisNaskahDinas = (TextView)findViewById(R.id.hasil_jenisNaskahDInasKonsep);
        tvPerihalKonsep = (TextView)findViewById(R.id.hasil_perihal_konsepp);
        tvTanggalSuratKonsep = (TextView)findViewById(R.id.hasil_tgl_surat_konsepp);
        tvNamaTembusan = (TextView)findViewById(R.id.tv_hasil_tembusan_konsep);
        tvCatatan = (TextView) findViewById(R.id.tv_hasil_catatan_pemeriksa);
        tvCatatanTolak = (TextView) findViewById(R.id.tv_hasil_catatan_pemeriksa_tolak);



        cvKonsep = (CardView) findViewById(R.id.cvIsiSurattKonsep);
        //cvKonsep.setVisibility(View.GONE);










        namaNaskahDinas = getIntent().getStringExtra("nama_naskah");
        tvJenisNaskahDinas.setText(namaNaskahDinas);



        editPesanPemeriksa = (EditText)findViewById(R.id.editPesanPemeriksaanKonsep);

        btnBukaSurat = (Button) findViewById(R.id.btnBukaSuratKonsep);
        btnKirimSurat = (Button) findViewById(R.id.btnKirimSuratKonsep);


        btnBukaSurat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPdf(nama_surat);
            }
        });

        spinnerJenisNaskahDinas = (MaterialSpinner) findViewById(R.id.spinnerJenisNaskahDinasKonsep);
        spinnerTindakanPemeriksa = (MaterialSpinner) findViewById(R.id.spinnerTindakanPemeriksaan);

        id_surat = getIntent().getStringExtra("id_surat");
        urutan_pemeriksa = getIntent().getStringExtra("urutan_pemeriksa");
        id_user_pemeriksa = getIntent().getStringExtra("id_user_pemeriksa");
        id_user_pemeriksa_konsep = getIntent().getStringExtra("id_user_pemeriksa_konsep");
        id_user_pemeriksa_tolak = getIntent().getStringExtra("id_user_pemeriksa_tolak");
        surat_title = getIntent().getStringExtra("surat_title");
        surat_name = getIntent().getStringExtra("surat_name");
        surat_link = getIntent().getStringExtra("surat_link");
        status_surat = getIntent().getStringExtra("status_surat");
        token_surat = getIntent().getStringExtra("token_surat");
        user_pemeriksa = getIntent().getStringExtra("user_pemeriksa");
        atas_nama = getIntent().getStringExtra("atas_nama");
        perihal_surat = getIntent().getStringExtra("perihal_surat");
        nama_naskah = getIntent().getStringExtra("nama_naskah");
        tgl_surat = getIntent().getStringExtra("tgl_surat");
        id_atas_nama = getIntent().getStringExtra("id_atas_nama");
        String tgl_surat_format = getIntent().getStringExtra("tgl_surat_format");
        id_tembusan = getIntent().getStringExtra("id_tembusan");
        nama_tembusan = getIntent().getStringExtra("nama_tembusan");

        URL_LENGKAP_CATATAN = api_catatan_pemeriksa + id_user_pemeriksa_tolak + "&id_surat="+id_surat;
        URL_LENGKAP_CATATAN_TOLAK = api_catatan_pemeriksa_tolak + id_user_pemeriksa + "&id_surat="+id_surat;
        //Toast.makeText(this, ""+URL_LENGKAP_CATATAN, Toast.LENGTH_SHORT).show();
       // tvNamaTembusan.setText(nama_tembusan);

        URL_TTD = URLL + id_surat;
        URL_TEMBUSAN = URLLL + id_surat;
        if(idd.equals(id_user_pemeriksa_konsep)){
            cvKonsep.setVisibility(View.VISIBLE);
        }
        tvPerihalKonsep.setText(perihal_surat);

        //Toast.makeText(this, "id_user"+idd+"\nid_user_pemeriksa"+id_user_pemeriksa, Toast.LENGTH_SHORT).show();
      /*  Toast.makeText(this, "id surat :"+id_surat+
                "\nurutan pemeriksa :"+urutan_pemeriksa+
                "\nid user pemeriksa :"+id_user_pemeriksa+
                "\nid user pemeriksa tolak :"+id_user_pemeriksa_tolak+
                "\nsurat title :"+surat_title+
                "\nsurat name :"+surat_name+
                "\nsurat link :"+surat_link+
                "\nstatus surat :"+status_surat+
                "\ntoken_surat :"+token_surat+
                "\nUser Pemeriksa :" +NamaPemeriksaSelanjutnya+
                "\natas nama :" +atas_nama+
                "\nperihal surat :" +perihal_surat+
                "\nnama_naskah :" +nama_naskah+
                "\nid_user :" +idd+
                "\ntgl surat :" +tgl_surat
                , Toast.LENGTH_SHORT).show();*/

       tvTanggalSuratKonsep.setText(tgl_surat_format);





        url_pdf_konsep = api_pdf_konsep + id_surat;

        URL_DETAIL_KONSEP = URL + token_surat;

        URL_LENGKAP_PEMERIKSA = URL_PEMERIKSA + urutan_pemeriksa +"&id_surat="+id_surat;





        spinnerJenisNaskahDinas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                id_naskahhh = getIdNaskah(position);
               // id_naskah_spin = getIdNaskah(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





        catatanPemeriksaa = editPesanPemeriksa.getText().toString();

        id_naskah2 = getIntent().getStringExtra("id_naskah");

        int naskah = Integer.parseInt(id_naskah2);


        //spinnerJenisNaskahDinas.setSelection(naskah);
/*
        spinnerTindakanPemeriksa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                kode_pemeriksa = getKodeStatusPemeriksa(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
*/
        spinnerTindakanPemeriksa.setAdapter(adapterKonsep);
        spinnerTindakanPemeriksa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                DataSpinnerJenisTindakanKonsep dataKonsep = (DataSpinnerJenisTindakanKonsep) parent.getSelectedItem();
                ambilDataTindakanPemeriksa(dataKonsep);
               // Toast.makeText(DetailKonsep.this, ""+valueTindakan, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

      /*  Toast.makeText(this, "id surat :"+id_surat+
                        "\ntoken_surat :"+token_surat+
                        "\nid_user pemeriksa :"+id_user_pemeriksa+
                        "\nid user pemeriksa tolak :"+id_user_pemeriksa_tolak+
                        "\ntgl surat :" +tgl_surat+
                        "\nperihal surat :" +perihal_surat+
                        "\nid_naskah :" +id_naskah2+
                        "\nsurat title :"+surat_title+
                        "\nsurat name :"+surat_name+
                        "\nsurat link :"+surat_link+
                        "\nstatus surat :"+status_surat+
                        "\nmod_by :"+ussr+

                        "\nurutan_pemeriksa :" +urutan_pemeriksa+

                        "\nid_user :" +idd
                , Toast.LENGTH_SHORT).show();*/

        getDataNaskahDinas();
        btnKirimSurat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Date c = Calendar.getInstance().getTime();
//                System.out.println("Current time => " + c);

                SimpleDateFormat df = new SimpleDateFormat("y-MM-d HH:mm:ss");
                String formattedDate = df.format(c);
                String ti = valueTindakan;
                checkSpinner = spinnerJenisNaskahDinas.getSelectedItemPosition();

                if(checkSpinner!=0){
                    if(ti.equals("AG")){
                        // Toast.makeText(DetailKonsep.this, "Lanjuta", Toast.LENGTH_SHORT).show();
                        String TP = "AG";

                        String catatanP = editPesanPemeriksa.getText().toString();

                        if(idd.equals(id_atas_nama) && ti.equals("AG")){
                            String SS = "MK";
                            // Toast.makeText(DetailKonsep.this, "MK KADIS", Toast.LENGTH_SHORT).show();
                            KirimSuratKonsepAG(id_surat, token_surat, id_user_pemeriksa, tgl_surat, perihal_surat, id_naskahhh, surat_title,surat_name, surat_link, SS.toString(), ussr.toString(), formattedDate, mod_ip, urutan_pemeriksa, idd.toString(), catatanP, formattedDate, TP.toString() );
                            notifikasi(id_user_pemeriksa);
                            NotifikasiWebAtasNama(idd, id_user_pemeriksa, id_surat, token_surat, formattedDate.toString(), id_instansi);
                        }else{
                            // Toast.makeText(DetailKonsep.this, "MK LAIN", Toast.LENGTH_SHORT).show();

                            KirimSuratKonsepAG(id_surat, token_surat, id_user_pemeriksa, tgl_surat, perihal_surat, id_naskahhh, surat_title,surat_name, surat_link, status_surat, ussr.toString(), formattedDate, mod_ip, urutan_pemeriksa, idd.toString(), catatanP, formattedDate, TP.toString() );
                            notifikasi(id_user_pemeriksa);
                            NotifikasiWeb(idd, id_user_pemeriksa, id_surat, token_surat, formattedDate.toString(), urutan_pemeriksa);
                        }
                        //String tgl = editTanggalSurat.getText().toString();
                        //String sPerihal =  editPerihal.getText().toString();
                        // Toast.makeText(DetailKonsep.this, ""+id_naskah.toString(), Toast.LENGTH_SHORT).show();

                    }else{
                        //Toast.makeText(DetailKonsep.this, "Tolak", Toast.LENGTH_SHORT).show();
                        String TP = "RJ";
                        String tgl = editPesanPemeriksa.getText().toString();
                       // Toast.makeText(DetailKonsep.this, ""+id_user_pemeriksa_tolak, Toast.LENGTH_SHORT).show();
                        // Toast.makeText(DetailKonsep.this, ""+TP.toString()+"\n"+catatanPemeriksaa.toString()+"\n"+datem, Toast.LENGTH_SHORT).show();
                        KirimSuratKonsepRJ(id_surat, token_surat, id_user_pemeriksa_tolak, tgl_surat, perihal_surat, id_naskahhh, surat_title,surat_name, surat_link, status_surat, ussr.toString(), formattedDate, mod_ip, urutan_pemeriksa, idd.toString(), tgl, formattedDate, TP.toString() );
                        notifikasi(id_user_pemeriksa_tolak);
                        NotifikasiWebTolak(idd, id_user_pemeriksa_tolak, id_surat, token_surat, formattedDate.toString(), urutan_pemeriksa);
                    }


                }else {
                    Toast.makeText(DetailKonsep.this, "Jenis Naskah Dinas Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                }




            }
        });




        getPdf();

        AmbilDataDetailKonsep();

        AmbilDataCatatan();
        AmbilDataCatatanTolak();

        AmbilTujuan();
        PenerimaTembusan();







    }

    public void NotifikasiWeb(final String id_pengirimA, final String id_penerimaA, final String id_suratA, final String token_suratA, final String tgl_notifikasiA, final String urutan_pemeriksaA){
        StringRequest  stringRequest = new StringRequest(Request.Method.POST, API_NOTIFIKASI_WEB, new Response.Listener<String>() {
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
                params.put("id_penerima", id_penerimaA);
                params.put("token_surat", token_suratA);
                params.put("tgl_notifikasi", tgl_notifikasiA);
                params.put("urutan_pemeriksa", urutan_pemeriksaA);




                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }
    public void NotifikasiWebTolak(final String id_pengirimA, final String id_penerimaA, final String id_suratA, final String token_suratA, final String tgl_notifikasiA, final String urutan_pemeriksaA){
        StringRequest  stringRequest = new StringRequest(Request.Method.POST, API_NOTIFIKASI_WEB_TOLAK, new Response.Listener<String>() {
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
                params.put("id_penerima", id_penerimaA);
                params.put("token_surat", token_suratA);
                params.put("tgl_notifikasi", tgl_notifikasiA);
                params.put("urutan_pemeriksa", urutan_pemeriksaA);




                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }
    public void NotifikasiWebAtasNama(final String id_pengirimA, final String id_penerimaA, final String id_suratA, final String token_suratA, final String tgl_notifikasiA, final String id_instansiA){
        StringRequest  stringRequest = new StringRequest(Request.Method.POST, API_NOTIFIKASI_WEB_ATAS_NAMA, new Response.Listener<String>() {
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
                params.put("id_penerima", id_penerimaA);
                params.put("token_surat", token_suratA);
                params.put("tgl_notifikasi", tgl_notifikasiA);
                params.put("id_instansi", id_instansiA);




                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


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
                            tvPenerima.setText(sb.toString());






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
                            tvNamaTembusan.setText(sb.toString());






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
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(DetailKonsep.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
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

    public void AmbilDataCatatan(){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LENGKAP_CATATAN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    Log.d(Tag, object.getString("result"));
                    JSONArray jsonArray = object.getJSONArray("result");


                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String catatanP = jsonObject.getString("catatan_pemeriksa");
                        if(catatanP.equals("null")){
                            tvCatatan.setText("");
                        }else {
                            tvCatatan.setText(catatanP);

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
    public void AmbilDataCatatanTolak(){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LENGKAP_CATATAN_TOLAK, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    Log.d(Tag, object.getString("result"));
                    JSONArray jsonArray = object.getJSONArray("result");


                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String catatanP = jsonObject.getString("catatan_pemeriksa");

                        if(catatanP.equals("null")){
                         tvCatatanTolak.setText("");
                        }else {
                            tvCatatanTolak.setText(catatanP);

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


    public void KirimSuratKonsepAG(final String id_suratA, final String token_suratA, final String user_pemeriksaA, final String tgl_suratA, final String perihal_suratA, final String id_naskahA, final String surat_titleA,
                                final String surat_nameA, final String surat_linkA, final String status_suratA, final String mod_byA, final String mod_dateA, final String mod_ipA, final String urutan_pemeriksaA, final String id_user_pengirimA, final String catatan_pemeriksaA, final String tgl_pemeriksaA, final String tindakan_pemeriksaA){



        StringRequest  stringRequest = new StringRequest(Request.Method.POST, api_kirim_surat_konsep, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    progressDialog.dismiss();
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("code");
//                    JSONArray jsonArray = jsonObject.getJSONArray("response");
                    if (success.equals("1")) {

                        Intent in = new Intent(DetailKonsep.this, MainActivity.class);
                        startActivity(in);
                        TastyToast.makeText(getApplicationContext(), "Sukses", Toast.LENGTH_LONG, TastyToast.SUCCESS).show();
               //         Toasty.success(DetailKonsep.this, "Sukes", Toast.LENGTH_SHORT, true).show();
                        /*Toast.makeText(DetailKonsep.this,
                                "Sukses ",
                                Toast.LENGTH_SHORT)
                                .show();*/
                    }else if(success.equals("0")){
                        TastyToast.makeText(getApplicationContext(), "Gagal", Toast.LENGTH_LONG, TastyToast.ERROR).show();

              //          Toasty.error(DetailKonsep.this, "Gagal", Toast.LENGTH_SHORT, true).show();

                      /*  Toast.makeText(DetailKonsep.this,
                                "Gagal ",
                                Toast.LENGTH_SHORT)
                                .show();*/
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
        //            Toasty.error(DetailKonsep.this, "Gagal :"+e.toString(), Toast.LENGTH_SHORT, true).show();
                   /* Toast.makeText(DetailKonsep.this,
                            "Error  : " + e.toString(),
                            Toast.LENGTH_SHORT)
                            .show();*/
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
                params.put("user_pemeriksa", user_pemeriksaA);
                params.put("tgl_surat", tgl_suratA);
                params.put("perihal_surat", perihal_suratA);
                params.put("id_naskah", id_naskahA);
                params.put("surat_title", surat_titleA);
                params.put("surat_name", surat_nameA);
                params.put("surat_link", surat_linkA);
                params.put("status_surat", status_suratA);
                params.put("mod_by", mod_byA);
                params.put("mod_date", mod_dateA);
                params.put("mod_ip", mod_ipA);
                params.put("urutan_pemeriksa", urutan_pemeriksaA);
                params.put("id_user_pengirim", id_user_pengirimA);
                params.put("catatan_pemeriksa", catatan_pemeriksaA);
                params.put("tgl_pemeriksa", tgl_pemeriksaA);
                params.put("tindakan_pemeriksa", tindakan_pemeriksaA);



                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);



    }


    public void KirimSuratKonsepRJ(final String id_suratA, final String token_suratA, final String user_pemeriksaA, final String tgl_suratA, final String perihal_suratA, final String id_naskahA, final String surat_titleA,
                                   final String surat_nameA, final String surat_linkA, final String status_suratA, final String mod_byA, final String mod_dateA, final String mod_ipA, final String urutan_pemeriksaA, final String id_user_pengirimA, final String catatan_pemeriksaA, final String tgl_pemeriksaA, final String tindakan_pemeriksaA){


        StringRequest  stringRequest = new StringRequest(Request.Method.POST, api_kirim_surat_konsep_tolak, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    progressDialog.dismiss();
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("code");

//                    JSONArray jsonArray = jsonObject.getJSONArray("response");
                    if (success.equals("1")) {
                        TastyToast.makeText(getApplicationContext(), "Sukses", Toast.LENGTH_LONG, TastyToast.SUCCESS).show();
                        Intent in = new Intent(DetailKonsep.this, MainActivity.class);
                        startActivity(in);
                    }else if(success.equals("0")){
                        TastyToast.makeText(getApplicationContext(), "Gagal", Toast.LENGTH_LONG, TastyToast.ERROR).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();

                    Toast.makeText(DetailKonsep.this,
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
                params.put("id_surat", id_suratA);
                params.put("token_surat", token_suratA);
                params.put("user_pemeriksa", user_pemeriksaA);
                params.put("tgl_surat", tgl_suratA);
                params.put("perihal_surat", perihal_suratA);
                params.put("id_naskah", id_naskahA);
                params.put("surat_title", surat_titleA);
                params.put("surat_name", surat_nameA);
                params.put("surat_link", surat_linkA);
                params.put("status_surat", status_suratA);
                params.put("mod_by", mod_byA);
                params.put("mod_date", mod_dateA);
                params.put("mod_ip", mod_ipA);
                params.put("urutan_pemeriksa", urutan_pemeriksaA);
                params.put("id_user_pengirim", id_user_pengirimA);
                params.put("catatan_pemeriksa", catatan_pemeriksaA);
                params.put("tgl_pemeriksa", tgl_pemeriksaA);
                params.put("tindakan_pemeriksa", tindakan_pemeriksaA);



                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);



    }

    public void getNamaTindakanPemeriksa(View view){
        DataSpinnerJenisTindakanKonsep dataKonsep = (DataSpinnerJenisTindakanKonsep) spinnerTindakanPemeriksa.getSelectedItem();
        ambilDataTindakanPemeriksa(dataKonsep);
    }

    private void ambilDataTindakanPemeriksa(DataSpinnerJenisTindakanKonsep dataKonsep){

         namaTndakan = dataKonsep.getNamaTindakan();
       valueTindakan = dataKonsep.getValueTindakan();

        //String tampildata = "Value "+ valueTindakan + "\nNama "+namaTndakan;

        //Toast.makeText(this, ""+tampildata, Toast.LENGTH_SHORT).show();
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
        pdfViewIntent.setDataAndType(Uri.fromFile(file),"application/msword");
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


                        tvAtasNama.setText(nama_pengirim);
                       // tvPenerima.setText(nama_penerima);
                        tvJenisNaskahDinas.setText(nama_naskah);

                     //   editPerihal.setText(perihal);
                        tvJudulSurat.setText(judul_surat);




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
    private void getDataNaskahDinas() {
        StringRequest stringRequest = new StringRequest(api_menu_jenis_naskah_dinas,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //    JSONObject j = null;
                        try {
                            //Parsing the fetched Json String to JSON Object
                            //   j = new JSONObject(response);

                            //Storing the Array of JSON String to our JSON Array
                            resulta = new JSONArray(response);

                            //Calling method getStudents to get the students from the JSON Array
                            getNamaNaskah(resulta);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //Creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //Adding request to the queue
        requestQueue.add(stringRequest);
    }
    private void getNamaNaskah(JSONArray j) {
        for (int i = 0; i < j.length(); i++) {
            try {
                //Getting json object
                JSONObject json = j.getJSONObject(i);

                //Adding the name of the student to array list
                datass.add(json.getString("nama_naskah"));
                // progressDialog.dismiss();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        spinnerJenisNaskahDinas.setAdapter(new ArrayAdapter<String>(DetailKonsep.this, android.R.layout.simple_spinner_dropdown_item, datass));
    }

    private String getIdNaskah(int position){
        String name="";
        try {
            //Getting object of given index
            JSONObject json = resulta.getJSONObject(position);


            name = json.getString("id_naskah");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Returning the name
        return name;
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

    }

    private void getDataStatusPemeriksaan() {
        StringRequest stringRequest = new StringRequest(api_menu_status_pemeriksaan,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //    JSONObject j = null;
                        try {
                            //Parsing the fetched Json String to JSON Object
                            //   j = new JSONObject(response);

                            //Storing the Array of JSON String to our JSON Array
                            resultaa = new JSONArray(response);

                            //Calling method getStudents to get the students from the JSON Array
                            getNamaStatusPemeriksaan(resultaa);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //Creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //Adding request to the queue
        requestQueue.add(stringRequest);
    }
    private void getNamaStatusPemeriksaan(JSONArray j) {
        for (int i = 0; i < j.length(); i++) {
            try {
                //Getting json object
                JSONObject json = j.getJSONObject(i);

                //Adding the name of the student to array list
                datasss.add(json.getString("nama_status_pemeriksa"));
                // progressDialog.dismiss();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        spinnerTindakanPemeriksa.setAdapter(new ArrayAdapter<String>(DetailKonsep.this, android.R.layout.simple_spinner_dropdown_item, datasss));
    }

    private String getKodeStatusPemeriksa(int position){
        String name="";
        try {
            //Getting object of given index
            JSONObject json = resultaa.getJSONObject(position);


            name = json.getString("kode_status_pemeriksa");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Returning the name
        return name;
    }

}
