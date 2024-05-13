/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanLiKho.DAO;

import db.DAOInterface;
import db.MyConnection;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import quanLiKho.DTO.PhieuNhapDTO;

/**
 *
 * @author PC
 */
public class PhieuNhapDAO implements DAOInterface<PhieuNhapDTO>{
    /*create table PHIEUNHAP(
	MAPHIEU		varchar(10) primary key,
	NGAYTAO		Datetime,
	MANCC		varchar(10)	foreign key references NCC(MANCC),		
	MATK		varchar(10)	foreign key references TAIKHOAN(MATK),
	TONGTIEN	int,
	TRANGTHAI	int,
    )*/
    
    @Override
    public int insert(PhieuNhapDTO t) {
        int ketQua = 0;
        try {
            Connection con = MyConnection.getConnection();

                String sql = "INSERT INTO PhieuNhap(MAPHIEU, NGAYTAO, MANCC, MATK, TONGTIEN, TRANGTHAI)"
                    + " VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, t.getMaPhieu());
            ps.setDate(2, (java.sql.Date) t.getNgayTao());
            ps.setString(3, t.getMaNCC());
            ps.setString(4, t.getMaTK());
            ps.setInt(5, t.getTongTien());
            ps.setInt(6, t.getTrangThai());
            
            System.out.println(sql);
            ketQua = ps.executeUpdate(sql);
            System.out.println("Insert thanh cong.");
            MyConnection.closeConnection(con);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int update(PhieuNhapDTO t) {
        int ketQua = 0;
        try {
            Connection con = MyConnection.getConnection();
            String sql = "UPDATE PhieuNhap"
                    + " SET NGAYTAO = ?, MANCC = ?, MATK = ?, TONGTIEN = ?, TRANGTHAI=?";

            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(6, t.getMaPhieu());
            ps.setDate(1, (java.sql.Date) t.getNgayTao());
            ps.setString(2, t.getMaNCC());
            ps.setString(3, t.getMaTK());
            ps.setInt(4, t.getTongTien());
            ps.setInt(5, t.getTrangThai());

            ketQua = ps.executeUpdate();
            
            if (ketQua != 0) {
                System.out.println("Update phieu muon thanh cong.");
            } else System.out.println("Update phieu muon that bai.");
            
            MyConnection.closeConnection(con);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int delete(PhieuNhapDTO t) {
        int ketQua = 0;
        try {
            Connection con = MyConnection.getConnection();
            String query = "UPDATE PHIEUNHAP"
                    + " SET TRANGTHAI = 0"
                    + " WHERE MAPHIEU = ?";

            Statement st = con.createStatement();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, t.getMaPhieu());

            ketQua = ps.executeUpdate();
            if (ketQua != 0) {
                System.out.println("Delete thanh cong.");
            } else System.out.println("Delete that bai.");
            MyConnection.closeConnection(con);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public ArrayList<PhieuNhapDTO> selectAll() {
        ArrayList<PhieuNhapDTO> listPhieu = new ArrayList<>();
        try {
            Connection con = MyConnection.getConnection();
            String sql = "SELECT * FROM PHIEUNHAP AS PN Where trangthai = 1";
            System.out.println(sql);
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String maPhieu = rs.getString("MaPhieu");
                String maNCC = rs.getString("mancc");
                String maTK = rs.getString("matk");
                Date ngayTao = rs.getDate("Ngaytao");
                int tongTien = rs.getInt("Tongtien");
                int trangThai = rs.getInt("TrangThai");

                listPhieu.add(new PhieuNhapDTO(maPhieu, ngayTao, maNCC, maTK, tongTien, trangThai));
            }

            MyConnection.closeConnection(con);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listPhieu;
    }

    @Override
    public PhieuNhapDTO selectById(PhieuNhapDTO t) {
        PhieuNhapDTO pm = new PhieuNhapDTO();
        try {
            Connection con = MyConnection.getConnection();
            String sql = "SELECT * FROM PhieuNhap WHERE TrangThai <> 0 AND MaPhieu = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, t.getMaPhieu());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String maPhieu = rs.getString("MaPhieu");
                String maNCC = rs.getString("mancc");
                String maTK = rs.getString("matk");
                Date ngayTao = rs.getDate("Ngaytao");
                int tongTien = rs.getInt("Tongtien");
                int trangThai = rs.getInt("TrangThai");

                pm = new PhieuNhapDTO(maPhieu, ngayTao, maNCC, maTK, tongTien, trangThai);
            }

            MyConnection.closeConnection(con);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return pm;
    }

    @Override
    public ArrayList<PhieuNhapDTO> selectByCondition(String condition) {
        ArrayList<PhieuNhapDTO> ketQua = new ArrayList<>();

        try {
            Connection con = MyConnection.getConnection();

            String sql = "SELECT * FROM PhieuNhap WHERE " + condition;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String maPhieu = rs.getString("MaPhieu");
                String maNCC = rs.getString("mancc");
                String maTK = rs.getString("matk");
                Date ngayTao = rs.getDate("Ngaytao");
                int tongTien = rs.getInt("Tongtien");
                int trangThai = rs.getInt("TrangThai");

                PhieuNhapDTO pm = new PhieuNhapDTO(maPhieu, ngayTao, maNCC, maTK, tongTien, trangThai);
                ketQua.add(pm);
            }
            System.out.println("Bạn đã thực thi " + sql);

            MyConnection.closeConnection(con);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ketQua;
    }
    
}
