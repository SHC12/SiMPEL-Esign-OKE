package com.egov.win10.simpelv.data;

/**
 * Created by win10 on 29/04/2019.
 */

public class DataSpinnerPenerimaDisposisi {

    private String id_user;
    private String id_instansi;
    private String nama_jabatan;
    private String nama_lengkap;


    public DataSpinnerPenerimaDisposisi(String id_user, String id_instansi, String nama_jabatan, String nama_lengkap) {
        this.id_user = id_user;
        this.id_instansi = id_instansi;
        this.nama_jabatan = nama_jabatan;
        this.nama_lengkap = nama_lengkap;
    }

    public DataSpinnerPenerimaDisposisi() {

    }

    public String getId_instansi() {
        return id_instansi;
    }

    public void setId_instansi(String id_instansi) {
        this.id_instansi = id_instansi;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getNama_jabatan() {
        return nama_jabatan;
    }

    public void setNama_jabatan(String nama_jabatan) {
        this.nama_jabatan = nama_jabatan;
    }

    public String getNama_lengkap() {
        return nama_lengkap;
    }

    public void setNama_lengkap(String nama_lengkap) {
        this.nama_lengkap = nama_lengkap;
    }


}
