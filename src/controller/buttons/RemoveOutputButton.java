package controller.buttons;

import controller.actions.AddChipAction;
import controller.actions.RemoveOutputAction;
import model.Circuit;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class RemoveOutputButton extends JButton {

    public RemoveOutputButton(Circuit circuit) {
        super(new RemoveOutputAction(circuit));
        setButtonProperties();
    }

    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setMnemonic(KeyEvent.VK_S);
        setToolTipText("Remove Output");
    }
}
