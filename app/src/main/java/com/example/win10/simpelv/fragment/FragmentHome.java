package com.example.win10.simpelv.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.win10.simpelv.R;
import com.example.win10.simpelv.adapter.AdapterDisposisiMasuk;
import com.example.win10.simpelv.adapter.AdapterSuratMasuk;
import com.example.win10.simpelv.data.DataDisposisiKeluar;
import com.example.win10.simpelv.data.DataDisposisiMasuk;
import com.example.win10.simpelv.data.DataSuratMasuk;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by win10 on 15/03/2019.
 */

public class FragmentHome extends Fragment {
    private String URL = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/model_surat_masuk_new.php?id_user=";
    private String URL_DETAIL_SURAT_MASUK = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/model_detail_surat_masuk.php?token_surat=";
    private String id_userr = "";
    private String url_surat_masuk = "";
    private String url_detail_surat_masuk = "";

    public static final String PREFS_NAME = "MyPrefsFile";

    private LinearLayoutManager layoutManager;

    public String token_surat = "";
    public String nama_p = "";

    TextView jumlahSM, jumlahDM, jumlahDK, jabatan, message;

    SharedPreferences sharedpreferences;
    private String URLLL = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/model_disposisi_keluar.php?id_user=";
    String id_userrrr = "";
    String URL_MODEL_DISPOSISI_KELUAR = "";



    private String URLL = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/model_disposisi_masuk.php?id_user=";
    private String id_userrr = "";
    private String url_disposisi_masuk = "";

    private String token_disposisi = "";
    public String id_surat;
    String pesan, jab;
    public RecyclerView rv;
    public CardView cvSM;
    public CardView cvDM;
    public CardView cvDK;
    private LinearLayoutManager linearLayoutManager;
    View view;
    private TextView hidden;
    public FragmentHome() {
    }





    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);


        jumlahSM = (TextView)view.findViewById(R.id.jumlah_suratmasuk);
        jumlahDM = (TextView)view.findViewById(R.id.jumlah_disposisimasuk);
        jumlahDK = (TextView)view.findViewById(R.id.jumlah_disposisikeluar);
        message = (TextView)view.findViewById(R.id.tvNama);
        jabatan = (TextView)view.findViewById(R.id.tvJabatan);
        cvSM = (CardView)view.findViewById(R.id.cvSuratMasuk);
        cvDM = (CardView)view.findViewById(R.id.cvDisposisiMasuk);
        cvDK = (CardView)view.findViewById(R.id.cvSuratDisposisiKeluar);





        id_userrrr = getActivity().getIntent().getStringExtra("id_user");
        URL_MODEL_DISPOSISI_KELUAR = URLLL + id_userrrr;

        pesan = getActivity().getIntent().getStringExtra("message");
        jab = getActivity().getIntent().getStringExtra("nama_instansi");

        message.setText(pesan);
        jabatan.setText(jab);
        id_userr = getActivity().getIntent().getStringExtra("id_user");
        url_surat_masuk = URL + id_userr;

        id_userrr = getActivity().getIntent().getStringExtra("id_user");
        url_disposisi_masuk = URLL + id_userrr;

        SharedPreferences mSettings = getActivity().getSharedPreferences("Settings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString("pesan", pesan);
        //editor.putInt("id", id);
        editor.apply();


        AmbilDataSuratMaSuk();
        AmbilDataDisposisiMasuk();
        AmbilDataModelDK();
        return view;
    }


    public void AmbilDataSuratMaSuk(){

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url_surat_masuk, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                int total = 0;
                String totals = "";
                if (response.length() > 0) {
                    for (int i = 0; i < response.length(); i++) {
                        try {


                            JSONObject jsonObject = response.getJSONObject(i);
                            total = response.length();
                            totals = String.valueOf(total);
                            jumlahSM.setText("SURAT MASUK : " + totals.toString());
                          //  Toast.makeText(getContext(), "Total " + totals, Toast.LENGTH_SHORT).show();


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }else {

                    jumlahSM.setText("SURAT MASUK : ");
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(getActivity()).add(jsonArrayRequest);
    }

    private void AmbilDataDisposisiMasuk(){

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url_disposisi_masuk, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                if (response.length() > 0) {
                    for (int i = 0; i < response.length(); i++) {
                        try {


                            JSONObject jsonObject = response.getJSONObject(i);
                            int total = response.length();
                            String totals = String.valueOf(total);
                            jumlahDM.setText("DISPOSISI MASUK : " + totals.toString());
                        //    Toast.makeText(getContext(), "Total " + totals, Toast.LENGTH_SHORT).show();







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
    private void AmbilDataModelDK(){

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL_MODEL_DISPOSISI_KELUAR, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                if (response.length() > 0) {
                    for (int i = 0; i < response.length(); i++) {
                        try {

                            JSONObject jsonObject = response.getJSONObject(i);
                            int total = response.length();
                            String totals = String.valueOf(total);
                            jumlahDK.setText("DISPOSISI KELUAR : " + totals.toString());




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
