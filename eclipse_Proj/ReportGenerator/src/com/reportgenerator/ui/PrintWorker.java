/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reportgenerator.ui;

import java.awt.BorderLayout;
import java.awt.Window;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.AbstractButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

/**
 *
 * @author mayur
 */
public class PrintWorker {
    public PrintWorker(final String jrxmlPath, final JTable dataTableJT, java.awt.event.ActionEvent evt, final ReportGenerator generator){
        SwingWorker<Void, Void> mySwingWorker = new SwingWorker<Void, Void>(){
         @Override
         protected Void doInBackground() throws Exception {
            // mimic some long-running process here...
             print(jrxmlPath,dataTableJT, generator);
             return null;
         }
      };

      Window win = SwingUtilities.getWindowAncestor((AbstractButton)evt.getSource());
      final JDialog dialog = new PleaseWaitJD(generator, true);
      dialog.setResizable(false);
      mySwingWorker.addPropertyChangeListener(new PropertyChangeListener() {

         @Override
         public void propertyChange(PropertyChangeEvent evt) {
            if (evt.getPropertyName().equals("state")) {
               if (evt.getNewValue() == SwingWorker.StateValue.DONE) {
                  dialog.dispose();
               }
            }
         }
      });
      mySwingWorker.execute();
      
      JPanel panel = new JPanel(new BorderLayout());
      panel.add(new JLabel("Please wait......."), BorderLayout.PAGE_START);
      dialog.add(panel);
      dialog.pack();
      dialog.setLocationRelativeTo(win);
      dialog.setVisible(true);
    }
     void print(String jrxmlPath, JTable dataTableJT ,ReportGenerator generator) {
        try {
            if (isPrinterAvailable()) {
                int totalCheckedRow = 0;
                if (dataTableJT.getRowCount() > 0) {
                    List<Map<String, ?>> maps = new ArrayList<>();
                    InputStream istream = getClass().getResourceAsStream(jrxmlPath);
                    JasperReport jasperReport = JasperCompileManager.compileReport(istream);
                    JasperPrint print = null;
                    int noOfPrints =0;
                    for (int i = 0; i < dataTableJT.getRowCount(); i++) {
                        Boolean isChecked = (Boolean) dataTableJT.getValueAt(i, 0);
                        if (isChecked) {
                        	++noOfPrints;
                            totalCheckedRow++;
                            Map<String, String> map = new HashMap<>();
                            for (int j = 1; j < dataTableJT.getColumnCount(); j++) {
                                map.put(dataTableJT.getColumnName(j).toLowerCase(), "" + dataTableJT.getValueAt(i, j));
                            }
                            maps.add(map);
                            JRMapCollectionDataSource dataSource = new JRMapCollectionDataSource(maps);
                            
                            JasperPrint tmp = JasperFillManager.fillReport(jasperReport, map,dataSource);
                            
                            if(print == null){
                                print = tmp;
                            }else{
                                  print.addPage((JRPrintPage) tmp.getPages().get(0));
                            }
                        }
                    }
                    if(noOfPrints!=0){
                        if (JOptionPane.showConfirmDialog(null, "do you want to print "+noOfPrints+" pages ?", "Confirm Print..",
                                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        	 JasperPrintManager.printReport(print, true);
                        } else {
                        }
                    }
                }
                if (totalCheckedRow == 0) {
                    if (dataTableJT.getRowCount() == 0) {
                        JOptionPane.showMessageDialog(generator, "Please open file.");
                    } else {
                        JOptionPane.showMessageDialog(generator, "Please select data to print.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(generator, "Printer Not available.");
            }
        } catch (JRException ex) {
            ex.printStackTrace();
            Logger.getLogger(ReportGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public boolean isPrinterAvailable() {
        PrintService printer = PrintServiceLookup.lookupDefaultPrintService();
        if (printer == null) {
            return false;
        }
        return true;
    }
    
    
}
