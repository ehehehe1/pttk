/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanLiKho.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import quanLiKho.BLL.*;
import quanLiKho.DTO.*;

/**
 *
 * @author PC
 */
public class SanPhamGUI extends javax.swing.JPanel {

    private LoaiSPBLL loaiBLL = new LoaiSPBLL();
    private MauSacBLL mauBLL = new MauSacBLL();
    private SizeBLL sizeBLL = new SizeBLL();
    private PhieuNhapBLL pnBLL = new PhieuNhapBLL();
    private CT_PhieuNhapBLL ctpnBLL = new CT_PhieuNhapBLL();
    private NhaCungCapBLL nccBLL = new NhaCungCapBLL();
    private TaiKhoanBLL tkBLL = new TaiKhoanBLL();
    private SanPhamBLL spBLL = new SanPhamBLL();
    private CT_SanPhamBLL ctspBLL = new CT_SanPhamBLL();
    private DefaultTableModel model_sp, model_ctsp;
    private String tenDN;
    private static int soSP;
    
    public SanPhamGUI(String tenDN) {
        cb_sizeAction cb_sizeAction = new cb_sizeAction();
        cb_loaiAction cb_loaiAction  = new cb_loaiAction();
        cb_mauAction cb_mauAction  = new cb_mauAction();
        capNhatAction capNhatAction = new capNhatAction();
        xoaSPAction xoaSPAction = new xoaSPAction();
        timKiemAction timKiemAction = new timKiemAction();
        this.cb_loaisp.addActionListener(cb_loaiAction);
        this.cb_size.addActionListener(cb_sizeAction);
        this.cb_mau.addActionListener(cb_mauAction);
        this.jb_xoasp.addActionListener(xoaSPAction);
        this.jb_capnhat.addActionListener(capNhatAction);
        this.jb_timkiem.addActionListener(timKiemAction);
        model_sp  = (DefaultTableModel) tb_sp.getModel();
        loadDataIntoTable();
        this.tenDN = tenDN;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp_ctsp = new javax.swing.JPanel();
        lb_tensp = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        lb_masp = new javax.swing.JLabel();
        lb_mau = new javax.swing.JLabel();
        cb_size = new javax.swing.JComboBox<>();
        lb_size = new javax.swing.JLabel();
        lb_sl = new javax.swing.JLabel();
        lb_sl1 = new javax.swing.JLabel();
        cb_mau = new javax.swing.JComboBox<>();
        lb_gia = new javax.swing.JLabel();
        lb_hinhanh = new javax.swing.JLabel();
        jp_timkiem = new javax.swing.JPanel();
        lb_loc = new javax.swing.JLabel();
        tf_timkiem = new javax.swing.JTextField();
        jb_timkiem = new javax.swing.JButton();
        lb_masp1 = new javax.swing.JLabel();
        lb_tensp1 = new javax.swing.JLabel();
        lb_loaisp1 = new javax.swing.JLabel();
        cb_masp = new javax.swing.JComboBox<>();
        cb_loaisp = new javax.swing.JComboBox<>();
        cb_tensp = new javax.swing.JComboBox<>();
        jp_button = new javax.swing.JPanel();
        jb_themsp = new javax.swing.JButton();
        jb_xoasp = new javax.swing.JButton();
        jb_capnhat = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jp_sp = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tb_sp = new javax.swing.JTable();

        jp_ctsp.setBackground(new java.awt.Color(255, 255, 255));

        lb_tensp.setFont(new java.awt.Font("Arial", 1, 40)); // NOI18N
        lb_tensp.setText("Tên sản phẩm");

        jPanel27.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lb_masp.setFont(new java.awt.Font("Arial", 0, 25)); // NOI18N
        lb_masp.setForeground(new java.awt.Color(153, 153, 153));
        lb_masp.setText("Mã sản phẩm");

        lb_mau.setFont(new java.awt.Font("Arial", 0, 25)); // NOI18N
        lb_mau.setText("Màu sắc");

        cb_size.setFont(new java.awt.Font("Arial", 0, 25)); // NOI18N
        cb_size.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lb_size.setFont(new java.awt.Font("Arial", 0, 25)); // NOI18N
        lb_size.setText("Size");

        lb_sl.setFont(new java.awt.Font("Arial", 0, 25)); // NOI18N
        lb_sl.setText("Số lượng:");

        lb_sl1.setFont(new java.awt.Font("Arial", 0, 25)); // NOI18N
        lb_sl1.setText("10");

        cb_mau.setFont(new java.awt.Font("Arial", 0, 25)); // NOI18N
        cb_mau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lb_gia.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        lb_gia.setText("đ100.000");

        lb_hinhanh.setText("jLabel1");

        javax.swing.GroupLayout jp_ctspLayout = new javax.swing.GroupLayout(jp_ctsp);
        jp_ctsp.setLayout(jp_ctspLayout);
        jp_ctspLayout.setHorizontalGroup(
            jp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_ctspLayout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_hinhanh, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addGroup(jp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_ctspLayout.createSequentialGroup()
                        .addGroup(jp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_sl)
                            .addComponent(lb_size)
                            .addComponent(lb_mau))
                        .addGap(34, 34, 34)
                        .addGroup(jp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp_ctspLayout.createSequentialGroup()
                                .addGroup(jp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cb_mau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jp_ctspLayout.createSequentialGroup()
                                .addComponent(lb_sl1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jp_ctspLayout.createSequentialGroup()
                        .addGroup(jp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_gia)
                            .addComponent(lb_masp)
                            .addComponent(lb_tensp))
                        .addGap(80, 80, 80))))
        );
        jp_ctspLayout.setVerticalGroup(
            jp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_ctspLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_hinhanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jp_ctspLayout.createSequentialGroup()
                        .addGroup(jp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp_ctspLayout.createSequentialGroup()
                                .addComponent(lb_tensp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lb_masp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_gia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lb_mau)
                                    .addComponent(cb_mau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_size)
                                    .addGroup(jp_ctspLayout.createSequentialGroup()
                                        .addComponent(cb_size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jp_ctspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lb_sl1)
                                            .addComponent(lb_sl)))))
                            .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 42, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jp_timkiem.setBackground(new java.awt.Color(255, 255, 255));

        lb_loc.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        lb_loc.setText("Lọc");

        jb_timkiem.setText("jButton19");

        lb_masp1.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        lb_masp1.setText("Mã sản phẩm");

        lb_tensp1.setText("Tên sản phẩm");

        lb_loaisp1.setText("Loại sản phẩm");

        cb_masp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_masp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_maspActionPerformed(evt);
            }
        });

        cb_loaisp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cb_tensp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_tensp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_tenspActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_timkiemLayout = new javax.swing.GroupLayout(jp_timkiem);
        jp_timkiem.setLayout(jp_timkiemLayout);
        jp_timkiemLayout.setHorizontalGroup(
            jp_timkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_timkiemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_timkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_timkiemLayout.createSequentialGroup()
                        .addComponent(tf_timkiem)
                        .addGap(18, 18, 18)
                        .addComponent(jb_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_timkiemLayout.createSequentialGroup()
                        .addGroup(jp_timkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cb_masp, 0, 285, Short.MAX_VALUE)
                            .addComponent(cb_loaisp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_loc, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_masp1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_tensp1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_loaisp1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_tensp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jp_timkiemLayout.setVerticalGroup(
            jp_timkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_timkiemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_timkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(lb_loc)
                .addGap(28, 28, 28)
                .addComponent(lb_masp1)
                .addGap(18, 18, 18)
                .addComponent(cb_masp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lb_tensp1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_tensp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_loaisp1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_loaisp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        jp_button.setBackground(new java.awt.Color(255, 255, 255));

        jb_themsp.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        jb_themsp.setText("Thêm sản phẩm");
        jb_themsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_themspActionPerformed(evt);
            }
        });

        jb_xoasp.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        jb_xoasp.setText("Xoá sản phẩm");

        jb_capnhat.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        jb_capnhat.setText("Cập nhật");

        javax.swing.GroupLayout jp_buttonLayout = new javax.swing.GroupLayout(jp_button);
        jp_button.setLayout(jp_buttonLayout);
        jp_buttonLayout.setHorizontalGroup(
            jp_buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_buttonLayout.createSequentialGroup()
                .addGap(1164, 1164, 1164)
                .addComponent(jLabel18)
                .addContainerGap(442, Short.MAX_VALUE))
            .addGroup(jp_buttonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jb_themsp)
                .addGap(90, 90, 90)
                .addComponent(jb_xoasp)
                .addGap(105, 105, 105)
                .addComponent(jb_capnhat)
                .addGap(371, 371, 371))
        );
        jp_buttonLayout.setVerticalGroup(
            jp_buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_buttonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jp_buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_themsp)
                    .addComponent(jb_xoasp)
                    .addComponent(jb_capnhat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18))
        );

        jp_sp.setBackground(new java.awt.Color(255, 255, 255));

        tb_sp.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tb_sp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Loại sản phẩm", "Giá bán"
            }
        ));
        tb_sp.setRowHeight(35);
        jScrollPane13.setViewportView(tb_sp);

        javax.swing.GroupLayout jp_spLayout = new javax.swing.GroupLayout(jp_sp);
        jp_sp.setLayout(jp_spLayout);
        jp_spLayout.setHorizontalGroup(
            jp_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_spLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13)
                .addContainerGap())
        );
        jp_spLayout.setVerticalGroup(
            jp_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_spLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1640, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jp_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jp_ctsp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jp_sp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jp_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 942, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jp_sp, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jp_ctsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jp_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jp_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        jPanel17.setBorder(BorderFactory.createTitledBorder("Chi tiết sản phẩm"));
    }// </editor-fold>//GEN-END:initComponents

    private void jb_themspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_themspActionPerformed
        new ThemSanPhamGUI();
    }//GEN-LAST:event_jb_themspActionPerformed

    private void cb_maspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_maspActionPerformed
        ArrayList<SanPhamDTO> sp = spBLL.getSelectedAll();
        ArrayList<String> list = new ArrayList<>();
        //listDS.add("");    
        for (SanPhamDTO t : sp) {
            list.add(t.getMaSP());
        }
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(list.toArray(new String[0]));
        cb_masp.setModel(model);
    }//GEN-LAST:event_cb_maspActionPerformed

    private void cb_tenspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_tenspActionPerformed
        ArrayList<SanPhamDTO> sp = spBLL.getSelectedAll();
        ArrayList<String> list = new ArrayList<>();
        //listDS.add("");    
        for (SanPhamDTO t : sp) {
            list.add(t.getTenSP());
        }
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(list.toArray(new String[0]));
        cb_masp.setModel(model);
    }//GEN-LAST:event_cb_tenspActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_loaisp;
    private javax.swing.JComboBox<String> cb_masp;
    private javax.swing.JComboBox<String> cb_mau;
    private javax.swing.JComboBox<String> cb_size;
    private javax.swing.JComboBox<String> cb_tensp;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JButton jb_capnhat;
    private javax.swing.JButton jb_themsp;
    private javax.swing.JButton jb_timkiem;
    private javax.swing.JButton jb_xoasp;
    private javax.swing.JPanel jp_button;
    private javax.swing.JPanel jp_ctsp;
    private javax.swing.JPanel jp_sp;
    private javax.swing.JPanel jp_timkiem;
    private javax.swing.JLabel lb_gia;
    private javax.swing.JLabel lb_hinhanh;
    private javax.swing.JLabel lb_loaisp1;
    private javax.swing.JLabel lb_loc;
    private javax.swing.JLabel lb_masp;
    private javax.swing.JLabel lb_masp1;
    private javax.swing.JLabel lb_mau;
    private javax.swing.JLabel lb_size;
    private javax.swing.JLabel lb_sl;
    private javax.swing.JLabel lb_sl1;
    private javax.swing.JLabel lb_tensp;
    private javax.swing.JLabel lb_tensp1;
    private javax.swing.JTable tb_sp;
    private javax.swing.JTextField tf_timkiem;
    // End of variables declaration//GEN-END:variables
    
    private class cb_loaiAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            ArrayList<LoaiSPDTO> loai = loaiBLL.getSelectedAll();
            ArrayList<String> list = new ArrayList<>();
            //listDS.add("");    
            for (LoaiSPDTO t : loai) {
                list.add(t.getTenLoai());
            }
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(list.toArray(new String[0]));
            cb_size.setModel(model);
        }       
    }
    
    private class cb_sizeAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            ArrayList<SizeDTO> size = sizeBLL.getSelectedAll();
            ArrayList<String> list = new ArrayList<>();
            //listDS.add("");    
            for (SizeDTO t : size) {
                list.add(t.getTenSize());
            }
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(list.toArray(new String[0]));
            cb_size.setModel(model);
        }
        
    }
    
    private class cb_mauAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            ArrayList<MauSacDTO> mau = mauBLL.getSelectedAll();
            ArrayList<String> list = new ArrayList<>();
            //listDS.add("");    
            for (MauSacDTO t : mau) {
                list.add(t.getTenMau());
            }
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(list.toArray(new String[0]));
            cb_mau.setModel(model);
        }
        
    }
    
    public void loadDataIntoTable() {
        ArrayList<SanPhamDTO> list = spBLL.getSelectedAll();
        if (!list.isEmpty()) {
            for (SanPhamDTO sp : list) {
                Object[] data = new Object[]{sp.getMaSP(), sp.getTenSP(), sp.getSoLuong()};
                model_sp.addRow(data);
                model_sp.fireTableDataChanged();
            }
        }
    }
    
    private class xoaSPAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            
        }  
    }
    
    private class timKiemAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            
        }  
    }
    
    private class capNhatAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            
        }  
    }
    
}
