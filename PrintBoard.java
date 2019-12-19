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
    private Adapter adapter;
    public PrintBoard(Game game) {
        this.game=game;
        this.adapter = new Adapter();
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
        setSize(500,500);
        //setResizable(false);
        game.iniciarJugadores();
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
        panelIzquierdo.setLayout(new FlowLayout());
        jugada=new JTextField(10);
        jugada.setSize(200,200);
        
        panelSuperior.add(jugada);
        panelDerecho.setLayout(new FlowLayout());
        JButton envio= new JButton("Enviar jugada");
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
    private JPanel info;
    void contentsBatleShips(){
        central.setLayout(new FlowLayout());
        Player1= new JPanel(new GridLayout(10,10));
        info   = new JPanel(new FlowLayout());
        Player2= new JPanel(new GridLayout(10,10));
        
        
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
        central.add(Player1);
        central.add(info);
        central.add(Player2);
        for(int i=0;i<game.getBoard().getRows();i++){
            for(int j=0;j<game.getBoard().getColumns();j++){
                b[i][j].setSize(20,20);
                ImageIcon fot = new ImageIcon("image\\blanco.png");
                Icon icono = new ImageIcon(fot.getImage().getScaledInstance(b[i][j].getWidth(), b[i][j].getHeight(), Image.SCALE_DEFAULT));
                b[i][j].setIcon(icono);
            }
        }
        EditSize();
    }
    public void actionPerformed(ActionEvent e) {
            JButton n=(JButton)e.getSource();
            String jugado =jugada.getText(); 
            if(jugado.length()==0 ){
                JOptionPane.showMessageDialog(null, "jugada incorrecta jugada");
            }else{
                Player jug= game.getPlayerturn();
                int []verifica= adapter.AdapterJugada(jugado);
                if(game.getBoard().getBox(verifica[0], verifica[1])==null){
                int [] jugadass = game.jugada(jug,jugado);
                    ImageIcon fot = new ImageIcon("image\\"+jug.getSymbol()+".png");
                    Icon icono = new ImageIcon(fot.getImage().getScaledInstance(b[jugadass[0]][jugadass[1]].getWidth(), b[jugadass[0]][jugadass[1]].getHeight(), Image.SCALE_DEFAULT));
                    b[jugadass[0]][jugadass[1]].setIcon(icono);
                    game.getPlayerMoved();
                    this.jugada.setText("");
                    if(game.isFinished(jug)){
                        JOptionPane.showMessageDialog(null, "Ganaste "+jug.getName()+"\nEres el besto prota");
                        setVisible(false);
                    }
                    if(game.isTied()){
                        JOptionPane.showMessageDialog(null, "Empate GG");
                        setVisible(false);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Posicion Ocupada");
                    Box[] a =game.getBoard().getBoxes();
                    
                }

            }
        }
    public void EditSize(){
        Player1.setSize(200,200);
        Player2.setSize(200,200);
        info.setSize(50,200);
        //--------
        central.setSize(550,200);
        //--------
        panelDerecho.setSize(50,200);
        panelIzquierdo.setSize(50,200);
        //---------
        panelSuperior.setSize(500, 100);
        panelInferior.setSize(500, 10);
        //---------
        setSize(500, 300);
        setResizable(false);
    }
}