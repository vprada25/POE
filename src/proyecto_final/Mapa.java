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
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author victo
 */
public class Mapa extends JPanel implements MouseListener, MouseMotionListener {

    Tiempo_dificil d;
    Tiempo_facil f;
    Tiempo_medio m;
    Interfaz frame;

    int x = 100, y = 10;
    int x1 = 100, y1 = 10;
    int x2 = 100, y2 = 10;
    int x3 = 100, y3 = 10;
    int x4 = 100, y4 = 10;
    int x5 = 100, y5 = 10;
    int x6 = 100, y6 = 10;

    ImageIcon Img0 = new ImageIcon(getClass().getResource("/imagenes/Panama1.png"));
    ImageIcon Img1 = new ImageIcon(getClass().getResource("/imagenes/Nicar.png"));
    ImageIcon Img2 = new ImageIcon(getClass().getResource("/imagenes/Hondu.png"));
    ImageIcon Img3 = new ImageIcon(getClass().getResource("/imagenes/ElSalvador.png"));
    ImageIcon Img4 = new ImageIcon(getClass().getResource("/imagenes/CostaRica.png"));
    ImageIcon Img5 = new ImageIcon(getClass().getResource("/imagenes/Belice.png"));
    ImageIcon Img6 = new ImageIcon(getClass().getResource("/imagenes/Guatemala1.png"));

    ImageIcon img1 = new ImageIcon(getClass().getResource("/imagenes/fondo_2.png"));
    Mapa.Hilo Hilo = new Mapa.Hilo();
    Mapa.Hilo2 Hilo2 = new Mapa.Hilo2();
    Mapa.Hilo3 Hilo3 = new Mapa.Hilo3();
    Mapa.Hilo4 Hilo4 = new Mapa.Hilo4();
    Mapa.Hilo5 Hilo5 = new Mapa.Hilo5();
    Mapa.Hilo6 Hilo6 = new Mapa.Hilo6();
    Mapa.Hilo7 Hilo7 = new Mapa.Hilo7();

    Jlabel lm1, lm2, lm3, lm4, lm5, lm6, lm7;
    JLabel lm8, lm9, lm11;
    
    boolean banresul=false;

    //JLabel partes[]= new JLabel[7];
    Mapa() {

        setBackground(new Color(214, 234, 248));
        setBorder(BorderFactory.createTitledBorder("MAPA"));
        setLayout(null);
        //setToolTipText(x+y);

        Dimension tama = getSize();
        Image fondo = img1.getImage();
        ImageIcon fondo_es = new ImageIcon(fondo.getScaledInstance(1210, 630, Image.SCALE_SMOOTH));
        lm9 = new JLabel();
        lm9.setBounds(0, 0, 1210, 600);
        lm9.setIcon(fondo_es);
        lm9.setOpaque(false);

        ImageIcon Img = new ImageIcon(getClass().getResource("/imagenes/CAmSinFondo.png"));
        Image mapa = Img.getImage();
        ImageIcon mapa_escalado = new ImageIcon(mapa.getScaledInstance(551, 448, Image.SCALE_SMOOTH));

        Image imagen = Img0.getImage();
        Image imagen1 = Img1.getImage();
        Image imagen2 = Img2.getImage();
        Image imagen3 = Img3.getImage();
        Image imagen4 = Img4.getImage();
        Image imagen5 = Img5.getImage();
        Image imagen6 = Img6.getImage();
        ImageIcon iconoEscalado = new ImageIcon(imagen.getScaledInstance(295, 193, Image.SCALE_SMOOTH));
        ImageIcon iconoEscalado1 = new ImageIcon(imagen1.getScaledInstance(253, 193, Image.SCALE_SMOOTH));
        ImageIcon iconoEscalado2 = new ImageIcon(imagen2.getScaledInstance(230, 155, Image.SCALE_SMOOTH));
        ImageIcon iconoEscalado3 = new ImageIcon(imagen3.getScaledInstance(110, 70, Image.SCALE_SMOOTH));
        ImageIcon iconoEscalado4 = new ImageIcon(imagen4.getScaledInstance(220, 170, Image.SCALE_SMOOTH));
        ImageIcon iconoEscalado5 = new ImageIcon(imagen5.getScaledInstance(140, 105, Image.SCALE_SMOOTH));
        ImageIcon iconoEscalado6 = new ImageIcon(imagen6.getScaledInstance(233, 175, Image.SCALE_SMOOTH));

        lm1 = new Jlabel(iconoEscalado);
        lm1.setBounds(y, (x - 90), 250, 250);
        lm2 = new Jlabel(iconoEscalado1);
        lm2.setBounds(y, x, 250, 250);
        lm3 = new Jlabel(iconoEscalado2);
        lm3.setBounds(y, (x + 100), 250, 250);
        lm4 = new Jlabel(iconoEscalado3);
        lm4.setBounds(y, (x + 200), 250, 250);
        lm5 = new Jlabel(iconoEscalado4);
        lm5.setBounds((y + 200), (x + 200), 250, 250);
        lm6 = new Jlabel(iconoEscalado5);
        lm6.setBounds((y + 200), x, 250, 250);
        lm7 = new Jlabel(iconoEscalado6);
        lm7.setBounds(y + 200, (x + 100), 250, 250);

        lm8 = new JLabel(mapa_escalado);
        lm8.setIcon(mapa_escalado);
        lm8.setBounds(370, 10, 750, 450);

        lm1.addMouseListener(this);
        lm2.addMouseListener(this);
        lm3.addMouseListener(this);
        lm4.addMouseListener(this);
        lm5.addMouseListener(this);
        lm6.addMouseListener(this);
        lm7.addMouseListener(this);

        add(lm1);
        add(lm2);
        add(lm3);
        add(lm4);
        add(lm5);
        add(lm6);
        add(lm7);
        add(lm8);
        add(lm9);
        
       

    }

    public void iniciar() {

        Hilo.start();
        Hilo2.start();
        Hilo3.start();
        Hilo4.start();
        Hilo5.start();
        Hilo6.start();
        Hilo7.start();

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Hilo.Continuar();
        Hilo2.Continuar();
        Hilo3.Continuar();
        Hilo4.Continuar();
        Hilo5.Continuar();
        Hilo6.Continuar();
        Hilo7.Continuar();

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == lm1) {
            Hilo.Pausar();
        }
        if (e.getSource() == lm2) {
            Hilo2.Pausar();
        }
        if (e.getSource() == lm3) {
            Hilo3.Pausar();
        }
        if (e.getSource() == lm4) {
            Hilo4.Pausar();
        }
        if (e.getSource() == lm5) {
            Hilo5.Pausar();
        }
        if (e.getSource() == lm6) {
            Hilo6.Pausar();
        }
        if (e.getSource() == lm7) {
            Hilo7.Pausar();
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
    boolean ban1 = false, ban2 = false, ban3 = false, ban4 = false, ban5 = false, ban6 = false, ban7 = false;

    class Jlabel extends JLabel implements MouseMotionListener {

        public Jlabel(Icon image) {
            super(image);
            addMouseMotionListener(this);
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            setLocation(this.getX() + e.getX() - this.getWidth() / 2, this.getY() + e.getY() - this.getHeight() / 2);

            int x, y;

            if (e.getSource() == lm1) {
                x = lm1.getX();
                y = lm1.getY();
                ban1 = true;
                if (x > 740 && x < 780 && y > 280 && y < 320) {
                    lm1.setLocation(762, 297);
                    lm1.removeMouseMotionListener(this);
                    ban1 = true;

                } else {
                    ban1 = false;
                    
                }

            }

            if (e.getSource() == lm2) {
                x = lm2.getX();
                y = lm2.getY();
                if (x > 600 && x < 640 && y > 100 && y < 130) {
                    lm2.setLocation(620, 117);
                    lm2.removeMouseMotionListener(this);
                    ban2 = true;
                } else {
                    ban2 = false;
                }
            }
            if (e.getSource() == lm3) {
                x = lm3.getX();
                y = lm3.getY();
                if (x > 550 && x < 580 && y > 25 && y < 60) {
                    lm3.setLocation(567, 40);
                    lm3.removeMouseMotionListener(this);
                    ban3 = true;
                } else {
                    ban3 = false;
                }
            }
            if (e.getSource() == lm4) {
                x = lm4.getX();
                y = lm4.getY();
                if (x > 460 && x < 490 && y > 50 && y < 185) {
                    lm4.setLocation(474, 73);
                    lm4.removeMouseMotionListener(this);
                    ban4 = true;
                } else {
                    ban4 = false;
                }
            }
            if (e.getSource() == lm5) {
                x = lm5.getX();
                y = lm5.getY();
                if (x > 630 && x < 660 && y > 240 && y < 265) {
                    lm5.setLocation(645, 256);
                    lm5.removeMouseMotionListener(this);
                    ban5 = true;
                } else {
                    ban5 = false;
                }
            }
            if (e.getSource() == lm6) {
                x = lm6.getX();
                y = lm6.getY();
                if (x > 440 && x < 520 && y > -70 && y < -40) {
                    ban6 = true;
                    lm6.setLocation(480, -63);
                    lm6.removeMouseMotionListener(this);
                } else {
                    ban6 = false;
                }
            }
            if (e.getSource() == lm7) {
                x = lm7.getX();
                y = lm7.getY();
                if (x > 400 && x < 440 && y > -25 && y < -5) {
                    lm7.setLocation(429, -11);
                    lm7.removeMouseMotionListener(lm7);
                    ban7 = true;
                } else {
                    ban7 = false;
                }
            }

            if (ban1) {
                Hilo.stop();

            }

            if (ban2) {
                Hilo2.stop();
            }

            if (ban3) {
                Hilo3.stop();
            }
            if (ban4) {
                Hilo4.stop();
            }
            if (ban5) {
                Hilo5.stop();
            }
            if (ban6) {
                Hilo6.stop();
            }
            if (ban7) {
                Hilo7.stop();
            }
            
             if (ban1==true && ban2==true && ban3==true&& ban4==true&&ban5==true&&ban6==true&&ban7==true ) {
               banresul=true;
                JOptionPane.showMessageDialog(null, "FELICIDADES HA FINALIZADO SU PRUEBA");
                JOptionPane.showMessageDialog(null, "GENERANDO RESULTADOS");
                String[] calificacion = {
            "Bueno",
            "Regular",
            "Malo",
            "Aburrido",
            "¿Eso era un juego?"
        };
        String resp = (String) JOptionPane.showInputDialog(null, "CALIFICA NUESTRO JUEGO", "AYUDANOS A MEJORAR", JOptionPane.DEFAULT_OPTION, null, calificacion,calificacion[0]);

                
                 
                
    
            }
            
            

        }

        @Override
        public void mouseMoved(MouseEvent e) {
            int x = lm7.getX();
            int y = lm7.getY();
            setToolTipText("x: " + Integer.toString(x) + "y: " + Integer.toString(y));

        }

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
                        lm1.setBounds(y, (x - 90), 250, 250);
                        if (x == 0) {
                            Iniciar_Sonido(Sonido);
                            TocoX = false;

                        }
                    }
                }

                if (!TocoX) {
                    if (EstaCorriendo) {
                        x++;
                        lm1.setBounds(y, (x - 90), 250, 250);
                        if (x == getWidth() - 1000) {
                            Iniciar_Sonido(Sonido);
                            TocoX = true;

                        }
                    }
                }
                if (TocoY) {
                    if (EstaCorriendo) {
                        y++;
                        lm1.setBounds(y, (x - 90), 250, 250);
                        if (y == getHeight() - 350) {
                            Iniciar_Sonido(Sonido);
                            TocoY = false;

                        }
                    }
                }
                if (!TocoY) {
                    if (EstaCorriendo) {
                        y--;
                        lm1.setBounds(y, (x - 90), 250, 250);
                        if (y == 0) {
                            Iniciar_Sonido(Sonido);
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

        public void Iniciar_Sonido(Clip C) {
            try {
                C = AudioSystem.getClip();
                // C.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/audios/pong.wav")));
                //C.start();
            } catch (Exception ex) {
                Logger.getLogger(Mapa.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public class Hilo2 extends Thread {

        boolean EstaCorriendo1 = true;
        boolean TocoX1 = true, TocoY1 = true;

        Clip Sonido;

        public Hilo2() {

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
            if (EstaCorriendo1) {
                if (TocoX1) {
                    if (EstaCorriendo1) {
                        x1--;
                        lm2.setBounds(y1, x1, 250, 250);
                        if (x1 == 0) {
                            TocoX1 = false;

                        }
                    }
                }

                if (!TocoX1) {
                    if (EstaCorriendo1) {
                        x1++;
                        lm2.setBounds(y1, x1, 250, 250);
                        if (x1 == getWidth() - 1000) {

                            TocoX1 = true;

                        }
                    }
                }
                if (TocoY1) {
                    if (EstaCorriendo1) {
                        y1++;
                        lm2.setBounds(y1, x1, 250, 250);
                        if (y1 == getHeight() - 350) {

                            TocoY1 = false;

                        }
                    }
                }
                if (!TocoY1) {
                    if (EstaCorriendo1) {
                        y1--;
                        lm2.setBounds(y1, x1, 250, 250);
                        if (y1 == 0) {

                            TocoY1 = true;

                        }
                    }
                }
            }
        }

        public void Pausar() {
            EstaCorriendo1 = false;
        }

        public void Continuar() {
            EstaCorriendo1 = true;
        }
    }

    public class Hilo3 extends Thread {

        boolean EstaCorriendo2 = true;
        boolean TocoX2 = true, TocoY2 = true;

        Clip Sonido;

        public Hilo3() {

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
            if (EstaCorriendo2) {
                if (TocoX2) {
                    if (EstaCorriendo2) {
                        x2--;
                        lm3.setBounds(y2, (x2 + 100), 250, 250);
                        if (x2 == 0) {
                            TocoX2 = false;

                        }
                    }
                }

                if (!TocoX2) {
                    if (EstaCorriendo2) {
                        x2++;
                        lm3.setBounds(y2, (x2 + 100), 250, 250);
                        if (x2 == getWidth() - 1000) {

                            TocoX2 = true;

                        }
                    }
                }
                if (TocoY2) {
                    if (EstaCorriendo2) {
                        y2++;
                        lm3.setBounds(y2, (x2 + 100), 250, 250);
                        if (y2 == getHeight() - 350) {

                            TocoY2 = false;

                        }
                    }
                }
                if (!TocoY2) {
                    if (EstaCorriendo2) {
                        y2--;
                        lm3.setBounds(y2, (x2 + 100), 250, 250);
                        if (y2 == 0) {

                            TocoY2 = true;

                        }
                    }
                }
            }
        }

        public void Pausar() {
            EstaCorriendo2 = false;
        }

        public void Continuar() {
            EstaCorriendo2 = true;
        }

    }

    public class Hilo4 extends Thread {

        boolean EstaCorriendo3 = true;
        boolean TocoX3 = true, TocoY3 = true;

        Clip Sonido;

        public Hilo4() {

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
            if (EstaCorriendo3) {
                if (TocoX3) {
                    if (EstaCorriendo3) {
                        x3--;
                        lm4.setBounds(y3, (x3 + 200), 250, 250);
                        if (x3 == 0) {
                            TocoX3 = false;

                        }
                    }
                }

                if (!TocoX3) {
                    if (EstaCorriendo3) {
                        x3++;
                        lm4.setBounds(y3, (x3 + 200), 250, 250);
                        if (x3 == getWidth() - 1000) {

                            TocoX3 = true;

                        }
                    }
                }
                if (TocoY3) {
                    if (EstaCorriendo3) {
                        y3++;
                        lm4.setBounds(y3, (x3 + 200), 250, 250);
                        if (y3 == getHeight() - 350) {

                            TocoY3 = false;

                        }
                    }
                }
                if (!TocoY3) {
                    if (EstaCorriendo3) {
                        y3--;
                        lm4.setBounds(y3, (x3 + 200), 250, 250);
                        if (y3 == 0) {

                            TocoY3 = true;

                        }
                    }
                }
            }
        }

        public void Pausar() {
            EstaCorriendo3 = false;
        }

        public void Continuar() {
            EstaCorriendo3 = true;
        }

    }

    public class Hilo5 extends Thread {

        boolean EstaCorriendo4 = true;
        boolean TocoX4 = true, TocoY4 = true;

        Clip Sonido;

        public Hilo5() {

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
            if (EstaCorriendo4) {
                if (TocoX4) {
                    if (EstaCorriendo4) {
                        x4--;
                        lm5.setBounds((y4 + 200), (x4 + 200), 250, 250);
                        if (x4 == 0) {
                            TocoX4 = false;

                        }
                    }
                }

                if (!TocoX4) {
                    if (EstaCorriendo4) {
                        x4++;
                        lm5.setBounds((y4 + 200), (x4 + 200), 250, 250);
                        if (x4 == getWidth() - 1000) {

                            TocoX4 = true;

                        }
                    }
                }
                if (TocoY4) {
                    if (EstaCorriendo4) {
                        y4++;
                        lm5.setBounds((y4 + 200), (x4 + 200), 250, 250);
                        if (y4 == getHeight() - 350) {

                            TocoY4 = false;

                        }
                    }
                }
                if (!TocoY4) {
                    if (EstaCorriendo4) {
                        y4--;
                        lm5.setBounds(y4 + 200, (x4 + 200), 250, 250);
                        if (y4 == 0) {

                            TocoY4 = true;

                        }
                    }
                }
            }
        }

        public void Pausar() {
            EstaCorriendo4 = false;
        }

        public void Continuar() {
            EstaCorriendo4 = true;
        }

    }

    public class Hilo6 extends Thread {

        boolean EstaCorriendo5 = true;
        boolean TocoX5 = true, TocoY5 = true;

        Clip Sonido;

        public Hilo6() {

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
            if (EstaCorriendo5) {
                if (TocoX5) {
                    if (EstaCorriendo5) {
                        x5--;
                        lm6.setBounds((y5 + 200), x5, 250, 250);
                        if (x5 == 0) {
                            TocoX5 = false;

                        }
                    }
                }

                if (!TocoX5) {
                    if (EstaCorriendo5) {
                        x5++;
                        lm6.setBounds((y5 + 200), x5, 250, 250);
                        if (x5 == getWidth() - 1000) {

                            TocoX5 = true;

                        }
                    }
                }
                if (TocoY5) {
                    if (EstaCorriendo5) {
                        y5++;
                        lm6.setBounds((y5 + 200), x5, 250, 250);
                        if (y5 == getHeight() - 350) {

                            TocoY5 = false;

                        }
                    }
                }
                if (!TocoY5) {
                    if (EstaCorriendo5) {
                        y5--;
                        lm6.setBounds(y5 + 200, x5, 250, 250);
                        if (y5 == 0) {

                            TocoY5 = true;

                        }
                    }
                }
            }
        }

        public void Pausar() {
            EstaCorriendo5 = false;
        }

        public void Continuar() {
            EstaCorriendo5 = true;
        }

    }

    public class Hilo7 extends Thread {

        boolean EstaCorriendo6 = true;
        boolean TocoX6 = true, TocoY6 = true;

        Clip Sonido;

        public Hilo7() {

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
            if (EstaCorriendo6) {
                if (TocoX6) {
                    if (EstaCorriendo6) {
                        x6--;
                        lm7.setBounds((y6 + 200), x6 + 100, 250, 250);
                        if (x6 == 0) {
                            TocoX6 = false;

                        }
                    }
                }

                if (!TocoX6) {
                    if (EstaCorriendo6) {
                        x6++;
                        lm7.setBounds((y6 + 200), x6 + 100, 250, 250);
                        if (x6 == getWidth() - 1000) {

                            TocoX6 = true;

                        }
                    }
                }
                if (TocoY6) {
                    if (EstaCorriendo6) {
                        y6++;
                        lm7.setBounds((y6 + 200), x6 + 100, 250, 250);
                        if (y6 == getHeight() - 350) {

                            TocoY6 = false;

                        }
                    }
                }
                if (!TocoY6) {
                    if (EstaCorriendo6) {
                        y6--;
                        lm7.setBounds(y6 + 200, x6 + 100, 250, 250);
                        if (y6 == 0) {

                            TocoY6 = true;

                        }
                    }
                }
            }
        }

        public void Pausar() {
            EstaCorriendo6 = false;
        }

        public void Continuar() {
            EstaCorriendo6 = true;
        }

    }

    

}
