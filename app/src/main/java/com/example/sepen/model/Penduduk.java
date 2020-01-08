package com.example.sepen.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Penduduk {
    @Expose
    @SerializedName("id")private int id;
    @Expose
    @SerializedName("provinsi")private String provinsi;
    @Expose
    @SerializedName("kota")private String kota;
    @Expose
    @SerializedName("kecamatan")private String kecamatan;
    @Expose
    @SerializedName("kelurahan")private String kelurahan;
    @Expose
    @SerializedName("rw")private int rw;
    @Expose
    @SerializedName("rt")private int rt;
    @Expose
    @SerializedName("k_keluarga")private int k_keluarga;
    @Expose
    @SerializedName("jml_penduduk")private int jml_penduduk;
    @Expose
    @SerializedName("petugas")private String petugas;
    @Expose
    @SerializedName("success")private Boolean success;
    @Expose
    @SerializedName("message")private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(String kelurahan) {
        this.kelurahan = kelurahan;
    }

    public int getRw() {
        return rw;
    }

    public void setRw(int rw) {
        this.rw = rw;
    }

    public int getRt() {
        return rt;
    }

    public void setRt(int rt) {
        this.rt = rt;
    }

    public int getK_keluarga() {
        return k_keluarga;
    }

    public void setK_keluarga(int k_keluarga) {
        this.k_keluarga = k_keluarga;
    }

    public int getJml_penduduk() {
        return jml_penduduk;
    }

    public void setJml_penduduk(int jml_penduduk) {
        this.jml_penduduk = jml_penduduk;
    }

    public String getPetugas() {
        return petugas;
    }

    public void setPetugas(String petugas) {
        this.petugas = petugas;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
