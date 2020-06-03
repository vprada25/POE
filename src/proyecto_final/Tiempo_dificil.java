package proyecto_final;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Tiempo_dificil extends   Thread {

    JLabel k, pu;
    int i, puntaje = 1000;
    Interfaz frame;
    Mapa m ;
    String time, time2;

    public Tiempo_dificil(JLabel l, JLabel p, int h, Interfaz frame) {
        k = l;
        pu = p;
        i = h;
        this.frame = frame;
        time = "";
    }

    public void setI(int i) {
        this.i = i;
    }

    public void run() {
        for (i = 0; i > 0 - 1; i--) {
            for (int j = 20; j > -1; j--) {
                time = ((i < 10) ? "0" + i : i + "") + (j < 10 ? ":0" + j : ":" + j);
                puntaje = puntaje - j;
                time2 = Integer.toString(puntaje);
                k.setText(time);
                pu.setText("PUNTAJE: " + time2);
                try {
                    Thread.sleep(999);
                } catch (InterruptedException ex) {
                }
            }
           
         
            if (i == 0) {
                frame.dispose();
                resultado resul = new resultado(time);
                resul.tex(time2);
                resul.setVisible(true);

                //frame.Cerrar();
            }
        }
    }

}
