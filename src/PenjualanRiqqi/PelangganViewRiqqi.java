/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package PenjualanRiqqi;

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
public class PelangganViewRiqqi extends javax.swing.JInternalFrame {

    /**
     * Creates new form PelangganViewRiqqi
     */
    public PelangganViewRiqqi() {
        initComponents();
    }
    public Connection cn;
    public Statement st;
    public ResultSet rs;

    public void koneksi() {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/penjualan_db_riqqi";
            String user = "root";
            String pass = "";

            Class.forName(driver);
            if (cn == null) {
                try {
                    cn = DriverManager.getConnection(url, user, pass);
                    st = cn.createStatement();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    public void simpan() {
        koneksi();
        try {
            if (tKode.getText().isBlank()
                    || tNama.getText().isBlank()
                    || tEmail.getText().isBlank()
                    || tAlamat.getText().isBlank()) {
                JOptionPane.showMessageDialog(this, "GA BOLEH KOSONG", "PESAN", JOptionPane.ERROR_MESSAGE);
            } else {
                st.executeUpdate("INSERT INTO pelanggan_riqqi VALUES"
                        + "('" + tKode.getText() + "','"
                        + tNama.getText() + "','"
                        + tEmail.getText() + "','"
                        + tAlamat.getText() + "')");
                JOptionPane.showMessageDialog(this, "DATA BERHASIL DIINPUT", "PESAN", JOptionPane.INFORMATION_MESSAGE);
                bersih();
            }
        } catch (SQLException e) {
            switch (e.getErrorCode()) {
                case 1062 -> {
                    int confirm = JOptionPane.showConfirmDialog(null,
                            "KODE BARANG SUDAH ADA ! \n APAKAH INGIN MENGUBAH DATA",
                            "PERINGATAN",
                            JOptionPane.WARNING_MESSAGE);
                    switch (confirm) {
                        case 0 ->
                            ubah();
                        case 1,2 ->
                            bersih();
                    }
                }
                case 1366 ->
                    JOptionPane.showMessageDialog(this, "FIELD HARGA DAN JUMLAH HARUS BERUPA ANGKA");
                default ->
                    JOptionPane.showMessageDialog(this, e.getErrorCode());
            }
        }

    }

    public void bersih() {
        tKode.setText("");
        tNama.setText("");
        tEmail.setText("");
        tAlamat.setText("");
        tKode.requestFocus();
    }

    public void hapus() {
        koneksi();
        try {
            rs = st.executeQuery(
                    "SELECT * FROM pelanggan_riqqi WHERE kode = '" + tKode.getText() + "'");
            if (tKode.getText().isBlank()) {
                JOptionPane.showMessageDialog(this, "GA BISA HAPUS DATA KOSONG", "PESAN", JOptionPane.ERROR_MESSAGE);
            } else if (rs.next()) {
                int yakin = JOptionPane.showConfirmDialog(this, "YAKIN INGIN HAPUS DATA INI?");
                switch (yakin) {
                    case 0 -> {
                        st.executeUpdate("DELETE FROM pelanggan_riqqi WHERE kode = '" + tKode.getText() + "'");
                        bersih();
                        JOptionPane.showMessageDialog(this, "DATA BERHASIL DIHAPUS", "PESAN", JOptionPane.INFORMATION_MESSAGE);
                    }
                    case 1,2 ->
                        JOptionPane.showMessageDialog(this, "OKE GAK JADI HAPUS DATA", "PESAN", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "KODE TIDAK TERDAFTAR", "PESAN", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getErrorCode()
                    + " : " + e.getMessage()
            );
        }
    }

    public void ubah() {
        koneksi();
        try {
            st.executeUpdate("UPDATE pelanggan_riqqi SET "
                    + "nama = '" + tNama.getText() + "',"
                    + "email = '" + tEmail.getText() + "',"
                    + "alamat = '" + tAlamat.getText() + "'"
                    + "WHERE kode = '" + tKode.getText() + "'");
            JOptionPane.showMessageDialog(this, "DATA BERHASIL DIUBAH", "PESAN", JOptionPane.INFORMATION_MESSAGE);
            bersih();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tKode = new javax.swing.JTextField();
        tAlamat = new javax.swing.JTextField();
        tEmail = new javax.swing.JTextField();
        tNama = new javax.swing.JTextField();
        btnBaru = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Form Pelanggan");

        jLabel1.setText("Kode");

        jLabel2.setText("Nama");

        jLabel3.setText("Email");

        jLabel4.setText("Alamat");

        btnBaru.setText("BARU");
        btnBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBaruActionPerformed(evt);
            }
        });

        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tAlamat)
                                        .addContainerGap())))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tNama, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(btnBaru)
                                .addGap(18, 18, 18)
                                .addComponent(btnSimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnHapus))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(29, 29, 29)
                                .addComponent(tKode, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBaru)
                    .addComponent(btnSimpan)
                    .addComponent(btnHapus))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBaruActionPerformed
        bersih();
    }//GEN-LAST:event_btnBaruActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        simpan();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        hapus();
    }//GEN-LAST:event_btnHapusActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBaru;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField tAlamat;
    private javax.swing.JTextField tEmail;
    private javax.swing.JTextField tKode;
    private javax.swing.JTextField tNama;
    // End of variables declaration//GEN-END:variables
}
