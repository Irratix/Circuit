import model.Circuit;
import model.Gates.*;
import view.Frame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Circuit circuit = new Circuit();

        //just some testing data
        /*Source gate1 = new Source();
        gate1.setCoords(100, 100);
        Source gate2 = new Source();
        gate2.setCoords(150, 400);
        AND gate3 = new AND();
        gate3.setCoords(300, 200);
        Light gate4 = new Light();
        gate4.setCoords(500, 100);
        gate1.connectToComplete(gate3, 0, 0);
        gate2.connectToComplete(gate3, 0, 1);
        gate3.connectToComplete(gate4, 0, 0);

        circuit.addGate(gate1);
        circuit.addGate(gate2);
        circuit.addGate(gate3);
        circuit.addGate(gate4);*/

        Frame frame = new Frame("Circuit", circuit);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
