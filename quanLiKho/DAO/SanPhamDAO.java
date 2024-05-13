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
import quanLiKho.DTO.SanPhamDTO;

/**
 *
 * @author PC
 */
public class SanPhamDAO implements DAOInterface<SanPhamDTO>{
    /*create table SANPHAM(
	MASP	varchar(10) primary key,
	TENSP	nvarchar(255) NOT NULL,
	HINHANH varchar(50),
	GIABAN	int,
	MALOAI	varchar(10) foreign key references LOAISP(MALOAI),
	SOLUONG int,			-- soluong tính tự động bằng tổng các số lượng sản phẩm của từng mã chi tiết sản phẩm
	TRANGTHAI smallint NOT NULL
    )
    */
    @Override
    public int insert(SanPhamDTO t) {
        int ketQua = 0;
        try {
            Connection con = MyConnection.getConnection();

            String sql = "INSERT INTO SanPham(MaSP, TenSP, HinhAnh, GiaNhap, GiaBan, MaLoai, SoLuong, TrangThai)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, t.getMaSP());
            ps.setString(2, t.getTenSP());
            ps.setString(3, t.getHinhAnh());
            ps.setInt(4, t.getGiaNhap());
            ps.setInt(5, t.getGiaBan());
            ps.setString(6, t.getMaLoai());
            ps.setInt(7, t.getSoLuong());
            ps.setInt(8, t.getTrangThai());
            
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
    public int update(SanPhamDTO t) {
        int ketQua = 0;
        try {
            Connection con = MyConnection.getConnection();
            String sql = "UPDATE SanPham"
                    + " SET TenSP = ?, HinhAnh = ?, GiaNhap = ?, GiaBan = ?, MaLoai = ?, SoLuong = ?, TrangThai = ?"
                    + " WHERE MaSP = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(8, t.getMaSP());
            ps.setString(1, t.getTenSP());
            ps.setString(2, t.getHinhAnh());
            ps.setInt(3, t.getGiaNhap());
            ps.setInt(4, t.getGiaBan());
            ps.setString(5, t.getMaLoai());
            ps.setInt(6, t.getSoLuong());
            ps.setInt(7, t.getTrangThai());

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
    public int delete(SanPhamDTO t) {
        int ketQua = 0;

        try {
            Connection con = MyConnection.getConnection();
            String query = "Update SanPham SET TrangThai = 0" + " WHERE MaSP = '" + t.getMaSP() + "'";

            Statement st = con.createStatement();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, t.getMaSP());

            ketQua = st.executeUpdate(query);
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
    public ArrayList<SanPhamDTO> selectAll() {
        ArrayList<SanPhamDTO> listCTPM = new ArrayList<>();
        try {
            Connection con = MyConnection.getConnection();
            String sql = "SELECT * FROM SanPham, PhieuNhap" + " WHERE PhieuNhap.MaPhieu = SanPham.MaPhieu";
            System.out.println(sql);
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String masp = rs.getString("MaSP");
                String ten = rs.getString("TenSP");
                String img = rs.getString("HinhAnh");
                int gianhap = rs.getInt("GiaNhap");
                int giaban = rs.getInt("GiaBan");
                int sl = rs.getInt("SoLuong");
                String maloai = rs.getString("maLoai");
                int trangThai = rs.getInt("trangThai");

                listCTPM.add(new SanPhamDTO(masp, ten, img, gianhap, giaban, maloai, sl, trangThai));
            }

            MyConnection.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listCTPM;
    }

    @Override
    public SanPhamDTO selectById(SanPhamDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<SanPhamDTO> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
