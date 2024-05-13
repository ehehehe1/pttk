/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanLiKho.DAO;

import db.DAOInterface;
import db.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import quanLiKho.DTO.TaiKhoanDTO;

/**
 *
 * @author PC
 */
public class TaiKhoanDAO implements DAOInterface<TaiKhoanDTO>{

    @Override
    public int insert(TaiKhoanDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(TaiKhoanDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(TaiKhoanDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TaiKhoanDTO> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TaiKhoanDTO selectById(TaiKhoanDTO t) {
        TaiKhoanDTO ctpn = null;
        try {
            Connection con = MyConnection.getConnection();
            String query = "SELECT * FROM TaiKhoan WHERE TenDN = ?";
            
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, t.getTenDN());
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String matk = rs.getString("MaTK");
                String matkhau = rs.getString("MatKhau");
                int sdt = rs.getInt("SDT");
                String email = rs.getString("Email");
                String dc = rs.getString("DiaChi");
                int maQ = rs.getInt("MaQ");
                int trangThai = rs.getInt("TrangThai");

                ctpn = new TaiKhoanDTO(matk, t.getTenDN(), matkhau, sdt, email, dc, maQ, trangThai);
            }

            MyConnection.closeConnection(con);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ctpn;
    }

    @Override
    public ArrayList<TaiKhoanDTO> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
