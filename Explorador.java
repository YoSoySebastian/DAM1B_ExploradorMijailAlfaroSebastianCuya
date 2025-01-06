import java.util.Random;

public class Explorador {
    private String nombre;
    private Posicion posicionActual;
    private static final int ARRIBA = 1;
    private static final int ABAJO = 2;
    private static final int DERECHA = 3;
    private static final int IZQUIERDA = 4;

    public Explorador(String nombre){
        this.nombre = nombre;
        Random random = new Random();
        int filaAleatoria = random.nextInt(6);
        this.posicionActual = new Posicion(filaAleatoria, 0);
    }

    public String getNombre() {
        return nombre;
    }

    public Posicion getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(Posicion posicionActual) {
        this.posicionActual = posicionActual;
    }

    public void moverse(int direccion){
        int Fila = posicionActual.getCoordenadaFila();
        int Col = posicionActual.getCoordenadaCol();

        switch (direccion) {
            case ARRIBA:
                if (Fila > 0) Fila--;
                break;
            case ABAJO:
                if (Fila < 5) Fila++;
                break;
            case DERECHA:
                if (Col < 19) Col++;
                break;
            case IZQUIERDA:
                if (Col > 0) Col--;
                break;
        }

        posicionActual.setCoordenadaFila(Fila);
        posicionActual.setCoordenadaCol(Col);
    }
}
