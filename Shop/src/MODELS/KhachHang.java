package MODELS;

public class KhachHang {
    
    private int idKhachHang;
    private String hoTen;
    private String sdt;
    private String diaChi;
    private String cccd;

    public KhachHang() {
    }

    public KhachHang(int idKhachHang, String hoTen, String sdt, String diaChi, String cccd) {
        this.idKhachHang = idKhachHang;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.cccd = cccd;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getCccd() {
        return cccd;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getSdt() {
        return sdt;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }
    
}
