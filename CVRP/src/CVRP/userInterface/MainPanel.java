package CVRP.userInterface;

import CVRP.userInterface.lowerPanel.LowerPanel;
import CVRP.userInterface.upperMenu.UpperMenu;
import CVRP.algorithm.Rules;
import CVRP.algorithm.Solver;
import CVRP.objects.Car;
import CVRP.objects.Location;
import CVRP.objects.Packet;
import java.awt.Color;
import java.util.Random;

public class MainPanel extends UIAPanel {

    public Rules rules;
    public Solver solver;
    public UpperMenu upper;
    public LowerPanel lower;

    public MainPanel(int width, int height, int left, int top) {
        super(width, height, left, top);
        rules = new Rules(1000, 1000, 20, 0.99, 100, 100);
        rules.getCars().add(new Car(0, 50));
        this.solver = new Solver(rules);
    }

    private void createUpper() {
        this.upper = new UpperMenu(width, 140, 0, 0, this);
        upper.setParentPanel(this);
        upper.createContents();
        this.add(upper);
    }

    private void createLower() {
        lower = new LowerPanel(width, height - 140, 0, 140, rules, solver);
        lower.setParentPanel(this);
        lower.createContents();
        this.add(lower);
    }

    @Override
    public void createContents() {
        createUpper();
        createLower();
    }

    @Override
    public void updateChildren() {
        upper.changeSize(width, 140);
        lower.changeSize(width, height - 140);
    }

    public Rules getRules() {
        return rules;
    }

    public void setRules(Rules rules) {
        this.rules = rules;
        lower.setRules(rules);
    }

    private int r() {
        return r(601);
    }

    private int r(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }

    public void updateLower() {
        lower.rules = rules;
        lower.updateContents();
    }

    public void resetSolver() {
        solver.reset();
    }

    public void randomMap(int locations) {
        rules = new Rules(1000, 1000, 50, 0.99, r(), r());
        int packetid = 0;
        for (int i = 1; i < locations; i++) {
            rules.getLocations().add(new Location(i, r(), r()));
            for (int j = 0; j < r(6); j++) {
                rules.getLocations().get(i).getPackets().add(new Packet(packetid, r(50)));
                packetid++;

            }
        }

        rules.getCars().add(new Car(0, 500));
        solver.setRules(rules);
        updateLower();
    }
    
}
