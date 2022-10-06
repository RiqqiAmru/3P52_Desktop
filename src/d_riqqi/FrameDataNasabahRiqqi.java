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
 * @author Kamelia
 */
public class FrameDataNasabahRiqqi extends javax.swing.JFrame {

    /**
     * Creates new form FrameDataNasabahRiqqi
     */
    public FrameDataNasabahRiqqi() {
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

        groupLulusan = new javax.swing.ButtonGroup();
        groupUsia = new javax.swing.ButtonGroup();
        groupKota = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textNama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        buttonSD = new javax.swing.JRadioButton();
        buttonSMP = new javax.swing.JRadioButton();
        buttonSMA = new javax.swing.JRadioButton();
        buttonD3 = new javax.swing.JRadioButton();
        buttonS1 = new javax.swing.JRadioButton();
        buttonS2 = new javax.swing.JRadioButton();
        buttons3 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        radioRemaja = new javax.swing.JRadioButton();
        usiaDewasa = new javax.swing.JRadioButton();
        usiaDewasaSekali = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        radioPkl = new javax.swing.JRadioButton();
        radioJateng = new javax.swing.JRadioButton();
        radioJawa = new javax.swing.JRadioButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        radioLuar = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("PENDATAAN DATA NASABAH XXXX");

        jLabel2.setText("1. NAMA NASABAH ");

        jLabel3.setText("2. LULUSAN TERAKHIR");

        groupLulusan.add(buttonSD);
        buttonSD.setText("SD");

        groupLulusan.add(buttonSMP);
        buttonSMP.setText("SMP");

        groupLulusan.add(buttonSMA);
        buttonSMA.setSelected(true);
        buttonSMA.setText("SMA");
        buttonSMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSMAActionPerformed(evt);
            }
        });

        groupLulusan.add(buttonD3);
        buttonD3.setText("D3");

        groupLulusan.add(buttonS1);
        buttonS1.setText("S1");

        groupLulusan.add(buttonS2);
        buttonS2.setText("S2");

        groupLulusan.add(buttons3);
        buttons3.setText("S3");
        buttons3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttons3ActionPerformed(evt);
            }
        });

        jLabel4.setText("3. USIA NASABAH");

        groupUsia.add(radioRemaja);
        radioRemaja.setSelected(true);
        radioRemaja.setText("17 - 21");

        groupUsia.add(usiaDewasa);
        usiaDewasa.setText("22 - 39");

        groupUsia.add(usiaDewasaSekali);
        usiaDewasaSekali.setText("40 - ~");

        jLabel5.setText("4. KOTA TINGGAL");

        groupKota.add(radioPkl);
        radioPkl.setText("PEKALONGAN");

        groupKota.add(radioJateng);
        radioJateng.setSelected(true);
        radioJateng.setText("JATENG");

        groupKota.add(radioJawa);
        radioJawa.setText("PULAU JAWA");

        jToggleButton1.setText("PROSES");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        groupKota.add(radioLuar);
        radioLuar.setText("LUAR PULAU JAWA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buttonD3)
                                    .addComponent(radioRemaja)
                                    .addComponent(usiaDewasa)
                                    .addComponent(usiaDewasaSekali)
                                    .addComponent(radioPkl)
                                    .addComponent(radioJateng)
                                    .addComponent(radioJawa)
                                    .addComponent(jToggleButton1)
                                    .addComponent(radioLuar)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(buttonSMA)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(buttons3))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(buttonSMP)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(buttonS2))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(buttonSD)
                                            .addGap(30, 30, 30)
                                            .addComponent(buttonS1))))))
                        .addGap(0, 109, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(43, 43, 43)
                                .addComponent(textNama))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(buttonSD)
                    .addComponent(buttonS1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSMP)
                    .addComponent(buttonS2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSMA)
                    .addComponent(buttons3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonD3)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(radioRemaja))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usiaDewasa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usiaDewasaSekali)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(radioPkl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioJateng)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioJawa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioLuar)
                .addGap(10, 10, 10)
                .addComponent(jToggleButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSMAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonSMAActionPerformed

    private void buttons3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttons3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttons3ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        String nama = textNama.getText();

        String lulusan = "";
        if (buttonSD.isSelected()) {
            lulusan = "SD / SEKOLAH UMUM";
        } else if (buttonSMP.isSelected()) {
            lulusan = "SMP / SEKOLAH UMUM";
        } else if (buttonSMA.isSelected()) {
            lulusan = "SMA / SEKOLAH UMUM";
        } else if (buttonD3.isSelected()) {
            lulusan = "D3 / SARJANA MUDA";
        } else if (buttonS1.isSelected()) {
            lulusan = "S1 / SARJANA LENGKAP";
        } else if (buttonS2.isSelected()) {
            lulusan = "S2 / SARJANA LENGKAP";
        } else if (buttons3.isSelected()) {
            lulusan = "S3 / SARJANA LENGKAP";
        }

        String usia = "";
        if (radioRemaja.isSelected()) {
            usia = "17 - 21 / REMAJA";
        } else if (usiaDewasa.isSelected()) {
            usia = "22 - 39 / DEWASA";
        } else if (usiaDewasaSekali.isSelected()) {
            usia = "40 - ~ / NASABAH DEWASA SEKALI";
        }

        String kota = "";
        if (radioJateng.isSelected()) {
            kota = "JATENG / LOKASI DEKAT DENGAN BANK TUJUAN";
        } else if (radioPkl.isSelected()) {
            kota = "PEKALONGAN / LOKASI DEKAT DENGAN BANK TUJUAN";
        } else if (radioJawa.isSelected()) {
            kota = "JAWA / LOKASI DEKAT DENGAN BANK TUJUAN";
        } else if (radioLuar.isSelected()) {
            kota = "LUAR PULAU JAWA / JAUH DARI TUJUAN";
        }

        String hasil = "";
        hasil += "\n      DATA NASABAH ";
        hasil += "\n NAMA         : " + nama;
        hasil += "\n LULUSAN      : " + lulusan;
        hasil += "\n USIA         : " + usia;
        hasil += "\n KOTA TINGGAL : " + kota;
        if (textNama.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "TOLONG ISIKAN NAMA");
            textNama.requestFocus();
        } else {
            JOptionPane.showMessageDialog(this, hasil, "HASIL", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FrameDataNasabahRiqqi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameDataNasabahRiqqi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameDataNasabahRiqqi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameDataNasabahRiqqi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        Font font = new Font("Monospaced", Font.PLAIN, 15);
        //For MessageArea and TextField font.
        UIManager.put("OptionPane.messageFont", font);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameDataNasabahRiqqi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton buttonD3;
    private javax.swing.JRadioButton buttonS1;
    private javax.swing.JRadioButton buttonS2;
    private javax.swing.JRadioButton buttonSD;
    private javax.swing.JRadioButton buttonSMA;
    private javax.swing.JRadioButton buttonSMP;
    private javax.swing.JRadioButton buttons3;
    private javax.swing.ButtonGroup groupKota;
    private javax.swing.ButtonGroup groupLulusan;
    private javax.swing.ButtonGroup groupUsia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JRadioButton radioJateng;
    private javax.swing.JRadioButton radioJawa;
    private javax.swing.JRadioButton radioLuar;
    private javax.swing.JRadioButton radioPkl;
    private javax.swing.JRadioButton radioRemaja;
    private javax.swing.JTextField textNama;
    private javax.swing.JRadioButton usiaDewasa;
    private javax.swing.JRadioButton usiaDewasaSekali;
    // End of variables declaration//GEN-END:variables
}
