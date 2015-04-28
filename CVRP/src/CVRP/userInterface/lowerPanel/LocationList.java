package CVRP.userInterface.lowerPanel;

import CVRP.algorithm.Rules;
import CVRP.objects.Location;
import CVRP.userInterface.listeners.newLocationListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class LocationList extends JPanel {
    Rules rules;
    private LocationLabel[] labels;

    public LocationList(Rules rules) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.rules = rules;
    }

    public void createContents() {
        
        labels = new LocationLabel[rules.getLocations().size()];
        for (int i = 0; i < rules.getLocations().size(); i++) {
            Location loc = rules.getLocations().get(i);
            int packets = loc.getPackets().size();
            LocationLabel label = new LocationLabel(loc);
            label.createContents();
            labels[i] = label;
            this.add(label);
            this.add(Box.createVerticalStrut(15));
        }
        JButton button = new JButton("New Location");
        button.addActionListener(new newLocationListener(rules, this));
        this.add(button);
    }


    public Rules getRules() {
        return rules;
    }

    public void setRules(Rules rules) {
        this.rules = rules;
    }

    public void updateContents() {
        this.removeAll();
        createContents();
        this.revalidate();
        this.repaint();
    }
    
    
    
}
