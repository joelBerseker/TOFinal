public class Prueba{
    public static void main(String[] args) {
        String jugada = "A2";
        //int x =Character.getNumericValue(jugada.charAt(0));
        //int y =Character.getNumericValue(jugada.charAt(1));
        int x = jugada.charAt(0)-'0';
        x=x-17;
        int y = jugada.charAt(1)-'0';
        System.out.println(x+" "+y);
    }
}