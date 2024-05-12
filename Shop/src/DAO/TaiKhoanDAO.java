package DAO;

import IServices.IDAOService;
import MODELS.TaiKhoan;
import helper.XJdbc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class TaiKhoanDAO implements IDAOService<TaiKhoan, Integer> {
    final String INSERT_SQL = "insert into TaiKhoan(Email, IDNguoiDung, MatKhau, TrangThai) values(?, ?, ?, ?)";
    final String UPDATE_SQL = "update TaiKhoan set MatKhau=?, TrangThai=? where IDTaiKhoan=?";
    final String UPDATEMK_SQL = "update TaiKhoan set MatKhau=? where Email=?";
    final String SELECT_BY_EMAIL_SQL = "select * from TaiKhoan where Email=?";
    final String SELECT_ALL_SQL = "select * from TaiKhoan";
    @Override
    public void insert(TaiKhoan entity) {
        XJdbc.update(INSERT_SQL, entity.getEmail(), entity.getIdNguoiDung(), entity.getMatKhau(), entity.getTrangThai());
    }

    @Override
    public void update(TaiKhoan entity) {
        XJdbc.update(UPDATE_SQL, entity.getMatKhau(), entity.getTrangThai(), entity.getIdTaiKhoan());
    }
    
    public void updatemk(String mk, String user){
        XJdbc.update(UPDATEMK_SQL, mk, user);
    }
    
    @Override
    public void delete(Integer id) {
       
    }

    @Override
    public List<TaiKhoan> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    public TaiKhoan selectById(String email) {
       List<TaiKhoan> list = selectBySql(SELECT_BY_EMAIL_SQL, email);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<TaiKhoan> selectBySql(String sql, Object... agrs) {
        List<TaiKhoan> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, agrs);
            while (rs.next()) {
                TaiKhoan entity = new TaiKhoan();
                entity.setIdTaiKhoan(rs.getString("MATK"));
                entity.setEmail(rs.getString("Email"));
//                entity.setIdNguoiDung(rs.getInt("IDNguoiDung"));
                entity.setMatKhau(rs.getString("MATKHAU"));
                entity.setTrangThai(rs.getInt("TRANGTHAI"));
                entity.setVaiTro(rs.getInt("MAQ"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return list;
    }

    @Override
    public TaiKhoan selectById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
