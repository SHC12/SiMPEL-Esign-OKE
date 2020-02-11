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

import com.egov.win10.simpelv.DetailSuratKeluar;
import com.egov.win10.simpelv.R;
import com.egov.win10.simpelv.data.DataSuratKeluar;

import java.util.ArrayList;

/**
 * Created by win10 on 04/07/2019.
 */

public class AdapterSuratKeluar extends RecyclerView.Adapter<AdapterSuratKeluar.ViewHolder> {

    private ArrayList<DataSuratKeluar> listDataSuratKeluar;
    private Activity activity;
    private Context context;

    public int data;

    public AdapterSuratKeluar(ArrayList<DataSuratKeluar> listDataSuratKeluar, Activity activity) {
        this.listDataSuratKeluar = listDataSuratKeluar;
        this.activity = activity;

    }

    @Override
    public AdapterSuratKeluar.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_surat_keluar, parent, false);
        AdapterSuratKeluar.ViewHolder vh = new AdapterSuratKeluar.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(AdapterSuratKeluar.ViewHolder holder, int position) {

        holder.tvNo.setText(listDataSuratKeluar.get(position).getNo());
        holder.tvTglSurat.setText(listDataSuratKeluar.get(position).getTgl_surat_format());
        holder.tvNoSurat.setText(listDataSuratKeluar.get(position).getNo_surat_keluar());
        holder.tvJenisSurat.setText(listDataSuratKeluar.get(position).getJenis_surat());
        holder.tvPenerimaSurat.setText(listDataSuratKeluar.get(position).getNama_penerima());
        holder.tvPengirimSurat.setText(listDataSuratKeluar.get(position).getAtas_nama());
        holder.tvPerihalSurat.setText(listDataSuratKeluar.get(position).getPerihal_surat());
        holder.tvStatusSurat.setText(listDataSuratKeluar.get(position).getStatus_surat());

        holder.id_suratt = (listDataSuratKeluar.get(position).getId_surat());
        holder.penerima_surat = (listDataSuratKeluar.get(position).getNama_penerima());
        holder.pengirim_surat = (listDataSuratKeluar.get(position).getAtas_nama());
        holder.tgl_surat = (listDataSuratKeluar.get(position).getTgl_surat_format());
        holder.token_surat = (listDataSuratKeluar.get(position).getToken_surat());
        holder.judul_surat = (listDataSuratKeluar.get(position).getSurat_title());
        holder.no_surat = (listDataSuratKeluar.get(position).getNo_surat_keluar());
        holder.nota_dinas = (listDataSuratKeluar.get(position).getJenis_surat());
        holder.no_agenda_keluar = (listDataSuratKeluar.get(position).getNo_agenda_keluar());
    }

    @Override
    public int getItemCount() {
        return listDataSuratKeluar.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cv;
        public TextView tvNo;
        public TextView tvNoSurat;
        public TextView tvJenisSurat;
        public TextView tvTglSurat;
        public TextView tvPerihalSurat;
        public TextView tvPenerimaSurat;
        public TextView tvPengirimSurat;
        public TextView tvStatusSurat;
        public String tvTokenDisposisii;
        public TextView tvNoSuratManual;
        private RelativeLayout itemList;

        private String token_disposisi;
        private String data1;
        private String token_surat;
        private String tgl_surat;
        private String penerima_surat;
        private String pengirim_surat;
        private String nota_dinas;
        private String judul_surat;
        private String no_agenda_keluar;

        private String id_suratt, no_surat, id_disposisi;
        private Context context;

        public ViewHolder(View itemView) {
            super(itemView);

            context = itemView.getContext();

            tvNo = (TextView) itemView.findViewById(R.id.textview_hasil_no_suratkeluar2);
            tvNoSurat = (TextView) itemView.findViewById(R.id.textview_hasil_nomor_surat_keluar2);
            tvJenisSurat = (TextView) itemView.findViewById(R.id.textview_hasil_jenis_surat_keluar2);
            tvTglSurat = (TextView) itemView.findViewById(R.id.textview_hasil_tanggal_surat_keluar2);
            tvPerihalSurat = (TextView) itemView.findViewById(R.id.textview_hasil_perihal_surat_keluar2);
            tvPenerimaSurat = (TextView) itemView.findViewById(R.id.textview_hasil_penerima_surat_keluar2);
            tvPengirimSurat = (TextView) itemView.findViewById(R.id.textview_hasil_pengirim_surat_keluar2);
            tvStatusSurat = (TextView) itemView.findViewById(R.id.textview_hasil_status_surat_keluar2);





            itemList = (RelativeLayout) itemView.findViewById(R.id.item_list_surat_keluar2);
            itemList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    switch (getAdapterPosition()) {
                        case 0:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);



                            intent.putExtra("data1", data1);


                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 1:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);


                            intent.putExtra("data1", data1);
                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 2:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);



                            intent.putExtra("data1", data1);


                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 3:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);


                            intent.putExtra("data1", data1);
                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 4:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);



                            intent.putExtra("data1", data1);


                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 5:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);


                            intent.putExtra("data1", data1);
                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 6:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);



                            intent.putExtra("data1", data1);


                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 7:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);


                            intent.putExtra("data1", data1);
                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 8:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);



                            intent.putExtra("data1", data1);


                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 9:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);


                            intent.putExtra("data1", data1);
                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 10:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);



                            intent.putExtra("data1", data1);


                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 11:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);


                            intent.putExtra("data1", data1);
                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 12:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);



                            intent.putExtra("data1", data1);


                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 13:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);


                            intent.putExtra("data1", data1);
                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 14:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);



                            intent.putExtra("data1", data1);


                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 15:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);


                            intent.putExtra("data1", data1);
                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 16:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);



                            intent.putExtra("data1", data1);


                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 17:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);


                            intent.putExtra("data1", data1);
                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 18:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);



                            intent.putExtra("data1", data1);


                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 19:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);


                            intent.putExtra("data1", data1);
                            //intent.putExtra("token_disposisi", no_surat);

                            break;

                        case 20:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);



                            intent.putExtra("data1", data1);


                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 21:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);


                            intent.putExtra("data1", data1);
                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 22:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);



                            intent.putExtra("data1", data1);


                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 23:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);


                            intent.putExtra("data1", data1);
                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 24:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);



                            intent.putExtra("data1", data1);


                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 25:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);


                            intent.putExtra("data1", data1);
                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 26:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);



                            intent.putExtra("data1", data1);


                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 27:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);


                            intent.putExtra("data1", data1);
                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 28:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);



                            intent.putExtra("data1", data1);


                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 29:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);


                            intent.putExtra("data1", data1);
                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 30:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);



                            intent.putExtra("data1", data1);


                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 31:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);


                            intent.putExtra("data1", data1);
                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 32:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);



                            intent.putExtra("data1", data1);


                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 33:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);


                            intent.putExtra("data1", data1);
                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 34:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);



                            intent.putExtra("data1", data1);


                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 35:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);


                            intent.putExtra("data1", data1);
                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 36:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);



                            intent.putExtra("data1", data1);


                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 37:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);


                            intent.putExtra("data1", data1);
                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 38:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);



                            intent.putExtra("data1", data1);


                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 39:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);


                            intent.putExtra("data1", data1);
                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 40:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);



                            intent.putExtra("data1", data1);


                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 41:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);


                            intent.putExtra("data1", data1);
                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 42:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);



                            intent.putExtra("data1", data1);


                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 43:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);


                            intent.putExtra("data1", data1);
                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 44:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);



                            intent.putExtra("data1", data1);


                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 45:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);


                            intent.putExtra("data1", data1);
                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 46:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);



                            intent.putExtra("data1", data1);


                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 47:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);


                            intent.putExtra("data1", data1);
                            //intent.putExtra("token_disposisi", no_surat);

                            break;

                        case 48:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);



                            intent.putExtra("data1", data1);


                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 49:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);


                            intent.putExtra("data1", data1);
                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 50:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);



                            intent.putExtra("data1", data1);


                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 51:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);


                            intent.putExtra("data1", data1);
                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 52:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);



                            intent.putExtra("data1", data1);


                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 53:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);


                            intent.putExtra("data1", data1);
                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 54:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);



                            intent.putExtra("data1", data1);


                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 55:
                            intent = new Intent(context, DetailSuratKeluar.class);

                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("id_surat", id_suratt);
                            intent.putExtra("nota_dinas", nota_dinas);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("penerima_surat", penerima_surat);
                            intent.putExtra("pengirim_surat", pengirim_surat);
                            intent.putExtra("no_surat", no_surat);
                            intent.putExtra("no_agenda_keluar", no_agenda_keluar);


                            intent.putExtra("data1", data1);
                            //intent.putExtra("token_disposisi", no_surat);

                            break;

                    }
                    context.startActivity(intent);
                }
            });


        }
    }
}
