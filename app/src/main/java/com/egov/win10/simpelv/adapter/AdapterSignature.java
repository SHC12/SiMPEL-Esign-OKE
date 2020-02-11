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

import com.egov.win10.simpelv.DetailSignature;
import com.egov.win10.simpelv.R;
import com.egov.win10.simpelv.TTD.PilihTTD;
import com.egov.win10.simpelv.data.DataSignature;

import java.util.ArrayList;

/**
 * Created by win10 on 26/06/2019.
 */

public class AdapterSignature extends RecyclerView.Adapter<AdapterSignature.ViewHolder> {

    private ArrayList<DataSignature> listDataSignature;
    private Activity activity;
    private Context context;

    public int data;

    public AdapterSignature(ArrayList<DataSignature> listDataSignature, Activity activity) {
        this.listDataSignature = listDataSignature;
        this.activity = activity;
    }


    @Override
    public AdapterSignature.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_signature, parent, false);
        AdapterSignature.ViewHolder vh = new AdapterSignature.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(AdapterSignature.ViewHolder holder, int position) {
        holder.tvNo.setText(listDataSignature.get(position).getNo());

        holder.tvJenisSurat.setText(listDataSignature.get(position).getNama_naskah());
//        holder.tvPemeriksa.setText(listDataSignature.get(position).getUser_pemeriksa());
       // holder.tvAtasNama.setText(listDataSignature.get(position).getNama_tujuan());
        holder.tvPerihal.setText(listDataSignature.get(position).getPerihal_surat());
        holder.token_surat = (listDataSignature.get(position).getToken_surat());
        holder.id_surat = (listDataSignature.get(position).getId_surat());
        holder.id_naskah = (listDataSignature.get(position).getId_naskah());
        holder.tvNoSurat.setText(listDataSignature.get(position).getNomor_surat());
        holder.tvTgl_surat.setText(listDataSignature.get(position).getTgl_surat_format());
       // holder.urutan_pemeriksa = (listDataSignature.get(position).getUrutan_pemeriksa());
        //holder.id_user_pemeriksa = (listDataSignature.get(position).getId_user_pemeriksa());
        //holder.surat_title = (listDataSignature.get(position).getSurat_title());
        //holder.surat_name = (listDataSignature.get(position).getSurat_name());
       // holder.surat_link = (listDataSignature.get(position).getSurat_link());
        holder.status_surat = (listDataSignature.get(position).getStatus_surat());

        holder.id_naskah = (listDataSignature.get(position).getId_naskah());
        holder.user_pemeriksa = (listDataSignature.get(position).getUser_pemeriksa());
        holder.atas_nama = (listDataSignature.get(position).getAtas_nama());
        holder.perihal_surat = (listDataSignature.get(position).getPerihal_surat());
        holder.nama_naskah = (listDataSignature.get(position).getNama_naskah());
        holder.tgl_surat = (listDataSignature.get(position).getTgl_surat());
        holder.nomor_surat = (listDataSignature.get(position).getNomor_surat());
        holder.no_agenda_surat_keluar = (listDataSignature.get(position).getNo_agenda_keluar());
       // holder.id_user_pemeriksa_tolak = (listDataSignature.get(position).getId_user_pemeriksa_tolak());
        //holder.id_atas_nama = (listDataSignature.get(position).getId_atas_nama());
        holder.nama_tujuan = (listDataSignature.get(position).getNama_tujuan());
        holder.nama_pengirim = (listDataSignature.get(position).getNama_pengirim());
        holder.id_instansi = (listDataSignature.get(position).getId_instansi());
        holder.tgl_surat_format = (listDataSignature.get(position).getTgl_surat_format());
        holder.nama_tembusan = (listDataSignature.get(position).getTembusan());

    }

    @Override
    public int getItemCount() {
        return listDataSignature.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cv;
        public TextView tvNo;
        public TextView tvTgl_surat;
        public TextView tvNoSurat;
        public TextView tvNamaNaskah;
        public TextView tvJenisSurat;
        public TextView tvPemeriksa;
        public TextView tvAtasNama;
        public TextView tvPerihal;

        public String no;
        public String id_surat;
        public String nomor_surat;

        public String status_surat;
        public String id_naskah;
        public String id_instansi;
        public String token_surat;
        public String user_pemeriksa;
        public String atas_nama;
        public String nama_tujuan;
        public String nama_pengirim;
        public String perihal_surat;
        public String nama_naskah;
        public String tgl_surat;
        public String tgl_surat_format;
        public String nama_tembusan;
        public String data1;

        public String no_agenda_surat_keluar;


        private RelativeLayout itemList;

        private Context context;

        public ViewHolder(View itemView) {
            super(itemView);

            context = itemView.getContext();


            tvNo = (TextView) itemView.findViewById(R.id.textview_hasil_no_signature);
            tvTgl_surat = (TextView) itemView.findViewById(R.id.textview_hasil_tanggal_surat_signature);
            tvNoSurat = (TextView) itemView.findViewById(R.id.textview_hasil_no_surat_signature);
            tvJenisSurat = (TextView) itemView.findViewById(R.id.textview_hasil_jenis_surat_signature);

            //tvAtasNama = (TextView) itemView.findViewById(R.id.textview_hasil_atas_nama_signature);
            tvPerihal = (TextView) itemView.findViewById(R.id.textview_hasil_perihal_signature);



            itemList = (RelativeLayout) itemView.findViewById(R.id.item_list_signature);
            itemList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    switch (getAdapterPosition()) {
                        case 0:
                            intent = new Intent(context, PilihTTD.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);







                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 1:
                            intent = new Intent(context, PilihTTD.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);








                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 2:
                            intent = new Intent(context, PilihTTD.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);










                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 3:
                            intent = new Intent(context, PilihTTD.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);





                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 4:
                            intent = new Intent(context, PilihTTD.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);





                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 5:
                            intent = new Intent(context, PilihTTD.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);






                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 6:
                            intent = new Intent(context, PilihTTD.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);






                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 7:
                            intent = new Intent(context, PilihTTD.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);








                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 8:
                            intent = new Intent(context, PilihTTD.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);








                            //intent.putExtra("token_disposisi", no_surat);

                            break;

                        case 9:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);







                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 10:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);








                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 11:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);










                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 12:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);





                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 13:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);






                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 14:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);






                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 15:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);








                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 16:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);








                            //intent.putExtra("token_disposisi", no_surat);

                            break;

                        case 17:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);







                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 18:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);








                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 19:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);










                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 20:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);





                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 21:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);






                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 22:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);






                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 23:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);








                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 24:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);








                            //intent.putExtra("token_disposisi", no_surat);

                            break;

                        case 25:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);







                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 26:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);








                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 27:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);










                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 28:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);





                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 29:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);






                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 30:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);






                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 31:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);








                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 32:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);








                            //intent.putExtra("token_disposisi", no_surat);

                            break;

                        case 33:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);







                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 34:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);








                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 35:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);










                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 36:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);





                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 37:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);






                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 38:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);






                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 39:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);








                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 40:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);








                            //intent.putExtra("token_disposisi", no_surat);

                            break;

                        case 41:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);







                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 42:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);








                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 43:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);










                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 44:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);





                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 45:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);






                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 46:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);






                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 47:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);








                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 48:
                            intent = new Intent(context, DetailSignature.class);



                            intent.putExtra("nama_tujuan", nama_tujuan);
                            intent.putExtra("nama_pengirim", nama_pengirim);
                            intent.putExtra("judul_surat", perihal_surat);
                            intent.putExtra("nomor_surat", nomor_surat);
                            intent.putExtra("no_agenda_surat_keluar", no_agenda_surat_keluar);
                            intent.putExtra("tanggal_surat", tgl_surat);
                            intent.putExtra("tanggal_surat_format", tgl_surat_format);
                            intent.putExtra("jenis_nota_dinas", nama_naskah);


                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("id_instansi", id_instansi);
                            intent.putExtra("token_surat", token_surat);








                            //intent.putExtra("token_disposisi", no_surat);

                            break;



                    }
                    context.startActivity(intent);
                }
            });


        }
    }
}
