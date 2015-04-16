package CVRP.userInterface.lowerPanel;

import CVRP.objects.Car;
import CVRP.userInterface.UIPanel;
import CVRP.userInterface.listeners.CarListener;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CarLabel extends UIPanel {

    private Car car;
    private boolean displayed;
    private JTextField nameEdit;
    private JTextField weightEdit;

    public CarLabel(int width, int height, int left, int top, Car car) {
        super(width, height, left, top);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.car = car;
        this.displayed = true;
        this.nameEdit = new JTextField(car.getName());
        this.weightEdit = new JTextField(String.valueOf(car.getMaxWeight()));
    }

    @Override
    public void createContents() {
        display();
    }

    @Override
    public void updateChildren() {
    }

    public void updateContents() {
        if (displayed) {
            display();
        } else {
            edit();
        }
        
        
    }
    
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
    }
    
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
        this.revalidate();
        this.repaint();
    }

}
