package controller.actions;

import model.Circuit;
import model.Gates.AND;
import model.Gates.Source;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddOutputAction extends AbstractAction {

    private Circuit circuit;

    public AddOutputAction(Circuit circuit) {
        super("Add Output");
        this.circuit = circuit;
        setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        circuit.addOutput();
    }
}
