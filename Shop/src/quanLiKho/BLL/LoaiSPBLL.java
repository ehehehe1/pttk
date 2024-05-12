/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanLiKho.BLL;

import java.util.ArrayList;
import quanLiKho.DAO.LoaiSPDAO;
import quanLiKho.DTO.LoaiSPDTO;

/**
 *
 * @author PC
 */
public class LoaiSPBLL {
    LoaiSPDAO loaiDAO = new LoaiSPDAO();
    
    public ArrayList<LoaiSPDTO> getSelectedAll() {
        return loaiDAO.selectAll();
    }
    
    public ArrayList<LoaiSPDTO> getSelectedByCondition(String condition) {
        return loaiDAO.selectByCondition(condition);
    }
    
    public LoaiSPDTO getSelectedById(LoaiSPDTO t) {
        return loaiDAO.selectById(t);
    }
    
    public int insertSelected(LoaiSPDTO t) {
        return loaiDAO.insert(t);
    }
    
    public int updateSelected(LoaiSPDTO t) {
        return loaiDAO.update(t);
    }
    
    public int deleteSelected(LoaiSPDTO t) {
        return loaiDAO.delete(t);
    }
}
