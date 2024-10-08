package sabo_override;

/**
 *
 * @author MFNF FIQRI
 */
class Hewan {

    public void membuatsuara() {
        System.out.println("gerrr....");
    }

    public void ukuranhewan() {
        System.out.println("default");
    }
}

class sapi extends Hewan {

    @Override
    public void membuatsuara() {
        System.out.println("Suara Sapi : Mooooo...... Moooooo.......");
    }

    @Override
    public void ukuranhewan() {
        System.out.println("Ukuran Sapi : 7");
    }
}

class kambing extends Hewan {

    @Override
    public void membuatsuara() {
        System.out.println("Suara Kambing : Mbekkkk....... Mbekkkkk");
    }

    @Override
    public void ukuranhewan() {
        System.out.println("Ukuran Kambing : 4");
    }
}

public class Sabo_override {

    public static void main(String[] args) {
        // TODO code application logic here
        Hewan S = new sapi();
        Hewan K = new kambing();
        S.membuatsuara();
        S.ukuranhewan();
        System.out.println("--------------------------------------------------");
        K.membuatsuara();
        K.ukuranhewan();
    }

}
