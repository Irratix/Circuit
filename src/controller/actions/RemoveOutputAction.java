package controller.actions;

import model.Circuit;
import model.Gates.AND;
import model.Gates.Source;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RemoveOutputAction extends AbstractAction {

    private Circuit circuit;

    public RemoveOutputAction(Circuit circuit) {
        super("Remove Output");
        this.circuit = circuit;
        setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        circuit.removeOutput();
    }
}
