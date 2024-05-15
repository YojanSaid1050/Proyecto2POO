package presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FCulebrita extends JFrame {
    private PCuadricula pCuadricula;
    private JButton bNuevoJuego;
    private JLabel lPuntaje;
    private JLabel lTiempo;
    private Timer timer;
    private int segundos;

    public FCulebrita() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setTitle("Culebrita");

        JPanel pSuperior = new JPanel();
        pSuperior.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        bNuevoJuego = new JButton("Nuevo Juego");
        bNuevoJuego.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nuevoJuego();
            }
        });

        lPuntaje = new JLabel("Puntaje: 0");
        lTiempo = new JLabel("Tiempo: 0s");

        pSuperior.add(bNuevoJuego);
        pSuperior.add(lPuntaje);
        pSuperior.add(lTiempo);

        add(pSuperior, BorderLayout.NORTH);

        pCuadricula = new PCuadricula();
        add(pCuadricula, BorderLayout.CENTER);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                segundos++;
                lTiempo.setText("Tiempo: " + segundos + "s");
            }
        });

        setVisible(true);
    }

    private void nuevoJuego() {
        segundos = 0;
        lPuntaje.setText("Puntaje: 0");
        lTiempo.setText("Tiempo: 0s");

        timer.start();

        pCuadricula.nuevoJuego();
    }
    
    public void reiniciarTiempo() {
        segundos = 0;
        lTiempo.setText("Tiempo: " + segundos + "s");
    }


    public static void main(String[] args) {
        new FCulebrita();
    }
}