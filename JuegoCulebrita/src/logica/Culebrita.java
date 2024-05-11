package logica;

import java.awt.event.KeyEvent;

public class Culebrita {
    private int fila;
    private int columna;
    private int direccion;

    public Culebrita() {
        this.fila = (int) (Math.random() * 15);
        this.columna = (int) (Math.random() * 15);
        this.direccion = 1;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public void moverCulebrita(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_UP && direccion != 2) {
            direccion = 0; // Arriba
        } else if (keyCode == KeyEvent.VK_RIGHT && direccion != 3) {
            direccion = 1; // Derecha
        } else if (keyCode == KeyEvent.VK_DOWN && direccion != 0) {
            direccion = 2; // Abajo
        } else if (keyCode == KeyEvent.VK_LEFT && direccion != 1) {
            direccion = 3; // Izquierda
        }
    }

    public void mover() {
        switch (direccion) {
            case 0: // Arriba
                fila--;
                break;
            case 1: // Derecha
                columna++;
                break;
            case 2: // Abajo
                fila++;
                break;
            case 3: // Izquierda
                columna--;
                break;
        }
    }

    public void nuevoJuego() {
        fila = (int) (Math.random() * 15);
        columna = (int) (Math.random() * 15);
        direccion = 1;
    }
}
