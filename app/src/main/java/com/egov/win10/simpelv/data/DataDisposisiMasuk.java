package com.egov.win10.simpelv.data;

/**
 * Created by win10 on 22/03/2019.
 */

public class DataDisposisiMasuk {
    private String no;
    private String id_user;
    private String id_surat;
    private String token_disposisi;
    private String id_disposisi_masuk;
    private String tgl_surat;
    private String no_surat_manual;
    private String perihal_surat;
    private String nama_pengirim_disposisi;
    private String status_dis;
    private String nama_status_penerima;

    public DataDisposisiMasuk(String no, String id_user, String id_surat, String token_disposisi, String id_disposisi_masuk, String tgl_surat, String no_surat_manual, String perihal_surat, String nama_pengirim_disposisi, String status_dis, String nama_status_penerima) {
        this.no = no;
        this.id_user = id_user;
        this.id_surat = id_surat;
        this.token_disposisi = token_disposisi;
        this.id_disposisi_masuk = id_disposisi_masuk;
        this.tgl_surat = tgl_surat;
        this.no_surat_manual = no_surat_manual;
        this.perihal_surat = perihal_surat;
        this.nama_pengirim_disposisi = nama_pengirim_disposisi;
        this.status_dis = status_dis;
        this.nama_status_penerima = nama_status_penerima;
    }

    public DataDisposisiMasuk() {
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
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

    public String getId_disposisi_masuk() {
        return id_disposisi_masuk;
    }

    public void setId_disposisi_masuk(String id_disposisi_masuk) {
        this.id_disposisi_masuk = id_disposisi_masuk;
    }

    public String getTgl_surat() {
        return tgl_surat;
    }

    public void setTgl_surat(String tgl_surat) {
        this.tgl_surat = tgl_surat;
    }

    public String getNo_surat_manual() {
        return no_surat_manual;
    }

    public void setNo_surat_manual(String no_surat_manual) {
        this.no_surat_manual = no_surat_manual;
    }

    public String getPerihal_surat() {
        return perihal_surat;
    }

    public void setPerihal_surat(String perihal_surat) {
        this.perihal_surat = perihal_surat;
    }

    public String getNama_pengirim_disposisi() {
        return nama_pengirim_disposisi;
    }

    public void setNama_pengirim_disposisi(String nama_pengirim_disposisi) {
        this.nama_pengirim_disposisi = nama_pengirim_disposisi;
    }

    public String getStatus_dis() {
        return status_dis;
    }

    public void setStatus_dis(String status_dis) {
        this.status_dis = status_dis;
    }

    public String getNama_status_penerima() {
        return nama_status_penerima;
    }

    public void setNama_status_penerima(String nama_status_penerima) {
        this.nama_status_penerima = nama_status_penerima;
    }
}
