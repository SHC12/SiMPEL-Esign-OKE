package com.egov.win10.simpelv.data;

/**
 * Created by win10 on 04/07/2019.
 */

public class DataTembusan {
    public String id_surat;
    public String no;
    public String nama_tujuan;
    public String token_surat;
    public String status_surat;
    public String nomor_surat;
    public String no_agenda_masuk;
    public String nama_naskah;
    public String nama_status_surat;
    public String nama_pengirim;
    public String id_naskah;
    public String atas_nama;
    public String perihal_surat;
    public String tgl_surat_format;
    public String surat_title;


    public DataTembusan() {
    }

    public DataTembusan(String id_surat, String no, String nama_tujuan, String token_surat, String status_surat, String nomor_surat, String no_agenda_masuk, String nama_naskah, String nama_status_surat, String nama_pengirim, String id_naskah, String atas_nama, String perihal_surat, String tgl_surat_format, String surat_title) {
        this.id_surat = id_surat;
        this.no = no;
        this.nama_tujuan = nama_tujuan;
        this.token_surat = token_surat;
        this.status_surat = status_surat;
        this.nomor_surat = nomor_surat;
        this.no_agenda_masuk = no_agenda_masuk;
        this.nama_naskah = nama_naskah;
        this.nama_status_surat = nama_status_surat;
        this.nama_pengirim = nama_pengirim;
        this.id_naskah = id_naskah;
        this.atas_nama = atas_nama;
        this.perihal_surat = perihal_surat;
        this.tgl_surat_format = tgl_surat_format;
        this.surat_title = surat_title;
    }

    public String getSurat_title() {
        return surat_title;
    }

    public void setSurat_title(String surat_title) {
        this.surat_title = surat_title;
    }

    public String getId_surat() {
        return id_surat;
    }

    public void setId_surat(String id_surat) {
        this.id_surat = id_surat;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getNama_tujuan() {
        return nama_tujuan;
    }

    public void setNama_tujuan(String nama_tujuan) {
        this.nama_tujuan = nama_tujuan;
    }

    public String getToken_surat() {
        return token_surat;
    }

    public void setToken_surat(String token_surat) {
        this.token_surat = token_surat;
    }

    public String getStatus_surat() {
        return status_surat;
    }

    public void setStatus_surat(String status_surat) {
        this.status_surat = status_surat;
    }

    public String getNomor_surat() {
        return nomor_surat;
    }

    public void setNomor_surat(String nomor_surat) {
        this.nomor_surat = nomor_surat;
    }

    public String getNo_agenda_masuk() {
        return no_agenda_masuk;
    }

    public void setNo_agenda_masuk(String no_agenda_masuk) {
        this.no_agenda_masuk = no_agenda_masuk;
    }

    public String getNama_naskah() {
        return nama_naskah;
    }

    public void setNama_naskah(String nama_naskah) {
        this.nama_naskah = nama_naskah;
    }

    public String getNama_status_surat() {
        return nama_status_surat;
    }

    public void setNama_status_surat(String nama_status_surat) {
        this.nama_status_surat = nama_status_surat;
    }

    public String getNama_pengirim() {
        return nama_pengirim;
    }

    public void setNama_pengirim(String nama_pengirim) {
        this.nama_pengirim = nama_pengirim;
    }

    public String getId_naskah() {
        return id_naskah;
    }

    public void setId_naskah(String id_naskah) {
        this.id_naskah = id_naskah;
    }

    public String getAtas_nama() {
        return atas_nama;
    }

    public void setAtas_nama(String atas_nama) {
        this.atas_nama = atas_nama;
    }

    public String getPerihal_surat() {
        return perihal_surat;
    }

    public void setPerihal_surat(String perihal_surat) {
        this.perihal_surat = perihal_surat;
    }

    public String getTgl_surat_format() {
        return tgl_surat_format;
    }

    public void setTgl_surat_format(String tgl_surat_format) {
        this.tgl_surat_format = tgl_surat_format;
    }
}
