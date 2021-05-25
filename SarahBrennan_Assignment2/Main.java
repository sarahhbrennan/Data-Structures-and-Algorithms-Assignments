//Sarah Brennan 2962279
import java.util.*;
public class Main {

	public static void main(String[] args) {
		
		Question2 q2 = new Question2();

		/*Factorial*/
		
		//get time before method called
		long start = System.nanoTime();
		//call method
		int y = q2.factorial(20);
		//get time after method called
		long end = System.nanoTime();
		//get time method takes to run
		long t1 = end - start;	
		//print out factorial
		System.out.println("Factorial: " + y);
		//print out how long it took to run
		System.out.println("Factorial took " + t1 + " nanoseconds to run");
		
		/*Power*/

		//get time before method called
		start = System.nanoTime();
		//call method
		int z = q2.power(15,5);
		//get time after method called
		end = System.nanoTime();
		//get time method takes to run
		long t2 = end - start;
		//print out power
		System.out.println("Power: " + z);
		//print out how long it took to run
		System.out.println("Power took " + t2 + " nanoseconds to run");

		/*Linear Search*/
		
		//populate array with random numbers
		int [] arr = new int [1000000];
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = (int) ((Math.random() * 10000000) + 1);
		}
		//get time before method called
		start = System.nanoTime();
		//call method
		int x = q2.linearSearch(arr, arr.length, (int) ((Math.random() * 10000000) + 1));
		//get time after method called
		end = System.nanoTime();
		//get time method takes to run
		long t3 = end - start;
		//print out position of linear search result
		System.out.println("Position of searched term: " + x);
		//print out how long it took to run
		System.out.println("Linear seach took " + t3 + " nanoseconds to run");
	}
}
