import javax.swing.*;
import java.awt.*;
public class Display extends JFrame{

    /**
    	 *
    	 */
    private static final long serialVersionUID = 1L;
    JPanel gridHolder = new JPanel(); // panel to store the grid
private GridLayout buttonsGrid; // space containing a buttons
private JButton myButtons[]; // grid is to be filled with these buttons
private BorderLayout mainGUILayout; // main gui layout
private Container mainGuiContainer;

public Display()
{
    mainGUILayout = new BorderLayout(5,5); // the width of space in between the main gui elements.
    mainGuiContainer = getContentPane(); // getting content pane
    mainGuiContainer.setLayout(mainGUILayout); // setting main layout
    buttonsGrid = new GridLayout(4, 1, 5, 5); // 4 buttons one over the other
    myButtons = new JButton[4]; // player's hand represented with buttons
    gridHolder.setLayout(buttonsGrid);

                for (int x = 0; x < 4; x++)
                {

                myButtons[x] = new JButton (" ");
                gridHolder.add(myButtons[x]);
                }

            add(gridHolder, BorderLayout.WEST);
            setVisible(true);
}
}

