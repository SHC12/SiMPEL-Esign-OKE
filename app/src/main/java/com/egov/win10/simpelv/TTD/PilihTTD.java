package com.egov.win10.simpelv.TTD;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.egov.win10.simpelv.DetailSignature;
import com.egov.win10.simpelv.R;

public class PilihTTD extends AppCompatActivity {


    public static final String PREFS_NAME = "MyPrefsFile";


    String NIK;

    String id_surat = "";
    String token_surat = "";
    String nama_tujuan;
    String nama_pengirim = "";
    String judul_surat = "";
    String nomor_surat = "";
    String agenda_nomor_surat_keluar = "";
    String tgl_surat = "";
    String jenis_nota_dinas = "";

    String username = "";
    String id_instansi = "";

    String tgl_surat_format;
    String tembusan;

    Button btnTTE;
    Button btnNonTTE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_ttd);



        id_surat = getIntent().getStringExtra("id_surat");
        token_surat = getIntent().getStringExtra("token_surat");
        nama_tujuan = getIntent().getStringExtra("nama_tujuan");
        nama_pengirim = getIntent().getStringExtra("nama_pengirim");
        judul_surat = getIntent().getStringExtra("judul_surat");
        id_instansi = getIntent().getStringExtra("id_instansi");
        nomor_surat = getIntent().getStringExtra("nomor_surat");
        agenda_nomor_surat_keluar = getIntent().getStringExtra("no_agenda_surat_keluar");
        tgl_surat = getIntent().getStringExtra("tanggal_surat");
        jenis_nota_dinas = getIntent().getStringExtra("jenis_nota_dinas");
        tgl_surat_format = getIntent().getStringExtra("tanggal_surat_format");
        tembusan = getIntent().getStringExtra("nama_tembusan");



        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        NIK = settings.getString("nik", "default");

        btnTTE = (Button) findViewById(R.id.btnTTE);
        btnNonTTE = (Button) findViewById(R.id.btnNonTTE);


        btnTTE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(NIK.equals("null")){
                    Toast.makeText(PilihTTD.this, "Anda Belum Memiliki Sertifikat Tanda Tangan Digital", Toast.LENGTH_SHORT).show();
                }else{



                Intent intent = new Intent(getApplicationContext(), PassPhrase.class);
                intent.putExtra("nama_tujuan", nama_tujuan);
                intent.putExtra("nama_pengirim", nama_pengirim);
                intent.putExtra("judul_surat", judul_surat);
                intent.putExtra("nomor_surat", nomor_surat);
                intent.putExtra("no_agenda_surat_keluar", agenda_nomor_surat_keluar);
                intent.putExtra("tanggal_surat", tgl_surat);
                intent.putExtra("tanggal_surat_format", tgl_surat_format);
                intent.putExtra("jenis_nota_dinas", jenis_nota_dinas);

                intent.putExtra("jenisTTD", "TTE");
                intent.putExtra("nama_tembusan", tembusan);





                intent.putExtra("id_surat", id_surat);
                intent.putExtra("id_instansi", id_instansi);
                intent.putExtra("token_surat", token_surat);

                startActivity(intent);
                }

                //Toast.makeText(PilihTTD.this, "id surat : "+id_surat+"\ntoken surat : "+token_surat+"\n nama tujuan : "+nama_tujuan+"\nnama pengirim : "+nama_pengirim+"\njudul_surat : "+judul_surat+"\nid_instansi : "+id_instansi+"\nnomor surat : "+nomor_surat+"\nagenda_surat : "+agenda_nomor_surat_keluar+"\ntgl surat : "+tgl_surat+"\njenis nota dians : "+jenis_nota_dinas+"\ntgl surat format : "+tgl_surat_format+"\ntembusan  : "+tembusan, Toast.LENGTH_SHORT).show();
            }
        });

        btnNonTTE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), DetailSignature.class);
                intent.putExtra("nama_tujuan", nama_tujuan);
                intent.putExtra("nama_pengirim", nama_pengirim);
                intent.putExtra("judul_surat", judul_surat);
                intent.putExtra("nomor_surat", nomor_surat);
                intent.putExtra("no_agenda_surat_keluar", agenda_nomor_surat_keluar);
                intent.putExtra("tanggal_surat", tgl_surat);
                intent.putExtra("tanggal_surat_format", tgl_surat_format);
                intent.putExtra("jenis_nota_dinas", jenis_nota_dinas);
                intent.putExtra("jenisTTD", "NONTTE");


                intent.putExtra("nama_tembusan", tembusan);





                intent.putExtra("id_surat", id_surat);
                intent.putExtra("id_instansi", id_instansi);
                intent.putExtra("token_surat", token_surat);

                startActivity(intent);

            }
        });





    }




}
