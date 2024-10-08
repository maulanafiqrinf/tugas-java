/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas_minggu2;

/**
 *
 * @author Lenovo
 */
public class managingpeople_Tugas2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Person p1 = new Person("Arial", 37);

        Person p2 = new Person("Joseph", 15);

        if (p1.getAge() == p2.getAge()) {

            System.out.println(p1.getName() + " is the same age as " + p2.getName());
        } else {
            System.out.println(p1.getName() + " is NOT the same age as " + p2.getName());
        }
    }
}
