/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SenjataPUBG_Polymorphism;

/**
 *
 * @author Lenovo
 */
public class M416 extends Senjata {

    @Override
    void Jenis() {
        System.out.println("Jenis Senjata = Assault Riffle ");
    }

    @Override
    void Nama() {
        System.out.println("Nama Senjata = M416 ");
    }

    @Override
    void Damage() {
        System.out.println("Damage Senjata = 41 ");
    }

    @Override
    void Peluru() {
        System.out.println("Tipe Peluru = 5.56");
    }

    @Override
    void Magazinesize() {
        System.out.println("Jumlah Peluru = 30");
    }

    @Override
    void Attachments() {
        System.out.println("Jumlah Attachments = 5");
    }

    @Override
    void Modetembak() {
        System.out.println("Mode Tembak = Single,Auto ");
    }
}
