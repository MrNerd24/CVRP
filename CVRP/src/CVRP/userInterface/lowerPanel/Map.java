package CVRP.userInterface.lowerPanel;

import CVRP.algorithm.Rules;
import CVRP.algorithm.Solver;
import CVRP.objects.Location;
import CVRP.userInterface.UIPanel;
import CVRP.utils.TLArrayList;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class Map extends UIPanel {

    Rules rules;
    Solver solver;

    public Map(int width, int height, int left, int top, Rules rules, Solver solver) {
        super(width, height, left, top);
        this.rules = rules;
        this.solver = solver;
        this.setBackground(Color.white);
    }

    public Rules getRules() {
        return rules;
    }

    public void setRules(Rules rules) {
        this.rules = rules;
        this.repaint();
    }

    @Override
    public void createContents() {
        this.repaint();
    }

    @Override
    public void updateChildren() {
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (solver.getBest() != null) {
            drawPath(g2);
        } else {
            drawLocations(g2);
        }
    }

    private void drawLocations(Graphics2D g2) {
        g2.setColor(Color.RED);
        drawLocation(rules.getLocations().get(0), g2);
        g2.setColor(Color.BLACK);
        for (int i = 1; i < rules.getLocations().size(); i++) {
            Location loc = rules.getLocations().get(i);
            drawLocation(loc, g2);
        }
    }

    private void drawPath(Graphics2D g2) {
        TLArrayList<TLArrayList<Location>> paths = solver.getBest().getPaths();
        for (int i = 0; i < paths.size(); i++) {
            for (int j = 1; j < paths.get(i).size(); j++) {
                Location loc1 = paths.get(i).get(j);
                Location loc2 = paths.get(i).get(j - 1);
                if (loc1.getId() != 0) {
                    drawLocation(loc1, g2);
                }
                drawLine(loc1, loc2, g2);
            }

        }
        g2.setColor(Color.RED);
        drawLocation(paths.get(0).get(0), g2);
        g2.setColor(Color.BLACK);
    }

    private void drawLocation(Location loc, Graphics2D g) {
        g.fillOval(loc.getX() - 5, loc.getY() - 5, 10, 10);
    }

    private void drawLine(Location loc1, Location loc2, Graphics2D g) {
        g.draw(new Line2D.Double(loc1.getX(), loc1.getY(), loc2.getX(), loc2.getY()));
    }

}
