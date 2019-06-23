package model;

import java.util.ArrayList;

public class Connector {

    ArrayList<Gate> connections;

    public Connector() {
        this.connections = new ArrayList<>();
    }

    /**
     * adds a connection from this connector to a gate
     * @param gate
     */
    public void connectTo(Gate gate) {
        this.connections.add(gate);
    }

    /**
     * returns whether or not this connector has a connection to a certain gate
     * @param gate
     * @return
     */
    public boolean isConnectedTo(Gate gate) {
        return this.connections.contains(gate);
    }
}
