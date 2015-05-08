package CVRP.userInterface.lowerPanel;

import CVRP.algorithm.Rules;
import CVRP.objects.Car;
import CVRP.userInterface.MainPanel;
import CVRP.userInterface.listeners.newCarListener;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Lists all carLabels
 * @author Juuso
 */
public class CarList extends JPanel {

    Rules rules;
    CarLabel[] labels;

    public CarList(Rules rules) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.rules = rules;
    }

    /**
     * Creates the list.
     */
    public void createContents() {
        labels = new CarLabel[rules.getCars().size()];
        for (int i = 0; i < rules.getCars().size(); i++) {
            Car car = rules.getCars().get(i);
            CarLabel label = new CarLabel(car);
            label.createContents();
            labels[i] = label;
            this.add(label);
            this.add(Box.createVerticalStrut(15));
        }
        JButton button = new JButton("New car");
        button.addActionListener(new newCarListener(rules, this));
        this.add(button);
        this.add(Box.createVerticalStrut(30));
    }

    public Rules getRules() {
        return rules;
    }

    public void setRules(Rules rules) {
        this.rules = rules;
    }

    /**
     * updates the list's contents.
     */
    public void updateContents() {
        this.removeAll();
        createContents();
        this.revalidate();
        this.repaint();
    }

    /**
     * Finds the mainpanel
     * @return Mainpanel
     */
    public MainPanel findMain() {
        Component parent = this.getParent();
        while (!parent.getClass().equals(MainPanel.class)) {
            parent = parent.getParent();
        }
        return (MainPanel) parent;
    }

}
