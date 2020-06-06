package controller.buttons;

import controller.actions.AddORAction;
import controller.actions.AddSourceAction;
import controller.actions.AddXORAction;
import model.Circuit;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class AddXORButton extends JButton {

    public AddXORButton(Circuit circuit) {
        super(new AddXORAction(circuit));
        setButtonProperties();
    }

    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setMnemonic(KeyEvent.VK_S);
        setToolTipText("Add XOR-gate");
    }
}
