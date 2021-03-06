package controller;

import controller.buttons.*;
import model.Circuit;

import javax.swing.*;

public class TaskBar extends JMenuBar {

    public TaskBar(Circuit circuit) {
        add(new AddSourceButton(circuit));
        add(new AddLightButton(circuit));
        add(new AddChipButton(circuit));
        add(new AddANDButton(circuit));
        add(new AddNOTButton(circuit));
        add(new AddORButton(circuit));
        add(new AddXORButton(circuit));
        add(new DeleteGateButton(circuit));
    }
}
