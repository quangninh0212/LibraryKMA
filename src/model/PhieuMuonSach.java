/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class PhieuMuonSach {
    private String maDG, maSach, ngayMuon;
    private int soLuong, tinhTrang, requestID;
    private String ngayHenTra, ngayTraThucTe;

    public PhieuMuonSach(String maDG, String maSach, String ngayMuon, int soLuong, int tinhTrang) {
        this.maDG = maDG;
        this.maSach = maSach;
        this.ngayMuon = ngayMuon;
        this.soLuong = soLuong;
        this.tinhTrang = tinhTrang;
    }
    
    public PhieuMuonSach(String maDG, String maSach, String ngayMuon, int soLuong, int tinhTrang, int requestID, String ngayHenTra) {
        this.maDG = maDG;
        this.maSach = maSach;
        this.ngayMuon = ngayMuon;
        this.soLuong = soLuong;
        this.tinhTrang = tinhTrang;
        this.requestID = requestID;
        this.ngayHenTra = ngayHenTra;
    }
    
    public PhieuMuonSach(String maDG, String maSach, String ngayMuon, int soLuong, int tinhTrang, String ngayHenTra) {
        this.maDG = maDG;
        this.maSach = maSach;
        this.ngayMuon = ngayMuon;
        this.soLuong = soLuong;
        this.tinhTrang = tinhTrang;
        this.ngayHenTra = ngayHenTra;
    }
    
    public PhieuMuonSach(String maDG, String maSach, String ngayMuon, int soLuong, int tinhTrang, int requestID, String ngayHenTra, String ngayTraThucTe) {
        this.maDG = maDG;
        this.maSach = maSach;
        this.ngayMuon = ngayMuon;
        this.soLuong = soLuong;
        this.tinhTrang = tinhTrang;
        this.requestID = requestID;
        this.ngayHenTra = ngayHenTra;
        this.ngayTraThucTe = ngayTraThucTe;
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

    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
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
