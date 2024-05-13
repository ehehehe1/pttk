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
import quanLiKho.DTO.LoaiSPDTO;

/**
 *
 * @author PC
 */
public class LoaiSPDAO implements DAOInterface<LoaiSPDTO>{

    @Override
    public int insert(LoaiSPDTO t) {
        int ketQua = 0;
        try {
            Connection con = MyConnection.getConnection();

            String sql = "INSERT INTO LoaiSP(MaLoai, TenLoai, TrangThai)"
                    + " VALUES (?, ?, ?) ";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, t.getMaLoai());
            ps.setString(2, t.getTenLoai());
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
    public int update(LoaiSPDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(LoaiSPDTO t) {
        int ketQua = 0;
        try {
            Connection con = MyConnection.getConnection();

            String sql = "UpDate LoaiSP SET TrangThai = 0 Where MaLoai = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, t.getMaLoai());
            
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
    public ArrayList<LoaiSPDTO> selectAll() {
        ArrayList<LoaiSPDTO> list = new ArrayList<>();
        try {
            Connection con = MyConnection.getConnection();
            String sql = "SELECT * FROM LoaiSP" + " WHERE TrangThai = 1";
            System.out.println(sql);
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String ma = rs.getString("MaLoai");
                String ten = rs.getString("TenLoai");
                int tt = rs.getInt("TrangThai");

                list.add(new LoaiSPDTO(ma, ten, tt));
            }

            MyConnection.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public LoaiSPDTO selectById(LoaiSPDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<LoaiSPDTO> selectByCondition(String condition) {
        ArrayList<LoaiSPDTO> list = new ArrayList<>();
        try {
            Connection con = MyConnection.getConnection();
            String sql = "SELECT * FROM LoaiSP" + " WHERE " + condition;
            System.out.println(sql);
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String ma = rs.getString("MaLoai");
                String ten = rs.getString("TenLoai");
                int tt = rs.getInt("TrangThai");

                list.add(new LoaiSPDTO(ma, ten, tt));
            }

            MyConnection.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
}
