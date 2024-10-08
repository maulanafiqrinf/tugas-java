/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vivi.bambang;

import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class ViviBambang {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        hewan game = new hewan();
        kucing kucing = new kucing();
        kelinci kelinci = new kelinci();
        hamster hamster = new hamster();
        anjing anjing = new anjing();

        System.out.print("Masukkan nama Hewan anda = ");
        String namahewan = in.next();

        if (namahewan.equalsIgnoreCase("kucing")) {
            kucing.Nama();
            kucing.Makan();
            kucing.Minum();
            kucing.Mandi();
        } else if (namahewan.equalsIgnoreCase("anjing")) {
            anjing.Nama();
            anjing.Makan();
            anjing.Minum();
            anjing.Mandi();
        } else if (namahewan.equalsIgnoreCase("hamster")) {
            hamster.Nama();
            hamster.Makan();
            hamster.Minum();
            hamster.Mandi();
        } else if (namahewan.equalsIgnoreCase("kelinci")) {
            kelinci.Nama();
            kelinci.Makan();
            kelinci.Minum();
            kelinci.Mandi();
        }
    }
}
