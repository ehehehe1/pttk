/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanLiKho.DTO;

import java.math.BigDecimal;

/**
 *
 * @author PC
 */
public class CT_PhieuNhapDTO {
    private String maPhieu;
    private String maCTSP;
    private int soLuong;
    private BigDecimal donGia;
    private BigDecimal thanhTien;

    public CT_PhieuNhapDTO() {
    }

    public CT_PhieuNhapDTO(String maPhieu, String maCTSP, int soLuong, BigDecimal donGia, BigDecimal thanhTien) {
        this.maPhieu = maPhieu;
        this.maCTSP = maCTSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public String getMaCTSP() {
        return maCTSP;
    }

    public void setMaCTSP(String maCTSP) {
        this.maCTSP = maCTSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public BigDecimal getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(BigDecimal thanhTien) {
        this.thanhTien = thanhTien;
    }
    
    
    
    
}
