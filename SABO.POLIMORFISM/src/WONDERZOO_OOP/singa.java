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
public class singa extends hewan {

    @Override
    void setNama() {
        String singa = "Simba";
        System.out.println("Nama Singa: " + singa);
    }

    @Override
    void setSuara() {
        String suara = "Roaaarrrr";
        System.out.println("Suara Singa: " + suara);
    }

    @Override
    void setBerat() {
        double berat = 150;
        System.out.println("berat Singa: " + berat + " Kg");
    }
}
