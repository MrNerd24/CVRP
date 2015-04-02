package CVRP.objects;

import CVRP.algorithm.Rules;
import CVRP.utils.TLArrayList;
import java.util.Random;

/**
 * DNA class holds a solution for the problem.
 *
 * @author Juuso
 */
public class DNA implements Comparable<DNA>, Cloneable {

    private Rules rules;
    private TLArrayList<TLArrayList<Location>> runningOrder;
    private boolean loadingOrder = true;
    private TLArrayList<TLArrayList<Location>> paths;
    private int fitness = Integer.MAX_VALUE;
    private int difference = Integer.MAX_VALUE;
    private int score = Integer.MAX_VALUE;
    private double differenceImportance;
    private DNA daddy;
    private DNA mommy;

    /**
     * Creates a new DNA
     *
     * @param random True if the dna should be filled with a random solution.
     * @param rules Rules used to make the DNA.
     */
    public DNA(boolean random, Rules rules) {
        this.differenceImportance = 1;
        this.rules = rules;
        runningOrder = new TLArrayList<>();
        paths = new TLArrayList<>();
        if (random) {
            createRandomDNA();
        } else {
            createEmptyDNA();
        }

    }

    /**
     * Creates a new DNA based on other DNAs
     * @param daddy Daddy DNA
     * @param mommy Mommy DNA
     */
    public DNA(DNA daddy, DNA mommy) {
        this.differenceImportance = daddy.differenceImportance;
        this.rules = daddy.rules;
        runningOrder = new TLArrayList<>();
        paths = new TLArrayList<>();
        this.daddy = daddy;
        this.mommy = mommy;
        TLArrayList<Location> frees = new TLArrayList<Location>();
        crossoverFromDaddy(daddy, frees);
        crossoverFromMommy(mommy, frees);
        for (int i = 0; i < runningOrder.size(); i++) {
            runningOrder.get(i).reduceSize();
        }

    }

    private void crossoverFromMommy(DNA mommy, TLArrayList<Location> frees) {
        for (int i = 0; i < mommy.runningOrder.size(); i++) {
            for (int j = 0; j < mommy.runningOrder.get(i).size(); j++) {
                if (frees.contains(mommy.runningOrder.get(i).get(j))) {
                    this.runningOrder.get(i).add(mommy.runningOrder.get(i).get(j));
                }
            }
        }
    }

    private void crossoverFromDaddy(DNA daddy, TLArrayList<Location> frees) {
        Random random = new Random();
        for (int i = 0; i < daddy.runningOrder.size(); i++) {
            runningOrder.set(i, new TLArrayList<Location>());
            for (int j = 0; j < daddy.runningOrder.get(i).size(); j++) {
                if (random.nextInt(20) % 2 == 0) {
                    runningOrder.get(i).set(j, daddy.runningOrder.get(i).get(j));
                } else {
                    frees.add(daddy.runningOrder.get(i).get(j));
                }
            }
        }
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    public void setDifference(int difference) {
        this.difference = difference;
    }

    private void createRandomDNA() {
        Random random = new Random();
        for (int i = 0; i < rules.getCars().size(); i++) {
            if (runningOrder.get(i) == null) {
                runningOrder.set(i, new TLArrayList<>());
            }
        }
        for (int i = 1; i < rules.getLocations().size(); i++) {
            Location location = rules.getLocations().get(i);
            int carIndex = random.nextInt(rules.getCars().size());
            runningOrder.get(carIndex).add(location);
        }
    }

    private void createEmptyDNA() {
        for (int i = 0; i < rules.getCars().size(); i++) {
            runningOrder.add(new TLArrayList<>());
        }
    }

    /**
     * Mutates the DNA by either swapping locations inside a car route or swapping locations between two car routes.
     * @param maxAmount Max amount of mutations.
     */
    public void mutate(int maxAmount) {
        Random random = new Random();
        int mutations = random.nextInt(maxAmount);
        for (int i = 0; i < mutations; i++) {
            int type = random.nextInt(20);
            if (type % 4 == 0) {
                swapBetweenRoutes();
            } else {
                swapInARoute();
            }
        }
    }
    
    /**
     * Mutates the DNA by either swapping locations inside a car route or swapping locations between two car routes.
     */
    public void mutate() {
        mutate(rules.getMutations());
    }

    private void swapBetweenRoutes() {
        Random random = new Random();
        int randomCar1 = random.nextInt(rules.getCars().size());
        int randomCar2 = random.nextInt(rules.getCars().size());
        if (runningOrder.get(randomCar1).size() < 2) {
            return;
        }
        
        int randomLocation = random.nextInt(runningOrder.get(randomCar1).size());

        Location holder = runningOrder.get(randomCar1).remove(randomLocation);
        runningOrder.get(randomCar2).add(holder);
    }

    private void swapInARoute() {
        Random random = new Random();
        int randomCar = random.nextInt(runningOrder.size());
        while (runningOrder.get(randomCar).isEmpty()) {
            randomCar = random.nextInt(runningOrder.size());
        }
        if (runningOrder.get(randomCar).size() < 2) {
            return;
        }
        int swapIndex1 = random.nextInt(runningOrder.get(randomCar).size());
        int swapIndex2 = swapIndex1 + 1;
        if (swapIndex2 >= runningOrder.get(randomCar).size()) {
            swapIndex2 = swapIndex1 - 1;
        }
        if (swapIndex2 < 0) {
            return;
        }

        Location holder = runningOrder.get(randomCar).get(swapIndex1);
        runningOrder.get(randomCar).set(swapIndex1, runningOrder.get(randomCar).get(swapIndex2));
        runningOrder.get(randomCar).set(swapIndex2, holder);
    }

    /**
     * Calculates the fitness. Fitness is the longest route distance betweens the car routes. This method also caches the calculates fitness.
     * @return Returns the fitness.
     */
    public int calculateFitness() {
        double answer = 0;
        for (int i = 0; i < rules.getCars().size(); i++) {
            Car car = rules.getCars().get(i);
            int maxWeight = car.getMaxWeight();
            TLArrayList<Location> locations = runningOrder.get(i);
            TLArrayList<Location> path = makePath(locations, maxWeight);
            paths.add(path);
//            answer += getPathDistance(path);
            answer = Math.max(answer, getPathDistance(path));
        }
        fitness = (int) answer;
        return (int) answer;
    }

    private TLArrayList<Location> makePath(TLArrayList<Location> locations, int maxWeight) {
        TLArrayList<Location> path = new TLArrayList<Location>();
        path.add(rules.getLocations().get(0));
        int weight = 0;
        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).getPackets().isEmpty()) {
                continue;
            }
            int newWeight = weight;
            for (int j = 0; j < locations.get(i).getPackets().size(); j++) {
                newWeight += locations.get(i).getPackets().get(j).getWeight();
            }
            if (weight <= maxWeight && newWeight > maxWeight) {
                weight = newWeight - weight;
                if (weight > maxWeight) {
                    weight = handleWeirdWeight(locations, i, maxWeight, path);
                } else {
                    path.add(rules.getLocations().get(0));
                    path.add(locations.get(i));
                }

            } else {
                weight = newWeight;
                path.add(locations.get(i));
            }
        }
        path.add(rules.getLocations().get(0));
        return path;
    }

    private int handleWeirdWeight(TLArrayList<Location> locations, int i, int maxWeight, TLArrayList<Location> path) throws Error {
        int weight;
        int weightBetween = 0;
        path.add(rules.getLocations().get(0));
        path.add(locations.get(i));
        for (int j = 0; j < locations.get(i).getPackets().size(); j++) {
            if (locations.get(i).getPackets().get(j).getWeight() > maxWeight) {
                throw new Error("Some packet weights more than what the car can carry");
            }
            weightBetween += locations.get(i).getPackets().get(j).getWeight();
            if (weightBetween > maxWeight) {
                path.add(rules.getLocations().get(0));
                path.add(locations.get(i));
                weightBetween = locations.get(i).getPackets().get(j).getWeight();
            }
        }
        weight = weightBetween;
        return weight;
    }

    /**
     * Calculates difference from the parents. Difference is calculated by checking the locations in the same positions in the DNA in all 3 DNAs and summing the distance from parents' locations to the child DNA. The bigger the difference, the better.
     * @param daddy Daddy DNA, if null, the daddy from the constructor is used.
     * @param mommy Mommy DNA, if null, the mommy from the constructor is used.
     * @return returns the difference, this method also caches the value.
     */
    public int calculateDifference(DNA daddy, DNA mommy) {
        if (daddy == null || mommy == null) {
            daddy = this.daddy;
            mommy = this.mommy;
        }
        double answer = 0;
        for (int i = 0; i < runningOrder.size(); i++) {
            if (daddy != null) {
                for (int j = 0; j < Math.min(runningOrder.get(i).size(), daddy.runningOrder.get(i).size()); j++) {
                    answer += runningOrder.get(i).get(j).distance(daddy.runningOrder.get(i).get(j));
                }
            }

        }

        for (int i = 0; i < runningOrder.size(); i++) {
            if (mommy != null) {
                for (int j = 0; j < Math.min(runningOrder.get(i).size(), mommy.runningOrder.get(i).size()); j++) {
                    answer += runningOrder.get(i).get(j).distance(mommy.runningOrder.get(i).get(j));
                }
            }

        }
        difference = (int) answer;
        return (int) answer;
    }

    /**
     *
     * @return
     */
    public int calculateScore() {
        if (fitness == Integer.MAX_VALUE) {
            calculateFitness();
        }
        if (difference == Integer.MAX_VALUE) {
            calculateDifference(daddy, mommy);
        }

//        Magic formulas incoming:
        double fitDis = rules.getFitDis();
        double difDis = rules.getDifDis() * differenceImportance;
        double fit = fitness;
        double dif = difference;
        if (difDis < 1) {
            score = (int) fit;
            return (int) fit;
        }
        double fitProj = 0;
        double difProj = 0;

        difProj = (difDis * (fitDis * (fitDis - fit) + dif * difDis)) / (difDis * difDis + fitDis * fitDis);
        fitProj = (fitDis * (difDis * fitDis * (fit - fitDis) - dif * difDis * difDis + difDis * difDis * difDis + fitDis * fitDis * difProj)) / (difDis * difDis * difDis);

        int answer = (int) Math.sqrt(Math.pow(fitProj, 2) + Math.pow(difDis - difProj, 2));
        score = answer;
        return answer;
    }

    /**
     * returns the DNA's fitness. If fitness isn't yet cached, it will calculate it first.
     * @return the fitness.
     */
    public int getFitness() {
        if (fitness == Integer.MAX_VALUE) {
            calculateFitness();
        }
        return fitness;
    }

    /**
     * returns the DNA's diference. If difference isn't yet cached, it will calculate it first.
     * @return the difference.
     */
    public int getDifference() {
        if (difference == Integer.MAX_VALUE) {
            calculateDifference(daddy, mommy);
        }
        return difference;
    }

    /**
     * returns the DNA's score. If score isn't yet cached, it will calculate it first.
     * @return the score
     */
    public int getScore() {
        if (score == Integer.MAX_VALUE) {
            calculateScore();
        }
        return score;
    }

    private double getPathDistance(TLArrayList<Location> path) {
        double answer = 0;
        for (int i = 1; i < path.size(); i++) {
            answer += path.get(i).distance(path.get(i - 1));
        }
        return answer;
    }

    @Override
    public int compareTo(DNA o) {

        if (this.getScore() == o.getScore()) {
            return 0;
        }

        if (this.getScore() > o.getScore()) {
            return 1;
        } else {
            return -1;
        }
    }

    public double getDifferenceImportance() {
        return differenceImportance;
    }

    public void setDifferenceImportance(double differenceImportance) {
        this.differenceImportance = differenceImportance;
    }

    /**
     * Returns the DNA's solution, aka the order where the locations are visited.
     * @return Returns the runningOrder. Every list in this list contains locations that a car visits.
     */
    public TLArrayList<TLArrayList<Location>> getRunningOrder() {
        return runningOrder;
    }

    /**
     * Returns the paths calculated from the runningOrder. The path will be calculated at the same time as fitness.
     * @return
     */
    public TLArrayList<TLArrayList<Location>> getPaths() {
        if (fitness == Integer.MAX_VALUE) {
            calculateFitness();
        }
        return paths;
    }

}
