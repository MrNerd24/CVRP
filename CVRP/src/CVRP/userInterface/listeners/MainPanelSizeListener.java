package CVRP.userInterface.listeners;

import CVRP.userInterface.MainPanel;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

/**
 * Listens the mainpanel's size changes
 * @author Juuso
 */
public class MainPanelSizeListener implements ComponentListener {

    MainPanel main;

    /**
     * Creates a new sizeListener
     * @param main mainPanel
     */
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
