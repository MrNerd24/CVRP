package CVRP.userInterface.upperMenu;

import CVRP.userInterface.MainPanel;
import CVRP.userInterface.UIAPanel;
import CVRP.userInterface.listeners.doGenerationsListener;
import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DoGenerations extends UIAPanel {

    JTextField number;
    JButton reset;
    JButton doButton;
    MainPanel main;

    public DoGenerations(int width, int height, int left, int top, MainPanel main) {
        super(width, height, left, top);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.main = main;
    }

    @Override
    public void createContents() {
        addNumberField();
        this.add(Box.createVerticalStrut(10));
        addResetAndDo();
        this.add(Box.createVerticalStrut(10));
        addDo();
    }

    @Override
    public void updateChildren() {
    }

    private void addNumberField() {
        number = new JTextField("1");
        this.add(new JLabel("Amount:"));
        this.add(number);
    }

    private void addResetAndDo() {
        reset = new JButton("Reset and do generations");
        reset.addActionListener(new doGenerationsListener(true, main, number));
        this.add(reset);
    }

    private void addDo() {
        doButton = new JButton("Do generations");
        doButton.addActionListener(new doGenerationsListener(false, main, number));
        this.add(doButton);
    }

}
