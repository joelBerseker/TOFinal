public class Prueba2{
    public static void main(String[] args) {
        Ship s1=new Ship(4);
        for(int i=0;i<s1.getIndexOfShipBoxes().length;i++){
            System.out.println(s1.getIndexOfShipBoxes()[i]);
        }
    }
}