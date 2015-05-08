package CVRP.userInterface.upperMenu;

import CVRP.algorithm.Rules;
import CVRP.objects.Car;
import CVRP.userInterface.Button;
import CVRP.userInterface.MainPanel;
import CVRP.userInterface.TextField;
import CVRP.userInterface.UIAPanel;
import CVRP.userInterface.listeners.UpperMenuButtonListener;

/**
 * Upper menu holds buttons for controlling the algorihm.
 * @author Juuso
 */
public class UpperMenu extends UIAPanel {

    MainPanel main;
    UpperMenuButtonListener buttonListener;
    UIAPanel[] optionsBoxes;
    Integer activeBox;

    Button newBut;
    Button resBut;
    private Button saveBut;
    private Button genBut;
    TextField genAmount;
    TextField saveName;
    TextField mutationAmount;
    TextField difDisAmount;
    TextField fitDisAmount;
    TextField difDecAmount;
    private Button ranBut;
    private TextField randomAmount;

    /**
     * Creates a new upperMenu
     * @param width Width of the menu.
     * @param height Height of the menu.
     * @param left Distance from parent's left side
     * @param top Distance from Parent's top side
     * @param main MainPanel
     */
    public UpperMenu(int width, int height, int left, int top, MainPanel main) {
        super(width, height, left, top);
        this.main = main;
        buttonListener = new UpperMenuButtonListener(this);

    }

    @Override
    public void createContents() {
        createNewButton();
        createResetButton();
        createRandomButton();
        createRandoms();
        createOpenList();
        createGenerationAmount();
        createDoGenerationsButton();
        createMutations();
        createFitDis();
        createDifDec();
        createDifDis();
    }

    @Override
    public void updateChildren() {
        newBut.changePosition(getSpotFromLeft(0), getSpotFromTop(0));
        resBut.changePosition(getSpotFromLeft(0), getSpotFromTop(1));
        genBut.changePosition(getSpotFromLeft(2), getSpotFromTop(1));
        genAmount.changePosition(getSpotFromLeft(2), getSpotFromTop(0));
        mutationAmount.changePosition(getSpotFromLeft(3), getSpotFromTop(0));
        difDisAmount.changePosition(getSpotFromLeft(4), getSpotFromTop(1));
        fitDisAmount.changePosition(getSpotFromLeft(4), getSpotFromTop(0));
        difDecAmount.changePosition(getSpotFromLeft(3), getSpotFromTop(1));
        ranBut.changePosition(getSpotFromLeft(1), getSpotFromTop(1));
        randomAmount.changePosition(getSpotFromLeft(1), getSpotFromTop(0));

        newBut.changeSize(getSpotWidth(), getSpotHeight());
        resBut.changeSize(getSpotWidth(), getSpotHeight());
        genBut.changeSize(getSpotWidth(), getSpotHeight());
        genAmount.changeSize(getSpotWidth(), getSpotHeight());
        mutationAmount.changeSize(getSpotWidth(), getSpotHeight());
        difDisAmount.changeSize(getSpotWidth(), getSpotHeight());
        fitDisAmount.changeSize(getSpotWidth(), getSpotHeight());
        difDecAmount.changeSize(getSpotWidth(), getSpotHeight());
        ranBut.changeSize(getSpotWidth(), getSpotHeight());
        randomAmount.changeSize(getSpotWidth(), getSpotHeight());

        this.revalidate();
        this.repaint();
    }

    /**
     * This method is ran when some of the buttons is clicked.
     * @param buttonName Name of the button.
     */
    public void buttonClick(String buttonName) {
        switch (buttonName) {
            case "New":
                newButtonClick();
                break;
            case "Reset":
                resetButtonClick();
                break;
            case "Save":
                saveButtonClick();
                break;
            case "Do generations":
                genButtonClick();
                break;
            case "Random map":
                randomClick();
                break;
            default:
                throw new AssertionError();
        }
    }

    private void newButtonClick() {
        Rules rules = new Rules(1000, 1000, 20, 0.99, 100, 100);
        rules.getCars().add(new Car(0, 50));
        main.rules = rules;
        main.solver.setRules(rules);
        main.updateLower();
    }

    private int getSpotFromLeft(int spot) {
        return (int) (((width / 5) * spot) + (width / 5) * 0.1);
    }

    private int getSpotFromTop(int spot) {
        return (int) (((height / 2) * spot) + (height / 2) * 0.1);
    }

    private int getSpotWidth() {
        return (int) ((width / 5) * 0.8);
    }

    private int getSpotHeight() {
        return (int) ((height / 2) * 0.8);
    }

    private void createNewButton() {
        newBut = new Button(getSpotWidth(), getSpotHeight(), getSpotFromLeft(0), getSpotFromTop(0), "New", buttonListener, this);
        this.add(newBut);
    }

    private void createResetButton() {
        resBut = new Button(getSpotWidth(), getSpotHeight(), getSpotFromLeft(0), getSpotFromTop(1), "Reset", buttonListener, this);
        this.add(resBut);
    }

    private void createFileName() {
        saveName = new TextField(getSpotWidth(), getSpotHeight(), getSpotFromLeft(2), getSpotFromTop(0), "File name:");
        this.add(saveName);
    }

    private void createSaveButton() {
        saveBut = new Button(getSpotWidth(), getSpotHeight(), getSpotFromLeft(2), getSpotFromTop(1), "Save", buttonListener, this);
        this.add(saveBut);
    }

    private void createOpenList() {

    }

    private void createGenerationAmount() {
        genAmount = new TextField(getSpotWidth(), getSpotHeight(), getSpotFromLeft(4), getSpotFromTop(0), "Amount of generations:");
        genAmount.setText("500");
        this.add(genAmount);
    }

    private void createDoGenerationsButton() {
        genBut = new Button(getSpotWidth(), getSpotHeight(), getSpotFromLeft(4), getSpotFromTop(1), "Do generations", buttonListener, this);
        this.add(genBut);
    }

    private void createMutations() {
        mutationAmount = new TextField(getSpotWidth(), getSpotHeight(), getSpotFromLeft(5), getSpotFromTop(0), "Max mutations");
        mutationAmount.setText(String.valueOf(main.rules.getMutations()));
        this.add(mutationAmount);
    }

    private void createFitDis() {
        fitDisAmount = new TextField(getSpotWidth(), getSpotHeight(), getSpotFromLeft(6), getSpotFromTop(0), "Fitness distance:");
        fitDisAmount.setText(String.valueOf(main.rules.getFitDis()));
        this.add(fitDisAmount);
    }

    private void createDifDec() {
        difDecAmount = new TextField(getSpotWidth(), getSpotHeight(), getSpotFromLeft(5), getSpotFromTop(1), "Difference decrease:");
        difDecAmount.setText(String.valueOf(main.rules.getDifDec()));
        this.add(difDecAmount);
    }

    private void createDifDis() {
        difDisAmount = new TextField(getSpotWidth(), getSpotHeight(), getSpotFromLeft(6), getSpotFromTop(1), "Difference distance:");
        difDisAmount.setText(String.valueOf(main.rules.getDifDis()));
        this.add(difDisAmount);
    }

    private void resetButtonClick() {
        main.solver.reset();
        main.updateLower();
    }

    private void saveButtonClick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void genButtonClick() {
        int amount = 1;
        try {
            amount = getNumberFromField(genAmount);
            if (amount <= 0) {
                amount = 1;
            }
        } catch (Exception e) {
        }
        main.solver.doGenerations(amount);
        main.updateLower();
    }



    private int getNumberFromField(TextField field) {
        String text = field.getText();
        int number = 0;
        try {
            number = Integer.parseInt(text);
        } catch (Exception e) {
            throw e;
        }
        return number;
    }

    private void createRandomButton() {
        ranBut = new Button(getSpotWidth(), getSpotHeight(), getSpotFromLeft(1), getSpotFromTop(1), "Random map", buttonListener, this);
        this.add(ranBut);
    }

    private void createRandoms() {
        randomAmount = new TextField(getSpotWidth(), getSpotHeight(), getSpotFromLeft(6), getSpotFromTop(0), "Locations in random:");
        randomAmount.setText("20");
        this.add(randomAmount);
    }

    /**
     * Assaigns new values for rules.
     */
    public void updateRuleValues() {
        try {
            main.rules.setMutations(getNumberFromField(mutationAmount));
        } catch (Exception e) {
        }

        try {
            main.rules.setFitDis(getNumberFromField(fitDisAmount));
        } catch (Exception e) {
        }

        try {
            main.rules.setDifDec(getNumberFromField(difDecAmount));
        } catch (Exception e) {
        }

        try {
            main.rules.setDifDis(getNumberFromField(difDisAmount));
        } catch (Exception e) {
        }

    }

    private void randomClick() {
        try {
            main.randomMap(getNumberFromField(randomAmount));
        } catch (Exception e) {
        }
        
    }

}
