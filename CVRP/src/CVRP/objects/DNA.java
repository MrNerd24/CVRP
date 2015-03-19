package CVRP.objects;

import CVRP.algorithm.Objects;
import CVRP.utils.TLArrayList;
import CVRP.utils.TLRandom;

public class DNA {

    private Objects objects;
    private TLArrayList<TLArrayList<Location>> runningOrder;
    private boolean loadingOrder = true;
    private TLArrayList<TLArrayList<Location>> paths;

    public DNA(boolean random, Objects objects) {
        this.objects = objects;
        runningOrder = new TLArrayList<>();
        paths = new TLArrayList<>();
        if (random) {
            createRandomDNA();
        } else {
            createEmptyDNA();
        }

    }

    private void createRandomDNA() {
        TLRandom random = new TLRandom();
        for (int i = 0; i < objects.getLocations().size(); i++) {
            Location location = objects.getLocations().get(i);
            int carIndex = random.nextInt(objects.getCars().size());
            if (runningOrder.get(carIndex) == null) {
                runningOrder.set(carIndex, new TLArrayList<>());
            }
            runningOrder.get(carIndex).add(location);
        }
        random.saveSeed();
    }

    private void createEmptyDNA() {
        for (int i = 0; i < objects.getCars().size(); i++) {
            runningOrder.add(new TLArrayList<>());
        }
    }

    public void mutate(int maxAmount) {
        TLRandom random = new TLRandom();
        int mutations = random.nextInt(maxAmount);
        for (int i = 0; i < mutations; i++) {
            int type = random.nextInt(20);
            if (type < 10) {
                swapInARoute(random);
            } else {
                swapBetweenRoutes(random);
            }
        }
        random.saveSeed();
    }

    private void swapBetweenRoutes(TLRandom random) {
        int randomCar1 = random.nextInt(objects.getCars().size());
        int randomCar2 = random.nextInt(objects.getCars().size());
        while (randomCar1 == randomCar2) {
            randomCar2 = random.nextInt(objects.getCars().size());
        }
        int randomLocation = random.nextInt(runningOrder.get(randomCar1).size());
        Location holder = runningOrder.get(randomCar1).remove(randomLocation);
        runningOrder.get(randomCar2).add(holder);
    }

    private void swapInARoute(TLRandom random) {
        int randomCar = random.nextInt(objects.getCars().size());
        int swapIndex1 = random.nextInt(runningOrder.get(randomCar).size());
        int swapIndex2 = random.nextInt(runningOrder.get(randomCar).size());
        while (swapIndex1 == swapIndex2) {
            swapIndex2 = random.nextInt(runningOrder.get(randomCar).size());
        }
        Location holder = runningOrder.get(randomCar).get(swapIndex1);
        runningOrder.get(randomCar).set(swapIndex1, runningOrder.get(randomCar).get(swapIndex2));
        runningOrder.get(randomCar).set(swapIndex2, holder);
    }

    public int getFitness() {
        int answer = 0;
        for (int i = 0; i < objects.getCars().size(); i++) {
            Car car = objects.getCars().get(i);
            int maxWeight = car.getMaxWeight();
            TLArrayList<Location> locations = runningOrder.get(i);
            TLArrayList<Location> path = makePath(locations, maxWeight);
            paths.add(path);
            answer += getPathDistance(path);
        }
        return answer;
    }

    private TLArrayList<Location> makePath(TLArrayList<Location> locations, int maxWeight) {
        TLArrayList<Location> path = new TLArrayList<Location>();
        path.add(objects.getLocations().get(0));
        int weight = 0;
        for (int j = 1; j < locations.size(); j++) {
            int newWeight = weight;
            for (int k = 0; k < locations.get(j).getPackets().size(); k++) {
                newWeight += locations.get(j).getPackets().get(k).getWeight();
            }
            if (weight < maxWeight && newWeight > maxWeight) {
                weight = newWeight;
                path.add(locations.get(j));
                path.add(locations.get(0));
            } else {
                weight += newWeight;
                path.add(locations.get(j));
            }
        }
        return path;
    }

    public int getDifference(DNA daddy, DNA mommy) {
        throw new UnsupportedOperationException();
    }

    public int getScore() {
        throw new UnsupportedOperationException();
    }
    
    private int getPathDistance(TLArrayList<Location> path) {
        int answer = 0;
        for (int i = 1; i < path.size(); i++) {
            answer += path.get(i).distance(path.get(i-1));
        }
        return answer;
    }
    
    public DNA crossOver(DNA other) {
        
        
        
        return null;
    }
}
