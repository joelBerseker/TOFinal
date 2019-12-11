public class Ship{
    private final Box InitialBox, FinalBox;
    private int[] indexOf_boxes;
    private int Number_of_UnmarkedBoxes;

    public Ship(final Box InitialBox, final Box FinalBox) {
        this.InitialBox = InitialBox;
        this.FinalBox = FinalBox;
        Number_of_UnmarkedBoxes = numberOfBoxes();
        fill_IndexOfBoxes();
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

    public void setNumber_of_UnmarkedBoxes(final int Number_of_UnmarkedBoxes) {
        this.Number_of_UnmarkedBoxes = Number_of_UnmarkedBoxes;
    }

    public int[] getIndexOfShipBoxes() {
        return indexOf_boxes;
    }

    public void setIndexOfShipBoxes(final int[] indexOf_boxes) {
        this.indexOf_boxes=indexOf_boxes;
    }
    public boolean isSunken(){
        if(getNumber_of_UnmarkedBoxes()>0)
            return false;
        else return true;
    }
    public int numberOfBoxes(){
        int index_of_initialBox,index_of_finalBox,r;
        if(getInitialBox().getIndex()>getFinalBox().getIndex()){
            index_of_initialBox=getFinalBox().getIndex();
            index_of_finalBox=getInitialBox().getIndex();
        }else{
            index_of_finalBox=getFinalBox().getIndex();
            index_of_initialBox=getInitialBox().getIndex();
        }
        if(index_of_finalBox-index_of_initialBox<4){
            return index_of_finalBox-index_of_initialBox+1;
            
        }else if((index_of_finalBox-index_of_initialBox)%10<=4){
            return (index_of_finalBox-index_of_initialBox)%10;
        }else{
            System.out.println("Las coordenadas ingresadas son incorrectas");
            return -1;
        }
    }
    public void fill_IndexOfBoxes(){
        indexOf_boxes=new int[Number_of_UnmarkedBoxes];
        if(FinalBox.getIndex()-InitialBox.getIndex()>=10){
            for(int i=0;i<FinalBox.getIndex()-InitialBox.getIndex()+1;i+=10){
                indexOf_boxes[i]=InitialBox.getIndex()+i;
            }
        }else{
            for(int i=0;i<FinalBox.getIndex()-InitialBox.getIndex();i++){
                indexOf_boxes[i]=InitialBox.getIndex()+i;
            }
        }
    }
}