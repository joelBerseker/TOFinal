public class Box{
    private char x,y;
    private boolean marked,filled;
    //marked para x, filled para y
    //el eje x siempre lleva vocal de la A a la J
    //el eje y siempre lleva numero del 1 al 10
    //una casilla puede estar marcada y/o ocupada por un barco
    public char getX(){
        return x;
    }
    public char getY(){
        return y;
    }
    public void setX(char x){
        this.x=x;
    }
    public void setY(char y){
        this.y=y;
    }
    public void mark(){
        marked=true;
    }
    public boolean isMarked(){
        return marked;
    }
    public void fill(){
        filled=true;
    }
    public boolean isFilled(){
        return filled;
    }
    public Box(){
        x='A';
        y='1';
        marked=false;
        filled=false;
    }
    public Box(char x,char y){
        this.x=x;
        this.y=y;
        marked=false;
        filled=false;
    }
    public String one_zero(){
        if(this.isFilled()){
            return "O";
        }else if(this.isMarked()){
            return "X";
        }else return " ";
    }
}