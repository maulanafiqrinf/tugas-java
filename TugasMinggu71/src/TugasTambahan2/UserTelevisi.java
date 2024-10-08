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
public class UserTelevisi {

    public static void main(String[] args) {
        TelevisiModern tv = new TelevisiModern("TV Panasonic, 32 inces", 100);

        String[] semuaChannel = {"METRO TV", "RCTI", "TPI", "TRANS TV",
            "TRANS 7", "SCTV", "INDOSIAR", "ANTV",
            "TVRI", "BAYU TV", "JTV"};

        System.out.println("Fiqri, membeli Televisi : " + tv.getDesk());

        tv.getChannels();
        tv.setChannels(semuaChannel);

        tv.setChannelAktif(3);
        tv.setVolume(10);
        tv.setChannelAktif(10);
        tv.setChannelAktif(1);

        tv.setModusTampilan(TelevisiModern.TELETEXT);
        tv.setHalamanTeleText(250);
        tv.setModusTampilan(TelevisiModern.tV);
        tv.playCD();
        tv.setDiscTray("Yo Wis Ben 2");
        tv.playCD();
    }
}
