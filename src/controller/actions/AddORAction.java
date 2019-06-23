package controller.actions;

import model.Circuit;
import model.Gates.OR;
import model.Gates.Source;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddORAction extends AbstractAction {

    private Circuit circuit;

    public AddORAction(Circuit circuit) {
        super("Add OR-gate");
        this.circuit = circuit;
        setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        circuit.addGate(new OR());
    }
}
