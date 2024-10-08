/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inhiritence;

/**
 *
 * @author Lenovo
 */
public class fiqri extends siswa {

    public fiqri(String pnama, int pnis, int pnilai) {
        super(pnama, pnis, pnilai);
    }

    public static void main(String[] args) {
    fiqri f = new fiqri("Fiqri", 200105, 100);
    
    f.nama  = "fiqri";

    f.getInfoSiswa ();

    f.membaca ();

    f.menulis ();
    }

}
