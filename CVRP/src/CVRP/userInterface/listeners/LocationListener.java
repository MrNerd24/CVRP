package CVRP.userInterface.listeners;

import CVRP.userInterface.lowerPanel.LocationLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener for editing location
 * @author Juuso
 */
public class LocationListener implements ActionListener {

    LocationLabel loc;

    /**
     * Creates a new locationListener
     * @param loc Locationlable that holds the button.
     */
    public LocationListener(LocationLabel loc) {
        this.loc = loc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        loc.click();
    }

}
