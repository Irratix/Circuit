package controller.actions;

import model.Circuit;
import model.Gates.Chip;
import model.Gates.Light;
import model.Gates.Source;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddChipAction extends AbstractAction {

    private Circuit circuit;

    public AddChipAction(Circuit circuit) {
        super("Add Chip");
        this.circuit = circuit;
        setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        circuit.addGate(new Chip());
    }
}
