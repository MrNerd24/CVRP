package CVRP.userInterface.listeners;

import CVRP.userInterface.upperMenu.UpperMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener that listens uppermenu's buttons
 * @author Juuso
 */
public class UpperMenuButtonListener implements ActionListener {
    
    private UpperMenu menu;
    
    /**
     * 
     * @param menu Uppermenu
     */
    public UpperMenuButtonListener(UpperMenu menu) {
        this.menu = menu;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        menu.updateRuleValues();
        menu.buttonClick(e.getActionCommand());
    }
    
}
