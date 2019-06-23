package model.Gates;

import model.Gate;

public class Source extends Gate {

    private boolean state;

    public Source() {
        this.state = true;
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

    /**
     * change the state of this source
     */
    public void changeState() {
        this.state = !this.state;
    }
}
