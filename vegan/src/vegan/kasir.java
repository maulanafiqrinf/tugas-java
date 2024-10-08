/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vegan;
import java.awt.HeadlessException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import database.Connection;
import database.Parameter;
import database.SetTable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class kasir extends javax.swing.JInternalFrame {
    ResultSet st;
    Connection con;
    Statement rs;
    PreparedStatement ps;
    String sql;
    int old, dec, now;
    String newstock;
    public String date;
    
        private void otomatis() {
        try {
            DateFormat vblnth = new SimpleDateFormat("ddMMYYYY");
            String blnth = vblnth.format(Calendar.getInstance().getTime());

            DateFormat hari = new SimpleDateFormat("dd-MM-YYYY");
            String a = hari.format(Calendar.getInstance().getTime());
             st = con.eksekusiQuery("SELECT MAX(right(kode_transaksi,6)) AS kode_transaksi  "
                    + "FROM penjualan Where tanggal_transaksi like '" +a+ "'");

            while (st.next()) {
                if (st.first() == false) {
                    KodeTransaksi.setText("AP/" +blnth+"/"+ "000001");
                } else {
                    st.last();
                    int auto_id = st.getInt(1) + 1;
                    String no = String.valueOf(auto_id);
                    int NomorJual = no.length();
                    //MENGATUR jumlah 0
                    for (int j = 0; j < 6 - NomorJual; j++) {
                        no = "0" + no;
                    }
                    KodeTransaksi.setText("AP/"+blnth+"/" + no);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());

        }
    }
    
     private void noterakhir() 
       
    {
        try {
            st = con.eksekusiQuery("SELECT *from penjualan order by kode_transaksi desc limit 1 ");
            DateFormat vblnth = new SimpleDateFormat("dd-MM-YYYY");
            String blnth = vblnth.format(Calendar.getInstance().getTime());
            if (!st.next()) {
                KodeTransaksi.setText("UPB/" + blnth + "/" + "000000");
            } else {
                String no = st.getString("kode_transaksi");
                String kosong = "";
                String b = no.substring(0, 10);
                String c = no.substring(11, 17);
                KodeTransaksi.setText(b + "/" + c);
            }
            otomatis();

        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());

        }
    }
 
    
    
    /**
     * Creates new form kasir
     */
    public kasir() {
        con = new database.Connection(new Parameter().HOST_DB,
                new Parameter().USERNAME_DB,
                new Parameter().PASSWORD_DB,
                new Parameter().IPHOST,
                new Parameter().PORT);
        initComponents();
        getTabel();
        getView();
        otomatis();
        Waktu();
    }

        public void getTabel() {
        String column[] = {"kd_minuman", "nama_minuman", "jenis_minuman",
           "harga_jualminuman","jumlah_minuman", "tanggal"};
        st = con.querySelect(column, "minuman");
        table_minuman.setModel(new SetTable(st));
    }

    public void getView() {
        String column[] = {"kd_transaksi", "nama_pembeli", "kd_minuman", "nama_minuman",
            "harga_jual", "jumlah_beli", "total_harga", "tanggal_transaksi","nomor"};
        st = con.querySelect(column, "penjualan");
        TableTransaksi.setModel(new SetTable(st));
    }
       public void getCari() {
        if (TextSearch.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Masukkan yang anda cari !!!");
        } else {
            if (ComboBoxSearch.getSelectedItem().equals("Kode Minuman")) {
                st = con.querySelectAll("medicine", "kd_minuman LIKE '%" + TextSearch.getText() + "%' ");
                table_minuman.setModel(new SetTable(st));
            } else if (ComboBoxSearch.getSelectedItem().equals("Nama Minuman")) {
                st = con.querySelectAll("medicine", "nama_minuman LIKE '%" + TextSearch.getText() + "%' ");
                table_minuman.setModel(new SetTable(st));
            } else if (ComboBoxSearch.getSelectedItem().equals("Jenis Minuman")) {
                st = con.querySelectAll("medicine", "jenis_minuman LIKE '%" + TextSearch.getText() + "%' ");
                table_minuman.setModel(new SetTable(st));
            }
        }
    }

    public void getTambah() {
        if (KodeMinuman.getText().equals("")
                || NamaMinuman.getText().equals("")
                || HargaJualMinuman.getText().equals("")
                || JumlahBeli.getText().equals("")
                || LSubTotal.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Silahkan lengkapi data terlebih dahulu !!! ");

        } else if (KodeTransaksi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Silahkan Masukan Kode Transaksi Secara Unik !!!");

        } else {
            String[] column = {
                "kode_transaksi",
                "Nama_Pembeli",
                "kode_obat",
                "nama_obat",
                "merek_obat",
                "harga_jual",
                "jumlah_beli",
                "total_harga",
                "tanggal_transaksi",
               
               };
            String[] value = {KodeTransaksi.getText(), NamaPembeli.getText(),
                KodeObat.getText(), NamaObat.getText(),
                MerekObat.getText(), HargaJualObat.getText(),
                JumlahBeli.getText(), LSubTotal.getText(),date};
            System.out.println(con.queryInsert("penjualan", column, value));
            try {
                if (!getCheck_stock()) {
                    JOptionPane.showMessageDialog(this, "Stock obat sudah habis");
                } else {
                    getMin();
                    getTabel();
                }
            } catch (SQLException ex) {
                Logger.getLogger(kasir.class.getName()).log(Level.SEVERE, null, ex);
            }
            getSubTotal();
            getTotal();
          
              JumlahBeli.setText("");
              LSubTotal.setText("");
              Kembalian1.setText("");
              Tunai.setText("");
            getView();
           
            /*getCancel();*/
        }
    }

    public boolean getCheck_stock() throws SQLException {
        boolean checkstock;
        st = con.querySelectAll("medicine", "kode_obat='" + KodeObat.getText() + "'");
        while (st.next()) {
            old = st.getInt("jumlah_obat");
        }
        dec = Integer.parseInt(JumlahBeli.getText());
        if (old < dec) {
            checkstock = false;
        } else {
            checkstock = true;
        }
        return checkstock;
    }

    public void getMin() throws SQLException {
        st = con.querySelectAll("medicine", "kode_obat='" + KodeObat.getText() + "'");
        while (st.next()) {
            old = st.getInt("jumlah_obat");
        }
        dec = Integer.parseInt(JumlahBeli.getText());
        now = old - dec;
        newstock = Integer.toString(now);
        String a = String.valueOf(newstock);
        String[] kolom = {"jumlah_obat"};
        String[] isi = {a};
        System.out.println(con.queryUpdate("medicine", kolom, isi, "kode_obat='"
                + KodeObat.getText() + "'"));
    }

    public void getMouseClick() {
        //KodeTransaksi.setText(String.valueOf(TableMedicine.getValueAt(TableMedicine.getSelectedRow(), 0)));
        KodeObat.setText(String.valueOf(TableMedicine.getValueAt(TableMedicine.getSelectedRow(), 0)));
        NamaObat.setText(String.valueOf(TableMedicine.getValueAt(TableMedicine.getSelectedRow(), 1)));
        MerekObat.setText(String.valueOf(TableMedicine.getValueAt(TableMedicine.getSelectedRow(), 4)));
        HargaJualObat.setText(String.valueOf(TableMedicine.getValueAt(TableMedicine.getSelectedRow(), 6)));
        JumlahBeli.setText("");
        LSubTotal.setText("");
        Kembalian1.setText("");
        Tunai.setText("");
    }

    //  Hitungan Hitungannya
    public void getSubTotal() {
        Integer a = Integer.parseInt(HargaJualObat.getText());
        Integer b = Integer.parseInt(JumlahBeli.getText());
        Integer c = a * b;
        LSubTotal.setText(String.valueOf(c));
    }

   
    
     public void getPaymen1() {
        int a = Integer.parseInt(LSubTotal.getText());
        int b = Integer.parseInt(Tunai.getText());
        int c = b - a;
        Kembalian1.setText(String.valueOf(c));
    }
    public void getTotal() {
        st = con.eksekusiQuery("SELECT SUM(total_harga) as total_harga FROM"
                + " penjualan WHERE Kode_Transaksi= '" + KodeTransaksi.getText() + "'");
        try {
            st.next();
            lSubTotal1.setText(st.getString("total_harga"));
        } catch (SQLException ex) {
            Logger.getLogger(Kasir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getPaymen() {
        int a = Integer.parseInt(lSubTotal1.getText());
        int b = Integer.parseInt(Tunai.getText());
        int c = b - a;
        Kembalian1.setText(Integer.toString(c));
    }
public void getCan(){
    NamaPembeli.setText(null);
        NamaPembeli.setText(null);
        KodeObat.setText(null);
        NamaObat.setText(null);
        MerekObat.setText(null);
        HargaJualObat.setText(null);
        JumlahBeli.setText(null);
        Tanggalan.setDate(null);
        LSubTotal.setText(null);
        lSubTotal1.setText(null);
     
    otomatis();
      Waktu();
}
    public void getCancel() {
        NamaPembeli.setText(null);
        NamaPembeli.setText(null);
        KodeObat.setText(null);
        NamaObat.setText(null);
        MerekObat.setText(null);
        HargaJualObat.setText(null);
        JumlahBeli.setText(null);
        Tanggalan.setDate(null);
        LSubTotal.setText(null);
        lSubTotal1.setText(null);
        Tunai.setText(null);
        Kembalian1.setText(null);
          Waktu();
    }

    public void getDelete() {
        String id = String.valueOf(TableTransaksi.getValueAt(TableTransaksi.getSelectedRow(), 9));
        if (JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus data ini", "Peringatan!!!", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            con.queryDelete("penjualan", "Nomor=" + id);
        } else {
            return;
        }
        getTabel();
        getView();
        JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
        getTotal();
        Waktu();
       
         
    
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
        KodeTransaksi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        NamaPembeli = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        KodeMinuman = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        NamaMinuman = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        JumlahBeli = new javax.swing.JTextField();
        HargaJualMinuman = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lSubTotal = new javax.swing.JTextField();
        Kembalian1 = new javax.swing.JTextField();
        Tunai = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        simpan = new javax.swing.JButton();
        LSubTotal = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_minuman = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableTransaksi = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jTextField13 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        ComboBoxSearch = new javax.swing.JComboBox<>();
        TextSearch = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Kode Transaksi");

        KodeTransaksi.setText("jTextField1");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Nama Pembeli");

        NamaPembeli.setText("jTextField1");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Kode Minuman");

        KodeMinuman.setText("jTextField1");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Nama Minuman");

        NamaMinuman.setText("jTextField1");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Harga Jual");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Jumlah Beli");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Tanggal");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("jLabel1");

        jTextField5.setText("jTextField1");

        jTextField6.setText("jTextField1");

        JumlahBeli.setText("jTextField1");

        HargaJualMinuman.setText("jTextField1");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("jLabel1");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Tunai");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Kembalian");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Total Harga");

        lSubTotal.setText("jTextField1");

        Kembalian1.setText("jTextField1");

        Tunai.setText("jTextField1");

        jTextField12.setText("jTextField1");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Rp.");

        simpan.setText("Simpan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(simpan, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(LSubTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jTextField12, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Tunai)
                            .addComponent(Kembalian1)
                            .addComponent(lSubTotal)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(KodeTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addComponent(jTextField5)
                            .addComponent(jTextField6)
                            .addComponent(JumlahBeli)
                            .addComponent(HargaJualMinuman)
                            .addComponent(NamaMinuman)
                            .addComponent(KodeMinuman)
                            .addComponent(NamaPembeli, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(KodeTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(NamaPembeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(KodeMinuman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(NamaMinuman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(HargaJualMinuman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(JumlahBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(LSubTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(Tunai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(Kembalian1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(simpan)
                .addGap(17, 17, 17))
        );

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        table_minuman.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table_minuman);

        TableTransaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(TableTransaksi);

        jButton2.setText("jButton2");

        jTextField13.setText("jTextField13");

        jLabel14.setText("jLabel14");

        jButton3.setText("jButton3");

        ComboBoxSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        TextSearch.setText("jTextField14");

        jButton4.setText("jButton4");

        jButton5.setText("jButton5");

        jButton6.setText("jButton6");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(26, 26, 26)
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel14))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jButton3)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ComboBoxSearch, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TextSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(ComboBoxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(TextSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxSearch;
    private javax.swing.JTextField HargaJualMinuman;
    private javax.swing.JTextField JumlahBeli;
    private javax.swing.JTextField Kembalian1;
    private javax.swing.JTextField KodeMinuman;
    private javax.swing.JTextField KodeTransaksi;
    private javax.swing.JLabel LSubTotal;
    private javax.swing.JTextField NamaMinuman;
    private javax.swing.JTextField NamaPembeli;
    private javax.swing.JTable TableTransaksi;
    private javax.swing.JTextField TextSearch;
    private javax.swing.JTextField Tunai;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField lSubTotal;
    private javax.swing.JButton simpan;
    private javax.swing.JTable table_minuman;
    // End of variables declaration//GEN-END:variables

    private void initComponents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
