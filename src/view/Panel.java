package view;

import model.Circuit;
import model.Gate;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Panel extends JPanel implements Observer {

    private Circuit circuit;

    private static final int DEFAULT_GATE_WIDTH = 100;
    private static final int DEFAULT_GATE_HEIGHT = 50;
    private static final int DEFAULT_CONNECT_RADIUS = 15;

    public Panel(Circuit circuit) {
        this.circuit = circuit;
        circuit.addObserver(this);
        setBackground(new Color(43, 46, 53));
        setVisible(true);
        setOpaque(true);
    }

    /**
     * paints connections between nodes
     * @param g
     */
    private void paintConnections(Graphics g) {
        g.setColor(new Color(0, 0, 0));
        for (Gate gate1 : this.circuit.getCircuit())
            for (Gate gate2 : gate1.getInputs())
                if (gate2 != null)
                    g.drawLine(gate1.getX()
                            , gate1.getY()
                            , gate2.getX()
                            , gate2.getY()
                    );
    }

    /**
     * paint all gates on a circuit
     * @param g
     */
    private void paintGates(Graphics g) {
        for (Gate gate : this.circuit.getCircuit()) {
            g.setColor(new Color(255, 255, 255));
            g.fillRect(gate.getX()
                , gate.getY()
                , DEFAULT_GATE_WIDTH
                , DEFAULT_GATE_HEIGHT);
            g.setColor(new Color(70, 171, 67));
            for (int i=0; i<gate.getInputs().size(); i++)
                g.fillOval(gate.getX() - DEFAULT_CONNECT_RADIUS/2
                        , (i+1)*DEFAULT_GATE_HEIGHT/(gate.getInputs().size()+1) + gate.getY() - DEFAULT_CONNECT_RADIUS/2
                        , DEFAULT_CONNECT_RADIUS
                        , DEFAULT_CONNECT_RADIUS);
            g.setColor(new Color(171, 83, 83));
            for (int i=0; i<gate.getOutputs().size(); i++)
                g.fillOval(gate.getX() + DEFAULT_GATE_WIDTH - DEFAULT_CONNECT_RADIUS/2
                        , (i+1)*DEFAULT_GATE_HEIGHT/(gate.getOutputs().size()+1) + gate.getY() - DEFAULT_CONNECT_RADIUS/2
                        , DEFAULT_CONNECT_RADIUS
                        , DEFAULT_CONNECT_RADIUS);
        }
    }

    /**
     * paint all components
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintConnections(g);
        paintGates(g);
    }

    /**
     * Tell the panel that any object it displays has changed
     * @param o
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
}
