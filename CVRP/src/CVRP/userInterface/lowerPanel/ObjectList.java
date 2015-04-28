package CVRP.userInterface.lowerPanel;

import CVRP.algorithm.Rules;
import CVRP.userInterface.UIAPanel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollPane;

public class ObjectList extends UIAPanel {
    
    public Rules rules;
    ScrollView view;
    JScrollPane scroll;
    
    public ObjectList(int width, int height, int left, int top, Rules rules) {
        super(width, height, left, top);
        this.rules = rules;
    }
    
    @Override
    public void createContents() {
        view = new ScrollView(width, 0, 10, 0, rules);
        view.createContents();
        view.setParentPanel(this);
        view.setBorder(null);
        
        scroll = new JScrollPane(view);
        scroll.setBounds(0, 0, width, height);
        scroll.setBorder(null);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        
        this.add(scroll);
    }
    
    @Override
    public void updateChildren() {  
        scroll.setBounds(0, 0, width, height);
        view.changeSize(width, 30);
    }

    void updateContents() {
        view.rules = rules;
        view.updateContents();
    }

    
}
