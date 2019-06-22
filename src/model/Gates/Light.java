package model.Gates;

import model.Gate;

public class Light extends Gate {

    public Light() {
        setInputAmt(1);
        setOutputAmt(0);
    }

    /**
     * returns the state of the Light
     * @return
     */
    public boolean evaluate() {
        return this.inputs.get(0).evaluate();
    }
}
