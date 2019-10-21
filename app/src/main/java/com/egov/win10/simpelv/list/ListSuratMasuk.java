package com.egov.win10.simpelv.list;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.egov.win10.simpelv.R;
import com.egov.win10.simpelv.adapter.AdapterSuratMasuk;
import com.egov.win10.simpelv.data.DataSuratMasuk;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListSuratMasuk extends AppCompatActivity {

    private String URL = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/model_surat_masuk_new.php?id_user=";
    private String URL_DETAIL_SURAT_MASUK = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/model_detail_surat_masuk.php?token_surat=";
    private String id_userr = "";
    private String url_surat_masuk = "";
    private String url_detail_surat_masuk = "";
    private AdapterSuratMasuk mAdapter;
    private ProgressDialog progressDialog;
    private ArrayList<DataSuratMasuk> listData;
    public static final String PREFS_NAME = "MyPrefsFile";

    private LinearLayoutManager layoutManager;

    public String token_surat = "";
    public String nama_p = "";



    TextView textViewSM;

    SharedPreferences sharedpreferences;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_surat_masuk);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences mSettings = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        String cookieName = settings.getString("message", "default");


        textViewSM = (TextView)findViewById(R.id.tvNamaSM);
        textViewSM.setText(cookieName);

        RecyclerView rv = (RecyclerView)findViewById(R.id.rvSuratMasuk);
        rv.setHasFixedSize(true);

        id_userr = settings.getString("id_user", "default");
        url_surat_masuk = URL + id_userr;
        url_detail_surat_masuk = URL_DETAIL_SURAT_MASUK + token_surat;
        layoutManager = new LinearLayoutManager(ListSuratMasuk.this);
        //layoutManager.setOrientation(GridLayoutManager.VERTICAL);
        rv.setLayoutManager(layoutManager);
        progressDialog = new ProgressDialog(ListSuratMasuk.this);
        progressDialog.setMessage("Mohon Tunggu....");
        progressDialog.show();

        //Toast.makeText(this, ""+url_surat_masuk, Toast.LENGTH_SHORT).show();


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                progressDialog.dismiss();
            }
        }, 10000);


        listData = new ArrayList<DataSuratMasuk>();
        //detailSuratMasuk();
        AmbilData();

        mAdapter = new AdapterSuratMasuk(listData, ListSuratMasuk.this);
        rv.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();



    }


    public void AmbilData(){

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url_surat_masuk, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                if (response.length() > 0) {
                    for (int i = 0; i < response.length(); i++) {
                        try {

                            JSONObject jsonObject = response.getJSONObject(i);
                            DataSuratMasuk data = new DataSuratMasuk();
                            data.setNo(jsonObject.getString("no"));
                            data.setNama_pengirim(jsonObject.getString("nama_pengirim"));
                            data.setId_surat(jsonObject.getString("id_surat"));
                            //  data.setToken_disposisi(jsonObject.getString("token_disposisi"));
                            data.setNama_naskah(jsonObject.getString("nama_naskah"));
                            data.setToken_surat(jsonObject.getString("token_surat"));
                            data.setPerihal_surat(jsonObject.getString("perihal_surat"));
                            data.setTgl_surat(jsonObject.getString("tgl_surat"));
                            data.setTgl_surat_masuk(jsonObject.getString("tgl_surat_masuk"));

                            data.setStatus_penerima(jsonObject.getString("status_penerima"));
                            data.setNo_surat_manual(jsonObject.getString("no_surat_manual"));

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
