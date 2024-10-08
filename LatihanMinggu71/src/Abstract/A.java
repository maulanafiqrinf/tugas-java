/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Abstract;

/**
 *
 * @author Lenovo
 */
public abstract class A { //deklarasi class
    abstract public void method2(); // deklarasi method abstrak
    // method konkrit yg memiliki implementasi
    public void method1(){
        System.out.println("Method konkrit dari class A");
    }
}
