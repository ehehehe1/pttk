package MODELS;

public class GioiTinh {
    private int idGioiTinh;
    private String gioiTinh;

    public GioiTinh() {
    }

    public GioiTinh(int idGioiTinh, String gioiTinh) {
        this.idGioiTinh = idGioiTinh;
        this.gioiTinh = gioiTinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public int getIdGioiTinh() {
        return idGioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setIdGioiTinh(int idGioiTinh) {
        this.idGioiTinh = idGioiTinh;
    }

    @Override
    public String toString() {
        return gioiTinh;
    }
    
}
