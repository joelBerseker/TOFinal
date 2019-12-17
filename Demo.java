import javax.swing.*;
public class Demo{
    public static void main(String[]args) {
		/*Game game = new GameTresEnRaya();
		PrintBoard printL = new PrintBoard(game);
		*/
		Display myApplication = new Display();
        myApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myApplication.setSize(1024, 1024);
        myApplication.setVisible(true); // displaying application
	}
}