/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeTableUI;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Isuru
 */
public class EditTimeTable extends javax.swing.JFrame {

    /**
     * Creates new form EditTimeTable
     */
    public String fileLocation = null;
    
    public EditTimeTable() {
        initComponents();
        
        jComboBoxSearchBy.setBackground(new Color(240, 240, 240, 50));
        
        //Setting MultiLineTableCellRenderer for each column
        jTableETT.getColumnModel().getColumn(0).setCellRenderer(new MultiLineTableCellRenderer());
        jTableETT.getColumnModel().getColumn(1).setCellRenderer(new MultiLineTableCellRenderer());
        jTableETT.getColumnModel().getColumn(2).setCellRenderer(new MultiLineTableCellRenderer());
        jTableETT.getColumnModel().getColumn(3).setCellRenderer(new MultiLineTableCellRenderer());
        jTableETT.getColumnModel().getColumn(4).setCellRenderer(new MultiLineTableCellRenderer());
        jTableETT.getColumnModel().getColumn(5).setCellRenderer(new MultiLineTableCellRenderer());
        
        //Setting MultiLineTableCellEditor for each column
        jTableETT.getColumnModel().getColumn(0).setCellEditor(new MultilineTableCellEditor());
        jTableETT.getColumnModel().getColumn(1).setCellEditor(new MultilineTableCellEditor());
        jTableETT.getColumnModel().getColumn(2).setCellEditor(new MultilineTableCellEditor());
        jTableETT.getColumnModel().getColumn(3).setCellEditor(new MultilineTableCellEditor());
        jTableETT.getColumnModel().getColumn(4).setCellEditor(new MultilineTableCellEditor());
        jTableETT.getColumnModel().getColumn(5).setCellEditor(new MultilineTableCellEditor());
        
        jTableETT.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        jTableETT.setRowSelectionAllowed(false);
        jTableETT.setColumnSelectionAllowed(false);
        jTableETT.setCellSelectionEnabled(true);
        jTableETT.setRowHeight(90);
        
        //Setting the table to JScrollPane
        jScrollPaneETT.setViewportView(jTableETT);
        
        AutoCompleteDecorator.decorate(jComboBoxSearch);
        populateJComboBoxSearch();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneETT = new javax.swing.JScrollPane();
        jTableETT = new javax.swing.JTable();
        jLabelClear = new javax.swing.JLabel();
        jLabelViewTimeTable = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabelEditTimeTable = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jComboBoxSearchBy = new javax.swing.JComboBox<>();
        jComboBoxSearch = new javax.swing.JComboBox<>();
        jLabelSearchIcon = new javax.swing.JLabel();
        jLabelDelete = new javax.swing.JLabel();
        jLabelUpdate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableETT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTableETT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Time Slot", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableETT.setToolTipText("Double Click on a Cell to Edit");
        jTableETT.setSelectionBackground(new java.awt.Color(0, 204, 204));
        jScrollPaneETT.setViewportView(jTableETT);

        getContentPane().add(jScrollPaneETT, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 880, 370));

        jLabelClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ClearTimeTable.png"))); // NOI18N
        jLabelClear.setToolTipText("Click to Clear All Table Contents");
        jLabelClear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelClearMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 620, -1, -1));

        jLabelViewTimeTable.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabelViewTimeTable.setForeground(new java.awt.Color(62, 70, 205));
        jLabelViewTimeTable.setText("VIEW TIME TABLE");
        jLabelViewTimeTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelViewTimeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ViewTimeTableClicked(evt);
            }
        });
        getContentPane().add(jLabelViewTimeTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 184, 114));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelEditTimeTable.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabelEditTimeTable.setForeground(new java.awt.Color(62, 70, 205));
        jLabelEditTimeTable.setText("EDIT TIME TABLE");
        jLabelEditTimeTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(jLabelEditTimeTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home_50px.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back_to_50px.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 10, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 1260, 80));

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxSearchBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Search by Lecturer", "Search by Batch", "Search by Lecture Hall" }));
        jComboBoxSearchBy.setToolTipText("Type of Timetable to be Searched");
        jComboBoxSearchBy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBoxSearchBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSearchByActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBoxSearchBy, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 240, 30));

        jComboBoxSearch.setToolTipText("Select Timetable ID");
        jPanel3.add(jComboBoxSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 40, 260, 30));

        jLabelSearchIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button (2).png"))); // NOI18N
        jLabelSearchIcon.setToolTipText("Click to Search Timetable");
        jLabelSearchIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSearchIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSearchIconMouseClicked(evt);
            }
        });
        jPanel3.add(jLabelSearchIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 40, -1, -1));

        jLabelDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delete.png"))); // NOI18N
        jLabelDelete.setToolTipText("Click to Delete Timetable");
        jLabelDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDeleteMouseClicked(evt);
            }
        });
        jPanel3.add(jLabelDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 500, -1, -1));

        jLabelUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Update.png"))); // NOI18N
        jLabelUpdate.setToolTipText("Click to Update Timetable");
        jLabelUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelUpdateMouseClicked(evt);
            }
        });
        jPanel3.add(jLabelUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 500, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 1260, 570));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public void clearTable()
    {
        String[] cols = {"Time Slots","Monday","Tuesday","Wednesday", "Thursday", "Friday"};
        String[][] data = { 
                            {"", "", "", "", "", ""},
                            {"", "", "", "", "", ""},
                            {"", "", "", "", "", ""},
                            {"", "", "", "", "", ""},
                            {"", "", "", "", "", ""},
                          };
        
        model = (DefaultTableModel) jTableETT.getModel();
        model.setDataVector(data, cols);
        
        jTableETT.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        
        //Setting MultiLineTableCellRenderer for each column
        jTableETT.getColumnModel().getColumn(0).setCellRenderer(new MultiLineTableCellRenderer());
        jTableETT.getColumnModel().getColumn(1).setCellRenderer(new MultiLineTableCellRenderer());
        jTableETT.getColumnModel().getColumn(2).setCellRenderer(new MultiLineTableCellRenderer());
        jTableETT.getColumnModel().getColumn(3).setCellRenderer(new MultiLineTableCellRenderer());
        jTableETT.getColumnModel().getColumn(4).setCellRenderer(new MultiLineTableCellRenderer());
        jTableETT.getColumnModel().getColumn(5).setCellRenderer(new MultiLineTableCellRenderer());
        
        //Setting MultiLineTableCellEditor for each column
        jTableETT.getColumnModel().getColumn(0).setCellEditor(new MultilineTableCellEditor());
        jTableETT.getColumnModel().getColumn(1).setCellEditor(new MultilineTableCellEditor());
        jTableETT.getColumnModel().getColumn(2).setCellEditor(new MultilineTableCellEditor());
        jTableETT.getColumnModel().getColumn(3).setCellEditor(new MultilineTableCellEditor());
        jTableETT.getColumnModel().getColumn(4).setCellEditor(new MultilineTableCellEditor());
        jTableETT.getColumnModel().getColumn(5).setCellEditor(new MultilineTableCellEditor());
                   
        //Setting row height
        jTableETT.setRowHeight(100);
        //Setting the table to JScrollPane
        jScrollPaneETT.setViewportView(jTableETT);
    }
  
    private void ViewTimeTableClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewTimeTableClicked
        ViewTimeTable viewTimeTable = new ViewTimeTable();
        viewTimeTable.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ViewTimeTableClicked

    private void jLabelUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelUpdateMouseClicked
        if(jComboBoxSearch.getSelectedItem().toString().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter a timetable id to the search field: Lecturer ID/Batch ID/Hall ID", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            exportDataToExcel(fileLocation);
        }
    }//GEN-LAST:event_jLabelUpdateMouseClicked

    private void jLabelSearchIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSearchIconMouseClicked
        try {
             Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Hello");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegetimetable?" + "user=root&password=root");
            
            if(jComboBoxSearch.getSelectedItem().toString().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter a timetable id to the search field: Lecturer ID/Batch ID/Hall ID", "Error", JOptionPane.WARNING_MESSAGE);
            }
            else{
                PreparedStatement statement = null;
                ResultSet resultSet = null;
                String query = null;
                
                String searchBy = jComboBoxSearchBy.getSelectedItem().toString();
                String searchID = jComboBoxSearch.getSelectedItem().toString();   
                
                if(null != searchBy)
                switch (searchBy) {
                    case "Search by Lecturer":
                        query = "SELECT TABLE_LOCATION FROM TIMETABLES WHERE LECTURER_ID = '" + searchID + "'";
                        break;
                    case "Search by Lecture Hall":
                        query = "SELECT TABLE_LOCATION FROM TIMETABLES WHERE HALL_ID = '" + searchID + "'";
                        break;
                    case "Search by Batch":
                        query = "SELECT TABLE_LOCATION FROM TIMETABLES WHERE BATCH_ID = '" + searchID + "'";
                        break;
                    default:
                        break;
                }
                
                statement = conn.prepareStatement(query);
                resultSet = statement.executeQuery(); 
                
                if(resultSet.next())
                {
                    fileLocation = resultSet.getString("TABLE_LOCATION");
                    importDataFromExcel(fileLocation);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "No record found");               
                }                   
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);       
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jLabelSearchIconMouseClicked

    private void jLabelDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteMouseClicked
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Hello");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegetimetable?" + "user=root&password=root");
            
            if(jComboBoxSearch.getSelectedItem().toString().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter a timetable id to the search field: Lecturer ID/Batch ID/Hall ID", "Error", JOptionPane.WARNING_MESSAGE);
            }
            else{
                int confirmation = JOptionPane.showConfirmDialog(null, "Do you wish to continue?", "Delete Time Table", JOptionPane.YES_NO_OPTION);
                if(confirmation == 0){
                    PreparedStatement statement = null;
                    ResultSet resultSet = null;
                    String query = null;

                    String searchBy = jComboBoxSearchBy.getSelectedItem().toString();
                    String searchID = jComboBoxSearch.getSelectedItem().toString();

                    if(searchBy != null)
                    switch (searchBy) {
                        case "Search by Lecturer":
                            query = "DELETE FROM TIMETABLES WHERE LECTURER_ID = '" + searchID + "'";
                            break;
                        case "Search by Lecture Hall":
                            query = "DELETE FROM TIMETABLES WHERE HALL_ID = '" + searchID + "'";
                            break;
                        case "Search by Batch":
                            query = "DELETE FROM TIMETABLES WHERE BATCH_ID = '" + searchID + "'";
                            break;
                        default:
                            break;
                    }

                    statement = conn.prepareStatement(query);
                    statement.executeUpdate();
                    
                    try  
                    {         
                        File f= new File(fileLocation + ".xlsx"); 
                        if(f.delete())
                        {
                           JOptionPane.showMessageDialog(null, "Successfully Deleted.");
                           populateJComboBoxSearch();
                           clearTable();
                        }  
                        else  
                        {  
                            JOptionPane.showMessageDialog(null, "Failed to Delete", "Error", JOptionPane.ERROR_MESSAGE);  
                        }  
                    }  
                    catch(Exception e)  
                    {  
                        e.printStackTrace();  
                    }                                
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);       
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jLabelDeleteMouseClicked

    private void jLabelClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelClearMouseClicked
        int confirmation = JOptionPane.showConfirmDialog(null, "Do you wish to continue?", "Clear Time Table", JOptionPane.YES_NO_OPTION);
        if(confirmation == 0)
            clearTable(); 
    }//GEN-LAST:event_jLabelClearMouseClicked

    private void jComboBoxSearchByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSearchByActionPerformed
        populateJComboBoxSearch();
    }//GEN-LAST:event_jComboBoxSearchByActionPerformed
   
    private void populateJComboBoxSearch() {
        try {
             Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Hello");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegetimetable?" + "user=root&password=root");
            
            PreparedStatement statement = null;
            ResultSet resultSet = null;
            String query = null;

            String searchBy = jComboBoxSearchBy.getSelectedItem().toString();

            if(searchBy != null){
                switch (searchBy) {
                    case "Search by Lecturer":
                        query = "SELECT LECTURER_ID FROM TIMETABLES WHERE LECTURER_ID IS NOT NULL";
                        break;
                    case "Search by Lecture Hall":
                        query = "SELECT HALL_ID FROM TIMETABLES WHERE HALL_ID IS NOT NULL";
                        break;
                    case "Search by Batch":
                        query = "SELECT BATCH_ID FROM TIMETABLES WHERE BATCH_ID IS NOT NULL";
                        break;
                    default:
                        break;
                }
            }

            statement = conn.prepareStatement(query);
            resultSet = statement.executeQuery(); 

            String id = null;
                                    
            switch (searchBy) {
                case "Search by Lecturer":
                    jComboBoxSearch.removeAllItems();
                    jComboBoxSearch.addItem("");
                    while(resultSet.next()){
                        id = resultSet.getString("LECTURER_ID");
                        jComboBoxSearch.addItem(id);
                    }
                    break;
                case "Search by Lecture Hall":
                    jComboBoxSearch.removeAllItems();
                    jComboBoxSearch.addItem("");
                    while(resultSet.next()){
                        id = resultSet.getString("HALL_ID");
                        jComboBoxSearch.addItem(id);
                    }
                    break;
                case "Search by Batch":
                    jComboBoxSearch.removeAllItems();
                    jComboBoxSearch.addItem("");
                    while(resultSet.next()){
                        id = resultSet.getString("BATCH_ID");
                        jComboBoxSearch.addItem(id);
                    }
                    break;
                default:
                    break;
            }                         
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);       
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    DefaultTableModel model;
    
    private void exportDataToExcel(String fileLocation) {
        FileOutputStream excelFOU = null;
        BufferedOutputStream excelBOU = null;
        XSSFWorkbook excelJTableExporter = null;
        model = (DefaultTableModel) jTableETT.getModel();
        
        try {
            //Import excel poi libraries to netbeans
            excelJTableExporter = new XSSFWorkbook();
            XSSFSheet excelSheet = excelJTableExporter.createSheet("JTable Excel Sheet");

            //Loop to get jtable columns and rows
            for (int i = 0; i < model.getRowCount(); i++) {
                XSSFRow excelRow = excelSheet.createRow(i);
                for (int j = 0; j < model.getColumnCount(); j++) {
                    XSSFCell excelCell = excelRow.createCell(j);
                    excelCell.setCellValue(model.getValueAt(i, j).toString());
                }
            }               
            File excelFile = new File(fileLocation);
            excelFOU = new FileOutputStream(excelFile + ".xlsx");
            excelBOU = new BufferedOutputStream(excelFOU);
            excelJTableExporter.write(excelBOU);
            JOptionPane.showMessageDialog(null, "Updated Successfully.");
        } catch (FileNotFoundException FNFException) {
            JOptionPane.showMessageDialog(null, FNFException.getMessage());
        } catch (IOException iOException) {
             JOptionPane.showMessageDialog(null, iOException.getMessage());
        } finally {
            try {
                if (excelBOU != null) {
                    excelBOU.close();
                }
                if (excelFOU != null) {
                    excelFOU.close();
                }
                if (excelJTableExporter != null) {
                    excelJTableExporter.close();
                }
            } catch (IOException iOException) {
                JOptionPane.showMessageDialog(null, iOException.getMessage());
            }
        }
    }
    
    private void importDataFromExcel(String fileLocation) {
        File excelFile;
        FileInputStream excelFIS = null;
        BufferedInputStream excelBIS = null;
        XSSFWorkbook excelImportToJTable = null; 
        model = (DefaultTableModel) jTableETT.getModel();
        
        try {
            excelFile = new File(fileLocation + ".xlsx");
            excelFIS = new FileInputStream(excelFile);
            excelBIS = new BufferedInputStream(excelFIS);
            excelImportToJTable = new XSSFWorkbook(excelBIS);
            XSSFSheet excelSheet = excelImportToJTable.getSheetAt(0);

            for (int row = 0; row <= excelSheet.getLastRowNum(); row++) {
                XSSFRow excelRow = excelSheet.getRow(row);
                for (int column = 0; column < excelRow.getLastCellNum(); column++){
                    XSSFCell excelCell = excelRow.getCell(column);
                    model.setValueAt(excelCell.toString(), row, column);
                    System.out.println(row +" " +column);
                    System.out.println(excelCell);                   
                 }
            }
        }
        catch (IOException iOException) {
            JOptionPane.showMessageDialog(null, iOException.getMessage());
        } finally {
            try {
                if (excelFIS != null) {
                    excelFIS.close();
                }
                if (excelBIS != null) {
                    excelBIS.close();
                }
                if (excelImportToJTable != null) {
                    excelImportToJTable.close();
                }
            } catch (IOException iOException) {
                JOptionPane.showMessageDialog(null, iOException.getMessage());
            }
        }
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditTimeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditTimeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditTimeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditTimeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditTimeTable test = new EditTimeTable();
                test.setSize(800, 400);
                test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                test.show();
                //new EditTimeTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBoxSearch;
    private javax.swing.JComboBox<String> jComboBoxSearchBy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelClear;
    private javax.swing.JLabel jLabelDelete;
    private javax.swing.JLabel jLabelEditTimeTable;
    private javax.swing.JLabel jLabelSearchIcon;
    private javax.swing.JLabel jLabelUpdate;
    private javax.swing.JLabel jLabelViewTimeTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPaneETT;
    private javax.swing.JTable jTableETT;
    // End of variables declaration//GEN-END:variables
}
