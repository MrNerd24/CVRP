package CVRP.userInterface;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Juuso
 */
public class MainUI implements Runnable{
    
    private JFrame frame;

    /**
     *
     */
    public MainUI() {
        
    }
    
    @Override
    public void run() {
        frame = new JFrame("CVRP");

        frame.setPreferredSize(new Dimension(1000, 800));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();

        frame.setVisible(true);
    }

    private void createComponents(Container contentPane) {
        
    }
    
}
