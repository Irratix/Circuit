import model.Circuit;
import model.Gates.*;
import view.Frame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Circuit circuit = new Circuit();
        Frame frame = new Frame("Circuit", circuit);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
