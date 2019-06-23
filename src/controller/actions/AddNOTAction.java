package controller.actions;

import model.Circuit;
import model.Gates.NOT;
import model.Gates.Source;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddNOTAction extends AbstractAction {

    private Circuit circuit;

    public AddNOTAction(Circuit circuit) {
        super("Add NOT-gate");
        this.circuit = circuit;
        setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        circuit.addGate(new NOT());
    }
}
