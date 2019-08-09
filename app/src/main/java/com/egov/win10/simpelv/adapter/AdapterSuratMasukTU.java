package com.egov.win10.simpelv.adapter;

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

import com.egov.win10.simpelv.R;
import com.egov.win10.simpelv.TU.DetailSuratMasukTU;
import com.egov.win10.simpelv.data.DataSuratMasukTU;

import java.util.ArrayList;

/**
 * Created by win10 on 21/07/2019.
 */

public class AdapterSuratMasukTU extends RecyclerView.Adapter<AdapterSuratMasukTU.ViewHolder> {

    private ArrayList<DataSuratMasukTU> listData;
    private Activity activity;
    private Context context;

    public AdapterSuratMasukTU(ArrayList<DataSuratMasukTU> listData, Activity activity) {
        this.listData = listData;
        this.activity = activity;
    }


    @Override
    public AdapterSuratMasukTU.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_surat_masuk_tu, parent, false);
       ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(AdapterSuratMasukTU.ViewHolder holder, int position) {

        holder.tvNo.setText(listData.get(position).getNo());
//        holder.tvPerihalSurat.setText(listData.get(position).getPerihal_surat());
        holder.tvTglSurat.setText(listData.get(position).getTgl_surat());
        holder.tvNama_pengirim.setText(listData.get(position).getNama_pengirim());
        holder.tvStatusPenerima.setText(listData.get(position).getStatus_penerima());
        holder.tvNoSurat.setText(listData.get(position).getNo_surat_keluar());
        holder.tvTanggalSurat.setText(listData.get(position).getTgl_surat());
        holder.tvPerihalSurat.setText(listData.get(position).getNama_naskah());
        holder.token_surat_SM = (listData.get(position).getToken_surat());
        holder.tvPerihal.setText(listData.get(position).getPerihal_surat());
        holder.perihal_surat = (listData.get(position).getPerihal_surat());
        holder.no_surat_SM = (listData.get(position).getNo_surat_keluar());
        holder.pass_id_surat = (listData.get(position).getId_surat());
        holder.tanggal_surat = (listData.get(position).getTgl_surat());
        // holder.token_disposisii = (listData.get(position).getToken_disposisi());
        holder.nama_naskah = (listData.get(position).getNama_naskah());
        holder.tanggal_surat_masuk = (listData.get(position).getTgl_surat_format());
        holder.no_agenda_masuk_terakhir = (listData.get(position).getNo_agenda_masuk());
        holder.pengirim = (listData.get(position).getNama_pengirim());


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
        public String no_agenda_masuk_terakhir;
        public String pengirim;




        public ViewHolder(View v) {
            super(v);
            context = itemView.getContext();
            // cv=(CardView)v.findViewById(R.id.cvSuratMasuk);
            tvNo = (TextView) itemView.findViewById(R.id.textview_hasil_no_SM_tu);
            tvTanggalSurat = (TextView) itemView.findViewById(R.id.textview_hasil_tanggal_surat_SM_tu);
            tvNoSurat = (TextView) itemView.findViewById(R.id.textview_hasil_no_surat_masuk_SM_tu);
            tvTglSurat = (TextView) itemView.findViewById(R.id.textview_hasil_tanggal_surat_SM_tu);
            tvPerihalSurat = (TextView) itemView.findViewById(R.id.textview_hasil_jenis_surat_SM_tu);
            tvNama_pengirim = (TextView) itemView.findViewById(R.id.textview_hasil_nama_pengirim_SM_tu);
            tvStatusPenerima = (TextView) itemView.findViewById(R.id.textview_hasil_status_surat_masuk_SM_tu);
            tvPerihal = (TextView) itemView.findViewById(R.id.textview_hasil_perihal_surat_masuk_SM_tu);
            itemListSM = (RelativeLayout) itemView.findViewById(R.id.item_list_surat_masuk_TU);
            itemListSM.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    switch (getAdapterPosition()){
                        case 0:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 1:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;

                        case 2:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 3:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 4:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 5:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 6:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 7:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 8:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;

                        case 9:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 10:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 11:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 12:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 13:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 14:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 15:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 16:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;

                        case 17:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 18:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 19:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 20:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 21:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 22:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 23:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 24:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;

                        case 25:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 26:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 27:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 28:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 29:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 30:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 31:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 32:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;

                        case 33:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 34:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 35:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 36:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 37:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 38:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 39:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 40:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;

                        case 41:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 42:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 43:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 44:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 45:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 46:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 47:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 48:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;

                        case 49:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 50:
                            intent = new Intent(context, DetailSuratMasukTU.class);

                            //intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("token_surat", token_surat_SM);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("token_disposisi", token_disposisii);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("no_agenda_masuk_terakhir", no_agenda_masuk_terakhir);
                            intent.putExtra("pengirim", pengirim);
                            //intent.putExtra("no_surat_manual", no_surat);
                            break;



                    }
                    context.startActivity(intent);
                }
            });
        }
    }
}
