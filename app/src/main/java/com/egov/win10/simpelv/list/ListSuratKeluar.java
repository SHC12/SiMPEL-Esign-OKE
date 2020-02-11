package com.egov.win10.simpelv.list;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.egov.win10.simpelv.R;
import com.egov.win10.simpelv.adapter.AdapterSuratKeluar;
import com.egov.win10.simpelv.data.DataSuratKeluar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListSuratKeluar extends AppCompatActivity {


    private String URL = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/model_surat_keluar.php?id_user=";
    String id_instansi, id_groups, username;
    String id_user = "";
    String URL_MODEL_SURAT_KELUAR = "";

    public static final String PREFS_NAME = "MyPrefsFile";


    TextView textViewSK;

    private LinearLayoutManager linearLayoutManager;
    private AdapterSuratKeluar mAdapter;
    private ProgressDialog progressDialog;
    private ArrayList<DataSuratKeluar> listData;
    public RecyclerView rv;

    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_surat_keluar);



        SharedPreferences mSettings = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        SharedPreferences Settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String cookieName = Settings.getString("message", "missing");
        id_instansi = Settings.getString("id_instansi", "default");
        id_user = Settings.getString("id_user", "default");
        username = Settings.getString("username", "default");
        id_groups = Settings.getString("id_groups", "default");

        textViewSK = (TextView)findViewById(R.id.tvNamaListSK);

        textViewSK.setText(cookieName);

        rv = (RecyclerView)findViewById(R.id.rvListSuratKeluar);
        rv.setHasFixedSize(true);
        rv.setVisibility(View.GONE);


        URL_MODEL_SURAT_KELUAR = URL + id_user+"&id_instansi="+id_instansi+"&id_groups="+id_groups+"&username="+username;

    //    Toast.makeText(this, ""+URL_MODEL_SURAT_KELUAR, Toast.LENGTH_SHORT).show();

        linearLayoutManager = new LinearLayoutManager(this);
        //layoutManager.setOrientation(GridLayoutManager.VERTICAL);
        rv.setLayoutManager(linearLayoutManager);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Mohon Tunggu....");
        progressDialog.show();

        //setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        //id_user = (TextView) view.findViewById(R.id.);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                progressDialog.dismiss();
            }
        }, 10000);


        listData = new ArrayList<DataSuratKeluar>();
        AmbilDataModelSK();
        mAdapter = new AdapterSuratKeluar(listData, ListSuratKeluar.this);
        rv.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();







    }

    private void AmbilDataModelSK(){

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL_MODEL_SURAT_KELUAR, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                if (response.length() > 0) {
                    for (int i = 0; i < response.length(); i++) {
                        try {

                            JSONObject jsonObject = response.getJSONObject(i);


                            DataSuratKeluar data = new DataSuratKeluar();
                            data.setNo(jsonObject.getString("no"));
                            data.setId_surat(jsonObject.getString("id_surat"));
                            data.setSurat_title(jsonObject.getString("surat_title"));
                            data.setSurat_name(jsonObject.getString("surat_name"));
                            data.setSurat_link(jsonObject.getString("surat_link"));
                            data.setStatus_surat(jsonObject.getString("status_surat"));
                            data.setId_naskah(jsonObject.getString("id_naskah"));
                            data.setToken_surat(jsonObject.getString("token_surat"));
                            data.setNo_surat_keluar(jsonObject.getString("no_surat_keluar"));
                            data.setId_user_penerima(jsonObject.getString("id_user_penerima"));
                            data.setNama_penerima(jsonObject.getString("nama_penerima"));
                            data.setAtas_nama(jsonObject.getString("atas_nama"));
                            data.setPerihal_surat(jsonObject.getString("perihal_surat"));
                            data.setJenis_surat(jsonObject.getString("jenis_surat"));
                            data.setTgl_surat_format(jsonObject.getString("tgl_surat_format"));
                            data.setTgl_surat(jsonObject.getString("tgl_surat"));
                            data.setNo_agenda_keluar(jsonObject.getString("no_agenda_keluar"));
/*
                            Intent intent = new Intent(getActivity().getBaseContext(), DetailDisposisiMasuk.class);
                            intent.putExtra("id_surat", id_surat);
                            getActivity().startActivity(intent);
*/






                            progressDialog.dismiss();
                            rv.setVisibility(View.VISIBLE);
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
