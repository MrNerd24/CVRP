package CVRP.userInterface.listeners;

import CVRP.objects.Car;
import CVRP.userInterface.lowerPanel.CarLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarListener implements ActionListener {
    CarLabel car;

    public CarListener(CarLabel car) {
        this.car = car;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        car.click();
    }

}
