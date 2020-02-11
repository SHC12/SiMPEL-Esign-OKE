package com.egov.win10.simpelv.TU;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

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
import com.egov.win10.simpelv.BuatDisposisiSM;
import com.egov.win10.simpelv.DetailKonsep;
import com.egov.win10.simpelv.MainActivity;
import com.egov.win10.simpelv.R;
import com.egov.win10.simpelv.TTD.DaftarTTD;
import com.nbsp.materialfilepicker.MaterialFilePicker;
import com.nbsp.materialfilepicker.ui.FilePickerActivity;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import fr.ganfra.materialspinner.MaterialSpinner;

public class BuatSuratMasuk extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {



    public static final String getPenerima = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/get_penerima.php?id_instansi_tu=";
    public static final String api_menu_jenis_naskah_dinas = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/menu_naskah_dinas.php";
    public static final String url_fcm = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/push_fcm_surat_masuk_tu.php?id_user=";
   String url_penerima = "";
   String id_instansi_tu;
   String id_user_tu;
   String id_user_pimpinan;
   String id_naskah;
   String nama_penerima;
   String jabatan_penerima;
   String username;
   String nama_lengkap;


   String filepath2;

    EditText tu_tgl_penerimaan, tu_tgl_surat, tu_nama, tu_instansi, tu_alamat_instansi, tu_nomor_surat_masuk, tu_nomor_agenda_masuk, tu_perihal_surat;
    TextView tv_namaTembusan, tv_jabatanTembusan;

    MaterialSpinner spinerTembusan;
    MaterialSpinner spinerJenisNaskahDinas;

    Calendar myCalendar;
    Calendar myCalendar2;
    Calendar calendar;

    String tgl = "";
    String tgl2 = "";

    String s_tgl_penerimaan, s_tgl_surat, s_nama, s_instansi, s_alamat_instansi, s_nomor_surat_masuk, s_nomor_agenda_masuk, s_perihal_surat;

    Button btnPilihSurat, btnKirimSurat;

    DatePickerDialog datePickerDialog;
    android.app.DatePickerDialog datepicker2;
    SimpleDateFormat dateFormat;
    int Year, Month, Day ;
    public static final String PREFS_NAME = "MyPrefsFile";

    public JSONArray resultTembusan;
    public JSONArray resultNaskahDinas;
    private ArrayList<String> datatembusan;
    private ArrayList<String> dataNaskahDinas;


    TextView tvNamaTU;

    private ProgressDialog progressDialog;


    File surat_pdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_surat_masuk);

        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.M && checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[] {android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1001);
        }


        datatembusan = new ArrayList<String>();
        dataNaskahDinas = new ArrayList<String>();

        SharedPreferences mSettings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        id_instansi_tu = mSettings.getString("id_instansi", "default");
        id_user_tu = mSettings.getString("id_user", "default");
        username =mSettings.getString("username", "default");
        id_user_pimpinan = mSettings.getString("id_user_pimpinan", "default");
        nama_lengkap = mSettings.getString("nama_lengkap", "default");
 //       Toast.makeText(this, ""+id_instansi_tu, Toast.LENGTH_SHORT).show();



        tvNamaTU = (TextView) findViewById(R.id.tvNamaBSM);
        tvNamaTU.setText(nama_lengkap);


        url_penerima = getPenerima + id_instansi_tu;

       // Toast.makeText(this, ""+url_penerima, Toast.LENGTH_SHORT).show();
        dateFormat = new SimpleDateFormat("dd MMMM yyyy");

        calendar = Calendar.getInstance();
        myCalendar = Calendar.getInstance();
        myCalendar2 = Calendar.getInstance();
        Year = calendar.get(Calendar.YEAR) ;


        Month = calendar.get(Calendar.MONTH);
        Day = calendar.get(Calendar.DAY_OF_MONTH);
        tu_tgl_penerimaan = (EditText) findViewById(R.id.BSM_tanggal_penerimaan);
        tu_tgl_penerimaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar now = Calendar.getInstance();


                datePickerDialog = DatePickerDialog.newInstance(BuatSuratMasuk.this, Year, Month, Day);


                datePickerDialog.setThemeDark(false);

                datePickerDialog.showYearPickerFirst(false);

                datePickerDialog.setAccentColor(Color.parseColor("#0072BA"));

                datePickerDialog.setTitle("Pilih Tanggal Acara");

                datePickerDialog.show(getFragmentManager(), "DatePickerDialog");
            }
        });
        tu_tgl_surat = (EditText) findViewById(R.id.BSM_tanggal_surat);
        tu_tgl_surat.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
            showDateDialog();
            }
        });
        tu_nama = (EditText) findViewById(R.id.BSM_nama);
        tu_instansi = (EditText) findViewById(R.id.BSM_instansi);
        tu_alamat_instansi = (EditText) findViewById(R.id.BSM_alamat_instansi);
        tu_nomor_surat_masuk = (EditText) findViewById(R.id.BSM_nomor_surat_masuk);
        tu_nomor_agenda_masuk = (EditText) findViewById(R.id.BSM_nomor_agenda_masuk);
        tu_perihal_surat = (EditText) findViewById(R.id.BSM_perihal_surat);





        spinerJenisNaskahDinas = (MaterialSpinner) findViewById(R.id.spinnerJenisNaskahSuratManual);
        spinerJenisNaskahDinas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                id_naskah = getIdNaskah(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnPilihSurat = (Button) findViewById(R.id.btn_BSM_pilih_surat);
        btnPilihSurat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialFilePicker()
                        .withActivity(BuatSuratMasuk.this)
                        .withRequestCode(1200)
                        .withHiddenFiles(false)

                        .start();
            }
        });
        btnKirimSurat = (Button) findViewById(R.id.btn_BSM_kirim_surat);
        btnKirimSurat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s_tgl_penerimaan = tu_tgl_penerimaan.getText().toString();
                s_tgl_surat = tu_tgl_surat.getText().toString();
                s_nama = tu_nama.getText().toString();
                s_instansi = tu_instansi.getText().toString();
                s_alamat_instansi = tu_alamat_instansi.getText().toString();
                s_nomor_surat_masuk = tu_nomor_surat_masuk.getText().toString();
                s_nomor_agenda_masuk = tu_nomor_agenda_masuk.getText().toString();
                s_perihal_surat = tu_perihal_surat.getText().toString();

                progressDialog = new ProgressDialog(BuatSuratMasuk.this);
                progressDialog.setMessage("Mohon Tunggu....");
                progressDialog.show();


                if(s_tgl_penerimaan.equals("") || s_tgl_surat.equals("") || s_nama.equals("") || s_instansi.equals("") || s_alamat_instansi.equals("") || s_nomor_surat_masuk.equals("") || s_nomor_agenda_masuk.equals("")
                || s_perihal_surat.equals("") || id_naskah.equals("")){
                    progressDialog.dismiss();
                    Toast.makeText(BuatSuratMasuk.this, "Gagal, data tidak boleh kosong !", Toast.LENGTH_SHORT).show();
                }else {
                    upload_pdf();

                }
             //  notifikasi(id_user_pimpinan);
               // Toast.makeText(BuatSuratMasuk.this, ""+id_user_pimpinan+"\n"+username, Toast.LENGTH_SHORT).show();
                /*Toast.makeText(BuatSuratMasuk.this, "tgl_penerimaan : "+tgl+"\n tgl_surat : "+tgl2+"\nnama : "+s_nama+"\n instansi : "+s_instansi+"\n alamat instansi : "+s_alamat_instansi+
                        "\nno surat masuk : "+s_nomor_surat_masuk+"\n no agenda masuk : "+s_nomor_agenda_masuk+"\n perihal surat : "+s_perihal_surat+"\n id naskah : "+id_naskah+"\n id user penerima : "+id_user_tembusan+"\n id instansi : "+id_instansi_tu+"\nid user instansi : "+id_user_tu+"\n username : "+username, Toast.LENGTH_SHORT).show();
*/

            }
        });



      //  getDataa();
        getDataNaskahDinas();



    }


    public void upload_pdf(){



        surat_pdf = new File(filepath2);



        AndroidNetworking.upload("http://simpel.pasamanbaratkab.go.id/api_android/simaya/surat_masuk_manual.php")
                .addMultipartFile("image_ttd", surat_pdf)
                .addMultipartParameter("user_instansi", id_instansi_tu)
                .addMultipartParameter("user_pemeriksa", id_user_tu)
                .addMultipartParameter("tgl_surat", tgl2)
                .addMultipartParameter("perihal_surat", s_perihal_surat)
                .addMultipartParameter("jenis_naskah", id_naskah)
                .addMultipartParameter("nama_pengirim", s_nama)
                .addMultipartParameter("instansi_pengirim", s_instansi)
                .addMultipartParameter("alamat_pengirim", s_alamat_instansi)
                .addMultipartParameter("no_surat", s_nomor_surat_masuk)
                .addMultipartParameter("create_by", username)
                .addMultipartParameter("create_date", tgl)
                .addMultipartParameter("create_ip", "192.168.0.0")
                .addMultipartParameter("no_agenda", s_nomor_agenda_masuk)
                .setTag("Upload Image")
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        progressDialog.dismiss();
                        notifikasi(id_user_pimpinan);
                        Toast.makeText(BuatSuratMasuk.this, "Sukses", Toast.LENGTH_SHORT).show();
                        Intent in =  new Intent(BuatSuratMasuk.this, MainActivity.class);
                        startActivity(in);
                    }

                    @Override
                    public void onError(ANError anError) {
                        anError.printStackTrace();
                        //    Toast.makeText(DaftarTTD.this, "ERROR : " + anError.getErrorBody(), Toast.LENGTH_SHORT).show();
                        Log.e("ERROR  : ", ""+anError.getErrorDetail());
                    }
                });


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

    private void getDataNaskahDinas() {
        StringRequest stringRequest = new StringRequest(api_menu_jenis_naskah_dinas,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            resultNaskahDinas = new JSONArray(response);


                            getNamaNaskah(resultNaskahDinas);
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


        RequestQueue requestQueue = Volley.newRequestQueue(this);


        requestQueue.add(stringRequest);
    }
    private void getNamaNaskah(JSONArray j) {
        for (int i = 0; i < j.length(); i++) {
            try {

                JSONObject json = j.getJSONObject(i);


                dataNaskahDinas.add(json.getString("nama_naskah"));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        spinerJenisNaskahDinas.setAdapter(new ArrayAdapter<String>(BuatSuratMasuk.this, android.R.layout.simple_spinner_dropdown_item, dataNaskahDinas));
    }

    private String getIdNaskah(int position){
        String name="";
        try {
            //Getting object of given index
            JSONObject json = resultNaskahDinas.getJSONObject(position);


            name = json.getString("id_naskah");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Returning the name
        return name;
    }

    private void getDataa() {
        StringRequest stringRequest = new StringRequest(url_penerima,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //Parsing the fetched Json String to JSON Object
                            //   j = new JSONObject(response);

                            //Storing the Array of JSON String to our JSON Array
                            resultTembusan = new JSONArray(response);

                            //Calling method getStudents to get the students from the JSON Array
                            getNamaLengkapp(resultTembusan);
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

    private void getNamaLengkapp(JSONArray jj) {
        for (int i = 0; i < jj.length(); i++) {
            try {
                //Getting json object
                JSONObject json = jj.getJSONObject(i);

                //Adding the name of the student to array list
                datatembusan.add(json.getString("nama_instansi"));
                progressDialog.dismiss();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
     //   spinerTembusan.setAdapter(new ArrayAdapter<String>(BuatSuratMasuk.this, android.R.layout.simple_spinner_dropdown_item, datatembusan));
    }

    private String getNamee(int position){
        String name="";
        try {
            //Getting object of given index
            JSONObject json = resultTembusan.getJSONObject(position);

            //Fetching name from that object
            name = json.getString("nama_lengkap");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Returning the name
        return name;
    }

    //Doing the same with this method as we did with getName()
    private String getJabatann(int position){
        String course="";
        try {
            JSONObject json = resultTembusan.getJSONObject(position);
            course = json.getString("nama_jabatan");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return course;
    }

    //Doing the same with this method as we did with getName()
    private String getId_userr(int position){
        String session="";
        try {
            JSONObject json = resultTembusan.getJSONObject(position);
            session = json.getString("id_user");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return session;
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void showDateDialog(){

        /**
         * Calendar untuk mendapatkan tanggal sekarang
         */
        Calendar newCalendar = Calendar.getInstance();

        /**
         * Initiate DatePicker dialog
         */
        datepicker2 = new android.app.DatePickerDialog(this, new android.app.DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(i, i1, i2);

                tu_tgl_surat.setText(dateFormat.format(newDate.getTime()));

                String formatTanggalll = "yyyy-MM-dd";
                SimpleDateFormat sdff2 = new SimpleDateFormat(formatTanggalll);
                tgl2 = sdff2.format(newDate.getTime());
            }
        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        datepicker2.show();


    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        myCalendar.set(Calendar.YEAR, year);
        myCalendar.set(Calendar.MONTH, monthOfYear);
        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        myCalendar2.set(Calendar.YEAR, year);
        myCalendar2.set(Calendar.MONTH, monthOfYear);
        myCalendar2.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        String formatTanggal = "dd MMMM yyyy";

        String formatTanggall = "yyyy-MM-dd";

        SimpleDateFormat sdf = new SimpleDateFormat(formatTanggal);
        SimpleDateFormat sdf2 = new SimpleDateFormat(formatTanggall);
        tu_tgl_penerimaan.setText(sdf.format(myCalendar.getTime()));
        tgl = sdf2.format(myCalendar.getTime());
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1001:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Ijin DIterima!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Ijin Ditolak!", Toast.LENGTH_SHORT).show();
                    finish();
                }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == 1200 && resultCode == RESULT_OK) {
            filepath2 = data.getStringExtra(FilePickerActivity.RESULT_FILE_PATH);


        }

    }
}
