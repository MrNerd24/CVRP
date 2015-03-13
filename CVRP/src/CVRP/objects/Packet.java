package CVRP.objects;

public class Packet {
    private int id;
    private int weight;
    private Location destination;

    public Packet(int id, int weight, Location destination) {
        this.id = id;
        this.weight = weight;
        this.destination = destination;
    }

    public int getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }

    public Location getDestination() {
        return destination;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }
    
}
