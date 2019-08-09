package com.egov.win10.simpelv.TU;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.egov.win10.simpelv.R;
import com.egov.win10.simpelv.adapter.AdapterAgendaKeluar;
import com.egov.win10.simpelv.adapter.AdapterAgendaMasuk;
import com.egov.win10.simpelv.data.DataAgendaKeluar;
import com.egov.win10.simpelv.data.DataAgendaMasuk;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListAgendaKeluar extends AppCompatActivity {

    private String URL = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/model_agenda_keluar_tu.php?id_groups=";



    private String url_agenda_keluar = "";


    private AdapterAgendaKeluar mAdapter;
    private ProgressDialog progressDialog;
    private ArrayList<DataAgendaKeluar> listData;
    public static final String PREFS_NAME = "MyPrefsFile";

    private LinearLayoutManager layoutManager;

    public String token_surat = "";
    public String nama_p = "";

    String id_user;
    String id_groups;
    String id_instansi;


    TextView textViewSM;

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_agenda_keluar);


        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences mSettings = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        String cookieName = settings.getString("message", "default");

        id_user = settings.getString("id_user", "default");
        id_instansi = settings.getString("id_instansi", "default");
        id_groups = settings.getString("id_groups", "default");

        url_agenda_keluar = URL + id_groups +"&id_instansi="+id_instansi+"&id_user="+id_user;


        textViewSM = (TextView)findViewById(R.id.tvNamaSM);
        textViewSM.setText(cookieName);

        RecyclerView rv = (RecyclerView)findViewById(R.id.rvAgendaKeluar);
        rv.setHasFixedSize(true);


        layoutManager = new LinearLayoutManager(ListAgendaKeluar.this);
        //layoutManager.setOrientation(GridLayoutManager.VERTICAL);
        rv.setLayoutManager(layoutManager);
        progressDialog = new ProgressDialog(ListAgendaKeluar.this);
        progressDialog.setMessage("Mohon Tunggu....");
        progressDialog.show();

        //Toast.makeText(this, ""+url_surat_masuk, Toast.LENGTH_SHORT).show();


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                progressDialog.dismiss();
            }
        }, 10000);


        listData = new ArrayList<DataAgendaKeluar>();
        //detailSuratMasuk();
        AmbilData();

        mAdapter = new AdapterAgendaKeluar(listData, ListAgendaKeluar.this);
        rv.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();


    }

    public void AmbilData(){

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url_agenda_keluar, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                if (response.length() > 0) {
                    for (int i = 0; i < response.length(); i++) {
                        try {

                            JSONObject jsonObject = response.getJSONObject(i);
                            DataAgendaKeluar data = new DataAgendaKeluar();
                            data.setNo(jsonObject.getString("no"));
                            data.setNo_agenda_masuk(jsonObject.getString("no_agenda_keluar"));
                            data.setAtas_nama(jsonObject.getString("atas_nama"));
                            data.setSurat_link(jsonObject.getString("surat_link"));
                            data.setSurat_name(jsonObject.getString("surat_name"));
                            data.setSurat_title(jsonObject.getString("surat_title"));
                            data.setId_surat(jsonObject.getString("id_surat"));
                            //  data.setToken_disposisi(jsonObject.getString("token_disposisi"));
                            data.setNama_naskah(jsonObject.getString("nama_naskah"));
                            data.setToken_surat(jsonObject.getString("token_surat"));
                            data.setPerihal_surat(jsonObject.getString("perihal_surat"));
                            data.setTgl_surat(jsonObject.getString("tgl_surat"));
                            data.setTgl_surat_format(jsonObject.getString("tgl_surat_format"));

                            data.setStatus_penerima(jsonObject.getString("status_penerima"));
                            data.setNo_surat_keluar(jsonObject.getString("no_surat_keluar"));

                            token_surat = jsonObject.getString("token_surat");
                            progressDialog.dismiss();
                            listData.add(data);
                            mAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(this).add(jsonArrayRequest);
    }
}
