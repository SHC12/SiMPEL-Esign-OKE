package com.egov.win10.simpelv.data;

/**
 * Created by win10 on 04/07/2019.
 */

public class DataSuratKeluar {

    public String no;
    public String id_surat;
    public String surat_title;
    public String surat_name;
    public String surat_link;
    public String status_surat;
    public String id_naskah;
    public String token_surat;
    public String no_surat_keluar;
    public String id_user_penerima;
    public String nama_penerima;
    public String atas_nama;
    public String perihal_surat;
    public String jenis_surat;
    public String tgl_surat_format;
    public String tgl_surat;
    public String no_agenda_keluar;

    public DataSuratKeluar() {
    }

    public DataSuratKeluar(String no, String id_surat, String surat_title, String surat_name, String surat_link, String status_surat, String id_naskah, String token_surat, String no_surat_keluar, String id_user_penerima, String nama_penerima, String atas_nama, String perihal_surat, String jenis_surat, String tgl_surat_format, String tgl_surat, String no_agenda_keluar) {
        this.no = no;
        this.id_surat = id_surat;
        this.surat_title = surat_title;
        this.surat_name = surat_name;
        this.surat_link = surat_link;
        this.status_surat = status_surat;
        this.id_naskah = id_naskah;
        this.token_surat = token_surat;
        this.no_surat_keluar = no_surat_keluar;
        this.id_user_penerima = id_user_penerima;
        this.nama_penerima = nama_penerima;
        this.atas_nama = atas_nama;
        this.perihal_surat = perihal_surat;
        this.jenis_surat = jenis_surat;
        this.tgl_surat_format = tgl_surat_format;
        this.tgl_surat = tgl_surat;
        this.no_agenda_keluar = no_agenda_keluar;
    }

    public String getNo_agenda_keluar() {
        return no_agenda_keluar;
    }

    public void setNo_agenda_keluar(String no_agenda_keluar) {
        this.no_agenda_keluar = no_agenda_keluar;
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

    public String getSurat_title() {
        return surat_title;
    }

    public void setSurat_title(String surat_title) {
        this.surat_title = surat_title;
    }

    public String getSurat_name() {
        return surat_name;
    }

    public void setSurat_name(String surat_name) {
        this.surat_name = surat_name;
    }

    public String getSurat_link() {
        return surat_link;
    }

    public void setSurat_link(String surat_link) {
        this.surat_link = surat_link;
    }

    public String getStatus_surat() {
        return status_surat;
    }

    public void setStatus_surat(String status_surat) {
        this.status_surat = status_surat;
    }

    public String getId_naskah() {
        return id_naskah;
    }

    public void setId_naskah(String id_naskah) {
        this.id_naskah = id_naskah;
    }

    public String getToken_surat() {
        return token_surat;
    }

    public void setToken_surat(String token_surat) {
        this.token_surat = token_surat;
    }

    public String getNo_surat_keluar() {
        return no_surat_keluar;
    }

    public void setNo_surat_keluar(String no_surat_keluar) {
        this.no_surat_keluar = no_surat_keluar;
    }

    public String getId_user_penerima() {
        return id_user_penerima;
    }

    public void setId_user_penerima(String id_user_penerima) {
        this.id_user_penerima = id_user_penerima;
    }

    public String getNama_penerima() {
        return nama_penerima;
    }

    public void setNama_penerima(String nama_penerima) {
        this.nama_penerima = nama_penerima;
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

    public String getJenis_surat() {
        return jenis_surat;
    }

    public void setJenis_surat(String jenis_surat) {
        this.jenis_surat = jenis_surat;
    }

    public String getTgl_surat_format() {
        return tgl_surat_format;
    }

    public void setTgl_surat_format(String tgl_surat_format) {
        this.tgl_surat_format = tgl_surat_format;
    }

    public String getTgl_surat() {
        return tgl_surat;
    }

    public void setTgl_surat(String tgl_surat) {
        this.tgl_surat = tgl_surat;
    }
}
