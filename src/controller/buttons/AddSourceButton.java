package controller.buttons;

import controller.actions.AddSourceAction;
import model.Circuit;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class AddSourceButton extends JButton {

    public AddSourceButton(Circuit circuit) {
        super(new AddSourceAction(circuit));
        setButtonProperties();
    }

    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setMnemonic(KeyEvent.VK_S);
        setToolTipText("Add Source");
    }
}
