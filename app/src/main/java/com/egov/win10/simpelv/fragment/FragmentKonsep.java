package com.egov.win10.simpelv.fragment;

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

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.egov.win10.simpelv.R;
import com.egov.win10.simpelv.adapter.AdapterKonsep;
import com.egov.win10.simpelv.data.DataKonsep;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by win10 on 19/06/2019.
 */

public class FragmentKonsep extends Fragment {

    private String URL = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/model_konsep.php?id_user=";
    String id_instansi = "id_instansi";
    String id_groups = "";
    String id_user = "";
    String URL_MODEL_DISPOSISI_KELUAR = "";

    String URL_LENGKAP = "";

    TextView textViewSK;

    private LinearLayoutManager linearLayoutManager;
    private AdapterKonsep mAdapter;
    private ProgressDialog progressDialog;
    private ArrayList<DataKonsep> listData;
    public RecyclerView rv;

    View view;


    public FragmentKonsep() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.konsep_fragment, container, false);

        SharedPreferences mSettings = getActivity().getSharedPreferences("Settings", Context.MODE_PRIVATE);
        String cookieName = mSettings.getString("pesan", "missing");
        
        id_instansi = mSettings.getString("id_instansii", "missing");
        id_groups = mSettings.getString("id_groups", "missing");


        textViewSK = (TextView)view.findViewById(R.id.tvNamaKonsep);


        textViewSK.setText(cookieName);

        rv = (RecyclerView)view.findViewById(R.id.rvKonsep);
        rv.setHasFixedSize(true);
        rv.setVisibility(View.GONE);

        id_user = getActivity().getIntent().getStringExtra("id_user");
        URL_LENGKAP = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/model_konsep.php?id_user="+id_user+"&id_instansi="+id_instansi+"&id_groups="+id_groups;
      //  Toast.makeText(getActivity(), " "+URL_LENGKAP, Toast.LENGTH_SHORT).show();
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


        listData = new ArrayList<DataKonsep>();
       AmbilDataModelKonsep();
        mAdapter = new AdapterKonsep(listData, getActivity());
        rv.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();



        return view;
    }

    private void AmbilDataModelKonsep() {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL_LENGKAP, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                if (response.length() > 0) {
                    for (int i = 0; i < response.length(); i++) {
                        try {

                            JSONObject jsonObject = response.getJSONObject(i);


                            DataKonsep data = new DataKonsep();
                            data.setNo(jsonObject.getString("no"));
                            data.setId_surat(jsonObject.getString("id_surat"));
                            data.setUrutan_pemeriksa(jsonObject.getString("urutan_pemeriksa"));
                            data.setId_user_pemeriksa(jsonObject.getString("id_user_pemeriksa"));
                            data.setId_user_pemeriksa_konsep(jsonObject.getString("id_user_pemeriksa_konsep"));
                            data.setId_user_pemeriksa_tolak(jsonObject.getString("id_user_pemeriksa_tolak"));
                            data.setSurat_title(jsonObject.getString("surat_title"));
                            data.setSurat_name(jsonObject.getString("surat_name"));
                            data.setSurat_link(jsonObject.getString("surat_link"));
                            data.setStatus_surat(jsonObject.getString("status_surat"));
                            data.setId_naskah(jsonObject.getString("id_naskah"));
                            data.setToken_surat(jsonObject.getString("token_surat"));
                            data.setUser_pemeriksa(jsonObject.getString("user_pemeriksa"));
                            data.setAtas_nama(jsonObject.getString("atas_nama"));
                            data.setPerihal_surat(jsonObject.getString("perihal_surat"));
                            data.setNama_naskah(jsonObject.getString("nama_naskah"));
                            data.setTgl_surat(jsonObject.getString("tgl_surat"));
                            data.setId_atas_nama(jsonObject.getString("id_atas_nama"));
                            data.setTgl_surat_format(jsonObject.getString("tgl_surat_format"));
                            data.setId_tembusan(jsonObject.getString("id_user_tembusan"));
                            data.setNama_tembusan(jsonObject.getString("nama_user_tembusan"));


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

        Volley.newRequestQueue(getActivity()).add(jsonArrayRequest);
    }

}
