package controller.buttons;

import controller.actions.AddChipAction;
import controller.actions.RemoveInputAction;
import model.Circuit;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class RemoveInputButton extends JButton {

    public RemoveInputButton(Circuit circuit) {
        super(new RemoveInputAction(circuit));
        setButtonProperties();
    }

    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setMnemonic(KeyEvent.VK_S);
        setToolTipText("Remove Input");
    }
}
