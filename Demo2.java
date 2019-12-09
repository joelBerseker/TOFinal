public class Demo2{
    public static void main(String [] args){
        Game Tres_en_Linea = new Game();
        while(Tres_en_Linea.getNum_Jugadas()<10&&Tres_en_Linea.isFinished()==false){
            Tres_en_Linea.Battle();
        }
    }
}