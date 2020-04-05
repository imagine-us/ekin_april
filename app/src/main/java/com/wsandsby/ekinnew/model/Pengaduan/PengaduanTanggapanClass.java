package com.wsandsby.ekinnew.model.Pengaduan;

import com.google.gson.annotations.SerializedName;

public class PengaduanTanggapanClass {

    @SerializedName("pengaduan")
    private String isiPengaduan;

    @SerializedName("subjek")
    private String subjekPengaduan;

    public String getSubjekPengaduan() {
        return subjekPengaduan;
    }

    public void setSubjekPengaduan(String subjekPengaduan) {
        this.subjekPengaduan = subjekPengaduan;
    }

    @SerializedName("tanggal_pengaduan")
    private String tanggalPengaduan;

    @SerializedName("tanggapan")
    private String isiTanggapan;

    @SerializedName("tanggal_tanggapan")
    private String tanggalTanggapan;

    public PengaduanTanggapanClass(String isiPengaduan, String tanggalPengaduan, String isiTanggapan, String tanggalTanggapan) {
        this.isiPengaduan = isiPengaduan;
        this.tanggalPengaduan = tanggalPengaduan;
        this.isiTanggapan = isiTanggapan;
        this.tanggalTanggapan = tanggalTanggapan;
    }

    public String getIsiPengaduan() {
        return isiPengaduan;
    }

    public void setIsiPengaduan(String isiPengaduan) {
        this.isiPengaduan = isiPengaduan;
    }

    public String getTanggalPengaduan() {
        return tanggalPengaduan;
    }

    public void setTanggalPengaduan(String tanggalPengaduan) {
        this.tanggalPengaduan = tanggalPengaduan;
    }

    public String getIsiTanggapan() {
        return isiTanggapan;
    }

    public void setIsiTanggapan(String isiTanggapan) {
        this.isiTanggapan = isiTanggapan;
    }

    public String getTanggalTanggapan() {
        return tanggalTanggapan;
    }

    public void setTanggalTanggapan(String tanggalTanggapan) {
        this.tanggalTanggapan = tanggalTanggapan;
    }
}
