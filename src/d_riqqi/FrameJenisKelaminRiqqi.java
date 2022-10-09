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
public class FrameJenisKelaminRiqqi extends javax.swing.JFrame {

    /**
     * Creates new form FrameJenisKelaminRiqqi
     */
    public FrameJenisKelaminRiqqi() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textNama = new javax.swing.JTextField();
        radioPria = new javax.swing.JRadioButton();
        radioWanita = new javax.swing.JRadioButton();
        buttonProses = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("NAMA PENDUDUK");

        jLabel2.setText("JENIS KELAMIN");

        buttonGroup1.add(radioPria);
        radioPria.setSelected(true);
        radioPria.setText("LAKI - LAKI");
        radioPria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioPriaActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioWanita);
        radioWanita.setText("PEREMPUAN");

        buttonProses.setText("PROSES");
        buttonProses.setActionCommand("");
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
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonProses)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(radioPria)
                        .addGap(18, 18, 18)
                        .addComponent(radioWanita))
                    .addComponent(textNama, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(radioPria)
                    .addComponent(radioWanita))
                .addGap(18, 18, 18)
                .addComponent(buttonProses)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radioPriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioPriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioPriaActionPerformed

    private void buttonProsesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProsesActionPerformed
        String nama = textNama.getText();
        
        String jenisKelamin = "";
        if (radioWanita.isSelected()) {
            jenisKelamin = "Perempuan";
        } else {
            jenisKelamin = "Laki - Laki";
        }

        JOptionPane.showMessageDialog(this, " NAMA          : " + nama
                + "\n JENIS KELAMIN : " + jenisKelamin,
                "JENIS KELAMIN", JOptionPane.INFORMATION_MESSAGE);

        textNama.requestFocus();
        textNama.setText("");

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
            java.util.logging.Logger.getLogger(FrameJenisKelaminRiqqi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameJenisKelaminRiqqi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameJenisKelaminRiqqi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameJenisKelaminRiqqi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        Font font = new Font("Monospaced", Font.PLAIN, 15);
//For MessageArea and TextField font.
        UIManager.put("OptionPane.messageFont", font);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameJenisKelaminRiqqi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton buttonProses;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton radioPria;
    private javax.swing.JRadioButton radioWanita;
    private javax.swing.JTextField textNama;
    // End of variables declaration//GEN-END:variables
}