package controller.actions;

import model.ChipCircuit;
import model.Circuit;
import model.Gates.AND;
import model.Gates.Source;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RemoveInputAction extends AbstractAction {

    private ChipCircuit circuit;

    public RemoveInputAction(ChipCircuit circuit) {
        super("Remove Input");
        this.circuit = circuit;
        setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        circuit.removeInput();
    }
}
