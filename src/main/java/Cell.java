import java.util.Objects;

public class Cell {
    int fila;
    int columna;
    public Cell(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    @Override
    public String toString() {
        return "Cell [" + fila +" , " + columna + ']';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return fila == cell.fila && columna == cell.columna;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fila, columna);
    }
}
