/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanLiKho.BLL;

import java.util.ArrayList;
import quanLiKho.DAO.PhieuNhapDAO;
import quanLiKho.DTO.PhieuNhapDTO;

/**
 *
 * @author PC
 */
public class PhieuNhapBLL {
    PhieuNhapDAO pnDAO = new PhieuNhapDAO();
    
    public ArrayList<PhieuNhapDTO> getSelectedAll() {
        return pnDAO.selectAll();
    }
    
    public ArrayList<PhieuNhapDTO> getSelectedByCondition(String condition) {
        return pnDAO.selectByCondition(condition);
    }
    
    public PhieuNhapDTO getSelectedById(PhieuNhapDTO t) {
        return pnDAO.selectById(t);
    }
    
    public int insertSelected(PhieuNhapDTO t) {
        return pnDAO.insert(t);
    }
    
    public int updateSelected(PhieuNhapDTO t) {
        return pnDAO.update(t);
    }
    
    public int deleteSelected(PhieuNhapDTO t) {
        return pnDAO.delete(t);
    }
}
