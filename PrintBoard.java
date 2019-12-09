import javax.swing.LayoutStyle.ComponentPlacement;

public class PrintBoard extends JFrame implements ActionListener{
    public static int cont=0;
    private Object[] b;
	public PrintBoard(Board board) {

		setSize(250,250);
		
		setTitle(board.getGameName());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contents(board);
		setVisible(true);
		
    }
    public void contents(Board board) {
        if(board.getGameName().equalsIgnoreCase("Tres en Lina")){
            contentsTreeInLine(board);
        }else if(board.getGameName().equalsIgnoreCase("Botella borracha")){
            contentsDrunkBottle(board);
        }else{
            contentsBatleShips(board);
        }
    }
    void contentsTreeInLine(Board board){
        setLayout(new GridLayout(board.getRows(),board.getRows()));
    }
    void contentsDrunkBottle(Board board){
        
    }
    
    void contentsBatleShips(Board board){

    }
}   