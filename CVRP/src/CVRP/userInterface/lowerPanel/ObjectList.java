package CVRP.userInterface.lowerPanel;

import CVRP.algorithm.Rules;
import CVRP.userInterface.UIPanel;
import java.awt.Color;

public class ObjectList extends UIPanel {
    Rules rules;
    CarList carList;
    LocationList locList;

    public ObjectList(int width, int height, int left, int top, Rules rules) {
        super(width, height, left, top);
        this.setBackground(new Color(120, 120, 120));
        this.rules = rules;
    }

    @Override
    public void createContents() {
        carList = new CarList(width, rules.getCars().size()*80, 0, 0, rules);
        carList.setParentPanel(this);
        carList.createContents();
        this.add(carList);
        
        locList = new LocationList(width, rules.getLocations().size()*80, 0, carList.getPanelHeight(), rules);
        locList.setParentPanel(this);
        locList.createContents();
        this.add(locList);
    }

    @Override
    public void updateChildren() {
        carList.changeSize(width, rules.getCars().size()*80);
        locList.changeSize(width, rules.getLocations().size()*80);
        locList.changePosition(0, carList.getPanelHeight());
                
    }
    
}
