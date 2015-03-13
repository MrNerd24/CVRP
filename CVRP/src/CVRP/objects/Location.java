package CVRP.objects;

import CVRP.utils.TLArrayList;

public class Location {
    private int id;
    private int x;
    private int y;
    private TLArrayList<Packet> packets;

    public Location(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
        packets = new TLArrayList<>();
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public TLArrayList<Packet> getPackets() {
        return packets;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public double distance(Location o) {
        return Math.sqrt(Math.pow(this.x - o.x, 2) + Math.pow(this.y - o.y, 2));
        
    }

    
}
