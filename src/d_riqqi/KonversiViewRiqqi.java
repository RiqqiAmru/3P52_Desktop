/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package d_riqqi;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Riqqi
 */
public class KonversiViewRiqqi extends javax.swing.JFrame {

    DefaultListModel modelList;
    NumberFormat USD = NumberFormat.getCurrencyInstance(Locale.US);     //kurs USD
    NumberFormat YEN = NumberFormat.getCurrencyInstance(Locale.JAPAN);     //kurs USD
    NumberFormat EURO = NumberFormat.getCurrencyInstance(Locale.FRANCE);     //kurs USD

    /**
     * Creates new form KonversiViewRiqqi
     */
    public KonversiViewRiqqi() {
        initComponents();
        modelList = new DefaultListModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cetak = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        nominal = new javax.swing.JTextField();
        kurs1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        kurs2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        ya = new javax.swing.JRadioButton();
        tidak = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        konversi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        history = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Konversi Mata Uang");

        kurs1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Indonesian Rupiah IDR", "American Dollar USD", "Japan YEN", "European EURO\t", " " }));

        jLabel2.setText("Output Mata Uang");

        kurs2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Indonesian Rupiah IDR", "American Dollar USD", "Japan YEN", "European EURO" }));
        kurs2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kurs2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Cetak");

        cetak.add(ya);
        ya.setSelected(true);
        ya.setText("Ya");

        cetak.add(tidak);
        tidak.setText("Tidak");

        jLabel4.setText("History");

        konversi.setText("Konversi");
        konversi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                konversiActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(history);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(nominal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(kurs1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ya)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tidak))
                                    .addComponent(kurs2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(konversi))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nominal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kurs1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kurs2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ya)
                    .addComponent(tidak))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(konversi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void konversiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_konversiActionPerformed
        DecimalFormat IDR = (DecimalFormat) DecimalFormat.getCurrencyInstance(); //kurs Indonesia
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("Rp.");
        formatRp.setMonetaryDecimalSeparator('.');
        formatRp.setGroupingSeparator('.');
        IDR.setDecimalFormatSymbols(formatRp);

        try {
            double IDR_USD = 14997;
            double IDR_EURO = 15235;
            double IDR_JPN = 102.7231;
            
            double USD_JPN = 149.7755;
            double USD_EURO = 1.0221;
            double EURO_JPN = 146.5395;
            
            double nilaiNominal = Double.parseDouble(nominal.getText());
            double hasil = 0;
            String hasilTampil = "";
            if (kurs1.getSelectedIndex() == 0) {
                if (kurs2.getSelectedIndex() == 0) {            //idr ke idr
                    hasil = nilaiNominal;
                    hasilTampil = IDR.format(hasil) + " - " + kurs2.getSelectedItem().toString();
                } else if (kurs2.getSelectedIndex() == 1) {     //idr ke usd
                    hasil = nilaiNominal / IDR_USD;
                    hasilTampil = USD.format(hasil) + " - " + kurs2.getSelectedItem().toString();
                } else if (kurs2.getSelectedIndex() == 2) {          //idr ke yen
                    hasil = nilaiNominal / IDR_JPN;
                    hasilTampil = YEN.format(hasil) + " - " + kurs2.getSelectedItem().toString();
                } else if (kurs2.getSelectedIndex() == 3) {          //idr ke euro
                    hasil = nilaiNominal / IDR_EURO;
                    hasilTampil = EURO.format(hasil) + " - " + kurs2.getSelectedItem().toString();
                }
            } else if (kurs1.getSelectedIndex() == 1) {     
                if (kurs2.getSelectedIndex() == 0) {            //USD KE IDR
                    hasil = nilaiNominal * IDR_USD;
                    hasilTampil = IDR.format(hasil) + " - " + kurs2.getSelectedItem().toString();
                } else if (kurs2.getSelectedIndex() == 1) {     //USD KE USD
                    hasil = nilaiNominal;
                    hasilTampil = USD.format(hasil) + " - " + kurs2.getSelectedItem().toString();
                }else if (kurs2.getSelectedIndex() == 2) {     //USD KE JPN
                    hasil = nilaiNominal * USD_JPN;
                    hasilTampil = YEN.format(hasil) + " - " + kurs2.getSelectedItem().toString();
                }else if (kurs2.getSelectedIndex() == 3) {     //USD KE EURO
                    hasil = nilaiNominal * USD_EURO;
                    hasilTampil = EURO.format(hasil) + " - " + kurs2.getSelectedItem().toString();
                }
            }else if (kurs1.getSelectedIndex() == 2) {     
                if (kurs2.getSelectedIndex() == 0) {            //JPN KE IDR
                    hasil = nilaiNominal * IDR_JPN;
                    hasilTampil = IDR.format(hasil) + " - " + kurs2.getSelectedItem().toString();
                } else if (kurs2.getSelectedIndex() == 1) {     //JPN KE USD
                    hasil = nilaiNominal / USD_JPN;
                    hasilTampil = USD.format(hasil) + " - " + kurs2.getSelectedItem().toString();
                }else if (kurs2.getSelectedIndex() == 2) {     //JPN KE JPN
                    hasil = nilaiNominal ;
                    hasilTampil = YEN.format(hasil) + " - " + kurs2.getSelectedItem().toString();
                }else if (kurs2.getSelectedIndex() == 3) {     //JPN KE EURO
                    hasil = nilaiNominal / EURO_JPN;
                    hasilTampil = EURO.format(hasil) + " - " + kurs2.getSelectedItem().toString();
                }
            }else if (kurs1.getSelectedIndex() == 3) {     
                if (kurs2.getSelectedIndex() == 0) {            //EURO KE IDR
                    hasil = nilaiNominal * IDR_EURO;
                    hasilTampil = IDR.format(hasil) + " - " + kurs2.getSelectedItem().toString();
                } else if (kurs2.getSelectedIndex() == 1) {     //EURO KE USD
                    hasil = nilaiNominal / USD_EURO;
                    hasilTampil = USD.format(hasil) + " - " + kurs2.getSelectedItem().toString();
                }else if (kurs2.getSelectedIndex() == 2) {     //EURO KE JPN
                    hasil = nilaiNominal ;
                    hasilTampil = YEN.format(hasil) + " - " + kurs2.getSelectedItem().toString();
                }else if (kurs2.getSelectedIndex() == 3) {     //EURO KE EURO
                    hasil = nilaiNominal / EURO_JPN;
                    hasilTampil = EURO.format(hasil) + " - " + kurs2.getSelectedItem().toString();
                }
            }

            modelList.addElement(hasilTampil);
            history.setModel(modelList);

            if (ya.isSelected()) {
                JOptionPane.showMessageDialog(this, "Hasil Konversi : "
                        + hasilTampil, "INFORMASI", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {
            if (nominal.getText().isBlank()) {
                JOptionPane.showMessageDialog(this, "KOSONG GA BISA DI KONVERSI");
                nominal.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "INPUT NILAI ANGKA SAJA");
                nominal.setText("");
            }
        }
    }//GEN-LAST:event_konversiActionPerformed

    private void kurs2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kurs2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kurs2ActionPerformed

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
            java.util.logging.Logger.getLogger(KonversiViewRiqqi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KonversiViewRiqqi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KonversiViewRiqqi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KonversiViewRiqqi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KonversiViewRiqqi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup cetak;
    private javax.swing.JList<String> history;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton konversi;
    private javax.swing.JComboBox<String> kurs1;
    private javax.swing.JComboBox<String> kurs2;
    private javax.swing.JTextField nominal;
    private javax.swing.JRadioButton tidak;
    private javax.swing.JRadioButton ya;
    // End of variables declaration//GEN-END:variables
}
