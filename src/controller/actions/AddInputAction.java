package controller.actions;

import model.Circuit;
import model.Gates.AND;
import model.Gates.Source;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddInputAction extends AbstractAction {

    private Circuit circuit;

    public AddInputAction(Circuit circuit) {
        super("Add Input");
        this.circuit = circuit;
        setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        circuit.addInput();
    }
}
