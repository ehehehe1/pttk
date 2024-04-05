/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banhang; 

/** 
 *       
 * @author huynh 
 */       
public class KHACHHANG {

    private String id;
    private String hoTen;
    private String TenDN;
    private String MK;
    private String Email;
    private int SDT;
    private String DIACHI;
    private int TTHAI;

    // Các thuộc tính khác của khách hàng
    public KHACHHANG(String id, String hoTen, String TenDN, String MK, String Email, int SDT, String DIACHI, int TTHAI) {
        this.id = id;
        this.hoTen = hoTen;
        this.TenDN = TenDN;
        this.MK = MK;
        this.Email = Email;
        this.SDT = SDT; 
        this.DIACHI = DIACHI;
        this.TTHAI = TTHAI;
    }      

    // Phương thức getter và setter cho các thuộc tính của khách hàng
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getTenDN() {
        return TenDN;
    }
    public void setTenDN(String TenDN) {
        this.TenDN = TenDN;
    }

    public String getMK() {
        return MK;
    }
    public void setMK(String MK) {
        this.MK = MK;
    }

    public String getEmail() {
        return Email;
    }
    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getSDT() {
        return SDT;
    }
    public void setSDT(int SDT) {
        this.SDT = SDT;
    }

    public String getDIACHI() {
        return DIACHI;
    }

    public void setDIACHI(String DIACHI) {
        this.DIACHI = DIACHI;
    }
  
    public int getTTHAI() {
        return TTHAI;
    }

    public void setTTHAI(int TTHAI) {
        this.TTHAI = TTHAI;
    }
}
