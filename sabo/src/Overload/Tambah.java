/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Overload;

/**
 *
 * @author Lenovo
 */
public class Tambah {
// melakukan overloading tambah()
// yang mengambil dua
// parameter int.
    public int Tambah(int x, int y) {
        return (x + y);
    }

// melakukan overloading sum()
// yang mengambil tiga
// parameter int.
    public int Tambah(int x, int y, int z) {
        return (x + y + z);
    }

// melakukan overloading sum()
// yang mengambil dua
// parameter double.
    public double Tambah(double x, double y) {
        return (x + y);
    }

    /* Driver code */
    public static void main(String args[]) {

        Tambah T = new Tambah();

        System.out.println(T.Tambah(30, 80));

        System.out.println(T.Tambah(100, 250, 10));

        System.out.println(T.Tambah(35.5, 65.5));

    }

}
