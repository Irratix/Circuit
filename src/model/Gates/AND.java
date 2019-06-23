package model.Gates;

import model.Gate;

public class AND extends Gate {

    public AND() {
        setInputAmt(2);
        setOutputAmt(1);
    }

    /**
     * returns the state of the AND-gate
     * @return
     */
    public boolean evaluate() {
        return this.inputs.get(0).evaluate()
                && this.inputs.get(0).evaluate();
    }
}