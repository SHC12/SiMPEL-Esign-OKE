package com.egov.win10.simpelv.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.egov.win10.simpelv.DetailSuratMasuk;
import com.egov.win10.simpelv.R;
import com.egov.win10.simpelv.data.DataSuratMasuk;

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
        holder.tvNama_pengirim.setText(listData.get(position).getNama_pengirim());
        holder.tvStatusPenerima.setText(listData.get(position).getStatus_penerima());
        holder.tvNoSurat.setText(listData.get(position).getNo_surat_manual());
        holder.tvTanggalSurat.setText(listData.get(position).getTgl_surat());
        holder.token_surat_SM = (listData.get(position).getToken_surat());
        holder.tvPerihal.setText(listData.get(position).getPerihal_surat());
        holder.perihal_surat = (listData.get(position).getPerihal_surat());
        holder.no_surat_SM = (listData.get(position).getNo_surat_manual());
        holder.pass_id_surat = (listData.get(position).getId_surat());
        holder.tanggal_surat = (listData.get(position).getTgl_surat());
       // holder.token_disposisii = (listData.get(position).getToken_disposisi());
        holder.nama_naskah = (listData.get(position).getNama_naskah());
        holder.tanggal_surat_masuk = (listData.get(position).getTgl_surat_masuk());



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
        public String tanggal_surat;
        public String tanggal_surat_masuk;
        public String nama_naskah;
        public String token_disposisii;

        public ViewHolder(View v) {
            super(v);
            context = itemView.getContext();
           // cv=(CardView)v.findViewById(R.id.cvSuratMasuk);
            tvNo = (TextView) itemView.findViewById(R.id.textview_hasil_no);
            tvTanggalSurat = (TextView) itemView.findViewById(R.id.textview_hasil_tanggal_surat);
            tvNoSurat = (TextView) itemView.findViewById(R.id.textview_hasil_no_surat_masuk);
            tvTglSurat = (TextView) itemView.findViewById(R.id.textview_hasil_tanggal_surat);
            tvNama_pengirim = (TextView) itemView.findViewById(R.id.textview_hasil_nama_pengirim);
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
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 1:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                             intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            break;
                        case 2:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            break;
                        case 3:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("perihal_surat", perihal_surat);
                            break;
                        case 4:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            break;
                        case 5:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            break;
                        case 6:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
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
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            break;
                        case 8:
                            intent = new Intent(context, DetailSuratMasuk.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 9:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            break;
                        case 10:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            break;
                        case 11:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("perihal_surat", perihal_surat);
                            break;
                        case 12:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            break;
                        case 13:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            break;
                        case 14:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            break;
                        case 15:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            break;

                        case 16:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            break;
                        case 17:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            break;
                        case 18:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("perihal_surat", perihal_surat);
                            break;
                        case 19:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            break;
                        case 20:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            break;
                        case 21:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            break;
                        case 22:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            break;
                        case 23:
                            intent = new Intent(context, DetailSuratMasuk.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 24:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            break;
                        case 25:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            break;
                        case 26:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("perihal_surat", perihal_surat);
                            break;
                        case 27:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            break;
                        case 28:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            break;
                        case 29:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            break;
                        case 30:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            break;
                        case 31:
                            intent = new Intent(context, DetailSuratMasuk.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 32:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("nama_naskah", nama_naskah);
                            break;
                        case 33:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            break;
                        case 34:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("perihal_surat", perihal_surat);
                            break;
                        case 35:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("perihal_surat", perihal_surat);
                            break;
                        case 36:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            break;
                        case 37:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            break;
                        case 38:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            break;
                        case 39:
                            intent = new Intent(context, DetailSuratMasuk.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 40:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            break;
                        case 41:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            break;
                        case 42:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("perihal_surat", perihal_surat);
                            break;
                        case 43:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            break;
                        case 44:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            break;
                        case 45:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            break;
                        case 46:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            break;

                        case 47:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            break;
                        case 48:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            break;
                        case 49:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("perihal_surat", perihal_surat);
                            break;
                        case 50:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            break;
                        case 51:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            break;
                        case 52:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            break;
                        case 53:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            break;
                        case 54:
                            intent = new Intent(context, DetailSuratMasuk.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 55:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            break;
                        case 56:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            break;
                        case 57:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("perihal_surat", perihal_surat);
                            break;
                        case 58:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            break;
                        case 59:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            break;
                        case 60:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            break;
                        case 61:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            break;
                        case 62:
                            intent = new Intent(context, DetailSuratMasuk.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 63:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            break;
                        case 64:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            break;
                        case 65:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("perihal_surat", perihal_surat);
                            break;
                        case 66:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            break;
                        case 67:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            break;
                        case 68:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            break;
                        case 69:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            break;
                        case 70:
                            intent = new Intent(context, DetailSuratMasuk.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 71:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            break;
                        case 72:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            break;
                        case 73:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("perihal_surat", perihal_surat);
                            break;
                        case 74:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            break;
                        case 75:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            break;
                        case 76:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            break;
                        case 77:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            break;

                        case 78:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            break;
                        case 79:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            break;
                        case 80:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("perihal_surat", perihal_surat);
                            break;
                        case 81:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            break;
                        case 82:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            break;
                        case 83:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            break;
                        case 84:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            break;
                        case 85:
                            intent = new Intent(context, DetailSuratMasuk.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 86:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            break;
                        case 87:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            break;
                        case 88:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("perihal_surat", perihal_surat);
                            break;
                        case 89:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            break;
                        case 90:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            break;
                        case 91:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            break;
                        case 92:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            break;
                        case 93:
                            intent = new Intent(context, DetailSuratMasuk.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 94:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            break;
                        case 95:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            break;
                        case 96:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("perihal_surat", perihal_surat);
                            break;
                        case 97:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            break;
                        case 98:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            break;
                        case 99:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            break;
                        case 100:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            break;
                        case 101:
                            intent = new Intent(context, DetailSuratMasuk.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 102:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            break;
                        case 103:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            break;
                        case 104:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("perihal_surat", perihal_surat);
                            break;
                        case 105:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            break;
                        case 106:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            break;
                        case 107:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            break;
                        case 108:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            break;
                        case 109:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            break;
                        case 110:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            break;
                        case 111:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("perihal_surat", perihal_surat);
                            break;
                        case 112:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            break;
                        case 113:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            break;
                        case 114:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            break;
                        case 115:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            break;
                        case 116:
                            intent = new Intent(context, DetailSuratMasuk.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 117:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            break;
                        case 118:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            break;
                        case 119:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("perihal_surat", perihal_surat);
                            break;
                        case 120:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            break;
                        case 121:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            break;
                        case 122:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            break;
                        case 123:
                            intent = new Intent(context, DetailSuratMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("no_surat_manual", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            break;

                    }
                    context.startActivity(intent);
                }
            });
        }
    }

}
