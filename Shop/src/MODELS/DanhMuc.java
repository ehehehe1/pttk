package MODELS;

public class DanhMuc {
    private int idDanhMuc;
    private String danhMuc;

    public DanhMuc() {
    }

    public DanhMuc(int idDanhMuc, String danhMuc) {
        this.idDanhMuc = idDanhMuc;
        this.danhMuc = danhMuc;
    }

    public String getDanhMuc() {
        return danhMuc;
    }

    public int getIdDanhMuc() {
        return idDanhMuc;
    }

    public void setDanhMuc(String danhMuc) {
        this.danhMuc = danhMuc;
    }

    public void setIdDanhMuc(int idDanhMuc) {
        this.idDanhMuc = idDanhMuc;
    }

    @Override
    public String toString() {
        return danhMuc;
    }
    
}
