import java.util.*;
import javax.swing.*;

public class Portfolio25 {
    public static void main(String[] args) {

    }
}
class Game{
    private char Player1;
    private char Player2;

    public Game(){

    }
    //setters
    public void setPlayer1(char player1) {
        this.Player1 = player1;
    }
    public void setPlayer2(char player2) {
        this.Player2 = player2;
    }
    //getters
    public char getPlayer1() {
        return Player1;
    }
    public char getPlayer2() {
        return Player2;
    }
    //generador de partida.
    public char getJugada(){
       int tirada = (int)(Math.round((Math.random()*2)%3));
       char jugada;
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
       return jugada;
       }
     public void setGame() {
    	 this.setPlayer1(getJugada);
     }
       
    }
}

