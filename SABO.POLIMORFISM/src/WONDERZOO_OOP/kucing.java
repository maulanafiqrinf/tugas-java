/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WONDERZOO_OOP;

/**
 *
 * @author Lenovo
 */
public class kucing extends hewan {
    //Subclass Pertama

    @Override
    void setNama() {
        String kucing = "Kittie";
        System.out.println("Nama Kucing: " + kucing);
    }

    @Override
    void setSuara() {
        String suara = "Miaw Meow Meong";
        System.out.println("Suara Kucing: " + suara);
    }

    @Override
    void setBerat() {
        double berat = 4.5;
        System.out.println("berat Kucing: " + berat + " Kg");
    }
}
