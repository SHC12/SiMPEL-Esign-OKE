package com.example.win10.simpelv.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.win10.simpelv.R;
import com.example.win10.simpelv.adapter.AdapterDisposisiKeluar;
import com.example.win10.simpelv.adapter.AdapterDisposisiMasuk;
import com.example.win10.simpelv.data.DataDisposisiKeluar;
import com.example.win10.simpelv.data.DataDisposisiMasuk;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by win10 on 15/03/2019.
 */

public class FragmentSuratKeluar extends Fragment {

    private String URL = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/model_disposisi_keluar_new.php?id_user=";
    String id_user = "";
    String URL_MODEL_DISPOSISI_KELUAR = "";


    TextView textViewSK;

    private LinearLayoutManager linearLayoutManager;
    private AdapterDisposisiKeluar mAdapter;
    private ProgressDialog progressDialog;
    private ArrayList<DataDisposisiKeluar> listData;
    public RecyclerView rv;

    View view;
    public FragmentSuratKeluar() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.suratkeluar_fragment, container, false);



        SharedPreferences mSettings = getActivity().getSharedPreferences("Settings", Context.MODE_PRIVATE);
        String cookieName = mSettings.getString("pesan", "missing");

        textViewSK = (TextView)view.findViewById(R.id.tvNamaDK);

        textViewSK.setText(cookieName);

        rv = (RecyclerView)view.findViewById(R.id.rvSuratKeluar);
        rv.setHasFixedSize(true);
        rv.setVisibility(View.GONE);

        id_user = getActivity().getIntent().getStringExtra("id_user");
        URL_MODEL_DISPOSISI_KELUAR = URL + id_user;

        linearLayoutManager = new LinearLayoutManager(getActivity());
        //layoutManager.setOrientation(GridLayoutManager.VERTICAL);
        rv.setLayoutManager(linearLayoutManager);
        progressDialog = new ProgressDialog(getActivity());
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


        listData = new ArrayList<DataDisposisiKeluar>();
        AmbilDataModelDK();
        mAdapter = new AdapterDisposisiKeluar(listData, getActivity());
        rv.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();




        return view;
    }


    private void AmbilDataModelDK(){

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL_MODEL_DISPOSISI_KELUAR, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                if (response.length() > 0) {
                    for (int i = 0; i < response.length(); i++) {
                        try {

                            JSONObject jsonObject = response.getJSONObject(i);


                            DataDisposisiKeluar data = new DataDisposisiKeluar();
                            data.setNo(jsonObject.getString("no"));
                            data.setId_disposisi(jsonObject.getString("id_disposisi"));
                            data.setTgl_surat(jsonObject.getString("tgl_surat"));
                            data.setId_surat(jsonObject.getString("id_surat"));
                            data.setTgl_disposisi(jsonObject.getString("tgl_disposisi"));
                            data.setPerihal_surat(jsonObject.getString("perihal_surat"));
                            data.setNama_penerima_disposisi(jsonObject.getString("nama_penerima_disposisi"));
                            data.setNo_surat_manual(jsonObject.getString("no_surat_manual"));
                            data.setToken_disposisi(jsonObject.getString("token_disposisi"));
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

        Volley.newRequestQueue(getActivity()).add(jsonArrayRequest);
    }
}
