/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DASAR;

/**
 *
 * @author Lenovo
 */
public class game {
    public static void main(String[] args){

        // membuat objek player
        player petani = new player();

        // mengisi atribut player
        petani.name = "fiqri Kode";
        petani.speed = 78;
        petani.healthPoin = 0;

        // menjalankan method
        petani.run();

        if(petani.isDead()){
            System.out.println("Game Over!");
        }

    }
}

