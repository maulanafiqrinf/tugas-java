/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inhiritance;

/**
 *
 * @author Lenovo
 */
public class main {
    public static void main(String[] args) {
        
        // membuat objek bangun datar
        bangundatar bangundatar = new bangundatar();
        
        // membuat objek persegi dan mengisi nilai properti
        persegi persegi = new persegi();
        persegi.sisi = 2;
        
        // membuat objek Lingkaran dan mengisi nilai properti
        lingkaran lingkaran = new lingkaran();
        lingkaran.r = 22;
        
        // membuat objek Persegi Panjang dan mengisi nilai properti
        persegipanjang persegipanjang = new persegipanjang();
        persegipanjang.panjang = 8;
        persegipanjang.lebar = 4;
        
        // membuat objek Segitiga dan mengisi nilai properti
        segitiga msegitiga = new segitiga();
        msegitiga.alas = 12;
        msegitiga.tinggi = 8;
        
        
        // memanggil method luas dan keliling
        bangundatar.luas();
        bangundatar.keliling();
        
        persegi.luas();
        persegi.keliling();
        
        lingkaran.luas();
        lingkaran.keliling();
        
        persegipanjang.luas();
        persegipanjang.keliling();
        
        msegitiga.luas();
        msegitiga.keliling();
    }
}
