/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanLiKho.BLL;

import java.util.ArrayList;
import quanLiKho.DAO.NhaCungCapDAO;
import quanLiKho.DTO.NhaCungCapDTO;

/**
 *
 * @author PC
 */
public class NhaCungCapBLL {
    NhaCungCapDAO nccDAO = new NhaCungCapDAO();
    
    public ArrayList<NhaCungCapDTO> getSelectedAll() {
        return nccDAO.selectAll();
    }
    
    public ArrayList<NhaCungCapDTO> getSelectedByCondition(String condition) {
        return nccDAO.selectByCondition(condition);
    }
    
    public NhaCungCapDTO getSelectedById(NhaCungCapDTO t) {
        return nccDAO.selectById(t);
    }
    
    public int insertSelected(NhaCungCapDTO t) {
        return nccDAO.insert(t);
    }
    
    public int updateSelected(NhaCungCapDTO t) {
        return nccDAO.update(t);
    }
    
    public int deleteSelected(NhaCungCapDTO t) {
        return nccDAO.delete(t);
    }
}
