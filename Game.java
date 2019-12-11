
public interface Game{
    public boolean isFinished(Player player); 
    public void jugada(Player player);
    public void Start();
    public Board getBoard();
    public Player getPlayerMoved();
}