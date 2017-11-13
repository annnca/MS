package randomJava;

import java.util.ArrayList;
import java.util.List;


public class Lehmer {
	
	private int a;  //multiplicatorul
	private int c; // incrementor
	private int m; //modulul
	private int noOfNumbersToBeGenerated;
	
	public Lehmer(int a, int c, int m, int noOfNumbersToBeGenerated) {
		this.a = a;
		this.c = c;
		this.m = m;
		this.noOfNumbersToBeGenerated = noOfNumbersToBeGenerated;
	}

	public List<Integer> generate(int seed){
		List<Integer> numbers = new ArrayList<Integer>();
		
		int index = 0;
		int number = seed;
		numbers.add(number);
		
		while(index < noOfNumbersToBeGenerated) {
			number = (a * number + c) % m;
			numbers.add(number);
			index ++;
		}
		return numbers;		
	}
	
	public void printNumbers(List<Integer> numbers) {
		for (Integer integer : numbers) {
			System.out.println(integer);
		}
	}
	
	public static int LehmerGen(int x)
	{
		int a = 21;
		int c = 9;
		int m = 10000;
		x = (a*x + c) % m;
		
		return x;
	}
	public List<Integer> binomialGenerator(int n, double p){
		
		List<Integer> numbers = new ArrayList<Integer>();
		
		int seed = 27;
		
		for (int j = 1; j <= noOfNumbersToBeGenerated; j++){
		  int N = LehmerGen(seed);
		  seed = seed + 1;
		  
		  int x  = 0;
		  
		  for(int i = 0; i < n; i++) {
		    if((double)(N/10000.0) < p) {
		      x++;
		    }
		    N = LehmerGen(N);
		  }
		  numbers.add(x);
		}
		  
		return numbers;
	}
	
	public List<Integer> poissonGenerator(double lambda){
		
		List<Integer> numbers = new ArrayList<Integer>();
		
		int seed = 27;
		double L = Math.exp(-lambda);
		
		for (int j = 1; j <= noOfNumbersToBeGenerated; j++){
			int N = LehmerGen(seed);
			seed = seed + 23;
			
			  double p = 1.0;
			  int k = 0;

			  do {
			    k++;
			    p = p * (double)(N/10000.0);
			  } while (p > L);
			  
			  N = LehmerGen(N);
			  numbers.add(k-1);
		  }
		  
		return numbers;
	}
}
