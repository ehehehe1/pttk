package MODELS;

public class HoaDon {
    private int idHoaDon;
    private int idNguoiDung;
    private int idKhachHang;
    private String ngayLap;
    private double tongTien;
    private String hinhThucThanhToan;
    private int trangThai;

    public HoaDon() {
    }

    public HoaDon(int idHoaDon, int idNguoiDung, int idKhachHang, String ngayLap, double tongTien, String hinhThucThanhToan, int trangThai) {
        this.idHoaDon = idHoaDon;
        this.idNguoiDung = idNguoiDung;
        this.idKhachHang = idKhachHang;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.trangThai = trangThai;
    }

    public void setIdNguoiDung(int idNguoiDung) {
        this.idNguoiDung = idNguoiDung;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public int getIdNguoiDung() {
        return idNguoiDung;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public String getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public double getTongTien() {
        return tongTien;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
     
}
