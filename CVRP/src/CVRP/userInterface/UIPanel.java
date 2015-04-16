package CVRP.userInterface;

import javax.swing.JPanel;

public abstract class UIPanel extends JPanel {

    protected int width;
    protected int height;
    protected int left;
    protected int top;
    protected UIPanel parentPanel;

    public UIPanel(int width, int height, int left, int top) {
        this.width = width;
        this.height = height;
        this.left = left;
        this.top = top;
        this.setLayout(null);
    }

    public abstract void createContents();

    public abstract void updateChildren();

    public void updateBounds() {
        this.setBounds(left, top, width, height);
    }

    public void changeSize(int x, int y) {
        this.width = x;
        this.height = y;
        updateBounds();
        updateChildren();
    }

    public void changePosition(int x, int y) {
        this.left = x;
        this.top = y;
        updateBounds();
        updateChildren();
    }

    public int getDistanceFromTop() {
        if (parentPanel != null) {
            return this.top + parentPanel.getDistanceFromTop();
        }
        return 0;
    }

    public int getPanelWidth() {
        return width;
    }

    public int getPanelHeight() {
        return height;
    }

    public UIPanel getParentPanel() {
        return parentPanel;
    }

    public void setParentPanel(UIPanel parent) {
        this.parentPanel = parent;
        updateBounds();
    }
    
    

}
