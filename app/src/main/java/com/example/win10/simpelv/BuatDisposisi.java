package com.example.win10.simpelv;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import fr.ganfra.materialspinner.MaterialSpinner;

public class BuatDisposisi extends AppCompatActivity implements Spinner.OnItemSelectedListener {


    public static final String api_menu_penerima = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/menu_nama_penerima.php?id_user=";
    public static final String api_menu_insturksi = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/menu_instruksi.php";
    public String id_user = "";
    public String id_instansi = "";

    public String url_menu_penerima = "";
    public String url_menu_insturksi = "";

    public static final String PREFS_NAME = "MyPrefsFile";



    public static final String TAG_NAMA = "nama_lengkap";
    public static final String TAG_JABATAN = "nama_jabatan";
    public static final String JSON_ARRAY = "result";

    MaterialSpinner spinner;
    MaterialSpinner spinner2;
    List<Integer> list = new ArrayList<>();
    ArrayAdapter<Integer> adapter;

    public ArrayList<String> menu_penerima_data;
    public ArrayList<String> menu_penerima_data2;

    //JSON Array
    public JSONArray result;

    //TextViews to display details
    private TextView textViewNama;
    private TextView textViewJabatan;

    String nama = "";
    String jabatan = "";


    TextView nomorsurat, tujuan, tanggal_surat, pengirim, jenisnotadinas, tanggalselesai;
    EditText editWaktu;

    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_disposisi);

        initItems();
        nomorsurat = (TextView)findViewById(R.id.tv_hasil_nomor_surat_BDM);
        tujuan = (TextView)findViewById(R.id.tv_hasil_tujuan_BDM);
        tanggal_surat = (TextView)findViewById(R.id.tv_hasil_tanggal_surat_BDM);
        pengirim = (TextView)findViewById(R.id.tv_hasil_pengirim_BDM);
        jenisnotadinas = (TextView)findViewById(R.id.tv_hasil_jenis_nota_dinas_BDM);
        tanggalselesai = (TextView)findViewById(R.id.tv_hasil_tanggal_selesai_BDM);


        String nomorsuratt = getIntent().getStringExtra("no_surat_manual");
        String tanggalsuratt = getIntent().getStringExtra("tgl_surat");
        String tanggalselesaii = getIntent().getStringExtra("tgl_selesai");
        String namanaskah = getIntent().getStringExtra("nama_naskah");
        String nama_penerima = getIntent().getStringExtra("nama_lengkap_penerima");


        nomorsurat.setText(nomorsuratt.toString());
        tujuan.setText(nama_penerima.toString());
        tanggal_surat.setText(tanggalsuratt.toString());
        tanggalselesai.setText(tanggalselesaii.toString());
        jenisnotadinas.setText(namanaskah.toString());
        //   Toast.makeText(this, "nomor surat : " +nomorsuratt, Toast.LENGTH_SHORT).show();


        spinner = (MaterialSpinner)findViewById(R.id.spinnerPenerimaDisposisi);
        spinner2 = (MaterialSpinner)findViewById(R.id.spinnerInstruksi);
        editWaktu = (EditText)findViewById(R.id.editWaktu);
        editWaktu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(BuatDisposisi.this, new android.app.TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        editWaktu.setText(String.format("%02d:%02d",selectedHour, selectedMinute));
                    }
                }, hour, minute, true);
                mTimePicker.setTitle("Pilih Waktu");
                mTimePicker.show();
            }
        });
        // adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item, list);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spinner.setAdapter(adapter);



        menu_penerima_data = new ArrayList<String>();
        menu_penerima_data2 = new ArrayList<String>();
        spinner.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        //Initializing TextViews
        textViewNama = (TextView) findViewById(R.id.textViewNama);
        textViewJabatan = (TextView) findViewById(R.id.textViewJabatan);


        //This method will fetch the data from the URL


        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        id_user = settings.getString("id_user", "defaultName");
        id_instansi = settings.getString("id_instansi", "defaultInstansi");

        // Toast.makeText(this, "Id user : " + id_user + " id instansi : "+ id_instansi, Toast.LENGTH_SHORT).show();


        url_menu_penerima = api_menu_penerima + id_user + "&id_instansi=" + id_instansi;
        url_menu_insturksi = api_menu_insturksi;

        getDataPenerimaDisposisi();
        getDataInsturksis();
/*
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position != -1){
                    int selected = Integer.parseInt(spinner.getItemAtPosition(position).toString());
                    if(selected %2 == 0){
                        spinner.setError("error");
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/
    }
    public void getDataPenerimaDisposisi(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_menu_penerima, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);

                    JSONArray jsonArray = object.getJSONArray("result");
                    for (int i = 0; i<jsonArray.length(); i++){

                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        menu_penerima_data.add(jsonObject.getString("nama_lengkap"));




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

        spinner.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, menu_penerima_data));
    }
    public void getDataInsturksis(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url_menu_insturksi, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonarray = new JSONArray(response);

                    for(int i=0; i < jsonarray.length(); i++) {
                        JSONObject jsonobject = jsonarray.getJSONObject(i);
                        String id = jsonobject.getString("id_instruksi");
                        String insturksi = jsonobject.getString("nama_instruksi");



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
    private String getCourse(int position){
        String course="";
        try {
            JSONObject json = result.getJSONObject(position);
            course = json.getString(TAG_JABATAN);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return course;
    }

    public void initItems(){
        for(int i = 1; i <=100; i++){
            list.add(i);
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        textViewNama.setText(spinner.getSelectedItem().toString());
        // textViewJabatan.setText(jabatan.toString());


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        textViewNama.setText("");
        textViewJabatan.setText("");
    }
}
