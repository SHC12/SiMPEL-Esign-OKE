package com.example.win10.simpelv.data;

/**
 * Created by win10 on 26/04/2019.
 */

public class DataDisposisiKeluar {

    private String no = "";
    private String id_disposisi = "";
    private String id_surat = "";
    private String  tgl_surat = "";
    private String  token_disposisi = "";
    private String  tgl_disposisi =  "";
    private String perihal_surat = "";
    private String nama_penerima_disposisi = "";
    private String no_surat_manual = "";

    public DataDisposisiKeluar(String no, String id_disposisi, String id_surat, String tgl_surat, String token_disposisi, String tgl_disposisi, String perihal_surat, String nama_penerima_disposisi,String no_surat_manual) {
        this.no = no;
        this.id_disposisi = id_disposisi;
        this.id_surat = id_surat;
        this.tgl_surat = tgl_surat;
        this.token_disposisi = token_disposisi;
        this.tgl_disposisi = tgl_disposisi;
        this.perihal_surat = perihal_surat;
        this.nama_penerima_disposisi = nama_penerima_disposisi;
        this.no_surat_manual = no_surat_manual;
    }

    public String getNama_penerima_disposisi() {
        return nama_penerima_disposisi;
    }

    public void setNama_penerima_disposisi(String nama_penerima_disposisi) {
        this.nama_penerima_disposisi = nama_penerima_disposisi;
    }

    public String getId_surat() {
        return id_surat;
    }

    public void setId_surat(String id_surat) {
        this.id_surat = id_surat;
    }

    public DataDisposisiKeluar() {
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getId_disposisi() {
        return id_disposisi;
    }

    public void setId_disposisi(String id_disposisi) {
        this.id_disposisi = id_disposisi;
    }

    public String getTgl_surat() {
        return tgl_surat;
    }

    public void setTgl_surat(String tgl_surat) {
        this.tgl_surat = tgl_surat;
    }

    public String getToken_disposisi() {
        return token_disposisi;
    }

    public void setToken_disposisi(String token_disposisi) {
        this.token_disposisi = token_disposisi;
    }

    public String getTgl_disposisi() {
        return tgl_disposisi;
    }

    public void setTgl_disposisi(String tgl_disposisi) {
        this.tgl_disposisi = tgl_disposisi;
    }

    public String getPerihal_surat() {
        return perihal_surat;
    }

    public void setPerihal_surat(String perihal_surat) {
        this.perihal_surat = perihal_surat;
    }

    public String getNo_surat_manual() {
        return no_surat_manual;
    }

    public void setNo_surat_manual(String no_surat_manual) {
        this.no_surat_manual = no_surat_manual;
    }
}
