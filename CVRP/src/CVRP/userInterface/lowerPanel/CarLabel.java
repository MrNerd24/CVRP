package CVRP.userInterface.lowerPanel;

import CVRP.objects.Car;
import CVRP.userInterface.MainPanel;
import CVRP.userInterface.listeners.CarListener;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Panel that displays car's information and allows to edit.
 * @author Juuso
 */
public class CarLabel extends JPanel {

    private Car car;
    private boolean displayed;
    private JTextField nameEdit;
    private JTextField weightEdit;

    /**
     * Creates a new carLable
     * @param car displayed car
     */
    public CarLabel(Car car) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.car = car;
        this.displayed = true;
        this.nameEdit = new JTextField(car.getName());
        this.weightEdit = new JTextField(String.valueOf(car.getMaxWeight()));
    }


    public void createContents() {
        display();
    }

    public void updateContents() {
        if (displayed) {
            display();
        } else {
            edit();
        }

    }

    /**
     * Method that is ran when a edit button is clicked.
     */
    public void click() {

        String newName = nameEdit.getText();
        int newWeight = Integer.parseInt(weightEdit.getText());

        car.setName(newName);
        car.setMaxWeight(newWeight);

        if (displayed) {
            displayed = false;
            edit();
        } else {
            displayed = true;
            display();
        }

        if (displayed) {
            MainPanel main = findMain();
            main.resetSolver();
            main.updateLower();
        }
    }

    /**
     * Displays the car's information
     */
    public void display() {
        this.removeAll();

        Font title = new Font(Font.SANS_SERIF, Font.BOLD, 16);
        Font sub = new Font(Font.SANS_SERIF, Font.PLAIN, 16);

        JLabel carName = new JLabel(car.toString());
        carName.setFont(title);
        this.add(carName);

        JLabel weight = new JLabel("  Can carry: " + car.getMaxWeight());
        weight.setFont(sub);
        this.add(weight);

        JButton editButton = new JButton("Edit");
        editButton.addActionListener(new CarListener(this));
        this.add(editButton);

        this.revalidate();
        this.repaint();
    }

    /**
     * Allows to edit the car's information
     */
    public void edit() {
        this.removeAll();

        Font title = new Font(Font.SANS_SERIF, Font.BOLD, 16);
        Font sub = new Font(Font.SANS_SERIF, Font.PLAIN, 16);

        nameEdit.setFont(title);
        nameEdit.addActionListener(new CarListener(this));
        this.add(nameEdit);

        weightEdit.setFont(sub);
        weightEdit.addActionListener(new CarListener(this));
        this.add(weightEdit);

        if (displayed) {
            MainPanel main = (MainPanel) this.getParent().getParent().getParent().getParent().getParent().getParent().getParent();
            main.updateLower();
        }

        this.revalidate();
        this.repaint();
    }

    /**
     * Finds the mainPanel
     * @return mainPanel
     */
    public MainPanel findMain() {
        Component parent = this.getParent();
        while (!parent.getClass().equals(MainPanel.class)) {
            parent = parent.getParent();
        }
        return (MainPanel) parent;
    }

}
