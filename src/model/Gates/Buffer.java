package model.Gates;

import model.Connector;
import model.Gate;

public class Buffer extends Gate {

    private Connector connection;

    public Buffer(Connector connector) {
        setInputAmt(0);
        setOutputAmt(1);
        this.connection = connector;
    }

    /**
     * returns the state of the Buffer
     * @return
     */
    public boolean evaluate() {
        return this.connection.evaluate();
    }
}
