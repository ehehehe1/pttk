/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanLiKho.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author PC
 */
public class QuanLyKhoMain extends JFrame{
    private JButton jb_trangchu, jb_thuoctinh, jb_sanpham, jb_pn, jb_ncc, jb_tke, jb_logout;
    private JLabel jLabel_logo;
    private JTabbedPane tp_main;
    private JPanel jPanel_menu;
    private String tenDN;
    
    public QuanLyKhoMain(String tenDN) {
        this.tenDN = tenDN;
        this.init();
    }

    private void init() {
        jb_trangchu = new JButton();
        jb_sanpham = new JButton();
        jb_pn = new JButton();
        jb_ncc = new JButton();
        jb_tke = new JButton();
        jLabel_logo = new JLabel();
        jPanel_menu = new JPanel();
        jb_logout = new JButton();
        jb_thuoctinh = new JButton();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Quản lý kho");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setLayout(null);

        ActionListener ac = new QuanLyKhoBUS(this);
        
        jPanel_menu.setBackground(Color.white);
        jPanel_menu.setLayout(null);
        
        jLabel_logo.setText("Hi, " + tenDN + " !");
        jLabel_logo.setFont(new Font("Roboto", 1, 22));
        jLabel_logo.setIcon(new ImageIcon(getClass().getResource("/res/user.png")));
        jPanel_menu.add(jLabel_logo);
        jLabel_logo.setBounds(40, 20, 400, 100);
        
        JLabel ex = new JLabel("-");
        ex.setBounds(0, 90, jPanel_menu.getWidth(), 1);
        jPanel_menu.add(ex);

        JSeparator separator = new JSeparator();
        separator.setOrientation(SwingConstants.HORIZONTAL);
        separator.setBounds(0, 150, 250, 10);
        jPanel_menu.add(separator);
        
        Color color_bg = new Color(235, 235, 235);
        
        jb_thuoctinh.setFont(new Font("Roboto", 0, 18));
        //jb_thuoctinh.setIcon(new ImageIcon(getClass().getResource("/res/loaisach.png")));
        jb_thuoctinh.setText("Thuộc tính");
        jb_thuoctinh.setBackground(Color.WHITE);
        jb_thuoctinh.setBorderPainted(false);
        jPanel_menu.add(jb_thuoctinh);
        jb_thuoctinh.setBounds(15, 250, 220, 60);
        jb_thuoctinh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                changeTab("Thuộc tính");                
            }
        });

        jb_sanpham.setBackground(Color.WHITE);
        jb_sanpham.setFont(new Font("Roboto", 0, 18));
        //jb_sanpham.setIcon(new ImageIcon(getClass().getResource("/res/book_mana.png")));
        jb_sanpham.setText("Sản phẩm");
        jb_sanpham.setHorizontalTextPosition(SwingConstants.RIGHT);
        jb_sanpham.setBorderPainted(false);
        jPanel_menu.add(jb_sanpham);
        jb_sanpham.setBounds(15, 340, 220, 60);
        jb_sanpham.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                changeTab("Sản phẩm");                
            }
        });

        jb_pn.setFont(new Font("Roboto", 0, 18));
        //jb_pn.setIcon(new ImageIcon(getClass().getResource("/res/the.png")));
        jb_pn.setText("Phiếu nhập");
        jb_pn.setBackground(Color.WHITE);
        jb_pn.setBorderPainted(false);
        jPanel_menu.add(jb_pn);
        jb_pn.setBounds(15, 430, 220, 60);
        jb_pn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                changeTab("Phiếu nhập");                
            }
        });

        jb_ncc.setFont(new Font("Roboto", 0, 18));
        //jb_ncc.setIcon(new ImageIcon(getClass().getResource("/res/muon.png")));
        jb_ncc.setText("Nhà cung cấp");
        jb_ncc.setBorderPainted(false);
        jb_ncc.setBackground(Color.WHITE);
        jPanel_menu.add(jb_ncc);
        jb_ncc.setBounds(15, 520, 220, 60);
        jb_ncc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                changeTab("Nhà cung cấp");                
            }
        });

        jb_tke.setFont(new Font("Roboto", 0, 18));
        //jb_tke.setIcon(new ImageIcon(getClass().getResource("/res/tra.png")));
        jb_tke.setText("Thống kê");
        jb_tke.setBorderPainted(false);
        jb_tke.setBackground(Color.WHITE);
        jPanel_menu.add(jb_tke);
        jb_tke.setBounds(15, 610, 220, 60);
        jb_tke.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                changeTab("Thống kê");                
            }
        });

        jb_logout.setFont(new Font("Roboto", 1, 24));
        jb_logout.setIcon(new ImageIcon(getClass().getResource("/res/dxuat.png")));
        jb_logout.setText("Đăng xuất");
        jPanel_menu.add(jb_logout);
        jb_logout.setBackground(Color.white);
        jb_logout.setBounds(0, 900, 230, 70);
        jb_logout.setBorderPainted(false);
        jb_logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                changeTab("Đăng xuất");                
            }
        });

        jPanel_menu.setBounds(0, 0, 250, this.getMaximumSize().height);
        getContentPane().add(jPanel_menu);

        tp_main.setFont(new Font("Roboto", 0, 18));
        tp_main.setBounds(260, 0, this.getMaximumSize().width - 290, this.getMaximumSize().height);

        getContentPane().add(tp_main);
        this.setVisible(true);
    }
    
    public void changeTab(String tab) {
        Color colorbg = new Color(240, 240, 240);
        if(tab.equals("Thuộc tính")) {
            jb_trangchu.setBackground(Color.white);
            jb_thuoctinh.setBackground(colorbg);
            jb_sanpham.setBackground(Color.white);
            jb_pn.setBackground(Color.white);
            jb_ncc.setBackground(Color.white);
            jb_tke.setBackground(Color.white);
        }
        
        else if (tab.equals("Sản phẩm")) {
            jb_trangchu.setBackground(Color.white);
            jb_thuoctinh.setBackground(Color.white);
            jb_sanpham.setBackground(colorbg);
            jb_pn.setBackground(Color.white);
            jb_ncc.setBackground(Color.white);
            jb_tke.setBackground(Color.white);
            
        } else if (tab.equals("Phiếu nhập")) {
            jb_trangchu.setBackground(Color.white);
            jb_thuoctinh.setBackground(Color.white);
            jb_sanpham.setBackground(Color.white);
            jb_pn.setBackground(colorbg);
            jb_ncc.setBackground(Color.white);
            jb_tke.setBackground(Color.white);

        } else if (tab.equals("Nhà cung cấp")) {
            jb_trangchu.setBackground(Color.white);
            jb_thuoctinh.setBackground(Color.white);
            jb_sanpham.setBackground(Color.white);
            jb_pn.setBackground(Color.white);
            jb_ncc.setBackground(colorbg);
            jb_tke.setBackground(Color.white);

        } else if (tab.equals("Thống kê")) {
            jb_trangchu.setBackground(Color.white);
            jb_thuoctinh.setBackground(Color.white);
            jb_sanpham.setBackground(Color.white);
            jb_pn.setBackground(Color.white);
            jb_ncc.setBackground(Color.white);
            jb_tke.setBackground(colorbg);
        }
        removeAndAddJTabble(tab);
    }
    
    public void removeAndAddJTabble(String tab) {
        if (tab.equals("Thuộc tính")) {
            tp_main.removeAll();
            tp_main.addTab("Quản lý thuộc tính sản phẩm", new ThuocTinhGUI(tenDN));
        } else if (tab.equals("Sản phẩm")) {
            tp_main.removeAll();
            tp_main.addTab("Quản lý sản phẩm", new SanPhamGUI(tenDN));
        } else if (tab.equals("Phiếu nhập")) {
            tp_main.removeAll();
            tp_main.addTab("Phiếu nhập", new PhieuNhapGUI(tenDN));
            tp_main.addTab("Thêm phiếu nhập", new ThemPhieuNhapGUI(tenDN));
        } else if (tab.equals("Nhà cung cấp")) {
            tp_main.removeAll();
            tp_main.addTab("Quản lý nhà cung cấp", new NhaCungCapGUI(tenDN));
//        } else if (tab.equals("Thống kê")) {
//            tp_main.removeAll();
//            tp_main.addTab("Thống kê", );
//            
        } else if (tab.equals("Đăng xuất")) {
            int check = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn đăng xuất?", "warning", JOptionPane.YES_NO_OPTION);
            if(check == JOptionPane.YES_OPTION) {
                dispose();
                new LoginGUI();
            }
        }
    } 
}
