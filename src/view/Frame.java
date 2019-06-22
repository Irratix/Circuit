package view;

import model.Circuit;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    private static final int WIDTH = 1100;
    private static final int HEIGHT = 600;

    public Frame(String title, Circuit circuit) {
        super(title);
        Panel panel = new Panel(circuit);

        getContentPane().add(panel);

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setResizable(false);
        pack();
        setVisible(true);

    }
}
