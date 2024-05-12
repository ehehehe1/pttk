package MODELS;

public class ChiTietSanPham {

    private int idChiTietSP;
    private String maSP;
    private int idSanPham;
    private int idKichCo;
    private int idMauSac;
    private int idDonViTinh;
    private int idChatLieu;
    private int idGioiTinh;
    private String moTa;
    private float giaTien;
    private String tenCT;
    private int trangThai;
    private int soLuong;

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(int idChiTietSP, String maSP, int idSanPham, int idKichCo, int idMauSac, int idDonViTinh, int idChatLieu, int idGioiTinh, String moTa, float giaTien, String tenCT, int trangThai, int soLuong) {
        this.idChiTietSP = idChiTietSP;
        this.maSP = maSP;
        this.idSanPham = idSanPham;
        this.idKichCo = idKichCo;
        this.idMauSac = idMauSac;
        this.idDonViTinh = idDonViTinh;
        this.idChatLieu = idChatLieu;
        this.idGioiTinh = idGioiTinh;
        this.moTa = moTa;
        this.giaTien = giaTien;
        this.tenCT = tenCT;
        this.trangThai = trangThai;
        this.soLuong = soLuong;
    }


    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public void setIdKichCo(int idKichCo) {
        this.idKichCo = idKichCo;
    }

    public void setIdMauSac(int idMauSac) {
        this.idMauSac = idMauSac;
    }

    public void setIdDonViTinh(int idDonViTinh) {
        this.idDonViTinh = idDonViTinh;
    }

    public void setIdChatLieu(int idChatLieu) {
        this.idChatLieu = idChatLieu;
    }

    public void setIdGioiTinh(int idGioiTinh) {
        this.idGioiTinh = idGioiTinh;
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public int getIdKichCo() {
        return idKichCo;
    }

    public int getIdMauSac() {
        return idMauSac;
    }

    public int getIdDonViTinh() {
        return idDonViTinh;
    }

    public int getIdChatLieu() {
        return idChatLieu;
    }

    public int getIdGioiTinh() {
        return idGioiTinh;
    }

    public void setIdChiTietSP(int idChiTietSP) {
        this.idChiTietSP = idChiTietSP;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public void setTenCT(String tenCT) {
        this.tenCT = tenCT;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getIdChiTietSP() {
        return idChiTietSP;
    }

    public String getMoTa() {
        return moTa;
    }

    public String getTenCT() {
        return tenCT;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setGiaTien(float giaTien) {
        this.giaTien = giaTien;
    }

    public float getGiaTien() {
        return giaTien;
    }

}
