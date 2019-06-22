package model;

import java.util.ArrayList;
import java.util.Observable;

public class Circuit extends Observable {

    private ArrayList<Gate> gates;

    public Circuit() {
        this.gates = new ArrayList<>();
    }

    /**
     * returns a copy of all gates in the circuit
     * @return
     */
    public ArrayList<Gate> getCircuit() {
        return (ArrayList<Gate>) this.gates.clone();
    }

    /**
     * adds a gate to the circuit
     * @param gate
     */
    public void addGate(Gate gate) {
        this.gates.add(gate);
    }
}
