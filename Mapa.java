public class Mapa {
    //Del tutorial de los colores
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_ROJO = "\u001B[31m";
    public static final String ANSI_VERDE = "\u001B[32m";
    public static final String ANSI_AZUL = "\u001B[34m";

    private char[][] tablero;
    private Posicion posTesoro;

    public Mapa() {
        tablero = new char[6][20];
        //Se podía hacer un metodo para inicializar el mapa, pero daba igual si lo hacia en el constructor no?
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = ' ';
            }
        }
        generarTesoro();
    }

    //Para generar la posicion aleatoria del tesoro en el mapa
    private void generarTesoro() {
        int fila = (int) (Math.random() * 6);
        int col = (int) (Math.random() * 20);
        posTesoro = new Posicion(fila, col);
    }

    public Posicion getTesoro() {
        return posTesoro;
    }

    public char[][] getTablero() {
        return tablero;
    }

    //Muestra el mapa en la consola y toda la interfaz
    public void mostrar(Posicion jugador, Posicion[] enemigos, Posicion[] trampas, Posicion enemigoInteligente) {
        for (int i = 0; i < 6; i++) {
            System.out.println("----------------------------------------------------------------------------------");
            for (int j = 0; j < 20; j++) {
                System.out.print("| ");

                boolean dibujado = false;

                if (jugador.getCoordenadaFila() == i && jugador.getCoordenadaCol() == j) {
                    System.out.print(ANSI_AZUL + "J" + ANSI_RESET + " ");
                    dibujado = true;
                } else if (enemigoInteligente.getCoordenadaFila() == i && enemigoInteligente.getCoordenadaCol() == j) {
                    System.out.print(ANSI_ROJO + "*" + ANSI_RESET + " ");
                    dibujado = true;
                } else {
                    for (int k = 0; k < enemigos.length; k++) {
                        if (enemigos[k].getCoordenadaFila() == i && enemigos[k].getCoordenadaCol() == j) {
                            System.out.print(ANSI_ROJO + "E" + ANSI_RESET + " ");
                            dibujado = true;
                            break;
                        }
                    }
                }

                if (!dibujado) {
                    for (int k = 0; k < trampas.length; k++) {
                        if (trampas[k].getCoordenadaFila() == i && trampas[k].getCoordenadaCol() == j) {
                            System.out.print(ANSI_VERDE + "T" + ANSI_RESET + " ");
                            dibujado = true;
                            break;
                        }
                    }
                }

                if (!dibujado) {
                    System.out.print(tablero[i][j] + " ");
                }
            }
            System.out.println("|");
        }
        System.out.println("----------------------------------------------------------------------------------");
    }
}