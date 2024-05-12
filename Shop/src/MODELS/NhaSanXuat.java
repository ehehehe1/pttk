package MODELS;

public class NhaSanXuat {
    private int idNhaSanXuat;
    private String nhaSanXuat;

    public NhaSanXuat() {
    }

    public NhaSanXuat(int idNhaSanXuat, String nhaSanXuat) {
        this.idNhaSanXuat = idNhaSanXuat;
        this.nhaSanXuat = nhaSanXuat;
    }

    public int getIdNhaSanXuat() {
        return idNhaSanXuat;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setIdNhaSanXuat(int idNhaSanXuat) {
        this.idNhaSanXuat = idNhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    @Override
    public String toString() {
        return nhaSanXuat;
    }
    
}
