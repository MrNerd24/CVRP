package CVRP.objects;

/**
 * This class contains information of a packet.
 * @author Juuso
 */
public class Packet {
    private int id;
    private int weight;

    /**
     * Creates a new packet
     * @param id Packet id
     * @param weight packet's weight.
     */
    public Packet(int id, int weight) {
        this.id = id;
        this.weight = weight;
    }
    
     public Packet(String constructorString) {
        String[] values = constructorString.split("£");
        this.id = Integer.parseInt(values[1]);
        this.weight = Integer.parseInt(values[2]);
     }

    public int getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    public String getConstructorString() {
        return "£" + this.id + "£" + this.weight;
    }

    
}
