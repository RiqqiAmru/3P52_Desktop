/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package PenjualanRiqqi;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Kamelia
 */
public class MainMenuRiqqi extends javax.swing.JFrame {

    /**
     * Creates new form PenjualanRiqqi
     */
    public MainMenuRiqqi() {
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

        desktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        master = new javax.swing.JMenu();
        iBarang = new javax.swing.JMenuItem();
        iPelanggan = new javax.swing.JMenuItem();
        menuHargaLama = new javax.swing.JMenuItem();
        menuPelangganLama = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 567, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
        );

        master.setText("Master");

        iBarang.setText("Barang");
        iBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iBarangActionPerformed(evt);
            }
        });
        master.add(iBarang);

        iPelanggan.setText("Pelanggan");
        iPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iPelangganActionPerformed(evt);
            }
        });
        master.add(iPelanggan);

        menuHargaLama.setText("Data Harga Lama");
        menuHargaLama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuHargaLamaActionPerformed(evt);
            }
        });
        master.add(menuHargaLama);

        menuPelangganLama.setText("Data Pelanggan Lama");
        menuPelangganLama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPelangganLamaActionPerformed(evt);
            }
        });
        master.add(menuPelangganLama);

        jMenuBar1.add(master);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iBarangActionPerformed
        BarangViewRiqqi barang = new BarangViewRiqqi();
        barang.setVisible(true);
        desktop.add(barang);
        try {
            barang.setSelected(true);
        } catch (PropertyVetoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_iBarangActionPerformed

    private void iPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iPelangganActionPerformed
        PelangganViewRiqqi pelanggan = new PelangganViewRiqqi();
        pelanggan.setVisible(true);
        desktop.add(pelanggan);
        try {
            pelanggan.setSelected(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_iPelangganActionPerformed

    private void menuHargaLamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuHargaLamaActionPerformed
        DataLamaHarga dtl = new DataLamaHarga();
        dtl.setVisible(true);
        desktop.add(dtl);
        try {
            dtl.setSelected(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_menuHargaLamaActionPerformed

    private void menuPelangganLamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPelangganLamaActionPerformed
        DataLamaPelanggan dtl = new DataLamaPelanggan();
        dtl.setVisible(true);
        desktop.add(dtl);
        try {
            dtl.setSelected(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_menuPelangganLamaActionPerformed

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
            java.util.logging.Logger.getLogger(MainMenuRiqqi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenuRiqqi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenuRiqqi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenuRiqqi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenuRiqqi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenuItem iBarang;
    private javax.swing.JMenuItem iPelanggan;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu master;
    private javax.swing.JMenuItem menuHargaLama;
    private javax.swing.JMenuItem menuPelangganLama;
    // End of variables declaration//GEN-END:variables
}
