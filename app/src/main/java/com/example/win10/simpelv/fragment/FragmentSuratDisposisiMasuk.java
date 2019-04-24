package com.example.win10.simpelv.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.support.v7.widget.CardView;
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
import com.example.win10.simpelv.R;
import com.example.win10.simpelv.adapter.AdapterDisposisiMasuk;
import com.example.win10.simpelv.data.DataDisposisiMasuk;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by win10 on 18/03/2019.
 */

public class FragmentSuratDisposisiMasuk extends Fragment {

    private String URL = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/model_disposisi_masuk.php?id_user=";
    private String id_userr = "";
    private String url_disposisi_masuk = "";
    private AdapterDisposisiMasuk mAdapter;
    private ProgressDialog progressDialog;
    private ArrayList<DataDisposisiMasuk> listData;
    private String token_disposisi = "";
    public String id_surat;
    public RecyclerView rv;
    public CardView cv;
    private LinearLayoutManager linearLayoutManager;
    View view;
    private TextView hidden;



    public FragmentSuratDisposisiMasuk() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.suratdisposisimasuk_fragment, container, false);


        rv = (RecyclerView)view.findViewById(R.id.rvDisposisiMasuk);
        rv.setHasFixedSize(true);
        rv.setVisibility(View.GONE);
        hidden = (TextView)view.findViewById(R.id.tvDataKosong);

        id_userr = getActivity().getIntent().getStringExtra("id_user");
        url_disposisi_masuk = URL + id_userr;
        linearLayoutManager = new LinearLayoutManager(getActivity());
        //layoutManager.setOrientation(GridLayoutManager.VERTICAL);
        rv.setLayoutManager(linearLayoutManager);
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        //setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        //id_user = (TextView) view.findViewById(R.id.);




        listData = new ArrayList<DataDisposisiMasuk>();
        AmbilData();
        mAdapter = new AdapterDisposisiMasuk(listData, getActivity());
        rv.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();




        return view;


    }

    private void AmbilData(){

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url_disposisi_masuk, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                if (response.length() > 0) {
                    for (int i = 0; i < response.length(); i++) {
                        try {

                            JSONObject jsonObject = response.getJSONObject(i);

                            token_disposisi = jsonObject.getString("token_disposisi");
                            DataDisposisiMasuk data = new DataDisposisiMasuk();
                            data.setNo(jsonObject.getString("no"));
                            data.setId_user(jsonObject.getString("id_user"));
                            data.setId_surat(jsonObject.getString("id_surat"));
                            data.setToken_disposisi(jsonObject.getString("token_disposisi"));
                            data.setId_disposisi_masuk(jsonObject.getString("id_disposisi_masuk"));
                            data.setTgl_surat(jsonObject.getString("tgl_surat"));
                            data.setNo_surat_manual(jsonObject.getString("no_surat_manual"));
                            data.setPerihal_surat(jsonObject.getString("perihal_surat"));
                            data.setNama_pengirim_disposisi(jsonObject.getString("nama_pengirim_disposisi"));
                            data.setStatus_dis(jsonObject.getString("status_dis"));
                            data.setNama_status_penerima(jsonObject.getString("nama_status_penerima"));
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
                    hidden.setVisibility(View.VISIBLE);
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
