/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanLiKho.BLL;

import java.util.ArrayList;
import quanLiKho.DAO.CT_SanPhamDAO;
import quanLiKho.DTO.CT_SanPhamDTO;

/**
 *
 * @author PC
 */
public class CT_SanPhamBLL {
    CT_SanPhamDAO ctspDAO = new CT_SanPhamDAO();
    
    public ArrayList<CT_SanPhamDTO> getSelectedAll() {
        return ctspDAO.selectAll();
    }
    
    public ArrayList<CT_SanPhamDTO> getSelectedByCondition(String condition) {
        return ctspDAO.selectByCondition(condition);
    }
    
    public CT_SanPhamDTO getSelectedById(CT_SanPhamDTO t) {
        return ctspDAO.selectById(t);
    }
    
    public int insertSelected(CT_SanPhamDTO t) {
        return ctspDAO.insert(t);
    }
    
    public int updateSelected(CT_SanPhamDTO t) {
        return ctspDAO.update(t);
    }
    
    public int deleteSelected(CT_SanPhamDTO t) {
        return ctspDAO.delete(t);
    }
}
