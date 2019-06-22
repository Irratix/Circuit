import model.Circuit;
import model.Gates.*;
import view.Frame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Circuit circuit = new Circuit();

        Source gate1 = new Source();
        gate1.setCoords(10, 100);
        Light gate2 = new Light();
        gate2.setCoords(500, 100);
        AND gate3 = new AND();
        gate3.setCoords(300, 200);

        circuit.addGate(gate1);
        circuit.addGate(gate2);
        circuit.addGate(gate3);

        Frame frame = new Frame("Circuit", circuit);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
