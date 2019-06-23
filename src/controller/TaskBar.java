package controller;

import controller.buttons.*;
import model.Circuit;

import javax.swing.*;

public class TaskBar extends JMenuBar {

    public TaskBar(Circuit circuit) {
        add(new AddSourceButton(circuit));
    }
}
