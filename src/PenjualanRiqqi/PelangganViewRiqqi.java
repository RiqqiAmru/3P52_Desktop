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
import javax.swing.table.DefaultTableModel;

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
        tampilkan();
    }
    public Connection cn;
    public Statement st;
    public ResultSet rs;
    DefaultTableModel dt;
    public String namaLama = "";
    public String alamatLama = "";
    public String emailLama = "";

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

    public void tampilkan() {
        koneksi();
        dt = (DefaultTableModel) tabelPelanggan.getModel();

        try {
            rs = st.executeQuery("SELECT * FROM pelanggan_riqqi");
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
                    rs.getString("kode"),
                    rs.getString("nama"),
                    rs.getString("email"),
                    rs.getString("alamat"),});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        tabelPelanggan.setModel(dt);
        btnSimpan.setText("SIMPAN");
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
                tampilkan();
            }
        } catch (SQLException e) {
            switch (e.getErrorCode()) {

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
        lblNamaLama.setText("");
        lblAlamatLama.setText("");
        lblEmailLama.setText("");
        btnSimpan.setText("SIMPAN");
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
                        tampilkan();
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

            if (lblNamaLama.getText().equalsIgnoreCase(tNama.getText())
                    || lblAlamatLama.getText().equalsIgnoreCase(tAlamat.getText())
                    || lblEmailLama.getText().equalsIgnoreCase(tEmail.getText())) {
                JOptionPane.showMessageDialog(this, "HARUS EDIT SEMUA DATA INI, GABOLE ADA YANG SAMA", "PESAN", JOptionPane.ERROR_MESSAGE);
            } else {
                st.executeUpdate("UPDATE pelanggan_riqqi SET "
                        + "nama = '" + tNama.getText() + "',"
                        + "email = '" + tEmail.getText() + "',"
                        + "alamat = '" + tAlamat.getText() + "'"
                        + "WHERE kode = '" + tKode.getText() + "'");
                JOptionPane.showMessageDialog(this, "DATA BERHASIL DIUBAH", "PESAN", JOptionPane.INFORMATION_MESSAGE);
                tampilkan();
                st.executeUpdate("INSERT INTO data_lama_pelanggan (kode,nama,email,alamat)"
                        + "VALUES ('" + tKode.getText() + "','" + lblNamaLama.getText() + "','" + lblEmailLama.getText() + "','" + lblAlamatLama.getText() + "')");
                bersih();
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
        tKode = new javax.swing.JTextField();
        tAlamat = new javax.swing.JTextField();
        tEmail = new javax.swing.JTextField();
        tNama = new javax.swing.JTextField();
        btnBaru = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelPelanggan = new javax.swing.JTable();
        lblNamaLama = new javax.swing.JLabel();
        lblEmailLama = new javax.swing.JLabel();
        lblAlamatLama = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Form Pelanggan");

        jLabel1.setText("Kode");

        jLabel2.setText("Nama");

        jLabel3.setText("Email");

        jLabel4.setText("Alamat");

        tKode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tKodeActionPerformed(evt);
            }
        });

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

        tabelPelanggan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NO", "KODE", "NAMA", "EMAIL", "ALAMAT"
            }
        ));
        jScrollPane1.setViewportView(tabelPelanggan);

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
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(tNama, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(29, 29, 29)
                                    .addComponent(tKode, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNamaLama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnBaru)
                        .addGap(18, 18, 18)
                        .addComponent(btnSimpan)
                        .addGap(18, 18, 18)
                        .addComponent(btnHapus)
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(tAlamat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmailLama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAlamatLama, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(lblNamaLama, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addComponent(lblEmailLama, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addComponent(lblAlamatLama, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBaru)
                    .addComponent(btnSimpan)
                    .addComponent(btnHapus))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBaruActionPerformed
        bersih();
    }//GEN-LAST:event_btnBaruActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        if (btnSimpan.getText() == "SIMPAN") {
            simpan();
        }
        if (btnSimpan.getText() == "EDIT") {
            ubah();
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        hapus();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void tKodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tKodeActionPerformed
        String kode = tKode.getText();
        koneksi();
        try {
            rs = st.executeQuery("SELECT * FROM pelanggan_riqqi WHERE kode = '" + kode + "'");
            if (rs.next()) {
                tNama.setText(rs.getString("nama"));
                tEmail.setText(rs.getString("email"));
                tAlamat.setText(rs.getString("alamat"));
                btnSimpan.setText("EDIT");
            }
            lblNamaLama.setText(tNama.getText());
            lblAlamatLama.setText(tAlamat.getText());
            lblEmailLama.setText(tEmail.getText());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_tKodeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBaru;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAlamatLama;
    private javax.swing.JLabel lblEmailLama;
    private javax.swing.JLabel lblNamaLama;
    private javax.swing.JTextField tAlamat;
    private javax.swing.JTextField tEmail;
    private javax.swing.JTextField tKode;
    private javax.swing.JTextField tNama;
    private javax.swing.JTable tabelPelanggan;
    // End of variables declaration//GEN-END:variables
}
