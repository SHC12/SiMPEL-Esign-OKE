package com.egov.win10.simpelv.data;

/**
 * Created by win10 on 25/07/2019.
 */

public class DataAgendaMasuk {

    private String no;
    private String id_surat;
    private String nama_naskah;
    private String token_surat;
    private String perihal_surat;
    private String tgl_surat;
    private String tgl_surat_masuk;
    private String tgl_surat_format;
    private String surat_title;
    private String surat_name;
    private String surat_link;
    private String atas_nama;
    private String status_penerima;
    private String no_surat_keluar;
    private String no_agenda_masuk;


    public DataAgendaMasuk() {
    }

    public DataAgendaMasuk(String no, String id_surat, String nama_naskah, String token_surat, String perihal_surat, String tgl_surat, String tgl_surat_masuk, String tgl_surat_format, String surat_title, String surat_name, String surat_link, String atas_nama, String status_penerima, String no_surat_keluar, String no_agenda_masuk) {
        this.no = no;
        this.id_surat = id_surat;
        this.nama_naskah = nama_naskah;
        this.token_surat = token_surat;
        this.perihal_surat = perihal_surat;
        this.tgl_surat = tgl_surat;
        this.tgl_surat_masuk = tgl_surat_masuk;
        this.tgl_surat_format = tgl_surat_format;
        this.surat_title = surat_title;
        this.surat_name = surat_name;
        this.surat_link = surat_link;
        this.atas_nama = atas_nama;
        this.status_penerima = status_penerima;
        this.no_surat_keluar = no_surat_keluar;
        this.no_agenda_masuk = no_agenda_masuk;
    }

    public String getTgl_surat_masuk() {
        return tgl_surat_masuk;
    }

    public void setTgl_surat_masuk(String tgl_surat_masuk) {
        this.tgl_surat_masuk = tgl_surat_masuk;
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

    public String getNama_naskah() {
        return nama_naskah;
    }

    public void setNama_naskah(String nama_naskah) {
        this.nama_naskah = nama_naskah;
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

    public String getTgl_surat_format() {
        return tgl_surat_format;
    }

    public void setTgl_surat_format(String tgl_surat_format) {
        this.tgl_surat_format = tgl_surat_format;
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

    public String getAtas_nama() {
        return atas_nama;
    }

    public void setAtas_nama(String atas_nama) {
        this.atas_nama = atas_nama;
    }

    public String getStatus_penerima() {
        return status_penerima;
    }

    public void setStatus_penerima(String status_penerima) {
        this.status_penerima = status_penerima;
    }

    public String getNo_surat_keluar() {
        return no_surat_keluar;
    }

    public void setNo_surat_keluar(String no_surat_keluar) {
        this.no_surat_keluar = no_surat_keluar;
    }

    public String getNo_agenda_masuk() {
        return no_agenda_masuk;
    }

    public void setNo_agenda_masuk(String no_agenda_masuk) {
        this.no_agenda_masuk = no_agenda_masuk;
    }
}
