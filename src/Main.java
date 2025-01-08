import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Presentacion del juego
        System.out.println("*******************************************************");
        System.out.println("Bienvenido al juego del explorador");
        System.out.println("*******************************************************");

        //Creacion de mapa, jugador, rampas, enemigo inteligente y enemigos.
        Mapa mapa = new Mapa();
        Explorador explorador = new Explorador("Jugador");
        Enemigo[] enemigos = {new Enemigo("Enemigo1"), new Enemigo("Enemigo2"), new Enemigo("Enemigo3")};
        Posicion[] trampas = generarTrampas();
        EnemigoInteligente enemigoInteligente = new EnemigoInteligente();

        Scanner scanner = new Scanner(System.in);
        //Para entrar en un bucle para que el juego siga activo
        boolean juegoEnCurso = true;

        while (juegoEnCurso) {
            mapa.mostrar(explorador.getPosicion(), obtenerPosicionesEnemigos(enemigos), trampas, enemigoInteligente.getPosicion());
            //Los movimientos que podemos realizar con WASD tanto en mayuscula como en minuscula (Era mas comodo que con 1234 y solo tenia que hacer un uppercase par que cuadrase)
            System.out.println("Tu turno: Ingresa W (Arriba), S (Abajo), D (Derecha), A (Izquierda):");
            String movimiento = scanner.next();
            movimiento = movimiento.toUpperCase();
            explorador.moverse(movimiento, mapa.getTablero());

            if (verificarEstadoJuego(explorador.getPosicion(), enemigos, trampas, enemigoInteligente, mapa.getTesoro())) {
                juegoEnCurso = false;
                break;
            }

            for (int i = 0; i < enemigos.length; i++) {
                enemigos[i].moverse(mapa.getTablero());
            }

            enemigoInteligente.moverse(explorador.getPosicion(), mapa.getTablero());

            if (verificarEstadoJuego(explorador.getPosicion(), enemigos, trampas, enemigoInteligente, mapa.getTesoro())) {
                juegoEnCurso = false;
            }
        }
    }

    //Genera las trampas en posiciones aleatorias
    private static Posicion[] generarTrampas() {
        Posicion[] trampas = new Posicion[3];
        for (int i = 0; i < 3; i++) {
            int fila, col;
            boolean posicionValida;
            do {
                posicionValida = true;
                fila = (int) (Math.random() * 6);
                col = (int) (Math.random() * 20);
                for (int j = 0; j < i; j++) {
                    //Para verificar si la posicion es valida y no se solape con otras trampas
                    if (Math.abs(trampas[j].getCoordenadaFila() - fila) < 3 && Math.abs(trampas[j].getCoordenadaCol() - col) < 3) {
                        posicionValida = false;
                        break;
                    }
                }
            } while (!posicionValida);
            trampas[i] = new Posicion(fila, col);
        }
        return trampas;
    }

    //
    private static Posicion[] obtenerPosicionesEnemigos(Enemigo[] enemigos) {
        Posicion[] posiciones = new Posicion[enemigos.length];
        for (int i = 0; i < enemigos.length; i++) {
            posiciones[i] = enemigos[i].getPosicion();
        }
        return posiciones;
    }

    //Condiciones de victoria y derrota, en caso de caer en una trampa, enemigo o el enemigointeligente, perderemos.
    //Si tocamos el tesoro, ganamos
    private static boolean verificarEstadoJuego(Posicion jugador, Enemigo[] enemigos, Posicion[] trampas, EnemigoInteligente enemigoInteligente, Posicion tesoro) {
        for (int i = 0; i < trampas.length; i++) {
            if (jugador.getCoordenadaFila() == trampas[i].getCoordenadaFila() && jugador.getCoordenadaCol() == trampas[i].getCoordenadaCol()) {
                System.out.println("Has caído en una trampa. ¡Perdiste!");
                return true;
            }
        }

        for (int i = 0; i < enemigos.length; i++) {
            if (jugador.getCoordenadaFila() == enemigos[i].getPosicion().getCoordenadaFila() && jugador.getCoordenadaCol() == enemigos[i].getPosicion().getCoordenadaCol()) {
                System.out.println("Un enemigo te atrapó. ¡Perdiste!");
                return true;
            }
        }

        if (jugador.getCoordenadaFila() == enemigoInteligente.getPosicion().getCoordenadaFila() && jugador.getCoordenadaCol() == enemigoInteligente.getPosicion().getCoordenadaCol()) {
            System.out.println("El enemigo inteligente te atrapó. ¡Perdiste!");
            return true;
        }

        if (jugador.getCoordenadaFila() == tesoro.getCoordenadaFila() && jugador.getCoordenadaCol() == tesoro.getCoordenadaCol()) {
            System.out.println("¡Encontraste el tesoro! ¡Ganaste!");
            return true;
        }

        return false;
    }
}