/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package d_riqqi;

import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Riqqi
 */
public class Biodata0069 extends javax.swing.JFrame {

    /**
     * Creates new form FrameBiodataRiqqi
     */
    public Biodata0069() {
        initComponents();
        tampilkan();
    }

    public Connection cn;
    public Statement st;
    public ResultSet rs;

    public void koneksi() {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/biodata_db_riqqi";
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

    public void tampilkan() {
        koneksi();
        DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();

        try {
            rs = st.executeQuery("SELECT * FROM biodata_riqqi");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

        dt.getDataVector().clear();
        dt.fireTableDataChanged();

        int no = 1;
        try {
            while (rs.next()) {
                dt.addRow(new Object[]{
                    no++,
                    rs.getString("nim"),
                    rs.getString("nama"),
                    rs.getString("jurusan"),
                    rs.getString("email"),
                    rs.getString("alamat")
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        jTable1.setModel(dt);
        btnSimpan.setText("SIMPAN");
        tNim.setEditable(true);
    }

    public void simpan() {
        koneksi();
        try {
            rs = st.executeQuery(
                    "SELECT * FROM biodata_riqqi WHERE nim = '" + tNim.getText() + "'");
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "NIM SUDAH TERDAFTAR !!!", "PESAN", JOptionPane.ERROR_MESSAGE);
            } else if (tNim.getText().isBlank()
                    || tNama.getText().isBlank()
                    || tJurusan.getText().isBlank()
                    || tEmail.getText().isBlank()
                    || tAlamat.getText().isBlank()) {
                JOptionPane.showMessageDialog(this, "GA BOLEH KOSONG", "PESAN", JOptionPane.ERROR_MESSAGE);
            } else {
                st.executeUpdate("INSERT INTO biodata_riqqi VALUES"
                        + "('" + tNim.getText() + "','"
                        + tNama.getText() + "','"
                        + tJurusan.getText() + "','"
                        + tEmail.getText() + "','"
                        + tAlamat.getText() + "')");
                JOptionPane.showMessageDialog(this, "DATA BERHASIL DIINPUT", "PESAN", JOptionPane.INFORMATION_MESSAGE);
                bersih();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }

    public void bersih() {
        tNim.setText("");
        tNama.setText("");
        tJurusan.setText("");
        tEmail.setText("");
        tAlamat.setText("");
        tNim.requestFocus();
    }

    public void hapus() {
        koneksi();
        try {
            rs = st.executeQuery(
                    "SELECT * FROM biodata_riqqi WHERE nim = '" + tNim.getText() + "'");
            if (rs.next()) {
                int yakin = JOptionPane.showConfirmDialog(this, "YAKIN INGIN HAPUS DATA INI?");
                switch (yakin) {
                    case 0:
                        st.executeUpdate("DELETE FROM biodata_riqqi WHERE nim = '" + tNim.getText() + "'");
                        bersih();
                        JOptionPane.showMessageDialog(this, "DATA BERHASIL DIHAPUS", "PESAN", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 1,2:
                        JOptionPane.showMessageDialog(this, "OKE GAK JADI HAPUS DATA", "PESAN", JOptionPane.INFORMATION_MESSAGE);
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(this, "TIDAK BISA MENGHAPUS DATA YANG TIDAK ADA", "PESAN", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    public void ubah() {
        koneksi();
        try {
            rs = st.executeQuery(
                    "SELECT * FROM biodata_riqqi WHERE nim = '" + tNim.getText() + "'");
            if (rs.next()) {

                st.executeUpdate("UPDATE biodata_riqqi SET "
                        + "nama = '" + tNama.getText() + "',"
                        + "jurusan = '" + tJurusan.getText() + "',"
                        + "email = '" + tEmail.getText() + "',"
                        + "alamat = '" + tAlamat.getText() + "'"
                        + "WHERE nim = '" + tNim.getText() + "'");
                JOptionPane.showMessageDialog(this, "DATA BERHASIL DIUBAH", "PESAN", JOptionPane.INFORMATION_MESSAGE);
                bersih();
            } else {
                JOptionPane.showMessageDialog(this, "TIDAK BISA MENGUBAH NIM YANG TIDAK ADA", "PESAN", JOptionPane.ERROR_MESSAGE);
            }

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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tNim = new javax.swing.JTextField();
        tNama = new javax.swing.JTextField();
        tJurusan = new javax.swing.JTextField();
        tEmail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tAlamat = new javax.swing.JTextArea();
        btnSimpan = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnReset = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("FORMULIR BIODATA");

        jLabel2.setText("NIM");

        jLabel3.setText("Nama");

        jLabel4.setText("Jurusan");

        jLabel5.setText("Email");

        jLabel6.setText("Alamat");

        tAlamat.setColumns(20);
        tAlamat.setRows(5);
        jScrollPane1.setViewportView(tAlamat);

        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NO", "NIM", "NAMA", "JURUSAN", "EMAIL", "ALAMAT"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        btnReset.setText("RESET");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnHapus.setText("HAPUS");
        btnHapus.setEnabled(false);
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6))
                            .addGap(34, 34, 34)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tNim)
                                .addComponent(tNama)
                                .addComponent(tJurusan)
                                .addComponent(tEmail)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnReset, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSimpan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnHapus)))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tNim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(tNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSimpan)
                            .addComponent(btnHapus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReset)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        if (btnSimpan.getText() == "SIMPAN") {
            simpan();
            tampilkan();
        } else if (btnSimpan.getText() == "UBAH") {
            ubah();
            tampilkan();
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        if (btnSimpan.getText() == "SIMPAN") {
            bersih();
        } else {
            tNim.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
            tNama.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
            tJurusan.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
            tEmail.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
            tAlamat.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString());
        }
    }//GEN-LAST:event_btnResetActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        tNim.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
        tNama.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
        tJurusan.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
        tEmail.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
        tAlamat.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString());

        btnSimpan.setText("UBAH");
        tNim.setEditable(false);
        btnHapus.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        hapus();
        tampilkan();
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
            java.util.logging.Logger.getLogger(Biodata0069.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Biodata0069.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Biodata0069.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Biodata0069.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        Font font = new Font("Monospaced", Font.PLAIN, 12);
//For MessageArea and TextField font.
        UIManager.put("OptionPane.messageFont", font);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new Biodata0069().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea tAlamat;
    private javax.swing.JTextField tEmail;
    private javax.swing.JTextField tJurusan;
    private javax.swing.JTextField tNama;
    private javax.swing.JTextField tNim;
    // End of variables declaration//GEN-END:variables
}
