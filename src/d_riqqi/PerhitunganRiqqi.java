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
public class PerhitunganRiqqi extends javax.swing.JFrame {

    /**
     * Creates new form PerhitunganRiqqi
     */
    public PerhitunganRiqqi() {
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textTugas = new javax.swing.JTextField();
        textUjian = new javax.swing.JTextField();
        textHasil = new javax.swing.JTextField();
        bJumlah = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nilai Tugas [1-100]");

        jLabel2.setText("Nilai Ujian [1-100]");

        jLabel3.setText("Penjumlahan Nilai Rata - Rata");

        textTugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTugasActionPerformed(evt);
            }
        });

        textUjian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textUjianActionPerformed(evt);
            }
        });

        bJumlah.setText("JUMLAH");
        bJumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bJumlahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(textHasil, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bJumlah)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(textTugas)
                                .addComponent(textUjian, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textTugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textUjian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(bJumlah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textHasil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textTugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTugasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTugasActionPerformed

    private void textUjianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textUjianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textUjianActionPerformed

    private void bJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bJumlahActionPerformed
        try {
            float a = Float.parseFloat(textTugas.getText());
            float b = Float.parseFloat(textUjian.getText());

            if (a < 0 || b < 0) {
                JOptionPane.showMessageDialog(this, "NILAI GA BOLE NEGATIF", "INFORMATION", JOptionPane.ERROR_MESSAGE);
                textTugas.setText("");
                textUjian.setText("");
                textHasil.setText("");
            } else if (a == 0 || b == 0) {
                JOptionPane.showMessageDialog(this, "NILAI 0 TIDAK AKAN MENDAPAT HASIL", "INFORMATION", JOptionPane.ERROR_MESSAGE);
                textTugas.setText("");
                textUjian.setText("");
                textHasil.setText("");
            } else if (a <= 100 && b <= 100) {
                float hasilJumlah = (a + b) / 2;
                textHasil.setText(String.valueOf(hasilJumlah));
            } else {
                JOptionPane.showMessageDialog(this, "NILAI DIATAS 100 GABOLE", "INFORMATION", JOptionPane.ERROR_MESSAGE);
                textTugas.setText("");
                textUjian.setText("");
                textHasil.setText("");
            }
        } catch (Exception e) {
            if (textTugas.getText().isEmpty() || textUjian.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "NILAI TIDAK BOLEH KOSONG", "INFORMATION", JOptionPane.ERROR_MESSAGE);
                textTugas.setText("");
                textUjian.setText("");
                textHasil.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "NILAI HARUS BERUPA ANGKA", "INFORMATION", JOptionPane.ERROR_MESSAGE);
                textTugas.setText("");
                textUjian.setText("");
                textHasil.setText("");
            }
        }
//        textTugas.setText("");
//        textUjian.setText("");
//        textHasil.setText("");
//        textTugas.requestFocus();
    }//GEN-LAST:event_bJumlahActionPerformed

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
            java.util.logging.Logger.getLogger(PerhitunganRiqqi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PerhitunganRiqqi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PerhitunganRiqqi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PerhitunganRiqqi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        Font font = new Font("Monospaced", Font.PLAIN, 15);
//For MessageArea and TextField font.
        UIManager.put("OptionPane.messageFont", font);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PerhitunganRiqqi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bJumlah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField textHasil;
    private javax.swing.JTextField textTugas;
    private javax.swing.JTextField textUjian;
    // End of variables declaration//GEN-END:variables
}