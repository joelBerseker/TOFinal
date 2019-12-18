
public class Demo{
    public static void main(String[]args) {
		//Game game = new GameBattleShips();
		Game game = new GameTresEnRaya();
		PrintBoard printL = new PrintBoard(game);
		printL.setVisible(true);
	}
}