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
import java.util.ArrayList;
import java.util.List;
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
                row[4] = rs.getInt(6) == 1;

                model.insertRow(0, row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DSDH_sql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DONHANG getDHid(String id) {
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
                int PTTT = rs.getInt(4);
                String NGAYDH = rs.getString(5);
                int TTHAI = rs.getInt(6);
                donhang = new DONHANG(donHangId, khachHangId, TTien, PTTT, NGAYDH, TTHAI);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DSDH_sql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return donhang;
    }

    public void update(String donHangID, int TTHAI) {
        String sql1 = "update DONHANG set TRANGTHAI=? where MADH=?";
        String sql2 = "select * FROM CT_DONHANG where MADH=?";
        String sql3 = "select * FROM CT_SANPHAM where MACTSP=?";
        String sql4 = "update CT_SANPHAM set SOLUONG=? where MACTSP=?";

        try {
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setInt(1, TTHAI);
            ps1.setString(2, donHangID);
            ps1.executeUpdate();

            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setString(1, donHangID);
            ResultSet rs2 = ps2.executeQuery();
            List<String> MACTSPList = new ArrayList<>();
            List<Integer> SoLuongList = new ArrayList<>();
            while (rs2.next()) {
                MACTSPList.add(rs2.getString(2));
                SoLuongList.add(rs2.getInt(4));
            }

            for (int i = 0; i < MACTSPList.size(); i++) {
                String MACTSP = MACTSPList.get(i);
                int SoLuong = SoLuongList.get(i);

                PreparedStatement ps3 = con.prepareStatement(sql3);
                ps3.setString(1, MACTSP);
                ResultSet rs3 = ps3.executeQuery();
                int soluong = 0;
                if (rs3.next()) {
                    soluong = rs3.getInt(5);
                }

                PreparedStatement ps4 = con.prepareStatement(sql4);
                if (TTHAI == 1) {
                    soluong -= SoLuong;
                } else if (TTHAI == 0) {
                    soluong += SoLuong;
                }
                ps4.setInt(1, soluong);
                ps4.setString(2, MACTSP);
                ps4.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DSDH_sql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
