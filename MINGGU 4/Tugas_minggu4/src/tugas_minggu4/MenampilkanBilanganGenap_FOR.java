/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas_minggu4;

import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class MenampilkanBilanganGenap_FOR {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int awal, akhir;

        System.out.println("                 MENAMPILKAN DERET BILANGAN GENAP                                      ");
        System.out.println("              DENGAN MENENTUKAN BATAS AWAL DAN AKHIR                                   ");
        System.out.println("---------------------------------------------------------------------------------------");

        System.out.print("Masukkan nilai awal: ");
        awal = input.nextInt();
        System.out.print("Masukkan nilai akhir: ");
        akhir = input.nextInt();
        System.out.println("---------------------------------------------------------------------------------------");

        System.out.println("Bilangan Genap");
        for (int i = awal; i <= akhir; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println("");
    }
}
