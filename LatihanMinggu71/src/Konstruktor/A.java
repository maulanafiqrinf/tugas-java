/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Konstruktor;

/**
 *
 * @author Lenovo
 */
public class A {
      //A(){} // Konstruktor default, diperlukan hanya agar program dapat
           // dikompilasi.
    
    A(String param1) { //Konstruktor untuk class A sudah didefinisikan sehingga
                       // Java tidak membuat konstruktor default untuk clas ini
                       
                       
            // super(); Tambaham kode secara otomatis oleh Java untuk memanggil
            //          Konstruktor dari SuperClassnya
          
            
          //super(); // Konstruktor default dari class
                    // Object dipanggil
                    
        //System.out.println("Konstruktor class A dieksekusi ...");
        System.out.println("Konstruktor class A dengan Parameter " 
                + param1 + " dieksekusi...");
    }
}

