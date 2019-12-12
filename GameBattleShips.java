public class GameBattleShips implements Game {
    private Player player1,player2;
    private Board board;
    private Adapter adapter;
    private boolean finished;

    Scanner sc = new Scanner(System.in);
    public GameBattleShips(){
        this.board      =   new Board(10,"BattleShips");
        this.player1    =   new Player("Jose",'X');
        this.player2    =   new Player("Pedro",'O');
        this.finished   =   false;
        this.adapter = new Adapter();
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

    public Adapter getAdapter() {
        return adapter;
    }

    public void setAdapter(Adapter adapter) {
        this.adapter = adapter;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
    
    @Override
    public void Start() {
        // TODO Auto-generated method stub

    }

    @Override
    public Player getPlayerMoved() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isFinished(Player player) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void jugada(Player player) {
        // TODO Auto-generated method stub

    }
}