/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author victo
 */
class Mapa_movimiento extends JPanel {

    //int x = (int) (Math.random() * 744), y = (int) (Math.random() * 450);
    ImageIcon Img = new ImageIcon(getClass().getResource("/imagenes/fondo1.jpg"));
    int x = 100, y = 10;
   // Image[] ima1={new ImageIcon(getClass().getResource("/imagenes/panama.png")).getImage(),new ImageIcon(getClass().getResource("/imagenes/nicaragua.png")).getImage(),new ImageIcon(getClass().getResource("/imagenes/honduras.png")).getImage(),new ImageIcon(getClass().getResource("/imagenes/el_salvador.png")).getImage(),new ImageIcon(getClass().getResource("/imagenes/costa_rica.png")).getImage(),new ImageIcon(getClass().getResource("/imagenes/belize.png")).getImage(),new ImageIcon(getClass().getResource("/imagenes/belize.png")).getImage()};

    Hilo Hilo = new Hilo();

    public Mapa_movimiento() {

        setBackground(new Color(214, 234, 248));
        setOpaque(false);
        setBorder(BorderFactory.createTitledBorder("MAPAS MOVIMIENTOS"));

    }

    public void iniciar() {
        Hilo.start();

    }

    public void paint(Graphics g) {
        Dimension tama = getSize();
        g.drawImage(Img.getImage(), 0, 0, tama.width, tama.height, null);

        super.paint(g);

        ImageIcon Img = new ImageIcon(getClass().getResource("/imagenes/panama.png"));
        ImageIcon Img1 = new ImageIcon(getClass().getResource("/imagenes/nicaragua.png"));
        ImageIcon Img2 = new ImageIcon(getClass().getResource("/imagenes/honduras.png"));
        ImageIcon Img3 = new ImageIcon(getClass().getResource("/imagenes/el_salvador.png"));
        ImageIcon Img4 = new ImageIcon(getClass().getResource("/imagenes/costa_rica.png"));
        ImageIcon Img5 = new ImageIcon(getClass().getResource("/imagenes/belize.png"));
        ImageIcon Img6 = new ImageIcon(getClass().getResource("/imagenes/guatemala.png"));
        /*g.drawImage(Img.getImage(), 10, 10, 100, 100, null);
        g.drawImage(Img1.getImage(), 10, 100, 100, 100, null);
        g.drawImage(Img2.getImage(), 10, 200, 100, 100, null);
        g.drawImage(Img3.getImage(), 10, 300, 100, 100, null);
        g.drawImage(Img4.getImage(), 210, 300, 100, 100, null);
        g.drawImage(Img5.getImage(), 210, 100, 100, 100, null);
        g.drawImage(Img6.getImage(), 210, 200, 100, 100, null);*/
        g.drawImage(Img.getImage(), y, (x-90), 100, 100, null);
        g.drawImage(Img1.getImage(), y, x, 100, 100, null);
        g.drawImage(Img2.getImage(), y, (x+100), 100, 100, null);
        g.drawImage(Img3.getImage(), y, (x+200), 100, 100, null);
        g.drawImage(Img4.getImage(), (y+200), (x+200), 100, 100, null);
        g.drawImage(Img5.getImage(), (y+200), x, 100, 100, null);
        g.drawImage(Img6.getImage(), (y+200), (x+100), 100, 100, null);

    }
    
    

    public class Hilo extends Thread {

        boolean EstaCorriendo = true;
        boolean TocoX = true, TocoY = true;

        Clip Sonido;

        public Hilo() {

        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Mover();
                    repaint();
                    Thread.sleep(5);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        public void Mover() {
            if (EstaCorriendo) {
                if (TocoX) {
                    if (EstaCorriendo) {
                        x--;
                        if (x == 0) {

                            TocoX = false;

                        }
                    }
                }
                
                if (!TocoX) {
                    if (EstaCorriendo) {
                        x++;
                        if (x == getWidth() - 50) {

                            TocoX = true;

                        }
                    }
                }
                if (TocoY) {
                    if (EstaCorriendo) {
                        y++;
                        if (y == getHeight() - 30) {

                            TocoY = false;

                        }
                    }
                }
                if (!TocoY) {
                    if (EstaCorriendo) {
                        y--;
                        if (y == 0) {
                            TocoY = true;

                        }
                    }
                }
            }
        }

        public void Pausar() {
            EstaCorriendo = false;
        }

        public void Continuar() {
            EstaCorriendo = true;
        }

        /*public class hilo extends Thread {

        hilo() {

        }

        public void run() {

            for (;;) {
                while (x < 650) {
                    try {
                        sleep(3);
                        x++;  
                        repaint();

                    } catch (InterruptedException ex) {

                    }
                }

                while (x > 0) {
                    try {
                        sleep(3);
                        x--;
                        
                        repaint();

                    } catch (InterruptedException ex) {

                    }
                }

            }

        }

    }
         */
    }
}
