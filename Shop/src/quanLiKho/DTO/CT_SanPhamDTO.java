/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanLiKho.DTO;

/**
 *
 * @author PC
 */
public class CT_SanPhamDTO {
    private String maCTSP;
    private String tenSP;
    private String tenMau;
    private String tenSize;
    private int soLuong;
    private int trangThai;

    public CT_SanPhamDTO() {
    }

    public CT_SanPhamDTO(String maCTSP, String tenSP, String tenMau, String tenSize, int soLuong, int trangThai) {
        this.maCTSP = maCTSP;
        this.tenSP = tenSP;
        this.tenMau = tenMau;
        this.tenSize = tenSize;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
    }

    public String getMaCTSP() {
        return maCTSP;
    }

    public void setMaCTSP(String maCTSP) {
        this.maCTSP = maCTSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getTenMau() {
        return tenMau;
    }

    public void setTenMau(String tenMau) {
        this.tenMau = tenMau;
    }

    public String getTenSize() {
        return tenSize;
    }

    public void setTenSize(String tenSize) {
        this.tenSize = tenSize;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
