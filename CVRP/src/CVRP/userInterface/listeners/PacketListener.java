package CVRP.userInterface.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import CVRP.userInterface.lowerPanel.PacketLabel;

public class PacketListener implements ActionListener {

    PacketLabel packet;

    public PacketListener(PacketLabel packet) {
        this.packet = packet;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        packet.click();
    }

}
