
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class PFM extends javax.swing.JFrame {

   private static Stack<Object[]> undoStack = new Stack<>();
   private static List<Object[]> originalData = new ArrayList<>();
   
   private void returnToOriginalOrder() {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

    // Clear the current table data
    model.setRowCount(0);

    // Restore the original data
    for (Object[] row : originalData) {
        model.addRow(row);
    }

    // Recalculate the "No." column after restoring the original order
    for (int i = 0; i < model.getRowCount(); i++) {
        model.setValueAt(i + 1, i, 0); // Update row numbers
    }
}
   
    public PFM() {
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

        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jButtonUndo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButtonsortamount = new javax.swing.JButton();
        jButtonsorttype = new javax.swing.JButton();
        jButtonreturn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(23, 21, 59));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 110, 40));

        jButtonEdit.setText("EDIT");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 110, 40));

        jButtonUndo.setText("UNDO");
        jButtonUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUndoActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonUndo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 110, 40));

        jTable1.setBackground(new java.awt.Color(51, 51, 51));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "TYPE", "DESCRIPTION", "AMOUNT", "DATE:"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(30);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(30);
            jTable1.getColumnModel().getColumn(1).setMinWidth(90);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(90);
            jTable1.getColumnModel().getColumn(2).setMinWidth(300);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(300);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(300);
            jTable1.getColumnModel().getColumn(3).setMinWidth(100);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 630, 210));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PERSONAL FINANCIAL MANAGEMENT");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, -1));

        jButtonsortamount.setText("SORT BY AMOUNT");
        jButtonsortamount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonsortamountActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonsortamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 330, 140, 20));

        jButtonsorttype.setText("SORT BY TYPE");
        jButtonsorttype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonsorttypeActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonsorttype, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, 120, 20));

        jButtonreturn.setText("RETURN");
        jButtonreturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonreturnActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonreturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, -1, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1008, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      ADD jas = new ADD();
      jas.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUndoActionPerformed
  DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    if (!undoStack.isEmpty() && model.getRowCount() > 0) {
        // Remove the last row added
        model.removeRow(model.getRowCount() - 1);
        undoStack.pop();

        // Recalculate the "No." column
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(i + 1, i, 0); // Update row numbers
        }
    } else {
        JOptionPane.showMessageDialog(this, "No actions to undo!", "Undo Error", JOptionPane.ERROR_MESSAGE);
    }   // TODO add your handling code here:
    }//GEN-LAST:event_jButtonUndoActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
 DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

    // Prompt the user to enter the row number
    String input = JOptionPane.showInputDialog(this, 
        "Enter the row number you want to edit:", 
        "Edit Row", 
        JOptionPane.QUESTION_MESSAGE);

    try {
        // Parse input to integer
        int rowNumber = Integer.parseInt(input) - 1; // Convert to 0-based index

        // Check if the row number is valid
        if (rowNumber >= 0 && rowNumber < model.getRowCount()) {
            // Allow editing only for the selected columns: TYPE, DESCRIPTION, and AMOUNT
            for (int col = 1; col <= 3; col++) { // Columns: 1=TYPE, 2=DESCRIPTION, 3=AMOUNT
                String columnName = model.getColumnName(col);
                Object currentValue = model.getValueAt(rowNumber, col);

                // Handle TYPE column with restricted choices
                if (col == 1) { // TYPE column
                    String[] options = {"INCOME", "EXPENSES"};
                    String newValue = (String) JOptionPane.showInputDialog(this, 
                        "Select value for " + columnName + ":", 
                        "Edit TYPE", 
                        JOptionPane.QUESTION_MESSAGE, 
                        null, 
                        options, 
                        currentValue);

                    if (newValue != null) {
                        model.setValueAt(newValue, rowNumber, col);
                    }
                } else if (col == 2) { // Handle DESCRIPTION column
                    String newValue = JOptionPane.showInputDialog(this, 
                        "Edit value for " + columnName + " (Current: " + currentValue + "):", 
                        currentValue);

                    if (newValue != null && newValue.matches("[A-Za-z ]+")) { // Only letters and spaces
                        model.setValueAt(newValue, rowNumber, col);
                    } else {
                        JOptionPane.showMessageDialog(this, 
                            "Invalid input. DESCRIPTION should contain only words.", 
                            "Input Error", 
                            JOptionPane.ERROR_MESSAGE);
                        col--; // Re-prompt for the same column
                    }
                } else if (col == 3) { // Handle AMOUNT column
                    String newValue = JOptionPane.showInputDialog(this, 
                        "Edit value for " + columnName + " (Current: " + currentValue + "):", 
                        currentValue);

                    if (newValue != null && newValue.matches("\\d+(\\.\\d{1,2})?")) { // Only numbers (allow decimals)
                        model.setValueAt(newValue, rowNumber, col);
                    } else {
                        JOptionPane.showMessageDialog(this, 
                            "Invalid input. AMOUNT should contain only numbers.", 
                            "Input Error", 
                            JOptionPane.ERROR_MESSAGE);
                        col--; // Re-prompt for the same column
                    }
                }
            }
        } else {
            // Invalid row number
            throw new IndexOutOfBoundsException("Row number out of range.");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, 
            "Invalid input. Please enter a numeric row number.", 
            "Input Error", 
            JOptionPane.ERROR_MESSAGE);
    } catch (IndexOutOfBoundsException e) {
        JOptionPane.showMessageDialog(this, 
            e.getMessage(), 
            "Invalid Row", 
            JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonsorttypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonsorttypeActionPerformed
     DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

    // Retrieve all rows as a list
    java.util.List<Object[]> rows = new java.util.ArrayList<>();
    for (int i = 0; i < model.getRowCount(); i++) {
        Object[] row = new Object[model.getColumnCount()];
        for (int j = 0; j < model.getColumnCount(); j++) {
            row[j] = model.getValueAt(i, j);
        }
        rows.add(row);
    }

    // Sort rows by TYPE column (column index 1)
    rows.sort((row1, row2) -> {
        String type1 = row1[1].toString();
        String type2 = row2[1].toString();
        return type1.compareToIgnoreCase(type2); // Income comes before Expenses
    });

    // Clear the table and add the sorted rows
    model.setRowCount(0);
    for (Object[] row : rows) {
        model.addRow(row);
    }

    // Recalculate the "No." column
    for (int i = 0; i < model.getRowCount(); i++) {
        model.setValueAt(i + 1, i, 0);
    }
    }//GEN-LAST:event_jButtonsorttypeActionPerformed

    private void jButtonsortamountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonsortamountActionPerformed
       DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

    // Retrieve all rows as a list
    java.util.List<Object[]> rows = new java.util.ArrayList<>();
    for (int i = 0; i < model.getRowCount(); i++) {
        Object[] row = new Object[model.getColumnCount()];
        for (int j = 0; j < model.getColumnCount(); j++) {
            row[j] = model.getValueAt(i, j);
        }
        rows.add(row);
    }

    // Sort rows by AMOUNT column (column index 3)
    rows.sort((row1, row2) -> {
        Double amount1 = Double.valueOf(row1[3].toString());
        Double amount2 = Double.valueOf(row2[3].toString());
        return amount2.compareTo(amount1); // Descending order
    });

    // Clear the table and add the sorted rows
    model.setRowCount(0);
    for (Object[] row : rows) {
        model.addRow(row);
    }

    // Recalculate the "No." column
    for (int i = 0; i < model.getRowCount(); i++) {
        model.setValueAt(i + 1, i, 0);
    }
    }//GEN-LAST:event_jButtonsortamountActionPerformed

    private void jButtonreturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonreturnActionPerformed
    returnToOriginalOrder();
    }//GEN-LAST:event_jButtonreturnActionPerformed
 public static void AddRowtoTable(Object[] datarow){
   DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

    // Set the first column (No.) as the next number
    Object[] rowWithNumber = new Object[datarow.length];
    rowWithNumber[0] = model.getRowCount() + 1; // Automatically set the row number
    System.arraycopy(datarow, 1, rowWithNumber, 1, datarow.length - 1);

    model.addRow(rowWithNumber);

    // Store the row in the backup list for original order
    originalData.add(rowWithNumber);
 }
    
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
            java.util.logging.Logger.getLogger(PFM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PFM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PFM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PFM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PFM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonUndo;
    private javax.swing.JButton jButtonreturn;
    private javax.swing.JButton jButtonsortamount;
    private javax.swing.JButton jButtonsorttype;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}