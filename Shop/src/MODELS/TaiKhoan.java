package MODELS;

public class TaiKhoan {
    
    private String idTaiKhoan;
    private String email;
    private String matKhau;
    private int trangThai;
    private int idNguoiDung;
    private int vaiTro;

    public TaiKhoan() {
    }

    public TaiKhoan(String idTaiKhoan, String email, int idNguoiDung, String matKhau, int vaiTro, int trangThai) {
        this.idTaiKhoan = idTaiKhoan;
        this.email = email;
        this.matKhau = matKhau;
        this.trangThai = trangThai;
        this.idNguoiDung = idNguoiDung;
        this.vaiTro = vaiTro;
    }

    public void setIdTaiKhoan(String idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    public String getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public String getEmail() {
        return email;
    }

    public int getIdNguoiDung() {
        return idNguoiDung;
    }

    public void setIdNguoiDung(int idNguoiDung) {
        this.idNguoiDung = idNguoiDung;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public int getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(int vaiTro) {
        this.vaiTro = vaiTro;
    }
    
    
}
