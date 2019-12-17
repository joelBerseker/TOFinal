import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PrintBoard extends JFrame implements ActionListener{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static int cont = 0;
    private JLabel[][] b;
    private Game game;
    private JPanel panelSuperior,panelInferior,central,panelIzquierdo, panelDerecho;
    
    public PrintBoard(Game game) {
        this.game=game;
		setSize(500,500);
		setTitle(this.game.getBoard().getGameName());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        contents(this.game.getBoard());
        setLayout(new  BorderLayout());
        add(central,BorderLayout.CENTER);
        add(panelSuperior,BorderLayout.NORTH);
        add(panelInferior,BorderLayout.SOUTH);
        add(panelIzquierdo,BorderLayout.WEST);
        add(panelDerecho,BorderLayout.EAST);
        setVisible(true);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                Image img= new ImageIcon("image\\x.png").getImage();
                ImageIcon img2=new ImageIcon(img.getScaledInstance(78, 124, Image.SCALE_SMOOTH));
                b[i][j].setIcon(img2);
            }
        }
    }
    public void contents(Board board) {
        central= new JPanel();
        panelSuperior= new JPanel();
        panelInferior= new JPanel();
        panelIzquierdo= new JPanel();
        panelDerecho=new JPanel();
       
        
        if(board.getGameName().equalsIgnoreCase("Tres en Raya")){
            contentsTreeInLine(board);
        }else if(board.getGameName().equalsIgnoreCase("Botella borracha")){
            contentsDrunkBottle(board);
        }else{
            contentsBatleShips(board);
        }
        panelSuperior.setLayout( new FlowLayout(FlowLayout.CENTER));
        panelSuperior.add(new JLabel("MI GAME"));
        panelInferior.setLayout( new FlowLayout(FlowLayout.CENTER));
        panelInferior.add(new JLabel("MI GAME"));
        panelIzquierdo.setLayout(new GridLayout(3,1));
        panelIzquierdo.add(new JLabel("MI GAME"));
        JTextField jugada=new JTextField("Holi");
        jugada.setSize(100,200);
        panelIzquierdo.add(jugada);
        panelIzquierdo.add(new JButton("Holi"));
        panelDerecho.setLayout(new GridLayout(3,1));
        panelDerecho.add(new JTextField("Holi"));
        panelDerecho.add(new JButton("Holi"));
    }
    void contentsTreeInLine(Board board){
        central.setSize(200,200);
        central.setLayout(new GridLayout(3,3));
        b =new JLabel[board.getRows()][board.getRows()];
        for(int i=0;i<b.length;i++) {
			for(int j=0;j<b[i].length;j++) {		
			    b[i][j] =new JLabel();
                central.add(b[i][j]);
		    }	
		}
    }
    void contentsDrunkBottle(Board board){
        
    }
    void contentsBatleShips(Board board){
        setLayout(new GridLayout(board.getRows(),board.getRows()*2));
        b =new JLabel[board.getRows()][board.getRows()*2];
        for(int i=0;i<b.length;i++) {
			for(int j=0;j<b[i].length;j++) {		
			    /*son botones :v*/b[i][j] =new JLabel();
			    add((JLabel)b[i][j]);
		    }	
		}
    }
    public void actionPerformed(ActionEvent e) {
            JButton n=(JButton)e.getSource();
			game.getPlayerMoved();	
            n.setIcon(new ImageIcon("image\\x.png"));
            n.setEnabled(false);

    }
}