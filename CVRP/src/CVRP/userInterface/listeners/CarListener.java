package CVRP.userInterface.listeners;

import CVRP.objects.Car;
import CVRP.userInterface.lowerPanel.CarLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listening the edit car button
 * @author Juuso
 */
public class CarListener implements ActionListener {
    CarLabel car;

    /**
     * Creates a new carListener
     * @param car Carlabel that is clicked
     */
    public CarListener(CarLabel car) {
        this.car = car;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        car.click();
    }

}
