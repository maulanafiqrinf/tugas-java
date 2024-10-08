/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ContohSederhana;

/**
 *
 * @author Lenovo
 */
public class orang {

    private String nama;
    private double tinggi;
    private double berat;

    public orang(String nama, double tinggi, double berat) {
        this.nama = nama;
        this.tinggi = tinggi;
        this.berat = berat;
    }

    public String toString() {
        return ("Nama : " + nama + "\nTinggi : " + tinggi + "\nBerat : " + berat);

    }
}
