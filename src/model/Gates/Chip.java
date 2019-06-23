package model.Gates;

import model.ChipCircuit;
import model.Circuit;
import model.Gate;

import java.util.Observable;
import java.util.Observer;

public class Chip extends Gate implements Observer {

    private ChipCircuit circuit;

    public Chip() {
        this.circuit = new ChipCircuit();
        this.circuit.addObserver(this);
        setInputAmt(0);
        setOutputAmt(0);
    }

    public ChipCircuit getCircuit() {
        return this.circuit;
    }

    /**
     * update whenever the set of inputs and outputs changes
     * @param o
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {
        this.inputs = this.circuit.getInputs();
        this.outputs = this.circuit.getOutputs();
        notifyObservers();
    }
}
