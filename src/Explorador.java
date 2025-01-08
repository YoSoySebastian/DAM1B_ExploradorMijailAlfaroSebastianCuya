public class Explorador {
    private String nombre;
    private Posicion posicion;

    public static final String ARRIBA = "W";
    public static final String ABAJO = "S";
    public static final String DERECHA = "D";
    public static final String IZQUIERDA = "A";

    public Explorador(String nombre) {
        this.nombre = nombre;
        int filaAleatoria = (int) (Math.random() * 6);
        this.posicion = new Posicion(filaAleatoria, 0);
    }

    public Posicion getPosicion() {
        return this.posicion;
    }

    public void moverse(String direccion, char[][] mapa) {
        int nuevaFila = posicion.getCoordenadaFila();
        int nuevaCol = posicion.getCoordenadaCol();

        switch (direccion) {
            case ARRIBA:
                if (nuevaFila > 0) nuevaFila--;
                break;
            case ABAJO:
                if (nuevaFila < 5) nuevaFila++;
                break;
            case DERECHA:
                if (nuevaCol < 19) nuevaCol++;
                break;
            case IZQUIERDA:
                if (nuevaCol > 0) nuevaCol--;
                break;
        }
        posicion.setCoordenadaFila(nuevaFila);
        posicion.setCoordenadaCol(nuevaCol);
    }
}