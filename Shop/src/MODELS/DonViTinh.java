package MODELS;

public class DonViTinh {
    private int idDonViTinh;
    private String donViTinh;

    public DonViTinh() {
    }

    public DonViTinh(int idDonViTinh, String donViTinh) {
        this.idDonViTinh = idDonViTinh;
        this.donViTinh = donViTinh;
    }

    public int getIdDonViTinh() {
        return idDonViTinh;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setIdDonViTinh(int idDonViTinh) {
        this.idDonViTinh = idDonViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    @Override
    public String toString() {
        return donViTinh;
    }
    
}
