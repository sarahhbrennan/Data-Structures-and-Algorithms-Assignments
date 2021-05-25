/*
 * Question2.java
 * 
 *
 * Sarah Brennan 2962279 
 */

import java.util.*;
import java.util.function.*;
public class Question2Test {
	public static void main(String args[]){
		/*Question 2 ============================================================
		Using the generic class MyList<E> (given) write a code sequence that
		tests all of its the methods. You are given a Book class that you can use
		to perform your tests. Note that creating a MyList<Integer> instance is not
		an acceptable data type for your tests.
		================================================================== */
		
		Book b1 = new Book("Happy Days","Samuel Beckett");
		Book b2 = new Book("Ulysses","James Joyce");
		Book b3 = new Book("To Kill a Mocking Bird","Harper Lee");
		Book b4 = new Book("Lord Of The Rings","J. R. R. Tolkien");
		
		MyList<Book> bookLst = new MyList<Book>();
		MyList<Book> bookLst2 = new MyList<Book>();
		
		//add books to lists Test
		bookLst.add(Arrays.asList(b1,b2,b3));
		
		//print Test
		bookLst.print(x->System.out.print(x+", "));
		
		//contains Test
		System.out.println(bookLst.contains(b -> b.equals(b4)));
		
		//filterList Test
		System.out.println(bookLst.filterList(b -> b.equals(b2)));
		
		//remove Test
		bookLst.remove(b -> b.equals(b1));
		bookLst.print(x->System.out.print(x+", "));
	}
}