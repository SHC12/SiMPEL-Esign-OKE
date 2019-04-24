package com.example.win10.simpelv.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.win10.simpelv.DetailDisposisiMasuk;
import com.example.win10.simpelv.R;
import com.example.win10.simpelv.data.DataDisposisiMasuk;

import java.util.ArrayList;

/**
 * Created by win10 on 20/03/2019.
 */

public class AdapterDisposisiMasuk extends RecyclerView.Adapter<AdapterDisposisiMasuk.ViewHolder> {
    private ArrayList<DataDisposisiMasuk> listDataDisposisiMasuk;
    private Activity activity;
    private Context context;

    public int data;

    public AdapterDisposisiMasuk(ArrayList<DataDisposisiMasuk> listDataDisposisiMasuk, Activity activity) {
        this.listDataDisposisiMasuk = listDataDisposisiMasuk;
        this.activity = activity;
    }


    @Override
    public AdapterDisposisiMasuk.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_disposisi_masuk, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(AdapterDisposisiMasuk.ViewHolder holder, int position) {


        holder.tvNo.setText(listDataDisposisiMasuk.get(position).getNo());
        holder.tvPerihalSurat.setText(listDataDisposisiMasuk.get(position).getPerihal_surat());
        holder.tvTglSurat.setText(listDataDisposisiMasuk.get(position).getTgl_surat());
        holder.tvNama_pengirim_disposisi.setText(listDataDisposisiMasuk.get(position).getNama_pengirim_disposisi());
        holder.tvStatusPenerima.setText(listDataDisposisiMasuk.get(position).getNama_status_penerima());
        holder.token_disposisi = (listDataDisposisiMasuk.get(position).getToken_disposisi());
        holder.id_surat = (listDataDisposisiMasuk.get(position).getId_surat());
        holder.no_surat = (listDataDisposisiMasuk.get(position).getNo_surat_manual());

    }


    public void jumlahData(){

        data = listDataDisposisiMasuk.size();
    }

    @Override
    public int getItemCount() {
        return listDataDisposisiMasuk.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cv;
        public TextView tvNo;
        public TextView tvIdUser;
        public TextView tvIdSurat;
        public TextView tvTokenDisposisiMasuk;
        public TextView tvPerihalSurat;
        public TextView tvTglSurat;
        public TextView tvNama_pengirim_disposisi;
        public TextView tvStatusPenerima;
        public TextView tvNoSuratManual;
        private RelativeLayout itemList;

        private String token_disposisi;
        private String id_surat, no_surat;
        private Context context;
        public ViewHolder(View itemView) {
            super(itemView);

           context = itemView.getContext();







            tvNo = (TextView)itemView.findViewById(R.id.textview_hasil_no_disposisi_masuk);
            tvPerihalSurat = (TextView)itemView.findViewById(R.id.textview_hasil_perihal_surat_disposisi_masuk);
            tvTglSurat = (TextView)itemView.findViewById(R.id.textview_hasil_tanggal_surat_disposisi_masuk);
            tvNama_pengirim_disposisi = (TextView)itemView.findViewById(R.id.textview_hasil_nama_pengirim_disposisi_masuk);
            tvStatusPenerima = (TextView)itemView.findViewById(R.id.textview_hasil_nama_status_penerima);
           itemList = (RelativeLayout) itemView.findViewById(R.id.item_list);
            itemList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    switch (getAdapterPosition()){
                        case 0:
                            intent = new Intent(context, DetailDisposisiMasuk.class);

                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 1:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 2:
                            intent = new Intent(context, DetailDisposisiMasuk.class);

                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 3:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 4:
                            intent = new Intent(context, DetailDisposisiMasuk.class);

                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 5:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 6:
                            intent = new Intent(context, DetailDisposisiMasuk.class);

                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 7:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                    }
                    context.startActivity(intent);
                }
            });


        }
    }
}
