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
public class SKS extends Senjata {

    @Override
    void Jenis() {
        System.out.println("Jenis Senjata = Designated Marksman Riffle(DMR) ");
    }

    @Override
    void Nama() {
        System.out.println("Nama Senjata = SKS ");
    }

    @Override
    void Damage() {
        System.out.println("Damage Senjata = 55 ");
    }

    @Override
    void Peluru() {
        System.out.println("Tipe Peluru = 7.62");
    }

    @Override
    void Magazinesize() {
        System.out.println("Jumlah Peluru = 10");
    }

    @Override
    void Attachments() {
        System.out.println("Jumlah Attachments = 4");
    }

    @Override
    void Modetembak() {
        System.out.println("Mode Tembak = Semi-Auto,Auto ");
    }
}
