public class Demo2{
    public static void main(String [] args){
        //falla en posiciones verticales
        Game Tres_en_Linea = new Game();
        do{
            Tres_en_Linea.Battle();
        }while(Tres_en_Linea.isFinished()==false);
    }
}