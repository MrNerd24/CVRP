package CVRP.userInterface.lowerPanel;

import CVRP.objects.Location;
import CVRP.objects.Packet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class newPacketListener implements ActionListener {

    Location loc;
    LocationList list;

    public newPacketListener(Location loc, LocationList list) {
        this.loc = loc;
        this.list = list;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        loc.getPackets().add(new Packet(getUnusedId(), 5));
        list.updateContents();
    }

    public int getUnusedId() {
        boolean[] used = new boolean[10000];
        for (int i = 0; i < loc.getPackets().size(); i++) {
            used[loc.getPackets().get(i).getId()] = true;
        }
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                return i;
            }
        }
        return -1;
    }

}
