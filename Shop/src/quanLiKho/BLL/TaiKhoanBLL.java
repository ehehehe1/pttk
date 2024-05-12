/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanLiKho.BLL;

import java.util.ArrayList;
import quanLiKho.DAO.TaiKhoanDAO;
import quanLiKho.DTO.TaiKhoanDTO;

/**
 *
 * @author PC
 */
public class TaiKhoanBLL {
    TaiKhoanDAO tkDAO = new TaiKhoanDAO();
    
    public ArrayList<TaiKhoanDTO> getSelectedAll() {
        return tkDAO.selectAll();
    }
    
    public ArrayList<TaiKhoanDTO> getSelectedByCondition(String condition) {
        return tkDAO.selectByCondition(condition);
    }
    
    public TaiKhoanDTO getSelectedById(TaiKhoanDTO t) {
        return tkDAO.selectById(t);
    }
    
    public int insertSelected(TaiKhoanDTO t) {
        return tkDAO.insert(t);
    }
    
    public int updateSelected(TaiKhoanDTO t) {
        return tkDAO.update(t);
    }
    
    public int deleteSelected(TaiKhoanDTO t) {
        return tkDAO.delete(t);
    }
}
