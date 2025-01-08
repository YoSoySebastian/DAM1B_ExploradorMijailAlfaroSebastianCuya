import java.util.Random;

public class Enemigo {
    private String nombre;
    private Posicion posicionActual;

    public Enemigo(String nombre) {
        this.nombre = nombre;
        Random random = new Random();
        int filaAleatoria = random.nextInt(6);
        int colAleatoria = random.nextInt(20);
        this.posicionActual = new Posicion(filaAleatoria, colAleatoria);
    }

    public void moverse(char[][] tablero) {
        Random random = new Random();
        int direccion = random.nextInt(4) + 1;
        int fila = posicionActual.getCoordenadaFila();
        int col = posicionActual.getCoordenadaCol();

        switch (direccion) {
            case 1:
                if (fila > 0 && tablero[fila - 1][col] == ' ') fila--;
                break;
            case 2:
                if (fila < 5 && tablero[fila + 1][col] == ' ') fila++;
                break;
            case 3:
                if (col < 19 && tablero[fila][col + 1] == ' ') col++;
                break;
            case 4:
                if (col > 0 && tablero[fila][col - 1] == ' ') col--;
                break;
        }

        posicionActual.setCoordenadaFila(fila);
        posicionActual.setCoordenadaCol(col);
    }

    public Posicion getPosicion() {
        return this.posicionActual;
    }
}