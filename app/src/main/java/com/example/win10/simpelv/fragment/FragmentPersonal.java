package com.example.win10.simpelv.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.win10.simpelv.Login;
import com.example.win10.simpelv.MainActivity;
import com.example.win10.simpelv.R;

/**
 * Created by win10 on 15/03/2019.
 */

public class FragmentPersonal extends Fragment {

    public static final String PREFS_NAME = "MyPrefsFile";

    SharedPreferences settings;

    Button btnLogout;
    TextView txtPesanPersonal;
    public FragmentPersonal() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.personal_fragment, container, false);


        SharedPreferences mSettings = getActivity().getSharedPreferences("Settings", Context.MODE_PRIVATE);
        String cookieName = mSettings.getString("pesan", "missing");


        txtPesanPersonal = (TextView)  view.findViewById(R.id.tvNamaPersonal);

        txtPesanPersonal.setText(cookieName);

        btnLogout = (Button)view.findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Keluar");
                builder.setMessage("Ingin Keluar Aplikasi SiMPEL ??");
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        getActivity().moveTaskToBack(true);
                        getActivity().finish();

                    }
                }).setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });
        return view;


    }
}
