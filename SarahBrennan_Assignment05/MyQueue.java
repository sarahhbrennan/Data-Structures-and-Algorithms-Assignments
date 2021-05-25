//Sarah Brennan 2962279
import java.util.*;

public class MyQueue<E> implements Queue<E> {


	private ArrayDeque<E> queue;
	
	public MyQueue()
	{
		queue = new ArrayDeque<E>();
	}
	
	public boolean join(E x) {		
		if(full())
			return false;
		else
		{
			//add element to end of the queue
			queue.addLast(x);;
			return true;
		}
	}


	public E top() {
		//the top element of the queue returned but not removed 
		return queue.peekFirst();
	}


	public boolean leave() {
		if(queue.size() == 0)
			return false;
		else
		{
			//removes top element in queue
			queue.pollFirst();
			return true;
		}
	}

	
	public boolean full() {
		//arraydeque does not have limit so will never be full
		return false;
	}


	public boolean empty() {
		//will show true if empty and false if not empty
		return queue.isEmpty();
	}


	public boolean contains(E x) {
		//checks if element is in queue
		if(queue.contains(x))
			return true;
		else
			return false;
	}


	public Iterator<E> iterator() {
		//goes through each iteration of queue
		return queue.iterator();
	}
	
	public String toString()
	{
		//prints out queue
		return queue.toString();
	}

}
