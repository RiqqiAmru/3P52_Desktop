/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package PenjualanRiqqi;

import java.awt.event.*;
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
public class BarangViewRiqqi extends javax.swing.JInternalFrame {

    /**
     * Creates new form NewJInternalFrame
     */
    public BarangViewRiqqi() {
        initComponents();
        bersih();
        tampilkan();
    }
    DefaultTableModel dt;
    public Connection cn;
    public Statement st;
    public Statement st2;
    public ResultSet rs;
    public ResultSet rs2;
    public String kodeBarang = "";
    public String hargaLama = "";

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
                    st2 = cn.createStatement();
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
        dt = (DefaultTableModel) tabelBarang.getModel();

        try {
            rs = st.executeQuery("SELECT * FROM barang_riqqi");
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
                    rs.getString("satuan"),
                    rs.getString("harga"),});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        tabelBarang.setModel(dt);
        btnSimpan.setText("SIMPAN");
    }

    public void simpan() {
        koneksi();
        try {
            if (tKode.getText().isBlank()
                    || tNama.getText().isBlank()
                    || cSatuan.getSelectedIndex() == 0
                    || tJumlah.getText().equals("0")
                    || tHarga.getText().equals("0")) {
                JOptionPane.showMessageDialog(this, "GA BOLEH KOSONG", "PESAN", JOptionPane.ERROR_MESSAGE);
            } else {
                st.executeUpdate("INSERT INTO barang_riqqi VALUES"
                        + "('" + tKode.getText() + "','"
                        + tNama.getText() + "','"
                        + cSatuan.getSelectedItem().toString() + "','"
                        + tJumlah.getText() + "','"
                        + tHarga.getText() + "')");
                JOptionPane.showMessageDialog(this, "DATA BERHASIL DIINPUT", "PESAN", JOptionPane.INFORMATION_MESSAGE);
                bersih();
                tampilkan();
            }
        } catch (SQLException e) {
//            if (e.getErrorCode() == 1062) {
//                int confirm = JOptionPane.showConfirmDialog(null,
//                        "KODE BARANG SUDAH ADA ! \n APAKAH INGIN MENGUBAH DATA",
//                        "PERINGATAN",
//                        JOptionPane.WARNING_MESSAGE);
//                switch (confirm) {
//                    case 0 ->
//                        ubah();
//                    case 1,2 ->
//                        bersih();
//                }
//            } else
            if (e.getErrorCode() == 1366) {
                JOptionPane.showMessageDialog(this, "FIELD HARGA DAN JUMLAH HARUS BERUPA ANGKA");
            } else {
                JOptionPane.showMessageDialog(this, e.getErrorCode());
            }
        }

    }

    public void bersih() {
        tKode.setText("");
        tNama.setText("");
        tHarga.setText("");
        tJumlah.setText("");
        cSatuan.setSelectedIndex(0);
        tKode.requestFocus();
        btnSimpan.setText("SIMPAN");
    }

    public void hapus() {
        koneksi();
        try {
            rs = st.executeQuery(
                    "SELECT * FROM barang_riqqi WHERE kode = '" + tKode.getText() + "'");
            if (tKode.getText().isBlank()) {
                JOptionPane.showMessageDialog(this, "GA BISA HAPUS DATA KOSONG", "PESAN", JOptionPane.ERROR_MESSAGE);
            } else if (rs.next()) {
                int yakin = JOptionPane.showConfirmDialog(this, "YAKIN INGIN HAPUS DATA INI?");
                switch (yakin) {
                    case 0:
                        st.executeUpdate("DELETE FROM barang_riqqi WHERE kode = '" + tKode.getText() + "'");
                        bersih();
                        tampilkan();
                        JOptionPane.showMessageDialog(this, "DATA BERHASIL DIHAPUS", "PESAN", JOptionPane.INFORMATION_MESSAGE);
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
            st.executeUpdate("UPDATE barang_riqqi SET "
                    + "nama = '" + tNama.getText() + "',"
                    + "satuan = '" + cSatuan.getSelectedItem().toString() + "',"
                    + "jumlah = '" + tJumlah.getText() + "',"
                    + "harga = '" + tHarga.getText() + "'"
                    + "WHERE kode = '" + tKode.getText() + "'");
            JOptionPane.showMessageDialog(this, "DATA BERHASIL DIUBAH", "PESAN", JOptionPane.INFORMATION_MESSAGE);
            st.executeUpdate("INSERT INTO data_lama_harga (kode_brg, harga) "
                    + "VALUES('" + kodeBarang + "','" + hargaLama + "')");
            bersih();
            tampilkan();
        } catch (SQLException e) {
            if (e.getErrorCode() == 1366) {
                JOptionPane.showMessageDialog(this, "FIELD HARGA DAN JUMLAH HARUS BERUPA ANGKA");
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tKode = new javax.swing.JTextField();
        tNama = new javax.swing.JTextField();
        cSatuan = new javax.swing.JComboBox<>();
        tJumlah = new javax.swing.JTextField();
        tHarga = new javax.swing.JTextField();
        btnBaru = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        lblHargaLama = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelBarang = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Form Barang");

        jLabel1.setText("Kode");

        jLabel2.setText("Nama");

        jLabel3.setText("Satuan");

        jLabel4.setText("Jumlah");

        jLabel5.setText("Harga");

        tKode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tKodeActionPerformed(evt);
            }
        });

        cSatuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----- pilih -----", "kilo", "liter", "box" }));

        tJumlah.setText("0");

        tHarga.setText("0");

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

        tabelBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NO", "KODE", "NAMA", "SATUAN", "HARGA"
            }
        ));
        jScrollPane1.setViewportView(tabelBarang);

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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cSatuan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tJumlah))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(tHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblHargaLama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(136, 136, 136)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(15, 15, 15)
                                .addComponent(tNama))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnBaru)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHapus)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(tKode)))
                        .addGap(10, 10, 10))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3))
                    .addComponent(cSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(tHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblHargaLama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBaru)
                    .addComponent(btnSimpan)
                    .addComponent(btnHapus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(301, 301, 301))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBaruActionPerformed
        bersih();
    }//GEN-LAST:event_btnBaruActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        hapus();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        if (btnSimpan.getText() == "SIMPAN") {
            simpan();
        }
        if (btnSimpan.getText() == "EDIT") {
            ubah();
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void tKodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tKodeActionPerformed
        String kode = tKode.getText();
        koneksi();
        try {
            rs = st.executeQuery("SELECT * FROM barang_riqqi WHERE kode = '" + kode + "'");
            if (rs.next()) {
                tNama.setText(rs.getString("nama"));
                tJumlah.setText(rs.getString("jumlah"));
                tHarga.setText(rs.getString("harga"));
                cSatuan.setSelectedItem(rs.getString("satuan"));
                btnSimpan.setText("EDIT");
                kodeBarang = tKode.getText();
                hargaLama = tHarga.getText();

            }
            String iniLabelHargaLama = "";
            rs2 = st2.executeQuery("SELECT * FROM data_lama_harga WHERE kode_brg = '" + kode + "' ORDER BY no DESC");
            while (rs2.next()) {
                iniLabelHargaLama += " / " + rs2.getString("harga");
                lblHargaLama.setText(iniLabelHargaLama);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_tKodeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBaru;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> cSatuan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHargaLama;
    private javax.swing.JTextField tHarga;
    private javax.swing.JTextField tJumlah;
    private javax.swing.JTextField tKode;
    private javax.swing.JTextField tNama;
    private javax.swing.JTable tabelBarang;
    // End of variables declaration//GEN-END:variables
}
