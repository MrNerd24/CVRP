package CVRP.userInterface;

import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * A holder class for a button
 * @author Juuso
 */
public class Button extends UIAPanel {

    String name;
    ActionListener listener;
    JButton button;

    /**
     * Creates a new button.
     * @param width Width of the button
     * @param height Height of the button
     * @param left Distance from parent's left side
     * @param top Distance from parent's top
     * @param name Text on the button
     * @param listener Button's listener
     * @param parent button's parent
     */
    public Button(int width, int height, int left, int top, String name, ActionListener listener, UIAPanel parent) {
        super(width, height, left, top);
        this.name = name;
        this.listener = listener;
        this.setParentPanel(parent);
        createContents();
    }

    /**
     * Creates the button.
     */
    @Override
    public void createContents() {
        button = new JButton(name);
        button.addActionListener(listener);
        button.setSize(width, height);
        this.add(button);
    }

    /**
     * Updates the size.
     */
    @Override
    public void updateChildren() {
        button.setSize(width, height);
    }

}
