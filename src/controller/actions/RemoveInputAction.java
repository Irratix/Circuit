package controller.actions;

import model.Circuit;
import model.Gates.AND;
import model.Gates.Source;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RemoveInputAction extends AbstractAction {

    private Circuit circuit;

    public RemoveInputAction(Circuit circuit) {
        super("Remove Input");
        this.circuit = circuit;
        setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        circuit.removeInput();
    }
}
