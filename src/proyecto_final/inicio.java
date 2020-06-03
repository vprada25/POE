package proyecto_final;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.paint.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class inicio implements ActionListener {

    JButton inicio, instrucciones, salir;
    JPanel botones, fondo;
    JLabel img;
    JFrame Inicio;
    Mapa_movimiento hilo = new Mapa_movimiento();
    Instruccion ins = new Instruccion();
  

    inicio() {

         
        ctrpanel1();
        //ctrpanel2();
        frame();

    }

    public void ctrpanel1() {

        fondo = new JPanel();
        ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/jugar.png"));
        ImageIcon icono2 = new ImageIcon(getClass().getResource("/imagenes/como_jugar.png"));
        ImageIcon icono3 = new ImageIcon(getClass().getResource("/imagenes/salir.jpg"));
        Image imagen = icono.getImage();
        Image imagen2 = icono2.getImage();
        Image imagen3 = icono3.getImage();
        ImageIcon iconoEscalado = new ImageIcon(imagen.getScaledInstance(80, 80, Image.SCALE_SMOOTH));
        ImageIcon iconoEscalado2 = new ImageIcon(imagen2.getScaledInstance(80, 80, Image.SCALE_SMOOTH));
        ImageIcon iconoEscalado3 = new ImageIcon(imagen3.getScaledInstance(80, 80, Image.SCALE_SMOOTH));

        inicio = new JButton();
        inicio.setBorderPainted(false);
        inicio.setContentAreaFilled(false);
        inicio.setToolTipText("CLICKEA PARA JUGAR");
        inicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        inicio.setIcon(iconoEscalado);
        inicio.setFocusPainted(false);
        inicio.addActionListener(this);
        inicio.setOpaque(false);

        instrucciones = new JButton();
        instrucciones.setIcon(iconoEscalado2);
        instrucciones.addActionListener(this);
        instrucciones.setFocusPainted(false);
        instrucciones.setBorderPainted(false);
        instrucciones.setContentAreaFilled(false);
        instrucciones.setToolTipText("CLICKEA PARA VER COMO JUGAR");
        instrucciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        instrucciones.setOpaque(false);
       

        salir = new JButton();
        salir.setToolTipText("CLICKEA PARA SALIR");
        salir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        salir.addActionListener(this);
        salir.setFocusPainted(false);
        salir.setBorderPainted(false);
        salir.setContentAreaFilled(false);
        salir.setIcon(iconoEscalado3);
        salir.setOpaque(false);

        fondo.setVisible(true);
        fondo.add(inicio);
        fondo.add(instrucciones);
        fondo.add(salir);

    }

    /* public void ctrpanel2() {
        botones = new JPanel();
        botones.setLayout(new GridLayout(1, 1));

        inicio = new JButton("JUGAR");
        inicio.addActionListener(this);
        instrucciones = new JButton("INSTRUCCIONES");
        instrucciones.addActionListener(this);
        salir = new JButton("SALIR");
        salir.addActionListener(this);

        botones.add(inicio);
        botones.add(instrucciones);
        botones.add(salir);

    }*/
    public void frame() {
        Inicio = new JFrame();
        Inicio.setLayout(new BorderLayout());
        Inicio.setSize(500, 500);
        Inicio.setLocationRelativeTo(Inicio);
        img = new JLabel();
        ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/fondo.jpg"));
        Image imagen = icono.getImage();
        ImageIcon iconoEscalado = new ImageIcon(imagen.getScaledInstance(500, 400, Image.SCALE_SMOOTH));
        img.setIcon(iconoEscalado);
        img.setOpaque(false);

        Inicio.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/imagenes/Rompe.png")));

        Inicio.add(img);
        Inicio.setResizable(false);
        Inicio.add(fondo, BorderLayout.SOUTH);
        Inicio.setDefaultCloseOperation(1);
        Inicio.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Inicio.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == salir) {
            System.exit(0);
        }
        if (e.getSource() == inicio) {
            Inicio.setVisible(false);
            Interfaz x = new Interfaz();

        }

        if (e.getSource() == instrucciones) {
            ins.setVisible(true);
            Inicio.setVisible(false);

        }

    }

}
