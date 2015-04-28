package CVRP.userInterface.lowerPanel;

import CVRP.algorithm.Rules;
import CVRP.algorithm.Solver;
import CVRP.userInterface.UIAPanel;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;

public class LowerPanel extends UIAPanel {

    private Map map;
    private ObjectList objectList;
    public Rules rules;
    private Solver solver;

    public LowerPanel(int width, int height, int left, int top, Rules rules, Solver solver) {
        super(width, height, left, top);
        this.rules = rules;
        this.solver = solver;
    }

    @Override
    public void createContents() {
        map = new Map((int) (width * 0.8), height, 0, 0, rules, solver);
        map.setParentPanel(this);
        map.createContents();
        this.add(map);
        objectList = new ObjectList((int) (width * 0.2), height, (int) (width * 0.8), 0, rules);
        objectList.setParentPanel(this);
        objectList.createContents();
        this.add(objectList);
    }

    @Override
    public void updateChildren() {
        map.changeSize((int) (width * 0.8), height);
        objectList.changeSize((int) (width * 0.2), height);
        objectList.changePosition((int) (width * 0.8), 0);
    }

    public Rules getRules() {
        return rules;
    }

    public void setRules(Rules rules) {
        this.rules = rules;
        map.setRules(rules);
    }
    
    public void updateContents() {
        map.rules = rules;
        map.repaint();
        objectList.rules = rules;
        objectList.updateContents();
    }

}
