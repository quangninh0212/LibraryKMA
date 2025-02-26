/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class PhieuMuonSachTable {    
    private int maMuon;
    private String maDG, maSach, hoTen, tenSach, ngayMuon, ngayHenTra, ngayTraThucTe;
    private int soLuong;
    private String tinhTrang;

    public PhieuMuonSachTable(int maMuon, String maDG, String maSach, String hoTen, String tenSach, String ngayMuon, String ngayHenTra, String ngayTraThucTe, int soLuong, String tinhTrang) {
        this.maMuon = maMuon;
        this.maDG = maDG;
        this.maSach = maSach;
        this.hoTen = hoTen;
        this.tenSach = tenSach;
        this.ngayMuon = ngayMuon;
        this.ngayHenTra = ngayHenTra;
        this.ngayTraThucTe = ngayTraThucTe;
        this.soLuong = soLuong;
        this.tinhTrang = tinhTrang;
    }
    
    public int getMaMuon() {
        return maMuon;
    }

    public void setMaMuon(int maMuon) {
        this.maMuon = maMuon;
    }

    public String getMaDG() {
        return maDG;
    }

    public void setMaDG(String maDG) {
        this.maDG = maDG;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNgayHenTra() {
        return ngayHenTra;
    }

    public void setNgayHenTra(String ngayHenTra) {
        this.ngayHenTra = ngayHenTra;
    }

    public String getNgayTraThucTe() {
        return ngayTraThucTe;
    }

    public void setNgayTraThucTe(String ngayTraThucTe) {
        this.ngayTraThucTe = ngayTraThucTe;
    }
    
    
}

    