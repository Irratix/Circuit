package controller.buttons;

import controller.actions.AddChipAction;
import controller.actions.AddOutputAction;
import model.Circuit;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class AddOutputButton extends JButton {

    public AddOutputButton(Circuit circuit) {
        super(new AddOutputAction(circuit));
        setButtonProperties();
    }

    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setMnemonic(KeyEvent.VK_S);
        setToolTipText("Add Output");
    }
}
