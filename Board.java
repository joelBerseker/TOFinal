public class Board {
    private Box[] boxes;
    private int rows;
    public Board(){
        boxes= new Box[9];
        this.rows=3;
    }
    public Board(int rows){
        boxes=new Box[rows*rows];
        this.rows= rows;
    }
    public Box[] getBoxes(){
        return boxes;
    }
    public Box getBox(int x,int y){
        int num = x*this.rows+y;
        return boxes[num];
    }
    public void setBox(int x,int y,Object Data){
        int num = x*this.rows+y;
        boxes[num]=new Box(Data);
    }
    
    public void show(){
        for(int i=0;i<getBoxes().length;i++){
            if(i%rows==0)
                System.out.println();
            if(boxes[i]==null)
                System.out.print(" ");
            System.out.print(boxes[i]);
        }
    }
}