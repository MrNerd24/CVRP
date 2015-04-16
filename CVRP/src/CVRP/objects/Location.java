package CVRP.objects;

import CVRP.utils.TLArrayList;
import java.util.Objects;

/**
 * This class holds a location used in the problem. There is also a list of packets that are for this location.
 * @author Juuso
 */
public class Location {
    private int id;
    private int x;
    private int y;
    private TLArrayList<Packet> packets;
    private String name;

    /**
     * Creates a new location.
     * @param id Location id.
     * @param x X coordinate.
     * @param y Y coordinate.
     */
    public Location(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.name = "Location" + id;
        packets = new TLArrayList<>();
    }
    
    public Location(String constructorString) {
        String[] values = constructorString.split("§");
        this.name = values[1];
        this.id = Integer.parseInt(values[2]);
        this.x = Integer.parseInt(values[3]);
        this.y = Integer.parseInt(values[4]);
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

    /**
     * Returns the list of packets that should be delivered to this location.
     * @return Returns list of packets.
     */
    public TLArrayList<Packet> getPackets() {
        return packets;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    /**
     * Calculates the distance between this and some other location.
     * @param o The other location.
     * @return The distance between the locations.
     */
    public double distance(Location o) {
        if (o == null) {
            throw new IllegalArgumentException("the other location was null.");
        }
        return Math.sqrt(Math.pow(this.x - o.x, 2) + Math.pow(this.y - o.y, 2));
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.id;
        hash = 19 * hash + this.x;
        hash = 19 * hash + this.y;
        hash = 19 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Location other = (Location) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }


    
    public String getConstructorString() {
        return "§" + name + "§" + id + "§" + x + "§" + y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

    
}
