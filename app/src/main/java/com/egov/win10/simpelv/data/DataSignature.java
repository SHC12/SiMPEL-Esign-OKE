package com.egov.win10.simpelv.data;

/**
 * Created by win10 on 26/06/2019.
 */

public class DataSignature {

    public String no;
    public String token_surat;
    public String id_surat;
    public String id_tujuan;
    public String id_instansi;
    public String nama_tujuan;
    public String status_surat;
    public String nomor_surat;
    public String no_agenda_keluar;
    public String tgl_surat_keluar;
    public String nama_naskah;
    public String nama_status_surat;
    public String nama_pengirim;
    public String id_naskah;
    public String user_pemeriksa;
    public String atas_nama;
    public String perihal_surat;
    public String tgl_surat;
    public String tgl_surat_format;
    public String tembusan;


    public DataSignature() {
    }

    public DataSignature(String no, String token_surat, String id_surat, String id_tujuan, String id_instansi, String nama_tujuan, String status_surat, String nomor_surat, String no_agenda_keluar, String tgl_surat_keluar, String nama_naskah, String nama_status_surat, String nama_pengirim, String id_naskah, String user_pemeriksa, String atas_nama, String perihal_surat, String tgl_surat, String tgl_surat_format, String tembusan) {
        this.no = no;
        this.token_surat = token_surat;
        this.id_surat = id_surat;
        this.id_tujuan = id_tujuan;
        this.id_instansi = id_instansi;
        this.nama_tujuan = nama_tujuan;
        this.status_surat = status_surat;
        this.nomor_surat = nomor_surat;
        this.no_agenda_keluar = no_agenda_keluar;
        this.tgl_surat_keluar = tgl_surat_keluar;
        this.nama_naskah = nama_naskah;
        this.nama_status_surat = nama_status_surat;
        this.nama_pengirim = nama_pengirim;
        this.id_naskah = id_naskah;
        this.user_pemeriksa = user_pemeriksa;
        this.atas_nama = atas_nama;
        this.perihal_surat = perihal_surat;
        this.tgl_surat = tgl_surat;
        this.tgl_surat_format = tgl_surat_format;
        this.tembusan = tembusan;
    }

    public String getTembusan() {
        return tembusan;
    }

    public void setTembusan(String tembusan) {
        this.tembusan = tembusan;
    }

    public String getId_instansi() {
        return id_instansi;
    }

    public void setId_instansi(String id_instansi) {
        this.id_instansi = id_instansi;
    }

    public String getTgl_surat_format() {
        return tgl_surat_format;
    }

    public void setTgl_surat_format(String tgl_surat_format) {
        this.tgl_surat_format = tgl_surat_format;
    }

    public String getNama_pengirim() {
        return nama_pengirim;
    }

    public void setNama_pengirim(String nama_pengirim) {
        this.nama_pengirim = nama_pengirim;
    }

    public String getId_tujuan() {
        return id_tujuan;
    }

    public void setId_tujuan(String id_tujuan) {
        this.id_tujuan = id_tujuan;
    }

    public String getNama_tujuan() {
        return nama_tujuan;
    }

    public void setNama_tujuan(String nama_tujuan) {
        this.nama_tujuan = nama_tujuan;
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

    public String getNo_agenda_keluar() {
        return no_agenda_keluar;
    }

    public void setNo_agenda_keluar(String no_agenda_keluar) {
        this.no_agenda_keluar = no_agenda_keluar;
    }

    public String getTgl_surat_keluar() {
        return tgl_surat_keluar;
    }

    public void setTgl_surat_keluar(String tgl_surat_keluar) {
        this.tgl_surat_keluar = tgl_surat_keluar;
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

    public String getId_naskah() {
        return id_naskah;
    }

    public void setId_naskah(String id_naskah) {
        this.id_naskah = id_naskah;
    }

    public String getUser_pemeriksa() {
        return user_pemeriksa;
    }

    public void setUser_pemeriksa(String user_pemeriksa) {
        this.user_pemeriksa = user_pemeriksa;
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

    public String getTgl_surat() {
        return tgl_surat;
    }

    public void setTgl_surat(String tgl_surat) {
        this.tgl_surat = tgl_surat;
    }
}
