package MODELS;

public class SanPham {
    
    private int idSanPham;
    private int idDanhMuc;
    private int idNhaSanXuat;
    private String tenSanPham;
    private int trangThaiSP;

    public SanPham() {
    }

    public SanPham(int idSanPham, int idDanhMuc, int idNhaSanXuat, String tenSanPham, int trangThaiSP) {
        this.idSanPham = idSanPham;
        this.idDanhMuc = idDanhMuc;
        this.idNhaSanXuat = idNhaSanXuat;
        this.tenSanPham = tenSanPham;
        this.trangThaiSP = trangThaiSP;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public void setIdDanhMuc(int idDanhMuc) {
        this.idDanhMuc = idDanhMuc;
    }

    public void setIdNhaSanXuat(int idNhaSanXuat) {
        this.idNhaSanXuat = idNhaSanXuat;
    }
 
    public int getIdSanPham() {
        return idSanPham;
    }

    public int getIdDanhMuc() {
        return idDanhMuc;
    }

    public int getIdNhaSanXuat() {
        return idNhaSanXuat;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public int getTrangThaiSP() {
        return trangThaiSP;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public void setTrangThaiSP(int trangThaiSP) {
        this.trangThaiSP = trangThaiSP;
    }

    @Override
    public String toString() {
        return tenSanPham;
    }
    
}
