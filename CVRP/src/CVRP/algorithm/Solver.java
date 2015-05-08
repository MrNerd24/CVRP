package CVRP.algorithm;

import CVRP.objects.DNA;

/**
 * Class that handles the problem solving.
 *
 * @author Juuso
 */
public class Solver {

    private Rules rules;
    private DNA best;
    private Generation latestGen;

    /**
     * Creates a new solver
     *
     * @param rules list of locations, cars and other important things in the
     * solving process.
     */
    public Solver(Rules rules) {
        this.rules = rules;
    }

    /**
     * Creates new generations
     *
     * @param amount the amount of new generations being created.
     */
    public void doGenerations(int amount) {
        for (int i = 0; i < amount; i++) {
            newGeneration();
        }
    }

    /**
     * Returns the best DNA from the latest generation.
     *
     * @return the best DNA.
     */
    public DNA getBest() {
        return best;
    }

    private void newGeneration() {
        if (latestGen == null) {
            latestGen = new Generation(rules);
            latestGen.setDifferenceImportance(1);
            latestGen.sortDNAs();
            best = latestGen.getDNAs().get(0);
        }
        latestGen = new Generation(latestGen, latestGen.getDifferenceImportance() * rules.getDifDec());
        latestGen.sortDNAs();
        best = best.getFitness() >= latestGen.getDNAs().get(0).getFitness() ? latestGen.getDNAs().get(0) : best;
    }

    public Rules getRules() {
        return rules;
    }

    public void setRules(Rules rules) {
        this.rules = rules;
        reset();
    }
    
    /**
     * Resets the solver.
     */
    public void reset() {
        latestGen = null;
        best = null;
    }

}
