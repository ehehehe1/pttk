/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanLiKho.BLL;

import java.util.ArrayList;
import quanLiKho.DAO.SanPhamDAO;
import quanLiKho.DTO.SanPhamDTO;

/**
 *
 * @author PC
 */
public class SanPhamBLL {
    SanPhamDAO spDAO = new SanPhamDAO();
    
    public ArrayList<SanPhamDTO> getSelectedAll() {
        return spDAO.selectAll();
    }
    
    public ArrayList<SanPhamDTO> getSelectedByCondition(String condition) {
        return spDAO.selectByCondition(condition);
    }
    
    public SanPhamDTO getSelectedById(SanPhamDTO t) {
        return spDAO.selectById(t);
    }
    
    public int insertSelected(SanPhamDTO t) {
        return spDAO.insert(t);
    }
    
    public int updateSelected(SanPhamDTO t) {
        return spDAO.update(t);
    }
    
    public int deleteSelected(SanPhamDTO t) {
        return spDAO.delete(t);
    }
}
