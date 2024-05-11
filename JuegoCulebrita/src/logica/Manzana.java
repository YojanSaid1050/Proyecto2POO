package logica;

public class Manzana {
    private int fila;
    private int columna;

    public Manzana(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void generarNuevaPosicion() {
        this.fila = (int) (Math.random() * 15);
        this.columna = (int) (Math.random() * 15);
    }
}
