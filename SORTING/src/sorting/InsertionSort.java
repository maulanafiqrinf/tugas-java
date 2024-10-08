/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class InsertionSort {
   public static void main(String args[])
   {
       int size, i, j, temp;
       int arr[] = new int[50];
       Scanner scan = new Scanner(System.in);
	   
       System.out.print("Enter Array Size : ");
       size = scan.nextInt();
	   
       System.out.print("Enter Array Elements : ");
       for(i=0; i<size; i++)
       {
           arr[i] = scan.nextInt();
       }
	   
       System.out.print("Sorting Array using Insertion Sort Technique..\n");
       for(i=1; i<size; i++)
       {
           temp = arr[i];
           j = i - 1;
           while((temp < arr[j]) && (j >= 0))
           {
               arr[j+1] = arr[j];
               j = j - 1;
           }
           arr[j+1] = temp;
       }
	   
       System.out.print("Array after Sorting is : \n");
       for(i=0; i<size; i++)
       {
           System.out.print(arr[i] + "  ");
       }
   }
}
