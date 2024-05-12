/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanLiKho.DTO;

import java.util.Date;
import quanLiKho.BLL.PhieuNhapBLL;

/**
 *
 * @author PC
 */
public class PhieuNhapDTO {
    private String maPhieu;
    private Date ngayTao;
    private String tenNCC;
    private String maTK;
    private int tongTien;
    private int trangThai;
    
//    private PhieuNhapBLL pnBLL = new PhieuNhapBLL();
//    private TaiKhoanBLL tkBLL = new PhieuNhapBLL()
    
    public PhieuNhapDTO() {
    }

    public PhieuNhapDTO(String maPhieu, Date ngayTao, String tenNCC, String maTK, int tongTien, int trangThai) {
        this.maPhieu = maPhieu;
        this.ngayTao = ngayTao;
        this.tenNCC = tenNCC;
        this.maTK = maTK;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public PhieuNhapDTO(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getMaNCC() {
        return tenNCC;
    }

    public void setMaNCC(String maNCC) {
        
        this.tenNCC = maNCC;
    }

    public String getMaTK() {
        return maTK;
    }

    public void setMaTK(String maTK) {
        this.maTK = maTK;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
