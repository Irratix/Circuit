package controller;

import model.Circuit;
import model.Gate;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GateDragger extends JPanel implements MouseListener, MouseMotionListener {

    private Circuit circuit;
    private Gate gate;

    private int relativeX;
    private int relativeY;

    public GateDragger(Circuit circuit) {
        this.circuit = circuit;
        this.gate = null;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.gate = this.circuit.findGateAt(e.getX(), e.getY());
        if (this.gate != null) {
            this.relativeX = e.getX() - this.gate.getX();
            this.relativeY = e.getY() - this.gate.getY();
        }
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
        if (this.gate != null) {
            this.gate.setCoords(
                    e.getX() - this.relativeX,
                    e.getY() - this.relativeY
            );
            circuit.update();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
