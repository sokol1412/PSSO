


/**
 * This simulation subclass implements AbstractSimulation.run(..)
 * with  a test script for the telecom system with only the
 * basic objects.
 */
public class BasicSimulation extends AbstractSimulation {

    public static void main(String[] args){
    	simulation = new BasicSimulation();
    	simulation.run();
    }

    protected void report(Customer c) { }

}
