package com.reportgenerator.ui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReportGenerator extends javax.swing.JFrame {

    public List<List<Object>> rowData;
    public List<Object> columnData;
    public List<List<Object>> tempRowData;
    public List<Object> tempColumnData;
    public DefaultTableModel tm;

    public ReportGenerator() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        openFileChooser = new javax.swing.JButton();
        selectedFileTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTableJT = new javax.swing.JTable();
        printPSPJB = new javax.swing.JButton();
        printPRPJB = new javax.swing.JButton();
        printSCJB = new javax.swing.JButton();
        searchTF = new javax.swing.JTextField();
        searchJB = new javax.swing.JButton();
        clearJB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Apna Group Certificate Generator");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(107, 107, 107));

        openFileChooser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/reportgenerator/data/openFile.png"))); // NOI18N
        openFileChooser.setText("Open File");
        openFileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileChooserActionPerformed(evt);
            }
        });

        selectedFileTF.setEditable(false);

        dataTableJT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(dataTableJT);

        printPSPJB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/reportgenerator/data/print.png"))); // NOI18N
        printPSPJB.setText("  PSP");
        printPSPJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printPSPJBActionPerformed(evt);
            }
        });

        printPRPJB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/reportgenerator/data/print.png"))); // NOI18N
        printPRPJB.setText("  PRP");
        printPRPJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printPRPJBActionPerformed(evt);
            }
        });

        printSCJB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/reportgenerator/data/print.png"))); // NOI18N
        printSCJB.setText("  Share");
        printSCJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printSCJBActionPerformed(evt);
            }
        });

        searchTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchTFKeyPressed(evt);
            }
        });

        searchJB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/reportgenerator/data/srch.png"))); // NOI18N
        searchJB.setText("Search");
        searchJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchJBActionPerformed(evt);
            }
        });

        clearJB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/reportgenerator/data/sweep.png"))); // NOI18N
        clearJB.setText("Clear");
        clearJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearJBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(selectedFileTF, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(openFileChooser)
                        .addGap(237, 237, 237)
                        .addComponent(printSCJB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(printPRPJB, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(printPSPJB, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(searchTF, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchJB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearJB)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(printPSPJB)
                            .addComponent(printPRPJB)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(selectedFileTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(openFileChooser)
                            .addComponent(printSCJB))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchJB)
                    .addComponent(clearJB))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void clearJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearJBActionPerformed
        searchTF.setText("");
        if (tm != null) {
            tm.setRowCount(0);
            for (List<Object> singleRow : rowData) {
                tm.addRow(singleRow.toArray());
            }
        }
    }//GEN-LAST:event_clearJBActionPerformed

    private void searchJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchJBActionPerformed
        String searchString = searchTF.getText();
        if ("".equals(searchString) && searchString != null) {
            if (searchCount != 0) {
                tm.setRowCount(0);
                for (List<Object> singleRow : rowData) {
                    tm.addRow(singleRow.toArray());
                }
                searchCount = 0;
            }
        } else {
            String val = "";
            tempRowData = new ArrayList<>();
            for (int row = 0; row <= dataTableJT.getRowCount() - 1; row++) {
                boolean matchingFound = false;
                for (int col = 0; col <= dataTableJT.getColumnCount() - 1; col++) {
                    if (dataTableJT.getValueAt(row, col) != null) {
                        val = dataTableJT.getValueAt(row, col).toString();
                    } else {
                        val = "";
                    }
                    if (val.toLowerCase().contains(searchString.toLowerCase()) && !matchingFound) {
                        matchingFound = true;
                        //                    if (val.startsWith(searchString)) {
                        // this will automatically set the view of the scroll in the location of the value
                        dataTableJT.scrollRectToVisible(dataTableJT.getCellRect(row, 0, true));
                        // this will automatically set the focus of the searched/selected row/value
                        dataTableJT.setRowSelectionInterval(row, row);
                        List<Object> singleRow = new ArrayList<>();
                        for (int i = 0; i <= dataTableJT.getColumnCount() - 1; i++) {
                            singleRow.add(dataTableJT.getValueAt(row, i));
                        }
                        tempRowData.add(singleRow);

                    }
                }
            }
            if (tm != null) {
                tm.setRowCount(0);
                for (List<Object> singleRow : tempRowData) {
                    tm.addRow(singleRow.toArray());
                }
            }
            searchCount++;
        }
    }//GEN-LAST:event_searchJBActionPerformed

    private void searchTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTFKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            searchJBActionPerformed(null);
        }
    }//GEN-LAST:event_searchTFKeyPressed

    private void printSCJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printSCJBActionPerformed
        final String jrxmlPath = "/com/reportgenerator/data/printSCReport.jrxml"; // jrxml path for SC Report
        new PrintWorker(jrxmlPath, dataTableJT, evt, this);
    }//GEN-LAST:event_printSCJBActionPerformed

    private void printPRPJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printPRPJBActionPerformed
        final String jrxmlPath = "/com/reportgenerator/data/printPRPReport.jrxml"; // jrxml path for PRP Report
        new PrintWorker(jrxmlPath, dataTableJT, evt, this);
    }//GEN-LAST:event_printPRPJBActionPerformed

    private void openFileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileChooserActionPerformed
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jfc.setAcceptAllFileFilterUsed(false);
        jfc.addChoosableFileFilter(new FileNameExtensionFilter("Data Files(*.xls , *.xlsx)", "xlsx", "xls"));
        jfc.setMultiSelectionEnabled(false);
        int returnVal = jfc.showOpenDialog(this);
        dataTableJT.setModel(new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) {
                    return true;
                } else {
                    return false;
                }
            }
        });
        tm = (DefaultTableModel) dataTableJT.getModel();
        tm.setColumnCount(0);
        tm.setRowCount(0);
        dataTableJT.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        rowData = new LinkedList<>();
        columnData = new LinkedList<>();
        int count = 0;
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = jfc.getSelectedFile();
            selectedFileTF.setText(file.getAbsolutePath());
            selectedFileTF.setEditable(false);
            try {
                Workbook workbook = Workbook.getWorkbook(file);
                Sheet sheet = workbook.getSheet(0);
                columnData.add("");
                for (int i = 0; i < sheet.getRows(); i++) {
                    ++count;
                    List<Object> singleRow = new ArrayList<>();
                    if (count != 1) {
                        singleRow.add(false);
                    }
                    Cell[] cellsOfRow = sheet.getRow(i);
                    for (int j = 0; j < cellsOfRow.length; j++) {
                        if (count == 1) {
                            columnData.add(sheet.getCell(j, i).getContents());
                        } else {
                            singleRow.add(sheet.getCell(j, i).getContents());
                        }
                    }
                    if (!singleRow.isEmpty()) {
                        rowData.add(singleRow);
                    }
                }
                for (Object column : columnData) {
                    tm.addColumn(column);
                }
                for (List<Object> singleRow : rowData) {
                    tm.addRow(singleRow.toArray());
                }
                TableColumn tc;
                for (int i = 0; i < dataTableJT.getColumnCount(); i++) {
                    tc = dataTableJT.getColumnModel().getColumn(i);
                    if (i == 0) {
                        tc.setCellEditor(dataTableJT.getDefaultEditor(Boolean.class));
                        tc.setCellRenderer(dataTableJT.getDefaultRenderer(Boolean.class));
                        tc.setHeaderRenderer(new CheckBoxHeader(new HeaderCheckBoxItemListener()));
                    }
                    tc.setResizable(true);
                    tc.setPreferredWidth(125);
                    tc.sizeWidthToFit();
                }

                tm.fireTableDataChanged();
            } catch (IOException | BiffException | IndexOutOfBoundsException e) {
                usePOIForNewerVersion(file);
            }
        }
    }//GEN-LAST:event_openFileChooserActionPerformed

    private void printPSPJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printPSPJBActionPerformed
        final String jrxmlPath = "/com/reportgenerator/data/printPSPReport.jrxml"; // jrxml path for PSP Report
        new PrintWorker(jrxmlPath, dataTableJT, evt, this);
    }//GEN-LAST:event_printPSPJBActionPerformed
    JFileChooser jfc = new JFileChooser();

    class HeaderCheckBoxItemListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            Object source = e.getSource();
            if (source instanceof AbstractButton == false) {
                return;
            }
            boolean checked = e.getStateChange() == ItemEvent.SELECTED;
            for (int x = 0, y = dataTableJT.getRowCount(); x < y; x++) {
                dataTableJT.setValueAt(checked, x, 0);
            }
        }
    }

    private void usePOIForNewerVersion(File file) {
        try {
            org.apache.poi.ss.usermodel.Workbook workbook = WorkbookFactory.create(file);
            org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);
            org.apache.poi.ss.usermodel.Row row;
            org.apache.poi.ss.usermodel.Cell cell;
            rowData = new LinkedList<>();
            columnData = new LinkedList<>();
            Iterator rows = sheet.rowIterator();
            columnData.add("");
            int count = 0;
            boolean removedEmptyArea = false;
            while (rows.hasNext()) {
                ++count;
                row = (org.apache.poi.ss.usermodel.Row) rows.next();
                Iterator cells = row.cellIterator();
                List<Object> singleRow = new ArrayList<>();
                if (count != 1) {
                    singleRow.add(false);
                }
                while (cells.hasNext()) {
                    cell = (org.apache.poi.ss.usermodel.Cell) cells.next();
                    if (cell.getCellType() != org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BLANK || removedEmptyArea) {
                        cell.setCellType(org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING);
                        removedEmptyArea = true;
                        if (count == 1) {
                            columnData.add(cell);
                        } else {
                            singleRow.add(cell);
                        }
                    }
                }
                if (!singleRow.isEmpty()) {
                    rowData.add(singleRow);
                }
            }
            for (Object column : columnData) {
                tm.addColumn(column);
            }
            for (List<Object> singleRow : rowData) {
                tm.addRow(singleRow.toArray());
            }
            TableColumn tc;
            for (int i = 0; i < dataTableJT.getColumnCount(); i++) {
                tc = dataTableJT.getColumnModel().getColumn(i);
                if (i == 0) {
                    tc.setCellEditor(dataTableJT.getDefaultEditor(Boolean.class));
                    tc.setCellRenderer(dataTableJT.getDefaultRenderer(Boolean.class));
                    tc.setHeaderRenderer(new CheckBoxHeader(new HeaderCheckBoxItemListener()));
                }
                tc.setResizable(true);
                tc.setPreferredWidth(125);
                tc.sizeWidthToFit();
            }
            tm.fireTableDataChanged();
        } catch (IOException | InvalidFormatException e) {
        } finally {
        }
    }
    int searchCount = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            Thread.sleep(3000);
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
                java.util.logging.Logger.getLogger(ReportGenerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(ReportGenerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(ReportGenerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(ReportGenerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new ReportGenerator().setVisible(true);
                }
            });
        } catch (InterruptedException ex) {
            Logger.getLogger(ReportGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearJB;
    private javax.swing.JTable dataTableJT;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton openFileChooser;
    private javax.swing.JButton printPRPJB;
    private javax.swing.JButton printPSPJB;
    private javax.swing.JButton printSCJB;
    private javax.swing.JButton searchJB;
    private javax.swing.JTextField searchTF;
    private javax.swing.JTextField selectedFileTF;
    // End of variables declaration//GEN-END:variables
}
