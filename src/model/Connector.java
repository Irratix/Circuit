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

    /**
     * removes a gate from the connection
     * @param gate
     */
    public void removeGate(Gate gate) {
        this.connections.replaceAll(connected -> connected == gate ? null : connected);
    }

    /**
     * returns a copy of all gates connected with this connector
     * @return
     */
    public ArrayList<Gate> connections() {
        return (ArrayList<Gate>) this.connections.clone();
    }
}
