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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author huynh
 */
public class DSTK_sql {

    Connection con = MyConnection.getConnection();
    PreparedStatement ps;

    public void getSPValue(JTable table, JTextField text, String searchValue) {
        String sql = "SELECT * FROM SANPHAM WHERE concat(MASP,TENSP) LIKE ? AND TRANGTHAI=?;";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + searchValue + "%");
            ps.setInt(2, 1);
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object[] row;
            int TongTien = 0;
            while (rs.next()) {
                row = new Object[4];
                row[0] = rs.getString(2);
                row[1] = rs.getString(1);

                String sql1 = "SELECT *FROM ((CT_DONHANG INNER JOIN CT_SANPHAM ON CT_DONHANG.MACTSP = CT_SANPHAM.MACTSP)INNER JOIN DONHANG ON DONHANG.MADH = CT_DONHANG.MADH);";
                PreparedStatement ps1 = con.prepareStatement(sql1);
                ResultSet rs1 = ps1.executeQuery();
                //model.insertRow(0, row);
                int soluong = 0;       
                int doanhthu = 0;
                while (rs1.next()) {
                    String maspHienTai = rs1.getString(7);
                    if (rs1.getInt(17) == 1) {
                        if (rs.getString(1).equals(maspHienTai)) {
                            soluong += rs1.getInt(4);
                            doanhthu += rs1.getInt(4) * rs1.getInt(5);

                        }
                    }
                    row[2] = soluong;
                    row[3] = doanhthu;

                }
                TongTien += (Integer) row[3 ];
                //model.addRow(row);
                     model.insertRow(0, row);
            }
            text.setText(String.valueOf(TongTien));
        } catch (SQLException ex) {
            Logger.getLogger(DSTK_sql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
