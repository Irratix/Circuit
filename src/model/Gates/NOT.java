package model.Gates;

import model.Gate;

public class NOT extends Gate {

    public NOT() {
        setInputAmt(1);
        setOutputAmt(1);
    }

    /**
     * returns the state of the NOT-gate
     * @return
     */
    public boolean evaluate() {
        if (this.inputs.get(0) == null)
            return false;
        return !this.inputs.get(0).evaluate();
    }
}
