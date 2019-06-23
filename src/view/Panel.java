package view;

import model.Circuit;
import model.Connector;
import model.Gate;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Panel extends JPanel implements Observer {

    private Circuit circuit;

    public static final int DEFAULT_GATE_WIDTH = 100;
    public static final int DEFAULT_GATE_HEIGHT = 100;
    public static final int DEFAULT_CONNECT_RADIUS = 15;

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
        for (Gate gate1 : this.circuit.getCircuit()) {
            if (gate1.evaluate()) {
                g.setColor(new Color(255, 255, 255));
            } else {
                g.setColor(new Color(0, 0, 0));
            }
            for (int i = 0; i < gate1.getInputs().size(); i++) {
                Gate gate2 = gate1.getInputs().get(i);
                if (gate2 != null) {
                    //get the index of the connector of gate2 which is connected to gate1
                    int connectorID = 0;
                    for (Connector connector : gate2.getOutputs())
                        if (connector.isConnectedTo(gate1))
                            connectorID = gate2.getOutputs().indexOf(connector);
                    //draw that connection
                    g.drawLine(gate1.getX()
                            , gate1.getY() + (i + 1) * DEFAULT_GATE_HEIGHT / (gate1.getInputs().size() + 1)
                            , gate2.getX() + DEFAULT_GATE_WIDTH
                            , gate2.getY() + (connectorID + 1) * DEFAULT_GATE_HEIGHT / (gate2.getOutputs().size() + 1)
                    );
                }
            }
        }
    }

    /**
     * paints the connectors of the node
     * @param g
     */
    private void paintConnectors(Graphics g) {
        for (Gate gate : this.circuit.getCircuit()) {
            g.setColor(new Color(70, 171, 67));
            for (int i=0; i<gate.getInputs().size(); i++)
                g.fillOval(gate.getX() - DEFAULT_CONNECT_RADIUS/2
                        , (i+1)*DEFAULT_GATE_HEIGHT/(gate.getInputs().size()+1) + gate.getY() - DEFAULT_CONNECT_RADIUS/2
                        , DEFAULT_CONNECT_RADIUS
                        , DEFAULT_CONNECT_RADIUS);
            for (int i=0; i<gate.getOutputs().size(); i++) {
                if (gate.getSelected() && gate.getSelectedID() == i) {
                    g.setColor(new Color(241, 8, 103));
                } else {
                    g.setColor(new Color(171, 83, 83));
                }
                g.fillOval(gate.getX() + DEFAULT_GATE_WIDTH - DEFAULT_CONNECT_RADIUS / 2
                        , (i + 1) * DEFAULT_GATE_HEIGHT / (gate.getOutputs().size() + 1) + gate.getY() - DEFAULT_CONNECT_RADIUS / 2
                        , DEFAULT_CONNECT_RADIUS
                        , DEFAULT_CONNECT_RADIUS);
            }
        }
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
        }
    }

    /**
     * paint all components
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintGates(g);
        paintConnectors(g);
        paintConnections(g);
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
