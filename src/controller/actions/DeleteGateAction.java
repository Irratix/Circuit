package controller.actions;

import model.Circuit;
import model.Gates.Source;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DeleteGateAction extends AbstractAction {

    private Circuit circuit;

    public DeleteGateAction(Circuit circuit) {
        super("Delete Selection");
        this.circuit = circuit;
        setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.circuit.deleteSelected();
    }
}
