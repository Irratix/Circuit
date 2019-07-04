package controller.actions;

import model.ChipCircuit;
import model.Circuit;
import model.Gates.AND;
import model.Gates.Source;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddOutputAction extends AbstractAction {

    private ChipCircuit circuit;

    public AddOutputAction(ChipCircuit circuit) {
        super("Add Output");
        this.circuit = circuit;
        setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        circuit.addOutput();
    }
}
