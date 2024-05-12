package giaoDien;

import DAO.TaiKhoanDAO;
import helper.MsgBox;
import MODELS.TaiKhoan;
import helper.Auth;
import helper.XJdbc;
import javax.swing.ImageIcon;

public class Doimk extends javax.swing.JPanel {

    TaiKhoanDAO tkdao;
    int count = -1;
    int i = -1, j = -1;

    public Doimk() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paldoimk = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPassMoi = new javax.swing.JPasswordField();
        txtrePassMoi = new javax.swing.JPasswordField();
        btnLuu = new javax.swing.JButton();
        txtPassCu = new javax.swing.JPasswordField();
        btnshowpassnew = new javax.swing.JButton();
        btnshowpassnew1 = new javax.swing.JButton();
        btnshowpassold = new javax.swing.JButton();

        paldoimk.setBackground(new java.awt.Color(153, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel1.setText("ĐỔI MẬT KHẨU");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Mật Khẩu Cũ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Mật Khẩu Mới");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Nhập Lại Mật Khẩu Mới");

        txtPassMoi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtrePassMoi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnLuu.setBackground(new java.awt.Color(153, 255, 255));
        btnLuu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinhanh/Accept.png"))); // NOI18N
        btnLuu.setText("LƯU");
        btnLuu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        txtPassCu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnshowpassnew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinhanh/nshow.png"))); // NOI18N
        btnshowpassnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnshowpassnewActionPerformed(evt);
            }
        });

        btnshowpassnew1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinhanh/nshow.png"))); // NOI18N
        btnshowpassnew1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnshowpassnew1ActionPerformed(evt);
            }
        });

        btnshowpassold.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinhanh/nshow.png"))); // NOI18N
        btnshowpassold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnshowpassoldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassCu, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnshowpassnew, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnshowpassold, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtrePassMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btnshowpassnew1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(236, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(432, 432, 432))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(444, 444, 444))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtPassCu, txtPassMoi, txtrePassMoi});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnshowpassnew, btnshowpassnew1, btnshowpassold});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jLabel2)
                        .addGap(16, 16, 16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnshowpassold, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassCu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPassMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(btnshowpassnew, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnshowpassnew1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtrePassMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addGap(68, 68, 68)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtPassCu, txtPassMoi, txtrePassMoi});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnshowpassnew, btnshowpassnew1, btnshowpassold});

        javax.swing.GroupLayout paldoimkLayout = new javax.swing.GroupLayout(paldoimk);
        paldoimk.setLayout(paldoimkLayout);
        paldoimkLayout.setHorizontalGroup(
            paldoimkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paldoimkLayout.createSequentialGroup()
                .addGap(296, 296, 296)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(301, Short.MAX_VALUE))
        );
        paldoimkLayout.setVerticalGroup(
            paldoimkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paldoimkLayout.createSequentialGroup()
                .addContainerGap(243, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(224, 224, 224))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paldoimk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paldoimk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed

        String matKhauCu = new String(txtPassCu.getPassword());
        String matKhauMoi = new String(txtPassMoi.getPassword());
        String matKhauMoi1 = new String(txtrePassMoi.getPassword());
        try {
            
        
        if (matKhauCu.length() == 0
                || matKhauMoi.length() == 0
                || matKhauMoi1.length() == 0) {
            MsgBox.alert(this, "Không được để trống thông tin");
            return;
        } else if (!matKhauCu.equals(Auth.user.getMatKhau())) {
            MsgBox.alert(this, "Nhập sai mật khẩu cũ");
            return;
        } else if (matKhauMoi.length() < 6 || matKhauMoi.length() > 10) {
            MsgBox.alert(this, "Mật khẩu phải trên 6 kí tự và dưới 10 kí tự");
            return;
        } else if (!matKhauMoi.equals(matKhauMoi1)) {
            MsgBox.alert(this, "Xác nhận mật khẩu mới sai");
            return;
        } else {
            String sql = "update TaiKhoan set MatKhau=? where Email=?";
            XJdbc.update(sql, matKhauMoi, Auth.user.getEmail());
            MsgBox.alert(this, "Đổi mật khẩu thành công");
            this.setNew();
        }} catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Lỗi của Hưng");
        }
    }//GEN-LAST:event_btnLuuActionPerformed


    private void btnshowpassoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnshowpassoldActionPerformed
        count++;
        if (count % 2 == 0) {
            txtPassCu.setEchoChar('\u0000');
            btnshowpassold.setIcon(new ImageIcon("src\\Hinhanh\\showp.png"));
        } else {
            txtPassCu.setEchoChar('\u2022');
            btnshowpassold.setIcon(new ImageIcon("src\\Hinhanh\\nshow.png"));
        }
    }//GEN-LAST:event_btnshowpassoldActionPerformed

    private void btnshowpassnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnshowpassnewActionPerformed
        i++;
        if (i % 2 == 0) {
            txtPassMoi.setEchoChar('\u0000');
            btnshowpassnew.setIcon(new ImageIcon("src\\Hinhanh\\showp.png"));
        } else {
            txtPassMoi.setEchoChar('\u2022');
            btnshowpassnew.setIcon(new ImageIcon("src\\Hinhanh\\nshow.png"));
        }
    }//GEN-LAST:event_btnshowpassnewActionPerformed

    private void btnshowpassnew1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnshowpassnew1ActionPerformed
        j++;
        if (j % 2 == 0) {
            txtrePassMoi.setEchoChar('\u0000');
            btnshowpassnew1.setIcon(new ImageIcon("src\\Hinhanh\\showp.png"));
        } else {
            txtrePassMoi.setEchoChar('\u2022');
            btnshowpassnew1.setIcon(new ImageIcon("src\\Hinhanh\\nshow.png"));
        }
    }//GEN-LAST:event_btnshowpassnew1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnshowpassnew;
    private javax.swing.JButton btnshowpassnew1;
    private javax.swing.JButton btnshowpassold;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel paldoimk;
    private javax.swing.JPasswordField txtPassCu;
    private javax.swing.JPasswordField txtPassMoi;
    private javax.swing.JPasswordField txtrePassMoi;
    // End of variables declaration//GEN-END:variables

    private void setNew() {

        txtPassCu.setText("");
        txtPassMoi.setText("");
        txtrePassMoi.setText("");
    }
}
