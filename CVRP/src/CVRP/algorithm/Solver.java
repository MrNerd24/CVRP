package CVRP.algorithm;

import CVRP.objects.DNA;

public class Solver {

    private Objects objects;
    private DNA best;
    private Generation latestGen;

    public Solver(Objects objects) {
        this.objects = objects;
    }
    
    public void doGenerators(int amount) {
        for (int i = 0; i < amount; i++) {
            newGeneration();
        }
    }
    
    public DNA getBest() {
        return best;
    }

    private void newGeneration() {
        latestGen = new Generation(objects, latestGen);
    }
}
