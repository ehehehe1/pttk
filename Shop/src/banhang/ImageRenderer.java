/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banhang;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ImageRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (value instanceof ImageIcon) {
            ImageIcon icon = (ImageIcon) value; 
            label.setIcon(icon);
            label.setText(null); // Xóa văn bản để chỉ hiển thị hình ảnh
            label.setHorizontalAlignment(JLabel.CENTER); // Căn giữa hình ảnh trong ô
            label.setVerticalAlignment(JLabel.CENTER);
        }
        return label;
    }      
}