package MODELS;

public class KichCo {
    private int idKichCo;
    private String kichCo;

    public KichCo() {
    }

    public KichCo(int idKichCo, String kichCo) {
        this.idKichCo = idKichCo;
        this.kichCo = kichCo;
    }

    public String getKichCo() {
        return kichCo;
    }

    public void setKichCo(String kichCo) {
        this.kichCo = kichCo;
    }

    public void setIdKichCo(int idKichCo) {
        this.idKichCo = idKichCo;
    }

    public int getIdKichCo() {
        return idKichCo;
    }

    @Override
    public String toString() {
        return kichCo;
    }

}
