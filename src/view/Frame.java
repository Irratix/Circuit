package view;

import controller.ConnectAction;
import controller.GateDragger;
import controller.GateInteraction;
import controller.TaskBar;
import model.Circuit;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    private static final int WIDTH = 2*1920/3;
    private static final int HEIGHT = 2*1080/3;

    public Frame(String title, Circuit circuit) {
        super(title);
        Panel panel = new Panel(circuit);
        GateDragger gateDragger = new GateDragger(circuit);
        ConnectAction connector = new ConnectAction(circuit);
        GateInteraction gateInteraction = new GateInteraction(circuit);

        getContentPane().add(panel);
        getContentPane().addMouseListener(gateDragger);
        getContentPane().addMouseMotionListener(gateDragger);
        getContentPane().addMouseListener(connector);
        getContentPane().addMouseMotionListener(connector);
        getContentPane().addMouseListener(gateInteraction);

        setJMenuBar(new TaskBar(circuit));
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setResizable(true);
        pack();
        setVisible(true);
    }
}
