/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanLiKho.BLL;

import java.util.ArrayList;
import quanLiKho.DAO.MauSacDAO;
import quanLiKho.DTO.MauSacDTO;

/**
 *
 * @author PC
 */
public class MauSacBLL {
    MauSacDAO msDAO = new MauSacDAO();
    
    public ArrayList<MauSacDTO> getSelectedAll() {
        return msDAO.selectAll();
    }
    
    public ArrayList<MauSacDTO> getSelectedByCondition(String condition) {
        return msDAO.selectByCondition(condition);
    }
    
    public MauSacDTO getSelectedByCondition1(String condition) {
        return msDAO.selectByCondition1(condition);
    }
    
    public MauSacDTO getSelectedById(MauSacDTO t) {
        return msDAO.selectById(t);
    }
    
    public int insertSelected(MauSacDTO t) {
        return msDAO.insert(t);
    }
    
    public int updateSelected(MauSacDTO t) {
        return msDAO.update(t);
    }
    
    public int deleteSelected(MauSacDTO t) {
        return msDAO.delete(t);
    }
}
