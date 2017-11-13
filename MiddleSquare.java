package randomJava;

import java.util.ArrayList;
import java.util.List;


public class MiddleSquare {
	int noOfNumbersToBeGenerated;
	
	public MiddleSquare(int noOfNumbersToBeGenerated) {
		this.noOfNumbersToBeGenerated = noOfNumbersToBeGenerated;
	}

	public List<Long> generator(long seed){
		List<Long> numbers = new ArrayList<Long>();
		
		long number;
		int index = 0;
		
		number = seed*seed;
		
		numbers.add(seed);
		
		while(index < noOfNumbersToBeGenerated) {
			String stringNumber = "" + number;
			
			int middle = stringNumber.length() / 2;
			
			stringNumber = stringNumber.substring(middle-2, middle+2);
			
			number = Integer.parseInt(stringNumber);
			
			
			if(number/1000 == 0 && number/100%10 == 0) {
				number = number + 1100;
			} // case 00ab
			
			if(number/1000 == 0 && number/100%10 == 0 && number%100/10 == 0) {
				number = number + 1230;
			}//case 000a
			
			if(number == 0) {
				number = seed + 1;
			}//case 0000
			
			if(number%100/10 == 0 && number%10 == 0) {
				number = number + 1;
			}//case ab00
			
			if(number/1000 == 0) {
				number = number + 2000;
			}//case ab00
			
			numbers.add(number);

			number = number*number;

			index++;
		}
		return numbers;
	}

	public void printNumbers(List<Long> numbers) {
		for (Long integer : numbers) {
			System.out.println(integer);
		}
	}
	public static int midSquareGen(int seed)
	{
		int number;
		
		number = seed*seed;

			String stringNumber = "" + number;
			
			int middle = stringNumber.length() / 2;
			
			stringNumber = stringNumber.substring(middle-2, middle+2);
			
			number = Integer.parseInt(stringNumber);
			
			
			if(number/1000 == 0 && number/100%10 == 0) {
				number = number + 1100;
			} // case 00ab
			
			if(number/1000 == 0 && number/100%10 == 0 && number%100/10 == 0) {
				number = number + 1230;
			}//case 000a
			
			if(number == 0) {
				number = seed + 1;
			}//case 0000
			
			if(number%100/10 == 0 && number%10 == 0) {
				number = number + 1;
			}//case ab00
			
			if(number/1000 == 0) {
				number = number + 2000;
			}//case ab00

			return number;
	}
	public List<Integer> binomialGenerator(int n, double p){	
		List<Integer> numbers = new ArrayList<Integer>();
		
		int seed = 4398;
		
		for (int j = 1; j <= noOfNumbersToBeGenerated; j++){
		  int N = midSquareGen(seed);
		  seed = seed + 54;
		  
		  int x  = 0;
		  
		  for(int i = 0; i < n; i++) {
		    if((double)(N/10000.0) < p) {
		      x++;
		    }
		    N = midSquareGen(N);
		  }
		  numbers.add(x);
		}
		  
		return numbers;
	}
	
	public List<Integer> poissonGenerator(double lambda){
		
		List<Integer> numbers = new ArrayList<Integer>();
		
		int seed = 2746;
		double L = Math.exp(-lambda);
		
		for (int j = 1; j <= noOfNumbersToBeGenerated; j++){
			int  N = midSquareGen(seed);
			seed = seed + 54;
			 
			double p = 1.0;
			int k = 0;

			do {
			    k++;
			    p = p * (double)(N/10000.0);
			} while (p > L);
			  
			N = midSquareGen(N);
			numbers.add(k-1);
		  }
		  
		return numbers;
	}
}
