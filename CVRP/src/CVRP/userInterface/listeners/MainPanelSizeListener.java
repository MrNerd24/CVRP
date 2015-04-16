package CVRP.userInterface.listeners;

import CVRP.userInterface.MainPanel;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class MainPanelSizeListener implements ComponentListener {

    MainPanel main;

    public MainPanelSizeListener(MainPanel main) {
        this.main = main;
    }
    
    

    @Override
    public void componentResized(ComponentEvent e) {
        main.changeSize(e.getComponent().getWidth(), e.getComponent().getHeight());
    }

    @Override
    public void componentMoved(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }

}
