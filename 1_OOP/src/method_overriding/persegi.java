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
public class persegi extends bangundatar {

    float sisi;

    @Override
    float luas() {
        float luas = sisi * sisi;
        System.out.println("Luas Persegi: " + luas);
        return 0;
    }

    @Override
    float keliling() {
        float keliling = 4 * sisi;
        System.out.println("Keliling Persegi: " + keliling);
        return keliling;
    }
}
