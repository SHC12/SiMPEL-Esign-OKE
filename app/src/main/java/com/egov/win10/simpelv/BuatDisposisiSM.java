package com.egov.win10.simpelv;

import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.egov.win10.simpelv.data.DataSpinnerPenerimaDisposisi;
import com.sdsmdg.tastytoast.TastyToast;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


import fr.ganfra.materialspinner.MaterialSpinner;

public class BuatDisposisiSM extends AppCompatActivity implements DatePickerDialog.OnDateSetListener  {



    private ArrayList<String> datas;
    private ArrayList<String> datass;
    private ArrayList<String> datass2;




    String tgl = "";
    String datenow = "";
    String mac = "000000";



    public static final String api_menu_penerima = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/menu_nama_penerima.php?id_user=";
    public static final String api_menu_penerima_sekda = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/menu_terusan_atasan.php?id_user=";
    public static final String api_menu_penerima_bupati = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/menu_terusan_atasan_bupati.php?id_user=";
    public static final String api_add_disposisi = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/add_disposisi.php";
    public static final String api_menu_insturksi = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/menu_instruksi.php";
    public static final String url_fcm = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/push_fcm_surat_masuk.php?id_user=";
    public String id_user = "";
    public String id_instansi = "";

    public String url_menu_penerima = "";
    public String url_menu_penerima_sekda = "";
    public String url_menu_insturksi = "";

    public static final String PREFS_NAME = "MyPrefsFile";


    MaterialSpinner spinner;
    MaterialSpinner spinner2;
    MaterialSpinner spinner3;


    public ArrayList<String> menu_penerima_data;
    public ArrayList<String> menu_penerima_data2;

    //JSON Array
    public JSONArray result;
    public JSONArray resultt;
    public JSONArray resulta;

    //TextViews to display details
    private TextView textViewNama;
    private TextView textViewNama2;
    private TextView textViewJabatan;
    private TextView textViewJabatan2;


    String tanggalsuratt;

    Calendar calendar;
    Calendar myCalendar;

    int Year, Month, Day ;

    TextView nomorsurat, tujuan, tanggal_surat, pengirim, jenisnotadinas, tanggalselesai, tvIsi_disposisi;
    EditText editWaktu, editTanggal;

    DatePickerDialog datePickerDialog;
    String id_surat, id_instruksi, isi_disposisi, token_surat, token_disposisi ;

    String jabaatan;
    String id_userrT, id_suratT, id_instruksiT, id_instansiiT, tgl_disposisiT, isi_disposisiT, token_suratT, no_surat_manualT, nama_naskahT, created_byT, macT, penerima_disposisiT;

    String c = "";
    String d = "";
    String e = "";
    String f = "";
    String waktu = "";
    String nama_naskah = "";
    String nomorsuratt;
    Button btnKirimSurat;

    String username, usernamesekda;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_disposisi_sm);



        SharedPreferences mSettings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        usernamesekda = mSettings.getString("username", "default");







        token_surat = getIntent().getStringExtra("token_surat");
        nama_naskah = getIntent().getStringExtra("nama_naskah");




        datas = new ArrayList<String>();
        datass = new ArrayList<String>();
        datass2 = new ArrayList<String>();
        btnKirimSurat = (Button)findViewById(R.id.btnKirimSuratSMSM);
        tvIsi_disposisi = (TextView)findViewById(R.id.editIsiDisposisiSM);
        nomorsurat = (TextView)findViewById(R.id.tv_hasil_nomor_surat_BDMSM);
        tujuan = (TextView)findViewById(R.id.tv_hasil_tujuan_BDMSM);
        tanggal_surat = (TextView)findViewById(R.id.tv_hasil_tanggal_surat_BDMSM);
        pengirim = (TextView)findViewById(R.id.tv_hasil_pengirim_BDMSM);
        jenisnotadinas = (TextView)findViewById(R.id.tv_hasil_jenis_nota_dinas_BDMSM);
        progressDialog = new ProgressDialog(BuatDisposisiSM.this);
        progressDialog.setMessage("Mohon Tunggu....");
        progressDialog.show();






        token_disposisi = getIntent().getStringExtra("token_disposisi");






        calendar = Calendar.getInstance();

        myCalendar = Calendar.getInstance();
        Year = calendar.get(Calendar.YEAR) ;


        Month = calendar.get(Calendar.MONTH);

        id_surat = getIntent().getStringExtra("id_surat");

        Day = calendar.get(Calendar.DAY_OF_MONTH);
        editTanggal = (EditText)findViewById(R.id.editTanggalSelesaiSM);
        editTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();


                datePickerDialog = DatePickerDialog.newInstance(BuatDisposisiSM.this, Year, Month, Day);


                datePickerDialog.setThemeDark(false);

                datePickerDialog.showYearPickerFirst(false);

                datePickerDialog.setAccentColor(Color.parseColor("#0072BA"));

                datePickerDialog.setTitle("Pilih Tanggal Acara");

                datePickerDialog.show(getFragmentManager(), "DatePickerDialog");

            }
        });

       nomorsuratt = getIntent().getStringExtra("nomor_surat");
        tanggalsuratt = getIntent().getStringExtra("tanggal_surat");
        String tanggalselesaii = getIntent().getStringExtra("tgl_selesai");
        String namanaskah = getIntent().getStringExtra("nama_naskah");
        String nama_penerima = getIntent().getStringExtra("tujuan");


        nomorsurat.setText(getIntent().getStringExtra("nomor_surat"));

        tanggal_surat.setText(tanggalsuratt.toString());




        spinner = (MaterialSpinner)findViewById(R.id.spinnerPenerimaDisposisiSM);
        spinner3 = (MaterialSpinner)findViewById(R.id.spinnerPenerimaDisposisiSM2);
        spinner2 = (MaterialSpinner)findViewById(R.id.spinnerInstruksiSM);

        editWaktu = (EditText)findViewById(R.id.editWaktuSM);
        editWaktu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(BuatDisposisiSM.this, new android.app.TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        editWaktu.setText(String.format("%02d:%02d",selectedHour, selectedMinute));
                    }
                }, hour, minute, true);
                mTimePicker.setTitle("Pilih Waktu");
                mTimePicker.show();
            }
        });

        waktu = editWaktu.getText().toString().trim();


        textViewNama = (TextView) findViewById(R.id.textViewNamaSM);
        textViewNama2 = (TextView) findViewById(R.id.textViewNamaSM2);
        textViewJabatan = (TextView) findViewById(R.id.textViewJabatanSM);
        textViewJabatan2 = (TextView) findViewById(R.id.textViewJabatanSM2);



        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        String n = settings.getString("name", "defaultName");
        String nn = settings.getString("namapengirim", "defaultName");
        String nnn = settings.getString("namanaskah", "defaultName");
        tujuan.setText(n);
        pengirim.setText(nn);
        jenisnotadinas.setText(nnn);

        id_user = settings.getString("id_user", "defaultName");

        id_instansi = settings.getString("id_instansi", "defaultInstansi");
        username = settings.getString("username", "default");

       // url_menu_penerima = api_menu_penerima + id_user + "&id_instansi=" + id_instansi;

        if(username.equals("sekda")){
            url_menu_penerima = api_menu_penerima_sekda + id_user + "&id_instansi=" + id_instansi;
        }else if(username.equals("bupati")){
            url_menu_penerima = api_menu_penerima_bupati + id_user + "&id_instansi=" + id_instansi;
        }
        else{
            url_menu_penerima = api_menu_penerima + id_user + "&id_instansi=" + id_instansi;
        }

        url_menu_insturksi = api_menu_insturksi;

       // Toast.makeText(BuatDisposisiSM.this, ""+url_menu_penerima, Toast.LENGTH_SHORT).show();



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String a = getJabatan(position);
                String b = getName(position);
                c = getId_user(position);


                textViewNama.setText(b.toString());
                textViewJabatan.setText(a.toString());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                textViewJabatan.setText("");
                textViewNama.setText("");
            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                d = getIdInstruksi(position);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String x = getJabatann(position);
                String y = getNamee(position);
                e = getId_userr(position);

                textViewNama2.setText(y.toString());
                textViewJabatan2.setText(x.toString());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                textViewJabatan2.setText("");
                textViewNama2.setText("");
            }
        });


        btnKirimSurat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isi_disposisi = tvIsi_disposisi.getText().toString();


                progressDialog.setMessage("Mohon Tunggu....");
                progressDialog.show();
/*
                id_userrT = id_user;
                id_suratT = id_surat;
                id_instruksiT = d.toString();
                id_instansiiT = id_instansi;
                tgl_disposisiT = tanggalsuratt;
                isi_disposisiT = isi_disposisi;
                token_suratT = token_surat;
                no_surat_manualT = getIntent().getStringExtra("no_surat_manual");
                nama_naskahT = getIntent().getStringExtra("nama_naskah");
                created_byT = username;
                macT = "";
                penerima_disposisiT = c.toString() ;*/
                no_surat_manualT = getIntent().getStringExtra("no_surat_manual");
                f = e + ";;"+ c;
                nama_naskahT = getIntent().getStringExtra("nama_naskah");

                if(editTanggal.getText().toString().length() == 0 || c == "" || d == ""){
                    progressDialog.dismiss();
              //      Toasty.info(BuatDisposisiSM.this, "Penerima Disposisi, Instruksi atau Tanggal Selesai tidak boleh kosong", Toast.LENGTH_SHORT, true).show();
                   // TastyToast.makeText(getApplicationContext(), "Penerima Disposisi, Instruksi atau Tanggal Selesai tidak boleh kosong", Toast.LENGTH_LONG, TastyToast.WARNING).show();
                    Toast.makeText(BuatDisposisiSM.this, "Penerima Disposisi, Instruksi atau Tanggal Selesai tidak boleh kosong", Toast.LENGTH_SHORT).show();


                }else {
                    TambahDisposisi(id_user, id_surat, d.toString(), id_instansi, tanggalsuratt, isi_disposisi, token_surat, nomorsuratt, nama_naskah, username, mac, f.toString(), tgl, tgl);
                }

                // Toast.makeText(BuatDisposisiSM.this, "tanggal "+ tgl, Toast.LENGTH_SHORT).show();

              /*  Toast.makeText(BuatDisposisiSM.this, "id_user "+id_user+"\nid surat "+id_surat+"\nid instruksi "+d.toString()+"\nid instansi "+id_instansi+"\ntgl disposisi "+tanggalsuratt+"\nisi disposisi"+isi_disposisi+
                        "\ntoken surat "+token_surat+"\nno surat"+nomorsuratt+"\nnama naskah"+nama_naskah+"\ncreated by "+username+"\nmac "+mac+"\npenerima disposisi "+c.toString()+"\ntoken disposisi "+token_disposisi, Toast.LENGTH_SHORT).show();*/

                notifikasi(c);
                notifikasi(e);

            }
        });



        getData();
        getDataa();
        getDataInstruksi();


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(BuatDisposisiSM.this, MainActivity.class);
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
                //params.put("password", password);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
    private void getData() {
        StringRequest stringRequest = new StringRequest(url_menu_penerima,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject j = null;
                        try {
                            //Parsing the fetched Json String to JSON Object
                            j = new JSONObject(response);

                            //Storing the Array of JSON String to our JSON Array
                            result = j.getJSONArray("result");


                            getNamaLengkap(result);
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

    private void getNamaLengkap(JSONArray j) {
        for (int i = 0; i < j.length(); i++) {
            try {
                //Getting json object
                JSONObject json = j.getJSONObject(i);

                //Adding the name of the student to array list
                datas.add(json.getString("nama_lengkap"));
                progressDialog.dismiss();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        spinner.setAdapter(new ArrayAdapter<String>(BuatDisposisiSM.this, android.R.layout.simple_spinner_dropdown_item, datas));
    }

    private String getName(int position){
        String name="";
        try {
            //Getting object of given index
            JSONObject json = result.getJSONObject(position);

            //Fetching name from that object
            name = json.getString("nama_lengkap");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Returning the name
        return name;
    }

    //Doing the same with this method as we did with getName()
    private String getJabatan(int position){
        String course="";
        try {
            JSONObject json = result.getJSONObject(position);
            course = json.getString("nama_jabatan");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return course;
    }

    //Doing the same with this method as we did with getName()
    private String getId_user(int position){
        String session="";
        try {
            JSONObject json = result.getJSONObject(position);
            session = json.getString("id_user");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return session;
    }


    private void getDataa() {
        StringRequest stringRequest = new StringRequest(url_menu_penerima,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject jj = null;
                        try {
                            //Parsing the fetched Json String to JSON Object
                            jj = new JSONObject(response);

                            //Storing the Array of JSON String to our JSON Array
                            resultt = jj.getJSONArray("result");

                            //Calling method getStudents to get the students from the JSON Array
                            getNamaLengkapp(resultt);
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
                datass2.add(json.getString("nama_lengkap"));
                progressDialog.dismiss();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        spinner3.setAdapter(new ArrayAdapter<String>(BuatDisposisiSM.this, android.R.layout.simple_spinner_dropdown_item, datass2));
    }

    private String getNamee(int position){
        String name="";
        try {
            //Getting object of given index
            JSONObject json = resultt.getJSONObject(position);

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
            JSONObject json = resultt.getJSONObject(position);
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
            JSONObject json = resultt.getJSONObject(position);
            session = json.getString("id_user");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return session;
    }
    public void TambahDisposisi(final String id_userA, final String id_suratA, final String id_instruksiA, final String id_instansiA, final String tgl_disposisiA, final String isi_disposisiA, final String token_suratA,
                                final String no_surat_manualA, final String nama_naskahA, final String created_byA, final String macA, final String penerima_disposisiA,  final String waktuA, final String waktuB){


/*
        id_userrT = id_user;
        id_suratT = id_surat;
        id_instruksiT = d.toString();
        id_instansiiT = id_instansi;
        tgl_disposisiT = tanggalsuratt;
        isi_disposisiT = isi_disposisi;
        token_suratT = token_surat;
        no_surat_manualT = getIntent().getStringExtra("no_surat_manual");
        nama_naskahT = getIntent().getStringExtra("nama_naskah");
        created_byT = username;
        macT = "";
        penerima_disposisiT = c.toString() ;

        Toast.makeText(BuatDisposisi.this, "id_user "+id_userrT+"\nid surat "+id_suratT+"\nid instruksi "+id_instruksiT+"\nid instansi "+id_instansiiT+"\ntgl disposisi "+tgl_disposisiT+"\nisi disposisi"+isi_disposisiT+
                "\ntoken surat "+token_suratT+"\nno surat"+no_surat_manualT+"\nnama naskah"+nama_naskahT+"\ncreated by "+created_byT+"\nmac "+macT+"\npenerima disposisi "+penerima_disposisiT, Toast.LENGTH_SHORT).show();*/
        StringRequest  stringRequest = new StringRequest(Request.Method.POST, api_add_disposisi, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    progressDialog.dismiss();
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
//                    JSONArray jsonArray = jsonObject.getJSONArray("response");
                    if (success.equals("1")) {
                        Intent in = new Intent(BuatDisposisiSM.this, MainActivity.class);
                        Toast.makeText(BuatDisposisiSM.this, "Sukses", Toast.LENGTH_SHORT).show();
                     //   TastyToast.makeText(getApplicationContext(), "Sukses", Toast.LENGTH_LONG, TastyToast.SUCCESS).show();

                   //     Toasty.success(BuatDisposisiSM.this, "Sukses", Toast.LENGTH_SHORT, true).show();
                       /* Toast.makeText(BuatDisposisiSM.this,
                                "Sukses ",
                                Toast.LENGTH_SHORT)
                                .show();*/
                        startActivity(in);
                    }else if(success.equals("0")){

                        Toast.makeText(BuatDisposisiSM.this, "Gagal", Toast.LENGTH_SHORT).show();
                    //    TastyToast.makeText(getApplicationContext(), "Penerima disposisi sudah menerima disposisi ini sebelumnya", Toast.LENGTH_LONG, TastyToast.WARNING).show();
                    //    Toasty.error(BuatDisposisiSM.this, "Penerima disposisi sudah menerima disposisi ini sebelumnya", Toast.LENGTH_SHORT, true).show();

                     /*   Toast.makeText(BuatDisposisiSM.this,
                                "Gagal ",
                                Toast.LENGTH_SHORT)
                                .show();*/
                    }
                } catch (JSONException e) {
                    e.printStackTrace();

                    Toast.makeText(BuatDisposisiSM.this,
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
                params.put("id_user", id_userA);     // sesuaikan dengan $_POST pada PHP
                params.put("id_surat", id_suratA);
                params.put("id_instruksi", id_instruksiA);
                params.put("id_instansi", id_instansiA);
                params.put("tgl_disposisi", tgl_disposisiA);
                params.put("isi_disposisi", isi_disposisiA);
                params.put("token_surat", token_suratA);
                params.put("no_surat_manual", no_surat_manualA);
                params.put("nama_naskah", nama_naskahA);
                params.put("created_by", created_byA);
                params.put("mac", macA);
                params.put("penerima_disposisi", penerima_disposisiA);
                params.put("tgl_terima", waktuA);
                params.put("tgl_selesai", waktuB);


                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);



    }

    public void getDataPenerimaDisposisi(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_menu_penerima, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);

                    JSONArray jsonArray = object.getJSONArray("result");

                    ArrayList<DataSpinnerPenerimaDisposisi> lisData = new ArrayList<DataSpinnerPenerimaDisposisi>();
                    lisData.clear();
                    for (int i = 0; i<jsonArray.length(); i++){

                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        menu_penerima_data.add(jsonObject.getString("nama_lengkap"));


                        //Toast.makeText(BuatDisposisi.this, "jabaran" + jabatan, Toast.LENGTH_SHORT).show();


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

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(BuatDisposisiSM.this, android.R.layout.simple_spinner_dropdown_item, menu_penerima_data);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(spinnerAdapter);

    }
    private void getDataInstruksi() {
        StringRequest stringRequest = new StringRequest(url_menu_insturksi,
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
                            getNamaInstruksi(resulta);
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
    private void getNamaInstruksi(JSONArray j) {
        for (int i = 0; i < j.length(); i++) {
            try {
                //Getting json object
                JSONObject json = j.getJSONObject(i);

                //Adding the name of the student to array list
                datass.add(json.getString("nama_instruksi"));
                // progressDialog.dismiss();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        spinner2.setAdapter(new ArrayAdapter<String>(BuatDisposisiSM.this, android.R.layout.simple_spinner_dropdown_item, datass));
    }

    private String getIdInstruksi(int position){
        String name="";
        try {
            //Getting object of given index
            JSONObject json = resulta.getJSONObject(position);


            name = json.getString("id_instruksi");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Returning the name
        return name;
    }
    public void getDataInsturksiss(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url_menu_insturksi, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonarray = new JSONArray(response);

                    for(int i=0; i < jsonarray.length(); i++) {
                        JSONObject jsonobject = jsonarray.getJSONObject(i);
                        String id = jsonobject.getString("id_instruksi");
                        String insturksi = jsonobject.getString("nama_instruksi");
                        //  id_instruksi = id;




                        menu_penerima_data2.add(insturksi);


                        // Toast.makeText(getApplicationContext(), "instruksi " + insturksi, Toast.LENGTH_SHORT).show();

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

        spinner2.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, menu_penerima_data2));
    }




    //Doing the same with this method as we did with getName()



/*

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       // getDataPenerimaDisposisi();

        //Toast.makeText(BuatDisposisi.this, "jabaran" + array_nama_jabatan.get(position).toString(), Toast.LENGTH_SHORT).show();

        //  textViewJabatan.setText(array_nama_jabatan.get(position));

        String a = getCourse(position);
        String b = getName(position);

        textViewJabatan.setText(a.toString());
        textViewNama.setText(b.toString());

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        textViewNama.setText("");
        textViewJabatan.setText("");

    }
    */

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        myCalendar.set(Calendar.YEAR, year);
        myCalendar.set(Calendar.MONTH, monthOfYear);
        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        String formatTanggal = "dd MMMM yyyy";

        String formatTanggall = "yyyy-MM-dd";

        SimpleDateFormat sdf = new SimpleDateFormat(formatTanggal);
        SimpleDateFormat sdf2 = new SimpleDateFormat(formatTanggall);
        editTanggal.setText(sdf.format(myCalendar.getTime()));
        tgl = sdf2.format(myCalendar.getTime());


    }
}
