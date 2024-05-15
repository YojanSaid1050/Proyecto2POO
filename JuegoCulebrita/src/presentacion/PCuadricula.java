package presentacion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import logica.Culebrita;
import logica.Manzana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

public class PCuadricula extends JPanel implements KeyListener {
    private static final int FILAS = 15;
    private static final int COLUMNAS = 15;
    private int anchoCelda;
    private int altoCelda;
    private Culebrita culebrita;
    private Manzana manzana;
    private Timer timer;

    public PCuadricula() {
        culebrita = new Culebrita();
        manzana = new Manzana((int) (Math.random() * 15), (int) (Math.random() * 15));
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(this);
        timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moverSerpiente();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        anchoCelda = getWidth() / COLUMNAS;
        altoCelda = getHeight() / FILAS;
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                int x = j * anchoCelda;
                int y = i * altoCelda;
                g2d.setColor(Color.BLACK);
                g2d.drawRect(x, y, anchoCelda, altoCelda);
            }
        }

        int x = culebrita.getColumna() * anchoCelda;
        int y = culebrita.getFila() * altoCelda;
        g2d.setColor(Color.GREEN);
        g2d.fillRect(x, y, anchoCelda, altoCelda);

        x = manzana.getColumna() * anchoCelda;
        y = manzana.getFila() * altoCelda;
        g2d.setColor(Color.RED);
        g2d.fillOval(x, y, anchoCelda, altoCelda);
    }

    public void nuevoJuego() {
        culebrita.nuevoJuego();
        culebrita.setDireccion(1);
        manzana.generarNuevaPosicion();
        timer.start();
        repaint();
        
        ((FCulebrita) SwingUtilities.getWindowAncestor(this)).reiniciarTiempo();
    }


    void moverSerpiente() {
        culebrita.mover();
        
        // Verificar colisión con los bordes del tablero
        if (culebrita.getFila() < 0 || culebrita.getFila() >= FILAS ||
            culebrita.getColumna() < 0 || culebrita.getColumna() >= COLUMNAS) {
            timer.stop();
            JOptionPane.showMessageDialog(this, "¡Has perdido! La serpiente chocó con los bordes del tablero.");
            nuevoJuego();
        }
        
        // Verificar colisión con la manzana
        if (culebrita.getFila() == manzana.getFila() && culebrita.getColumna() == manzana.getColumna()) {
            // Colisión detectada: la serpiente ha alcanzado la manzana
            
            // Generar una nueva posición aleatoria para la manzana
            manzana.generarNuevaPosicion();
            
            // Actualizar el puntaje
            ((FCulebrita) SwingUtilities.getWindowAncestor(this)).actualizarPuntaje();
        }
        
        repaint();
    }


    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Tecla presionada: " + e.getKeyCode());
        culebrita.moverCulebrita(e);
        // Repintar el JPanel después de mover la serpiente
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}