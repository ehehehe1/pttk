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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *       
 * @author huynh
 */
public class DSDH_sql {

    Connection con = MyConnection.getConnection();
    PreparedStatement ps;

    public void getDHValue(JTable table, String searchValue) {
        String sql = "SELECT * FROM DONHANG WHERE concat(MADH,MAKH,TONGTIEN,NGAYDH) LIKE ?;";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + searchValue + "%");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object[] row;
            while (rs.next()) {        
                row = new Object[5];  
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(5);
                row[3] = rs.getInt(3);
                row[4] = rs.getInt(6)==1; 
  
                model.insertRow(0, row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DSDH_sql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void update(String donHangID, int TTHAI) {
        String sql = "update DONHANG set TRANGTHAI=? where MADH=?";

        try {  
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, TTHAI);
            ps.setString(2, donHangID);
            ps.executeUpdate();                  
            
        } catch (SQLException ex) {
            Logger.getLogger(DSDH_sql.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }
}
