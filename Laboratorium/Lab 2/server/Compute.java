package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Compute extends Remote {
    ArrayList<Integer> executeTask(Task<ArrayList<Integer>> t) throws RemoteException;
}
