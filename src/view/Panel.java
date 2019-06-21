package view;

import model.Circuit;

import javax.swing.*;

public class Panel extends JPanel {

    private Circuit circuit;

    public Panel(Circuit circuit) {
        this.circuit = circuit;
    }
}
