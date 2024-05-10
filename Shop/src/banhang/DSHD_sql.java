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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;    
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
/**
 *      
 * @author huynh
 */
public class DSHD_sql {  
    Connection con = MyConnection.getConnection();
    PreparedStatement ps;

    public void getHDValue(JTable table, String searchValue) {
        String sql = "SELECT * FROM DONHANG WHERE concat(MADH,MATK,TONGTIEN) LIKE ? AND TRANGTHAI=?;";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + searchValue + "%");    
            ps.setInt(2, 2);
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object[] row;
            while (rs.next()) {
                row = new Object[4];
                row[0] = rs.getString(1);           
                row[1] = rs.getString(2);
                row[2] = rs.getString(5);
                row[3] = rs.getInt(3);
//                row[4] = rs.getString(7);

                model.insertRow(0, row);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(DSHD_sql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DONHANG getHDid(String id) {
        String sql = "SELECT * FROM DONHANG WHERE MADH = ?;";     
        DONHANG donhang = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String donHangId = rs.getString(1);
                String khachHangId = rs.getString(2);
                int TTien = rs.getInt(3);
                String PTTT = rs.getString(4);         
                String NGAYDH = rs.getString(5);
                int TTHAI = rs.getInt(6);
                donhang = new DONHANG(donHangId, khachHangId, TTien, PTTT, NGAYDH, TTHAI);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DSHD_sql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return donhang;
    }

     

    public void getCTHD(JTable table, String MADH) {
        String sql1 = "select * FROM CT_DONHANG where MADH=?;";
        String sql2 = "select * FROM CT_SANPHAM where MACTSP=?;";
        String sql3 = "select * FROM SIZE where MASIZE=?;";
        String sql4 = "select * FROM MAUSAC where MAMAU=?;";
                                     

        try {
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setString(1, MADH);
            ResultSet rs1 = ps1.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object[] row;
            while (rs1.next()) {
                row = new Object[6];
                row[0] = rs1.getString(3);
                
                PreparedStatement ps2 = con.prepareStatement(sql2);
                String MACTSP=rs1.getString(2);
                ps2.setString(1, MACTSP);
                ResultSet rs2 = ps2.executeQuery();
                if(rs2.next())
                {
                    row[1] = rs2.getString(2);
                }
                
                
                PreparedStatement ps3 = con.prepareStatement(sql3);
                String MASIZE=rs2.getString(4);
                ps3.setString(1,MASIZE);
                ResultSet rs3 = ps3.executeQuery();
                if(rs3.next())
                {
                    row[2]=rs3.getString(2);
                }
                
                
                
                PreparedStatement ps4 = con.prepareStatement(sql4);
                String MAMAU=rs2.getString(3);
                ps4.setString(1, MAMAU);
                ResultSet rs4 = ps4.executeQuery();
                if(rs4.next())
                {
                    row[3]=rs4.getString(2);
                }
               
                
                
                row[4] = rs1.getString(4);
                row[5] = rs1.getString(5);

                model.insertRow(0, row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DSHD_sql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void getHDValueDate(JTable table, String DateStart, String DateEnd)
    {
        String sql = "SELECT * FROM DONHANG WHERE CONVERT(datetime, NGAYDH) BETWEEN ? AND ? AND TRANGTHAI=2;";
        try {     
            ps = con.prepareStatement(sql); 
            ps.setString(1, DateStart);     
            ps.setString(2, DateEnd);       
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object[] row;
            while (rs.next()) {
                row = new Object[4];
                row[0] = rs.getString(1);           
                row[1] = rs.getString(2);
                row[2] = rs.getString(5);
                row[3] = rs.getInt(3); 
                model.insertRow(0, row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DSHD_sql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     public void giaCao(JTable table){
        String sql = "SELECT * FROM DONHANG WHERE TRANGTHAI =? ORDER BY TONGTIEN ASC;";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, 2);
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            Object[] row;
            while (rs.next()) {
                row = new Object[6];       
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(5);
                row[3] = rs.getInt(3); 
                row[4] = rs.getString(4);
                row[5] = rs.getInt(6) == 2;

                model.insertRow(0, row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DSDH_sql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void giaThap(JTable table){
        String sql = "SELECT * FROM DONHANG WHERE TRANGTHAI =? ORDER BY TONGTIEN DESC;";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, 2);
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            Object[] row;
            while (rs.next()) {
                row = new Object[6];       
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(5);
                row[3] = rs.getInt(3);
                row[4] = rs.getString(4);
                row[5] = rs.getInt(6) == 2;

                model.insertRow(0, row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DSDH_sql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
