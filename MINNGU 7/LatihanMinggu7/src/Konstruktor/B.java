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
public class B extends A{
  B() {
      // Pemanggilan konstruktor superclass dengan keyword super tidak
      // dilakukan sehingga Java akan menambahkan secara otomatis kode untuk
      // memanggil konstruktor default milik superclassnua disini.
      
      super("test"); //tambahan
      
      System.out.println("Konstruktor class B dieksekusi ...");
  }  
}
