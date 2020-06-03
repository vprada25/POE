package proyecto_final;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

public class resultado extends JFrame implements ActionListener {

    JLabel texto;
    JButton close;
    JLabel cuadro;
    String time;

    public resultado(String time) {
        this.time = time;
        setTitle("RESULTADOS");
        setSize(350, 400);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/fondo1.jpg")).getImage());
        getContentPane().setBackground(Color.blue);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);

        cuadro = new JLabel();
        cuadro.setBounds(0, 0, 350, 400);
        cuadro.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/resultado.jpg")).getImage().getScaledInstance(cuadro.getWidth(), cuadro.getHeight(), Image.SCALE_DEFAULT)));

        texto = new JLabel();
        texto.setBounds(0, 0, 350, 400);
        texto.setFont(new Font("Comic Sans MS", Font.ITALIC, 23));
        texto.setHorizontalAlignment(JLabel.CENTER);
        texto.setForeground(Color.black);
        texto.setBackground(new Color(0, 0, 0, 0));

        close = new JButton();
        close.setBounds(220, 320, 50, 50);
        close.setToolTipText("CLICKEA PARA VOLVER A JUGAR");
        close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        close.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/bien.png")).getImage().getScaledInstance(close.getHeight(), close.getWidth(), Image.SCALE_DEFAULT)));
        close.setFocusable(false);
        close.setContentAreaFilled(false);
        close.setBorder(null);

        close.addActionListener(this);

        add(close);
        add(texto);
        add(cuadro);
        

        setVisible(false);
    }

    public void tex(String time) {
        
        String text = "<html><body>SU PRUEBA FINALIZO <br><br> SU PUNTAJE ES : "+time+" <br><br> GRACIAS POR JUGAR" + "<br>" +  "<br> " + "</body></html>";
        texto.setText(text);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        setVisible(false);
        inicio in = new inicio();

    }

}
