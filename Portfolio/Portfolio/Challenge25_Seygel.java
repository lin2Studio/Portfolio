import java.util.*;


public class Challenge25_Seygel {
    public static void main(String[] args) {
        partido miPartido = new partido();
      //  System.out.println(miPartido.getMarcador());
        System.out.println(miPartido.resultadoPartido());
    }
}
class juego{
    private char Player1;
    private char Player2;
    public juego(){
    }
                                                //setters
    public void setPlayer1(char player1) {
        Player1 = player1;
    }
    public void setPlayer2(char player2) {
        Player2 = player2;
    }
                                                //getters
    public char getPlayer1() {
        return Player1;
    }
    public char getPlayer2() {
        return Player2;
    }
                                                //Establecemos la elección random de piedra papel o tijeras.
    public char getJugada() {
        int tirada = (int) (Math.round((Math.random() * 2) % 3));
        return switch (tirada) {
            case 0 -> 'r';
            case 1 -> 'p';
            case 2 -> 's';
            default -> 'x';
        };
    }
                                                //Creamos un juego de Player1 vs Player2 de manera aleatoria.
    public void setJuego(){
        this.setPlayer1(getJugada());
        this.setPlayer2(getJugada());
    }
                                                //Establecemos el ganador del juego, retornando un 1 si gana Player1, -1 si gana Player2 y 0 si es empate.
    public int getVentaja(){
        if
        (getPlayer1()==getPlayer2()){
            return 0;
        }
        else if
        (getPlayer1()=='r' && getPlayer2()=='s'||
         getPlayer1()=='s' && getPlayer2()=='p'||
         getPlayer1()=='p' && getPlayer2()=='r'){
            return 1;
        }
        else
        {
            return -1;
        }
    }
}

class partido{
    private int Marcador;

    partido(){
        ArrayList <juego> HaKenBo = new ArrayList<>();
        int MatchSize;
        this.Marcador = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuántas veces quieres que juegen el Player1 contra el Player2?\n [Inserta valores entre 1 y 10.000]");
        MatchSize=sc.nextInt();

        for (int i = 0; i < MatchSize; i++) {
            juego pPT =new juego();                 //pPT = piedraPapelTijeras.
            pPT.setJuego();
            this.Marcador=this.Marcador+pPT.getVentaja();
          //System.out.println("P1: "+pPT.getPlayer1()+" P2: "+pPT.getPlayer2()+" Ventaja: "+pPT.getVentaja()); //Esta linea plotea los juegos  individualmente.
            HaKenBo.add(pPT);
        }
    }

    public int getMarcador() {
        return Marcador;
    }
    public String resultadoPartido(){
        if (Marcador>0){
            return "Player1";
        }
        else if (Marcador<0){
            return "Player2";
        }
        return "Tie";
    }
}