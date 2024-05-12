package giaoDien;

import com.formdev.flatlaf.FlatLightLaf;
import helper.Auth;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import javax.mail.MessagingException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class FrmHome extends javax.swing.JFrame {

    int index = 0;
    Color mauMeNuChinh = new Color(51, 153, 254);
    Color mauMeNuPhu = new Color(51, 204, 153);

    public FrmHome() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.init();

        execute();
    }

    private void execute() {
        ImageIcon iconStaff = new ImageIcon(getClass().getResource("/Hinhanh/menu.png"));
        ImageIcon iconQLTaiKhoan = new ImageIcon(getClass().getResource("/Hinhanh/protect.png"));
        ImageIcon iconTTTaiKhoan = new ImageIcon(getClass().getResource("/Hinhanh/acc.png"));
        ImageIcon iconThanhToan = new ImageIcon(getClass().getResource("/Hinhanh/thanhtoan.png"));
        ImageIcon iconSubMenu = new ImageIcon(getClass().getResource("/Hinhanh/subMenu.png"));
        ImageIcon iconLogout = new ImageIcon(getClass().getResource("/Hinhanh/logout.png"));
        ImageIcon iconSanPham = new ImageIcon(getClass().getResource("/Hinhanh/sanpham.png"));
        ImageIcon iconThongKe = new ImageIcon(getClass().getResource("/Hinhanh/thongke.png"));
        //Tạo Menu Quản Lý quan ao
        MenuItem menuQuan = new MenuItem(mauMeNuPhu, iconSubMenu, "\tQuản lý sản phẩm", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (index == 1) {
                    panelBody.removeAll();
                    panelBody.add(new PFrmQLSanPham());
                    panelBody.repaint();
                    panelBody.revalidate();
                } else {
                    index = 1;
                    panelBody.removeAll();
                    panelBody.add(new PFrmQLSanPham());
                    panelBody.repaint();
                    panelBody.revalidate();
                }
            }
        });
        MenuItem menuAo = new MenuItem(mauMeNuPhu, iconSubMenu, "\tThuộc Tính Sản Phẩm", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (index == 1) {
                    panelBody.removeAll();
                    panelBody.add(new PFrmThuocTinhSP());
                    panelBody.repaint();
                    panelBody.revalidate();
                } else {
                    index = 1;
                    panelBody.removeAll();
                    panelBody.add(new PFrmThuocTinhSP());
                    panelBody.repaint();
                    panelBody.revalidate();
                }
            }
        });

        //Tạo Menu Thanh toan
        MenuItem menuhoadon = new MenuItem(mauMeNuPhu, iconSubMenu, "\tBán Hàng", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (index == 1) {
                    panelBody.removeAll();
                    panelBody.add(new PFrmHoaDon());
                    panelBody.repaint();
                    panelBody.revalidate();
                } else {
                    index = 1;
                    panelBody.removeAll();
                    panelBody.add(new PFrmHoaDon());
                    panelBody.repaint();
                    panelBody.revalidate();
                }
            }
        });

        //Tạo Menu taikhoan
        MenuItem menuThongtin = new MenuItem(mauMeNuPhu, iconSubMenu, "\tThông Tin", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (index == 1) {
                    panelBody.removeAll();
                    panelBody.add(new Taikhoan());
                    panelBody.repaint();
                    panelBody.revalidate();
                } else {
                    index = 1;
                    panelBody.removeAll();
                    panelBody.add(new Taikhoan());
                    panelBody.repaint();
                    panelBody.revalidate();
                }
            }
        });
        MenuItem menuDoimk = new MenuItem(mauMeNuPhu, iconSubMenu, "\tĐổi Mật Khẩu", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (index == 1) {
                    panelBody.removeAll();
                    panelBody.add(new Doimk());
                    panelBody.repaint();
                    panelBody.revalidate();
                } else {
                    index = 1;
                    panelBody.removeAll();
                    panelBody.add(new Doimk());
                    panelBody.repaint();
                    panelBody.revalidate();
                }
            }
        });

        //Tạo Menu quẩn lý tài khoản cho Admin 
        MenuItem menuHome = new MenuItem(mauMeNuChinh, iconStaff, "Trang Chủ", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (index == 1) {
                    panelBody.removeAll();
                    panelBody.add(new PFromTrangchu());
                    panelBody.repaint();
                    panelBody.revalidate();
                } else {
                    index = 1;
                    panelBody.removeAll();
                    panelBody.add(new PFromTrangchu());
                    panelBody.repaint();
                    panelBody.revalidate();
                }

            }
        });
        MenuItem menuQLSanpham = new MenuItem(mauMeNuChinh, iconSanPham, "Sản Phẩm", null, menuQuan, menuAo);
        MenuItem menuThanhtoan = new MenuItem(mauMeNuChinh, iconThanhToan, "Thanh Toán", null, menuhoadon);
        MenuItem menutaikhoan = new MenuItem(mauMeNuChinh, iconTTTaiKhoan, "Tài Khoản", null, menuThongtin, menuDoimk);

        MenuItem menuDangxuat = new MenuItem(mauMeNuChinh, iconLogout, "Đăng Xuất", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!helper.MsgBox.confirm(null, "Bạn có muốn đăng xuất?")) {
                    return;
                }
                dispose();
                helper.Auth.clear();
                init();

            }
        });
        MenuItem menuThongke = new MenuItem(mauMeNuChinh, iconThongKe, "\tThống Kê", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (index == 1) {
                    panelBody.removeAll();
                    panelBody.add(new PFrmThongKe());
                    panelBody.repaint();
                    panelBody.revalidate();
                } else {
                    index = 1;
                    panelBody.removeAll();
                    panelBody.add(new PFrmThongKe());
                    panelBody.repaint();
                    panelBody.revalidate();
                }
            }
        });
        //Tạo Menu quẩn lý tài khoản cho Admin 
        MenuItem menuQuanLyTaiKhoan = new MenuItem(mauMeNuChinh, iconQLTaiKhoan, "Quản Lý Tài Khoản", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (index == 1) {
                    panelBody.removeAll();
                    panelBody.add(new QuanLyTK());
                    panelBody.repaint();
                    panelBody.revalidate();
                } else {
                    index = 1;
                    panelBody.removeAll();
                    panelBody.add(new QuanLyTK());
                    panelBody.repaint();
                    panelBody.revalidate();
                }
            }
        });

        addMenu(menuHome, menuQLSanpham, menuThanhtoan, menutaikhoan, menuQuanLyTaiKhoan, menuThongke, menuDangxuat);
        panelBody.add(new PFromTrangchu());

    }

    private void addMenu(MenuItem... menu) {
        for (int i = 0; i < menu.length; i++) {
            menus.add(menu[i]);
            ArrayList<MenuItem> subMenu = menu[i].getSubMenu();
            for (MenuItem m : subMenu) {
                addMenu(m);
            }
        }
        menus.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menus = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelBody = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panelMenu.setBackground(new java.awt.Color(255, 204, 204));
        panelMenu.setPreferredSize(new java.awt.Dimension(250, 486));

        menus.setBackground(new java.awt.Color(255, 255, 204));
        menus.setLayout(new javax.swing.BoxLayout(menus, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(menus);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setText("Quản lý Bán quần áo");

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE))
        );

        getContentPane().add(panelMenu, java.awt.BorderLayout.LINE_START);

        panelBody.setToolTipText("quản lý");
        panelBody.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panelBody, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1188, 797));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
//        if(helper.MsgBox.confirm(null, "Bạn có muốn thoát")){
//        helper.Auth.clear();
//        System.exit(0);
//        }
    }//GEN-LAST:event_formWindowClosing

    public static void main(String args[]) throws MessagingException, UnsupportedEncodingException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            javax.swing.UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmHome().setVisible(true);
            }
        });
        
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel menus;
    private javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelMenu;
    // End of variables declaration//GEN-END:variables
    private void init() {
        new JFrmLogin(this, true).setVisible(true);
        this.check();
    }

    public void check() {
        boolean ck = Auth.isLogin();
        this.setVisible(ck);
    }
}