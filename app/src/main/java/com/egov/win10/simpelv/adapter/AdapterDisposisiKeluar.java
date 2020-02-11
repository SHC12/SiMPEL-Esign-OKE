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

import com.egov.win10.simpelv.DetailDisposisiKeluar;
import com.egov.win10.simpelv.R;
import com.egov.win10.simpelv.data.DataDisposisiKeluar;

import java.util.ArrayList;

/**
 * Created by win10 on 26/04/2019.
 */

public class AdapterDisposisiKeluar extends RecyclerView.Adapter<AdapterDisposisiKeluar.ViewHolder> {

    private ArrayList<DataDisposisiKeluar> listDataDisposisiKeluar;
    private Activity activity;
    private Context context;

    public int data;

    public AdapterDisposisiKeluar(ArrayList<DataDisposisiKeluar> listDataDisposisiKeluar, Activity activity) {
        this.listDataDisposisiKeluar = listDataDisposisiKeluar;
        this.activity = activity;

    }

    @Override
    public AdapterDisposisiKeluar.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_disposisi_keluar, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(AdapterDisposisiKeluar.ViewHolder holder, int position) {
        holder.tvNo.setText(listDataDisposisiKeluar.get(position).getNo());
        holder.tvPerihalSurat.setText(listDataDisposisiKeluar.get(position).getPerihal_surat());
        holder.tvTglSurat.setText(listDataDisposisiKeluar.get(position).getTgl_disposisi());
        //holder.tvTglSurat.setText(listDataDisposisiKeluar.get(position).getTgl_disposisi());
        holder.tvTgl.setText(listDataDisposisiKeluar.get(position).getTgl_surat());
        holder.tvNoSuratManual.setText(listDataDisposisiKeluar.get(position).getNo_surat_manual());
        holder.tvPenerimaSurat.setText(listDataDisposisiKeluar.get(position).getNama_penerima_disposisi());
        //holder.no_surat = (listDataDisposisiKeluar.get(position).getNo_surat_manual());
        holder.id_disposisi = (listDataDisposisiKeluar.get(position).getId_disposisi());
        holder.token_disposisi = (listDataDisposisiKeluar.get(position).getToken_disposisi());
        holder.id_surat = (listDataDisposisiKeluar.get(position).getId_surat());
        holder.tvStatusPenerimaSurat.setText(listDataDisposisiKeluar.get(position).getStatus_penerima());
    }

    @Override
    public int getItemCount() {
        return listDataDisposisiKeluar.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cv;
        public TextView tvNo;
        public TextView tvIdDisposisi;
        public TextView tvTgl;
        public TextView tvTglSurat;
        public TextView tvPerihalSurat;
        public TextView tvPenerimaSurat;
        public TextView tvStatusPenerimaSurat;
        public String tvTokenDisposisii;
        public TextView tvNoSuratManual;
        private RelativeLayout itemList;

        private String token_disposisi;
        private String id_surat, no_surat, id_disposisi;
        private Context context;

        public ViewHolder(View itemView) {
            super(itemView);

            context = itemView.getContext();


            tvNo = (TextView) itemView.findViewById(R.id.textview_hasil_no_suratkeluar);
            tvTgl = (TextView) itemView.findViewById(R.id.textview_hasil_tanggal_disposisieluar);
            tvPenerimaSurat = (TextView) itemView.findViewById(R.id.textview_hasil_penerima_surat_disposisikeluar);
            tvTglSurat = (TextView) itemView.findViewById(R.id.textview_hasil_tanggal_surat_disposisikeluar);
            tvNoSuratManual = (TextView) itemView.findViewById(R.id.textview_hasil_no_surat_disposisikeluar);
            tvPerihalSurat = (TextView) itemView.findViewById(R.id.textview_hasil_perihal_surat_disposisikeluar);
            tvStatusPenerimaSurat = (TextView) itemView.findViewById(R.id.textview_hasil_status_penerima_disposisikeluar);



            itemList = (RelativeLayout) itemView.findViewById(R.id.item_list_surat_keluar);
            itemList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    switch (getAdapterPosition()) {
                        case 0:
                            intent = new Intent(context, DetailDisposisiKeluar.class);

                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi", id_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            //intent.putExtra("token_disposisi", no_surat);

                            break;
                        case 1:
                            intent = new Intent(context, DetailDisposisiKeluar.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_disposisi", id_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 2:
                            intent = new Intent(context, DetailDisposisiKeluar.class);
                            intent.putExtra("id_disposisi", id_disposisi);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 3:
                            intent = new Intent(context, DetailDisposisiKeluar.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);intent.putExtra("id_disposisi", id_disposisi);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 4:
                            intent = new Intent(context, DetailDisposisiKeluar.class);
                            intent.putExtra("id_disposisi", id_disposisi);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 5:
                            intent = new Intent(context, DetailDisposisiKeluar.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);intent.putExtra("id_disposisi", id_disposisi);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 6:
                            intent = new Intent(context, DetailDisposisiKeluar.class);
                            intent.putExtra("id_disposisi", id_disposisi);
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                        case 7:
                            intent = new Intent(context, DetailDisposisiKeluar.class);
                            //String token_disi = intent.getStringExtra("token_disposisi");
                            intent.putExtra("token_disposisi", token_disposisi);
                            intent.putExtra("id_surat", id_surat);intent.putExtra("id_disposisi", id_disposisi);
                            intent.putExtra("no_surat_manual", no_surat);
                            break;
                    }
                    context.startActivity(intent);
                }
            });


        }
    }
}
