import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TresEnRaya extends JFrame implements ActionListener{
    private JButton [][]b=new JButton[3][3];
    public static int cont=0;
	public TresEnRaya() {
		setSize(250,250);
		setLayout(new GridLayout(3,3));
		setTitle("Tres en raya");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contents();
		setVisible(true);
		
	}
	public void contents() {
		for(int i=0;i<b.length;i++) {
			for(int j=0;j<3;j++) {		
			b[i][j]=new JButton();
			b[i][j].setBounds((i+1)*40,(j+1)*40,200,200);
			b[i][j].addActionListener(this);
			add(b[i][j]);
			}	
		}
	}
	public void ganador() {
		for(int i=0;i<3;i++) {
			if(b[0][i].getText().equals("X")&&b[1][i].getText().equals("X")&&b[2][i].getText().equals("X")) {
				JOptionPane.showMessageDialog(null, "Gano X");
				limpiar();
				cont=0;
			}
			if(b[i][0].getText().equals("X")&&b[i][1].getText().equals("X")&&b[i][2].getText().equals("X")) {
				JOptionPane.showMessageDialog(null, "Gano X");
				limpiar();
				cont=0;
			}
			
		}
		if(b[0][0].getText().equals("X")&&b[1][1].getText().equals("X")&&b[2][2].getText().equals("X")) {
			JOptionPane.showMessageDialog(null, "Gano X");
			limpiar();
			cont=0;
		}
		if(b[0][2].getText().equals("X")&&b[1][1].getText().equals("X")&&b[2][0].getText().equals("X")) {
			JOptionPane.showMessageDialog(null, "Gano X");
			limpiar();
			cont=0;
		}
		for(int i=0;i<3;i++) {
			if(b[0][i].getText().equals("O")&&b[1][i].getText().equals("O")&&b[2][i].getText().equals("O")) {
				JOptionPane.showMessageDialog(null, "Gano O");
				limpiar();
				cont=0;
			}
			if(b[i][0].getText().equals("O")&&b[i][1].getText().equals("O")&&b[i][2].getText().equals("O")) {
				JOptionPane.showMessageDialog(null, "Gano O");
				limpiar();
				cont=0;
			}
			
		}
		if(b[0][0].getText().equals("O")&&b[1][1].getText().equals("O")&&b[2][2].getText().equals("O")) {
			JOptionPane.showMessageDialog(null, "Gano O");
			limpiar();
			cont=0;
		}
		if(b[0][2].getText().equals("O")&&b[1][1].getText().equals("O")&&b[2][0].getText().equals("O")) {
			JOptionPane.showMessageDialog(null, "Gano O");
			limpiar();
			cont=0;
		
		}	
		else if(cont>8) {
			JOptionPane.showMessageDialog(null, "    Empate");
			cont=0;
			limpiar();
		}
	}
	
	public void limpiar() {
		for(int i=0;i<b.length;i++) {
			for(int j=0;j<3;j++) {		
				b[i][j].setText("");
				b[i][j].setBackground(null);
				b[i][j].setEnabled(true);
			}	
		}
	}
	public void actionPerformed(ActionEvent e) {
        JButton n=(JButton)e.getSource();
    		if(cont%2==0) {
				n.setText("X");
				n.setEnabled(false);
				n.setBackground(Color.cyan);
			}
			else if(cont%2==1) {
				n.setText("O");
				n.setEnabled(false);
				n.setBackground(Color.green);
			}
			cont++;
			ganador();
	}
}

/*
public boolean isFinished(){
        if(finished==true)return true;
        else{
            for(int i=0;i<3;i++) {
                if(board.getBoxes()[i].isMarked()&&board.getBoxes()[i+3].isMarked()&&board.getBoxes()[i+6].isMarked()) {
                    JOptionPane.showMessageDialog(null, "Gano X");
                    Finish();
                }
                if(board.getBoxes()[i*3].isMarked()&&board.getBoxes()[i*3+1].isMarked()&&board.getBoxes()[i*3+2].isMarked()) {
                    JOptionPane.showMessageDialog(null, "Gano X");
                    Finish();
                }
            }
            if(board.getBoxes()[0].isMarked()&&board.getBoxes()[4].isMarked()&&board.getBoxes()[8].isMarked()) {
                JOptionPane.showMessageDialog(null, "Gano X");
                Finish();
            }
            if(board.getBoxes()[2].isMarked()&&board.getBoxes()[4].isMarked()&&board.getBoxes()[6].isMarked()) {
                JOptionPane.showMessageDialog(null, "Gano X");
                Finish();
            }
            for(int i=0;i<3;i++) {
                if(board.getBoxes()[i].isFilled()&&board.getBoxes()[i+3].isFilled()&&board.getBoxes()[i+6].isFilled()) {
                    JOptionPane.showMessageDialog(null, "Gano O");
                    Finish();
                }
                if(board.getBoxes()[i*3].isFilled()&&board.getBoxes()[i*3+1].isFilled()&&board.getBoxes()[i*3+2].isFilled()) {
                    JOptionPane.showMessageDialog(null, "Gano O");
                    Finish();
                }
            }
            if(board.getBoxes()[0].isFilled()&&board.getBoxes()[4].isFilled()&&board.getBoxes()[8].isFilled()) {
                JOptionPane.showMessageDialog(null, "Gano O");
                Finish();
            }
            if(board.getBoxes()[2].isFilled()&&board.getBoxes()[4].isFilled()&&board.getBoxes()[6].isFilled()) {
                JOptionPane.showMessageDialog(null, "Gano O");
                Finish();
            }	
            if(getNum_Jugadas()>8) {
                JOptionPane.showMessageDialog(null, "    Empate");
                Finish();
            }
            return finished;
        }
    }
*/