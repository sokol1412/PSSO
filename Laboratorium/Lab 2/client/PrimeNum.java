package client;

import java.util.ArrayList;
import server.Task;
import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class PrimeNum implements Task<ArrayList<Integer>>, Serializable{
	private final int num;
	private static ArrayList<Integer> primeNumbers = new ArrayList<Integer>();

	public PrimeNum(int num) {
        this.num = num;
    }
	
	public ArrayList<Integer> execute(ArrayList<Integer> primes) {
        //need to handle buffor we receive (primes array - variable above) - we must start looking for new prime numbers starting with last element of primes array
		return computePrime(primes, num);
    }
	
	public static ArrayList<Integer> computePrime(ArrayList<Integer> primes, int num) {
		int i = 0;
		int j = 0;
		primeNumbers.clear();
		
		if(primes.size() == 0) {
			j = 2;
		}
		else if(primes.size() < num){
			i = primes.size();
			j = primes.get(primes.size() - 1) + 1;
			primeNumbers = primes;
		}
		else if (primes.size() > num) {
			for (int k=0; k<num; k++) {
				primeNumbers.add(primes.get(k));
			}
			return primeNumbers;
		}
		else return primes;
		
		while(i!=num) {
			if (isPrime(j)) {
				primeNumbers.add(j);
				i++;
			}
			j++;
		}
		return primeNumbers;
    }
	
	static boolean isPrime(int check) {
	    for (int i = 2; i <= check/2; i++) {
	        if (check % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}

}
