/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting;

/**
 *
 * @author Lenovo
 */
public class BubbleSortDescending {
     
    static void bubbleSortdesc(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                //System.out.println(" A : " + arr[j-1] +" < "+" B : "+arr[j]);
                if (arr[j - 1] < arr[j]) {   //dirubah tanda operasi
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }

            }
        }

    }

    public static void main(String[] args) {
        int arr[] = {3, 60, 35, 2, 45, 320, 5};
        System.out.println("Array before bubble sort : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        bubbleSortdesc(arr);
        System.out.println("Array after bubble sort descending : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
