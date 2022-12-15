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
  //2 buat parameter user
  public BarangViewRiqqi(String user) {
    //3 masukin prop
    kodeUser = getUser(user);
    System.out.println("kode user yang di bawa ke tabel barang adalah " + kodeUser);
    initComponents();
    bersih();
    tampilkan();
  }
  //1 buat properti
  public String kodeUser;

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

  //buat function untuk mendapatkan kode user pokok terserah penting buat ambil data kode
  public String getUser(String user) {
//    Koneksi konek = new Koneksi(); buatnya yang ini temen2
    koneksi();
    try {
      rs = st.executeQuery("SELECT * FROM user_riqqi WHERE username = '" + user + "'");
      if (rs.next()) {
        return rs.getString("kode_user");
      }
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
    return "kosong";
  }

  public void tampilkan() {
    koneksi();
    dt = (DefaultTableModel) tabelBarang.getModel();

    try {
      rs = st.executeQuery("SELECT * FROM barang_tampil_view");
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
          rs.getString("jumlah"),
          rs.getString("harga"),
          rs.getString("stok_minimum"),
          rs.getString("kualitas"),
          rs.getString("username"),});
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
              || tStok.getText().isBlank()
              || cSatuan.getSelectedIndex() == 0
              || tJumlah.getText().equals("0")
              || kodeUser.equals("kosong")
              || tHarga.getText().equals("0")) {
        JOptionPane.showMessageDialog(this, "GA BOLEH KOSONG", "PESAN", JOptionPane.ERROR_MESSAGE);
      } else {
        st.executeUpdate("INSERT INTO barang_riqqi VALUES"
                + "('" + tKode.getText() + "','"
                + tNama.getText() + "','"
                + cSatuan.getSelectedItem().toString() + "','"
                + tJumlah.getText() + "','"
                + tHarga.getText() + "','"
                + tStok.getText() + "','"
                + cKualitas.getSelectedItem().toString() + "','"
                + kodeUser + "')");
        JOptionPane.showMessageDialog(this, "DATA BERHASIL DIINPUT", "PESAN", JOptionPane.INFORMATION_MESSAGE);
        bersih();
        tampilkan();
      }
    } catch (SQLException e) {

      if (e.getErrorCode() == 1366) {
        JOptionPane.showMessageDialog(this, "FIELD HARGA, JUMLAH DAN STOK HARUS BERUPA ANGKA");
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
    tStok.setText("");
    cSatuan.setSelectedIndex(0);
    cKualitas.setSelectedIndex(0);
    tKode.requestFocus();
    btnSimpan.setText("SIMPAN");
    btnSimpan.setEnabled(true);
    tKode.setEnabled(true);
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
    tKode.setEnabled(false);
    try {
      st.executeUpdate("UPDATE barang_riqqi SET "
              + "nama = '" + tNama.getText() + "',"
              + "satuan = '" + cSatuan.getSelectedItem().toString() + "',"
              + "jumlah = '" + tJumlah.getText() + "',"
              + "harga = '" + tHarga.getText() + "',"
              + "stok_minimum = '" + tStok.getText() + "',"
              + "kualitas = '" + cKualitas.getSelectedItem().toString() + "'"
              + "WHERE kode = '" + tKode.getText() + "'");
      JOptionPane.showMessageDialog(this, "DATA BERHASIL DIUBAH", "PESAN", JOptionPane.INFORMATION_MESSAGE);
//            if (hargaLama != tHarga.getText() & !hargaLama.isBlank()) {
//                st.executeUpdate("INSERT INTO data_lama_harga (kode_brg, harga) "
//                        + "VALUES('" + kodeBarang + "','" + hargaLama + "')");
//            }
      bersih();
      tampilkan();
    } catch (SQLException e) {
      if (e.getErrorCode() == 1366) {
        JOptionPane.showMessageDialog(this, "FIELD HARGA DAN JUMLAH HARUS BERUPA ANGKA");
      }
      JOptionPane.showMessageDialog(this, e.getMessage());
    }

  }

  public void klikTabel() {
    int row = tabelBarang.getSelectedRow();
    System.out.println(tabelBarang.getValueAt(row, 7).toString());
    tKode.setText(tabelBarang.getValueAt(row, 1).toString());
    tKode.setEnabled(false);
    tNama.setText(tabelBarang.getValueAt(row, 2).toString());
    cSatuan.setSelectedItem(tabelBarang.getValueAt(row, 3).toString());
    tJumlah.setText(tabelBarang.getValueAt(row, 4).toString());
    tHarga.setText(tabelBarang.getValueAt(row, 5).toString());
    tStok.setText(tabelBarang.getValueAt(row, 6).toString());
    cKualitas.setSelectedItem(tabelBarang.getValueAt(row, 7).toString());
    hargaLama = tHarga.getText();
    btnSimpan.setText("EDIT");
  }

  public void cariKode() {

    try {
      rs = st.executeQuery(
              "SELECT * FROM barang_riqqi WHERE kode = '" + tKode.getText() + "'");
      if (rs.next()) {
        int confirm = JOptionPane.showConfirmDialog(null,
                "KODE BARANG SUDAH ADA ! \n APAKAH INGIN MENGUBAH DATA",
                "PERINGATAN",
                JOptionPane.WARNING_MESSAGE);
        switch (confirm) {
          case 0 -> {
            System.out.println(rs.getString("kualitas"));
            tNama.setText(rs.getString("nama"));
            tJumlah.setText(rs.getString("jumlah"));
            tHarga.setText(rs.getString("harga"));
            tStok.setText(rs.getString("stok_minimum"));
            cSatuan.setSelectedItem(rs.getString("satuan"));
            cKualitas.setSelectedItem(rs.getString("kualitas"));
            btnSimpan.setText("EDIT");
            kodeBarang = tKode.getText();
            hargaLama = tHarga.getText();
          }
          case 1,2 ->
            bersih();
        }
      }
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(this, ex.getMessage());
    }

  }

  public void validasiKualitas() {
    btnSimpan.setEnabled(true);
    if (cKualitas.getSelectedIndex() == 0) {
      int stok = Integer.parseInt(tStok.getText());
      if (stok < 80) {
        JOptionPane.showMessageDialog(this, "KUALITAS BAIK STOK NYA GA BOLEH DIBAWAH 80", "PESAN", JOptionPane.ERROR_MESSAGE);
        tStok.requestFocus();
        btnSimpan.setEnabled(false);
      }
    } else if (cKualitas.getSelectedIndex() == 1) {
      int stok = Integer.parseInt(tStok.getText());
      if (stok < 20 | stok > 79) {
        JOptionPane.showMessageDialog(this, "KUALITAS SEDANG STOK NYA ANTARA 20 - 79", "PESAN", JOptionPane.ERROR_MESSAGE);
        tStok.requestFocus();
        btnSimpan.setEnabled(false);
      }
    } else if (cKualitas.getSelectedIndex() == 2) {
      int stok = Integer.parseInt(tStok.getText());
      if (stok < 0 | stok > 19) {
        JOptionPane.showMessageDialog(this, "KUALITAS KURANG STOK NYA ANTARA 1 - 19", "PESAN", JOptionPane.ERROR_MESSAGE);
        tStok.requestFocus();
        btnSimpan.setEnabled(false);
      }
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

    jLabel7 = new javax.swing.JLabel();
    jLabel8 = new javax.swing.JLabel();
    jPanel1 = new javax.swing.JPanel();
    btnBaru = new javax.swing.JButton();
    jLabel1 = new javax.swing.JLabel();
    btnHapus = new javax.swing.JButton();
    jLabel2 = new javax.swing.JLabel();
    btnSimpan = new javax.swing.JButton();
    jLabel6 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    tStok = new javax.swing.JTextField();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    tKode = new javax.swing.JTextField();
    tNama = new javax.swing.JTextField();
    cSatuan = new javax.swing.JComboBox<>();
    tJumlah = new javax.swing.JTextField();
    tHarga = new javax.swing.JTextField();
    jScrollPane1 = new javax.swing.JScrollPane();
    tabelBarang = new javax.swing.JTable();
    jLabel9 = new javax.swing.JLabel();
    cKualitas = new javax.swing.JComboBox<>();

    jLabel7.setText("jLabel7");

    jLabel8.setText("jLabel8");

    setClosable(true);
    setMaximizable(true);
    setResizable(true);
    setTitle("Form Barang");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 0, Short.MAX_VALUE)
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 200, Short.MAX_VALUE)
    );

    btnBaru.setText("BARU");
    btnBaru.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnBaruActionPerformed(evt);
      }
    });

    jLabel1.setText("Kode");

    btnHapus.setText("HAPUS");
    btnHapus.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnHapusActionPerformed(evt);
      }
    });

    jLabel2.setText("Nama");

    btnSimpan.setText("SIMPAN");
    btnSimpan.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnSimpanActionPerformed(evt);
      }
    });

    jLabel6.setText("Stok Minimum");

    jLabel3.setText("Satuan");

    jLabel4.setText("Jumlah");

    jLabel5.setText("Harga");

    tKode.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusLost(java.awt.event.FocusEvent evt) {
        tKodeFocusLost(evt);
      }
    });
    tKode.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        tKodeActionPerformed(evt);
      }
    });

    cSatuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----- pilih -----", "kilo", "liter", "box" }));

    tJumlah.setText("0");

    tHarga.setText("0");

    tabelBarang.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "NO", "KODE", "NAMA", "SATUAN", "JUMLAH", "HARGA", "STOK MIN", "KUALITAS", "username"
      }
    ));
    tabelBarang.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        tabelBarangMouseClicked(evt);
      }
    });
    jScrollPane1.setViewportView(tabelBarang);

    jLabel9.setText("Kualitas");

    cKualitas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "baik", "sedang", "kurang" }));
    cKualitas.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(java.awt.event.FocusEvent evt) {
        cKualitasFocusGained(evt);
      }
      public void focusLost(java.awt.event.FocusEvent evt) {
        cKualitasFocusLost(evt);
      }
    });
    cKualitas.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cKualitasActionPerformed(evt);
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addComponent(btnBaru)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSimpan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHapus)
                .addGap(404, 404, 404))
              .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel3)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(cSatuan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel4)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(tJumlah))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel2)
            .addGap(15, 15, 15)
            .addComponent(tNama))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addGap(18, 18, 18)
            .addComponent(tKode))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(tHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jLabel6)
                  .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  .addComponent(tStok)
                  .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(cKualitas, 0, 79, Short.MAX_VALUE)))))
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                  .addComponent(jLabel1)
                  .addComponent(tKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                  .addComponent(tNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3))
              .addComponent(cSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel4)
              .addComponent(tJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel5)
                .addComponent(tHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addComponent(jLabel6)))
          .addComponent(tStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(0, 22, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(jLabel9)
              .addComponent(cKualitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(15, 15, 15)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(btnBaru)
              .addComponent(btnSimpan)
              .addComponent(btnHapus))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
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
        tStok.setText(rs.getString("stok_minimum"));
        cSatuan.setSelectedItem(rs.getString("satuan"));
        cKualitas.setSelectedItem(rs.getString("kualitas"));
        btnSimpan.setText("EDIT");
        kodeBarang = tKode.getText();
        hargaLama = tHarga.getText();

      }

    } catch (SQLException e) {
      JOptionPane.showMessageDialog(this, e.getMessage());
    }
    }//GEN-LAST:event_tKodeActionPerformed

    private void tabelBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelBarangMouseClicked
    klikTabel();
    }//GEN-LAST:event_tabelBarangMouseClicked

    private void tKodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tKodeFocusLost
    cariKode();
    }//GEN-LAST:event_tKodeFocusLost

    private void cKualitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cKualitasActionPerformed

    }//GEN-LAST:event_cKualitasActionPerformed

    private void cKualitasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cKualitasFocusLost
    validasiKualitas();
    }//GEN-LAST:event_cKualitasFocusLost

    private void cKualitasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cKualitasFocusGained
    // TODO add your handling code here:
    }//GEN-LAST:event_cKualitasFocusGained

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnBaru;
  private javax.swing.JButton btnHapus;
  private javax.swing.JButton btnSimpan;
  private javax.swing.JComboBox<String> cKualitas;
  private javax.swing.JComboBox<String> cSatuan;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTextField tHarga;
  private javax.swing.JTextField tJumlah;
  private javax.swing.JTextField tKode;
  private javax.swing.JTextField tNama;
  private javax.swing.JTextField tStok;
  private javax.swing.JTable tabelBarang;
  // End of variables declaration//GEN-END:variables
}
