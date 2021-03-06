package CVRP.userInterface.lowerPanel;

import CVRP.algorithm.Rules;
import CVRP.userInterface.UIAPanel;
import java.awt.Component;
import java.awt.Container;
import javax.swing.Box;
import javax.swing.BoxLayout;

/**
 *
 * @author Juuso
 */
public class ScrollView extends UIAPanel {

    Rules rules;
    CarList carList;
    LocationList locList;

    /**
     *
     * @param width
     * @param height
     * @param left
     * @param top
     * @param rules
     */
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

    /**
     *
     * @param panel
     * @return
     */
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
