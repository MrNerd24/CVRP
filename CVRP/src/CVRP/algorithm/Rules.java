package CVRP.algorithm;

import CVRP.objects.Car;
import CVRP.objects.Location;
import CVRP.objects.Packet;
import CVRP.utils.TLArrayList;

/**
 * This class lists all the locations, cars and packets that are being used in the algorithm. It also has other settings.
 * @author Juuso
 */
public class Rules {

    private TLArrayList<Car> cars;
    private TLArrayList<Location> locations;
    private int difDis;
    private int fitDis;
    private int mutations;
    private double difDec;

    /**
     * Creates new rules. Contains the objects and rules that the algorithm then tries to solve upon. These should be defined by the user.
     * @param difDis Defines the sweetspot for the difference in the scoring. Bigger difDis means more emphasis on the difference in the first generations.
     * @param fitDis The relation between difDis and Fitdis defines how much the algorithm tries to favour the one over the other. Bigger fitDis means more emphasis on the fitness in the first generations.
     * @param mutations Defines the max amount mutations in a dna.
     * @param difDec Defines how much the importance of the difference in the first generations decreases over the generations. Must be between 1 and 0, where number near 1 means very little decrease.
     */
    public Rules(int difDis, int fitDis, int mutations, double difDec, int X0, int Y0) {
        this.difDis = difDis;
        this.fitDis = fitDis;
        this.mutations = mutations;
        this.difDec = difDec;
        cars = new TLArrayList<>();
        locations = new TLArrayList<>();
        locations.add(new Location(0, X0, Y0));
    }

    /**
     * 
     * @return Returns the cars used in the problem.
     */
    public TLArrayList<Car> getCars() {
        return cars;
    }


    /**
     *
     * @return returns the locations used in the problem. Every location has a list of packets that are to be delivered there.
     */
    public TLArrayList<Location> getLocations() {
        return locations;
    }


    public int getDifDis() {
        return difDis;
    }

    public void setDifDis(int difDis) {
        this.difDis = difDis;
    }

    public int getFitDis() {
        return fitDis;
    }

    public void setFitDis(int fitDis) {
        this.fitDis = fitDis;
    }

    public int getMutations() {
        return mutations;
    }

    public void setMutations(int mutations) {
        this.mutations = mutations;
    }

    public double getDifDec() {
        return difDec;
    }

    public void setDifDec(double difDec) {
        this.difDec = difDec;
    }
    
    

}
