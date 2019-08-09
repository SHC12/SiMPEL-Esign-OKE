package com.egov.win10.simpelv.fragment;

import android.content.Context;
import android.content.SharedPreferences;
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
import com.egov.win10.simpelv.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

    private String URL_KONSEP = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/model_konsep.php?id_user=";

    String URL_LENGKAP = "";

    String iduser;


    private LinearLayoutManager layoutManager;

    public String token_surat = "";
    public String nama_p = "";

    TextView jumlahSM, jumlahDM, jumlahDK, jumlahTTD, jabatan, message, logout;

    SharedPreferences sharedpreferences;
    private String URLLL = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/model_disposisi_keluar.php?id_user=";
    String id_userrrr = "";
    String URL_MODEL_DISPOSISI_KELUAR = "";


    private String URLS = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/model_signature.php?id_user=";
    private String URL_SIGNATURE = "";


    private String URLL = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/model_disposisi_masuk.php?id_user=";
    private String id_userrr = "";
    private String url_disposisi_masuk = "";

    private String token_disposisi = "";
    public String id_surat;
    String pesan, jab, id_groups, id_instansi;
    public RecyclerView rv;
    public CardView cvSM;
    public CardView cvDM;
    public CardView cvDK;
    private LinearLayoutManager linearLayoutManager;
    View view;
    private TextView hidden;
    SharedPreferences sharedPreferences;

    public FragmentHome() {
    }





    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);

        message = (TextView)view.findViewById(R.id.tvNama);

/*
        jumlahSM = (TextView)view.findViewById(R.id.jumlah_suratmasuk);
        jumlahDM = (TextView)view.findViewById(R.id.jumlah_disposisimasuk);
        jumlahDK = (TextView)view.findViewById(R.id.jumlah_disposisikeluar);
        jumlahTTD = (TextView)view.findViewById(R.id.jumlah_TTD);

        jabatan = (TextView)view.findViewById(R.id.tvJabatan);


        cvSM = (CardView)view.findViewById(R.id.cvSuratMasuk);
        cvDM = (CardView)view.findViewById(R.id.cvDisposisiMasuk);
        cvDK = (CardView)view.findViewById(R.id.cvSuratDisposisiKeluar);

        cvSM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/



        id_userrrr = getActivity().getIntent().getStringExtra("id_user");
        URL_MODEL_DISPOSISI_KELUAR = URLLL + id_userrrr;

        pesan = getActivity().getIntent().getStringExtra("message");
        jab = getActivity().getIntent().getStringExtra("nama_instansi");
        id_groups = getActivity().getIntent().getStringExtra("id_groups");
        id_instansi = getActivity().getIntent().getStringExtra("id_instansi");

        URL_SIGNATURE = URLS+id_userrrr+"&id_instansi="+id_instansi;
      //  Toast.makeText(getActivity(), ""+URL_SIGNATURE, Toast.LENGTH_SHORT).show();


        iduser = getActivity().getIntent().getStringExtra("id_user");
        URL_LENGKAP = "http://simpel.pasamanbaratkab.go.id/api_android/simaya/model_konsep.php?id_user="+iduser+"&id_instansi="+id_instansi+"&id_groups="+id_groups;


       // Toast.makeText(getActivity(), ""+URL_LENGKAP, Toast.LENGTH_SHORT).show();

        message.setText(pesan);
       // jabatan.setText(jab);
        id_userr = getActivity().getIntent().getStringExtra("id_user");
        url_surat_masuk = URL + id_userr;

        id_userrr = getActivity().getIntent().getStringExtra("id_user");
        url_disposisi_masuk = URLL + id_userrr;

        SharedPreferences mSettings = getActivity().getSharedPreferences("Settings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString("pesan", pesan);
        editor.putString("id_groups", id_groups);
        editor.putString("id_instansii", id_instansi);
        //editor.putInt("id", id);
        editor.apply();


       // AmbilDataSuratMaSuk();
     //   AmbilDataDisposisiMasuk();
//        AmbilDataModelDK();
      //  AmbilDataModelSignature();
      //  AmbilDataModelKonsep();
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

                    jumlahSM.setText("SURAT MASUK : 0 ");
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

                int count = 0;
                count = response.length();

                if (response.length() > 0 ) {
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
                }else if(response.length() == 0){
                   // hidden.setVisibility(View.VISIBLE);
                    jumlahDM.setText("DISPOSISI MASUK : 0 ");
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
                }else{
                    jumlahDK.setText("DISPOSISI KELUAR : 0");

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(getActivity()).add(jsonArrayRequest);
    }
    private void AmbilDataModelKonsep() {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL_LENGKAP, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                if (response.length() > 0) {
                    for (int i = 0; i < response.length(); i++) {
                        try {

                            JSONObject jsonObject = response.getJSONObject(i);
                            int total = response.length();
                            String totals = String.valueOf(total);
                            jumlahDK.setText("KONSEP: " + totals.toString());
                           // Toast.makeText(getActivity(), ""+totals.toString(), Toast.LENGTH_SHORT).show();



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }else{
                    jumlahDK.setText("KONSEP : 0");

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(getActivity()).add(jsonArrayRequest);
    }
    private void AmbilDataModelSignature() {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL_SIGNATURE, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                if (response.length() > 0) {
                    for (int i = 0; i < response.length(); i++) {
                        try {


                            JSONObject jsonObject = response.getJSONObject(i);
                            int total = response.length();
                            String totals = String.valueOf(total);
                            jumlahTTD.setText("Tanda Tangan Surat : " + totals.toString());
                            // Toast.makeText(getActivity(), ""+totals.toString(), Toast.LENGTH_SHORT).show();





/*
                            Intent intent = new Intent(getActivity().getBaseContext(), DetailDisposisiMasuk.class);
                            intent.putExtra("id_surat", id_surat);
                            getActivity().startActivity(intent);

*/






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
