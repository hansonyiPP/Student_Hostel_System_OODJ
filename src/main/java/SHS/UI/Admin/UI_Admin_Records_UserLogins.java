/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main.java.SHS.UI.Admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import main.java.SHS.FileHandlers.FileHandler;
import main.java.SHS.FileHandlers.FileName;
import main.java.SHS.FileHandlers.FileRecord;
import main.java.SHS.UI.UI_Login;

/**
 *
 * @author User
 */
public class UI_Admin_Records_UserLogins extends javax.swing.JFrame {

    /**
     * Creates new form UI_Admin_Records_UserLogins
     */
    public UI_Admin_Records_UserLogins() {
        initComponents();
        
     Label.setText("Student Login Records");
     String LOG_FILE = FileName.LOGS;
     FileHandler fileHandler = new FileHandler(LOG_FILE);
     
     DefaultTableModel logsTable = (DefaultTableModel) LogsTable.getModel();
      for (FileRecord record : fileHandler.FetchRecord()) {
            String[] recordData = record.getRecordList();
            String userType = recordData[3];
            
            // Filter records for userType "Student"
            if ("Student".equals(userType)) {
                Object[] rowData = new Object[]{recordData[0], recordData[1], recordData[2], recordData[4], recordData[5]};
                logsTable.addRow(rowData);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        LogsTable = new javax.swing.JTable();
        Label = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        StudentLogs = new javax.swing.JButton();
        SearchTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        PaymentBtn = new javax.swing.JLabel();
        RoomsButton1 = new javax.swing.JLabel();
        AdminLogs = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        ManageHeader2 = new javax.swing.JButton();
        ReportsBtn = new javax.swing.JButton();
        RecordsBtn = new javax.swing.JButton();
        LogOut = new javax.swing.JLabel();
        ApplicationsBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(217, 225, 228));

        LogsTable.setBackground(new java.awt.Color(213, 228, 242));
        LogsTable.setForeground(new java.awt.Color(92, 128, 188));
        LogsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Log ID", "Date", "Time", "Student ID", "Username"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(LogsTable);

        Label.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        Label.setForeground(new java.awt.Color(92, 128, 188));
        Label.setText("Student Login Records");
        Label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPanel3.setBackground(new java.awt.Color(92, 128, 188));
        jPanel3.setForeground(new java.awt.Color(92, 128, 188));
        jPanel3.setPreferredSize(new java.awt.Dimension(403, 3));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 424, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        StudentLogs.setText("Student Logins");
        StudentLogs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentLogsActionPerformed(evt);
            }
        });

        SearchTxt.setText("Search...");
        SearchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchTxtKeyReleased(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/java/SHS/UI/Imgs/Search Icon.png"))); // NOI18N

        PaymentBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/java/SHS/UI/Imgs/Payment.png"))); // NOI18N
        PaymentBtn.setText("jLabel4");
        PaymentBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PaymentBtnMouseClicked(evt);
            }
        });

        RoomsButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/java/SHS/UI/Imgs/Rooms.png"))); // NOI18N
        RoomsButton1.setText("jLabel4");
        RoomsButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RoomsButton1MouseClicked(evt);
            }
        });

        AdminLogs.setText("Admin Logins");
        AdminLogs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminLogsActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(92, 128, 188));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/java/SHS/UI/Imgs/SHS Logo Header.png"))); // NOI18N

        ManageHeader2.setBackground(new java.awt.Color(92, 128, 188));
        ManageHeader2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        ManageHeader2.setForeground(new java.awt.Color(217, 225, 228));
        ManageHeader2.setText("Management");
        ManageHeader2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageHeader2ActionPerformed(evt);
            }
        });

        ReportsBtn.setBackground(new java.awt.Color(92, 128, 188));
        ReportsBtn.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        ReportsBtn.setForeground(new java.awt.Color(217, 225, 228));
        ReportsBtn.setText("Reports");
        ReportsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportsBtnActionPerformed(evt);
            }
        });

        RecordsBtn.setBackground(new java.awt.Color(92, 128, 188));
        RecordsBtn.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        RecordsBtn.setForeground(new java.awt.Color(217, 225, 228));
        RecordsBtn.setText("Records");
        RecordsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecordsBtnActionPerformed(evt);
            }
        });

        LogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/java/SHS/UI/Imgs/Logout button.png"))); // NOI18N
        LogOut.setText("jLabel1");
        LogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogOutMouseClicked(evt);
            }
        });

        ApplicationsBtn.setBackground(new java.awt.Color(92, 128, 188));
        ApplicationsBtn.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        ApplicationsBtn.setForeground(new java.awt.Color(217, 225, 228));
        ApplicationsBtn.setText("Applications");
        ApplicationsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApplicationsBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ManageHeader2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ApplicationsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(RecordsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ReportsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(LogOut))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ManageHeader2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ApplicationsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RecordsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ReportsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(Label)))
                        .addGap(60, 60, 60)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(SearchTxt))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 882, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(PaymentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(RoomsButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(339, 339, 339)
                                .addComponent(StudentLogs, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AdminLogs, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(448, 448, 448)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(Label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(SearchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RoomsButton1)
                            .addComponent(PaymentBtn)
                            .addComponent(StudentLogs, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AdminLogs, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StudentLogsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentLogsActionPerformed

        Label.setText("Student Login Records");

        String LOG_FILE = FileName.LOGS;
     FileHandler fileHandler = new FileHandler(LOG_FILE);
     
     DefaultTableModel logsTable = (DefaultTableModel) LogsTable.getModel();
     
     logsTable.setRowCount(0);
      for (FileRecord record : fileHandler.FetchRecord()) {
            String[] recordData = record.getRecordList();
            String userType = recordData[3];
            
            // Filter records for userType "Student"
            if ("Student".equals(userType)) {
                Object[] rowData = new Object[]{recordData[0], recordData[1], recordData[2], recordData[4], recordData[5]};
                logsTable.addRow(rowData);
            }
        }
    }//GEN-LAST:event_StudentLogsActionPerformed

    private void RoomsButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RoomsButton1MouseClicked
        this.setVisible(false);
        UI_Admin_Records_Rooms UIAMR = new UI_Admin_Records_Rooms();
        UIAMR.setVisible(true);
    }//GEN-LAST:event_RoomsButton1MouseClicked

    private void AdminLogsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminLogsActionPerformed
    Label.setText("Admin Login Records");

        String LOG_FILE = FileName.LOGS;
     FileHandler fileHandler = new FileHandler(LOG_FILE);
     
     DefaultTableModel logsTable = (DefaultTableModel) LogsTable.getModel();
     
     logsTable.setRowCount(0);
      for (FileRecord record : fileHandler.FetchRecord()) {
            String[] recordData = record.getRecordList();
            String userType = recordData[3];
            
            // Filter records for userType "Student"
            if ("Admin".equals(userType)) {
                Object[] rowData = new Object[]{recordData[0], recordData[1], recordData[2], recordData[4], recordData[5]};
                logsTable.addRow(rowData);
            }
        }
    }//GEN-LAST:event_AdminLogsActionPerformed

    private void SearchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchTxtKeyReleased
        DefaultTableModel logsTable  = (DefaultTableModel)LogsTable.getModel();
        String search = SearchTxt.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(logsTable);
        LogsTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_SearchTxtKeyReleased

    private void ManageHeader2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageHeader2ActionPerformed
        this.setVisible(false);
        UI_Admin_Manage_User UIAMU = new UI_Admin_Manage_User();
        UIAMU.setVisible(true);
    }//GEN-LAST:event_ManageHeader2ActionPerformed

    private void ReportsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportsBtnActionPerformed
        this.setVisible(false);
        UI_Admin_Reports UIAR = new UI_Admin_Reports();
        UIAR.setVisible(true);
    }//GEN-LAST:event_ReportsBtnActionPerformed

    private void RecordsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecordsBtnActionPerformed
        this.setVisible(false);
        UI_Admin_Records_UserLogins UIARUL = new UI_Admin_Records_UserLogins();
        UIARUL.setVisible(true);
    }//GEN-LAST:event_RecordsBtnActionPerformed

    private void LogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOutMouseClicked
        UI_Login ul = new UI_Login();
        ul.setVisible(true);
        ul.pack();
        ul.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_LogOutMouseClicked

    private void ApplicationsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApplicationsBtnActionPerformed
        this.setVisible(false);
        UI_Admin_Applications UIAA = new UI_Admin_Applications();
        UIAA.setVisible(true);
    }//GEN-LAST:event_ApplicationsBtnActionPerformed

    private void PaymentBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PaymentBtnMouseClicked
        this.setVisible(false);
        UI_Admin_Records_Payment UIARUL = new UI_Admin_Records_Payment();
        UIARUL.setVisible(true);
    }//GEN-LAST:event_PaymentBtnMouseClicked

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
            java.util.logging.Logger.getLogger(UI_Admin_Records_UserLogins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI_Admin_Records_UserLogins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI_Admin_Records_UserLogins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI_Admin_Records_UserLogins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI_Admin_Records_UserLogins().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdminLogs;
    private javax.swing.JButton ApplicationsBtn;
    private javax.swing.JLabel Label;
    private javax.swing.JLabel LogOut;
    private javax.swing.JTable LogsTable;
    private javax.swing.JButton ManageHeader2;
    private javax.swing.JLabel PaymentBtn;
    private javax.swing.JButton RecordsBtn;
    private javax.swing.JButton ReportsBtn;
    private javax.swing.JLabel RoomsButton1;
    private javax.swing.JTextField SearchTxt;
    private javax.swing.JButton StudentLogs;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
