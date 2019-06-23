package controller.buttons;

import controller.actions.AddANDAction;
import controller.actions.AddSourceAction;
import model.Circuit;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class AddANDButton extends JButton {

    public AddANDButton(Circuit circuit) {
        super(new AddANDAction(circuit));
        setButtonProperties();
    }

    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setMnemonic(KeyEvent.VK_S);
        setToolTipText("Add AND-gate");
    }
}
