/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop;

/**
 *
 * @author Lenovo
 */
public class kuda extends hewan {

    @Override
    void setNama() {
        String kuda = "pinkie pie";
        System.out.println("Nama kuda: " + kuda);
    }

    @Override
    void setSuara() {
        String suara = "hihi-hihi";
        System.out.println("Suara kuda: " + suara);
    }

    @Override
    void setBerat() {
        double berat = 400;
        System.out.println("berat kuda: " + berat + " Kg");
    }
}
