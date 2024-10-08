/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SenjataPUBG_Polymorphism;

import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        Senjata pubg = new Senjata();
        AWM AWM = new AWM();
        M416 M416 = new M416();
        UMP9 UMP9 = new UMP9();
        S12K S12K = new S12K();
        DP28 DP28 = new DP28();
        SKS SKS = new SKS();
        P92 P92 = new P92();

        System.out.print("Masukkan nama Senjata anda = ");
        String namaSenjata = in.next();

        if (namaSenjata.equalsIgnoreCase("AWM")) {
            AWM.Jenis();
            AWM.Nama();
            AWM.Damage();
            AWM.Peluru();
            AWM.Magazinesize();
            AWM.Attachments();
            AWM.Modetembak();
        } else if (namaSenjata.equalsIgnoreCase("M416")) {
            M416.Jenis();
            M416.Nama();
            M416.Damage();
            M416.Peluru();
            M416.Magazinesize();
            M416.Attachments();
            M416.Modetembak();
        } else if (namaSenjata.equalsIgnoreCase("UMP9")) {
            UMP9.Jenis();
            UMP9.Nama();
            UMP9.Damage();
            UMP9.Peluru();
            UMP9.Magazinesize();
            UMP9.Attachments();
            UMP9.Modetembak();
        } else if (namaSenjata.equalsIgnoreCase("S12K")) {
            S12K.Jenis();
            S12K.Nama();
            S12K.Damage();
            S12K.Peluru();
            S12K.Magazinesize();
            S12K.Attachments();
            S12K.Modetembak();
        } else if (namaSenjata.equalsIgnoreCase("DP28")) {
            DP28.Jenis();
            DP28.Nama();
            DP28.Damage();
            DP28.Peluru();
            DP28.Magazinesize();
            DP28.Attachments();
            DP28.Modetembak();
        } else if (namaSenjata.equalsIgnoreCase("P92")) {
            P92.Jenis();
            P92.Nama();
            P92.Damage();
            P92.Peluru();
            P92.Magazinesize();
            P92.Attachments();
            P92.Modetembak();
        } else if (namaSenjata.equalsIgnoreCase("SKS")) {
            SKS.Jenis();
            SKS.Nama();
            SKS.Damage();
            SKS.Peluru();
            SKS.Magazinesize();
            SKS.Attachments();
            SKS.Modetembak();
        }
    }
}
