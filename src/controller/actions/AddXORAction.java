package controller.actions;

import model.Circuit;
import model.Gates.OR;
import model.Gates.Source;
import model.Gates.XOR;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddXORAction extends AbstractAction {

    private Circuit circuit;

    public AddXORAction(Circuit circuit) {
        super("Add XOR-gate");
        this.circuit = circuit;
        setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        circuit.addGate(new XOR());
    }
}
