package CVRP.objects;

import CVRP.utils.TLArrayList;

/**
 * Class tha holds information of a car.
 *
 * @author Juuso
 */
public class Car {

    private int id;
    private int maxWeight;
    private int pathDis;
    private String name;

    /**
     * Creates a new car.
     *
     * @param id Car's id
     * @param maxWeight The max weight this car can carry.
     */
    public Car(int id, int maxWeight) {
        this.id = id;
        this.maxWeight = maxWeight;
        this.name = "Car" + id;
    }

    public Car(String constructorString) {
        String[] values = constructorString.split("$");
        this.name = values[1];
        this.id = Integer.parseInt(values[2]);
        this.maxWeight = Integer.parseInt(values[3]);
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

    public int getPathDis() {
        return pathDis;
    }

    public void setPathDis(int pathDis) {
        this.pathDis = pathDis;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getConstructorString() {
        return "$" + name + "$" + this.id + "$" + this.maxWeight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
