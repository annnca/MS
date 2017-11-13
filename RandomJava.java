package randomJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomJava {
	
	int noOfNumbersToBeGenerated;
		
	public RandomJava(int noOfNumbersToBeGenerated) {
		this.noOfNumbersToBeGenerated = noOfNumbersToBeGenerated;
	}
	
	public void printNumbers(List<Integer> numbers) {
		for (Integer integer : numbers) {
			System.out.println(integer);
		}
	}
	public static double javaRandomGen(){
		Random random = new Random();
		  
		return (double)random.nextInt() / (double)Integer.MAX_VALUE;
	}
	
	public List<Integer> binomialGenerator(int n, double p){
		
		List<Integer> numbers = new ArrayList<Integer>();
		
		for (int j = 1; j <= noOfNumbersToBeGenerated; j++){
		
		  double N = javaRandomGen();
		  
		  int x  = 0;
		  for(int i = 0; i < n; i++) {
		    if(N < p) {
		      x++;
		    }
		    N = javaRandomGen();
		  }
		  
		  numbers.add(x);
		}
		  
		return numbers;
	}
	
	public List<Integer> poissonGenerator(double lambda){
		
		List<Integer> numbers = new ArrayList<Integer>();

		double L = Math.exp(-lambda);
		
		for (int j = 1; j <= noOfNumbersToBeGenerated; j++){
			double N = javaRandomGen();
			
			  double p = 1.0;
			  int k = 0;

			  do {
			    k++;
			    p = p * N;
			  } while (p > L);
			  
			  N = javaRandomGen();
			  numbers.add(k-1);
		  }
		  
		return numbers;
	}

}
