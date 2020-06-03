/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author victo
 */
public class PanelFondo extends JPanel {
    ImageIcon imagen;
    String nombre;
    
    public PanelFondo(String nombre){
        this.nombre=nombre;
    }
    
    public void paint(Graphics g){
        Dimension tama=getSize();
        imagen = new ImageIcon(getClass().getResource(nombre));
        g.drawImage(imagen.getImage(), 0, 0, tama.width,tama.height,null);
        setOpaque(false);
        super.paint(g);
        
    }

   

}
