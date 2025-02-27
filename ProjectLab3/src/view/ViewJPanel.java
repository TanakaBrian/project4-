/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;
import model.User;
import javax.swing.JPanel;

/**
 *
 * @author wolves
 */
public class ViewJPanel extends javax.swing.JPanel {
    private User userObject;
    
    // UI components (Ensure these exist in your UI design)
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField surnameInputField;
    private javax.swing.JTextField emailInputField;
    private javax.swing.JTextField phoneNumberInputField;
    private javax.swing.JComboBox<String> genderComboBox;
    private javax.swing.JSpinner ageSpinner;
    private javax.swing.JTextArea hobbiesTextArea;


/**
     * Default constructor
     */
    public ViewJPanel() {
        initComponents();
    }
    
  /**
     * Constructor with user data
     */
    public ViewJPanel(User userObject) {
        this.userObject = userObject;
        initComponents(); // Fix the typo and initialize UI first
        setAllFields();
    }
   /**
     * Populates the UI fields with user data
     */
    private void setAllFields() {
        if (userObject != null) {
            nameTextField.setText(userObject.getName());
            surnameInputField.setText(userObject.getSurname());
            emailInputField.setText(userObject.getEmail());
            phoneNumberInputField.setText(userObject.getPhoneNumber());
            genderComboBox.setSelectedItem(userObject.getGender());
            ageSpinner.setValue(userObject.getAge());
            hobbiesTextArea.setText(userObject.getHoby());
        }
    }
    
    /**
     * Initializes the UI components
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {
        nameTextField = new javax.swing.JTextField();
        surnameInputField = new javax.swing.JTextField();
        emailInputField = new javax.swing.JTextField();
        phoneNumberInputField = new javax.swing.JTextField();
        genderComboBox = new javax.swing.JComboBox<>(new String[]{"Male", "Female", "Other"});
        ageSpinner = new javax.swing.JSpinner();
        hobbiesTextArea = new javax.swing.JTextArea();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
