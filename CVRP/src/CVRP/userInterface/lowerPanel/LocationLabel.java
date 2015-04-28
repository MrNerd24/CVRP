package CVRP.userInterface.lowerPanel;

import CVRP.algorithm.Rules;
import CVRP.objects.Location;
import CVRP.objects.Packet;
import CVRP.userInterface.MainPanel;
import CVRP.userInterface.listeners.LocationListener;
import CVRP.userInterface.listeners.newLocationListener;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LocationLabel extends JPanel {

    private boolean displayed;
    private Location loc;
    private JTextField nameEdit;
    private PacketLabel[] packets;
    private JTextField xEdit;
    private JTextField yEdit;

    public LocationLabel(Location loc) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.loc = loc;
        displayed = true;

        nameEdit = new JTextField(loc.getName());
        xEdit = new JTextField(String.valueOf(loc.getX()));
        yEdit = new JTextField(String.valueOf(loc.getY()));
    }

    public void click() {
        String newName = nameEdit.getText();
        int newX = Integer.parseInt(xEdit.getText());
        int newY = Integer.parseInt(yEdit.getText());

        loc.setName(newName);
        loc.setX(newX);
        loc.setY(newY);

        if (displayed) {
            displayed = false;
            edit();
        } else {
            displayed = true;
            display();
        }

        for (PacketLabel packetLabel : packets) {
            if (displayed) {
                packetLabel.display();
            } else {
                packetLabel.edit();
            }
        }
        if (displayed) {
            MainPanel main = findMain();
            main.resetSolver();
            main.updateLower();
        }
        this.revalidate();
        this.repaint();
    }

    public void createContents() {
        display();
    }

    private void display() {
        this.removeAll();

        Font title = new Font(Font.SANS_SERIF, Font.BOLD, 16);
        Font sub = new Font(Font.SANS_SERIF, Font.PLAIN, 16);

        JLabel locName = new JLabel(loc.getName());
        locName.setFont(title);
        this.add(locName);

        JLabel x = new JLabel("  x: " + loc.getX());
        x.setFont(sub);
        this.add(x);

        JLabel y = new JLabel("  y: " + loc.getY());
        y.setFont(sub);
        this.add(y);

        addPackets();

        JButton editButton = new JButton("Edit");
        editButton.addActionListener(new LocationListener(this));
        this.add(editButton);

    }

    private void addPackets() {
        this.add(Box.createVerticalStrut(15));
        packets = new PacketLabel[loc.getPackets().size()];
        for (int i = 0; i < packets.length; i++) {
            Packet pac = loc.getPackets().get(i);
            PacketLabel label = new PacketLabel(pac);
            label.createContents();
            packets[i] = label;
            this.add(label);
            this.add(Box.createVerticalStrut(10));
        }
        if (!displayed) {
            JButton button = new JButton("New Packet");
            button.addActionListener(new newPacketListener(loc, (LocationList) this.getParent()));
            this.add(button);
        }
    }

    private void edit() {
        this.removeAll();

        Font title = new Font(Font.SANS_SERIF, Font.BOLD, 16);
        Font sub = new Font(Font.SANS_SERIF, Font.PLAIN, 16);

        nameEdit.setMaximumSize(new Dimension(this.getParent().getWidth(), 30));
        nameEdit.setFont(title);
        nameEdit.addActionListener(new LocationListener(this));
        this.add(nameEdit);

        xEdit.setMaximumSize(new Dimension(this.getParent().getWidth(), 30));
        xEdit.setFont(sub);
        xEdit.addActionListener(new LocationListener(this));
        this.add(xEdit);

        yEdit.setMaximumSize(new Dimension(this.getParent().getWidth(), 30));
        yEdit.setFont(sub);
        yEdit.addActionListener(new LocationListener(this));
        this.add(yEdit);

        addPackets();

    }
    
    private MainPanel findMain() {
        Component parent = this.getParent();
        while (!parent.getClass().equals(MainPanel.class)) {
            parent = parent.getParent();
        }
        return (MainPanel) parent;
    }

}
