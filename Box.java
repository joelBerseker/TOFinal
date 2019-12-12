public class Box{
    private Object dataBox;
    private int x,y;
    
    
    //marked para x, filled para y
    //el eje x siempre lleva vocal de la A a la J
    //el eje y siempre lleva numero del 1 al 10
    //una casilla puede estar marcada y/o ocupada por un barco
    public Box(Object Data){
        this.dataBox=Data;
    }
    public Box(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Object getData(){
        return this.dataBox;
    }
    public void setData(Object Data){
        this.dataBox=Data;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getIndex(){
        return x*10+y;
    } 
    public String toString(){
        return dataBox.toString();
    }

    
}