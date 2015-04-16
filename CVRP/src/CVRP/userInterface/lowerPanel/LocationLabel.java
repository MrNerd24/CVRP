package CVRP.userInterface.lowerPanel;

import CVRP.objects.Car;
import CVRP.objects.Location;
import CVRP.objects.Packet;
import CVRP.userInterface.UIPanel;
import CVRP.userInterface.listeners.CarListener;
import CVRP.userInterface.listeners.LocationListener;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LocationLabel extends UIPanel {

    private boolean displayed;
    private Location loc;
    private JTextField nameEdit;
    private PacketLabel[] packets;
    private JTextField xEdit;
    private JTextField yEdit;

    public LocationLabel(int width, int height, int left, int top, Location loc) {
        super(width, height, left, top);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.loc = loc;
        displayed = true;
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
    }

    @Override
    public void createContents() {
        display();
    }

    private void display() {
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

        this.revalidate();
        this.repaint();
    }

    private void addPackets() {
        packets = new PacketLabel[loc.getPackets().size()];
        for (int i = 0; i < packets.length; i++) {
            Packet pac = loc.getPackets().get(i);
            PacketLabel label = new PacketLabel(width, 80, 0, 80 * i, pac);
            label.setParentPanel(this);
            label.createContents();
            packets[i] = label;
            this.add(label);
        }
    }

    private void edit() {
        this.removeAll();

        Font title = new Font(Font.SANS_SERIF, Font.BOLD, 16);
        Font sub = new Font(Font.SANS_SERIF, Font.PLAIN, 16);

        nameEdit.setFont(title);
        nameEdit.addActionListener(new LocationListener(this));
        this.add(nameEdit);

        xEdit.setFont(sub);
        xEdit.addActionListener(new LocationListener(this));
        this.add(xEdit);

        yEdit.setFont(sub);
        yEdit.addActionListener(new LocationListener(this));
        this.add(yEdit);

        this.revalidate();
        this.repaint();
    }

    @Override
    public void updateChildren() {
    }

}
