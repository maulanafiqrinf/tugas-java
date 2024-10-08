/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SENJATAPUBG_OOP;

/**
 *
 * @author Lenovo
 */
public class UMP9 extends Senjata {

    @Override
    void Jenis() {
        System.out.println("Jenis Senjata = Submachine Gun ");
    }

    @Override
    void Nama() {
        System.out.println("Nama Senjata = UMP9 ");
    }

    @Override
    void Damage() {
        System.out.println("Damage Senjata = 35 ");
    }

    @Override
    void Peluru() {
        System.out.println("Tipe Peluru = .45");
    }

    @Override
    void Magazinesize() {
        System.out.println("Jumlah Peluru = 30 ");
    }

    @Override
    void Attachments() {
        System.out.println("Jumlah Attachments = 4");
    }

    @Override
    void Modetembak() {
        System.out.println("Mode Tembak = Single,Burst,Auto ");
    }
}
