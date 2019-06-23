package controller.actions;

import model.Circuit;
import model.Gates.Source;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddSourceAction extends AbstractAction {

    private Circuit circuit;

    public AddSourceAction(Circuit circuit) {
        super("Add Source");
        this.circuit = circuit;
        setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        circuit.addGate(new Source());
    }
}
