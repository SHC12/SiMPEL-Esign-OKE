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
import com.egov.win10.simpelv.TU.DetailAgendaMasuk;
import com.egov.win10.simpelv.TU.DetailSuratMasukTU;
import com.egov.win10.simpelv.data.DataAgendaMasuk;
import com.egov.win10.simpelv.data.DataSuratMasukTU;

import java.util.ArrayList;

/**
 * Created by win10 on 25/07/2019.
 */

public class AdapterAgendaMasuk extends RecyclerView.Adapter<AdapterAgendaMasuk.ViewHolder> {

    private ArrayList<DataAgendaMasuk> listData;
    private Activity activity;
    private Context context;


    public AdapterAgendaMasuk(ArrayList<DataAgendaMasuk> listData, Activity activity) {
        this.listData = listData;
        this.activity = activity;

    }



    @Override
    public AdapterAgendaMasuk.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_agenda_masuk, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(AdapterAgendaMasuk.ViewHolder holder, int position) {


        holder.tvNo.setText(listData.get(position).getNo());
        holder.tvTanggalSurat.setText(listData.get(position).getTgl_surat_format());
        holder.tvNoSurat.setText(listData.get(position).getNo_surat_keluar());
        holder.tvNoAgendaMasuk.setText(listData.get(position).getNo_agenda_masuk());
        holder.tvNama_pengirim.setText(listData.get(position).getAtas_nama());
        holder.tvPerihalSurat.setText(listData.get(position).getPerihal_surat());
        holder.tvStatusPenerima.setText(listData.get(position).getStatus_penerima());

        holder.perihal_surat = (listData.get(position).getPerihal_surat());
        holder.no_agenda_masuk_terakhir = (listData.get(position).getNo_agenda_masuk());
        holder.tanggal_surat_masuk = (listData.get(position).getTgl_surat_masuk());
        holder.pengirim = (listData.get(position).getAtas_nama());
        holder.pass_id_surat = (listData.get(position).getId_surat());
        holder.no_surat_SM = (listData.get(position).getNo_surat_keluar());
        holder.tanggal_surat = (listData.get(position).getTgl_surat_format());
        holder.surat_link = (listData.get(position).getSurat_link());
        holder.surat_name = (listData.get(position).getSurat_name());
        holder.surat_title = (listData.get(position).getSurat_title());
        holder.nama_naskah = (listData.get(position).getNama_naskah());








    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cv;
        public TextView tvNo;
        public TextView tvNoAgendaMasuk;
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
        public String surat_name;
        public String surat_link;
        public String surat_title;




        public ViewHolder(View v) {
            super(v);
            context = itemView.getContext();
            // cv=(CardView)v.findViewById(R.id.cvSuratMasuk);
            tvNo = (TextView) itemView.findViewById(R.id.textview_hasil_no_AM_tu);
            tvTanggalSurat = (TextView) itemView.findViewById(R.id.textview_hasil_tanggal_surat_AM_tu);
            tvNoSurat = (TextView) itemView.findViewById(R.id.textview_hasil_no_surat_masuk_AM_tu);
            tvNoAgendaMasuk = (TextView) itemView.findViewById(R.id.textview_hasil_no_agenda_AM_tu);
            tvTglSurat = (TextView) itemView.findViewById(R.id.textview_hasil_tanggal_surat_AM_tu);
            tvPerihalSurat = (TextView) itemView.findViewById(R.id.textview_hasil_perihal_agenda_AM_tu);
            tvNama_pengirim = (TextView) itemView.findViewById(R.id.textview_hasil_atas_nama_AM_tu);
            tvStatusPenerima = (TextView) itemView.findViewById(R.id.textview_hasil_status_surat_AM_tu);

            itemListSM = (RelativeLayout) itemView.findViewById(R.id.item_list_agenda_masuk_TU);
            itemListSM.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    switch (getAdapterPosition()){
                        case 0:
                            intent = new Intent(context, DetailAgendaMasuk.class);

                           intent.putExtra("perihal", perihal_surat);
                           intent.putExtra("no_agenda_masuk", no_agenda_masuk_terakhir);
                           intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                           intent.putExtra("pengirim", pengirim);
                           intent.putExtra("no_surat", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                           intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("nama_naskah", nama_naskah);



                            break;
                        case 1:
                            intent = new Intent(context, DetailAgendaMasuk.class);

                            intent.putExtra("perihal", perihal_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_masuk_terakhir);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("pengirim", pengirim);
                            intent.putExtra("no_surat", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("nama_naskah", nama_naskah);

                            break;
                        case 2:
                            intent = new Intent(context, DetailAgendaMasuk.class);

                           intent.putExtra("perihal", perihal_surat);
                           intent.putExtra("no_agenda_masuk", no_agenda_masuk_terakhir);
                           intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                           intent.putExtra("pengirim", pengirim);
                           intent.putExtra("no_surat", no_surat_SM);
                           intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("nama_naskah", nama_naskah);



                            break;
                        case 3:
                            intent = new Intent(context, DetailAgendaMasuk.class);

                            intent.putExtra("perihal", perihal_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_masuk_terakhir);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("pengirim", pengirim);
                            intent.putExtra("no_surat", no_surat_SM);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("nama_naskah", nama_naskah);

                            break;
                        case 4:
                            intent = new Intent(context, DetailAgendaMasuk.class);

                           intent.putExtra("perihal", perihal_surat);
                           intent.putExtra("no_agenda_masuk", no_agenda_masuk_terakhir);
                           intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                           intent.putExtra("pengirim", pengirim);
                           intent.putExtra("no_surat", no_surat_SM);
                           intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("id_surat", pass_id_surat);



                            break;
                        case 5:
                            intent = new Intent(context, DetailAgendaMasuk.class);

                            intent.putExtra("perihal", perihal_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_masuk_terakhir);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("pengirim", pengirim);
                            intent.putExtra("no_surat", no_surat_SM);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("nama_naskah", nama_naskah);

                            break;
                        case 6:
                            intent = new Intent(context, DetailAgendaMasuk.class);

                           intent.putExtra("perihal", perihal_surat);
                           intent.putExtra("no_agenda_masuk", no_agenda_masuk_terakhir);
                           intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                           intent.putExtra("pengirim", pengirim);
                            intent.putExtra("id_surat", pass_id_surat);
                           intent.putExtra("no_surat", no_surat_SM);
                           intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("nama_naskah", nama_naskah);



                            break;
                        case 7:
                            intent = new Intent(context, DetailAgendaMasuk.class);

                            intent.putExtra("perihal", perihal_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_masuk_terakhir);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("pengirim", pengirim);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("no_surat", no_surat_SM);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("nama_naskah", nama_naskah);

                            break;
                        case 8:
                            intent = new Intent(context, DetailAgendaMasuk.class);

                           intent.putExtra("perihal", perihal_surat);
                           intent.putExtra("no_agenda_masuk", no_agenda_masuk_terakhir);
                           intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                           intent.putExtra("pengirim", pengirim);
                            intent.putExtra("id_surat", pass_id_surat);
                           intent.putExtra("no_surat", no_surat_SM);
                           intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("nama_naskah", nama_naskah);



                            break;
                        case 9:
                            intent = new Intent(context, DetailAgendaMasuk.class);

                            intent.putExtra("perihal", perihal_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_masuk_terakhir);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("pengirim", pengirim);
                            intent.putExtra("no_surat", no_surat_SM);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("nama_naskah", nama_naskah);

                            break;
                        case 10:
                            intent = new Intent(context, DetailAgendaMasuk.class);

                           intent.putExtra("perihal", perihal_surat);
                           intent.putExtra("no_agenda_masuk", no_agenda_masuk_terakhir);
                           intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                           intent.putExtra("pengirim", pengirim);
                           intent.putExtra("no_surat", no_surat_SM);
                            intent.putExtra("id_surat", pass_id_surat);
                           intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("nama_naskah", nama_naskah);



                            break;
                        case 11:
                            intent = new Intent(context, DetailAgendaMasuk.class);

                            intent.putExtra("perihal", perihal_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_masuk_terakhir);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("pengirim", pengirim);
                            intent.putExtra("no_surat", no_surat_SM);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("nama_naskah", nama_naskah);

                            break;
                        case 12:
                            intent = new Intent(context, DetailAgendaMasuk.class);

                           intent.putExtra("perihal", perihal_surat);
                           intent.putExtra("no_agenda_masuk", no_agenda_masuk_terakhir);
                           intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                           intent.putExtra("pengirim", pengirim);
                           intent.putExtra("no_surat", no_surat_SM);
                           intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("nama_naskah", nama_naskah);



                            break;
                        case 13:
                            intent = new Intent(context, DetailAgendaMasuk.class);

                            intent.putExtra("perihal", perihal_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_masuk_terakhir);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("pengirim", pengirim);
                            intent.putExtra("no_surat", no_surat_SM);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("nama_naskah", nama_naskah);

                            break;
                        case 14:
                            intent = new Intent(context, DetailAgendaMasuk.class);

                           intent.putExtra("perihal", perihal_surat);
                           intent.putExtra("no_agenda_masuk", no_agenda_masuk_terakhir);
                           intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                           intent.putExtra("pengirim", pengirim);
                           intent.putExtra("no_surat", no_surat_SM);
                           intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("id_surat", pass_id_surat);



                            break;
                        case 15:
                            intent = new Intent(context, DetailAgendaMasuk.class);

                            intent.putExtra("perihal", perihal_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_masuk_terakhir);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("pengirim", pengirim);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("no_surat", no_surat_SM);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("nama_naskah", nama_naskah);

                            break;
                        case 16:
                            intent = new Intent(context, DetailAgendaMasuk.class);

                           intent.putExtra("perihal", perihal_surat);
                           intent.putExtra("no_agenda_masuk", no_agenda_masuk_terakhir);
                           intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("id_surat", pass_id_surat);
                           intent.putExtra("pengirim", pengirim);
                           intent.putExtra("no_surat", no_surat_SM);
                           intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("nama_naskah", nama_naskah);



                            break;
                        case 17:
                            intent = new Intent(context, DetailAgendaMasuk.class);

                            intent.putExtra("perihal", perihal_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_masuk_terakhir);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("pengirim", pengirim);
                            intent.putExtra("no_surat", no_surat_SM);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("nama_naskah", nama_naskah);

                            break;
                        case 18:
                            intent = new Intent(context, DetailAgendaMasuk.class);

                           intent.putExtra("perihal", perihal_surat);
                           intent.putExtra("no_agenda_masuk", no_agenda_masuk_terakhir);
                           intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("id_surat", pass_id_surat);
                           intent.putExtra("pengirim", pengirim);
                           intent.putExtra("no_surat", no_surat_SM);
                           intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("nama_naskah", nama_naskah);



                            break;
                        case 19:
                            intent = new Intent(context, DetailAgendaMasuk.class);

                            intent.putExtra("perihal", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_masuk_terakhir);
                            intent.putExtra("tanggal_surat_masuk", tanggal_surat_masuk);
                            intent.putExtra("pengirim", pengirim);
                            intent.putExtra("no_surat", no_surat_SM);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("nama_naskah", nama_naskah);

                            break;




                    }
                    context.startActivity(intent);
                }
            });
        }
    }
}
