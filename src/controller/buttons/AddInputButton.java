package controller.buttons;

import controller.actions.AddChipAction;
import controller.actions.AddInputAction;
import model.ChipCircuit;
import model.Circuit;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class AddInputButton extends JButton {

    public AddInputButton(ChipCircuit circuit) {
        super(new AddInputAction(circuit));
        setButtonProperties();
    }

    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setMnemonic(KeyEvent.VK_S);
        setToolTipText("Add Input");
    }
}
