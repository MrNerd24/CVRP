package CVRP.userInterface.listeners;

import CVRP.algorithm.Rules;
import CVRP.objects.Location;
import CVRP.userInterface.lowerPanel.LocationList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class newLocationListener implements ActionListener {

    Rules rules;
    LocationList list;

    public newLocationListener(Rules rules, LocationList list) {
        this.rules = rules;
        this.list = list;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        rules.getLocations().add(new Location(getUnusedId(), 100, 100));
        list.updateContents();
    }
    
    public int getUnusedId() {
        boolean[] used = new boolean[10000];
        for (int i = 0; i < rules.getLocations().size(); i++) {
            used[rules.getLocations().get(i).getId()] = true;
        }
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                return i;
            }
        }
        return -1;
    }

}
