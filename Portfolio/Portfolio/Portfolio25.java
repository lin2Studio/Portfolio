import java.util.*;
import javax.swing.*;

public class Portfolio25 {
    public static void main(String[] args) {

    }
}
//La clase Game es la que contendrá el par de jugadas de player1 y player2, de cada ronda.
class Game{
    private char Player1;
    private char Player2;
    private int Advantage; //esta variable define quien gana en cada juego.
    
//Constructor de clase en blanco, insertaremos los valores con setGame, que es un setter que declara el resultado de Player1 y Player2
    public Game(){
    }
    //setters
    public void setPlayer1(char player1) {
        this.Player1 = player1;
    }
    public void setPlayer2(char player2) {
        this.Player2 = player2;
    }

    public void setAdvantage() {
        if(getPlayer1()==getPlayer2()){
            this.Advantage = 0;
        }
        else if  (getPlayer1()=='R' && getPlayer2()=='S'||
                    getPlayer1()=='S' && getPlayer2()=='P'||
                    getPlayer1()=='P' && getPlayer2()=='R'){
            this.Advantage = 1;
        }
        else{
            this.Advantage = -1;
        }
    }


    //getters
    public char getPlayer1() {
        return Player1;
    }
    public char getPlayer2() {
        return Player2;
    }
    public int getAdvantage() {
        return Advantage;
    }

    //Este método devuelve la elección del jugador (cualquiera), usando el random, pasándolo a base 3 y el resto define el valor.
    // No usé el round a pelo porque me da que la matemática otorga más probabilidad a un número que a los otros.
    // de 0 a 0,44 redondea 0, de 0,45 a 1,44 redondea 1 y de 1,45 a 2 redondea 2... saldrían muchos más 1
    public char getJugada(){
       int tirada = (int)(Math.round((Math.random()*2)%3));
       char jugada='X';
       switch (tirada){
           case 0:
               jugada ='R';
               break;
           case 1:
               jugada ='P';
               break;
           case 2:
               jugada ='S';
               break;
       }
       return jugada;
    }
    //Establecemos las jugadas del Player1 y Player2
    public void setGame(){
        Game HaKenBo = new Game();
        HaKenBo.setPlayer1(getJugada());
        HaKenBo.setPlayer2(getJugada());
        HaKenBo.setAdvantage();
    }
    
}
// Creamos el conjunto de jugadas a petición del usuario usamos un int, así que de 1 a (2^31)-1 vamos ha establecer un máximo de 1000
class gamesArray{
    private ArrayList <Game> Match;
    private int MatchSize;// creamos el tamaño del Array.
    private int Marcador = 0;

    //Constructor del Conjunto de juegos, con la petición de tamaño a través de Terminal.
    public gamesArray(){
        this.Match= new ArrayList <Game> ();
        Scanner sc=new Scanner(System.in);
        System.out.println("¿Cuantas veces jugarán el Player1 contra Player2?\n[Introduzca un valor entre 1 y 1000]");
        this.MatchSize=sc.nextInt();
        for (int i = 0; i < this.MatchSize; i++) {
            Game RockPaperScisors = new Game();
            RockPaperScisors.setGame();
            this.Match.add(RockPaperScisors);
        }
    }
    //Creamos el marcador total del partido.
    public int getMarcador() {
        for (int i = 0; i < Match.size(); i++) {
            this.Marcador=this.Marcador + Match.get(i).getAdvantage();
        }
        return Marcador;
    }

    public String gameResult(){
        if(Marcador>0){
            System.out.println("Player1 WINS");
        }else if(Marcador<0){
            System.out.println("Player2 WINS");
        }else{
            System.out.println("TIE");
        }
    }
}

