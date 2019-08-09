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
import com.egov.win10.simpelv.TU.DetailAgendaKeluar;
import com.egov.win10.simpelv.TU.DetailSuratMasukTU;
import com.egov.win10.simpelv.data.DataAgendaKeluar;
import com.egov.win10.simpelv.data.DataAgendaMasuk;

import java.util.ArrayList;

/**
 * Created by win10 on 25/07/2019.
 */

public class AdapterAgendaKeluar extends RecyclerView.Adapter<AdapterAgendaKeluar.ViewHolder> {

    private ArrayList<DataAgendaKeluar> listData;
    private Activity activity;
    private Context context;


    public AdapterAgendaKeluar(ArrayList<DataAgendaKeluar> listData, Activity activity) {
        this.listData = listData;
        this.activity = activity;

    }



    @Override
    public AdapterAgendaKeluar.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_agenda_keluar, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(AdapterAgendaKeluar.ViewHolder holder, int position) {


        holder.tvNo.setText(listData.get(position).getNo());
        holder.tvTanggalSurat.setText(listData.get(position).getTgl_surat_format());
        holder.tvNoSurat.setText(listData.get(position).getNo_surat_keluar());
        holder.tvNoAgendaMasuk.setText(listData.get(position).getNo_agenda_masuk());
        holder.tvNama_pengirim.setText(listData.get(position).getAtas_nama());
        holder.tvPerihalSurat.setText(listData.get(position).getPerihal_surat());
        holder.tvStatusPenerima.setText(listData.get(position).getStatus_penerima());

        holder.no_agenda_keluar = (listData.get(position).getNo_agenda_masuk());
        holder.no_surat_SM = (listData.get(position)).getNo_surat_keluar();
        holder.tanggal_surat = (listData.get(position).getTgl_surat_format());
        holder.pengirim = (listData.get(position).getAtas_nama());
        holder.surat_link = (listData.get(position).getSurat_link());
        holder.surat_name = (listData.get(position).getSurat_name());
        holder.surat_title = (listData.get(position).getSurat_title());
        holder.nama_naskah = (listData.get(position).getNama_naskah());
        holder.pass_id_surat = (listData.get(position).getId_surat());
        holder.perihal_surat = (listData.get(position).getPerihal_surat());


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
        public String no_agenda_keluar;
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
            tvNo = (TextView) itemView.findViewById(R.id.textview_hasil_no_AK_tu);
            tvTanggalSurat = (TextView) itemView.findViewById(R.id.textview_hasil_tanggal_surat_AK_tu);
            tvNoSurat = (TextView) itemView.findViewById(R.id.textview_hasil_no_surat_masuk_AK_tu);
            tvNoAgendaMasuk = (TextView) itemView.findViewById(R.id.textview_hasil_no_agenda_AK_tu);
            tvTglSurat = (TextView) itemView.findViewById(R.id.textview_hasil_tanggal_surat_AK_tu);
            tvPerihalSurat = (TextView) itemView.findViewById(R.id.textview_hasil_perihal_agenda_AK_tu);
            tvNama_pengirim = (TextView) itemView.findViewById(R.id.textview_hasil_atas_nama_AK_tu);
            tvStatusPenerima = (TextView) itemView.findViewById(R.id.textview_hasil_status_surat_AK_tu);

            itemListSM = (RelativeLayout) itemView.findViewById(R.id.item_list_agenda_keluar_TU);
            itemListSM.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    switch (getAdapterPosition()){
                        case 0:
                            intent = new Intent(context, DetailAgendaKeluar.class);


                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("atas_nama", pengirim);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("perihal", perihal_surat);



                            break;
                        case 1:
                            intent = new Intent(context, DetailAgendaKeluar.class);


                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("atas_nama", pengirim);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("perihal", perihal_surat);



                            break;
                        case 2:
                            intent = new Intent(context, DetailAgendaKeluar.class);


                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("atas_nama", pengirim);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("perihal", perihal_surat);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);



                            break;
                        case 3:
                            intent = new Intent(context, DetailAgendaKeluar.class);


                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("perihal", perihal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("atas_nama", pengirim);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);



                            break;
                        case 4:
                            intent = new Intent(context, DetailAgendaKeluar.class);


                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("perihal", perihal_surat);
                            intent.putExtra("atas_nama", pengirim);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);



                            break;
                        case 5:
                            intent = new Intent(context, DetailAgendaKeluar.class);


                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("atas_nama", pengirim);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("perihal", perihal_surat);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);



                            break;
                        case 6:
                            intent = new Intent(context, DetailAgendaKeluar.class);


                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("atas_nama", pengirim);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("perihal", perihal_surat);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);



                            break;
                        case 7:
                            intent = new Intent(context, DetailAgendaKeluar.class);


                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("atas_nama", pengirim);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);

                            intent.putExtra("perihal", perihal_surat);


                            break;
                        case 8:
                            intent = new Intent(context, DetailAgendaKeluar.class);


                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("atas_nama", pengirim);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);

                            intent.putExtra("perihal", perihal_surat);


                            break;
                        case 9:
                            intent = new Intent(context, DetailAgendaKeluar.class);


                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("atas_nama", pengirim);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("perihal", perihal_surat);


                            break;
                        case 10:
                            intent = new Intent(context, DetailAgendaKeluar.class);


                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("atas_nama", pengirim);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("perihal", perihal_surat);


                            break;
                        case 11:
                            intent = new Intent(context, DetailAgendaKeluar.class);


                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("atas_nama", pengirim);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("perihal", perihal_surat);


                            break;
                        case 12:
                            intent = new Intent(context, DetailAgendaKeluar.class);


                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("atas_nama", pengirim);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);

                            intent.putExtra("perihal", perihal_surat);

                            break;
                        case 13:
                            intent = new Intent(context, DetailAgendaKeluar.class);


                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("atas_nama", pengirim);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("perihal", perihal_surat);


                            break;
                        case 14:
                            intent = new Intent(context, DetailAgendaKeluar.class);


                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("atas_nama", pengirim);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);

                            intent.putExtra("perihal", perihal_surat);

                            break;
                        case 15:
                            intent = new Intent(context, DetailAgendaKeluar.class);


                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("atas_nama", pengirim);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("perihal", perihal_surat);


                            break;
                        case 16:
                            intent = new Intent(context, DetailAgendaKeluar.class);


                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("atas_nama", pengirim);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);

                            intent.putExtra("perihal", perihal_surat);

                            break;
                        case 17:
                            intent = new Intent(context, DetailAgendaKeluar.class);


                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("atas_nama", pengirim);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);

                            intent.putExtra("perihal", perihal_surat);

                            break;
                        case 18:
                            intent = new Intent(context, DetailAgendaKeluar.class);


                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("atas_nama", pengirim);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);


                            intent.putExtra("perihal", perihal_surat);
                            break;
                        case 19:
                            intent = new Intent(context, DetailAgendaKeluar.class);


                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);
                            intent.putExtra("no_surat_masuk", no_surat_SM);
                            intent.putExtra("tanggal_surat", tanggal_surat);
                            intent.putExtra("id_surat", pass_id_surat);
                            intent.putExtra("atas_nama", pengirim);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("judul_surat", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("perihal", perihal_surat);


                            break;




                    }
                    context.startActivity(intent);
                }
            });
        }
    }
}
