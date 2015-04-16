package CVRP.userInterface.lowerPanel;

import CVRP.algorithm.Rules;
import CVRP.objects.Location;
import CVRP.userInterface.UIPanel;

public class LocationList extends UIPanel {
    Rules rules;
    private LocationLabel[] labels;

    public LocationList(int width, int height, int left, int top, Rules rules) {
        super(width, height, left, top);
        this.rules = rules;
    }

    @Override
    public void createContents() {
        labels = new LocationLabel[rules.getLocations().size()];
        for (int i = 0; i < rules.getLocations().size(); i++) {
            Location loc = rules.getLocations().get(i);
            LocationLabel label = new LocationLabel(width, 80, 0, 80*i, loc);
            label.setParentPanel(this);
            label.createContents();
            labels[i] = label;
            this.add(label);
        }
    }

    @Override
    public void updateChildren() {
    }

    public Rules getRules() {
        return rules;
    }

    public void setRules(Rules rules) {
        this.rules = rules;
    }
    
    
    
}
