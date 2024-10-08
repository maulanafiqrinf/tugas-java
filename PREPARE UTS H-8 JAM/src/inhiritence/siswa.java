/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inhiritence;

/**
 *
 * @author Lenovo
 */
public class siswa {
        // default modifier : public
    
    String nama;
    int nis;
    int nilai;
    
    siswa(String pnama, int pnis, int pnilai) {
        this.nama = pnama;
        this.nis = pnis;
        this.nilai = pnilai;
    }
    
    public void getInfoSiswa() {
        System.out.println("Siswa bernama " + this.nama + " dengan nis " 
                + this.nis + " memiliki nilai : "+ this.nilai);
    }
    
    // menulis
    public void menulis() {
        System.out.println(this.nama + " sedang menulis");
    }
    
    // membaca
    public void membaca() {
        System.out.println(this.nama + " sedang membaca");
    }
    
}

