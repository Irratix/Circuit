package model.Gates;

import model.Circuit;
import model.Gate;

public class Chip extends Gate {

    private Circuit circuit;

    public Chip() {
        this.circuit = new Circuit();
        setInputAmt(0);
        setOutputAmt(0);
    }

    public Circuit getCircuit() {
        return this.circuit;
    }
}
