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

import com.egov.win10.simpelv.DetailKonsep;
import com.egov.win10.simpelv.R;
import com.egov.win10.simpelv.data.DataKonsep;

import java.util.ArrayList;

/**
 * Created by win10 on 19/06/2019.
 */

public class AdapterKonsep extends RecyclerView.Adapter<AdapterKonsep.ViewHolder>{
    private ArrayList<DataKonsep> listDataKonsep;
    private Activity activity;
    private Context context;

    public int data;

    public AdapterKonsep(ArrayList<DataKonsep> listDataKonsep, Activity activity) {
        this.listDataKonsep = listDataKonsep;
        this.activity = activity;
    }


    @Override
    public AdapterKonsep.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_konsep, parent, false);
        AdapterKonsep.ViewHolder vh = new AdapterKonsep.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(AdapterKonsep.ViewHolder holder, int position) {
       holder.tvNo.setText(listDataKonsep.get(position).getNo());

       holder.tvJenisSurat.setText(listDataKonsep.get(position).getNama_naskah());
       holder.tvPemeriksa.setText(listDataKonsep.get(position).getUser_pemeriksa());
       holder.tvAtasNama.setText(listDataKonsep.get(position).getAtas_nama());
       holder.tvPerihal.setText(listDataKonsep.get(position).getPerihal_surat());
       holder.token_surat = (listDataKonsep.get(position).getToken_surat());
       holder.id_surat = (listDataKonsep.get(position).getId_surat());
       holder.id_naskah = (listDataKonsep.get(position).getId_naskah());
       holder.urutan_pemeriksa = (listDataKonsep.get(position).getUrutan_pemeriksa());
       holder.id_user_pemeriksa = (listDataKonsep.get(position).getId_user_pemeriksa());
       holder.surat_title = (listDataKonsep.get(position).getSurat_title());
       holder.surat_name = (listDataKonsep.get(position).getSurat_name());
       holder.surat_link = (listDataKonsep.get(position).getSurat_link());
       holder.status_surat = (listDataKonsep.get(position).getStatus_surat());
       holder.id_naskah = (listDataKonsep.get(position).getId_naskah());
       holder.user_pemeriksa = (listDataKonsep.get(position).getUser_pemeriksa());
       holder.atas_nama = (listDataKonsep.get(position).getAtas_nama());
       holder.perihal_surat = (listDataKonsep.get(position).getPerihal_surat());
       holder.nama_naskah = (listDataKonsep.get(position).getNama_naskah());
       holder.tgl_surat = (listDataKonsep.get(position).getTgl_surat());
       holder.id_user_pemeriksa_tolak = (listDataKonsep.get(position).getId_user_pemeriksa_tolak());
       holder.id_atas_nama = (listDataKonsep.get(position).getId_atas_nama());
        holder.tgl_surat_format = (listDataKonsep.get(position).getTgl_surat_format());
        holder.id_user_pemeriksa_konsep = (listDataKonsep.get(position).getId_user_pemeriksa_konsep());
        holder.nama_tembusan = (listDataKonsep.get(position).getNama_tembusan());
        holder.id_tembusan = (listDataKonsep.get(position).getId_tembusan());





    }

    @Override
    public int getItemCount() {
        return listDataKonsep.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cv;
        public TextView tvNo;
        public TextView tvNoSurat;
        public TextView tvNamaNaskah;
        public TextView tvJenisSurat;
        public TextView tvPemeriksa;
        public TextView tvAtasNama;
        public TextView tvPerihal;

        public String no;
        public String id_surat;
        public String urutan_pemeriksa;
        public String id_user_pemeriksa;
        public String id_user_pemeriksa_konsep;
        public String id_user_pemeriksa_tolak;
        public String surat_title;
        public String surat_name;
        public String surat_link;
        public String status_surat;
        public String id_naskah;
        public String token_surat;
        public String user_pemeriksa;
        public String atas_nama;
        public String id_atas_nama;
        public String perihal_surat;
        public String nama_naskah;
        public String tgl_surat;
        public String tgl_surat_format;
        public String id_tembusan;
        public String nama_tembusan;
        public String data1;


        private RelativeLayout itemList;

        private Context context;

        public ViewHolder(View itemView) {
            super(itemView);

            context = itemView.getContext();


            tvNo = (TextView) itemView.findViewById(R.id.textview_hasil_no_konsep);
            tvNoSurat = (TextView) itemView.findViewById(R.id.textview_hasil_nomor_surrat_konsep);
            tvJenisSurat = (TextView) itemView.findViewById(R.id.textview_hasil_jenis_surat_konsep);
            tvPemeriksa = (TextView) itemView.findViewById(R.id.textview_hasil_pemeriksa_konsep);
            tvAtasNama = (TextView) itemView.findViewById(R.id.textview_hasil_atas_nama_konsep);
            tvPerihal = (TextView) itemView.findViewById(R.id.textview_hasil_perihal_konsep);



            itemList = (RelativeLayout) itemView.findViewById(R.id.item_list_konsep);
            itemList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    switch (getAdapterPosition()) {
                        case 0:
                            intent = new Intent(context, DetailKonsep.class);




                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);







                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 1:
                            intent = new Intent(context, DetailKonsep.class);


                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);










                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 2:
                            intent = new Intent(context, DetailKonsep.class);




                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);









                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 3:
                            intent = new Intent(context, DetailKonsep.class);




                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);







                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 4:
                            intent = new Intent(context, DetailKonsep.class);



                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);









                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 5:
                            intent = new Intent(context, DetailKonsep.class);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);









                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 6:
                            intent = new Intent(context, DetailKonsep.class);




                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);









                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 7:
                            intent = new Intent(context, DetailKonsep.class);




                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);







                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 8:
                            intent = new Intent(context, DetailKonsep.class);


                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);










                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 9:
                            intent = new Intent(context, DetailKonsep.class);




                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);









                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 10:
                            intent = new Intent(context, DetailKonsep.class);




                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);







                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 11:
                            intent = new Intent(context, DetailKonsep.class);



                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);









                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 12:
                            intent = new Intent(context, DetailKonsep.class);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);









                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 13:
                            intent = new Intent(context, DetailKonsep.class);




                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);









                            //intent.putExtra("token_disposisi", no_surat);

                            break;

                            case 14:
                            intent = new Intent(context, DetailKonsep.class);




                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);







                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 15:
                            intent = new Intent(context, DetailKonsep.class);


                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);










                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 16:
                            intent = new Intent(context, DetailKonsep.class);




                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);









                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 17:
                            intent = new Intent(context, DetailKonsep.class);




                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);







                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 18:
                            intent = new Intent(context, DetailKonsep.class);



                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);









                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 19:
                            intent = new Intent(context, DetailKonsep.class);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);









                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 20:
                            intent = new Intent(context, DetailKonsep.class);




                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);









                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 21:
                            intent = new Intent(context, DetailKonsep.class);




                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);







                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 22:
                            intent = new Intent(context, DetailKonsep.class);


                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);










                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 23:
                            intent = new Intent(context, DetailKonsep.class);




                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);









                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 24:
                            intent = new Intent(context, DetailKonsep.class);




                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);







                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 25:
                            intent = new Intent(context, DetailKonsep.class);



                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);









                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 26:
                            intent = new Intent(context, DetailKonsep.class);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);









                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 27:
                            intent = new Intent(context, DetailKonsep.class);




                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);









                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 28:
                            intent = new Intent(context, DetailKonsep.class);




                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);







                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 29:
                            intent = new Intent(context, DetailKonsep.class);


                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);










                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 30:
                            intent = new Intent(context, DetailKonsep.class);




                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);









                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 31:
                            intent = new Intent(context, DetailKonsep.class);




                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);







                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 32:
                            intent = new Intent(context, DetailKonsep.class);



                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);









                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 33:
                            intent = new Intent(context, DetailKonsep.class);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);









                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 34:
                            intent = new Intent(context, DetailKonsep.class);




                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);









                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 35:
                            intent = new Intent(context, DetailKonsep.class);




                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);







                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 36:
                            intent = new Intent(context, DetailKonsep.class);


                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);










                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 37:
                            intent = new Intent(context, DetailKonsep.class);




                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);









                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 38:
                            intent = new Intent(context, DetailKonsep.class);




                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);







                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 39:
                            intent = new Intent(context, DetailKonsep.class);



                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);









                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 40:
                            intent = new Intent(context, DetailKonsep.class);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);









                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 41:
                            intent = new Intent(context, DetailKonsep.class);




                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);









                            //intent.putExtra("token_disposisi", no_surat);

                            break;

                            case 42:
                            intent = new Intent(context, DetailKonsep.class);




                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);







                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 43:
                            intent = new Intent(context, DetailKonsep.class);


                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);










                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 44:
                            intent = new Intent(context, DetailKonsep.class);




                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);









                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 45:
                            intent = new Intent(context, DetailKonsep.class);




                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);







                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 46:
                            intent = new Intent(context, DetailKonsep.class);



                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);









                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 47:
                            intent = new Intent(context, DetailKonsep.class);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);









                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 48:
                            intent = new Intent(context, DetailKonsep.class);




                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);









                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 49:
                            intent = new Intent(context, DetailKonsep.class);




                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);







                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 50:
                            intent = new Intent(context, DetailKonsep.class);


                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);










                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 51:
                            intent = new Intent(context, DetailKonsep.class);




                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);









                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 52:
                            intent = new Intent(context, DetailKonsep.class);




                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);







                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 53:
                            intent = new Intent(context, DetailKonsep.class);



                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);









                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 54:
                            intent = new Intent(context, DetailKonsep.class);





                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
                            intent.putExtra("data1", data1);









                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 55:
                            intent = new Intent(context, DetailKonsep.class);




                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("urutan_pemeriksa", urutan_pemeriksa);
                            intent.putExtra("id_user_pemeriksa", id_user_pemeriksa);
                            intent.putExtra("id_user_pemeriksa_konsep", id_user_pemeriksa_konsep);
                            intent.putExtra("surat_title", surat_title);
                            intent.putExtra("surat_name", surat_name);
                            intent.putExtra("surat_link", surat_link);
                            intent.putExtra("status_surat", status_surat);
                            intent.putExtra("id_naskah", id_naskah);
                            intent.putExtra("token_surat", token_surat);
                            intent.putExtra("user_pemeriksa", user_pemeriksa);
                            intent.putExtra("atas_nama", atas_nama);
                            intent.putExtra("id_atas_nama", id_atas_nama);
                            intent.putExtra("perihal_surat", perihal_surat);
                            intent.putExtra("nama_naskah", nama_naskah);
                            intent.putExtra("tgl_surat", tgl_surat);
                            intent.putExtra("tgl_surat_format", tgl_surat_format);
                            intent.putExtra("id_user_pemeriksa_tolak", id_user_pemeriksa_tolak);
                            intent.putExtra("id_tembusan", id_tembusan);
                            intent.putExtra("nama_tembusan", nama_tembusan);
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
