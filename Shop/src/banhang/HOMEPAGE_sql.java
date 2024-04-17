/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banhang;

import db.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;             
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author huynh
 */
public class HOMEPAGE_sql {

    Connection con = MyConnection.getConnection();
    PreparedStatement ps;

    public int getKH() {
        int soluong = 0;
        try {
            ps = con.prepareStatement("select count(*) FROM KHACHHANG");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                soluong = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HOMEPAGE_sql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return soluong;
    }

    public int getDH() {
        int soluong = 0;
        try {
            ps = con.prepareStatement("select count(*) FROM DONHANG");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                soluong = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HOMEPAGE_sql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return soluong;
    }

    public int getHD() {
        int soluong = 0;
        try {
            ps = con.prepareStatement("select count(*) FROM DONHANG WHERE TRANGTHAI=?");
            ps.setInt(1, 1);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                soluong = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HOMEPAGE_sql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return soluong;
    }
    
     public int getDT() {
        int soluong = 0;
        try {
            ps = con.prepareStatement("select * FROM DONHANG WHERE TRANGTHAI=?");
            ps.setInt(1, 1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                soluong += rs.getInt(3);    
            }
        } catch (SQLException ex) {
            Logger.getLogger(HOMEPAGE_sql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return soluong;
    }
}
