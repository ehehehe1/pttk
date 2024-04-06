/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banhang;

/**               
 *
 * @author huynh
 */
public class DONHANG {
    private String idDH;
    private String idKH;
    private int TTien;
    private int PTTT;
    private String ngayDH;
    private int TTHAI;

    // Các thuộc tính khác của khách hàng
    public DONHANG(String idDH,String idKH, int TTien, int PTTT, String ngayDH, int TTHAI) {
        this.idDH = idDH;
        this.idKH = idKH;
        this.TTien = TTien;
        this.PTTT = PTTT; 
        this.ngayDH = ngayDH;
        this.TTHAI = TTHAI;
    }         

    // Phương thức getter và setter cho các thuộc tính của khách hàng
    public String getIdDH() {
        return idDH;
    }
    public void setIdDH(String idDH) {
        this.idDH = idDH; 
    }
    
    public String getIdKH() {
        return idKH;
    }
    public void setIdKH(String idKH) {
        this.idKH = idKH; 
    }
    
    public int getTTien() {
        return TTien;
    }
    public void setTTien(int TTien) {
        this.TTien = TTien;
    }
    
    public int getPTTT() {
        return PTTT;
    }
    public void setPTTT(int PTTT) {
        this.PTTT = PTTT;
    }
    
    public String getNgayDH() {
        return ngayDH;
    }
    public void setNgayDH(String ngayDH) {
        this.ngayDH = ngayDH; 
    }

    public int getTTHAI() {
        return TTHAI;
    }
    public void setTTHAI(int TTHAI) {
        this.TTHAI = TTHAI;
    }
}
