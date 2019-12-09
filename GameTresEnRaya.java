import java.util.Scanner;
public class GameTresEnRaya implements Game{
    private Player player1,player2;
    private Board board;
    private Adapter adapter;
    private boolean finished;
    Scanner sc = new Scanner(System.in);
    public GameTresEnRaya(){
        this.board      =   new Board(3,"Tres en Raya");
        this.player1    =   new Player("X");
        this.player2    =   new Player("O");
        this.finished   =   false;
        adapter = new Adapter();
    }
    public void jugada(Player player){
        System.out.println("Jugador "+player.getName()+" jugada: ");
        String jugada =sc.next();
        board.setBox(adapter.AdapterJugada(jugada), player.getSymbol());
    }
    public void Start(){
        while(true){
            jugada(player1);
            if(isFinished(player1))break;
            jugada(player2);  
            if(isFinished(player2))break;
        }
        System.out.println("Game Over");
    }
    public boolean isFinished(Player player){
        if(finished)return false;
        return true;
    }
}