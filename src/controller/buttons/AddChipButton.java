package controller.buttons;

import controller.actions.AddChipAction;
import controller.actions.AddLightAction;
import model.Circuit;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class AddChipButton extends JButton {

    public AddChipButton(Circuit circuit) {
        super(new AddChipAction(circuit));
        setButtonProperties();
    }

    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setMnemonic(KeyEvent.VK_S);
        setToolTipText("Add Chip");
    }
}
