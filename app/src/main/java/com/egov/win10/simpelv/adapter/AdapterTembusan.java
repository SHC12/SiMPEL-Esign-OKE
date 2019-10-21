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

import com.egov.win10.simpelv.DetailTembusan;
import com.egov.win10.simpelv.R;
import com.egov.win10.simpelv.data.DataTembusan;

import java.util.ArrayList;

/**
 * Created by win10 on 04/07/2019.
 */

public class AdapterTembusan extends RecyclerView.Adapter<AdapterTembusan.ViewHolder> {
    private ArrayList<DataTembusan> listDataTembusan;
    private Activity activity;
    private Context context;

    public int data;

    public AdapterTembusan(ArrayList<DataTembusan> listDataTembusan, Activity activity) {
        this.listDataTembusan = listDataTembusan;
        this.activity = activity;
    }


    @Override
    public AdapterTembusan.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_tembusan, parent, false);
        AdapterTembusan.ViewHolder vh = new AdapterTembusan.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(AdapterTembusan.ViewHolder holder, int position) {

        holder.tvNo.setText(listDataTembusan.get(position).getNo());
        holder.tvTgl_surat.setText(listDataTembusan.get(position).getTgl_surat_format());
        holder.tvNoSurat.setText(listDataTembusan.get(position).getNomor_surat());
        holder.tvJenisSurat.setText(listDataTembusan.get(position).getNama_naskah());
        holder.tvPengirim.setText(listDataTembusan.get(position).getNama_pengirim());
        holder.tvPerihal.setText(listDataTembusan.get(position).getPerihal_surat());
        holder.tvStatusSurat.setText(listDataTembusan.get(position).getStatus_surat());

        holder.nomor_surat = (listDataTembusan.get(position).getNomor_surat());
        holder.id_surat = (listDataTembusan.get(position).getId_surat());
        holder.no_agenda_surat_masuk = (listDataTembusan.get(position).getNo_agenda_masuk());
        holder.tgl_surat_format = (listDataTembusan.get(position).getTgl_surat_format());
        holder.nama_pengirim = (listDataTembusan.get(position).getNama_pengirim());
        holder.nama_tujuan = (listDataTembusan.get(position).getNama_tujuan());
        holder.judul_surat = (listDataTembusan.get(position).getSurat_title());
        holder.jenis_surat = (listDataTembusan.get(position).getNama_naskah());



    }

    @Override
    public int getItemCount() {
        return listDataTembusan.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cv;
        public TextView tvNo;
        public TextView tvTgl_surat;
        public TextView tvNoSurat;
        public TextView tvNamaNaskah;
        public TextView tvJenisSurat;
        public TextView tvPengirim;
        public TextView tvStatusSurat;
        public TextView tvPerihal;

        public String no;
        public String id_surat;
        public String nomor_surat;

        public String status_surat;
        public String judul_surat;
        public String id_naskah;
        public String id_instansi;
        public String token_surat;
        public String jenis_surat;
        public String user_pemeriksa;
        public String atas_nama;
        public String nama_tujuan;
        public String nama_pengirim;
        public String perihal_surat;
        public String nama_naskah;
        public String tgl_surat;
        public String tgl_surat_format;
        public String no_agenda_surat_masuk;
        public String data1;


        private RelativeLayout itemList;

        private Context context;

        public ViewHolder(View itemView) {
            super(itemView);

            context = itemView.getContext();



            tvNo = (TextView) itemView.findViewById(R.id.textview_hasil_no_tembusan);
            tvTgl_surat = (TextView) itemView.findViewById(R.id.textview_hasil_tanggal_surat_tembusan);
            tvNoSurat = (TextView) itemView.findViewById(R.id.textview_hasil_nomor_surat_tembusan);
            tvJenisSurat = (TextView) itemView.findViewById(R.id.textview_hasil_jenis_surat_tembusan);
            tvPengirim = (TextView) itemView.findViewById(R.id.textview_hasil_nama_pengirim_tembusan);
            tvPerihal = (TextView) itemView.findViewById(R.id.textview_hasil_perihal_surat_tembusan);
            tvStatusSurat = (TextView) itemView.findViewById(R.id.textview_hasil_nama_status_penerima_tembusan);




            itemList = (RelativeLayout) itemView.findViewById(R.id.item_list_tembusan);
            itemList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    switch (getAdapterPosition()) {
                        case 0:
                            intent = new Intent(context, DetailTembusan.class);



                          intent.putExtra("nomor_surat", nomor_surat);
                          intent.putExtra("id_surat", id_surat);
                          intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                          intent.putExtra("tgl_surat_format", tgl_surat_format);
                          intent.putExtra("nama_pengirim", nama_pengirim);
                          intent.putExtra("nama_tujuan", nama_tujuan);
                          intent.putExtra("jenis_surat", jenis_surat);
                          intent.putExtra("judul_surat", judul_surat);
                          intent.putExtra("data1", data1);




                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 1:
                            intent = new Intent(context, DetailTembusan.class);


                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("jenis_surat", jenis_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("data1", data1);



                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 2:
                            intent = new Intent(context, DetailTembusan.class);



                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("jenis_surat", jenis_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("data1", data1);

                            //intent.putExtra("token_disposisi", no_surat);

                            break;

                        case 3:
                            intent = new Intent(context, DetailTembusan.class);


                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("jenis_surat", jenis_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("data1", data1);


                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 4:
                            intent = new Intent(context, DetailTembusan.class);



                          intent.putExtra("nomor_surat", nomor_surat);
                          intent.putExtra("id_surat", id_surat);
                          intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                          intent.putExtra("tgl_surat_format", tgl_surat_format);
                          intent.putExtra("nama_pengirim", nama_pengirim);
                          intent.putExtra("nama_tujuan", nama_tujuan);
                          intent.putExtra("jenis_surat", jenis_surat);
                          intent.putExtra("judul_surat", judul_surat);
                          intent.putExtra("data1", data1);




                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 5:
                            intent = new Intent(context, DetailTembusan.class);


                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("jenis_surat", jenis_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("data1", data1);



                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 6:
                            intent = new Intent(context, DetailTembusan.class);



                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("jenis_surat", jenis_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("data1", data1);

                            //intent.putExtra("token_disposisi", no_surat);

                            break;

                        case 7:
                            intent = new Intent(context, DetailTembusan.class);


                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("jenis_surat", jenis_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("data1", data1);


                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 8:
                            intent = new Intent(context, DetailTembusan.class);



                          intent.putExtra("nomor_surat", nomor_surat);
                          intent.putExtra("id_surat", id_surat);
                          intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                          intent.putExtra("tgl_surat_format", tgl_surat_format);
                          intent.putExtra("nama_pengirim", nama_pengirim);
                          intent.putExtra("nama_tujuan", nama_tujuan);
                          intent.putExtra("jenis_surat", jenis_surat);
                          intent.putExtra("judul_surat", judul_surat);
                          intent.putExtra("data1", data1);




                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 9:
                            intent = new Intent(context, DetailTembusan.class);


                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("jenis_surat", jenis_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("data1", data1);



                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 10:
                            intent = new Intent(context, DetailTembusan.class);



                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("jenis_surat", jenis_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("data1", data1);

                            //intent.putExtra("token_disposisi", no_surat);

                            break;

                        case 11:
                            intent = new Intent(context, DetailTembusan.class);


                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("jenis_surat", jenis_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("data1", data1);


                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 13:
                            intent = new Intent(context, DetailTembusan.class);



                          intent.putExtra("nomor_surat", nomor_surat);
                          intent.putExtra("id_surat", id_surat);
                          intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                          intent.putExtra("tgl_surat_format", tgl_surat_format);
                          intent.putExtra("nama_pengirim", nama_pengirim);
                          intent.putExtra("nama_tujuan", nama_tujuan);
                          intent.putExtra("jenis_surat", jenis_surat);
                          intent.putExtra("judul_surat", judul_surat);
                          intent.putExtra("data1", data1);




                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 14:
                            intent = new Intent(context, DetailTembusan.class);


                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("jenis_surat", jenis_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("data1", data1);



                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 15:
                            intent = new Intent(context, DetailTembusan.class);



                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("jenis_surat", jenis_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("data1", data1);

                            //intent.putExtra("token_disposisi", no_surat);

                            break;

                        case 16:
                            intent = new Intent(context, DetailTembusan.class);


                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("jenis_surat", jenis_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("data1", data1);


                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 17:
                            intent = new Intent(context, DetailTembusan.class);



                          intent.putExtra("nomor_surat", nomor_surat);
                          intent.putExtra("id_surat", id_surat);
                          intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                          intent.putExtra("tgl_surat_format", tgl_surat_format);
                          intent.putExtra("nama_pengirim", nama_pengirim);
                          intent.putExtra("nama_tujuan", nama_tujuan);
                          intent.putExtra("jenis_surat", jenis_surat);
                          intent.putExtra("judul_surat", judul_surat);
                          intent.putExtra("data1", data1);




                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 18:
                            intent = new Intent(context, DetailTembusan.class);


                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("jenis_surat", jenis_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("data1", data1);



                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 19:
                            intent = new Intent(context, DetailTembusan.class);



                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("jenis_surat", jenis_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("data1", data1);

                            //intent.putExtra("token_disposisi", no_surat);

                            break;

                        case 20:
                            intent = new Intent(context, DetailTembusan.class);


                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("jenis_surat", jenis_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("data1", data1);


                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 21:
                            intent = new Intent(context, DetailTembusan.class);



                          intent.putExtra("nomor_surat", nomor_surat);
                          intent.putExtra("id_surat", id_surat);
                          intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                          intent.putExtra("tgl_surat_format", tgl_surat_format);
                          intent.putExtra("nama_pengirim", nama_pengirim);
                          intent.putExtra("nama_tujuan", nama_tujuan);
                          intent.putExtra("jenis_surat", jenis_surat);
                          intent.putExtra("judul_surat", judul_surat);
                          intent.putExtra("data1", data1);




                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 22:
                            intent = new Intent(context, DetailTembusan.class);


                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("jenis_surat", jenis_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("data1", data1);



                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 23:
                            intent = new Intent(context, DetailTembusan.class);



                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("jenis_surat", jenis_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("data1", data1);

                            //intent.putExtra("token_disposisi", no_surat);

                            break;

                        case 24:
                            intent = new Intent(context, DetailTembusan.class);


                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("jenis_surat", jenis_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("data1", data1);


                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 25:
                            intent = new Intent(context, DetailTembusan.class);



                          intent.putExtra("nomor_surat", nomor_surat);
                          intent.putExtra("id_surat", id_surat);
                          intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                          intent.putExtra("tgl_surat_format", tgl_surat_format);
                          intent.putExtra("nama_pengirim", nama_pengirim);
                          intent.putExtra("nama_tujuan", nama_tujuan);
                          intent.putExtra("jenis_surat", jenis_surat);
                          intent.putExtra("judul_surat", judul_surat);
                          intent.putExtra("data1", data1);




                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 26:
                            intent = new Intent(context, DetailTembusan.class);


                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("jenis_surat", jenis_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("data1", data1);



                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 27:
                            intent = new Intent(context, DetailTembusan.class);



                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("jenis_surat", jenis_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("data1", data1);

                            //intent.putExtra("token_disposisi", no_surat);

                            break;

                        case 28:
                            intent = new Intent(context, DetailTembusan.class);


                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("jenis_surat", jenis_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("data1", data1);


                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 29:
                            intent = new Intent(context, DetailTembusan.class);



                          intent.putExtra("nomor_surat", nomor_surat);
                          intent.putExtra("id_surat", id_surat);
                          intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                          intent.putExtra("tgl_surat_format", tgl_surat_format);
                          intent.putExtra("nama_pengirim", nama_pengirim);
                          intent.putExtra("nama_tujuan", nama_tujuan);
                          intent.putExtra("jenis_surat", jenis_surat);
                          intent.putExtra("judul_surat", judul_surat);
                          intent.putExtra("data1", data1);




                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 30:
                            intent = new Intent(context, DetailTembusan.class);


                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("jenis_surat", jenis_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("data1", data1);



                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 31:
                            intent = new Intent(context, DetailTembusan.class);



                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("jenis_surat", jenis_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("data1", data1);

                            //intent.putExtra("token_disposisi", no_surat);

                            break;

                        case 32:
                            intent = new Intent(context, DetailTembusan.class);


                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("jenis_surat", jenis_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("data1", data1);


                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 33:
                            intent = new Intent(context, DetailTembusan.class);



                          intent.putExtra("nomor_surat", nomor_surat);
                          intent.putExtra("id_surat", id_surat);
                          intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                          intent.putExtra("tgl_surat_format", tgl_surat_format);
                          intent.putExtra("nama_pengirim", nama_pengirim);
                          intent.putExtra("nama_tujuan", nama_tujuan);
                          intent.putExtra("jenis_surat", jenis_surat);
                          intent.putExtra("judul_surat", judul_surat);
                          intent.putExtra("data1", data1);




                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 34:
                            intent = new Intent(context, DetailTembusan.class);


                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("jenis_surat", jenis_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("data1", data1);



                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 35:
                            intent = new Intent(context, DetailTembusan.class);



                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("jenis_surat", jenis_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("data1", data1);

                            //intent.putExtra("token_disposisi", no_surat);

                            break;

                        case 36:
                            intent = new Intent(context, DetailTembusan.class);


                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("jenis_surat", jenis_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("data1", data1);


                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 37:
                            intent = new Intent(context, DetailTembusan.class);



                          intent.putExtra("nomor_surat", nomor_surat);
                          intent.putExtra("id_surat", id_surat);
                          intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                          intent.putExtra("tgl_surat_format", tgl_surat_format);
                          intent.putExtra("nama_pengirim", nama_pengirim);
                          intent.putExtra("nama_tujuan", nama_tujuan);
                          intent.putExtra("jenis_surat", jenis_surat);
                          intent.putExtra("judul_surat", judul_surat);
                          intent.putExtra("data1", data1);




                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 38:
                            intent = new Intent(context, DetailTembusan.class);


                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("jenis_surat", jenis_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("data1", data1);



                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 39:
                            intent = new Intent(context, DetailTembusan.class);



                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("jenis_surat", jenis_surat);
                            intent.putExtra("judul_surat", judul_surat);
                            intent.putExtra("data1", data1);

                            //intent.putExtra("token_disposisi", no_surat);

                            break;

                        case 40:
                            intent = new Intent(context, DetailTembusan.class);


                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_agenda_masuk", no_agenda_surat_masuk);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("jenis_surat", jenis_surat);
                            intent.putExtra("judul_surat", judul_surat);
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
