/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TugasTambahan1;

/**
 *
 * @author Lenovo
 */
public class UserTelevisi {

    public static void main(String[] args) {
        Televisi tv = new Televisi("Panasonic, 32 inches", 10);
        String[] semuaChannel = {"METRO TV", "RCTI", "NET TV", "TRANS TV",
            "TRANS 7", "SCTV", "INDOSIAR", "ANTV","TVRI", "MNC TV", "JTV"};
        String[] channelFavorit = {"MNC", "TRANS 7", "TRANS TV", "SCTV","RCTI", "ANTV"};

        System.out.println("Fiqri, membeli Televisi : " + tv.getDesk());

        tv.getChannels();
        tv.setChannels(semuaChannel);
        tv.setChannels(channelFavorit);

        tv.setChannelAktif(2);
        tv.setVolume(8);
        tv.setChannelAktif(5);
        tv.setChannelAktif(4);
    }

}
