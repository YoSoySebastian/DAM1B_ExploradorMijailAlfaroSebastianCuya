import java.util.Random;

public class Enemigo {
    private String nombre;
    private Posicion posicionActual;
    private static final int ARRIBA = 1;
    private static final int ABAJO = 2;
    private static final int DERECHA = 3;
    private static final int IZQUIERDA = 4;

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
            case ARRIBA:
                if (fila > 0 && tablero[fila - 1][col] == ' ') fila--;
                break;
            case ABAJO:
                if (fila < 5 && tablero[fila + 1][col] == ' ') fila++;
                break;
            case DERECHA:
                if (col < 19 && tablero[fila][col + 1] == ' ') col++;
                break;
            case IZQUIERDA:
                if (col > 0 && tablero[fila][col - 1] == ' ') col--;
                break;
        }

        posicionActual.setCoordenadaFila(fila);
        posicionActual.setCoordenadaCol(col);
    }

    public void setPosicionActual(Posicion posicionActual){
        this.posicionActual = posicionActual;
    }

    public Posicion getPosicionActual() {
        return posicionActual;
    }
}
