package CVRP.userInterface.lowerPanel;

import CVRP.algorithm.Rules;
import CVRP.objects.Car;
import CVRP.userInterface.UIPanel;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.text.Style;

public class CarList extends UIPanel {
    Rules rules;
    CarLabel[] labels;

    public CarList(int width, int height, int left, int top, Rules rules) {
        super(width, height, left, top);
        this.rules = rules;
    }

    @Override
    public void createContents() {
        labels = new CarLabel[rules.getCars().size()];
        for (int i = 0; i < rules.getCars().size(); i++) {
            Car car = rules.getCars().get(i);
            CarLabel label = new CarLabel(width, 80, 0, 80*i, car);
            label.setParentPanel(this);
            label.createContents();
            labels[i] = label;
            this.add(label);
        }
    }

    @Override
    public void updateChildren() {
        for (int i = 0; i < labels.length; i++) {
            labels[i].changeSize(width, 80);
        }
    }

    public Rules getRules() {
        return rules;
    }

    public void setRules(Rules rules) {
        this.rules = rules;
    }
    
    

}
