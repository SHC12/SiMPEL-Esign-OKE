package com.egov.win10.simpelv.list;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.egov.win10.simpelv.R;
import com.egov.win10.simpelv.adapter.AdapterTembusan;
import com.egov.win10.simpelv.data.DataTembusan;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListTembusan extends AppCompatActivity {


    private String URL = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/model_tembusan.php?id_user=";
    private String URL_TEMBUSAN = "";

    String id_user = "";
    String id_instansi = "";

    public static final String PREFS_NAME = "MyPrefsFile";

    private LinearLayoutManager linearLayoutManager;
    private AdapterTembusan mAdapter;
    private ProgressDialog progressDialog;
    private ArrayList<DataTembusan> listData;
    public RecyclerView rv;

    View view;


    TextView textViewSK;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_tembusan);


        SharedPreferences mSettings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String cookieName = mSettings.getString("message", "default");

        id_instansi = mSettings.getString("id_instansi", "default");
        id_user = mSettings.getString("id_user", "default");



        textViewSK = (TextView)findViewById(R.id.tvNamaTembusan);


        textViewSK.setText(cookieName);

        URL_TEMBUSAN = URL+id_user+"&id_instansi="+id_instansi;
        rv = (RecyclerView)findViewById(R.id.rvTembusan);
        rv.setHasFixedSize(true);
        rv.setVisibility(View.GONE);




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


        listData = new ArrayList<DataTembusan>();
        AmbilDataModelTembusan();
        mAdapter = new AdapterTembusan(listData, ListTembusan.this);
        rv.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();


    }

    private void AmbilDataModelTembusan() {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL_TEMBUSAN, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                if (response.length() > 0) {
                    for (int i = 0; i < response.length(); i++) {
                        try {

                            JSONObject jsonObject = response.getJSONObject(i);


                            DataTembusan data = new DataTembusan();
                            data.setNo(jsonObject.getString("no"));
                            data.setId_surat(jsonObject.getString("id_surat"));
                            data.setNomor_surat(jsonObject.getString("nomor_surat"));
                            data.setNama_pengirim(jsonObject.getString("nama_pengirim"));
                            data.setNo_agenda_masuk(jsonObject.getString("no_agenda_masuk"));
                            data.setNama_tujuan(jsonObject.getString("nama_tujuan"));
                            data.setStatus_surat(jsonObject.getString("status_surat"));
                            data.setId_naskah(jsonObject.getString("id_naskah"));
                            data.setToken_surat(jsonObject.getString("token_surat"));
                            data.setSurat_title(jsonObject.getString("surat_title"));
                            data.setAtas_nama(jsonObject.getString("atas_nama"));
                            data.setPerihal_surat(jsonObject.getString("perihal_surat"));
                            data.setNama_naskah(jsonObject.getString("nama_naskah"));

                            data.setTgl_surat_format(jsonObject.getString("tgl_surat_format"));



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
}
