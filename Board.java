public class Board {
    private Box [] boxes;
    private int  puto;
    public Box[] getBoxes(){
        return boxes;
    }
    public Board(){
        boxes=new Box[9];
        String X_axis="ABC",Y_axis="012";
        for(int i=0;i<9;i++){
            boxes[i]=new Box(X_axis.charAt(i/3),Y_axis.charAt(i%3));
        }
        //se han llenado las casillas en el tablero
    }
    public int findBox(String box){
        char X=box.charAt(0);
        char Y=box.charAt(1);
        int aux=0,aux2=0;
        String X_axis="ABC",Y_axis="012";
        for(int i=0;i<3;i++){
            if(X==X_axis.charAt(i))
                aux=i;
        }
        for(int i=0;i<3;i++){
            if(Y==Y_axis.charAt(i))
                aux2=i;
        }
        return aux*3+aux2;
    }
    public int findBox(Box box){
        char X=box.getX();
        char Y=box.getY();
        int aux=0,aux2=0;
        String X_axis="ABC",Y_axis="012";
        for(int i=0;i<10;i++){
            if(X==X_axis.charAt(i))
                aux=i;
        }
        for(int i=0;i<3;i++){
            if(Y==Y_axis.charAt(i))
                aux2=i;
        }
        return aux*3+aux2;
    }
    public void show1(){
        for(int i=0;i<9;i++){
            if(i%3==0){
                System.out.println();   
            }
            System.out.print(this.getBoxes()[i].one_zero());
        }

    }
}