/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi;

import com.mysql.jdbc.RowData;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class dosen extends javax.swing.JFrame {

    public Statement st;
    public ResultSet rs;

    public DefaultTableModel tabmodel;
    Connection cn = database.koneksi.getkoneksi();

    /**
     * Creates new form dosen
     */
    public dosen() {
        initComponents();
        judul();
        tampildata();
        ulang();
    }

    public void tampildata() {
        try {
            st = cn.createStatement();
            tabmodel.getDataVector().removeAllElements();
            tabmodel.fireTableDataChanged();
            rs = st.executeQuery("select * from dosen");
            while (rs.next()) {
                Object[] data = {
                    rs.getString("NIP"),
                    rs.getString("nama_dosen"),
                    rs.getString("jk"),
                    rs.getString("nohandphone"),
                    rs.getString("alamat")
                };
                tabmodel.addRow(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void judul() {
        Object[] judul = {"NIP", "nama Dosen", "jenis kelamin", "no hp", "alamat"};
        tabmodel = new DefaultTableModel(null, judul);
        tbl_ds.setModel(tabmodel);
    }

    public void ulang() {
        NIP.setText("");
        nama_dosen.setText("");
        jk.setSelectedItem("");
        nohandphone.setText("");
        alamat.setText("");
        simpan.setEnabled(true);
        edit.setEnabled(false);
        hapus.setEnabled(false);
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
        NIP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nama_dosen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nohandphone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_ds = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        alamat = new javax.swing.JTextArea();
        search = new javax.swing.JTextField();
        simpan = new javax.swing.JButton();
        batal = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        jk = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("NIP");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 114, -1, -1));

        NIP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(NIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 108, 160, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nama Dosen");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 155, -1, -1));

        nama_dosen.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(nama_dosen, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 149, 160, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Jenis Kelamin");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 199, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("No HP");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 243, -1, -1));

        nohandphone.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(nohandphone, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 170, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Alamat");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 287, -1, -1));

        tbl_ds.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_ds.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_ds);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 111, 415, 280));

        alamat.setColumns(20);
        alamat.setRows(5);
        jScrollPane2.setViewportView(alamat);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 287, 170, -1));

        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });
        getContentPane().add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(632, 59, 148, 31));

        simpan.setText("simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });
        getContentPane().add(simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 402, 75, -1));

        batal.setText("batal");
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });
        getContentPane().add(batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 402, 79, -1));

        edit.setText("edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        getContentPane().add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(536, 402, 83, -1));

        hapus.setText("hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });
        getContentPane().add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(701, 402, 79, -1));

        jk.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-laki", "Perempuan" }));
        getContentPane().add(jk, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 196, 103, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
        if ("".equals(NIP.getText()) || "".equals(nama_dosen.getText()) || "".equals(jk.getSelectedItem()) || "".equals(nohandphone.getText()) || "".equals(alamat.getText())) {
            JOptionPane.showMessageDialog(null, "Lengkapi data!");
        } else {
            try {
                st = cn.createStatement();
                st.executeUpdate("insert into dosen set " + "NIP = '" + NIP.getText() + "', nama_dosen= '" + nama_dosen.getText() + "', jk='" + jk.getSelectedItem()
                        + "', nohandphone='" + nohandphone.getText() + "', alamat = '" + alamat.getText() + "';");
                tampildata();
                ulang();

                JOptionPane.showMessageDialog(null, "Berhasil");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        if ("".equals(NIP.getText()) || "".equals(nama_dosen.getText()) || "".equals(jk.getSelectedItem()) || "".equals(nohandphone.getText()) || "".equals(alamat.getText())) {
            JOptionPane.showMessageDialog(null, "Isi semua Kolom");
        } else {
            try {
                st = cn.createStatement();
                st.executeUpdate("update dosen set " + "NIP='" + NIP.getText() + "',"
                        + "nama_dosen='" + nama_dosen.getText() + "',"
                        + "jk='" + jk.getSelectedItem() + "',"
                        + "nohandphone='" + nohandphone.getText() + "'," + "alamat='" + alamat.getText() + "' where NIP='"
                        + tabmodel.getValueAt(tbl_ds.getSelectedRow(), 0) + "';");
                tampildata();
                ulang();
                JOptionPane.showMessageDialog(null, "Berhasil");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal diupdate! " + e.getMessage());
            }
        }
    }//GEN-LAST:event_editActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        if ("".equals(NIP.getText()) || "".equals(nama_dosen.getText()) || "".equals(jk.getSelectedItem()) || "".equals(nohandphone.getText()) || "".equals(alamat.getText())) {
            JOptionPane.showMessageDialog(null, "Pilih Terlebih dahulu");
        } else {
            try {
                int jawab;
                if ((jawab = JOptionPane.showConfirmDialog(null, "Hapus ?", "konfirmasi", JOptionPane.YES_NO_OPTION)) == 0) {
                    st.executeUpdate("delete from dosen where " + "NIP='" + tabmodel.getValueAt(tbl_ds.getSelectedRow(), 0) + "'");
                    tampildata();
                    ulang();
                    JOptionPane.showMessageDialog(null, "Berhasil dihapus");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal diHapus! " + e.getMessage());
            }
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        // TODO add your handling code here:
        if ("".equals(NIP.getText()) || "".equals(nama_dosen.getText()) || "".equals(jk.getSelectedItem()) || "".equals(nohandphone.getText()) || "".equals(alamat.getText())) {
            JOptionPane.showMessageDialog(null, "Isi semua Kolom");
        } else {
            try {
                st = cn.createStatement();
                st.executeUpdate("update dosen set " + "NIP='" + NIP.getText() + "',"
                        + "nama_dosen='" + nama_dosen.getText() + "',"
                        + "jk='" + jk.getSelectedItem() + "',"
                        + "nohandphone='" + nohandphone.getText() + "'," + "alamat='" + alamat.getText() + "' where NIP='"
                        + tabmodel.getValueAt(tbl_ds.getSelectedRow(), 0) + "';");
                tampildata();
                ulang();

                JOptionPane.showMessageDialog(null, "Berhasil");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal diupdate! " + e.getMessage());
            }
        }
    }//GEN-LAST:event_batalActionPerformed

    private void tbl_dsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dsMouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        NIP.setText(tabmodel.getValueAt(tbl_ds.getSelectedRow(), 0) + "");
        nama_dosen.setText(tabmodel.getValueAt(tbl_ds.getSelectedRow(), 1) + "");
        jk.setSelectedItem(tabmodel.getValueAt(tbl_ds.getSelectedRow(), 2) + "");
        nohandphone.setText(tabmodel.getValueAt(tbl_ds.getSelectedRow(), 3) + "");
        alamat.setText(tabmodel.getValueAt(tbl_ds.getSelectedRow(), 4) + "");
        simpan.setEnabled(false);
        edit.setEnabled(true);
        hapus.setEnabled(true);

        simpan.setEnabled(false);
    }//GEN-LAST:event_tbl_dsMouseClicked

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        // TODO add your handling code here:
        try {
            st = cn.createStatement();
            tabmodel.getDataVector().removeAllElements();
            tabmodel.fireTableDataChanged();
            rs = st.executeQuery("select * from dosen where NIP like '%" + search.getText() + "%' or nama_dosen like '%" + search.getText() + "%' or nohandphone like '%" + search.getText() + "%' ");
            while (rs.next()) {
                Object[] data = {
                    rs.getString("NIP"),
                    rs.getString("nama_dosen"),
                    rs.getString("nohandphone"),};
                tabmodel.addRow(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_searchKeyReleased

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
            java.util.logging.Logger.getLogger(dosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dosen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NIP;
    private javax.swing.JTextArea alamat;
    private javax.swing.JButton batal;
    private javax.swing.JButton edit;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jk;
    private javax.swing.JTextField nama_dosen;
    private javax.swing.JTextField nohandphone;
    private javax.swing.JTextField search;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tbl_ds;
    // End of variables declaration//GEN-END:variables
}
