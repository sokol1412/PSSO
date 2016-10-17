package server;
import java.util.ArrayList;

public interface Task<T> {
    ArrayList<Integer> execute(ArrayList<Integer> primes);
}
