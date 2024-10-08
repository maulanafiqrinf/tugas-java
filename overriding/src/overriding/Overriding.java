/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package overriding;

/**
 *
 * @author MFNF
 */
// membuat superclass
class Hewan {
    //membuat method 
    public void membuatsuara() {
        System.out.println("gerrr....");
    }
    //membuat method yang lain
    public void ukuranhewan() {
        System.out.println("default");
    }
}

//membuat anak kelas atau sub class yang mewarisi sifat superclass
class sapi extends Hewan {

    //@override pada class diatas menandakan bahwa method yang digunakan sama dengan kelas supernya.
    @Override
    public void membuatsuara() {
        System.out.println("Suara Sapi : Mooooo...... Moooooo.......");
    }
    //@override pada class diatas menandakan bahwa method yang digunakan sama dengan kelas supernya.
    @Override
    public void ukuranhewan() {
        System.out.println("Ukuran Sapi : 7");
    }
}

//membuat anak kelas atau sub class yang mewarisi sifat superclass
class kambing extends Hewan {
    //@override pada class diatas menandakan bahwa method yang digunakan sama dengan kelas supernya.
    @Override
    public void membuatsuara() {
        System.out.println("Suara Kambing : Mbekkkk....... Mbekkkkk");
    }
    //@override pada class diatas menandakan bahwa method yang digunakan sama dengan kelas supernya.
    @Override
    public void ukuranhewan() {
        System.out.println("Ukuran Kambing : 4");
    }
}

//membuat kelas main untuk memunculkan program
public class Overriding {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //membuat objek sapi
        Hewan S = new sapi();
        //membuat objek kambing
        Hewan K = new kambing();
        //objek sapi menggunakan method suara
        S.membuatsuara();
        //objek kambing menggunakan method ukuran
        S.ukuranhewan();
        System.out.println("--------------------------------------------------");
        //objek kambing menggunakan method suara
        K.membuatsuara();
        //objek kambing menggunakan method ukuran
        K.ukuranhewan();
 

    }
    
}
