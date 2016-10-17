package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ComputeEngine implements Compute {

	private ArrayList<Integer> primes= new ArrayList<Integer>();
	
	public ArrayList<Integer> executeTask(Task<ArrayList<Integer>> t) {
        ArrayList<Integer> result =  t.execute(primes);
		if (primes.size() == 0 || (result.size() > primes.size()))
			primes = result;
		return result;
    }

    public static void main(String[] args) {
        if (System.getSecurityManager() == null) System.setSecurityManager(new SecurityManager());
        try {
            String name = "Compute";
            Compute engine = new ComputeEngine();
            Compute stub = (Compute) UnicastRemoteObject.exportObject(engine, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stub);
            System.out.println("ComputeEngine bound");
        } catch (Exception e) {
            System.err.println("ComputeEngine exception:");
            e.printStackTrace();
        }
    }
}
