/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TugasTambahan2;

/**
 *
 * @author Lenovo
 */
public class TelevisiModern extends Televisi {

    public String teletext;
    public String TV;
    public String modusTampilan;
    public String discTray;

    public TelevisiModern(String deks, int jumlahChannel) {
        this.deks = deks;
        this.jumlahChannel = jumlahChannel;
    }

    static String TELETEXT = "Teletext";
    static String tV = "TV";

    public String setModusTampilan(String a) {
        if (TELETEXT == a) {
            this.TELETEXT = a;
            System.out.println("Modus tampilan : " + this.TELETEXT);
        } else if (tV == a) {
            this.tV = a;
            System.out.println("Modus tampilan : " + this.tV);
        }

        return "Tidak ada tampilan yang sesuai";
    }

    public void setHalamanTeleText(int teletext) {

        System.out.println("Berpindah ke halaman teletext " + teletext);
    }

    public String getHalamanTeleText() {
        return this.teletext;
    }

    public void setDiscTray(String discTray) {
        this.discTray = discTray;
    }

    public String getDiscTray() {
        return this.discTray;
    }

    public void playCD() {
        if (this.discTray == null) {
            System.out.println("Tidak ada CD di dalam disc tray!");
        } else {

            System.out.println("Memutar Film " + this.discTray);
        }
    }
}
