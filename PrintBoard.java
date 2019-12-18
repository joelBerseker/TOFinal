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
        
        setLayout(new  BorderLayout());
        
        central= new JPanel();
        panelSuperior= new JPanel();
        panelInferior= new JPanel();
        panelIzquierdo= new JPanel();
        panelDerecho=new JPanel();
        contents();
        add(central,BorderLayout.CENTER);
        /*add(panelSuperior,BorderLayout.NORTH);
        add(panelInferior,BorderLayout.SOUTH);
        add(panelIzquierdo,BorderLayout.WEST);
        add(panelDerecho,BorderLayout.EAST);
        */
        setVisible(true);
        
    }
    public void contents() {
        if(this.game.getBoard().getGameName().equalsIgnoreCase("Tres en Raya")){
            contentsTreeInLine(this.game.getBoard());
        }else if(this.game.getBoard().getGameName().equalsIgnoreCase("Botella borracha")){
            contentsDrunkBottle(this.game.getBoard());
        }else{
            contentsBatleShips();
        }
        /*
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
        */
    }
    void contentsTreeInLine(Board board){
        central.setLayout(new GridLayout(5,5));
        b =new JLabel[board.getRows()][board.getRows()];
        b[0][0]=new JLabel(new  ImageIcon(new ImageIcon("image\\x.png").getImage().getScaledInstance(78, 124, Image.SCALE_SMOOTH)));
        central.add(b[0][0]);
        central.add(new JLabel(new  ImageIcon(new ImageIcon("image\\vertical.png").getImage().getScaledInstance(78, 124, Image.SCALE_SMOOTH))));
        b[0][1]=new JLabel(new  ImageIcon(new ImageIcon("image\\blanco.png").getImage().getScaledInstance(78, 124, Image.SCALE_SMOOTH)));
        central.add(b[0][1]);
        central.add(new JLabel(new  ImageIcon(new ImageIcon("image\\vertical.png").getImage().getScaledInstance(78, 124, Image.SCALE_SMOOTH))));
        b[0][2]=new JLabel(new  ImageIcon(new ImageIcon("image\\cruce.png").getImage().getScaledInstance(78, 124, Image.SCALE_SMOOTH)));
        central.add(b[0][2]);

        //----------------
        b[1][0]=new JLabel(new  ImageIcon(new ImageIcon("image\\blanco.png").getImage().getScaledInstance(78, 124, Image.SCALE_SMOOTH)));
        central.add(b[1][0]);
        central.add(new JLabel(new  ImageIcon(new ImageIcon("image\\vertical.png").getImage().getScaledInstance(78, 124, Image.SCALE_SMOOTH))));
        b[1][1]=new JLabel(new  ImageIcon(new ImageIcon("image\\blanco.png").getImage().getScaledInstance(78, 124, Image.SCALE_SMOOTH)));
        central.add(b[1][1]);
        central.add(new JLabel(new  ImageIcon(new ImageIcon("image\\vertical.png").getImage().getScaledInstance(78, 124, Image.SCALE_SMOOTH))));
        b[1][2]=new JLabel(new  ImageIcon(new ImageIcon("image\\blanco.png").getImage().getScaledInstance(78, 124, Image.SCALE_SMOOTH)));
        central.add(b[1][2]);
        //-----------------
        b[2][0]=new JLabel(new  ImageIcon(new ImageIcon("image\\blanco.png").getImage().getScaledInstance(78, 124, Image.SCALE_SMOOTH)));
        central.add(b[2][0]);
        central.add(new JLabel(new  ImageIcon(new ImageIcon("image\\vertical.png").getImage().getScaledInstance(78, 124, Image.SCALE_SMOOTH))));
        b[2][1]=new JLabel(new  ImageIcon(new ImageIcon("image\\blanco.png").getImage().getScaledInstance(78, 124, Image.SCALE_SMOOTH)));
        central.add(b[2][1]);
        central.add(new JLabel(new  ImageIcon(new ImageIcon("image\\vertical.png").getImage().getScaledInstance(78, 124, Image.SCALE_SMOOTH))));
        b[2][2]=new JLabel(new  ImageIcon(new ImageIcon("image\\blanco.png").getImage().getScaledInstance(78, 124, Image.SCALE_SMOOTH)));
        central.add(b[2][2]);
        
    }

    void contentsDrunkBottle(Board board){
        
    }
    void contentsBatleShips(){
        central.setLayout(new GridLayout(1,3));
        JPanel Player1= new JPanel(new GridLayout(10,10));
        JPanel info   = new JPanel();
        JPanel Player2= new JPanel(new GridLayout(10,10));
        b =new JLabel[this.game.getBoard().getRows()][this.game.getBoard().getColumns()];
        for(int i=0;i<this.game.getBoard().getRows();i++){
            for(int j=0;j<this.game.getBoard().getRows();j++){
                b[i][j] =new JLabel();
                Player1.add(b[i][j]);
            }
        }
        for(int i=0;i<this.game.getBoard().getRows();i++){
            for(int j=this.game.getBoard().getRows();j<this.game.getBoard().getColumns();j++){
                b[i][j] =new JLabel("trans");
                Player2.add(b[i][j]);
            }
        }
        central.add(Player1);
        central.add(info);
        central.add(Player2);
        for(int i=0;i<game.getBoard().getRows();i++){
            for(int j=0;j<game.getBoard().getColumns();j++){
                Image img= new ImageIcon("image\\x.png").getImage();
                ImageIcon img2=new ImageIcon(img.getScaledInstance(78, 124, Image.SCALE_SMOOTH));
                b[i][j].setIcon(img2);
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