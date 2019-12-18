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
        add(panelSuperior,BorderLayout.PAGE_START);
        add(panelInferior,BorderLayout.PAGE_END);
        add(panelIzquierdo,BorderLayout.LINE_START);
        add(panelDerecho, BorderLayout.LINE_END);
    
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
        panelSuperior.setLayout(new FlowLayout());
        panelSuperior.add(new JLabel("MI GAME"));
        panelInferior.setLayout( new FlowLayout(FlowLayout.CENTER));
        panelInferior.add(new JLabel("MI GAME"));
        panelIzquierdo.setLayout( new GridLayout(3,1));
        JLabel la = new JLabel("MI GAME");
        la.setSize(200,200);
        panelIzquierdo.add(la);
        jugada=new JTextField("texto");
        jugada.setSize(200,200);
        
        panelSuperior.add(jugada);
        panelDerecho.setLayout( new GridLayout(3,1));
        JButton envio= new JButton("Tamaño");
        envio.setSize(200,200);
        envio.addActionListener(this);
        panelSuperior.add(envio);
    }
    JTextField jugada;
    void contentsTreeInLine(Board board){
        central.setLayout(new GridLayout(5,5));
        b =new JLabel[board.getRows()][board.getRows()];
        b[0][0]=new JLabel(new ImageIcon("image\\blanco.png"));
        central.add(b[0][0]);
        central.add(new JLabel(new ImageIcon("image\\black.png")));
        b[0][1]=new JLabel(new ImageIcon("image\\blanco.png"));
        central.add(b[0][1]);
        central.add(new JLabel(new ImageIcon("image\\black.png")));
        b[0][2]=new JLabel(new ImageIcon("image\\blanco.png"));
        central.add(b[0][2]);

        //----------------image\blanco.png image\black.png
        for(int i=0;i<5;i++){
            central.add(new JLabel(new ImageIcon("image\\black.png")));
        }
        //--------------------------
        b[1][0]=new JLabel(new ImageIcon("image\\blanco.png"));
        central.add(b[1][0]);
        central.add(new JLabel(new ImageIcon("image\\black.png")));
        b[1][1]=new JLabel(new ImageIcon("image\\blanco.png"));
        central.add(b[1][1]);
        central.add(new JLabel(new ImageIcon("image\\black.png")));
        b[1][2]=new JLabel(new ImageIcon("image\\blanco.png"));
        central.add(b[1][2]);
        //-----------------
        for(int i=0;i<5;i++){
            central.add(new JLabel(new ImageIcon("image\\hori.png")));
        }
        //-----------------
        b[2][0]=new JLabel(new ImageIcon("image\\blanco.png"));
        central.add(b[2][0]);
        central.add(new JLabel(new ImageIcon("image\\black.png")));
        b[2][1]=new JLabel(new ImageIcon("image\\blanco.png"));
        central.add(b[2][1]);
        central.add(new JLabel(new ImageIcon("image\\black.png")));
        b[2][2]=new JLabel(new ImageIcon("image\\blanco.png"));
        central.add(b[2][2]);
        
    }

    void contentsDrunkBottle(Board board){
        
    }
    private JPanel Player1,Player2;
    private JLabel info;
    void contentsBatleShips(){
        central.setLayout(new  BorderLayout());
        Player1= new JPanel(new GridLayout(10,10));
        info   = new JLabel();
        Player2= new JPanel(new GridLayout(10,10));
        EditSize();
        
        b =new JLabel[this.game.getBoard().getRows()][this.game.getBoard().getColumns()];
        for(int i=0;i<this.game.getBoard().getRows();i++){
            for(int j=0;j<this.game.getBoard().getRows();j++){
                b[i][j] =new JLabel();
                Player1.add(b[i][j]);
            }
        }
        for(int i=0;i<this.game.getBoard().getRows();i++){
            for(int j=this.game.getBoard().getRows();j<this.game.getBoard().getColumns();j++){
                b[i][j] =new JLabel();
                Player2.add(b[i][j]);
            }
        }
        central.add(Player1,BorderLayout.LINE_START);
        central.add(info,BorderLayout.CENTER);
        central.add(Player2,BorderLayout.LINE_END);
        for(int i=0;i<game.getBoard().getRows();i++){
            for(int j=0;j<game.getBoard().getColumns();j++){
                b[i][j].setSize(20,20);
                ImageIcon fot = new ImageIcon("image\\blanco.png");
                Icon icono = new ImageIcon(fot.getImage().getScaledInstance(b[i][j].getWidth(), b[i][j].getHeight(), Image.SCALE_DEFAULT));
                b[i][j].setIcon(icono);
            }
        }
    }
    public void actionPerformed(ActionEvent e) {
            JButton n=(JButton)e.getSource();
            n.setText(this.getWidth()+" "+this.getHeight());
            System.out.println("Plauer 1 = "+Player1.getWidth()+" "+Player1.getHeight());
            System.out.println("Plauer 2 = "+Player2.getWidth()+" "+Player2.getHeight());
            System.out.println("info = "+info.getWidth()+" "+info.getHeight());
            System.out.println("central = "+central.getWidth()+" "+central.getHeight());
            System.out.println("panelArriba = "+panelSuperior.getWidth()+" "+panelSuperior.getHeight());
            System.out.println("panelAbajo = "+panelInferior.getWidth()+" "+panelInferior.getHeight());
            System.out.println("panel Iz = "+panelIzquierdo.getWidth()+" "+panelIzquierdo.getHeight());
            System.out.println("panel de = "+panelDerecho.getWidth()+" "+panelDerecho.getHeight());
    }
    public void EditSize(){
        Player1.setSize(220,235);

        Player2.setSize(220,235);
        info.setSize(50,235);
        //--------
        central.setSize(490,235);
        //--------
        panelDerecho.setSize(200,235);
        panelIzquierdo.setSize(200,235);
        //---------
        panelSuperior.setSize(890, 200);
        panelInferior.setSize(890, 200);
        //---------
        setSize(890,635);
        setResizable(false);
    }
}