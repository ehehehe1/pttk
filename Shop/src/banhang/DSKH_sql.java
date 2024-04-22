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
        String sql = "SELECT * FROM TAIKHOAN WHERE MATK = ? AND MAQ=3;";
        KHACHHANG khachHang = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String khachHangId = rs.getString(1);
//                String hoTen = rs.getString(2);
                String TenDN = rs.getString(2);
                String MK = rs.getString(3);
                String EMAIL = rs.getString(5);
                String SDT = rs.getString(4);
                String DIACHI = rs.getString(6);
                int TTHAI = rs.getInt(8);
                khachHang = new KHACHHANG(khachHangId, TenDN, MK, EMAIL, SDT, DIACHI, TTHAI);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DSKH_sql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return khachHang;
    }

    public void getKHValue(JTable table, String searchValue) {
        String sql = "SELECT * FROM TAIKHOAN WHERE concat(MATK, TENDN, EMAIL, SDT, DIACHI) LIKE ?;";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + searchValue + "%");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object[] row;
            while (rs.next()) {
                row = new Object[6];
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(5);
                row[3] = rs.getString(4);
                row[4] = rs.getString(6);
                if (rs.getInt(8) == 1) {
                    row[5] = "Đã Duyệt";
                } else {
                    row[5] = "Chưa Duyệt";
                }
                model.insertRow(0, row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DSKH_sql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //check customer email address is already exists
    public boolean isEmailExists(String email) {
        try {
            ps = con.prepareStatement("select * FROM TAIKHOAN WHERE EMAIL=? AND MAQ=3");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DSKH_sql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //check customer phone address is already exists
    public boolean isPhoneExists(int phone) {
        try {
            ps = con.prepareStatement("select * FROM TAIKHOAN WHERE SDT=? AND MAQ=3");
            ps.setInt(1, phone);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DSKH_sql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean isIdExist(String id) {
        try {
            ps = con.prepareStatement("select * FROM TAIKHOAN WHERE MATK=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DSKH_sql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void insert(String khachHangId, String TenDN, String MK, String EMAIL, int SDT, String DIACHI, int TTHAI) {
        try {
          
            String sqlCheckID = "select * FROM TAIKHOAN WHERE MATK=?";
            PreparedStatement psSelect = con.prepareStatement(sqlCheckID);
            psSelect.setString(1, khachHangId);
            ResultSet rs = psSelect.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "ID đã tồn tại, mời nhập lại");
            } else {
                String sqlInsert = "INSERT INTO TAIKHOAN (MATK, TENDN, MATKHAU, EMAIL, SDT, DIACHI, MAQ, TRANGTHAI) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement psInsert = con.prepareStatement(sqlInsert);
                psInsert.setString(1, khachHangId);
                psInsert.setString(2, TenDN);
                psInsert.setString(3, MK);
                psInsert.setString(4, EMAIL);
                psInsert.setInt(5, SDT);
                psInsert.setString(6, DIACHI);
                psInsert.setInt(7, 3);
                psInsert.setInt(8, TTHAI);
                int rowsAffected = psInsert.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Khách hàng mới đã được thêm vào dữ liệu");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(DSKH_sql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(String khachHangId, String TenDN, String MK, String EMAIL, String SDT, String DIACHI, int TTHAI) {
        String sql = "update TAIKHOAN set TENDN=?, MATKHAU=?, EMAIL=?, SDT=?, DIACHI=?, TRANGTHAI=? where MATK=? AND MAQ=3";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, TenDN);
            ps.setString(2, MK);
            ps.setString(3, EMAIL);
            ps.setString(4, SDT);  
            ps.setString(5, DIACHI);
            ps.setInt(6, TTHAI);      
            ps.setString(7, khachHangId);

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "KHÁCH HÀNG ĐÃ ĐƯỢC CẬP NHẬT");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DSKH_sql.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void delete(String id) {
        int yesOrNo = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa khách hàng này khỏi dữ liệu ?", "Xóa Khách Hàng", JOptionPane.OK_CANCEL_OPTION, 0);
        if (yesOrNo == JOptionPane.OK_OPTION) {
            try {
                ps = con.prepareStatement("delete from TAIKHOAN where MATK=? AND MAQ=3");
                ps.setString(1, id);
                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "KHÁCH HÀNG ĐÃ ĐƯỢC XÓA THÀNH CÔNG");
                }
            } catch (SQLException ex) {
                Logger.getLogger(DSKH_sql.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
