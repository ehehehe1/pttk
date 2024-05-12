package helper;

import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author duyplus
 */
public class XHelper {

    /*
     * Thêm dấy phẩy sau 3 số
     */
    public static String commafy(String num) {
        String regex = "(\\d)(?=(\\d{3})+$)";
        String[] split = num.split("\\.");
        if (split.length == 2) {
            return split[0].replaceAll(regex, "$1,") + "." + split[1];
        } else {
            return num.replaceAll(regex, "$1,");
        }
    }

    /*
     * Xuất jtable sang excel
     */
    public static void writeToExcel(JTable tbldanhsach,  String Doanhthu) {
        XSSFWorkbook wb = null;
        FileOutputStream fos = null;
        try {
            wb = new XSSFWorkbook();
            XSSFSheet sheet = wb.createSheet(Doanhthu);
          

            JFileChooser fc = new JFileChooser("D:\\");
            fc.setDialogTitle("Save as...");
            FileNameExtensionFilter fnef = new FileNameExtensionFilter("Choose Files", "xls");
            fc.setFileFilter(fnef);
            int chooser = fc.showSaveDialog(null);
            if (chooser == JFileChooser.APPROVE_OPTION) {
                TableModel tm = tbldanhsach.getModel();
                TableColumnModel tcm = tbldanhsach.getTableHeader().getColumnModel();
               
                XSSFRow rowtitle = sheet.createRow((short) 0);
              
                for (int i = 0; i < tcm.getColumnCount(); i++) {
                    // Set font header
                    XSSFFont font = wb.createFont();
                    font.setFontHeightInPoints((short) 12);
                    font.setColor(IndexedColors.RED.getIndex());
                    font.setBold(true);
                    // Set style header
                    XSSFCellStyle cs = wb.createCellStyle();
                    cs.setAlignment(HorizontalAlignment.CENTER);
                    cs.setVerticalAlignment(VerticalAlignment.CENTER);
                    cs.setFont(font);
                    // Create header cell
                    XSSFCell cell = rowtitle.createCell((short) i);
                    cell.setCellValue(tcm.getColumn(i).getHeaderValue().toString());
                    cell.setCellStyle(cs);
                 
                }
                for (int i = 0; i < tm.getRowCount(); i++) {
                    XSSFFont font1 = wb.createFont();
                    // Set font body
                    font1.setFontHeightInPoints((short) 10);
                    // Set style
                    XSSFCellStyle cs1 = wb.createCellStyle();
                    cs1.setFont(font1);
                    XSSFRow row = sheet.createRow((short) i + 1);
                    for (int j = 0; j < tm.getColumnCount(); j++) {
                        // Create body cell
                        XSSFCell cell = row.createCell((short) j);
                        cell.setCellValue(Objects.toString(tm.getValueAt(i, j), ""));
                        cell.setCellStyle(cs1);
                        // Set fit column
                        for (int k = 0; k < row.getLastCellNum(); k++) {
                            wb.getSheetAt(0).autoSizeColumn(k);
                        }
                    }
//                    XSSFRow row1 = sheet1.createRow((short) i + 1);
//                    for (int j = 0; j < tm1.getColumnCount(); j++) {
//                        // Create body cell
//                        XSSFCell cell1 = row1.createCell((short) j);
//                        cell1.setCellValue(Objects.toString(tm1.getValueAt(i, j), ""));
//                        cell1.setCellStyle(cs1);
//                        // Set fit column
//                        for (int k = 0; k < row1.getLastCellNum(); k++) {
//                            wb.getSheetAt(0).autoSizeColumn(k);
//                        }
//                    }
//                    XSSFRow row2 = sheet2.createRow((short) i + 1);
//                    for (int j = 0; j < tm2.getColumnCount(); j++) {
//                        // Create body cell
//                        XSSFCell cell2 = row2.createCell((short) j);
//                        cell2.setCellValue(Objects.toString(tm2.getValueAt(i, j), ""));
//                        cell2.setCellStyle(cs1);
//                        // Set fit column
//                        for (int k = 0; k < row2.getLastCellNum(); k++) {
//                            wb.getSheetAt(0).autoSizeColumn(k);
//                        }
//                    }
                }
                fos = new FileOutputStream(fc.getSelectedFile() + ".xlsx");
                MsgBox.alert(null, "Xuất dữ liệu thành công!");
                Desktop.getDesktop().open(new File(fc.getSelectedFile() + ".xlsx"));
                wb.write(fos);
                fos.close();
            }
        } catch (HeadlessException | IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (wb != null) {
                    wb.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
