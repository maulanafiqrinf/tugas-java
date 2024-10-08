/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas_minggu4;

import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class Menentukan_minmax_rata {

    public static void main(String[] args) {
        int maksimum, Data, minimum, i, array[];
        int nilairata = 0;

        Scanner scan = new Scanner(System.in);
        System.out.print("Masukkan Banyaknya Data Nilai: ");
        Data = scan.nextInt();
        array = new int[Data];

        for (i = 0; i < Data; i++) {
            System.out.print("Masukkan Data Nilai ke-" + (i + 1) + ": ");
            array[i] = scan.nextInt();
        }
        // mencari nilai minimum dan maksimum
        maksimum = array[0];
        minimum = array[0];

        for (i = 0; i < Data; i++) {
            if (array[i] > maksimum) {
                maksimum = array[i];
            } else if (array[i] < minimum) {
                minimum = array[i];
            }
        }

        //mencari rata-rata 
        for (i = 0; i < Data; i++) {
            nilairata += array[i];
        }
        nilairata = nilairata / i;

        System.out.println("--------------------------------");
        System.out.println("Nilai minimum = " + minimum);
        System.out.println("Nilai maksimum = " + maksimum);
        System.out.println("Nilai Rata-Ratanya adalah = " + " " + nilairata);

    }
}
