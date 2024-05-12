
package giaoDien;

import MODELS.TaiKhoan;
import helper.MsgBox;
import java.text.DecimalFormat;
import java.util.Random;
import DAO.TaiKhoanDAO;
import helper.Auth;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import MODELS.Email;
import helper.EmailUtils;
import helper.XJdbc;
import javax.swing.ImageIcon;


public class JFrmQuenMatKhau extends javax.swing.JDialog {

    TaiKhoanDAO tkdao;
    private String otp, ma;
    int count = -1;
    int i = -1;
    public JFrmQuenMatKhau(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.tkdao = new TaiKhoanDAO();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        txtcode = new javax.swing.JTextField();
        btnnhanCode = new javax.swing.JButton();
        btnluu = new javax.swing.JButton();
        btnhuy = new javax.swing.JButton();
        txtmatKhauMoi = new javax.swing.JPasswordField();
        txtmatKhauMoi1 = new javax.swing.JPasswordField();
        btnshowP1 = new javax.swing.JButton();
        btnshowP = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("QUÊN MẬT KHẨU");

        jLabel2.setText("Email");

        jLabel3.setText("Code");

        jLabel4.setText("Mật Khẩu Mới");

        jLabel5.setText("Nhập Lại Mật Khẩu ");

        txtemail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtcode.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnnhanCode.setText("Nhận Code");
        btnnhanCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnhanCodeActionPerformed(evt);
            }
        });

        btnluu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinhanh/Accept.png"))); // NOI18N
        btnluu.setText("Lưu");
        btnluu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnluuActionPerformed(evt);
            }
        });

        btnhuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinhanh/No.png"))); // NOI18N
        btnhuy.setText("Hủy");
        btnhuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhuyActionPerformed(evt);
            }
        });

        txtmatKhauMoi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtmatKhauMoi1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnshowP1.setBackground(new java.awt.Color(255, 255, 255));
        btnshowP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinhanh/nshow.png"))); // NOI18N
        btnshowP1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnshowP1MouseClicked(evt);
            }
        });

        btnshowP.setBackground(new java.awt.Color(255, 255, 255));
        btnshowP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinhanh/nshow.png"))); // NOI18N
        btnshowP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnshowPMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtemail)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtcode, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnnhanCode))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnluu)
                        .addGap(144, 144, 144)
                        .addComponent(btnhuy))
                    .addComponent(txtmatKhauMoi)
                    .addComponent(txtmatKhauMoi1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnshowP, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnshowP1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(97, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(263, 263, 263))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnnhanCode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtmatKhauMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(txtmatKhauMoi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnshowP1))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnluu)
                            .addComponent(btnhuy)))
                    .addComponent(btnshowP))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtcode, txtemail, txtmatKhauMoi, txtmatKhauMoi1});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnshowP, btnshowP1});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnhuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhuyActionPerformed
        if (MsgBox.confirm(this, "Bạn có muốn thoát")) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnhuyActionPerformed

    private void btnnhanCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnhanCodeActionPerformed
        this.xacNhanEmail();
    }//GEN-LAST:event_btnnhanCodeActionPerformed

    private void btnluuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnluuActionPerformed
        if(ktOTP(otp)){
            String matKhauMoi = new String(txtmatKhauMoi.getPassword());
        String matKhauMoi1 = new String(txtmatKhauMoi1.getPassword());

        if ( matKhauMoi.length() == 0
                || matKhauMoi1.length() == 0) {
            MsgBox.alert(this, "Không được để trống thông tin");
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
            this.dispose();
            new JFrmLogin(new javax.swing.JFrame(), true).setVisible(true);
        }
                  
        }
    }//GEN-LAST:event_btnluuActionPerformed

    private void btnshowPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnshowPMouseClicked
        count++;
        if (count % 2 == 0) {
            txtmatKhauMoi.setEchoChar('\u0000');
            btnshowP.setIcon(new ImageIcon("src\\Hinhanh\\showp.png"));
        } else {
            txtmatKhauMoi.setEchoChar('\u2022');
            btnshowP.setIcon(new ImageIcon("src\\Hinhanh\\nshow.png"));
        }
    }//GEN-LAST:event_btnshowPMouseClicked

    private void btnshowP1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnshowP1MouseClicked
        i++;
        if (i % 2 == 0) {
            txtmatKhauMoi1.setEchoChar('\u0000');
            btnshowP1.setIcon(new ImageIcon("src\\Hinhanh\\showp.png"));
        } else {
            txtmatKhauMoi1.setEchoChar('\u2022');
            btnshowP1.setIcon(new ImageIcon("src\\Hinhanh\\nshow.png"));
        }
    }//GEN-LAST:event_btnshowP1MouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrmQuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrmQuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrmQuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrmQuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrmQuenMatKhau dialog = new JFrmQuenMatKhau(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnhuy;
    private javax.swing.JButton btnluu;
    private javax.swing.JButton btnnhanCode;
    private javax.swing.JButton btnshowP;
    private javax.swing.JButton btnshowP1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtcode;
    private javax.swing.JTextField txtemail;
    private javax.swing.JPasswordField txtmatKhauMoi;
    private javax.swing.JPasswordField txtmatKhauMoi1;
    // End of variables declaration//GEN-END:variables
    public void xacNhanEmail() {
        String user = this.txtemail.getText();
        if (user.trim().length() == 0) {
            return;
        }
        try {
            TaiKhoan tk = this.tkdao.selectById(user);
            if (tk==null) {
                MsgBox.alert(this, "Tài khoản không tồn tại");
                this.txtemail.requestFocus();
                return;
            }
            else{
            helper.Auth.user = tk;
            this.sendMail(tk.getEmail());
            
        }
    }
    catch (Exception e){
            MsgBox.alert(this, "Lỗi hệ thống");
        e.printStackTrace();
    }}
   public void sendMail(String toMail) {
        try {
            String otp = new DecimalFormat("000000").format(new Random().nextInt(999999));
            Email email = new Email();
            email.setFrom("hungnpph18034@fpt.edu.vn");
            email.setFromPassword("Phihung13102002@");
            email.setTo(toMail);
            email.setSubject("Forgit Password Function");

            StringBuilder sb = new StringBuilder();

            sb.append("Dear ").append(Auth.user.getEmail()).append("<br>");
            sb.append("Bạn đã sử dụng chức năng quên mật khẩu. <br> ");
            sb.append("Mã xác nhận của bạn là: <b>").append(otp).append("</b>");
            sb.append(" Trân trọng!<br>");
            sb.append("Administrator");

            email.setContent(sb.toString());
            EmailUtils.send(email);
            MsgBox.alert(this, "Email đã được gửi đi, vui lòng kiểm tra lại email");
            this.otp = otp;
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Lỗi Hệ thống");
        }

    }

    public boolean ktOTP(String otp) {
        System.out.println(otp);
        try {
            if (!this.txtcode.getText().equals(otp)) {
                MsgBox.alert(this, "Mã xác nhận không đúng!");
                this.txtcode.requestFocus();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
