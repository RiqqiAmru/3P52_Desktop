/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package d_riqqi;

import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Riqqi
 */
public class FrameHobbyRiqqi extends javax.swing.JFrame {

    /**
     * Creates new form FrameHobbyRiqqi
     */
    public FrameHobbyRiqqi() {
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

        jLabel1 = new javax.swing.JLabel();
        textNama = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        checkOlahraga = new javax.swing.JCheckBox();
        checkMusik = new javax.swing.JCheckBox();
        checkJalanJalan = new javax.swing.JCheckBox();
        buttonProses = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("NAMA");

        jLabel2.setText("HOBBY");

        checkOlahraga.setText("OLAHRAGA");

        checkMusik.setText("MUSIK");

        checkJalanJalan.setText("JALAN - JALAN");

        buttonProses.setText("PROSES");
        buttonProses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonProsesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(textNama, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkMusik)
                            .addComponent(checkOlahraga)
                            .addComponent(checkJalanJalan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonProses))
                        .addGap(75, 75, 75)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(checkOlahraga))
                .addGap(6, 6, 6)
                .addComponent(checkMusik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkJalanJalan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(buttonProses)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonProsesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProsesActionPerformed
        String info = "";
        String nama = textNama.getText();
        String olahraga = "TIDAK";
        String musik = "TIDAK";
        String jalanJalan = "TIDAK";
        int milihHobby = 0;
        int gaMilihHobby = 3;

        if (checkOlahraga.isSelected()) {
            olahraga = "YA";
            milihHobby++;
            gaMilihHobby--;
        }
        if (checkMusik.isSelected()) {
            musik = "YA";
            milihHobby++;
            gaMilihHobby--;
        }
        if (checkJalanJalan.isSelected()) {
            jalanJalan = "YA";
            milihHobby++;
            gaMilihHobby--;
        }

        info += "\n NAMA  : " + nama;
        info += "\n MEMILIKI HOBBY YAITU  ";
        info += "\n    - OLAHGARA    : " + olahraga;
        info += "\n    - MUSIK       : " + musik;
        info += "\n    - JALAN-JALAN : " + jalanJalan;
        info += "\n  HOBBY               : " + milihHobby;
        info += "\n  TIDAK MEMILIH HOBBY : " + gaMilihHobby;

        if(textNama.getText().isEmpty() | textNama.getText().isBlank()){
           JOptionPane.showMessageDialog(this, "tolong isikan nama", "HOBBY", JOptionPane.INFORMATION_MESSAGE); 
        }else{
        JOptionPane.showMessageDialog(this, info, "HOBBY", JOptionPane.INFORMATION_MESSAGE);
        }
        textNama.setText("");
        textNama.requestFocus();
    }//GEN-LAST:event_buttonProsesActionPerformed

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
            java.util.logging.Logger.getLogger(FrameHobbyRiqqi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameHobbyRiqqi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameHobbyRiqqi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameHobbyRiqqi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        Font font = new Font("Monospaced", Font.PLAIN, 15);
//For MessageArea and TextField font.
        UIManager.put("OptionPane.messageFont", font);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameHobbyRiqqi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonProses;
    private javax.swing.JCheckBox checkJalanJalan;
    private javax.swing.JCheckBox checkMusik;
    private javax.swing.JCheckBox checkOlahraga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField textNama;
    // End of variables declaration//GEN-END:variables
}
