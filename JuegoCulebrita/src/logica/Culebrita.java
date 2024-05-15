package logica;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Culebrita {
    private List<int[]> cuerpo;
    private int direccion;

    public Culebrita() {
        this.cuerpo = new ArrayList<>();
        cuerpo.add(new int[]{(int) (Math.random() * 15), (int) (Math.random() * 15)});
        this.direccion = 1;
    }

    public List<int[]> getCuerpo() {
        return cuerpo;
    }

    public int[] getCabeza() {
        return cuerpo.get(0);
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
            direccion = 0; 
        } else if (keyCode == KeyEvent.VK_RIGHT && direccion != 3) {
            direccion = 1; 
        } else if (keyCode == KeyEvent.VK_DOWN && direccion != 0) {
            direccion = 2; 
        } else if (keyCode == KeyEvent.VK_LEFT && direccion != 1) {
            direccion = 3; 
        }
    }

    public void mover() {
        int[] cabeza = getCabeza();
        int[] nuevaCabeza = new int[2];
        switch (direccion) {
            case 0:
                nuevaCabeza[0] = cabeza[0] - 1;
                nuevaCabeza[1] = cabeza[1];
                break;
            case 1:
                nuevaCabeza[0] = cabeza[0];
                nuevaCabeza[1] = cabeza[1] + 1;
                break;
            case 2:
                nuevaCabeza[0] = cabeza[0] + 1;
                nuevaCabeza[1] = cabeza[1];
                break;
            case 3:
                nuevaCabeza[0] = cabeza[0];
                nuevaCabeza[1] = cabeza[1] - 1;
                break;
        }
        cuerpo.add(0, nuevaCabeza);
        cuerpo.remove(cuerpo.size() - 1);
    }

    public void crecer() {
        int[] cabeza = getCabeza();
        int[] nuevaCabeza = new int[2];
        switch (direccion) {
            case 0:
                nuevaCabeza[0] = cabeza[0] - 1;
                nuevaCabeza[1] = cabeza[1];
                break;
            case 1:
                nuevaCabeza[0] = cabeza[0];
                nuevaCabeza[1] = cabeza[1] + 1;
                break;
            case 2:
                nuevaCabeza[0] = cabeza[0] + 1;
                nuevaCabeza[1] = cabeza[1];
                break;
            case 3:
                nuevaCabeza[0] = cabeza[0];
                nuevaCabeza[1] = cabeza[1] - 1;
                break;
        }
        cuerpo.add(0, nuevaCabeza);
    }

    public void nuevoJuego() {
        cuerpo.clear();
        cuerpo.add(new int[]{(int) (Math.random() * 15), (int) (Math.random() * 15)});
        direccion = 1;
    }
}
