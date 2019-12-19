public class Board {
    private Box[] boxes;
    private int rows;
    private int columns;
    private String gameName;
    public Board(){
        boxes= new Box[9];
        this.rows=3;
        this.columns= 3;
        this.gameName="Tres en Raya";
    }
    public Board(int rows,String GameName){
        boxes=new Box[rows*rows];
        this.rows= rows;
        this.columns= rows;
        this.gameName = GameName;
    }
    public Board(int rows,int columns,String GameName){
        boxes=new Box[rows*rows];
        this.rows= rows;
        this.columns= columns;
        this.gameName = GameName;
    }
    public Box[] getBoxes(){
        return boxes;
    }
    public Box getBox(int x,int y){
        int num = x*this.rows+y;
        return boxes[num];
    }
    public void setBox(int x,int y,char Data){
        int num = x*this.rows+y;
        boxes[num]=new Box(Data);
    }
    public void setBox(int[] coor,char Data){
        int num = coor[0]*this.rows+coor[1];
        boxes[num]=new Box(Data);
    }
    
    public void show(){
        for(int i=0;i<getBoxes().length;i++){
            if(i%rows == 0 )
                System.out.print("\n|");
            if(boxes[i]==null){
                System.out.print(" |");
                continue;
            }System.out.print(boxes[i]+"|");
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

}