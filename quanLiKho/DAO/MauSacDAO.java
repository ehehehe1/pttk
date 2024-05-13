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
import quanLiKho.DTO.MauSacDTO;

/**
 *
 * @author PC
 */
public class MauSacDAO implements DAOInterface<MauSacDTO>{

    @Override
    public int insert(MauSacDTO t) {
        int ketQua = 0;
        try {
            Connection con = MyConnection.getConnection();

            String sql = "INSERT INTO MauSac(MaMau, TenMau, TrangThai)"
                    + " VALUES (?, ?, ?) ";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, t.getMaMau());
            ps.setString(2, t.getTenMau());
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
    public int update(MauSacDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(MauSacDTO t) {
        int ketQua = 0;
        try {
            Connection con = MyConnection.getConnection();

            String sql = "UpDate MauSac SET TrangThai = 0 Where MaMau = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, t.getMaMau());
            
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
    public ArrayList<MauSacDTO> selectAll() {
        ArrayList<MauSacDTO> list = new ArrayList<>();
        try {
            Connection con = MyConnection.getConnection();
            String sql = "SELECT * FROM MauSac" + " WHERE TrangThai = 1";
            System.out.println(sql);
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String ma = rs.getString("MaMau");
                String ten = rs.getString("TenMau");
                int tt = rs.getInt("TrangThai");

                list.add(new MauSacDTO(ma, ten, tt));
            }

            MyConnection.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public MauSacDTO selectById(MauSacDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<MauSacDTO> selectByCondition(String condition) {
        ArrayList<MauSacDTO> list = new ArrayList<>();
        try {
            Connection con = MyConnection.getConnection();
            String sql = "SELECT * FROM MauSac" + " WHERE " + condition;
            System.out.println(sql);
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String ma = rs.getString("MaMau");
                String ten = rs.getString("TenMau");
                int tt = rs.getInt("TrangThai");

                list.add(new MauSacDTO(ma, ten, tt));
            }

            MyConnection.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    public MauSacDTO selectByCondition1(String condition) {
        MauSacDTO list = null;
        try {
            Connection con = MyConnection.getConnection();
            String sql = "SELECT * FROM MauSac" + " WHERE TrangThai = 1 and " + condition;
            System.out.println(sql);
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String ma = rs.getString("MaMau");
                String ten = rs.getString("TenMau");
                int tt = rs.getInt("TrangThai");

                list = new MauSacDTO(ma, ten, tt);
            }

            MyConnection.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
