package CVRP.userInterface;

import CVRP.interfaces.UIPanel;
import javax.swing.JPanel;

/**
 *
 * @author Juuso
 */
public abstract class UIAPanel extends JPanel implements UIPanel {

    protected int width;
    protected int height;
    protected int left;
    protected int top;
    protected UIPanel parentPanel;

    /**
     * Abstract class for absolutely positioned panel
     *
     * @param width Width of the panel
     * @param height Height of the panel
     * @param left distance from the parent's left side.
     * @param top distance from the parent's top side.
     */
    public UIAPanel(int width, int height, int left, int top) {
        this.width = width;
        this.height = height;
        this.left = left;
        this.top = top;
        this.setLayout(null);
    }

    /**
     * Creates children.
     */
    public abstract void createContents();

    /**
     * Updates children's size.
     */
    public abstract void updateChildren();

    /**
     * Updates the panel's size and location.
     */
    public void updateBounds() {
        this.setBounds(left, top, width, height);
    }

    /**
     * Changes the panel's size
     *
     * @param width New width
     * @param height New height
     */
    public void changeSize(int width, int height) {
        this.width = width;
        this.height = height;
        updateBounds();
        updateChildren();
    }

    /**
     * Changes the panel's position
     *
     * @param width new distane from left
     * @param height new distance from top
     */
    public void changePosition(int width, int height) {
        this.left = width;
        this.top = height;
        updateBounds();
        updateChildren();
    }

    /**
     * Returns the panel's width
     *
     * @return Width
     */
    public int getPanelWidth() {
        return width;
    }

    /**
     * Returns the panel's height
     *
     * @return Height
     */
    public int getPanelHeight() {
        return height;
    }

    /**
     * Returns the parent panel. Parent panel needs to be set before. Can also
     * use JPanel's own getPanel method
     *
     * @return Parent panel
     */
    @Override
    public UIPanel getParentPanel() {
        return parentPanel;
    }

    /**
     * Sets the Parent and updtes the bounds
     *
     * @param parent parent panel
     */
    public void setParentPanel(UIPanel parent) {
        this.parentPanel = parent;
        updateBounds();
    }

}
