package com.example.win10.simpelv.data;

/**
 * Created by win10 on 25/03/2019.
 */

public class DataDetailDisposisiMasuk {
    private String id_surat;
    private String token_disposisi;
    private String token_surat;
    private String no_surat_manual;
    private String tgl_surat;
    private String tgl_selesai;
    private String nama_naskah;
    private String nama_lengkap_penerima;
    private String nama_jabatan_penerima;
    private String nama_golongan_penerima;
    private String nama_pengirim;
    private String instansi_pengirim;
    private String alamat_instansi;
    private String isi_disposisi;
    private String nama_instruksi;

    public DataDetailDisposisiMasuk(String id_surat, String token_disposisi, String token_surat, String no_surat_manual, String tgl_surat, String tgl_selesai, String nama_naskah, String nama_lengkap_penerima, String nama_jabatan_penerima, String nama_golongan_penerima, String nama_pengirim, String instansi_pengirim, String alamat_instansi, String isi_disposisi, String nama_instruksi) {
        this.id_surat = id_surat;
        this.token_disposisi = token_disposisi;
        this.token_surat = token_surat;
        this.no_surat_manual = no_surat_manual;
        this.tgl_surat = tgl_surat;
        this.tgl_selesai = tgl_selesai;
        this.nama_naskah = nama_naskah;
        this.nama_lengkap_penerima = nama_lengkap_penerima;
        this.nama_jabatan_penerima = nama_jabatan_penerima;
        this.nama_golongan_penerima = nama_golongan_penerima;
        this.nama_pengirim = nama_pengirim;
        this.instansi_pengirim = instansi_pengirim;
        this.alamat_instansi = alamat_instansi;
        this.isi_disposisi = isi_disposisi;
        this.nama_instruksi = nama_instruksi;
    }

    public DataDetailDisposisiMasuk() {
    }

    public String getId_surat() {
        return id_surat;
    }

    public void setId_surat(String id_surat) {
        this.id_surat = id_surat;
    }

    public String getToken_disposisi() {
        return token_disposisi;
    }

    public void setToken_disposisi(String token_disposisi) {
        this.token_disposisi = token_disposisi;
    }

    public String getToken_surat() {
        return token_surat;
    }

    public void setToken_surat(String token_surat) {
        this.token_surat = token_surat;
    }

    public String getNo_surat_manual() {
        return no_surat_manual;
    }

    public void setNo_surat_manual(String no_surat_manual) {
        this.no_surat_manual = no_surat_manual;
    }

    public String getTgl_surat() {
        return tgl_surat;
    }

    public void setTgl_surat(String tgl_surat) {
        this.tgl_surat = tgl_surat;
    }

    public String getTgl_selesai() {
        return tgl_selesai;
    }

    public void setTgl_selesai(String tgl_selesai) {
        this.tgl_selesai = tgl_selesai;
    }

    public String getNama_naskah() {
        return nama_naskah;
    }

    public void setNama_naskah(String nama_naskah) {
        this.nama_naskah = nama_naskah;
    }

    public String getNama_lengkap_penerima() {
        return nama_lengkap_penerima;
    }

    public void setNama_lengkap_penerima(String nama_lengkap_penerima) {
        this.nama_lengkap_penerima = nama_lengkap_penerima;
    }

    public String getNama_jabatan_penerima() {
        return nama_jabatan_penerima;
    }

    public void setNama_jabatan_penerima(String nama_jabatan_penerima) {
        this.nama_jabatan_penerima = nama_jabatan_penerima;
    }

    public String getNama_golongan_penerima() {
        return nama_golongan_penerima;
    }

    public void setNama_golongan_penerima(String nama_golongan_penerima) {
        this.nama_golongan_penerima = nama_golongan_penerima;
    }

    public String getNama_pengirim() {
        return nama_pengirim;
    }

    public void setNama_pengirim(String nama_pengirim) {
        this.nama_pengirim = nama_pengirim;
    }

    public String getInstansi_pengirim() {
        return instansi_pengirim;
    }

    public void setInstansi_pengirim(String instansi_pengirim) {
        this.instansi_pengirim = instansi_pengirim;
    }

    public String getAlamat_instansi() {
        return alamat_instansi;
    }

    public void setAlamat_instansi(String alamat_instansi) {
        this.alamat_instansi = alamat_instansi;
    }

    public String getIsi_disposisi() {
        return isi_disposisi;
    }

    public void setIsi_disposisi(String isi_disposisi) {
        this.isi_disposisi = isi_disposisi;
    }

    public String getNama_instruksi() {
        return nama_instruksi;
    }

    public void setNama_instruksi(String nama_instruksi) {
        this.nama_instruksi = nama_instruksi;
    }
}
