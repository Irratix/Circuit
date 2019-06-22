package model;

import java.awt.*;
import java.util.ArrayList;

public class Gate {

    protected ArrayList<Gate> inputs;
    protected ArrayList<Gate> outputs;
    private Point coords;

    private static final int INIT_X = 10;
    private static final int INIT_Y = 10;

    public Gate() {
        this.inputs = new ArrayList<>();
        this.outputs = new ArrayList<>();
        this.coords = new Point();
        setCoords(INIT_X, INIT_Y);
    }

    /**
     * set the coordinates of this gate on its circuit
     * @param x
     * @param y
     */
    public void setCoords(int x, int y) {
        this.coords.setLocation(x, y);
    }

    /**
     * generic gate evaluation
     * @return
     */
    public boolean evaluate() {
        return false;
    }

    /**
     * sets the amount of inputs for a gate
     * @param n
     */
    protected void setInputAmt(int n) {
        if (this.inputs.size() < n)
            for (int i = this.inputs.size(); i < n; i++)
                this.inputs.add(null);
        while (this.inputs.size() > n)
            this.inputs.remove(n);
    }

    /**
     * sets the amount of outputs for a gate
     * @param n
     */
    protected void setOutputAmt(int n) {
        if (this.outputs.size() < n)
            for (int i = this.outputs.size(); i < n; i++)
                this.outputs.add(null);
        while (this.outputs.size() > n)
            this.outputs.remove(n);
    }

    /**
     * return x coordinate
     * @return
     */
    public int getX() {
        return (int) this.coords.getX();
    }

    /**
     * return y coordinate
     * @return
     */
    public int getY() {
        return (int) this.coords.getY();
    }

    /**
     * returns a copy of all gates that are inputs of this gate
     * @return
     */
    public ArrayList<Gate> getInputs() {
        return (ArrayList<Gate>) this.inputs.clone();
    }

    /**
     * returns a copy of all gates that receive input from this gate
     * @return
     */
    public ArrayList<Gate> getOutputs() {
        return (ArrayList<Gate>) this.outputs.clone();
    }

    /**
     * makes a connection from this gate's output to another gate's input
     * also makes the connection both ways
     * @param gate
     * @param output
     * @param input
     */
    public void connectToComplete(Gate gate, int output, int input) {
        this.outputs.set(output, gate);
        gate.connectFromOnce(this, input);
    }

    /**
     * makes a connection from this gate's input to another gate's output
     * also makes the connection both ways
     * @param gate
     * @param output
     * @param input
     */
    public void connectFromComplete(Gate gate, int output, int input) {
        this.inputs.set(input, gate);
        gate.connectToOnce(this, output);
    }

    /**
     * makes a connection from this gate's output to another gate's input
     * only makes a one-way connection
     * @param gate
     * @param output
     */
    private void connectToOnce(Gate gate, int output) {
        this.outputs.set(output, gate);
    }

    /**
     * makes a connection from this gate's input to another gate's output
     * only makes a one-way connection
     * @param gate
     * @param input
     */
    private void connectFromOnce(Gate gate, int input) {
        this.inputs.set(input, gate);
    }
}
