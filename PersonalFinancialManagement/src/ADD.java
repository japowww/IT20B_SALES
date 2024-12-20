import java.time.LocalDate;
import javax.swing.JOptionPane;

public class ADD extends javax.swing.JFrame {

private static int transactionCounter = 1; // Start at 1
private javax.swing.JFrame previousFrame;
       


    public ADD() {
       this.previousFrame = previousFrame;
        initComponents();
    }

    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jdescription = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jamount = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jCombotype = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(23, 21, 59));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PERSONAL FINANCIAL MANAGEMENT");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DESCRIPTION:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));
        jPanel1.add(jdescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 240, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("AMOUNT:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, -1, -1));

        jamount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jamountActionPerformed(evt);
            }
        });
        jPanel1.add(jamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 100, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TYPE:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 70, -1));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("CONFIRM");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 90, 30));

        jCombotype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "    ", "INCOME", "EXPENSES" }));
        jCombotype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCombotypeActionPerformed(evt);
            }
        });
        jPanel1.add(jCombotype, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 110, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jCombotypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCombotypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCombotypeActionPerformed

    
//    CONFIRM BUTTON
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
          String description = jdescription.getText().trim();
    String amount = jamount.getText().trim();
    Object type = jCombotype.getSelectedItem();

    // Validation: Check for empty fields
    if (description.isEmpty() || amount.isEmpty() || type == null || type.toString().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "All fields are required.", "Input Error", JOptionPane.ERROR_MESSAGE);
        // Return to the previous frame without adding data
        if (previousFrame != null) {
            previousFrame.setVisible(true);
        }
   
        return;
    }

    // Validation: Check if description contains only words
    if (!description.matches("[a-zA-Z ]+")) {
        JOptionPane.showMessageDialog(this, "Description must contain only letters and spaces.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Validation: Check if amount is numeric
    try {
        Double.parseDouble(amount); // Try parsing the amount as a number
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Amount must be a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Fetch the current date
    LocalDate currentDate = LocalDate.now();

    // Add data to the table in PFM
    PFM.AddRowtoTable(new Object[]{
        transactionCounter++,         // Transaction number
        type,                         // Selected type
        description,                  // Description
        amount,                       // Amount
        currentDate.toString()        // Current date
    });

    // Clear the input fields (optional)
    jdescription.setText("");
    jamount.setText("");
    jCombotype.setSelectedIndex(0);

    // Navigate back to the previous frame
    if (previousFrame != null) {
        previousFrame.setVisible(true); // Make the previous frame visible
    }
    this.dispose();
    
        
         
     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jamountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jamountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jamountActionPerformed

 
    
    
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
            java.util.logging.Logger.getLogger(ADD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ADD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ADD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ADD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ADD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jCombotype;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jamount;
    private javax.swing.JTextField jdescription;
    // End of variables declaration//GEN-END:variables
}
