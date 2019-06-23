package controller;

import model.Circuit;
import model.Connector;
import model.Gate;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ConnectAction extends JPanel implements MouseListener, MouseMotionListener {

    private Circuit circuit;
    private Gate output;
    private int outputID;

    public ConnectAction(Circuit circuit) {
        this.circuit = circuit;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        /*if (SwingUtilities.isLeftMouseButton(e)) {
            Gate tmpOutput = this.circuit.findOutputAt(e.getX(), e.getY());
            if (tmpOutput != null) {
                this.output = tmpOutput;
                this.outputID = this.output.findOutputID(e.getX(), e.getY());
                this.output.setSelected(true);
            } else {
                if (this.output != null) {
                    Gate input = this.circuit.findInputAt(e.getX(), e.getY());
                    if (input != null) {
                        int inputID = input.findInputID(e.getX(), e.getY());
                        this.output.connectFromComplete(input, this.outputID, inputID);
                    } else {
                        this.output.setSelected(false);
                        this.output = null;
                    }
                }
            }
        }*/
        this.circuit.update();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
