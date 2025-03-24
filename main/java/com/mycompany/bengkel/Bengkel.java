package com.mycompany.bengkel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Bengkel {
    private int id;
    private String nama;
    private String layanan;
    private boolean isSelesai;
    private String tanggalMasuk;
    
    public Bengkel(int id, String nama, String layanan, boolean isSelesai, String tanggalMasuk){
        this.id = id;
        this.nama = nama;
        this.layanan = layanan;
        this.isSelesai = isSelesai;
        this.tanggalMasuk = tanggalMasuk;
    }
    
    public Bengkel(String nama, String layanan){
        this.nama = nama;
        this.layanan = layanan;
        this.isSelesai = false;
    }
    
    public int getId(){
        return id;
    }
    
    public String getNama(){
        return nama;
    }
    
    public String getLayanan(){
        return layanan;
    }
    
    public boolean isSelesai(){
        return isSelesai;
    }
    
    public String getTanggalMasuk(){
        return tanggalMasuk;
    }
    
    @Override
   public String toString() {
        return "Bengkel{" +
                "id=" + id +
                ", nama='" + nama + '\'' +
                ", layanan='" + layanan + '\'' +
                ", isSelesai=" + isSelesai +
                ", tanggalMasuk='" + tanggalMasuk + '\'' +
                '}';
    }
}
