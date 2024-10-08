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
public class P92 extends Senjata {

    @Override
    void Jenis() {
        System.out.println("Jenis Senjata = Pistol ");
    }

    @Override
    void Nama() {
        System.out.println("Nama Senjata = P92 ");
    }

    @Override
    void Damage() {
        System.out.println("Damage Senjata = 29 ");
    }

    @Override
    void Peluru() {
        System.out.println("Tipe Peluru = 9mm ");
    }

    @Override
    void Magazinesize() {
        System.out.println("Jumlah Peluru = 15 ");
    }

    @Override
    void Attachments() {
        System.out.println("Jumlah Attachments = 3");
    }

    @Override
    void Modetembak() {
        System.out.println("Mode Tembak = Single ");
    }
}
