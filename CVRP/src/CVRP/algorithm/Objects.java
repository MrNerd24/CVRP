package CVRP.algorithm;

import CVRP.objects.Car;
import CVRP.objects.Location;
import CVRP.objects.Packet;
import CVRP.utils.TLArrayList;

public class Objects {
    private TLArrayList<Packet> packets;
    private TLArrayList<Car> cars;
    private TLArrayList<Location> locations;

    public Objects() {
        packets = new TLArrayList<>();
        cars = new TLArrayList<>();
        locations = new TLArrayList<>();
    }

    public TLArrayList<Packet> getPackets() {
        return packets;
    }

    public void setPackets(TLArrayList<Packet> packets) {
        this.packets = packets;
    }

    public TLArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(TLArrayList<Car> cars) {
        this.cars = cars;
    }

    public TLArrayList<Location> getLocations() {
        return locations;
    }

    public void setLocations(TLArrayList<Location> locations) {
        this.locations = locations;
    }
    
}
