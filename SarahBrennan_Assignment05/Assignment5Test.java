//Sarah Brennan 2962279
import java.util.*;

public class Assignment5Test {
	public static void main(String[] args)
	{
		
		/*Test Stack*/
		System.out.println("Stack");
		MyStack<Integer> stlst1 = new MyStack<Integer>();
		//push 10 elements onto stack
		for(int i = 0; i < 10; i++)
		{
			stlst1.push(new Integer(i));
		}
		
		Iterator<Integer> stackIt = stlst1.iterator();
		//print out each iteration in stack
		while(stackIt.hasNext())
		{
			System.out.print(stackIt.next() + " ");
		}
		System.out.println();
		//print out stack
		System.out.println(stlst1.toString());
		//print out last element in stack and then remove it
		while(!stlst1.empty()){
			System.out.print(stlst1.top()+" ");
			stlst1.pop();
		}
		
		System.out.println();
		System.out.println();
		/*Test Queue*/
		System.out.println("Queue");
		MyQueue<Integer> quelst1 = new MyQueue<Integer>();
		//add 10 elements to queue
		for(int i = 0; i < 10; i++)
		{
			quelst1.join(new Integer(i));
		}
		Iterator<Integer> queueIt = quelst1.iterator();
		//goes through each iteration of queue
		while(queueIt.hasNext())
		{
			System.out.print(queueIt.next() + " ");
		}
		System.out.println();
		//checks if queue contains certain element
		System.out.println(quelst1.contains(2));
		System.out.println(quelst1.contains(12));
		//print out queue
		System.out.println(quelst1.toString());
		//prints out first element in queue and then removes it
		while(!quelst1.empty()){
			System.out.print(quelst1.top()+" ");
			quelst1.leave();
		}		
	}
}
