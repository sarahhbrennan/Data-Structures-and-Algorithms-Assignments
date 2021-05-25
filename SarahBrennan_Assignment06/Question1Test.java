/*
 * Question1.java
 * 
 *
 * Sarah Brennan 2962279
 */

import java.util.*;
import java.util.function.*;
public class Question1Test {
	public static void main(String args[]){
		/*Question 1 ==========================================================
		Using the class NewNumbers (given) write a code sequence that tests
		the methods:
			forAll(Predicate<Integer> pr),
			List<Integer> getSubList(Predicate<Integer> pr)
			List<Integer> mapList(Function<Integer,Integer> f)
			Sample tests might be: all the values are positive, all negative,
			retrieve a list of the even numbers, a list of negative numbers,
			use mapList to return the square of all the numbers, etc
			You should write at least three tests for each method
		======================================================================*/
		// This code sets up a List
		NewNumbers lst = new NewNumbers();
		lst.add(Arrays.asList(1,2,3,4,6,-1,-5,7,8,12,4,-5,0,0,1,4,-2));
		lst.print(x->System.out.print(x+" "));
		
		/**
		 * Test forAll
		 */
		//Test that numbers are all less than 13
		System.out.println(lst.forAll(x-> x < 13));
		//Test that numbers are all negative
		System.out.println(lst.forAll(x-> x < 0));
		//Test that numbers are all positive
		System.out.println(lst.forAll(x-> x > 0));

		/**
		 * Test getSubList
		 */
		//get list of even numbers
		System.out.println(lst.getSubList(x-> x%2 == 0));
		//get list of negative numbers
		System.out.println(lst.getSubList(x-> x < 0));
		//get list of odd numbers
		System.out.println(lst.getSubList(x-> x%2 != 0));

		/**
		 * Test mapList
		 */
		//get square of all numbers
		System.out.println(lst.mapList(x-> x*x));
		//get list of all numbers as positive
		System.out.println(lst.mapList(x-> x >= 0 ? x : -x));
		//get list of all numbers as negative
		System.out.println(lst.mapList(x-> x <= 0 ? x : -x));
		
		int x = 1;
		assert x == 1;
		
	}
}