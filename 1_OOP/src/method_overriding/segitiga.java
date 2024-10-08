/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package method_overriding;

/**
 *
 * @author Lenovo
 */
public class segitiga extends bangundatar {

    float alas;
    float tinggi;

    @Override
    float luas() {
        float luas = 1 / 2 * (alas * tinggi);
        System.out.println("Luas Segitiga: " + luas);
        return luas;
    }

}
