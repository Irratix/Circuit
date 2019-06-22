package model.Gates;

import model.Gate;

public class OR extends Gate {

    public OR() {
        setInputAmt(2);
        setOutputAmt(1);
    }

    /**
     * returns the state of the OR-gate
     * @return
     */
    public boolean evaluate() {
        return this.inputs.get(0).evaluate()
                || this.inputs.get(0).evaluate();
    }
}
