package CVRP.userInterface.upperMenu;

import CVRP.userInterface.Button;
import CVRP.userInterface.MainPanel;
import CVRP.userInterface.UIPanel;
import CVRP.userInterface.listeners.UpperMenuListener;
import java.awt.Color;

public class UpperMenu extends UIPanel {

    MainPanel main;
    UpperMenuListener listener;
    Button[] buttons;
    UIPanel[] optionsBoxes;
    Integer activeBox;

    public UpperMenu(int width, int height, int left, int top, MainPanel main) {
        super(width, height, left, top);
        this.main = main;
        listener = new UpperMenuListener(this);
        this.setBackground(Color.yellow);
    }

    @Override
    public void createContents() {
        createButtons();
        createOptionsBoxes();
    }

    public void createButtons() {
        String[] names = new String[]{"New", "Open", "Save", "Do generations", "Settings"};
        buttons = new Button[names.length];
        int spaceWidth = (width / buttons.length);
        for (int i = 0; i < names.length; i++) {
            Button button = new Button(spaceWidth - 10, 30, spaceWidth * i, 20, names[i], listener, this);
            buttons[i] = button;
            button.createContents();
            this.add(button);
        }
    }

    private void createOptionsBoxes() {
        
    }

    @Override
    public void updateChildren() {
        int spaceWidth = (width / buttons.length);
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].changeSize(spaceWidth - 10, 30);
            buttons[i].changePosition(spaceWidth * i, 20);
        }
    }

    public void buttonClick(String buttonName) {
        switch (buttonName) {
            case "New":
                newButtonClick();
                break;
            case "Open":
                openButtonClick();
                break;
            case "Save":
                saveButtonClick();
                break;
            case "Do generations":
                generationButtonClick();
                break;
            case "Settings":
                settingsButtonClick();
                break;
            default:
                throw new AssertionError();
        }
    }

    private void newButtonClick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void openButtonClick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void saveButtonClick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void generationButtonClick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void settingsButtonClick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
