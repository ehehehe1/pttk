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
public class TaiKhoanDTO {
    private String maTK;
    private String tenDN;
    private String matKhau;
    private int sdt;
    private String email;
    private String diaChi;
    private String maQ;
    private int trangThai;

    public TaiKhoanDTO() {
    }

    public TaiKhoanDTO(String maTK, String tenDN, String matKhau, int sdt, String email, String diaChi, String maQ, int trangThai) {
        this.maTK = maTK;
        this.tenDN = tenDN;
        this.matKhau = matKhau;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
        this.maQ = maQ;
        this.trangThai = trangThai;
    }

    public TaiKhoanDTO(String maTK) {
        this.maTK = maTK;
    }

    public String getMaTK() {
        return maTK;
    }

    public void setMaTK(String maTK) {
        this.maTK = maTK;
    }

    public String getTenDN() {
        return tenDN;
    }

    public void setTenDN(String tenDN) {
        this.tenDN = tenDN;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMaQ() {
        return maQ;
    }

    public void setMaQ(String maQ) {
        this.maQ = maQ;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
