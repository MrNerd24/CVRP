package CVRP.userInterface.listeners;

import CVRP.userInterface.MainPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class doGenerationsListener implements ActionListener {

    boolean reset;
    MainPanel main;
    JTextField amount;

    public doGenerationsListener(boolean reset, MainPanel main, JTextField amount) {
        this.reset = reset;
        this.main = main;
        this.amount = amount;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        int amount;
        try {
            amount = Integer.parseInt(this.amount.getText());
        } catch (Exception e) {
            amount = 1;
        }

        if (amount < 1) {
            amount = 1;
        }
        if (reset) {
            main.resetSolver();
        }
        main.solver.doGenerations(amount);
        main.updateLower();
    }

}
