import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PrintBoard extends JFrame implements ActionListener{
    public static int cont=0;
    private JButton[][] b;
    private Game game;
    
    public PrintBoard(Game game) {
        this.game=game;
		setSize(250,250);
		setTitle(this.game.getBoard().getGameName());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contents(this.game.getBoard());
		setVisible(true);
    }
    public void contents(Board board) {
        if(board.getGameName().equalsIgnoreCase("Tres en Raya")){
            contentsTreeInLine(board);
        }else if(board.getGameName().equalsIgnoreCase("Botella borracha")){
            contentsDrunkBottle(board);
        }else{
            contentsBatleShips(board);
        }
    }
    void contentsTreeInLine(Board board){
        setLayout(new GridLayout(board.getRows(),board.getRows()));
        b =new JButton[board.getRows()][board.getRows()];
        for(int i=0;i<b.length;i++) {
			for(int j=0;j<b[i].length;j++) {		
			    b[i][j] =new JButton();
			    b[i][j].setBounds((i+1)*40,(j+1)*40,200,200);
			    b[i][j].addActionListener(this);
			    add(b[i][j]);
		    }	
		}
    }
    void contentsDrunkBottle(Board board){
        
    }
    void contentsBatleShips(Board board){
        setLayout(new GridLayout(board.getRows(),board.getRows()*2));
        b =new JButton[board.getRows()][board.getRows()*2];
        for(int i=0;i<b.length;i++) {
			for(int j=0;j<b[i].length;j++) {		
			    b[i][j] =new JButton();
			    b[i][j].setBounds((i+1)*40,(j+1)*40,200,200);
			    b[i][j].addActionListener(this);
			    add(b[i][j]);
		    }	
		}
    }
    public void actionPerformed(ActionEvent e) {
        JButton n=(JButton)e.getSource();
			game.getPlayerMoved();	
            n.setText(String.valueOf(   game.getPlayerMoved().getSymbol()));
            n.setIcon(new ImageIcon("image\\x.png"));
            n.setEnabled(false);
			n.setBackground(Color.cyan);
			cont++;
    }
}   