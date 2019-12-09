public class Player{
    private Board board;
    private Player enemy;
    private int number;
    public Player(Board board,int number){
        this.board=board;
        this.number=number;
        enemy=null;
    }
    public Board getBoard(){
        return board;
    }
    public int getNumber(){
        return number;
    }
    public Player getEnemy(){
        return enemy;
    }
    public void setEnemy(Player enemy){
        this.enemy=enemy;
    }
    public void setBoard(Board board){
        this.board=board;
    }
    public void setNumber(int number){
        this.number=number;
    }
    public void attack_play(String box){
        int index = getBoard().findBox(box);
        Box selectedBox=getBoard().getBoxes()[index];
        if(this.getNumber()==1) selectedBox.mark();
        else selectedBox.fill();
    }
}