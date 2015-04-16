package CVRP.userInterface.listeners;

import CVRP.userInterface.lowerPanel.LocationLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LocationListener implements ActionListener {

    LocationLabel loc;

    public LocationListener(LocationLabel loc) {
        this.loc = loc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        loc.click();
    }

}
