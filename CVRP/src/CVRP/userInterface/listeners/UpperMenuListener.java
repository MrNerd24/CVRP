package CVRP.userInterface.listeners;

import CVRP.userInterface.upperMenu.UpperMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpperMenuListener implements ActionListener {
    
    private UpperMenu menu;
    
    public UpperMenuListener(UpperMenu menu) {
        this.menu = menu;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        menu.buttonClick(e.getActionCommand());
    }
    
}
