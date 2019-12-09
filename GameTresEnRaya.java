import java.util.Scanner;
public class GameTresEnRaya implements Game{
    private Player player1,player2;
    private Board board;
    private boolean finished;
    Scanner sc = new Scanner(System.in);
    public GameTresEnRaya(){
        this.board      =   new Board();
        this.player1    =   new Player("X");
        this.player2    =   new Player("O");
        this.finished   =   false;
    }
    public void jugada(Player player){
        System.out.println("Jugador "+player.getName()+" jugada: ");
        String jugada =sc.next();
        int x = jugada.charAt(0)-'0';
        x=x-17;
        int y = jugada.charAt(1)-'0';
        board.setBox(x, y, player.getSymbol());
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