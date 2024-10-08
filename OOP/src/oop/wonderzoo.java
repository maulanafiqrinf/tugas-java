/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop;

/**
 *
 * @author Lenovo
 */
public class wonderzoo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println("===== HEWAN KUCING =====");
        hewan k = new kucing();
        k.setNama();
        k.setSuara();
        k.setBerat();
        
        System.out.println("===== HEWAN SINGA =====");
        hewan s = new singa();
        s.setNama();
        s.setSuara();
        s.setBerat();
        
        System.out.println("===== HEWAN KUDA =====");
        hewan u = new kuda();
        u.setNama();
        u.setSuara();
        u.setBerat();
    }
    
}
