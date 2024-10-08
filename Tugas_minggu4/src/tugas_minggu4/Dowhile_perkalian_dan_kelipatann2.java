/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas_minggu4;

/**
 *
 * @author Lenovo
 */
public class Dowhile_perkalian_dan_kelipatann2 {
    public static void main(String[] args) {
        
        int i=1;
        int j= 1;
        
        System.out.println("=================================================");
        System.out.println("                Do_While                         ");
        System.out.println("        Bilangan Kelipatan 2 (1-100)             ");
        System.out.println("=================================================");

        do {
            System.out.print(i * 2 + " ");
            i++;
        } while (i <= 50);
        System.out.println("                                       ");
        System.out.println("                                        ");



        System.out.println("                Do_While                         ");
        System.out.println("        Bilangan perkalian 2 (1-100)             ");
        System.out.println("=================================================");

        int angka= 1;
        do {
            angka *= 2;
            System.out.print(angka + " ");
            j++;
        } while (j <= 6);
        System.out.println();
    }
}

