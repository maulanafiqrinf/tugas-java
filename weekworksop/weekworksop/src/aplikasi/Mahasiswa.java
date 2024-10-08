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
public class Mahasiswa extends javax.swing.JFrame {

    public Statement st;
    public ResultSet rs;

    public DefaultTableModel tabmodel;
    Connection cn = database.koneksi.getkoneksi();

    /**
     * Creates new form mahasiswa
     */
    public Mahasiswa() {
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
            rs = st.executeQuery("select * from mahasiswa");
            while (rs.next()) {
                Object[] data = {
                    rs.getString("NIM"),
                    rs.getString("nama_mhs"),
                    rs.getString("jk"),
                    rs.getString("no_hp"),
                    rs.getString("alamat")
                };
                tabmodel.addRow(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void judul() {
        Object[] judul = {"NIM", "nama mahasiswa", "jenis kelamin", "no hp", "alamat"};
        tabmodel = new DefaultTableModel(null, judul);
        tbl_data.setModel(tabmodel);
    }

    public void ulang() {
        NIM.setText("");
        nama_mhs.setText("");
        jk.setSelectedItem("");
        no_hp.setText("");
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
        NIM = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nama_mhs = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        no_hp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jk = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamat = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_data = new javax.swing.JTable();
        simpan = new javax.swing.JButton();
        batal = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        SRCH = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("NIM");

        NIM.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nama Mahasiswa");

        nama_mhs.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Jenis Kelamin");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("No HP");

        no_hp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Alamat");

        jk.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-laki", "Perempuan" }));

        alamat.setColumns(20);
        alamat.setRows(5);
        jScrollPane1.setViewportView(alamat);

        tbl_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tbl_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dataMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_data);

        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        batal.setText("batal");
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });

        edit.setText("edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        SRCH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SRCHKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SRCH, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(simpan)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(106, 106, 106)
                                    .addComponent(NIM))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel6))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(no_hp, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nama_mhs, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(batal, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(edit)
                                .addGap(89, 89, 89)
                                .addComponent(hapus))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(SRCH, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(NIM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nama_mhs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(no_hp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane1)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(simpan)
                    .addComponent(batal)
                    .addComponent(edit)
                    .addComponent(hapus))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
        if ("".equals(NIM.getText()) || "".equals(nama_mhs.getText()) || "".equals(jk.getSelectedItem()) || "".equals(no_hp.getText()) || "".equals(alamat.getText())) {
            JOptionPane.showMessageDialog(null, "Lengkapi data!");
        } else {
            try {
                st = cn.createStatement();
                st.executeUpdate("insert into mahasiswa set " + "NIM = '" + NIM.getText() + "', nama_mhs= '" + nama_mhs.getText() + "', jk='" + jk.getSelectedItem()
                        + "', no_hp='" + no_hp.getText() + "', alamat = '" + alamat.getText() + "';");
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
        if ("".equals(NIM.getText()) || "".equals(nama_mhs.getText()) || "".equals(jk.getSelectedItem()) || "".equals(no_hp.getText()) || "".equals(alamat.getText())) {
            JOptionPane.showMessageDialog(null, "Isi semua Kolom");
        } else {
            try {
                st = cn.createStatement();
                st.executeUpdate("update mahasiswa set " + "NIM='" + NIM.getText() + "',"
                        + "nama_mhs='" + nama_mhs.getText() + "',"
                        + "jk='" + jk.getSelectedItem() + "',"
                        + "no_hp='" + no_hp.getText() + "'," + "alamat='" + alamat.getText() + "' where NIM='"
                        + tabmodel.getValueAt(tbl_data.getSelectedRow(), 0) + "';");
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
        if ("".equals(NIM.getText()) || "".equals(nama_mhs.getText()) || "".equals(jk.getSelectedItem()) || "".equals(no_hp.getText()) || "".equals(alamat.getText())) {
            JOptionPane.showMessageDialog(null, "Pilih Terlebih dahulu");
        } else {
            try {
                int jawab;
                if ((jawab = JOptionPane.showConfirmDialog(null, "Hapus ?", "konfirmasi", JOptionPane.YES_NO_OPTION)) == 0) {
                    st.executeUpdate("delete from mahasiswa where " + "NIM='" + tabmodel.getValueAt(tbl_data.getSelectedRow(), 0) + "'");
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
        if ("".equals(NIM.getText()) || "".equals(nama_mhs.getText()) || "".equals(jk.getSelectedItem()) || "".equals(no_hp.getText()) || "".equals(alamat.getText())) {
            JOptionPane.showMessageDialog(null, "Isi semua Kolom");
        } else {
            try {
                st = cn.createStatement();
                st.executeUpdate("update mahasiswa set " + "NIM='" + NIM.getText() + "',"
                        + "nama_mhs='" + nama_mhs.getText() + "',"
                        + "jk='" + jk.getSelectedItem() + "',"
                        + "no_hp='" + no_hp.getText() + "'," + "alamat='" + alamat.getText() + "' where NIM='"
                        + tabmodel.getValueAt(tbl_data.getSelectedRow(), 0) + "';");
                tampildata();
                ulang();

                JOptionPane.showMessageDialog(null, "Berhasil");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal diupdate! " + e.getMessage());
            }
        }
    }//GEN-LAST:event_batalActionPerformed

    private void tbl_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dataMouseClicked
        // TODO add your handling code here:
        NIM.setText(tabmodel.getValueAt(tbl_data.getSelectedRow(), 0) + "");
        nama_mhs.setText(tabmodel.getValueAt(tbl_data.getSelectedRow(), 1) + "");
        jk.setSelectedItem(tabmodel.getValueAt(tbl_data.getSelectedRow(), 2) + "");
        no_hp.setText(tabmodel.getValueAt(tbl_data.getSelectedRow(), 3) + "");
        alamat.setText(tabmodel.getValueAt(tbl_data.getSelectedRow(), 4)+ "");
        simpan.setEnabled(false);
        edit.setEnabled(true);
        hapus.setEnabled(true);
        
        simpan.setEnabled(false);
    }//GEN-LAST:event_tbl_dataMouseClicked

    private void SRCHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SRCHKeyReleased
        // TODO add your handling code here:
                         try {
            st = cn.createStatement();
            tabmodel.getDataVector().removeAllElements();
            tabmodel.fireTableDataChanged();
            rs = st.executeQuery("select * from mahasiswa where NIM like '%" + SRCH.getText() + "%' or nama_mhs like '%" + SRCH.getText() + "%' or no_hp like '%" + SRCH.getText() + "%' " );
            while (rs.next()){
                Object[] data = {
                    rs.getString("NIM"),
                    rs.getString("nama_mhs"),
                    rs.getString("no_hp"),
                };
                tabmodel.addRow(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_SRCHKeyReleased

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
            java.util.logging.Logger.getLogger(Mahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mahasiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NIM;
    private javax.swing.JTextField SRCH;
    private javax.swing.JTextArea alamat;
    private javax.swing.JButton batal;
    private javax.swing.JButton edit;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jk;
    private javax.swing.JTextField nama_mhs;
    private javax.swing.JTextField no_hp;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tbl_data;
    // End of variables declaration//GEN-END:variables
}
