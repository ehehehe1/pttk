/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanLiKho.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author PC
 */
public class QuanLyKhoBUS implements ActionListener{
    private QuanLyKhoMain main;


    public QuanLyKhoBUS(QuanLyKhoMain main) {
        this.main = main;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        this.main.changeTab(src);
    }
    
}
