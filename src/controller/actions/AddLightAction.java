package controller.actions;

import model.Circuit;
import model.Gates.Light;
import model.Gates.Source;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddLightAction extends AbstractAction {

    private Circuit circuit;

    public AddLightAction(Circuit circuit) {
        super("Add Light");
        this.circuit = circuit;
        setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        circuit.addGate(new Light());
    }
}
