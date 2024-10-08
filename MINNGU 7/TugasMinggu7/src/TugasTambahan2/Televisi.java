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
public class Televisi {

    public String deks;
    int jumlahChannel;
    private String[] channels = null;
    private int channelAktif;
    private int volume;

    public String getDesk() {
        return deks;
    }

    public int getJumlahChannel() {
        return jumlahChannel;
    }

    public String[] getChannels() {
        if (channels == null) {
            System.out.println("Belum ada Channel yang di atur!");
        }
        return channels;
    }

    public void setChannels(String[] channels) {
        if (channels.length > jumlahChannel) {
            System.out.println("Maaf Tv ini hanya dapat menyimpan "
                    + jumlahChannel + " channel");
        } else {
            this.channels = channels;
            System.out.println("Informasi Channel berhasil diupdate!");
        }
    }

    public int getChannelAktif() {
        return channelAktif;
    }

    public void setChannelAktif(int channelAktif) {
        if (channelAktif > channels.length) {
            System.out.println("Channel yang dicari belum diatur!");
            return;
        }
        this.channelAktif = channelAktif;
        System.out.println("Pindah Channel ke : " + channels[channelAktif]);
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("Intensitas volume sekarang : " + volume);
    }
}
