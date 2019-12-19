public class Adapter{
    public Adapter(){

    }
    public int[] AdapterJugada(String jugada){
        jugada=jugada.toUpperCase();
        int x = jugada.charAt(0)-'0';
        x=x-17;
        int y = jugada.charAt(1)-'0';
        int res []={x,y};
        return res;
    }
}