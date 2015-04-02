package CVRP.algorithm;

import CVRP.objects.DNA;
import CVRP.utils.TLArrayList;

/**
 * Creates a generation. the generation will have 100 dnas.
 * @author Juuso
 */
public class Generation {

    private TLArrayList<DNA> DNAs = new TLArrayList<DNA>();
    private double differenceImportance;
    private Rules rules;

    /**
     * Creates a new generation from a old generation. It chooses 10 best dnas from the older generation and creates new ones based on those.
     * @param lastGen Older generation that will contain the parents for this generation.
     * @param differenceImportance defines how much the algorithm favours difference from the last generation in the scoring. This will only affect things when this generation is use as a param in a new generation.
     */
    public Generation(Generation lastGen, double differenceImportance) {
        rules = lastGen.rules;
        this.differenceImportance = differenceImportance;
        lastGen.sortDNAs();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                DNA dna = new DNA(lastGen.getDNAs().get(i), lastGen.getDNAs().get(j));
                dna.mutate();
                DNAs.add(dna);
            }
        }
        for (int i = 0; i < DNAs.size(); i++) {
            DNAs.get(i).setDifferenceImportance(differenceImportance);
        }
    }

    /**
     * Creates a new generation that will be totally random.
     * @param rules Rules object should contain all the locations, cars and packets and also some other settings. 
     */
    public Generation(Rules rules) {
        this.rules = rules;
        for (int i = 0; i < 100; i++) {
            DNAs.add(new DNA(true, rules));
        }
    }

    /**
     * Sorts the dnas based on their score. dna's compareTo method will calculate the scores if they are not yet calculated.
     */
    public void sortDNAs() {
        DNAs = TLArrayList.sort(DNAs);
    }

    public TLArrayList<DNA> getDNAs() {
        return DNAs;
    }

    /**
     * DifferenceImportance tells the score calculating method how much to favour difference between a dna and its parents.
     * @return Returns the differenceimportance.
     */
    public double getDifferenceImportance() {
        return differenceImportance;
    }

    /**
     * DifferenceImportance tells the score calculating method how much to favour difference between a dna and its parents.
     * @param differenceImportance new value for the differenceimportance. Must be between 1 and 0
     */
    public void setDifferenceImportance(double differenceImportance) {
        this.differenceImportance = differenceImportance;
    }
    
    
    
    

}
