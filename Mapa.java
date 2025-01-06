public class Mapa {
    private char[][] tablero = new char[6][20];
    private Posicion posTesoro;
    private Posicion posJugador;
    private Enemigo[] listadoEnemigos = new Enemigo[3];
    private Posicion[] posicionTrampas = new Posicion[3];

    public Mapa(){
        //Pendiente
    }

    public char[][] getTablero(){
        return tablero;
    }

    public Posicion getPosTesoro() {
        return posTesoro;
    }

    public void mostrar(){
        //Pendiente
    }
}
