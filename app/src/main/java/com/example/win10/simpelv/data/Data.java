package com.example.win10.simpelv.data;

/**
 * Created by win10 on 20/03/2019.
 */

public class Data {
    private String idSurat;
    private String id_disposisi;
    private String id_instansi;
    private String id_user;
    private String noSurat;
    private String pengirimSurat;
    private String perihalSurat;
    private String statusDisposisi;
    private String statusPenerima;
    private String tanggalSurat;
    private String token_disposisi;

    public Data(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.id_user = str;
        this.id_instansi = str3;
        this.token_disposisi = str2;
        this.idSurat = str4;
        this.id_disposisi = str5;
        this.tanggalSurat = str6;
        this.perihalSurat = str7;
        this.pengirimSurat = str8;
        this.noSurat = str9;
        this.statusPenerima = str10;
        this.statusDisposisi = str11;
    }

    public Data() {

    }


    public String getId_user() {
        return this.id_user;
    }

    public void setId_user(String str) {
        this.id_user = str;
    }

    public String getId_instansi() {
        return this.id_instansi;
    }

    public void setId_instansi(String str) {
        this.id_instansi = str;
    }

    public String getToken_disposisi() {
        return this.token_disposisi;
    }

    public void setToken_disposisi(String str) {
        this.token_disposisi = str;
    }

    public String getIdSurat() {
        return this.idSurat;
    }

    public String setIdSurat(String str) {
        this.idSurat = str;
        return str;
    }

    public String getId_disposisi() {
        return this.id_disposisi;
    }

    public void setId_disposisi(String str) {
        this.id_disposisi = str;
    }

    public String getTanggalSurat() {
        return this.tanggalSurat;
    }

    public String setTanggalSurat(String str) {
        this.tanggalSurat = str;
        return str;
    }

    public String getPerihalSurat() {
        return this.perihalSurat;
    }

    public String setPerihalSurat(String str) {
        this.perihalSurat = str;
        return str;
    }

    public String getPengirimSurat() {
        return this.pengirimSurat;
    }

    public String setPengirimSurat(String str) {
        this.pengirimSurat = str;
        return str;
    }

    public String getNoSurat() {
        return this.noSurat;
    }

    public String setNoSurat(String str) {
        this.noSurat = str;
        return str;
    }

    public String getStatusPenerima() {
        return this.statusPenerima;
    }

    public String setStatusPenerima(String str) {
        this.statusPenerima = str;
        return str;
    }

    public String getStatusDisposisi() {
        return this.statusDisposisi;
    }

    public String setStatusDisposisi(String str) {
        this.statusDisposisi = str;
        return str;
    }
}
