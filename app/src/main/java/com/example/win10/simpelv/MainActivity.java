package com.example.win10.simpelv;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.win10.simpelv.fragment.FragmentHome;
import com.example.win10.simpelv.fragment.FragmentPersonal;
import com.example.win10.simpelv.fragment.FragmentSuratDisposisiMasuk;
import com.example.win10.simpelv.fragment.FragmentSuratKeluar;
import com.example.win10.simpelv.fragment.FragmentSuratMasuk;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment (new FragmentHome());

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bn_main);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
      /*  bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home :
                        Toast.makeText(MainActivity.this, "Home clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_surat_masuk :
                        Toast.makeText(MainActivity.this, "Star clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_disposisi_masuk :
                        Toast.makeText(MainActivity.this, "Money clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_disposisi_keluar :
                        Toast.makeText(MainActivity.this, "Star clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_personal :
                        Toast.makeText(MainActivity.this, "Money clicked", Toast.LENGTH_SHORT).show();
                        break;
                }

                return true;
            }
        });*/

    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
            return true;
        }

        return false;
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.home_menu:
                fragment = new FragmentHome();
                break;
            case R.id.suratmasuk_menu:
                fragment = new FragmentSuratMasuk();
                break;
            case R.id.disposisimasuk_menu:
                fragment = new FragmentSuratDisposisiMasuk();
                break;
            case R.id.disposisikeluar_menu:
                fragment = new FragmentSuratKeluar();
                break;
            case R.id.personal_menu:
                fragment = new FragmentPersonal();
                break;

        }
        return loadFragment(fragment);
    }
}