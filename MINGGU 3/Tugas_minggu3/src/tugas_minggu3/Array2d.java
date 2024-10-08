/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas_minggu3;

/**
 *
 * @author Lenovo
 */
public class Array2d {
    public static void main(String[] args) {
        int [][] arr2d = {{5,6,1,7}, {8,1,2,9}, {5,4,7,1}, {8,3,7,5}};
        for (int baris = 0; baris < 4; baris++) {
            for (int kolom = 0; kolom < 4; kolom++) {
                System.out.print(arr2d[baris][kolom]+"   ");
            }
            System.out.println("");
        }
    }
}
