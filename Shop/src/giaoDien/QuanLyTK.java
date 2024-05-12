package giaoDien;

import helper.MsgBox;
import helper.XJdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class QuanLyTK extends javax.swing.JPanel {

    Connection cn;
    DefaultTableModel model = new DefaultTableModel();
    int index;
    TableRowSorter<DefaultTableModel> ts;

    public QuanLyTK() {
        initComponents();
        model = (DefaultTableModel) tblDSNV.getModel();
        loadDataToTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        paneldanhsachNV = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSNV = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        panelThongtin = new javax.swing.JPanel();
        btnThemTK = new javax.swing.JButton();
        btnLammoi = new javax.swing.JButton();
        lblhoten = new javax.swing.JLabel();
        lblsdt = new javax.swing.JLabel();
        lblemail = new javax.swing.JLabel();
        lblcccd = new javax.swing.JLabel();
        lbldc = new javax.swing.JLabel();
        txthoten = new javax.swing.JTextField();
        txtCCCD = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtDiachi = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        btntrangthai = new javax.swing.JButton();
        cbotrangthai = new javax.swing.JComboBox<>();
        lbltrangthai = new javax.swing.JLabel();
        lblvaitro = new javax.swing.JLabel();
        cbovaitro = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        paneldanhsachNV.setBackground(new java.awt.Color(204, 255, 255));
        paneldanhsachNV.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh Sách Nhân Viên "));

        tblDSNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhân Viên ", "Họ Tên ", "SĐT", "CCCD", "Email", "Địa chỉ", "Trạng thái", "Vai trò"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSNV.setRowHeight(22);
        tblDSNV.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblDSNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSNVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDSNV);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Tìm kiếm");

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout paneldanhsachNVLayout = new javax.swing.GroupLayout(paneldanhsachNV);
        paneldanhsachNV.setLayout(paneldanhsachNVLayout);
        paneldanhsachNVLayout.setHorizontalGroup(
            paneldanhsachNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneldanhsachNVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(paneldanhsachNVLayout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 156, Short.MAX_VALUE))
        );
        paneldanhsachNVLayout.setVerticalGroup(
            paneldanhsachNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneldanhsachNVLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(paneldanhsachNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE))
        );

        panelThongtin.setBackground(new java.awt.Color(204, 255, 255));
        panelThongtin.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin cá nhân "));

        btnThemTK.setBackground(new java.awt.Color(102, 204, 255));
        btnThemTK.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThemTK.setText("Thêm Tài Khoản ");
        btnThemTK.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnThemTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemTKActionPerformed(evt);
            }
        });

        btnLammoi.setBackground(new java.awt.Color(102, 204, 255));
        btnLammoi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLammoi.setText("Làm Mới");
        btnLammoi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnLammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLammoiActionPerformed(evt);
            }
        });

        lblhoten.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblhoten.setText("Họ tên ");

        lblsdt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblsdt.setText("SDT");

        lblemail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblemail.setText("Email ");

        lblcccd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblcccd.setText("CCCD");

        lbldc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbldc.setText("Địa chỉ ");

        btntrangthai.setBackground(new java.awt.Color(102, 204, 255));
        btntrangthai.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btntrangthai.setText("Thay Đổi Trạng Thái ");
        btntrangthai.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btntrangthai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntrangthaiActionPerformed(evt);
            }
        });

        cbotrangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang làm", "Đã nghỉ", "Chuẩn bị đi làm" }));

        lbltrangthai.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbltrangthai.setText("Trạng Thái ");

        lblvaitro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblvaitro.setText("Vai Trò");

        cbovaitro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMIN", "Nhân Viên" }));

        javax.swing.GroupLayout panelThongtinLayout = new javax.swing.GroupLayout(panelThongtin);
        panelThongtin.setLayout(panelThongtinLayout);
        panelThongtinLayout.setHorizontalGroup(
            panelThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThongtinLayout.createSequentialGroup()
                .addGroup(panelThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelThongtinLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(panelThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblsdt)
                            .addComponent(lblcccd)
                            .addComponent(lblhoten)
                            .addComponent(lblemail)
                            .addComponent(lbldc)
                            .addComponent(lbltrangthai)
                            .addComponent(lblvaitro))
                        .addGap(39, 39, 39)
                        .addGroup(panelThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txthoten, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbotrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbovaitro, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelThongtinLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnThemTK, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(btntrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(btnLammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        panelThongtinLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbotrangthai, cbovaitro, txtCCCD, txtDiachi, txtEmail, txtSDT, txthoten});

        panelThongtinLayout.setVerticalGroup(
            panelThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThongtinLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(panelThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txthoten, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblhoten))
                .addGap(33, 33, 33)
                .addGroup(panelThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblsdt))
                .addGap(33, 33, 33)
                .addGroup(panelThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcccd))
                .addGap(33, 33, 33)
                .addGroup(panelThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblemail))
                .addGap(33, 33, 33)
                .addGroup(panelThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbldc))
                .addGap(33, 33, 33)
                .addGroup(panelThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbotrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbltrangthai))
                .addGap(33, 33, 33)
                .addGroup(panelThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbovaitro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblvaitro))
                .addGap(44, 44, 44)
                .addGroup(panelThongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btntrangthai)
                    .addComponent(btnThemTK, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        panelThongtinLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lbltrangthai, lblvaitro});

        panelThongtinLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbotrangthai, cbovaitro, txtCCCD, txtDiachi, txtEmail, txtSDT, txthoten});

        panelThongtinLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnLammoi, btnThemTK, btntrangthai});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paneldanhsachNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelThongtin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paneldanhsachNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelThongtin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLammoiActionPerformed
        try {
            txthoten.setText("");
            txtSDT.setText("");
            txtCCCD.setText("");
            txtEmail.setText("");
            txtDiachi.setText("");
            cbotrangthai.setSelectedItem(0);
            cbovaitro.setSelectedItem(0);
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi Làm mới");
        }
    }//GEN-LAST:event_btnLammoiActionPerformed

    private void btnThemTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemTKActionPerformed
        try {
            if (checkRong()) {
                return;
            }
            if (checkSDT()) {
                return;
            }
            if (checkEmail()) {
                return;
            }
            if (checkTrungEmail()) {
                return;
            }
            insert();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi Thêm Tài Khoản!");
        }
    }//GEN-LAST:event_btnThemTKActionPerformed

    private void tblDSNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSNVMouseClicked
        index = tblDSNV.getSelectedRow();
        showDetail();
    }//GEN-LAST:event_tblDSNVMouseClicked

    private void btntrangthaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntrangthaiActionPerformed
        try {
            updateTrangThaiND();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btntrangthaiActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        String tk = txtTimKiem.getText();
        filterTable(tk);
    }//GEN-LAST:event_txtTimKiemKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLammoi;
    private javax.swing.JButton btnThemTK;
    private javax.swing.JButton btntrangthai;
    private javax.swing.JComboBox<String> cbotrangthai;
    private javax.swing.JComboBox<String> cbovaitro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblcccd;
    private javax.swing.JLabel lbldc;
    private javax.swing.JLabel lblemail;
    private javax.swing.JLabel lblhoten;
    private javax.swing.JLabel lblsdt;
    private javax.swing.JLabel lbltrangthai;
    private javax.swing.JLabel lblvaitro;
    private javax.swing.JPanel panelThongtin;
    private javax.swing.JPanel paneldanhsachNV;
    private javax.swing.JTable tblDSNV;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtDiachi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txthoten;
    // End of variables declaration//GEN-END:variables

    private boolean checkRong() {
        try {
            if (txthoten.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập vào Họ tên!");
                txthoten.requestFocus();
                return true;
            }
            if (txtSDT.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập vào SDT!");
                txtSDT.requestFocus();
                return true;
            }
            if (txtCCCD.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập vào CCCD!");
                txtCCCD.requestFocus();
                return true;
            }
            if (txtEmail.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập vào Email!");
                txtEmail.requestFocus();
                return true;
            }
            if (txtDiachi.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập vào Địa chỉ!");
                txtDiachi.requestFocus();
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi chekRong");
        }
        return false;
    }

    private boolean checkSDT() {
        try {
            if (!txtSDT.getText().matches("0\\d{9}")) {
                JOptionPane.showMessageDialog(this, "Mời nhập SDT có 10 chữ số và bắt đầu bằng số 0");
                txtSDT.requestFocus();
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi checkSDT");
        }
        return false;
    }

    private boolean checkEmail() {
        try {
            String p_email = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$";
            if (txtEmail.getText().matches(p_email) == false) {
                JOptionPane.showMessageDialog(this, "Email bạn nhập không đúng định dạng!");
                txtEmail.requestFocus();
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi checkEmail!");
        }
        return false;
    }

    private boolean checkTrungEmail() {
        try {
            String sql = "Select Email From TaiKhoan Where Email = ?";
            PreparedStatement ps = XJdbc.getStmt(sql, txtEmail.getText());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Email đã tồn tại!");
                return true;
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    private void insert() {
        try {
            String sql1 = "insert into NguoiDung(HoTenNhanVien, SDT, DiaChi, CCCD, TrangThai)\n"
                    + "values(?, ?, ?, ?, ?)";
            PreparedStatement pstm1 = XJdbc.getStmt(sql1, txthoten.getText(), txtSDT.getText(),
                    txtDiachi.getText(), txtCCCD.getText(), cbotrangthai.getSelectedIndex());
            pstm1.executeUpdate();
            String sql2 = "select top 1 IDNguoiDung from NguoiDung order by IDNguoiDung desc ";
            PreparedStatement pstm2 = XJdbc.getStmt(sql2);
            ResultSet rs = pstm2.executeQuery();
            int idND = 0;
            while (rs.next()) {
                idND = rs.getInt(1);
            }
            String sql3 = "insert into TaiKhoan(Email, IDNguoiDung, MatKhau, IDVaiTro, TrangThai)\n"
                    + "values(?, ?, ?, ?, ?)";
            PreparedStatement pstm3 = XJdbc.getStmt(sql3, txtEmail.getText(), idND, "1234",
                    cbovaitro.getSelectedIndex(), cbotrangthai.getSelectedIndex());
            pstm3.executeUpdate();
            loadDataToTable();
            MsgBox.alert(this, "Thêm tài khoản thành công");
            if (model.getRowCount() > 0) {
                index = model.getRowCount() - 1;
                showDetail();
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi thêm tài khoản");
            e.printStackTrace();
        }

    }

    private void loadDataToTable() {
        try {
            model.setRowCount(0);
            String sql = "select NguoiDung.IDNguoiDung, HoTenNhanVien, SDT, CCCD, Email, DiaChi, TaiKhoan.TrangThai, VaiTro.TenVaiTro from NguoiDung \n"
                    + "inner join TaiKhoan on TaiKhoan.IDNguoiDung = NguoiDung.IDNguoiDung\n"
                    + "inner join VaiTro on TaiKhoan.IDVaiTro = VaiTro.IDVaiTro";
            PreparedStatement pstm = XJdbc.getStmt(sql);
            ResultSet rs = pstm.executeQuery();
            Vector nD = null;
            while (rs.next()) {
                String tt;
                nD = new Vector();
                nD.add(rs.getString("IDNguoiDung"));
                nD.add(rs.getString("HoTenNhanVien"));
                nD.add(rs.getString("SDT"));
                nD.add(rs.getString("CCCD"));
                nD.add(rs.getString("Email"));
                nD.add(rs.getString("DiaChi"));
                if (rs.getInt("TrangThai") == 0) {
                    tt = "Đang làm";
                } else if (rs.getInt("TrangThai") == 1) {
                    tt = "Đã nghỉ";
                } else {
                    tt = "Chuẩn bị đi làm";
                }
                nD.add(tt);
                nD.add(rs.getString("TenVaiTro"));

                model.addRow(nD);
            }
            tblDSNV.setModel(model);
            rs.close();
            pstm.close();
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi loadDataToTable");
        }

    }

    private void showDetail() {
        try {
            txthoten.setText(model.getValueAt(index, 1).toString());
            txtSDT.setText(model.getValueAt(index, 2).toString());
            txtCCCD.setText(model.getValueAt(index, 3).toString());
            txtEmail.setText(model.getValueAt(index, 4).toString());
            txtDiachi.setText(model.getValueAt(index, 5).toString());
            cbotrangthai.setSelectedItem(tblDSNV.getValueAt(index, 6).toString());
            cbovaitro.setSelectedItem(tblDSNV.getValueAt(index, 7).toString());
        } catch (Exception e) {
        }
    }

    private void updateTrangThaiND() {
        try {
            String sql = "update NguoiDung set TrangThai = ? where CCCD = ?";
            String sql2 = "update TaiKhoan set TrangThai = ? where Email = ?";
            PreparedStatement pstm = XJdbc.getStmt(sql);
            PreparedStatement pstm2 = XJdbc.getStmt(sql2);
            pstm.setInt(1, cbotrangthai.getSelectedIndex());
            pstm.setString(2, txtCCCD.getText().trim());
            pstm2.setInt(1, cbotrangthai.getSelectedIndex());
            pstm2.setString(2, txtEmail.getText().trim());
            pstm.executeUpdate();
            pstm2.executeUpdate();
            pstm.close();
            pstm2.close();
            loadDataToTable();
            MsgBox.alert(this, "Thay đổi trạng thái thành công!");
            if (model.getRowCount() > 0) {
                index = tblDSNV.getSelectedRow();
                showDetail();
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi updateTrangThaiND");
            e.printStackTrace();
        }
    }

    private void filterTable(String tk) {
        ts = new TableRowSorter<>(model);
        tblDSNV.setRowSorter(ts);
        if (tk.trim().length() == 0) {
            ts.setRowFilter(null);
        } else {
            ts.setRowFilter(RowFilter.regexFilter("(?i)" + tk));
        }
    }
}
