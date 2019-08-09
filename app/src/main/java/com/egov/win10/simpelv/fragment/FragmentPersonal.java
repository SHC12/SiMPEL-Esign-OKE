package com.egov.win10.simpelv.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.egov.win10.simpelv.R;
import com.egov.win10.simpelv.adapter.AdapterSignature;
import com.egov.win10.simpelv.data.DataSignature;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by win10 on 15/03/2019.
 */

public class FragmentPersonal extends Fragment {


    private String URL = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/model_signature.php?id_user=";
    private String URL_SIGNATURE = "";
    String id_user = "";
    String id_instansi = "";
    String id_jenjang_jabatan = "";
    public static final String PREFS_NAME = "MyPrefsFile";

    SharedPreferences settings;

    Button btnLogout;
    TextView txtPesanPersonal;


    private LinearLayoutManager linearLayoutManager;
    private AdapterSignature mAdapter;
    private ProgressDialog progressDialog;
    private ArrayList<DataSignature> listData;
    public RecyclerView rv;

    View view;



    public FragmentPersonal() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.personal_fragment, container, false);




        rv = (RecyclerView)view.findViewById(R.id.rvSignature);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        rv.setHasFixedSize(true);
        rv.setVisibility(View.GONE);
        rv.setLayoutManager(linearLayoutManager);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Mohon Tunggu....");
        progressDialog.show();

        SharedPreferences mSettings = getActivity().getSharedPreferences("Settings", Context.MODE_PRIVATE);

        SharedPreferences settings = getActivity().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        id_user = settings.getString("id_user", "default");
        id_instansi = settings.getString("id_instansi", "default");
        id_jenjang_jabatan = settings.getString("id_jenjang_jabatan", "default");

        //URL_SIGNATURE = URL+id_user+"&id_instansi="+id_instansi+"&id_jenjang_jabatan="+id_jenjang_jabatan;
        URL_SIGNATURE = URL+id_user+"&id_instansi="+id_instansi;


      //  Toast.makeText(getActivity(), ""+URL_SIGNATURE, Toast.LENGTH_SHORT).show();


        String cookieName = mSettings.getString("pesan", "missing");


        listData = new ArrayList<DataSignature>();
        AmbilDataModelSignature();

        mAdapter = new AdapterSignature(listData, getActivity());
        rv.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();


        txtPesanPersonal = (TextView)  view.findViewById(R.id.tvNamaPersonal);

        txtPesanPersonal.setText(cookieName);

        return view;



    }

    private void AmbilDataModelSignature() {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL_SIGNATURE, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                if (response.length() > 0) {
                    for (int i = 0; i < response.length(); i++) {
                        try {

                            JSONObject jsonObject = response.getJSONObject(i);


                            DataSignature data = new DataSignature();
                            data.setNo(jsonObject.getString("no"));
                            data.setToken_surat(jsonObject.getString("token_surat"));
                            data.setStatus_surat(jsonObject.getString("status_surat"));
                            data.setId_surat(jsonObject.getString("id_surat"));
                            data.setId_tujuan(jsonObject.getString("id_tujuan"));
                            data.setId_instansi(jsonObject.getString("id_instansi"));
                            data.setNama_tujuan(jsonObject.getString("nama_tujuan"));
                            data.setNama_pengirim(jsonObject.getString("nama_pengirim"));
                            data.setNomor_surat(jsonObject.getString("nomor_surat"));
                            data.setNo_agenda_keluar(jsonObject.getString("no_agenda_keluar"));
                            data.setTgl_surat_keluar(jsonObject.getString("tgl_surat_keluar"));
                            data.setNama_naskah(jsonObject.getString("nama_naskah"));
                            data.setNama_status_surat(jsonObject.getString("nama_status_surat"));
                            data.setId_naskah(jsonObject.getString("id_naskah"));
                            data.setAtas_nama(jsonObject.getString("atas_nama"));
                            data.setPerihal_surat(jsonObject.getString("perihal_surat"));
                            data.setTgl_surat(jsonObject.getString("tgl_surat"));
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

        Volley.newRequestQueue(getActivity()).add(jsonArrayRequest);
    }
}
