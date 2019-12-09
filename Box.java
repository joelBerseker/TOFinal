public class Box{
    private Object dataBox;
    //marked para x, filled para y
    //el eje x siempre lleva vocal de la A a la J
    //el eje y siempre lleva numero del 1 al 10
    //una casilla puede estar marcada y/o ocupada por un barco
    public Box(Object Data){
        this.dataBox=Data;
    }
    public Object getData(){
        return this.dataBox;
    }
    public void setData(Object Data){
        this.dataBox=Data;
    }
     
    public String toString(){
        return dataBox.toString();
    }
}