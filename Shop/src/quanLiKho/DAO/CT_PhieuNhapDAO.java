/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanLiKho.DAO;

import db.DAOInterface;
import db.MyConnection;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import quanLiKho.DTO.CT_PhieuNhapDTO;


public class CT_PhieuNhapDAO implements DAOInterface<CT_PhieuNhapDTO>{
    /*create table CT_PHIEUNHAP(
	MAPHIEU	varchar(10),
	MACTSP	varchar(30),
	SOLUONG	int,
	DONGIA	money,
	THANHTIEN money,
	primary key (MAPHIEU, MACTSP),
	foreign key (MAPHIEU) references PHIEUNHAP(MAPHIEU),
	foreign key (MACTSP) references CT_SANPHAM(MACTSP)
    )*/
    
    @Override
    public int insert(CT_PhieuNhapDTO t) {
        int ketQua = 0;
        try {
            Connection con = MyConnection.getConnection();

            String sql = "INSERT INTO CT_PhieuNhap(MaPhieu, MaCTSP, SoLuong, DonGia, ThanhTien)"
                    + " VALUES (?, ?, ?, ?, ?) ";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, t.getMaPhieu());
            ps.setString(2, t.getMaCTSP());
            ps.setInt(3, t.getSoLuong());
            ps.setBigDecimal(4, t.getDonGia());
            ps.setBigDecimal(5, t.getThanhTien());
            
            System.out.println(sql);
            ketQua = ps.executeUpdate(sql);
            if (ketQua != 0) {
                System.out.println("Insert ctpm thanh cong.");
            } else System.out.println("Insert ctpm that bai.");
            
            MyConnection.closeConnection(con);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    return ketQua ;
    }

    @Override
    public int update(CT_PhieuNhapDTO t) {
        int ketQua = 0;

        try {
            Connection con = MyConnection.getConnection();
            String sql = "UPDATE CT_PhieuNhap"
                    + " SET MaCTSP = ?, SoLuong = ?, DonGia = ?, ThanhTien = ?"
                    + " WHERE MaPhieu = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(5, t.getMaPhieu());
            ps.setString(1, t.getMaCTSP());
            ps.setInt(2, t.getSoLuong());
            ps.setBigDecimal(3, t.getDonGia());
            ps.setBigDecimal(4, t.getThanhTien());

            ketQua = ps.executeUpdate();
            if (ketQua != 0) {
                System.out.println("Update ctpm thanh cong.");
            } else System.out.println("Update ctpm that bai.");

            MyConnection.closeConnection(con);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int delete(CT_PhieuNhapDTO t) {
        int ketQua = 0;

        try {
            Connection con = MyConnection.getConnection();
            String query = "DELETE FROM CT_PhieuNhap" + " WHERE MaCTSP = '" + t.getMaCTSP() + "' and MaPhieu = '" + t.getMaPhieu() + "'";

            Statement st = con.createStatement();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, t.getMaCTSP());
            ps.setString(2, t.getMaPhieu());

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
    public ArrayList<CT_PhieuNhapDTO> selectAll() {
        ArrayList<CT_PhieuNhapDTO> listCTPM = new ArrayList<>();
        try {
            Connection con = MyConnection.getConnection();
            String sql = "SELECT * FROM CT_PhieuNhap, PhieuNhap" + " WHERE PhieuNhap.MaPhieu = CT_PhieuNhap.MaPhieu";
            System.out.println(sql);
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String maPhieu = rs.getString("MaPhieu");
                String maCTSP = rs.getString("MaCTSP");
                int sl = rs.getInt("SoLuong");
                BigDecimal dongia = rs.getBigDecimal("DonGia");
                BigDecimal thanhtien = rs.getBigDecimal("ThanhTien");

                listCTPM.add(new CT_PhieuNhapDTO(maPhieu, maCTSP, sl, dongia, thanhtien));
            }

            MyConnection.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listCTPM;
    }

    @Override
    public CT_PhieuNhapDTO selectById(CT_PhieuNhapDTO t) {
        CT_PhieuNhapDTO ctpn = null;
        try {
            Connection con = MyConnection.getConnection();
            String query = "SELECT * FROM CT_PhieuNhap WHERE MaPhieu = ? and MaCTSP = ?";
            
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, t.getMaPhieu());
            ps.setString(2, t.getMaCTSP());
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String maPhieu = rs.getString("MaPhieu");
                String maCTSP = rs.getString("MaCTSP");
                int sl = rs.getInt("SoLuong");
                BigDecimal dongia = rs.getBigDecimal("DonGia");
                BigDecimal thanhtien = rs.getBigDecimal("ThanhTien");

                ctpn = new CT_PhieuNhapDTO(maPhieu, maCTSP, sl, dongia, thanhtien);
            }

            MyConnection.closeConnection(con);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ctpn;
    }
    
    @Override
    public ArrayList<CT_PhieuNhapDTO> selectByCondition(String condition) {
        ArrayList<CT_PhieuNhapDTO> ketQua = new ArrayList<>();

        try {

            Connection con = MyConnection.getConnection();

            String query = "SELECT * FROM PhieuNhap WHERE " + condition;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String maPhieu = rs.getString("MaPhieu");
                String maCTSP = rs.getString("MaCTSP");
                int sl = rs.getInt("SoLuong");
                BigDecimal dongia = rs.getBigDecimal("DonGia");
                BigDecimal thanhtien = rs.getBigDecimal("ThanhTien");

                CT_PhieuNhapDTO ctpn = new CT_PhieuNhapDTO(maPhieu, maCTSP, sl, dongia, thanhtien);
                System.out.println(ctpn.toString());
                ketQua.add(ctpn);
            }
            System.out.println("Bạn đã thực thi " + query);

            MyConnection.closeConnection(con);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketQua;
    }
    
}
