package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

import view.Panel;

public class Circuit extends Observable {

    private ArrayList<Gate> gates;
    private ArrayList<Gate> toBeDeleted;

    public Circuit() {
        this.gates = new ArrayList<>();
        this.toBeDeleted = new ArrayList<>();
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
        update();
    }

    /**
     * returns a gate at the passed location, or null if there is none
     * @param x
     * @param y
     * @return
     */
    public Gate findGateAt(int x, int y) {
        for (Gate gate : this.gates)
            if (gate.isAt(x, y))
                return gate;
        return null;
    }

    /**
     * notify observers
     */
    public void update() {
        setChanged();
        notifyObservers();
    }

    /**
     * find which gate has an output at inserted coordinates
     * @param x
     * @param y
     * @return
     */
    public Gate findOutputAt(int x, int y) {
        Point coords = new Point(x, y);
        for (Gate gate : this.gates) {
            for (int i=0; i<gate.getOutputs().size(); i++) {
                Point outputCoords = new Point(
                        gate.getX() + Panel.DEFAULT_GATE_WIDTH,
                        gate.getY() + (i+1)*Panel.DEFAULT_GATE_HEIGHT/(gate.getOutputs().size()+1));
                if (coords.distance(outputCoords) < Panel.DEFAULT_CONNECT_RADIUS)
                    return gate;
            }
        }
        return null;
    }

    /**
     * find which gate has an input at inserted coordinates
     * @param x
     * @param y
     * @return
     */
    public Gate findInputAt(int x, int y) {
        Point coords = new Point(x, y);
        for (Gate gate : this.gates) {
            for (int i=0; i<gate.getInputs().size(); i++) {
                Point inputCoords = new Point(
                        gate.getX(),
                        gate.getY() + (i+1)*Panel.DEFAULT_GATE_HEIGHT/(gate.getInputs().size()+1));
                if (coords.distance(inputCoords) < Panel.DEFAULT_CONNECT_RADIUS)
                    return gate;
            }
        }
        return null;
    }

    /**
     * make a gate selected
     * @param gate
     */
    public void selectGate(Gate gate) {
        gate.setSelected(true);
        update();
    }

    public void unselectGate(Gate gate) {
        gate.setSelected(false);
    }

    public void deleteSelected() {
        for (Gate gate : this.gates) {
            if (gate.isSelected()) {
                this.toBeDeleted.add(gate);
            }
        }
        for (Gate gate : this.toBeDeleted) {
            deleteGate(gate);
        }
        this.toBeDeleted = new ArrayList<>();
        update();
    }

    /**
     * deletes the selected gate from the circuit
     */
    public void deleteGate(Gate gate) {
        for (Gate input : gate.getInputs())
            if (input != null)
                for (Connector connector : input.getOutputs())
                    connector.removeGate(gate);
        for (Connector connector : gate.getOutputs())
            for (Gate output : connector.connections())
                if (output != null) {
                    output.removeInput(gate);
                }
        this.gates.remove(gate);
        update();
    }
}
