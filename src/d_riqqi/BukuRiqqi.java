/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package d_riqqi;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kamelia
 */
public class BukuRiqqi extends javax.swing.JFrame {

    /**
     * Creates new form BukuRiqqi
     */
    public BukuRiqqi() {
        initComponents();
    }

    Connection cn;
    Statement st;
    ResultSet rs;

    public void koneksi() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/akses_database_riqqi";
        String user = "root";
        String pass = "";

        try {
            Class.forName(driver);
            cn = DriverManager.getConnection(url, user, pass);
            st = cn.createStatement();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    public void tampilkan() {

        koneksi();
        DefaultTableModel dt = (DefaultTableModel) tabelBuku.getModel();
        try {
            rs = st.executeQuery("SELECT * FROM buku_riqqi");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

        dt.getDataVector().clear();
        dt.fireTableDataChanged();

        int no = 1;
        try {
            while (rs.next()) {
                dt.addRow(new Object[]{
                    rs.getString("kd_buku"),
                    rs.getString("judul"),
                    rs.getString("penulis"),
                    rs.getString("penerbit"),});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        tabelBuku.setModel(dt);
    }

    public ResultSet cariBuku(String buku) {
        koneksi();
        DefaultTableModel dt = (DefaultTableModel) tabelBuku.getModel();
        try {
            rs = st.executeQuery("SELECT * FROM buku_riqqi WHERE judul LIKE '%" + buku + "%'");
            dt.getDataVector().clear();
            dt.fireTableDataChanged();

            int no = 1;
            try {
                while (rs.next()) {
                    dt.addRow(new Object[]{
                        rs.getString("kd_buku"),
                        rs.getString("judul"),
                        rs.getString("penulis"),
                        rs.getString("penerbit"),});
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
            tabelBuku.setModel(dt);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        return rs;
    }

    public ResultSet cariPenulis(String penulis) {
        koneksi();
        DefaultTableModel dt = (DefaultTableModel) tabelBuku.getModel();
        try {
            rs = st.executeQuery("SELECT * FROM buku_riqqi WHERE penulis LIKE '%" + penulis + "%'");
            dt.getDataVector().clear();
            dt.fireTableDataChanged();

            int no = 1;
            try {
                while (rs.next()) {
                    dt.addRow(new Object[]{
                        rs.getString("kd_buku"),
                        rs.getString("judul"),
                        rs.getString("penulis"),
                        rs.getString("penerbit"),});
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
            tabelBuku.setModel(dt);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        return rs;
    }

    public ResultSet cariPenerbit(String penerbit) {
        koneksi();
        DefaultTableModel dt = (DefaultTableModel) tabelBuku.getModel();
        try {
            rs = st.executeQuery("SELECT * FROM buku_riqqi WHERE penerbit LIKE '%" + penerbit
                    + "%'");
            dt.getDataVector().clear();
            dt.fireTableDataChanged();

            try {
                while (rs.next()) {
                    dt.addRow(new Object[]{
                        rs.getString("kd_buku"),
                        rs.getString("judul"),
                        rs.getString("penulis"),
                        rs.getString("penerbit"),});
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
            tabelBuku.setModel(dt);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        return rs;
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
        tCariBuku = new javax.swing.JTextField();
        btnCariBuku = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelBuku = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        tCariPenerbit = new javax.swing.JTextField();
        btnCariPenerbit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tCariPenulis = new javax.swing.JTextField();
        btnCariPenulis = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setText("Cari Buku");

        btnCariBuku.setText("CARI BUKU");
        btnCariBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariBukuActionPerformed(evt);
            }
        });

        tabelBuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Buku", "Judul", "Penulis", "Penerbit"
            }
        ));
        jScrollPane1.setViewportView(tabelBuku);

        jLabel2.setText("Cari Penerbit");

        btnCariPenerbit.setText("CARI PENERBIT");
        btnCariPenerbit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariPenerbitActionPerformed(evt);
            }
        });

        jLabel3.setText("Cari Penulis");

        btnCariPenulis.setText("CARI PENULIS");
        btnCariPenulis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariPenulisActionPerformed(evt);
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
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(tCariPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tCariBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(25, 25, 25)
                                .addComponent(tCariPenulis, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCariPenerbit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCariBuku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCariPenulis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(228, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tCariBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCariBuku))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tCariPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCariPenerbit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tCariPenulis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCariPenulis))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        tampilkan();
    }//GEN-LAST:event_formComponentShown

    private void btnCariBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariBukuActionPerformed
        cariBuku(tCariBuku.getText());
    }//GEN-LAST:event_btnCariBukuActionPerformed

    private void btnCariPenerbitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariPenerbitActionPerformed
        cariPenerbit(tCariPenerbit.getText());
    }//GEN-LAST:event_btnCariPenerbitActionPerformed

    private void btnCariPenulisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariPenulisActionPerformed
        cariPenulis(tCariPenulis.getText());
    }//GEN-LAST:event_btnCariPenulisActionPerformed

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
            java.util.logging.Logger.getLogger(BukuRiqqi.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BukuRiqqi.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BukuRiqqi.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BukuRiqqi.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BukuRiqqi().setVisible(true);
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCariBuku;
    private javax.swing.JButton btnCariPenerbit;
    private javax.swing.JButton btnCariPenulis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tCariBuku;
    private javax.swing.JTextField tCariPenerbit;
    private javax.swing.JTextField tCariPenulis;
    private javax.swing.JTable tabelBuku;
    // End of variables declaration//GEN-END:variables
}
