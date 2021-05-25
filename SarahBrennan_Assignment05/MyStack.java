//Sarah Brennan 2962279
import java.util.*;

public class MyStack<E> implements Stack<E>{
	
	private ArrayList<E> myStackList;
	private int size = 0;
	
	public MyStack() {
		myStackList = new ArrayList<E>();
	}

	public boolean push(E x) {
		if(full())
			return false;
		else {
			//add item to stack
			myStackList.add(x);
			//increase size of stack
			size++;
			return true;
		}
	}


	public boolean pop() {
		if(empty())
			return false;
		else
		{
			//create temp item to get top of stack to return
			//E temp = myStackList.get(size);
			//remove top item
			myStackList.remove(size-1);
			//decrease the size of the stack
			size--;
			return true;
		}
	}


	public E top() {
		if(empty())
			//nothing to return if stack is empty
			return null;
		else
		{
			//return the top item of stack
			return myStackList.get(size-1);
		}
	}


	public boolean empty() {
		//returns true if 0 and false if more than 0
		return size == 0;
	}


	public boolean full() {
		//as arraylist can never be fill, this will always be false
		return false;
	}


	public Iterator<E> iterator() {
		//goes through each item in the list
		return myStackList.iterator();
		
	}
	
	public String toString()
	{
		//prints stack
		return myStackList.toString();
	}
}
