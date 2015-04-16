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

public class MainPanel extends UIPanel {

    public Rules rules;
    public Solver solver;
    public UpperMenu upper;
    public LowerPanel lower;

    public MainPanel(int width, int height, int left, int top) {
        super(width, height, left, top);
        this.setBackground(Color.red);
        testRules();
        this.solver = new Solver(rules);
        solver.doGenerations(5000);
    }

    private void createUpper() {
        this.upper = new UpperMenu(width, 70, 0, 0, this);
        upper.setParentPanel(this);
        upper.createContents();
        this.add(upper);
    }

    private void createLower() {
        lower = new LowerPanel(width, height-70, 0, 70, rules, solver);
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
        upper.changeSize(width, 70);
        lower.changeSize(width, height-70);
    }

    public Rules getRules() {
        return rules;
    }

    public void setRules(Rules rules) {
        this.rules = rules;
        lower.setRules(rules);
    }
    
    private void testRules() {
        rules = new Rules(1000, 1000, 50, 0.99);

        rules.getLocations().add(new Location(0, r(), r()));
        rules.getLocations().add(new Location(1, r(), r()));
        rules.getLocations().add(new Location(2, r(), r()));
        rules.getLocations().add(new Location(3, r(), r()));
        rules.getLocations().add(new Location(4, r(), r()));
        rules.getLocations().add(new Location(5, r(), r()));
        rules.getLocations().add(new Location(6, r(), r()));
        rules.getLocations().add(new Location(7, r(), r()));
        rules.getLocations().add(new Location(8, r(), r()));
        rules.getLocations().add(new Location(9, r(), r()));
        rules.getLocations().add(new Location(10, r(), r()));
        rules.getLocations().add(new Location(11, r(), r()));
        rules.getLocations().add(new Location(12, r(), r()));
        rules.getLocations().add(new Location(13, r(), r()));
        rules.getLocations().add(new Location(14, r(), r()));

        rules.getLocations().get(1).getPackets().add(new Packet(1, 4));
        rules.getLocations().get(2).getPackets().add(new Packet(2, 3));
        rules.getLocations().get(2).getPackets().add(new Packet(3, 5));
        rules.getLocations().get(3).getPackets().add(new Packet(4, 8));
        rules.getLocations().get(3).getPackets().add(new Packet(5, 1));
        rules.getLocations().get(4).getPackets().add(new Packet(6, 1));
        rules.getLocations().get(4).getPackets().add(new Packet(7, 1));
        rules.getLocations().get(4).getPackets().add(new Packet(8, 2));
        rules.getLocations().get(5).getPackets().add(new Packet(9, 9));
        rules.getLocations().get(6).getPackets().add(new Packet(10, 1));
        rules.getLocations().get(6).getPackets().add(new Packet(11, 9));
        rules.getLocations().get(7).getPackets().add(new Packet(12, 3));
        rules.getLocations().get(8).getPackets().add(new Packet(13, 10));
        rules.getLocations().get(10).getPackets().add(new Packet(14, 2));
        rules.getLocations().get(10).getPackets().add(new Packet(15, 5));
        rules.getLocations().get(11).getPackets().add(new Packet(16, 7));
        rules.getLocations().get(11).getPackets().add(new Packet(17, 7));
        rules.getLocations().get(12).getPackets().add(new Packet(18, 1));
        rules.getLocations().get(13).getPackets().add(new Packet(19, 6));
        rules.getLocations().get(14).getPackets().add(new Packet(20, 10));
        rules.getLocations().get(14).getPackets().add(new Packet(21, 11));

        rules.getCars().add(new Car(1, 50));
        rules.getCars().add(new Car(2, 50));
    }
    
    private int r() {
        Random random = new Random();
        return random.nextInt(501);
    }
    
    

}
