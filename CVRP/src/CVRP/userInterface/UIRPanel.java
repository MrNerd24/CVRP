package CVRP.userInterface;

import CVRP.interfaces.UIPanel;
import java.awt.Dimension;
import javax.swing.JPanel;

public abstract class UIRPanel extends JPanel implements UIPanel {

    protected int width;
    protected int height;
    private UIPanel parentPanel;

    public UIRPanel(int width, int height) {
        this.width = width;
        this.height = height;
        this.setLayout(null);
    }

    public abstract void createContents();

    public abstract void updateChildren();

    public void updateBounds() {
        this.setPreferredSize(new Dimension(width, height));
    }

    public void changeSize(int x, int y) {
        this.width = x;
        this.height = y;
        updateBounds();
        updateChildren();
    }

    public int getPanelWidth() {
        return width;
    }

    public int getPanelHeight() {
        return height;
    }

    @Override
    public UIPanel getParentPanel() {
        return parentPanel;
    }

    @Override
    public void setParentPanel(UIPanel parent) {
        this.parentPanel = parent;
        updateBounds();
    }

}
