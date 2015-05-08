package CVRP.userInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * A holder for a textfield
 * @author Juuso
 */
public class TextField extends UIAPanel {

    JTextField field;
    JLabel name;

    /**
     * New textfield
     * @param width Field's width.
     * @param height Field's height
     * @param left Distance from parent's left side
     * @param top Distance from parent's top side
     * @param name Instructions for the desired input
     */
    public TextField(int width, int height, int left, int top, String name) {
        super(width, height, left, top);
        this.setLayout(new BorderLayout());
        field = new JTextField();
        this.name = new JLabel(name);
        
        createContents();
    }

    /**
     * Creates the textfield.
     */
    @Override
    public void createContents() {
        this.add(name, BorderLayout.NORTH);
        this.add(field);
    }

    /**
     * Does nothing...
     */
    @Override
    public void updateChildren() {
    }
    
    public String getText() {
        return field.getText();
    }
    
    public void setText(String text) {
        field.setText(text);
    }

}
