package com.example.galonly.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Galon  {
    private Integer id;
    private String nama_galon;
    private String alamat_galon;
    private String telepon;
    private String bukaTutup;
    private Integer jumlah;
    private Integer harga;
    private String image;

    public Galon(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama_galon() {
        return nama_galon;
    }

    public void setNama_galon(String nama_galon) {
        this.nama_galon = nama_galon;
    }

    public String getAlamat_galon() {
        return alamat_galon;
    }

    public void setAlamat_galon(String alamat_galon) {
        this.alamat_galon = alamat_galon;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getBukaTutup() {
        return bukaTutup;
    }

    public void setBukaTutup(String bukaTutup) {
        this.bukaTutup = bukaTutup;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
