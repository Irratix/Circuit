package controller.actions;

import model.Circuit;
import model.Gates.AND;
import model.Gates.Source;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddANDAction extends AbstractAction {

    private Circuit circuit;

    public AddANDAction(Circuit circuit) {
        super("Add AND-gate");
        this.circuit = circuit;
        setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        circuit.addGate(new AND());
    }
}
