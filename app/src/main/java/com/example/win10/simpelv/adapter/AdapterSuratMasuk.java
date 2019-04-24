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


import com.example.win10.simpelv.DetailSuratMasuk;
import com.example.win10.simpelv.R;
import com.example.win10.simpelv.data.DataSuratMasuk;

import java.util.ArrayList;

/**
 * Created by win10 on 20/03/2019.
 */


public class AdapterSuratMasuk extends RecyclerView.Adapter<AdapterSuratMasuk.ViewHolder> {
    private ArrayList<DataSuratMasuk> listData;
    private Activity activity;
    private Context context;

    public AdapterSuratMasuk(ArrayList<DataSuratMasuk> listData, Activity activity) {
        this.listData = listData;
        this.activity = activity;
    }

    @Override
    public AdapterSuratMasuk.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_surat_masuk, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(AdapterSuratMasuk.ViewHolder holder, int position) {
        holder.tvNo.setText(listData.get(position).getNo());
//        holder.tvPerihalSurat.setText(listData.get(position).getPerihal_surat());
        holder.tvTglSurat.setText(listData.get(position).getTgl_surat());
//        holder.tvNama_pengirim.setText(listData.get(position).getNama_pengirim());
        holder.tvStatusPenerima.setText(listData.get(position).getStatus_penerima());
        holder.tvNoSurat.setText(listData.get(position).getNo_surat_manual());
        holder.tvTanggalSurat.setText(listData.get(position).getTgl_surat());
        holder.token_surat_SM = (listData.get(position).getToken_surat());
        holder.tvPerihal.setText(listData.get(position).getPerihal_surat());
        holder.perihal_surat = (listData.get(position).getPerihal_surat());
        holder.no_surat_SM = (listData.get(position).getNo_surat_manual());
        holder.pass_id_surat = (listData.get(position).getId_surat());



    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cv;
        public TextView tvNo;
        public TextView tvIdSurat;
        public TextView tvTanggalSurat;
        public TextView tvPerihalSurat;
        public TextView tvTglSurat;
        public TextView tvNoSurat;
        public TextView tvNama_pengirim;
        private RelativeLayout itemListSM;
        public Context context;
        public TextView tvStatusPenerima;
        public TextView tvPerihal;
        public String token_surat_SM;
        public String no_surat_SM;
        public String perihal_surat;
        public String pass_id_surat;
        public ViewHolder(View v) {
            super(v);
            context = itemView.getContext();
            cv=(CardView)v.findViewById(R.id.cvSuratMasuk);
            tvNo = (TextView) itemView.findViewById(R.id.textview_hasil_no);
            tvTanggalSurat = (TextView) itemView.findViewById(R.id.textview_hasil_tanggal_surat);
            tvNoSurat = (TextView) itemView.findViewById(R.id.textview_hasil_no_surat_masuk);
            tvTglSurat = (TextView) itemView.findViewById(R.id.textview_hasil_tanggal_surat);
           // tvNama_pengirim = (TextView) itemView.findViewById(R.id.textview_hasil_nama_pengirim);
            tvStatusPenerima = (TextView) itemView.findViewById(R.id.textview_hasil_status_surat_masuk);
            tvPerihal = (TextView) itemView.findViewById(R.id.textview_hasil_perihal_surat_masuk);
            itemListSM = (RelativeLayout) itemView.findViewById(R.id.item_list_surat_masuk);
            itemListSM.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    switch (getAdapterPosition()){
                        case 0:
                            intent = new Intent(context, DetailSuratMasuk.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);

                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 1:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                             intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            break;
                        case 2:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            break;
                        case 3:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("perihal_surat", perihal_surat);
                            break;
                        case 4:
                            intent = new Intent(context, DetailSuratMasuk.class);

                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            break;
                        case 5:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            break;
                        case 6:
                            intent = new Intent(context, DetailSuratMasuk.class);

                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            break;
                        case 7:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            break;
                    }
                    context.startActivity(intent);
                }
            });
        }
    }

}
