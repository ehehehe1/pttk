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
import quanLiKho.DTO.NhaCungCapDTO;

/**
 *
 * @author PC
 */
public class NhaCungCapDAO implements DAOInterface<NhaCungCapDTO>{

    /*create table NCC(
	MANCC	varchar(10) primary key,
	TENNCC	nvarchar(255),
	DIACHI	nvarchar(255),
	EMAIL	varchar(255),
	SDT		int,
	TRANGTHAI int
)*/
    @Override
    public int insert(NhaCungCapDTO t) {
        int ketQua = 0;
        try {
            Connection con = MyConnection.getConnection();

            String sql = "INSERT INTO NCC(MaNCC, TenNCC, DiaChi, Email, SDT, TrangThai)"
                    + " VALUES (?, ?, ?, ?, ?, ?) ";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, t.getMaNCC());
            ps.setString(2, t.getTenNCC());
            ps.setString(3, t.getDiaChi());
            ps.setString(4, t.getEmail());
            ps.setInt(5, t.getSdt());
            ps.setInt(6, t.getTrangThai());
            
            System.out.println(sql);
            ketQua = ps.executeUpdate(sql);
            if (ketQua != 0) {
                System.out.println("Insert thanh cong.");
            } else System.out.println("Insert that bai.");
            
            MyConnection.closeConnection(con);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    return ketQua ;
    }

    @Override
    public int update(NhaCungCapDTO t) {
        int ketQua = 0;

        try {
            Connection con = MyConnection.getConnection();
            String sql = "UPDATE NCC"
                    + " SET TenNCC = ?, DiaChi = ?, Email = ?, SDT = ?, TrangThai = ?"
                    + " WHERE MaNCC = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(6, t.getMaNCC());
            ps.setString(1, t.getTenNCC());
            ps.setString(2, t.getDiaChi());
            ps.setString(3, t.getEmail());
            ps.setInt(4, t.getSdt());
            ps.setInt(5, t.getTrangThai());

            ketQua = ps.executeUpdate();
            if (ketQua != 0) {
                System.out.println("Update thanh cong.");
            } else System.out.println("Update that bai.");

            MyConnection.closeConnection(con);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int delete(NhaCungCapDTO t) {
        int ketQua = 0;

        try {
            Connection con = MyConnection.getConnection();
            String query = "UPDATE NCC SET TrangThai=0" + " WHERE MaNCC = '" + t.getMaNCC() + "'";

            Statement st = con.createStatement();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, t.getMaNCC());

            ketQua = st.executeUpdate(query);
            if (ketQua != 0) {
                System.out.println("Delete ctpm thanh cong.");
            } else System.out.println("Delete ctpm that bai.");

            MyConnection.closeConnection(con);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public ArrayList<NhaCungCapDTO> selectAll() {
        ArrayList<NhaCungCapDTO> list = new ArrayList<>();
        try {
            Connection con = MyConnection.getConnection();
            String sql = "SELECT * FROM NCC" + " WHERE TrangThai = 1";
            System.out.println(sql);
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String ma = rs.getString("MaNCC");
                String ten = rs.getString("TenNCC");
                String dc = rs.getString("DiaChi");
                String email = rs.getString("Email");
                int sdt = rs.getInt("SDT");
                int trangthai = rs.getInt("TrangThai");

                list.add(new NhaCungCapDTO(ma, ten, dc, email, sdt, trangthai));
            }

            MyConnection.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public NhaCungCapDTO selectById(NhaCungCapDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<NhaCungCapDTO> selectByCondition(String condition) {
        ArrayList<NhaCungCapDTO> list = new ArrayList<>();
        try {
            Connection con = MyConnection.getConnection();
            String sql = "SELECT * FROM NCC" + " WHERE TrangThai = 1 and" + condition;
            System.out.println(sql);
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String ma = rs.getString("MaNCC");
                String ten = rs.getString("TenNCC");
                String dc = rs.getString("DiaChi");
                String email = rs.getString("Email");
                int sdt = rs.getInt("SDT");
                int trangthai = rs.getInt("TrangThai");

                list.add(new NhaCungCapDTO(ma, ten, dc, email, sdt, trangthai));
            }

            MyConnection.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
}
