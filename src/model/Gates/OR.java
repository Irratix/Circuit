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
        boolean gate1 = false;
        boolean gate2 = false;
        if (this.inputs.get(0) != null)
            gate1 = this.inputs.get(0).evaluate();
        if (this.inputs.get(1) != null)
            gate2 = this.inputs.get(1).evaluate();
        return gate1 || gate2;
    }
}
