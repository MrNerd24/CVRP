package CVRP.userInterface.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import CVRP.userInterface.lowerPanel.PacketLabel;

/**
 * Listener for packet editing
 * @author Juuso
 */
public class PacketListener implements ActionListener {

    PacketLabel packet;

    /**
     *
     * @param packet Packetlable to be edited
     */
    public PacketListener(PacketLabel packet) {
        this.packet = packet;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        packet.click();
    }

}
