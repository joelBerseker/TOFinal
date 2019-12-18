public class Ship{
    private Box InitialBox, FinalBox;
    private int[] indexOf_boxes;
    private int Number_of_UnmarkedBoxes;
    private char direction;

    public Ship(int numberOfBoxes){
        int random=(int)(Math.random()*100);
        int random_aux=(int)(Math.random()*2);
        this.Number_of_UnmarkedBoxes=numberOfBoxes;
        fill_IndexOfBoxes(calculateIindex_and_Findex(random,random_aux,numberOfBoxes));
    }
    public Ship(Box InitialBox,Box FinalBox) {
        this.InitialBox = InitialBox;
        this.FinalBox = FinalBox;
        Number_of_UnmarkedBoxes = numberOfBoxes();
    }

    public Box getInitialBox() {
        return InitialBox;
    }

    public Box getFinalBox() {
        return FinalBox;
    }

    public int getNumber_of_UnmarkedBoxes() {
        return Number_of_UnmarkedBoxes;
    }

    public void setNumber_of_UnmarkedBoxes(int Number_of_UnmarkedBoxes) {
        this.Number_of_UnmarkedBoxes = Number_of_UnmarkedBoxes;
    }

    public int[] getIndexOfShipBoxes() {
        return indexOf_boxes;
    }

    public void setIndexOfShipBoxes(int[] indexOf_boxes) {
        this.indexOf_boxes=indexOf_boxes;
    }
    public boolean isSunken(){
        if(getNumber_of_UnmarkedBoxes()>0)
            return false;
        else return true;
    }
    public int numberOfBoxes(){
        int index_of_initialBox,index_of_finalBox;
        if(getInitialBox().getIndex()>getFinalBox().getIndex()){
            index_of_initialBox=getFinalBox().getIndex();
            index_of_finalBox=getInitialBox().getIndex();
        }else{
            index_of_finalBox=getFinalBox().getIndex();
            index_of_initialBox=getInitialBox().getIndex();
        }
        if(index_of_finalBox-index_of_initialBox<4){
            return index_of_finalBox-index_of_initialBox+1;
        }else if((index_of_finalBox-index_of_initialBox)/10<=4){
            return (index_of_finalBox-index_of_initialBox)/10+1;
        }else{
            System.out.println("Las coordenadas ingresadas son incorrectas");
            return 0;
        }
    }
    public int[] calculateIindex_and_Findex(int random,int random_aux,int numberOfBoxes){
        int []Iindex_andFindex=new int[2];
        //1 horizontal , 0 vertical
        if(random_aux==1){
            if(random%10+(numberOfBoxes-1)<=9){
                Iindex_andFindex[0]=random;
                Iindex_andFindex[1]=random+numberOfBoxes-1;
                return Iindex_andFindex;
            }else{
            //if(random%10-(numberOfBoxes-1)>=0){
                Iindex_andFindex[0]=random-numberOfBoxes-1;
                Iindex_andFindex[1]=random;
                return Iindex_andFindex;
            }
        }else{
            if(random-(numberOfBoxes-1)*10>=0){
                Iindex_andFindex[0]=random-(numberOfBoxes-1)*10;
                Iindex_andFindex[1]=random;
                return Iindex_andFindex;
            }else {
            //if(random+(numberOfBoxes-1)*10<=99){
                Iindex_andFindex[0]=random;
                Iindex_andFindex[1]=random+(numberOfBoxes-1)*10;
                return Iindex_andFindex;
            }
        }
           
    }
    public void fill_IndexOfBoxes(int []Iindex_and_Findex){
        int initialIndex=Iindex_and_Findex[0];
        int finalIndex=Iindex_and_Findex[1];
        indexOf_boxes=new int[Number_of_UnmarkedBoxes];
        if(finalIndex-initialIndex>=10){
            for(int i=0;i<Number_of_UnmarkedBoxes;i++){
                indexOf_boxes[i]=initialIndex+i*10;
            }
        }else{
            for(int i=0;i<Number_of_UnmarkedBoxes;i++){
                indexOf_boxes[i]=initialIndex+i;
            }
        }
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection() {
        if(getIndexOfShipBoxes()[Number_of_UnmarkedBoxes-1]-getIndexOfShipBoxes()[0]>4){
            this.direction='s';
        }else{
            this.direction='n';
        }
    }

    public void changeDirection(char direction) {
        this.direction=direction;
    }
}