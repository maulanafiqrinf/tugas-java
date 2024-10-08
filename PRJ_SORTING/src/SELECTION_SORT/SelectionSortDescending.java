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
public class SelectionSortDescending {

    public static void main(String[] args) {
        int[] num;
        int size;
        Scanner scanner = new Scanner(System.in);
        System.out.print("MASUKKAN JUMLAH : ");
        size = scanner.nextInt();
        num = new int[size];
        for (int i = 0; i < size; i++) {
            num[i] = scanner.nextInt();
        }
        int sorted_array[] = sort(num);
        System.out.println("ANGKA YANG SUDAH DI SELECTION(DSC) :");
        for (int i = 0; i < sorted_array.length; i++) {
            System.out.print(sorted_array[i] + "\t");
        }
    }

    public static int[] sort(int[] num) {
        int i, j, first, temp;
        for (i = num.length - 1; i > 0; i--) {
            first = 0;  
            for (j = 1; j <= i; j++) 
            {
                if (num[j] < num[first]) {
                    first = j;
                }
            }
            temp = num[first];   
            num[first] = num[i];
            num[i] = temp;
        }
        return num;
    }
}
