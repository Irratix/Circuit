package view;

import model.Circuit;
import model.Connector;
import model.Gate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

public class Panel extends JPanel implements Observer, MouseMotionListener {

    private Circuit circuit;
    private int mouseX;
    private int mouseY;

    public static final int DEFAULT_GATE_WIDTH = 64;
    public static final int DEFAULT_GATE_HEIGHT = 64;
    public static final int DEFAULT_CONNECT_RADIUS = 12;

    public Panel(Circuit circuit) {
        this.circuit = circuit;
        circuit.addObserver(this);
        setBackground(new Color(43, 46, 53));
        setVisible(true);
        setOpaque(true);

        this.mouseX = 0;
        this.mouseY = 0;
    }

    /**
     * paints connections between nodes
     * @param g
     */
    private void paintConnections(Graphics g) {
        for (Gate gate1 : this.circuit.getCircuit()) {

            for (int i = 0; i < gate1.getInputs().size(); i++) {
                Gate gate2 = gate1.getInputs().get(i);
                if (gate2 != null) {
                    if (gate2.evaluate()) {
                        g.setColor(new Color(255, 255, 255));
                    } else {
                        g.setColor(new Color(80, 80, 80));
                    }
                    //get the index of the connector of gate2 which is connected to gate1
                    int connectorID = 0;
                    for (Connector connector : gate2.getOutputs()) {
                        if (connector.isConnectedTo(gate1))
                            connectorID = gate2.getOutputs().indexOf(connector);
                    }

                    Graphics2D g2 = (Graphics2D) g;
                    g2.setStroke(new BasicStroke(2));

                    int connectorBX = gate1.getX();
                    int connectorBY = gate1.getY() + (i + 1) * DEFAULT_GATE_HEIGHT / (gate1.getInputs().size() + 1);
                    int connectorAX = gate2.getX() + DEFAULT_GATE_WIDTH;
                    int connectorAY = gate2.getY() + (connectorID + 1) * DEFAULT_GATE_HEIGHT / (gate2.getOutputs().size() + 1);

                    if (Math.abs(connectorAX-connectorBX) >= Math.abs(connectorAY-connectorBY)) {
                        //horizontal distance is greater
                        if (connectorBX < connectorAX) {
                            //connector B is to the left
                            g.drawLine(connectorAX
                                    , connectorAY
                                    , connectorAX-Math.abs(connectorAY-connectorBY)
                                    , connectorBY
                            );
                            g.drawLine(connectorAX-Math.abs(connectorAY-connectorBY)
                                    , connectorBY
                                    , connectorBX
                                    , connectorBY
                            );
                        } else {
                            //connector B is to the right
                            g.drawLine(connectorAX
                                    , connectorAY
                                    , connectorAX+Math.abs(connectorAY-connectorBY)
                                    , connectorBY
                            );
                            g.drawLine(connectorAX+Math.abs(connectorAY-connectorBY)
                                    , connectorBY
                                    , connectorBX
                                    , connectorBY
                            );
                        }
                    } else {
                        //vertical distance is greater
                        if (connectorBY < connectorAY) {
                            //connector B is above
                            g.drawLine(connectorAX
                                    , connectorAY
                                    , connectorAX
                                    , connectorBY+Math.abs(connectorAX-connectorBX)
                            );
                            g.drawLine(connectorAX
                                    , connectorBY+Math.abs(connectorAX-connectorBX)
                                    , connectorBX
                                    , connectorBY
                            );
                        } else {
                            //connector B is below
                            g.drawLine(connectorAX
                                    , connectorAY
                                    , connectorAX
                                    , connectorBY-Math.abs(connectorAX-connectorBX)
                            );
                            g.drawLine(connectorAX
                                    , connectorBY-Math.abs(connectorAX-connectorBX)
                                    , connectorBX
                                    , connectorBY
                            );
                        }
                    }
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
            // INPUTS
            for (int i=0; i<gate.getInputs().size(); i++)
                g.fillOval(gate.getX() - DEFAULT_CONNECT_RADIUS/2
                        , (i+1)*DEFAULT_GATE_HEIGHT/(gate.getInputs().size()+1) + gate.getY() - DEFAULT_CONNECT_RADIUS/2
                        , DEFAULT_CONNECT_RADIUS
                        , DEFAULT_CONNECT_RADIUS);

            // OUTPUTS
            for (int i=0; i<gate.getOutputs().size(); i++) {
                if (gate.isFocused() && gate.getSelectedConnector() == i) {
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
            BufferedImage img = GetGateTexture.getTexture(gate);
            //if the gate evaluates to false, change the color of the gate
            if (gate.isSelected()) {
                GetGateTexture.makeRed(img);
                //);
            } else if (!gate.evaluate()) {
                GetGateTexture.makeDarker(img);
            }
            g.drawImage(img
                    , gate.getX()
                    , gate.getY()
                    , DEFAULT_GATE_WIDTH
                    , DEFAULT_GATE_HEIGHT
                    , this);
            if (gate.evaluate()) {
                img = GetGateTexture.getGlowTexture(gate);
                if (gate.isSelected())
                    GetGateTexture.makeRed(img);
                g.drawImage(img
                        , gate.getX() - DEFAULT_GATE_WIDTH/2
                        , gate.getY() - DEFAULT_GATE_HEIGHT/2
                        , DEFAULT_GATE_WIDTH*2
                        , DEFAULT_GATE_HEIGHT*2
                        , this);
            }
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
        paintConnections(g);
        paintConnectors(g);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //TODO
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.mouseX = e.getX();
        this.mouseY = e.getY();
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
