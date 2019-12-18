
public interface Game{
    public boolean isFinished(Player player); 
    public int[] jugada(Player player,String jugada);
    public void Start();
    public Board getBoard();
    public Player getPlayerMoved();
}