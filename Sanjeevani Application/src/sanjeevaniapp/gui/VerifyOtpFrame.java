/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanjeevaniapp.gui;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import sanjeevaniapp.dao.AppointmentDao;
import sanjeevaniapp.dao.DoctorDao;
import sanjeevaniapp.dao.PatientDao;
import sanjeevaniapp.pojo.AppointmentPojo;
import sanjeevaniapp.pojo.PatientPojo;
import sanjeevaniapp.utility.OTPSender;
import sanjeevaniapp.utility.Sender;

/**
 *
 * @author TANMAY KUMAR
 */
public class VerifyOtpFrame extends javax.swing.JFrame {

    /**
     * Creates new form VarifyOtoFrame
     */
    private PatientPojo patient; 
    public VerifyOtpFrame() {
        initComponents();
        super.setLocationRelativeTo(null);
    }
    public VerifyOtpFrame(PatientPojo patient) {
       this();
       txtPatientName.setText(patient.getFirstName()+" "+patient.getLastName());
       txtMNo.setText(patient.getMno());
       this.patient=patient;
        
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
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtOTP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtSendOTP = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        txtLogOut = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtPatientName = new javax.swing.JTextField();
        txtBack = new javax.swing.JButton();
        btnVerify = new javax.swing.JButton();
        txtMNo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1080, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Lucida Bright", 3, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("SANJEEVANI ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 40, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sanjeevaniapp/icons/HomePageBGcropped.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 433));

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Patient Name");

        txtOTP.setBackground(new java.awt.Color(153, 204, 255));
        txtOTP.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtOTP.setForeground(new java.awt.Color(0, 0, 0));
        txtOTP.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        txtOTP.setOpaque(false);

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Phone No.");

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtSendOTP.setBackground(new java.awt.Color(0, 0, 0));
        txtSendOTP.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtSendOTP.setForeground(new java.awt.Color(153, 204, 255));
        txtSendOTP.setText("SEND OTP");
        txtSendOTP.setOpaque(false);
        txtSendOTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSendOTPActionPerformed(evt);
            }
        });

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtLogOut.setBackground(new java.awt.Color(0, 0, 0));
        txtLogOut.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtLogOut.setForeground(new java.awt.Color(153, 204, 255));
        txtLogOut.setText("LOGOUT");
        txtLogOut.setOpaque(false);
        txtLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLogOutActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Enter OTP");

        txtPatientName.setEditable(false);
        txtPatientName.setBackground(new java.awt.Color(153, 204, 255));
        txtPatientName.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtPatientName.setForeground(new java.awt.Color(0, 0, 0));
        txtPatientName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        txtPatientName.setOpaque(false);

        txtBack.setBackground(new java.awt.Color(0, 0, 0));
        txtBack.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtBack.setForeground(new java.awt.Color(153, 204, 255));
        txtBack.setText("BACK");
        txtBack.setOpaque(false);
        txtBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBackActionPerformed(evt);
            }
        });

        btnVerify.setBackground(new java.awt.Color(0, 0, 0));
        btnVerify.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnVerify.setForeground(new java.awt.Color(153, 204, 255));
        btnVerify.setText("VERIFY");
        btnVerify.setOpaque(false);
        btnVerify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerifyActionPerformed(evt);
            }
        });

        txtMNo.setEditable(false);
        txtMNo.setBackground(new java.awt.Color(153, 204, 255));
        txtMNo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtMNo.setForeground(new java.awt.Color(0, 0, 0));
        txtMNo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txtMNo.setOpaque(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtMNo, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(113, 113, 113))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLabel4)
                .addGap(32, 32, 32)
                .addComponent(txtOTP, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtSendOTP, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 974, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 974, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(txtBack, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105)
                .addComponent(btnVerify, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtOTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSendOTP))
                .addGap(22, 22, 22)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLogOut)
                    .addComponent(txtBack)
                    .addComponent(btnVerify))
                .addGap(25, 25, 25))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 439, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSendOTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSendOTPActionPerformed
        try{
           Sender sender=new OTPSender();
           String otp=String.valueOf(patient.getOtp());
           boolean result=sender.send(patient.getMno(), otp);
           if(result){
               JOptionPane.showMessageDialog(null,"OTP sent successfully!");
           }else{
               JOptionPane.showMessageDialog(null,"Cannot send the OTP . Please check the number!");
           }
       }catch(Exception ex){
           JOptionPane.showMessageDialog(null,"Server issue");
           ex.printStackTrace();
       }
    }//GEN-LAST:event_txtSendOTPActionPerformed

    private void txtLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLogOutActionPerformed
        LoginFrame frame = new LoginFrame();
        this.dispose();
        frame.setVisible(true);
    }//GEN-LAST:event_txtLogOutActionPerformed

    private void txtBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBackActionPerformed
        AddPatientFrame frame = new AddPatientFrame();
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_txtBackActionPerformed

    private void btnVerifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerifyActionPerformed
        if(!isValidOTP()){
            JOptionPane.showMessageDialog(null,"Invalid OTP. Try again!");
            return;
        }
        try{
            AppointmentPojo appojo=new AppointmentPojo();
            appojo.setAppointmentDate(patient.getDate().toString());
            appojo.setMobileNo(patient.getMno());
            appojo.setOpd(patient.getOpd());
            appojo.setPatientId(patient.getPatientId());
            appojo.setPatientName(txtPatientName.getText().trim());
            appojo.setStatus("REQUEST");
            String docName=DoctorDao.getDoctorNameById(patient.getDoctorId());
            appojo.setDoctorName(docName);
            boolean result1=PatientDao.addPatient(patient);
            boolean result2=AppointmentDao.addAppointment(appojo);
            if(result1 && result2){
                JOptionPane.showMessageDialog(null,"Patient record saved!!");
                ViewAllPatientsFrame viewAll=new ViewAllPatientsFrame();
                this.dispose();
                viewAll.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null,"Sorry! could not save the patient record!");
            }
            
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(null,"Error in DB");
           ex.printStackTrace();
       }
    }//GEN-LAST:event_btnVerifyActionPerformed

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
            java.util.logging.Logger.getLogger(VerifyOtpFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerifyOtpFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerifyOtpFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerifyOtpFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerifyOtpFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVerify;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton txtBack;
    private javax.swing.JButton txtLogOut;
    private javax.swing.JTextField txtMNo;
    private javax.swing.JTextField txtOTP;
    private javax.swing.JTextField txtPatientName;
    private javax.swing.JButton txtSendOTP;
    // End of variables declaration//GEN-END:variables

    private boolean isValidOTP() {
        boolean result=false;
        int otp=Integer.parseInt(txtOTP.getText().trim());
        if(otp==patient.getOtp())
            result=true;
        return result;
    }
}
