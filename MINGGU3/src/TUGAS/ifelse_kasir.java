/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas_minggu3;

import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class ifelse_kasir {
    public static void main(String[] args) {
        
        System.out.println("-----------------------------------");
        System.out.println("  Kharisma Agung Plaza < KAP > ");
        System.out.println("    Promo Belanja Berhadiah ");
        System.out.println("Khusus Pembelian 5 Barang Pertama ");
        System.out.println(" Dengan harga minimum Rp 10000,00 ");
        System.out.println("-----------------------------------");
        
         Scanner input = new Scanner(System.in);
         String nama;
         int harga1,harga2,harga3,harga4,harga5;
         double Hasil;
         Scanner abc=new
         Scanner(System.in);

 
        System.out.print("Masukkan Nama Pembeli :");
        nama= abc.nextLine();
        System.out.println("");
        
        System.out.print("Masukkan harga barang ke-1 :");
        harga1 = input.nextInt();
        System.out.print("Masukkan harga barang ke-2 :");
        harga2 = input.nextInt();
        System.out.print("Masukkan harga barang ke-3 :");
        harga3 = input.nextInt();
        System.out.print("Masukkan harga barang ke-4 :");
        harga4 = input.nextInt();
        System.out.print("Masukkan harga barang ke-5 :");
        harga5 = input.nextInt();
        
        Hasil= harga1+harga2+harga3+harga4+harga5;
        System.out.println("Total Harga Pembelian atas "+ nama + " adalah Rp"+ Hasil );
        System.out.println("");
        
        if(Hasil > 100000){
            System.out.println("Selamat....");
            System.out.println("Anda mendapat hadiah 1 buah mug cantik");
        }else{
            System.out.println("Maaf Anda Belum Mendapatkan Hadiah ");
        }  
            System.out.println("");
            System.out.println("--------------------------------------------");
        System.out.println("               Terima Kasih                   ");
        System.out.println("Anda sidah belanja di Kharisma Agung Plaza  ");
        
    }
}
