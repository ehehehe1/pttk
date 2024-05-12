package MODELS;

public class MauSac {
    private int idMauSac;
    private String mauSac;

    public MauSac() {
    }

    public MauSac(int idMauSac, String mauSac) {
        this.idMauSac = idMauSac;
        this.mauSac = mauSac;
    }

    public int getIdMauSac() {
        return idMauSac;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setIdMauSac(int idMauSac) {
        this.idMauSac = idMauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    @Override
    public String toString() {
        return mauSac;
    }
    
}
