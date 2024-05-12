package MODELS;

public class HoaDonChiTiet {
    private int idHoaDon;
    private int idChiTietSP;
    private double donGia;
    private int soLuong;
    private double thanhTien;
    private int trangThai;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int idHoaDon, int idChiTietSP, double donGia, int soLuong, double thanhTien, int trangThai) {
        this.idHoaDon = idHoaDon;
        this.idChiTietSP = idChiTietSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
        this.trangThai = trangThai;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public void setIdChiTietSP(int idChiTietSP) {
        this.idChiTietSP = idChiTietSP;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public int getIdChiTietSP() {
        return idChiTietSP;
    }

    public double getDonGia() {
        return donGia;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
}
