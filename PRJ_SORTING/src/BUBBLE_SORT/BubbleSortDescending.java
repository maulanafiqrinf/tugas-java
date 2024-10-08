/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUBBLE_SORT;

import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class BubbleSortDescending {

    public static void main(String[] args) {
        int n, c, d, swap;
        Scanner in = new Scanner(System.in);

        System.out.print("MASUKKAN JUMLAH :");
        n = in.nextInt();

        int array[] = new int[n];

        System.out.println("TEKAN " + n + " ANGKA : ");

        for (c = 0; c < n; c++) {
            array[c] = in.nextInt();
        }

        for (c = 0; c < (n - 1); c++) {
            for (d = 0; d < n - c - 1; d++) {
                if (array[d] < array[d + 1]) {
                    swap = array[d];
                    array[d] = array[d + 1];
                    array[d + 1] = swap;
                }
            }
        }

        System.out.println("ANGKA YANG SUDAH DI BUBBLESORT(DSC) : ");

        for (c = 0; c < n; c++) {
            System.out.print(array[ c ]);
        }
    }
}
