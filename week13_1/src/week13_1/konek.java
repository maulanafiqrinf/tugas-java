/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week13_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class konek {
        private static Connection cn;

    public static Connection getkoneksi() {
        if (cn == null) {
            
            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                cn = DriverManager.getConnection("jdbc:mysql://localhost/db_akademik1", "root", "");
                System.out.println("BERHASIL");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return cn;
    }

}
