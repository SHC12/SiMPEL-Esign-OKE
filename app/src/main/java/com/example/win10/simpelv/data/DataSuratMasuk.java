package com.example.win10.simpelv.data;

/**
 * Created by win10 on 20/03/2019.
 */

public class DataSuratMasuk {
   private String no;
   private String id_surat;
   private String token_surat;
   private String perihal_surat;
   private String tgl_surat;
   private String nama_pengirim;
   private String status_penerima;
   private String no_surat_manual;

    public DataSuratMasuk(String no, String id_surat, String token_surat, String perihal_surat, String tgl_surat, String nama_pengirim, String status_penerima, String no_surat_manual) {
        this.no = no;
        this.id_surat = id_surat;
        this.token_surat = token_surat;
        this.perihal_surat = perihal_surat;
        this.tgl_surat = tgl_surat;
        this.nama_pengirim = nama_pengirim;
        this.status_penerima = status_penerima;
        this.no_surat_manual = no_surat_manual;
    }

    public DataSuratMasuk() {
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getId_surat() {
        return id_surat;
    }

    public void setId_surat(String id_surat) {
        this.id_surat = id_surat;
    }

    public String getToken_surat() {
        return token_surat;
    }

    public void setToken_surat(String token_surat) {
        this.token_surat = token_surat;
    }

    public String getPerihal_surat() {
        return perihal_surat;
    }

    public void setPerihal_surat(String perihal_surat) {
        this.perihal_surat = perihal_surat;
    }

    public String getTgl_surat() {
        return tgl_surat;
    }

    public void setTgl_surat(String tgl_surat) {
        this.tgl_surat = tgl_surat;
    }

    public String getNama_pengirim() {
        return nama_pengirim;
    }

    public void setNama_pengirim(String nama_pengirim) {
        this.nama_pengirim = nama_pengirim;
    }

    public String getStatus_penerima() {
        return status_penerima;
    }

    public void setStatus_penerima(String status_penerima) {
        this.status_penerima = status_penerima;
    }

    public String getNo_surat_manual() {
        return no_surat_manual;
    }

    public void setNo_surat_manual(String no_surat_manual) {
        this.no_surat_manual = no_surat_manual;
    }
}
