package controller;

import controller.buttons.*;
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
                    frame.getJMenuBar().add(new AddInputButton(chip.getCircuit()));
                    frame.getJMenuBar().add(new RemoveInputButton(chip.getCircuit()));
                    frame.getJMenuBar().add(new AddOutputButton(chip.getCircuit()));
                    frame.getJMenuBar().add(new RemoveOutputButton(chip.getCircuit()));
                }
            }
            this.circuit.update();
        }
        if (SwingUtilities.isRightMouseButton(e)) {
            Gate gate = this.circuit.findGateAt(e.getX(), e.getY());
            if (gate != null) {
                if (gate.isSelected() == false) {
                    this.circuit.selectGate(gate);
                } else {
                    this.circuit.unselectGate(gate);
                }
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
