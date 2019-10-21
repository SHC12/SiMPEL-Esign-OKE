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

import com.egov.win10.simpelv.DetailDisposisiMasuk;
import com.egov.win10.simpelv.R;
import com.egov.win10.simpelv.data.DataDisposisiMasuk;

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
        holder.id_disposisi_masuk = (listDataDisposisiMasuk.get(position).getId_disposisi_masuk());

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
        private String id_disposisi_masuk;
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
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 1:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 2:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 3:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 4:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 5:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 6:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 7:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 8:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 9:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 10:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 11:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 12:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 13:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 14:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 15:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 16:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 17:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 18:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 19:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 20:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 21:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 22:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 23:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 24:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 25:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 26:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 27:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 28:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 29:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 30:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 31:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 32:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 33:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 34:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 35:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 36:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 37:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 38:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 39:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 40:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 41:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 42:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 43:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 44:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 45:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 46:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 47:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 48:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 49:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 50:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 51:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 52:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 53:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 54:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 55:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 56:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 57:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 58:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 59:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 60:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 61:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 62:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 63:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 64:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 65:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 66:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 67:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 68:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 69:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 70:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 72:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 73:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 74:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 75:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 76:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 77:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 78:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 79:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 80:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 81:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 82:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 83:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 84:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 85:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 86:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 87:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 88:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 89:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 90:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 91:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 92:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 93:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 94:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 95:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 96:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 97:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 98:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 99:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 100:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 101:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 102:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 103:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 104:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 105:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 106:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 107:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 108:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 109:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 110:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 111:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 112:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 113:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 114:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 115:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 116:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 117:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 118:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 119:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 120:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 121:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 122:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 123:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 124:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 125:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 126:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 127:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 128:
                            intent = new Intent(context, DetailDisposisiMasuk.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi_masuk", id_disposisi_masuk);
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
