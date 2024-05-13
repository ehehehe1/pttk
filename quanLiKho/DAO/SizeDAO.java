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
import java.sql.Statement;
import java.util.ArrayList;
import quanLiKho.DTO.SizeDTO;

/**
 *
 * @author PC
 */
public class SizeDAO implements DAOInterface<SizeDTO>{

    @Override
    public int insert(SizeDTO t) {
        int ketQua = 0;
        try {
            Connection con = MyConnection.getConnection();

            String sql = "INSERT INTO Size(MaSize, TenSize, TrangThai)"
                    + " VALUES (?, ?, ?) ";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, t.getMaSize());
            ps.setString(2, t.getTenSize());
            ps.setInt(3, t.getTrangThai());
            
            System.out.println(sql);
            ketQua = ps.executeUpdate(sql);
            if (ketQua != 0) {
                System.out.println("Insert  thanh cong.");
            } else System.out.println("Insert that bai.");
            
            MyConnection.closeConnection(con);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    return ketQua ;
    }

    @Override
    public int update(SizeDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(SizeDTO t) {
        int ketQua = 0;
        try {
            Connection con = MyConnection.getConnection();

            String sql = "UpDate Size SET TrangThai = 0 Where MaSize = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, t.getMaSize());
            
            System.out.println(sql);
            ketQua = ps.executeUpdate(sql);
            if (ketQua != 0) {
                System.out.println("Delete  thanh cong.");
            } else System.out.println("Delete that bai.");
            
            MyConnection.closeConnection(con);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return ketQua ;
    }

    @Override
    public ArrayList<SizeDTO> selectAll() {
        ArrayList<SizeDTO> list = new ArrayList<>();
        try {
            Connection con = MyConnection.getConnection();
            String sql = "SELECT * FROM Size" + " WHERE TrangThai = 1";
            System.out.println(sql);
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String ma = rs.getString("MaSize");
                String ten = rs.getString("TenSize");
                int tt = rs.getInt("TrangThai");

                list.add(new SizeDTO(ma, ten, tt));
            }

            MyConnection.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public SizeDTO selectById(SizeDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<SizeDTO> selectByCondition(String condition) {
        ArrayList<SizeDTO> list = new ArrayList<>();
        try {
            Connection con = MyConnection.getConnection();
            String sql = "SELECT * FROM Size" + " WHERE " + condition;
            System.out.println(sql);
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String ma = rs.getString("MaSize");
                String ten = rs.getString("TenSize");
                int tt = rs.getInt("TrangThai");

                list.add(new SizeDTO(ma, ten, tt));
            }

            MyConnection.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    
    public SizeDTO selectByCondition1(String condition) {
        SizeDTO list = null;
        try {
            Connection con = MyConnection.getConnection();
            String sql = "SELECT * FROM Size" + " WHERE TrangThai = 1 and " + condition;
            System.out.println(sql);
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String ma = rs.getString("MaSize");
                String ten = rs.getString("TenSize");
                int tt = rs.getInt("TrangThai");

                list = new SizeDTO(ma, ten, tt);
            }

            MyConnection.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
