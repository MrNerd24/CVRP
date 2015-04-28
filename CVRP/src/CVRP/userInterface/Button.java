package CVRP.userInterface;

import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Button extends UIAPanel {

    String name;
    ActionListener listener;
    JButton button;

    public Button(int width, int height, int left, int top, String name, ActionListener listener, UIAPanel parent) {
        super(width, height, left, top);
        this.name = name;
        this.listener = listener;
        this.setParentPanel(parent);
        createContents();
    }

    @Override
    public void createContents() {
        button = new JButton(name);
        button.addActionListener(listener);
        button.setSize(width, height);
        this.add(button);
    }

    @Override
    public void updateChildren() {
        button.setSize(width, height);
    }

}
