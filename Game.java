import java.util.*;
import javax.swing.*;
import java.awt.*;
public class Game{
    public Scanner scanner=new Scanner(System.in);
    private Player player1,player2;
    private Board board;
    private boolean finished;
    private int num_jugadas;
    public int getNum_Jugadas(){
        return num_jugadas;
    }
    public void setNum_Jugadas(int num_jugadas){
        this.num_jugadas=num_jugadas;
    }
    public Player getPlayer1(){
        return player1;
    }
    public Player getPlayer2(){
        return player2;
    }
    public Board getBoard(){
        return board;
    }
    public boolean isFinished(){
        if(finished==true)return true;
        else{
            for(int i=0;i<3;i++) {
                if(board.getBoxes()[i].isMarked()&&board.getBoxes()[i+3].isMarked()&&board.getBoxes()[i+6].isMarked()) {
                    JOptionPane.showMessageDialog(null, "Gano X");
                    Finish();
                }
                if(board.getBoxes()[i*3].isMarked()&&board.getBoxes()[i*3+1].isMarked()&&board.getBoxes()[i*3+2].isMarked()) {
                    JOptionPane.showMessageDialog(null, "Gano X");
                    Finish();
                }
            }
            if(board.getBoxes()[0].isMarked()&&board.getBoxes()[4].isMarked()&&board.getBoxes()[8].isMarked()) {
                JOptionPane.showMessageDialog(null, "Gano X");
                Finish();
            }
            if(board.getBoxes()[2].isMarked()&&board.getBoxes()[4].isMarked()&&board.getBoxes()[6].isMarked()) {
                JOptionPane.showMessageDialog(null, "Gano X");
                Finish();
            }
            for(int i=0;i<3;i++) {
                if(board.getBoxes()[i].isFilled()&&board.getBoxes()[i+3].isFilled()&&board.getBoxes()[i+6].isFilled()) {
                    JOptionPane.showMessageDialog(null, "Gano O");
                    Finish();
                }
                if(board.getBoxes()[i*3].isFilled()&&board.getBoxes()[i*3+1].isFilled()&&board.getBoxes()[i*3+2].isFilled()) {
                    JOptionPane.showMessageDialog(null, "Gano O");
                    Finish();
                }
            }
            if(board.getBoxes()[0].isFilled()&&board.getBoxes()[4].isFilled()&&board.getBoxes()[8].isFilled()) {
                JOptionPane.showMessageDialog(null, "Gano O");
                Finish();
            }
            if(board.getBoxes()[2].isFilled()&&board.getBoxes()[4].isFilled()&&board.getBoxes()[6].isFilled()) {
                JOptionPane.showMessageDialog(null, "Gano O");
                Finish();
            }	
            if(getNum_Jugadas()>8) {
                JOptionPane.showMessageDialog(null, "    Empate");
                Finish();
            }
            return finished;
        }
    }
    public void Finish(){
        finished=true;
    }
    public void setPlayer1(Player player1){
        this.player1=player1;
    }
    public void setPlayer2(Player player2){
        this.player2=player2;
    }
    public void setBoard(Board board){
        this.board=board;
    }
    public Game(){
        board=new Board();
        player1=new Player(board,1);
        player2=new Player(board,2);
        finished=false;
        player1.setEnemy(player2);
        player2.setEnemy(player1);
    }
    public void Battle(){
        playerTurn(getPlayer1());
        playerTurn(getPlayer2());
    }
    
    public void playerTurn(Player player){
        if(isFinished()==false){
            System.out.println("\nplayer "+player.getNumber()+" set your move");
            String box=scanner.next();
            player.attack_play(box);
            getBoard().show1();
            setNum_Jugadas(getNum_Jugadas()+1);
        }
    }
}