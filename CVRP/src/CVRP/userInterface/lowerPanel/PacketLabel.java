package CVRP.userInterface.lowerPanel;

import CVRP.objects.Packet;
import CVRP.userInterface.listeners.PacketListener;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PacketLabel extends JPanel {

    private JTextField weightEdit;
    private JTextField nameEdit;
    private Packet pac;
    private boolean displayed = true;

    public PacketLabel(Packet pac) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.pac = pac;
        nameEdit = new JTextField(pac.getName());
        weightEdit = new JTextField(String.valueOf(pac.getWeight()));
    }

    public void createContents() {
        display();
    }

    public void click() {
        String newName = nameEdit.getText();
        int newWeight = Integer.parseInt(weightEdit.getText());

        pac.setName(newName);
        pac.setWeight(newWeight);

        if (displayed) {
            displayed = false;
            edit();
        } else {
            displayed = true;
            display();
        }
        
    }

    public void edit() {
        displayed = false;
        this.removeAll();
        
        Font title = new Font(Font.SANS_SERIF, Font.BOLD, 16);
        Font sub = new Font(Font.SANS_SERIF, Font.PLAIN, 16);

        
        nameEdit.setFont(title);
        nameEdit.addActionListener(new PacketListener(this));
        this.add(nameEdit);

        weightEdit.setFont(sub);
        weightEdit.addActionListener(new PacketListener(this));
        this.add(weightEdit);
        
        this.revalidate();
        this.repaint();
    }

    public void display() {
        displayed = true;
        this.removeAll();
        
        Font title = new Font(Font.SANS_SERIF, Font.BOLD, 16);
        Font sub = new Font(Font.SANS_SERIF, Font.PLAIN, 16);

        JLabel pacName = new JLabel(pac.getName());
        pacName.setFont(title);
        this.add(pacName);

        JLabel pacWeight = new JLabel("  Weight: " + pac.getWeight());
        pacWeight.setFont(sub);
        this.add(pacWeight);

        this.revalidate();
        this.repaint();
    }

}
