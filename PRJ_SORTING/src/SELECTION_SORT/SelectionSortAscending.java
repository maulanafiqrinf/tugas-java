/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SELECTION_SORT;

import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class SelectionSortAscending {

    public static void main(String[] args) {
        int size, i, j, temp, small, index = 0, count = 0;
        int arr[] = new int[50];
        Scanner scan = new Scanner(System.in);
        System.out.print("MASUKKAN JUMLAH : ");
        size = scan.nextInt();
        System.out.println("Masukkan Angka yang di inginkan : ");
        for (i = 0; i < size; i++) {
            arr[i] = scan.nextInt();
        }
        System.out.println("ANGKA YANG TELAH DIMASUKKAN");
        for (i = 0; i < (size - 1); i++) {
            small = arr[i];
            for (j = (i + 1); j < size; j++) {
                if (small > arr[j]) {
                    small = arr[j];
                    count++;
                    index = j;
                }
            }
            if (count != 0) {
                temp = arr[i];
                arr[i] = small;
                arr[index] = temp;
            }
            count = 0;
        }
        System.out.println("ANGKA YANG SUDAH DI SELECTION(ASC) :");
        for (i = 0; i < size; i++) {
            System.out.print(arr[i] + "  ");
        }
    }
}
