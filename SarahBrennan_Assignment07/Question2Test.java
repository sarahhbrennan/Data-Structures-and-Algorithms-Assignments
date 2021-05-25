/**
 * student name: Sarah Brennan
 * student number: 2962279
 *
 */

import java.util.*;
import java.util.function.*;
public class Question2Test {
	public static void main(String[] args){
		
		//create new myhashlist with 20 lists
		MyHashList<Integer> myLst = new MyHashList<Integer>(20);
		//add elements into each list, have 100 altogether in 20 lists
		for(int i = 0; i < 100; i++)
		{
			//random number between 0 and 29 and add to table
			int x = (int)(Math.random()*30);
			myLst.add(x);
		}
		System.out.println(myLst.toString());
		//find all elements in myLst with same hashcode as 20
		System.out.println(myLst.getList(20));
		
		//create new list of integers
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(20);	
		list.add(21);	
		list.add(22);	
		//remove all elements in list from myLst
		myLst.remove(list);
		//print out lists once elements have been removed
		System.out.println(myLst.toString());
		
		//print out list of values in table that are less than 30
		System.out.println(myLst.get(x-> x <= 30));
	}
}