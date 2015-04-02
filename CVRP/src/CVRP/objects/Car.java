package CVRP.objects;

import CVRP.utils.TLArrayList;

/**
 * Class tha holds information of a car.
 * @author Juuso
 */
public class Car {
    private int id;
    private int maxWeight;

    /**
     * Creates a new car.
     * @param id Car's id
     * @param maxWeight The max weight this car can carry.
     */
    public Car(int id, int maxWeight) {
        this.id = id;
        this.maxWeight = maxWeight;
    }

    public int getId() {
        return id;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }
    
    
    
}
