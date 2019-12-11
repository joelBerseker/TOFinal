public class Prueba2{
    public static void main(String[] args) {
        Box b1=new Box(0,0);
        Box b2=new Box(6,0);
        Box b3=new Box(0,2);
        Box b4=new Box(0,3);
        Ship s1=new Ship(b1,b2);
        System.out.println(s1.getNumber_of_UnmarkedBoxes());
        
    }
}