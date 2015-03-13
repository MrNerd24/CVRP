package CVRP.objects;

import CVRP.utils.TLArrayList;

public class Car {
    private int id;
    private int maxWeight;
    private TLArrayList<Packet> packets = new TLArrayList<>();

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

    public TLArrayList<Packet> getPackets() {
        return packets;
    }
    
    
}
