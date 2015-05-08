package CVRP.userInterface.listeners;

import CVRP.algorithm.Rules;
import CVRP.objects.Car;
import CVRP.userInterface.lowerPanel.CarList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listens the new car button
 * @author Juuso
 */
public class newCarListener implements ActionListener {

    Rules rules;
    CarList list;

    public newCarListener(Rules rules, CarList list) {
        this.rules = rules;
        this.list = list;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        rules.getCars().add(new Car(getUnusedId(), 20));
        list.findMain().resetSolver();
        list.findMain().updateLower();
    }

    /**
     * Finds the next unused carID.
     * @return
     */
    public int getUnusedId() {
        boolean[] used = new boolean[10000];
        for (int i = 0; i < rules.getCars().size(); i++) {
            used[rules.getCars().get(i).getId()] = true;
        }
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                return i;
            }
        }
        return -1;
    }

}
