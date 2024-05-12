package MODELS;

public class NguoiDung {

    private int idNguoiDung;
    private String hoTen;
    private String sdt;
    private String diaChi;
    private String cccd;
    private int trangThai;

    public NguoiDung() {
    }

    public NguoiDung(int idNguoiDung, String hoTen, String sdt, String diaChi, String cccd,  int trangThai) {
        this.idNguoiDung = idNguoiDung;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.cccd = cccd;
        this.trangThai = trangThai;
    }
 
    public int getIdNguoiDung() {
        return idNguoiDung;
    }

    public void setIdNguoiDung(int idNguoiDung) {
        this.idNguoiDung = idNguoiDung;
    }

    public String getCccd() {
        return cccd;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getSdt() {
        return sdt;
    }

    public int getTrangThai() {
        return trangThai;
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

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}
