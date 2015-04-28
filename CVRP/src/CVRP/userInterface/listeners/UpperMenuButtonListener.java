package CVRP.userInterface.listeners;

import CVRP.userInterface.upperMenu.UpperMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpperMenuButtonListener implements ActionListener {
    
    private UpperMenu menu;
    
    public UpperMenuButtonListener(UpperMenu menu) {
        this.menu = menu;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        menu.updateRuleValues();
        menu.buttonClick(e.getActionCommand());
    }
    
}
