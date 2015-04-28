package CVRP.userInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TextField extends UIAPanel {

    JTextField field;
    JLabel name;

    public TextField(int width, int height, int left, int top, String name) {
        super(width, height, left, top);
        this.setLayout(new BorderLayout());
        field = new JTextField();
        this.name = new JLabel(name);
        
        createContents();
    }

    @Override
    public void createContents() {
        this.add(name, BorderLayout.NORTH);
        this.add(field);
    }

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
