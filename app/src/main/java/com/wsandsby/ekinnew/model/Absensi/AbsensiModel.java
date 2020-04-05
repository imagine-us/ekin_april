package com.wsandsby.ekinnew.model.Absensi;

import com.google.gson.annotations.SerializedName;

import java.util.List;

//kelas untuk menerima pengembalian dari server.

public class AbsensiModel {
    @SerializedName("status")
    private String status;

    @SerializedName("data")
    private List<Absensi> listAbsensi;

    public AbsensiModel(String status, List<Absensi> listAbsensi) {
        this.status = status;
        this.listAbsensi = listAbsensi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Absensi> getListAbsensi() {
        return listAbsensi;
    }

    public void setListAbsensi(List<Absensi> listAbsensi) {
        this.listAbsensi = listAbsensi;
    }
}
