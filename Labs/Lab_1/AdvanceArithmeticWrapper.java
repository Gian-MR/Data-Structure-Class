package Labs.Lab_1;

import java.util.ArrayList;

public class AdvanceArithmeticWrapper {

	public static interface AdvancedArithmetic{
		
		/**
		 * Method that takes an integer n as input and return the sum of all its divisors. 
		 * For example divisors of 6 are 1, 2, 3 and 6, so divisorSum() should return 12
		 *
		 * @param n - number to take the divisors of
		 * @return An integer denoting the sum of each div of n
		 */
		int divisorSum(int n);
		
		/**
		 * Method that takes an integer n as input and return an array of all its prime factors 
		 * For example prime factors of n = 12 are: 2, 2 and 3, so primeFactors() should return [2, 2, 3]
		 * 
		 * Basically what this method does is reduce all the factors of n to exclusively prime numbers, 
		 * not including 1. 
		 * Going back to the example of n = 12, we know that its factors are 3 and 4, 3 is already a prime, but
		 * 4 can be further reduced to 2 and 2, which are prime values. Which is why we get [2, 2, 3].
		 * 
		 * HINT 1: Look up Prime Factorization in the internet, this is basically what we are doing here.
		 *
		 * HINT 2: Use an ArrayList to store the numbers, then pass them on to an int array, 
		 * similar to a vector in C++.
		 *
		 * HINT 3: Remember the difference between Object Data Types and Primitive Data Types
		 * so you can successfully store values and pass them
		 *
		 * @param n - number to take the divisors of
		 * @return An array of type int denoting each prime factor (this array is in increasing order)
		 */
		int[] primeFactors(int n);
		
		/**
		 * Method that determines whether a given integer n is a prime number
		 * 
		 * @param n
		 * @return if the number is a prime number or not
		 */
		boolean isPrime(int n);
		
		
		/**
		 * Method that return the nth number in the fibonacci sequence
		 * 
		 * For example if n = 5, then fibonacci(n) returns 5 because the fifth term in the sequence is 5
		 * 
		 * Remember that the sequence starts with 1 and 1, then the next term in the series is the sum
		 * of the previous 2 terms:
		 * 
		 * 1,1,2,3,5,8,13,21,...
		 * 
		 * By definition, the fibonacci sequence is defined as follows:
		 * 
		 * F_0 = 0
		 * F_1 = 1
		 * F_n = F_(n-2) + F_(n-1)
		 * 
		 * Bonus Challenge: Doing this recursively is trivial, but can you do this ITERATIVELY?
		 * 
		 * @param n - index of the fibonacci sequence we want to find
		 * @return the value of nth term of the fibonacci sequence
		 */
		int fibonacci(int n);
		
	}
	
	public static class AdvancedCalculator implements AdvancedArithmetic{
		
		public int[] testValues; //DO NOT DELETE THIS, TEST WILL FAIL
		
		public AdvancedCalculator(int[] testValues) {
			this.testValues = testValues;
		}

		public int divisorSum(int n) {
			int sum = 0;
			for (int i = 1; i <= n; i++) {
				if (n % i == 0) {
					sum += i;
				}
			}
			return sum;
		}


		public int[] primeFactors(int n) {
			ArrayList<Integer> factors = new ArrayList<>();

			int div = 2;

			while (n > 1){
				while(n % div == 0){
					factors.add(div);
					n /= div;
				}
				div++;
			}
			int[] res = new int[factors.size()];

			for(int i = 0; i < factors.size(); i++){
				res[i] = factors.get(i);
			}

			return res;
		}

		public boolean isPrime(int n) {
			if(n < 2){
				return false;
			}
			for(int i = 2; i < n; i++){
				if(n % i == 0){
					return false;
				}
			}
			return true;
		}

		@Override
		public int fibonacci(int n) {
			if(n <= 1) return n;

			int a = 0, b = 1;

			for(int i = 2; i <=n; i++){
				int next = a + b;
				a = b;
				b = next;
			}
			return b;
		}
	}
}
