package controller;

import model.Circuit;
import model.Gate;
import model.Gates.Chip;
import model.Gates.Source;
import view.Frame;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GateInteraction extends JPanel implements MouseListener {

    private Circuit circuit;

    public GateInteraction(Circuit circuit) {
        this.circuit = circuit;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            Gate gate = this.circuit.findGateAt(e.getX(), e.getY());
            if (gate != null) {
                if (gate instanceof Source) {
                    Source source = (Source) gate;
                    source.changeState();
                } else if (gate instanceof Chip) {
                    Chip chip = (Chip) gate;
                    Frame frame = new Frame("Chip", chip.getCircuit());
                }
            }
            this.circuit.update();
        }
        if (SwingUtilities.isRightMouseButton(e)) {
            Gate gate = this.circuit.findGateAt(e.getX(), e.getY());
            if (gate != null && gate.isSelected() == false) {
                this.circuit.selectGate(gate);
            } else {
                this.circuit.removeSelection();
            }
        }
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
}
