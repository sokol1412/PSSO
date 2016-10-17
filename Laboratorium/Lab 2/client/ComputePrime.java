package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import server.Compute;
import java.util.ArrayList;

public class ComputePrime {
	 public static void main(String args[]) {
	        if (System.getSecurityManager() == null) System.setSecurityManager(new SecurityManager());
	        try {
	            String name = "Compute";
	            Registry registry = LocateRegistry.getRegistry(args[0]);
	            Compute comp = (Compute) registry.lookup(name);
	            PrimeNum taskPrime = new PrimeNum(Integer.parseInt(args[1]));
	            ArrayList<Integer> prime = comp.executeTask(taskPrime);
	            System.out.println(prime);    
	        } catch (Exception e) {
	            System.err.println("ComputePrime exception:");
	            e.printStackTrace();
	        }
	    }    
}
