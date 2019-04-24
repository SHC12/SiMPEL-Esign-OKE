package com.example.win10.simpelv.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.win10.simpelv.R;

/**
 * Created by win10 on 15/03/2019.
 */

public class FragmentSuratKeluar extends Fragment {

    View view;
    public FragmentSuratKeluar() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.suratkeluar_fragment, container, false);

        return view;
    }
}
