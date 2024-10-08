/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdnggambar;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Lenovo
 */
public class gmbrsearch extends JPanel{
    private Image gambar4;
 
    public gmbrsearch () {
        gambar4= new ImageIcon(getClass().getResource("/gambar/Search_48px.png")).getImage();
    }
 
    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
 
        Graphics2D gd = (Graphics2D) grphcs.create();
        gd.drawImage(gambar4, 0, 0, getWidth(), getHeight(), null);
        gd.dispose();
    }
}
