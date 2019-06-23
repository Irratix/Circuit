package model;

import model.Gates.Chip;

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
        for (Connector connector : gate.getOutputs())
            for (Gate chip : connector.connections())
                if (chip instanceof Chip) {
                    Chip curChip = (Chip) chip;
                    if (curChip.contains(this))
                        connector.removeGate(chip);
                }
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
        Connector connector = this.outputs.get(this.outputs.size()-1);
        for (Gate gate : connector.connections())
            gate.getInputs().removeIf(gates -> gates instanceof Chip && ((Chip)gates).contains(this));
        this.outputs.remove(connector);
        update();
    }

    /**
     * return this circuit's inputs
     * @return
     */
    public ArrayList<Gate> getInputs() {
        return this.inputs;
    }

    /**
     * return this circuit's outputs
     * @return
     */
    public ArrayList<Connector> getOutputs() {
        return this.outputs;
    }
}
