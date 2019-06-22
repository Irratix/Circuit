package view;

import controller.GateDragger;
import model.Circuit;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    private static final int WIDTH = 1100;
    private static final int HEIGHT = 600;

    public Frame(String title, Circuit circuit) {
        super(title);
        Panel panel = new Panel(circuit);
        GateDragger gateDragger = new GateDragger(circuit);

        getContentPane().add(panel);
        getContentPane().addMouseListener(gateDragger);
        getContentPane().addMouseMotionListener(gateDragger);

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setResizable(false);
        pack();
        setVisible(true);

    }
}
