package CVRP.userInterface.lowerPanel;

import CVRP.algorithm.Rules;
import CVRP.userInterface.UIAPanel;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class ScrollView extends UIAPanel {

    Rules rules;
    CarList carList;
    LocationList locList;

    public ScrollView(int width, int height, int left, int top, Rules rules) {
        super(width, height, left, top);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.rules = rules;
    }

    @Override
    public void createContents() {
        this.add(Box.createVerticalStrut(20));
        carList = new CarList(rules);
        carList.createContents();
        this.add(carList);

        locList = new LocationList(rules);
        locList.createContents();
        this.add(locList);
    }

    @Override
    public void updateChildren() {
    }

    @Override
    public void updateBounds() {
        this.setBounds(left, top, width, getChildHeight(this));
    }

    
    
    public int getChildHeight(Container panel) {
        if (panel.getComponentCount() == 0) {
            return panel.getPreferredSize().height;
        } else {
            int ans = 0;
            for (Component comp : panel.getComponents()) {
                
                ans += getChildHeight((Container) comp);
            }
            return ans;
        }
    }

    void updateContents() {
        carList.rules = rules;
        carList.updateContents();
        locList.rules = rules;
        locList.updateContents();
    }
    
    
    
    

    
    
    

}
