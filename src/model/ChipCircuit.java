package model;

import java.util.ArrayList;

public class ChipCircuit extends Circuit {

    private ArrayList<Gate> inputs;
    private ArrayList<Connector> outputs;

    public ChipCircuit() {
        this.inputs = new ArrayList<>();
        this.outputs = new ArrayList<>();
    }


    /**
     * add a new input to the circuit
     */
    public void addInput() {
        this.inputs.add(null);
        update();
    }

    /**
     * remove the last input
     */
    public void removeInput() {
        Gate gate = this.inputs.get(this.inputs.size()-1);
        this.inputs.remove(gate);
        update();
    }

    /**
     * remove last output of the circuit
     */
    public void addOutput() {
        this.outputs.add(new Connector());
        update();
    }

    /**
     * add a new input to the circuit
     */
    public void removeOutput() {
        this.outputs.remove(this.outputs.get(this.outputs.size()-1));
        update();
    }

    /**
     * return this circuit's inputs
     * @return
     */
    public ArrayList<Gate> getInputs() {
        return (ArrayList<Gate>) this.inputs.clone();
    }

    /**
     * return this circuit's outputs
     * @return
     */
    public ArrayList<Connector> getOutputs() {
        return (ArrayList<Connector>) this.outputs.clone();
    }
}
