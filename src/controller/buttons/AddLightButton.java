package controller.buttons;

import controller.actions.AddLightAction;
import model.Circuit;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class AddLightButton extends JButton {

    public AddLightButton(Circuit circuit) {
        super(new AddLightAction(circuit));
        setButtonProperties();
    }

    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setMnemonic(KeyEvent.VK_S);
        setToolTipText("Add Light");
    }
}
