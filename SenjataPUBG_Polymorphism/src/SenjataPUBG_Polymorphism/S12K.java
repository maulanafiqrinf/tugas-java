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
public class S12K extends Senjata {

    @Override
    void Jenis() {
        System.out.println("Jenis Senjata = Shotgun ");
    }

    @Override
    void Nama() {
        System.out.println("Nama Senjata = S12K ");
    }

    @Override
    void Damage() {
        System.out.println("Damage Senjata = 22 ");
    }

    @Override
    void Peluru() {
        System.out.println("Tipe Peluru = 12 Gauge");
    }

    @Override
    void Magazinesize() {
        System.out.println("Jumlah Peluru = 5 ");
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
