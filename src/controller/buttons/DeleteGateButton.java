package controller.buttons;

import controller.actions.AddSourceAction;
import controller.actions.DeleteGateAction;
import model.Circuit;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class DeleteGateButton extends JButton {

    public DeleteGateButton(Circuit circuit) {
        super(new DeleteGateAction(circuit));
        setButtonProperties();
    }

    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setMnemonic(KeyEvent.VK_S);
        setToolTipText("Delete Selected");
    }
}
