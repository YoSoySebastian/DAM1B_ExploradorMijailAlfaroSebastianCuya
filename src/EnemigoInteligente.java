public class EnemigoInteligente {
    private Posicion posicion;

    public EnemigoInteligente() {
        int filaAleatoria = (int) (Math.random() * 6);
        int colAleatoria = (int) (Math.random() * 20);
        this.posicion = new Posicion(filaAleatoria, colAleatoria);
    }

    public Posicion getPosicion() {
        return this.posicion;
    }

    public void moverse(Posicion posicionExplorador, char[][] mapa) {
        int filaActual = posicion.getCoordenadaFila();
        int colActual = posicion.getCoordenadaCol();
        int filaObjetivo = posicionExplorador.getCoordenadaFila();
        int colObjetivo = posicionExplorador.getCoordenadaCol();


        //Movimiento vertical
        if (filaActual != filaObjetivo) {
            if (filaActual < filaObjetivo) {
                filaActual++;
            } else {
                filaActual--;
            }

        //Movimiento horizontal
        } else if (colActual != colObjetivo) {
            if (colActual < colObjetivo) {
                colActual++;
            } else {
                colActual--;
            }
        }

        if (esMovimientoValido(filaActual, colActual, mapa)) {
            posicion.setCoordenadaFila(filaActual);
            posicion.setCoordenadaCol(colActual);
        }
    }

    private boolean esMovimientoValido(int fila, int col, char[][] mapa) {
        return fila >= 0 && fila < 6 && col >= 0 && col < 20 && mapa[fila][col] == ' ';
    }
}