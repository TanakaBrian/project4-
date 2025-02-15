/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import projectlab3.*;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import model.User;


/**
 *
 * @author wolves
 */
public class mainFrame extends javax.swing.JFrame {
 private ImageIcon userProfilePic;
 private javax.swing.JTextField phoneNumberInputField;




 /**
     * Creates new form mainFrame
     */
    
    public mainFrame() {
    initComponents();
    
// Display FormJPanel by default
        FormJPanel formJPanelObject = new FormJPanel(this.bottomPanel);
        this.bottomPanel.add("Form", formJPanelObject);
        
        CardLayout layout = (CardLayout) this.bottomPanel.getLayout();
        layout.show(bottomPanel, "Form");

// Add number validation for phone number input
        ((AbstractDocument)phoneNumberInputField.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
                super.insertString(fb, offset, text.replaceAll("[^0-9]", ""), attr);
            }
            
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                super.replace(fb, offset, length, text.replaceAll("[^0-9]", ""), attrs);
            }
        });
    }

private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        return email.matches(emailRegex);
    }

private void initComponents() {
        collegeButtonGroup = new javax.swing.ButtonGroup();
        jSplitPane1 = new javax.swing.JSplitPane();
        topPanel = new javax.swing.JPanel();
        formButton = new javax.swing.JButton();
        viewButton = new javax.swing.JButton();
        bottomPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 153));
        
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        
        formButton.setText("Form");
        formButton.addActionListener(evt -> formButtonActionPerformed(evt));
        
        viewButton.setText("View");
        viewButton.addActionListener(evt -> viewButtonActionPerformed(evt));
        
        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(formButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 326, Short.MAX_VALUE)
                .addComponent(viewButton)
                .addGap(112, 112, 112))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formButton)
                    .addComponent(viewButton))
                .addGap(34, 34, 34))
        );
        
        jSplitPane1.setTopComponent(topPanel);
        
        bottomPanel.setLayout(new java.awt.CardLayout());
        jSplitPane1.setRightComponent(bottomPanel);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();

}

   

        
      
     

                                        
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        collegeButtonGroup = new javax.swing.ButtonGroup();
        jSplitPane1 = new javax.swing.JSplitPane();
        topPanel = new javax.swing.JPanel();
        formButton = new javax.swing.JButton();
        viewButton = new javax.swing.JButton();
        bottomPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 153));

        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        formButton.setText("Form");

        viewButton.setText("View");
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(formButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 326, Short.MAX_VALUE)
                .addComponent(viewButton)
                .addGap(112, 112, 112))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formButton)
                    .addComponent(viewButton))
                .addGap(34, 34, 34))
        );

        jSplitPane1.setTopComponent(topPanel);

        bottomPanel.setLayout(new java.awt.CardLayout());
        jSplitPane1.setRightComponent(bottomPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButtonActionPerformed
        // TODO add your handling code here:
  ViewJPanel viewJPanelObject = new ViewJPanel();
        this.bottomPanel.add("View", viewJPanelObject);
        
        CardLayout layout = (CardLayout) this.bottomPanel.getLayout();
        layout.show(bottomPanel, "View");

    }//GEN-LAST:event_viewButtonActionPerformed
      
    private void formButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
    FormJPanel formJPanelObject = new FormJPanel(this.bottomPanel);
    this.bottomPanel.add("Form", formJPanelObject);
    
    CardLayout layout = (CardLayout) this.bottomPanel.getLayout();
    layout.show(bottomPanel, "Form");
}

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
     java.awt.EventQueue.invokeLater(() -> new mainFrame().setVisible(true));   
    }
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
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.ButtonGroup collegeButtonGroup;
    private javax.swing.JButton formButton;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel topPanel;
    private javax.swing.JButton viewButton;
    // End of variables declaration//GEN-END:variables

