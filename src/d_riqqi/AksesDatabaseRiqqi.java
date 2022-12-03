/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package d_riqqi;

import java.awt.event.KeyEvent;
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
public class AksesDatabaseRiqqi extends javax.swing.JFrame {

    /**
     * Creates new form AksesDatabaseRiqqi
     */
    public AksesDatabaseRiqqi() {
        initComponents();
    }
    public Connection cn;
    public Statement st;
    public ResultSet rs;

    public void koneksi() {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/akses_database_riqqi";
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
            System.out.println(ex.getMessage());
        }
    }

    public ResultSet cari(String nim) {
        koneksi();
        try {
            rs = st.executeQuery("SELECT * FROM ipk_riqqi WHERE nim = '" + nim + "'");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        return rs;
    }

    public void simpan() {
        koneksi();
        try {
            if (tNim.getText().isBlank()
                    || tNama.getText().isBlank()
                    || tIpk.getText().isBlank()) {
                JOptionPane.showMessageDialog(this, "GA BOLEH KOSONG", "PESAN", JOptionPane.ERROR_MESSAGE);
            } else {
                st.executeUpdate("INSERT INTO ipk_riqqi VALUES"
                        + "('" + tNim.getText() + "','"
                        + tNama.getText() + "','"
                        + tIpk.getText() + "')");
                JOptionPane.showMessageDialog(this, "DATA BERHASIL DIINPUT", "PESAN", JOptionPane.INFORMATION_MESSAGE);
                bersih();
            }
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
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
            } else if (e.getErrorCode() == 1366) {
                JOptionPane.showMessageDialog(this, "FIELD IPK HARUS BERUPA ANGKA");
            } else {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }

    }

    public void bersih() {
        tNim.setText("");
        tNama.setText("");
        tIpk.setText("");
        tNim.requestFocus();
    }

    public void hapus() {
        koneksi();
        int no = 1;
        try {
            rs = st.executeQuery(
                    "SELECT * FROM ipk_riqqi WHERE nim = '" + tNim.getText() + "'");
            if (tNim.getText().isBlank()) {
                JOptionPane.showMessageDialog(this, "GA BISA HAPUS DATA KOSONG", "PESAN", JOptionPane.ERROR_MESSAGE);
            } else if (rs.next()) {
                int yakin = JOptionPane.showConfirmDialog(this, "ANDA INGIN MENGHAPUS ?", "PESAN =" + no++, JOptionPane.YES_NO_OPTION);
                switch (yakin) {
                    case 0:
                        int yakin2 = JOptionPane.showConfirmDialog(this, "ANDA PASTI MENGHAPUS ?", "PESAN =" + no++, JOptionPane.YES_NO_OPTION);
                        switch (yakin2) {
                            case 0:
                                int yakin3 = JOptionPane.showConfirmDialog(this, "KAMI AKAN MENGHAPUS ?", "PESAN =" + no++, JOptionPane.YES_NO_OPTION);
                                switch (yakin3) {
                                    case 0:
                                        st.executeUpdate("DELETE FROM ipk_riqqi WHERE nim = '" + tNim.getText() + "'");
                                        bersih();
                                        JOptionPane.showMessageDialog(this, "DATA BERHASIL DIHAPUS", "PESAN", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    case 1,2:
                                        JOptionPane.showMessageDialog(this, "OKE GAK JADI HAPUS DATA", "PESAN", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                }
                                break;
                            case 1,2:
                                JOptionPane.showMessageDialog(this, "OKE GAK JADI HAPUS DATA", "PESAN", JOptionPane.INFORMATION_MESSAGE);
                                break;
                        }
                        break;
                    case 1,2:
                        JOptionPane.showMessageDialog(this, "OKE GAK JADI HAPUS DATA", "PESAN", JOptionPane.INFORMATION_MESSAGE);
                        break;
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
            if (tNim.getText().isBlank()
                    || tNama.getText().isBlank()
                    || tIpk.getText().isBlank()) {
                JOptionPane.showMessageDialog(this, "APANYA YANG MAU DIEDIT", "PESAN", JOptionPane.ERROR_MESSAGE);
            } else {

//                arahkan nilai yang akan diedit
                String pilih = "a";
                do {
                    pilih = JOptionPane.showInputDialog(this, "DAFTAR EDIT"
                            + "\n 1. SEMUA DATA"
                            + "\n 2. NAMA SAJA"
                            + "\n 3. IPK"
                            + "\n PILIH [1-3]");
                } while (!(pilih.equals("1") | pilih.equals("2") | pilih.equals("3")));
                switch (pilih) {
                    case "1":
                        st.executeUpdate("UPDATE ipk_riqqi SET "
                                + "nama = '" + tNama.getText() + "',"
                                + "ipk = '" + tIpk.getText() + "'"
                                + "WHERE nim = '" + tNim.getText() + "'");
                        break;
                    case "2":
                        st.executeUpdate("UPDATE ipk_riqqi SET "
                                + "nama = '" + tNama.getText() + "'"
                                + "WHERE nim = '" + tNim.getText() + "'");
                        break;
                    case "3":
                        st.executeUpdate("UPDATE ipk_riqqi SET "
                                + "ipk = '" + tIpk.getText() + "'"
                                + "WHERE nim = '" + tNim.getText() + "'");
                        break;

                }

                JOptionPane.showMessageDialog(this, "DATA BERHASIL DIUBAH", "PESAN", JOptionPane.INFORMATION_MESSAGE);
                bersih();
            }

        } catch (SQLException e) {
            if (e.getErrorCode() == 1366) {
                JOptionPane.showMessageDialog(this, "FIELD IPK HARUS BERUPA ANGKA");
            }
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tNim = new javax.swing.JTextField();
        tNama = new javax.swing.JTextField();
        tIpk = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("NIM");

        jLabel2.setText("NAMA");

        jLabel3.setText("IPK");

        tNim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tNimKeyPressed(evt);
            }
        });

        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnEdit.setText("EDIT");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(23, 23, 23))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tNama)
                            .addComponent(tIpk)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHapus))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addComponent(tNim))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tNim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tIpk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnEdit)
                    .addComponent(btnHapus))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tNimKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tNimKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String iniCari = tNim.getText();
            cari(iniCari);
            try {
                if (rs.next()) {
                    tNama.setText(rs.getString("nama"));
                    tIpk.setText(rs.getString("ipk"));
                } else {
                    JOptionPane.showMessageDialog(this, "DATA TIDAK ADA");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }//GEN-LAST:event_tNimKeyPressed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        try {
            float ipk = Float.parseFloat(tIpk.getText());
            if (ipk < 0 | ipk > 4) {
                JOptionPane.showMessageDialog(this, "NILAI IPK HARUS ANTARA 0 - 4");
            } else {
                simpan();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try {
            float ipk = Float.parseFloat(tIpk.getText());
            if (ipk < 0 | ipk > 4) {
                JOptionPane.showMessageDialog(this, "NILAI IPK HARUS ANTARA 0 - 4");
            } else {
                ubah();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        hapus();
    }//GEN-LAST:event_btnHapusActionPerformed

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
            java.util.logging.Logger.getLogger(AksesDatabaseRiqqi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AksesDatabaseRiqqi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AksesDatabaseRiqqi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AksesDatabaseRiqqi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AksesDatabaseRiqqi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tIpk;
    private javax.swing.JTextField tNama;
    private javax.swing.JTextField tNim;
    // End of variables declaration//GEN-END:variables
}
