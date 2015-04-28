package CVRP.objects;

/**
 * This class contains information of a packet.
 * @author Juuso
 */
public class Packet {
    private int id;
    private int weight;
    private String name;

    /**
     * Creates a new packet
     * @param id Packet id
     * @param weight packet's weight.
     */
    public Packet(int id, int weight) {
        this.id = id;
        this.weight = weight;
        this.name = "Packet" + id;
    }
    
     public Packet(String constructorString) {
        String[] values = constructorString.split("£");
        this.name = values[1];
        this.id = Integer.parseInt(values[2]);
        this.weight = Integer.parseInt(values[3]);
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
        return "£" + this.name + "£" + this.id + "£" + this.weight;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getName() {
        return name;
    }

    
}
