import java.util.Scanner;
public class GameTresEnRaya implements Game{
    private Player player1,player2;
    private Board board;
    private Adapter adapter;
    private boolean finished;

    Scanner sc = new Scanner(System.in);
    public GameTresEnRaya(){
        this.board      =   new Board(3,"Tres en Raya");
        this.player1    =   new Player("Jose",'X');
        this.player2    =   new Player("Pedro",'O');
        this.finished   =   false;
        this.adapter = new Adapter();
    }
    public void jugada(Player player){
        System.out.println("Jugador "+player.getName()+" jugada: ");
        String jugada =sc.next();
        board.setBox(adapter.AdapterJugada(jugada), player.getSymbol());
    }
    public void Start(){
        System.out.println("Game Over");
    }
    public boolean isFinished(Player player){
        if(finished)return false;
        return true;
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
        return player1;
    }
    
}