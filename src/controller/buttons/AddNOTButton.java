package controller.buttons;

import controller.actions.AddNOTAction;
import controller.actions.AddSourceAction;
import model.Circuit;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class AddNOTButton extends JButton {

    public AddNOTButton(Circuit circuit) {
        super(new AddNOTAction(circuit));
        setButtonProperties();
    }

    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setMnemonic(KeyEvent.VK_S);
        setToolTipText("Add NOT-gate");
    }
}
