package com.example.win10.simpelv.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.win10.simpelv.Login;
import com.example.win10.simpelv.R;

/**
 * Created by win10 on 15/03/2019.
 */

public class FragmentPersonal extends Fragment {


    Button btnLogout;
    public FragmentPersonal() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.personal_fragment, container, false);


        btnLogout = (Button)view.findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Login.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
