import java.util.Scanner;
import javax.swing.*;
public class GameTresEnRaya implements Game{
    private Player player1,player2,playerturn;;
    private Board board;
    private Adapter adapter;
    private boolean finished;

    Scanner sc = new Scanner(System.in);
    public GameTresEnRaya(){
        this.board      =   new Board(3,"Tres en Raya");
        this.finished   =   false;
        player1 = new Player();
        player2 = new Player();
        
        playerturn      =player1;
        this.adapter = new Adapter();
    }
    public void iniciarJugadores(){
        String nom1=JOptionPane.showInputDialog(null, "Introduce el nombre del primer jugador");
        player1.setName(nom1);
        player1.setSymbol('x');
        String nom2=JOptionPane.showInputDialog(null, "Introduce el nombre del segundo jugador");
        player2.setName(nom2);
        player2.setSymbol('o');
    }
    public int[] jugada(Player player,String jugada){
        board.setBox(adapter.AdapterJugada(jugada), player.getSymbol());
        return adapter.AdapterJugada(jugada);
    }
    public void Start(){
        this.finished=false;
    }
        public boolean isFinished(Player player){
            for(int i=0;i<3;i++) {
                if(board.getBox(0, i)!=null && board.getBox(0, i).getData()==player.getSymbol() &&
                board.getBox(1, i)!=null && board.getBox(1, i).getData()==player.getSymbol() &&
                board.getBox(2, i)!=null && board.getBox(2, i).getData()==player.getSymbol()) {
                    finished=true;
                    return true;
                }
                if(board.getBox(i, 0)!=null && board.getBox(i, 0).getData()==player.getSymbol() &&
                board.getBox(i, 1)!=null && board.getBox(i, 1).getData()==player.getSymbol() &&
                board.getBox(i, 2)!=null && board.getBox(i, 2).getData()==player.getSymbol()) {
                    finished=true;
                    return true;
                }
            }
            if(board.getBox(0, 0)!=null && board.getBox(0, 0).getData()==player.getSymbol() &&
            board.getBox(1, 1)!=null && board.getBox(1, 1).getData()==player.getSymbol() &&
            board.getBox(2, 2)!=null && board.getBox(2, 2).getData()==player.getSymbol()) {
                finished=true;
                return true;
            }
            if(board.getBox(0, 2)!=null && board.getBox(0, 2).getData()==player.getSymbol() &&
            board.getBox(1, 1)!=null && board.getBox(1, 1).getData()==player.getSymbol() &&
            board.getBox(2, 0)!=null && board.getBox(2, 0).getData()==player.getSymbol()) {
                finished=true;
                return true;
            }        
            return false;
        
    }
    public Player getPlayer1() {
        return player1;
    }
    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }
    public Player getPlayer2() {
        return player2;
    }
    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }
    public Board getBoard() {
        return board;
    }
    public void setBoard(Board board) {
        this.board = board;
    }
    public Player getPlayerMoved(){
        Player temp = playerturn;
        if(temp.Compare(player1)){
            playerturn=player2;
        }else{
            playerturn=player1;
        }
        return temp;
    }

    public Player getPlayerturn() {
        return playerturn;
    }

    public void setPlayerturn(Player playerturn) {
        this.playerturn = playerturn;
    }
}