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

public class DSKH_sql {

    Connection con = MyConnection.getConnection();
    PreparedStatement ps;

    /*
    //get table max row
    public int getMax() {
        int id = 0;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(id) FROM student");
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id + 1;
    }
     */
    public KHACHHANG getKHid(String id) {
        String sql = "SELECT * FROM KHACHHANG WHERE MAKH = ?;";
        KHACHHANG khachHang=null; 
        try {
            ps = con.prepareStatement(sql);            
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String khachHangId = rs.getString(1);    
                String hoTen = rs.getString(2);
                String TenDN = rs.getString(3);
                String MK = rs.getString(4);
                String EMAIL = rs.getString(5);
                int SDT = rs.getInt(6);
                String DIACHI = rs.getString(7);
                int TTHAI = rs.getInt(8);
                khachHang = new KHACHHANG(khachHangId, hoTen, TenDN,MK,EMAIL,SDT,DIACHI,TTHAI);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DSKH_sql.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return khachHang;
    }

    public void getKHValue(JTable table, String searchValue) {
        String sql = "SELECT * FROM KHACHHANG WHERE concat(MAKH,HOTEN, TENDN, EMAIL, SDT, DIACHI) LIKE ?;";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + searchValue + "%");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object[] row;
            while (rs.next()) {
                row = new Object[8];
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(5);
                row[3] = rs.getString(3);
                row[4] = rs.getInt(6);
                row[5] = rs.getString(7);
                model.insertRow(0, row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DSKH_sql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insert(String khachHangId, String hoTen, String TenDN, String MK, String EMAIL, int SDT,String DIACHI, int TTHAI) {
        try {
            String sqlInsert = "INSERT INTO KHACHHANG (MAKH, HOTEN, TENDN, MATKHAU, EMAIL, SDT, DIACHI,TRANGTHAI) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement psInsert = con.prepareStatement(sqlInsert);
            psInsert.setString(1, khachHangId);
            psInsert.setString(2, hoTen);
            psInsert.setString(3, TenDN);
            psInsert.setString(4, MK);
            psInsert.setString(5, EMAIL);
            psInsert.setInt(6, SDT);
            psInsert.setString(7, DIACHI);
            psInsert.setInt(8, TTHAI);
            int rowsAffected = psInsert.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Khách hàng mới đã được thêm vào dữ liệu");  
            }
        } catch (SQLException ex) {
            Logger.getLogger(DSKH_sql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(String khachHangId, String hoTen, String TenDN, String MK, String EMAIL, int SDT,String DIACHI, int TTHAI) {
        String sql = "update KHACHHANG set HOTEN=?, TENDN=?, MATKHAU=?, EMAIL=?, SDT=?, DIACHI=?, TRANGTHAI=? where MAKH=?";

        try {  
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, hoTen);
            ps.setString(2, TenDN);
            ps.setString(3, MK);
            ps.setString(4, EMAIL);
            ps.setInt(5, SDT);          
            ps.setString(6, DIACHI);
            ps.setInt(7, TTHAI);
            ps.setString(8, khachHangId);

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "KHÁCH HÀNG ĐÃ ĐƯỢC CẬP NHẬT"); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(DSKH_sql.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }
    
    public void delete (String id)
    {
      int yesOrNo = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa khách hàng này khỏi dữ liệu ?", "Xóa Khách Hàng",JOptionPane.OK_CANCEL_OPTION,0);
      if (yesOrNo == JOptionPane.OK_OPTION)
      {
          try {
              ps=con.prepareStatement("delete from KHACHHANG where MAKH=?");
              ps.setString(1,id);
              if(ps.executeUpdate() > 0)
              {
                  JOptionPane.showMessageDialog(null, "KHÁCH HÀNG ĐÃ ĐƯỢC XÓA THÀNH CÔNG");
              }
          }         
          catch (SQLException ex) {
            Logger.getLogger(DSKH_sql.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }
}
