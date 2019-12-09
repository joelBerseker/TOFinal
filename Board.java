public class Board {
    private Box [] boxes;
    private String X_axis;
    private String Y_axis;
    int asdadsdas;
    public Box[] getBoxes(){
        return boxes;
    }
    public String getX_Axis(){
        return X_axis;
    }
    public void setAxis(){
        String aux="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        X_axis=aux.substring(0,(int)Math.sqrt(getBoxes().length));
        for(int i=0;i<getBoxes().length;i++){
            Y_axis+=""+i;
        }
    }
    public String getY_Axis(){
        return Y_axis;
    }
    public Board(int rows){
        boxes=new Box[rows*rows];
        setAxis();
        for(int i=0;i<getBoxes().length;i++){
            boxes[i]=new Box(getX_Axis().charAt(i/rows),getY_Axis().charAt(i%rows));
        }
    }
    public int findBox(String box){
        char X=box.charAt(0);
        char Y=box.charAt(1);
        int aux=0,aux2=0;
        for(int i=0;i<Math.sqrt(getBoxes().length);i++){
            if(X==X_axis.charAt(i))
                aux=i;
            if(Y==Y_axis.charAt(i))
                aux2=i;
        }
        return aux*(int)(Math.sqrt(getBoxes().length))+aux2;
    }
    public int findBox(Box box){
        char X=box.getX();
        char Y=box.getY();
        int aux=0,aux2=0;
        for(int i=0;i<Math.sqrt(getBoxes().length);i++){
            if(X==X_axis.charAt(i))
                aux=i;
            if(Y==Y_axis.charAt(i))
                aux2=i;
        }
        return aux*(int)(Math.sqrt(getBoxes().length))+aux2;
    }
    public void show1(){
        for(int i=0;i<getBoxes().length;i++){
            if(i%((int)(Math.sqrt(getBoxes().length)))==0){
                System.out.println();   
            }
            System.out.print(this.getBoxes()[i].one_zero());
        }
    }
}