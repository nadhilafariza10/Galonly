package com.example.galonly;

import android.os.Parcel;
import android.os.Parcelable;

public class Galon implements Parcelable {
    private String name;
    private String detail;
    private String bukaTutup;
    private String harga;
    private int photo;

    public Galon(){

    }

    protected Galon(Parcel in) {
        name = in.readString();
        detail = in.readString();
        photo = in.readInt();
        bukaTutup = in.readString();
        harga = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(detail);
        dest.writeInt(photo);
        dest.writeString(bukaTutup);
        dest.writeString(harga);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Galon> CREATOR = new Creator<Galon>() {
        @Override
        public Galon createFromParcel(Parcel in) {
            return new Galon(in);
        }

        @Override
        public Galon[] newArray(int size) {
            return new Galon[size];
        }
    };

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getBukaTutup() { return bukaTutup; }

    public void setBukaTutup(String bukaTutup) { this.bukaTutup = bukaTutup; }

    public String getHarga() { return harga; }

    public void setHarga(String harga) { this.harga = harga; }
}
