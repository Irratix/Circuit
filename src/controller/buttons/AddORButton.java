package controller.buttons;

import controller.actions.AddORAction;
import controller.actions.AddSourceAction;
import model.Circuit;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class AddORButton extends JButton {

    public AddORButton(Circuit circuit) {
        super(new AddORAction(circuit));
        setButtonProperties();
    }

    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setMnemonic(KeyEvent.VK_S);
        setToolTipText("Add OR-gate");
    }
}
