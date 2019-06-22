package model.Gates;

import model.Gate;

public class Source extends Gate {

    private boolean state;

    public Source() {
        this.state = false;
        setInputAmt(0);
        setOutputAmt(1);
    }

    /**
     * returns the state of the source
     * @return
     */
    public boolean evaluate() {
        return this.state;
    }
}
