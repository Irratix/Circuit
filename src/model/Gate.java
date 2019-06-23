package model;

import java.awt.*;
import java.util.ArrayList;

import view.Panel;

public class Gate {

    protected ArrayList<Gate> inputs;
    protected ArrayList<Connector> outputs;
    private Point coords;
    private boolean selected;

    private static final int INIT_X = 10;
    private static final int INIT_Y = 10;

    public Gate() {
        this.inputs = new ArrayList<>();
        this.outputs = new ArrayList<>();
        this.coords = new Point();
        setCoords(INIT_X, INIT_Y);
        this.selected = false;
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
            for (int i = this.inputs.size(); i<n; i++)
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
            for (int i = this.outputs.size(); i<n; i++)
                this.outputs.add(new Connector());
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
    public ArrayList<Connector> getOutputs() {
        return (ArrayList<Connector>) this.outputs.clone();
    }

    /**
     * makes a connection from this gate's output to a gate's input
     * makes a complete connection
     * @param gate
     * @param output
     * @param input
     */
    public void connectToComplete(Gate gate, int output, int input) {
        this.outputs.get(output).connectTo(gate);
        gate.connectFromOnce(this, input);
    }

    /**
     * makes a connection from a gate's output to this gate's input
     * makes a complete connection
     * @param gate
     * @param output
     * @param input
     */
    public void connectFromComplete(Gate gate, int output, int input) {
        this.inputs.set(input, gate);
        gate.connectToOnce(this, output);
    }

    /**
     * makes a connection from this gate's output to a gate's input
     * only consolidates the connection from this gate's end
     * @param gate
     * @param output
     */
    public void connectToOnce(Gate gate, int output) {
        this.outputs.get(output).connectTo(gate);
    }

    /**
     * makes a connection from a gate's output to this gate's input
     * only consolidates the connection from this gate's end
     * @param gate
     * @param input
     */
    public void connectFromOnce(Gate gate, int input) {
        this.inputs.set(input, gate);
    }

    /**
     * check if this gate is at these coordinates
     * @param x
     * @param y
     * @return
     */
    public boolean isAt(int x, int y) {
        return this.getX() < x
                && this.getX() + Panel.DEFAULT_GATE_WIDTH > x
                && this.getY() < y
                && this.getY() + Panel.DEFAULT_GATE_HEIGHT > y;
    }

    /**
     * changes selection state of this gate
     * @param select
     */
    public void setSelected(boolean select) {
        this.selected = select;
    }

    /**
     * determines whether or not this gate is selected
     * @return
     */
    public boolean getSelected() {
        return this.selected;
    }
}
