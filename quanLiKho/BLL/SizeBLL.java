/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanLiKho.BLL;

import java.util.ArrayList;
import quanLiKho.DAO.SizeDAO;
import quanLiKho.DTO.SizeDTO;

/**
 *
 * @author PC
 */
public class SizeBLL {
    SizeDAO ktDAO = new SizeDAO();
    
    public ArrayList<SizeDTO> getSelectedAll() {
        return ktDAO.selectAll();
    }
    
    public ArrayList<SizeDTO> getSelectedByCondition(String condition) {
        return ktDAO.selectByCondition(condition);
    }
    
    public SizeDTO getSelectedByCondition1(String condition) {
        return ktDAO.selectByCondition1(condition);
    }
    
    public SizeDTO getSelectedById(SizeDTO t) {
        return ktDAO.selectById(t);
    }
    
    public int insertSelected(SizeDTO t) {
        return ktDAO.insert(t);
    }
    
    public int updateSelected(SizeDTO t) {
        return ktDAO.update(t);
    }
    
    public int deleteSelected(SizeDTO t) {
        return ktDAO.delete(t);
    }
}
