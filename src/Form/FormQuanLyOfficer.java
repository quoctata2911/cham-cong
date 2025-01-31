/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Form;
import DAO.QuanLyOfficer;
import Class.Officer;
import Class.ThongKeChamCongOfficer;
import Class.Worker;
import DAO.QuanLyWorker;
import connect.DatabaseConnection;
import java.awt.Desktop;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author vuqua
 */
public class FormQuanLyOfficer extends javax.swing.JFrame {

    /**
     * Creates new form FormQuanLyOfficer
     */
    private String getTenCa(int idCa) {
    switch (idCa) {
        case 1:
            return "Ca Sáng";
        case 2:
            return "Ca Chiều";
        default:
            return "Không xác định";
    }
    }
    private String getTH(int idCa) {
    switch (idCa) {
        case 0:
            return "Không đi làm";
        case 1:
            return "Có đi làm";
        case 2:
            return "Đang làm";
        default:
            return "Không xác định";
    }
    }
    private void loadDataToForm() {
    try {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã Nhân Viên");
        model.addColumn("Tên Nhân Viên");
        model.addColumn("Đơn Vị");
        model.addColumn("Ngày Làm");
        model.addColumn("Checkin");
        model.addColumn("Checkout");
        model.addColumn("Đi muộn");
        model.addColumn("Về sớm");
        model.addColumn("Buổi");
        model.addColumn("Trạng Thái");
        

        // Lấy danh sách Worker từ CSDL
       // Trong một lớp khác, ví dụ WorkerForm
        QuanLyOfficer quanLyOfficer = new QuanLyOfficer();
        List<Officer> officers = quanLyOfficer.getAllOfficerExcel();


        // Thêm dữ liệu từ danh sách Worker vào model
        for (Officer officer : officers) {
            String tenBuoi = getTenCa(officer.getIdGio()); // Lấy tên ca từ ID
            String th = getTH(officer.getStatus()); // Lấy tên ca từ ID
            Object[] row = {
                officer.getMaNhanVien(),
                officer.getTenNhanVien(),
                officer.getDonVi(),
                officer.getNgayLamViec(),
                officer.getCheckIn(),
                officer.getCheckOut(),
                officer.getDiMuon(),
                officer.getVeSom(),
                tenBuoi,
                th                  
            };
            model.addRow(row);
        }

        // Set model cho table
        jTable1.setModel(model);

    }catch(Exception ex) {
        ex.printStackTrace();
        // Xử lý lỗi nếu cần
    }
}
    public FormQuanLyOfficer() {
        initComponents();
        loadDataToForm();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        tendonvi = new javax.swing.JTextField();
        txt_donvi = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setText("Đơn vị:");

        tendonvi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tendonvi.setForeground(new java.awt.Color(204, 0, 0));
        tendonvi.setCaretColor(new java.awt.Color(204, 0, 0));
        tendonvi.setEnabled(false);

        txt_donvi.setText("Nhập đơn vị");
        txt_donvi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_donviActionPerformed(evt);
            }
        });

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Export Excel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Import Excel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Tháng");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Năm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(399, 399, 399))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tendonvi, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jYearChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(84, 84, 84)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_donvi)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tendonvi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(2, 2, 2)
                                            .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addGap(20, 20, 20)
                                    .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_donvi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private static void exportToExcel(JTable table) {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(); // Use XSSFWorkbook for XLSX format
            Sheet sheet = workbook.createSheet("Sheet1");

            // Get the table model
            TableModel model = table.getModel();

            // Create header row
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < model.getColumnCount(); i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(model.getColumnName(i));
            }

            // Create data rows
            for (int r = 0; r < model.getRowCount(); r++) {
                Row row = sheet.createRow(r + 1);
                for (int c = 0; c < model.getColumnCount(); c++) {
                    Cell cell = row.createCell(c);
                    Object value = model.getValueAt(r, c);
                    if (value != null) {
                        if (value instanceof Number) {
                            cell.setCellValue(((Number) value).doubleValue());
                        } else if (value instanceof Boolean) {
                            cell.setCellValue((Boolean) value);
                        } else {
                            cell.setCellValue(value.toString());
                        }
                    }
                }
            }

            // Create a temporary file
            File tempFile = File.createTempFile("exported_data", ".xlsx");

            // Save the workbook to the temporary file
            try (FileOutputStream fileOut = new FileOutputStream(tempFile)) {
                workbook.write(fileOut);
                System.out.println("Data exported successfully!");
            }

            workbook.close();

            // Open the file using the default application associated with .xlsx files
            Desktop.getDesktop().open(tempFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void txt_donviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_donviActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_donviActionPerformed

    private String formatTotalThoiGianLam(long totalSeconds) {
    long hours = totalSeconds / 3600;
    long minutes = (totalSeconds % 3600) / 60;
    long seconds = totalSeconds % 60;

    return String.format("%02d:%02d:%02d", hours, minutes, seconds);
}
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         try {
        int selectedMonth = jMonthChooser1.getMonth() + 1;
        int selectedYear = jYearChooser1.getYear();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã Nhân Viên");
        model.addColumn("Tên Nhân Viên");
        model.addColumn("Đơn Vị");
        model.addColumn("Tháng");
        model.addColumn("Tổng số buổi đi làm");
        model.addColumn("Tổng số thời gian đi muộn");
        model.addColumn("Tổng số thời gian về sớm");

        // Lấy danh sách Worker từ CSDL
       // Trong một lớp khác, ví dụ WorkerForm
        QuanLyOfficer quanLyOfficer = new QuanLyOfficer();
       
        //
       
        List<ThongKeChamCongOfficer> officers = quanLyOfficer.calculateChamCongInfoList(selectedYear, selectedMonth, txt_donvi.getText());
        
        int totalThoiGianDiMuon = 0;
        int totalThoiGianVeSom = 0;
        // Thêm dữ liệu từ danh sách Worker vào model
        for (ThongKeChamCongOfficer officer : officers) {
            
            Object[] row = {
                officer.getMaNhanVien(),
                officer.getHoTen(),
                officer.getDonVi(),
                selectedMonth,
                officer.getTongSoBuoiDiLam(),
                officer.getTongSoGioDiMuon(),
                officer.getTongSoGioVeSom()
            };
            model.addRow(row);   
          

        }
       tendonvi.setText(txt_donvi.getText());
        jTable1.setModel(model);

    }catch(Exception ex) {
        ex.printStackTrace();
        // Xử lý lỗi nếu cần
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        exportToExcel(jTable1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            // Người dùng đã chọn một tệp
            File selectedFile = fileChooser.getSelectedFile();

            // Gọi hàm import với đối tượng File đã chọn
            importWorkersFromExcel(selectedFile);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    public void importWorkersFromExcel(File excelFile) {
    try (Connection connection = DatabaseConnection.connect()) {
        FileInputStream fis = new FileInputStream(excelFile);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        // Assuming the first sheet is the one you want to read
        int sheetIndex = 0;
        org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(sheetIndex);

        // Loop through rows
        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                // Skip the header row
                continue;
            }

            Officer worker = createOfficerFromRow(row);
            System.out.println(row);

            String query = "INSERT INTO Officer (manhanvien, tennhanvien, donvi, ngaylamviec, checkin, checkout, dimuon, vesom, idgio, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, worker.getMaNhanVien());
                preparedStatement.setString(2, worker.getTenNhanVien());
                preparedStatement.setString(3, worker.getDonVi());
                preparedStatement.setDate(4, worker.getNgayLamViec());
                preparedStatement.setTime(5, worker.getCheckIn());
                preparedStatement.setTime(6, worker.getCheckOut());
                preparedStatement.setTime(7, worker.getDiMuon());
                preparedStatement.setTime(8, worker.getVeSom());
                preparedStatement.setInt(9, worker.getIdGio());
                preparedStatement.setInt(10, worker.getStatus());
                preparedStatement.executeUpdate();
            }
        }

        workbook.close();
        fis.close();

        // Hiển thị popup import thành công
        JOptionPane.showMessageDialog(null, "Import thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

        loadDataToForm();
    } catch (Exception e) {
        e.printStackTrace();
        // Handle exceptions if necessary
    }
}
    private Officer createOfficerFromRow(Row row) {
        
        Officer worker = new Officer();
        worker.setMaNhanVien(getStringCellValue(row.getCell(0)));
        worker.setTenNhanVien(getStringCellValue(row.getCell(1)));
        worker.setDonVi(getStringCellValue(row.getCell(2)));
        worker.setNgayLamViec(getDateCellValue(row.getCell(3)));
        worker.setCheckIn(getTimeCellValue(row.getCell(4)));
        worker.setCheckOut(getTimeCellValue(row.getCell(5)));
        worker.setDiMuon(getTimeCellValue(row.getCell(6)));
        worker.setVeSom(getTimeCellValue(row.getCell(7)));
        worker.setIdGio(getIntCellValue(row.getCell(8)));
        worker.setStatus(getIntCellValue(row.getCell(9)));
        return worker;
    }
    
        private String getStringCellValue(Cell cell) {
        return cell == null ? null : cell.toString();
    }

    

    private java.sql.Date getDateCellValue(Cell cell) {
    if (cell == null) {
        return null;
    }
    try {
        // Giá trị số ngày trong Excel
        double excelDateValue = cell.getNumericCellValue();
        
        // Chuyển đổi sang kiểu Date
        java.util.Date javaDate = org.apache.poi.ss.usermodel.DateUtil.getJavaDate(excelDateValue);
        
        // Chuyển đổi sang java.sql.Date
        return new java.sql.Date(javaDate.getTime());
    } catch (IllegalArgumentException e) {
        // Xử lý nếu giá trị không hợp lệ
        return null;
    }
}


private java.sql.Time getTimeCellValue(Cell cell) {
    if (cell == null) {
        return null;
    }
    try {
        // Giá trị số giờ trong Excel
        double excelTimeValue = cell.getNumericCellValue();
        
        // Chuyển đổi sang kiểu Date
        java.util.Date javaDateTime = org.apache.poi.ss.usermodel.DateUtil.getJavaDate(excelTimeValue);
        
        // Chuyển đổi sang java.sql.Timestamp
        java.sql.Timestamp timestamp = new java.sql.Timestamp(javaDateTime.getTime());
        
        // Lấy giờ từ Timestamp
        return new java.sql.Time(timestamp.getTime());
    } catch (IllegalArgumentException e) {
        // Xử lý nếu giá trị không hợp lệ
        e.printStackTrace();
        return null;
    }
}





    private int getIntCellValue(Cell cell) {
        return cell == null ? 0 : (int) cell.getNumericCellValue();
    }
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
            java.util.logging.Logger.getLogger(FormQuanLyOfficer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormQuanLyOfficer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormQuanLyOfficer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormQuanLyOfficer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormQuanLyOfficer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private javax.swing.JTextField tendonvi;
    private javax.swing.JTextField txt_donvi;
    // End of variables declaration//GEN-END:variables
}
