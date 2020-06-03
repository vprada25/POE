package proyecto_final;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author victo
 */
public class Interfaz extends JFrame implements ActionListener {

    PanelFondo p1, p2, p3, p4;
    JRadioButton facil, medio, dificil;

    JLabel time, puntaje, fondo;
    Tiempo_facil thread;
    Tiempo_medio threadm;
    Tiempo_dificil threadd;
    JButton b1, b2, b3, pausar, salir, reanudar;

    Mapa mapa = new Mapa();
    Mapa_movimiento mapa_movimiento = new Mapa_movimiento();
    resultado Resul;

    // fondo Fondo= new fondo();
    public Interfaz() {

        setLayout(null);
        setSize(1210, 630);
        setBackground(Color.yellow);
        setLocationRelativeTo(null);
        setTitle("JUEGO GEOGRAFIA");
        setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/imagenes/Rompe.png")));

        //setContentPane(new JLabel(new ImageIcon("/imagenes/fondo.jpg")));
        facil = new JRadioButton("FACIL", false);
        facil.addActionListener(this);
        facil.setOpaque(false);

        medio = new JRadioButton("MEDIO", false);
        medio.addActionListener(this);
        medio.setOpaque(false);

        dificil = new JRadioButton("DIFICIL", false);
        dificil.addActionListener(this);
        dificil.setOpaque(false);

        ButtonGroup difi = new ButtonGroup();

        difi.add(facil);
        difi.add(medio);
        difi.add(dificil);

        ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/pausar.png"));
        Image imagen = icono.getImage();
        ImageIcon iconoEscalado = new ImageIcon(imagen.getScaledInstance(70, 70, Image.SCALE_SMOOTH));

        ImageIcon icono2 = new ImageIcon(getClass().getResource("/imagenes/reanudar.png"));
        Image imagen2 = icono2.getImage();
        ImageIcon iconoEscalado2 = new ImageIcon(imagen2.getScaledInstance(70, 70, Image.SCALE_SMOOTH));

        ImageIcon icono3 = new ImageIcon(getClass().getResource("/imagenes/salir.jpg"));
        Image imagen3 = icono3.getImage();
        ImageIcon iconoEscalado3 = new ImageIcon(imagen3.getScaledInstance(70, 70, Image.SCALE_SMOOTH));

        salir = new JButton();
        salir.setBounds(350, 20, 200, 80);
        salir.addActionListener(this);
        salir.setVisible(false);
        salir.setBorderPainted(false);
        salir.setContentAreaFilled(false);
        salir.setToolTipText("CLICKEA PARA SALIR");
        salir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        salir.setIcon(iconoEscalado3);
        salir.setFocusPainted(false);
        salir.setOpaque(false);

        reanudar = new JButton();
        reanudar.setBounds(700, 20, 100, 80);
        reanudar.addActionListener(this);
        reanudar.setVisible(false);
        reanudar.setBorderPainted(false);
        reanudar.setContentAreaFilled(false);
        reanudar.setToolTipText("CLICKEA PARA REANUDAR");
        reanudar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        reanudar.setIcon(iconoEscalado2);
        reanudar.setFocusPainted(false);

        pausar = new JButton();
        pausar.setBounds(100, 20, 200, 80);
        pausar.setBorderPainted(false);
        pausar.setOpaque(false);
        pausar.setContentAreaFilled(false);
        pausar.setToolTipText("CLICKEA PARA PAUSAR");
        pausar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pausar.setIcon(iconoEscalado);
        pausar.setFocusPainted(false);
        pausar.addActionListener(this);
        pausar.setVisible(false);

        facil.setBounds(100, 15, 200, 30);
        medio.setBounds(350, 15, 200, 30);
        dificil.setBounds(600, 15, 100, 30);

        p1 = new PanelFondo("/imagenes/fondo2.png");
        p2 = new PanelFondo("/imagenes/fondo_time.jpg");
        p3 = new PanelFondo("/imagenes/fondo2.png");
        p4 = new PanelFondo("/imagenes/fondo_time.jpg");

        p1.setBorder(BorderFactory.createTitledBorder("MAPA"));
        p1.setBounds(0, 0, 800, 500);

        p2.setBounds(0, 500, 800, 100);
        p2.setOpaque(false);

        p2.setBorder(BorderFactory.createTitledBorder("PANEL BOTONES"));
        p2.setLayout(null);

        p3.setBounds(800, 0, 400, 500);
        mapa_movimiento.setBounds(800, 0, 400, 500);

        p3.setBorder(BorderFactory.createTitledBorder("MAPAS MOVIMIENTOS"));

        p4.setBounds(800, 500, 400, 100);
        p4.setBorder(BorderFactory.createTitledBorder("PANEL PUNTAJE-TIEMPO"));

        time = new JLabel();
        time.setOpaque(false);
        time.setForeground(Color.red);
        //time.setBackground(new Color(95, 209, 236));
        time.setBorder(BorderFactory.createTitledBorder("TIEMPO"));
        time.setHorizontalAlignment(JLabel.CENTER);
        time.setFont(new Font("Comic Sans MS", Font.ITALIC, 25));
        //time.setBounds(380, 20, 120, 50);
        puntaje = new JLabel();
        puntaje.setOpaque(false);
        puntaje.setForeground(Color.red);
        puntaje.setBorder(BorderFactory.createTitledBorder("PUNTAJE"));
        puntaje.setHorizontalAlignment(JLabel.CENTER);
        puntaje.setFont(new Font("Comic Sans MS", Font.ITALIC, 25));

        thread = new Tiempo_facil(time, puntaje, 4, this);
        threadm = new Tiempo_medio(time, puntaje, 4, this);
        threadd = new Tiempo_dificil(time, puntaje, 4, this);
        //thread = new Tiempo(puntaje, 4, this);

        thread.suspend();
        threadm.suspend();
        threadd.suspend();

        // thread.suspend();
        mapa.setBounds(0, 0, 1210, 500);
        //mapa.setBackground(Color.yellow);
        // Fondo.setBounds(0,0,800,500);   

        // mapa_movimiento.setBackground(Color.red);
        mapa.lm1.setVisible(false);
        mapa.lm2.setVisible(false);
        mapa.lm3.setVisible(false);
        mapa.lm4.setVisible(false);
        mapa.lm5.setVisible(false);
        mapa.lm6.setVisible(false);
        mapa.lm7.setVisible(false);
        p1.add(mapa);
        p2.add(facil);
        p2.add(medio);
        p2.add(dificil);
        p2.add(salir);
        //p2.add(pausar);
        //p2.add(reanudar);
        // p3.add(mapa_movimiento);
        p4.add(time);
        p4.add(puntaje);

        //add(p1);
        add(p2);
        // add(p3);
        add(p4);
        add(mapa);
        //add(mapa_movimiento);

        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == facil) {
            thread.start();
            //thread.resume();
            //threadm.start(); 

            mapa.iniciar();
            dificil.setVisible(false);
            medio.setVisible(false);
            facil.setVisible(false);
            pausar.setVisible(true);
            salir.setVisible(true);
            mapa.lm1.setVisible(true);
            mapa.lm2.setVisible(true);
            mapa.lm3.setVisible(true);
            mapa.lm4.setVisible(true);
            mapa.lm5.setVisible(true);
            mapa.lm6.setVisible(true);
            mapa.lm7.setVisible(true);

        }
        if (e.getSource() == medio) {
            mapa.lm1.setVisible(true);
            mapa.lm2.setVisible(true);
            mapa.lm3.setVisible(true);
            mapa.lm4.setVisible(true);
            mapa.lm5.setVisible(true);
            mapa.lm6.setVisible(true);
            mapa.lm7.setVisible(true);

            threadm.start();
            mapa.iniciar();
            facil.setVisible(false);
            dificil.setVisible(false);
            medio.setVisible(false);
            pausar.setVisible(true);
            salir.setVisible(true);
            //reanudar.setVisible(true);

        }
        if (e.getSource() == dificil) {
            mapa.lm1.setVisible(true);
            mapa.lm2.setVisible(true);
            mapa.lm3.setVisible(true);
            mapa.lm4.setVisible(true);
            mapa.lm5.setVisible(true);
            mapa.lm6.setVisible(true);
            mapa.lm7.setVisible(true);

            threadd.start();
            //threadm.start();
            mapa.iniciar();
            facil.setVisible(false);
            medio.setVisible(false);
            pausar.setVisible(true);
            salir.setVisible(true);
            dificil.setVisible(false);
            //reanudar.setVisible(true);

        }
        if (e.getSource() == pausar) {
            thread.suspend();
            threadd.suspend();
            threadm.suspend();
            pausar.setVisible(false);
            reanudar.setVisible(true);

        }
        if (e.getSource() == reanudar) {
            thread.resume();
            threadd.resume();
            threadm.resume();
            pausar.setVisible(true);
            reanudar.setVisible(false);

        }
        if (e.getSource() == salir) {
            dispose();
            inicio c = new inicio();
        }

    }

}
