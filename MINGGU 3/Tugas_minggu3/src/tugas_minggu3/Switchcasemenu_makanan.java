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
public class Switchcasemenu_makanan {
    public static void main(String[] args) {
        
        System.out.println("------------------------------");
        System.out.println("         CAFE CERIA        ");
        System.out.println("        ANEKA MINUMAN        ");
        System.out.println("------------------------------");
        
        System.out.println("        SPECIAL MENU :    ");
        
        Scanner input = new Scanner(System.in);
        int menu;
        String nama;
        Scanner abc=new
        Scanner(System.in);
        
        System.out.print("      1. Soft drinks\n      2. Mix juice\n      3. Nescafe\n      4. Soda milk\n      5. Tea\n");
        System.out.println("------------------------------");
        
        
        System.out.print("Masukkan Nama Pembeli :");
        nama= abc.nextLine();
        System.out.println("");
        
        System.out.print("Silahkan masukkan pilihan anda :");
        menu= input.nextInt();
        
        switch(menu){
            case 1 :
                System.out.println("Minuman yang anda pesan adalah Soft drinks ");
                System.out.println("Pesanan akan segera kami antar");
                System.out.println("Terima kasih "+ nama + " telah berkunjung di cafe ceria");
            break;
            case 2 :
                System.out.println("Minuman yang anda pesan adalah Mix juice ");
                System.out.println("Pesanan akan segera kami antar");
                System.out.println("Terima kasih "+ nama + " telah berkunjung di cafe ceria");
            break;
            case 3 :
                System.out.println("Minuman yang anda pesan adalah Nescafe ");
                System.out.println("Pesanan akan segera kami antar");
                System.out.println("Terima kasih "+ nama + " telah berkunjung di cafe ceria");
            break;
            case 4 :
                System.out.println("Minuman yang anda pesan adalah Soda milk ");
                System.out.println("Pesanan akan segera kami antar");
                System.out.println("Terima kasih "+ nama + " telah berkunjung di cafe ceria");
            break;
            case 5 :
                System.out.println("Minuman yang anda pesan adalah Tea ");
                System.out.println("Pesanan akan segera kami antar");
                System.out.println("Terima kasih "+ nama + " telah berkunjung di cafe ceria");
            break;
            default:
            System.out.println("Maaf anda salah memasukkan menu pilihan !!Silahkan coba lagi");
    
        }
        
      
    }
}
