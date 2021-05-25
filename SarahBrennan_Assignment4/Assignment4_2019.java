/**
 * Student name: Sarah Brennan
 *
 * Student number: 2962279
 */
 /*
 For Assignment 5 please complete the methods listed below for class LinkedListHT. In each case the comment 
 inserted in the method describes its purpose. 
 */
import java.util.*;
public class Assignment4_2019 {
  public static void main(String[] args) {
    //Test code here=========================================
	  LinkedListHT linkList = new LinkedListHT();
	  LinkedListHT linkList2 = new LinkedListHT();
	  //add data to both linked lists
	  linkList.addTail(1);
	  linkList.addHead(2);
	  linkList.addHead(7);
	  linkList.addHead(3);
	  linkList.addHead(7);
	  linkList.addHead(4);
	  linkList.addHead(5);
	  linkList.addHead(7);
	  linkList.addHead(6);
	  linkList.addHead(7);
	  linkList.addTail(0);
	  linkList2.addTail(10);
	  linkList2.addHead(20);
	  linkList2.addHead(30);
	  linkList2.addHead(40);
	  linkList2.addHead(50);
	  linkList2.addHead(60);
	  
	  //print out both linked lists to begin with
	  System.out.println("First linked list: " + linkList);
	  System.out.println("Second linked list: " + linkList2);
	  
	  //count how many 7s appear in the first linked list
	  System.out.println("Amount of 7s in list: " + linkList.count(7));
	  
	  //add all the numbers together in the first linked list
	  System.out.println("Addition of all elements in list: " + linkList.sum());
	  
	  //delete the number at the tale of the first linked list
	  linkList.delTail();
	  
	  //delete the number at the head of the first linked list
	  linkList.delHead();	 
	  
	  //print out the first linked list again to show head and tail removed
	  System.out.println("List once head and tail have been deleted: " + linkList);
	  
	  //get amount of integers in the first linked list
	  System.out.println("Amount of elements in list: " + linkList.size());
	  
	  //remove all 7s that appear in the first linked list
	  linkList.delAll(7);	  
	  
	  //print out the first linked list again to show 7s removed
	  System.out.println("Elements in list when all 7s removed: " + linkList);
	  
	  //add together all even numbers in the first linked list
	  System.out.println("Addition of all even numbers in list: " + linkList.sumEven());
	  
	  //add the second linked list to the first linked list
	  linkList.addTail(linkList2);
	  
	  //print out the first linked list again to show the second linked list has been added
	  System.out.println("List with second list added to the tail: " + linkList);
	  
	  //add the first linked list to an array the same size as the first linked list
	  int[] array = linkList.toArray();
	  System.out.print("List turned into array: ");
	  //print out the array
	  for(int i = 0; i < linkList.size(); i++)
	  {
		  if(i == linkList.size() - 1)
			  System.out.println(array[i]);
		  System.out.print(array[i]+ ", ");
	  }
	  
	  //reverse the first linked list
	  linkList.reverse();
	  
	  //print out the reverse of the first linked list
	  System.out.println("List after it has been reversed: " + linkList);
	  
	  //compare if the first linked list is the same as the second linked list
	  System.out.println("Check is 2 lists are equal: " + linkList.equals(linkList2));
    
    //======================================================
  }
}
class LinkedListHT{
	private Node head = null; 
	private Node tail = null; 
	//empty list
	public void addTail(int x){ //add at head
		Node nw = new Node(x);
		if(head == null){
			head = nw; tail = nw;
		}
		else{
	    tail.setNext(nw);
		  tail = nw;
		}
	}

  
	public void addHead(int x){
  	//insert x at head of list
		Node node = new Node(x);
		//if head is null, nothing in linked list so both head and tail are same int
		if(head == null){
			head = node; tail = node;
		}
		//if head is not null, set head to new integer
		else {
			node.setNext(head);
			head = node;
		}
	}
  
	public void delTail(){
	//remove element at tail of list
		//if there is only one element in linked list, need to set head to null
		if(head == tail)
		{
			head = null;
		}
		else
		{			
			Node node = head;
			//go to the second last number in list of elements
			while(node.next.next != null)
			{
				//keep going until second last number hit
				node = node.next;
			}
			//remove element from tail of list
			node.next = null;
		}
		
	}
 
	public int size(){
		//return number of nodes in the list
		
		//counts number of elements in list 
		int count = 0;
		Node node = head;

		while(node != null)
		{
			//increase count
			count++;
			//go to next node until no nodes left in list
			node = node.next;
		}
		//return amount of elements in list
		return count;
	}
	
	public void delHead(){
    //remove element at head of list
		//if no element in head then nothing to delete
		if(head == null)
		{
			return;
		}
		else
		{
			Node node = head;
			//change head to the next element and delete the last
			head = node.next;
		}
	}
	
	public void delAll(int x){
	//delete all occurrences of x from the list
		Node node = new Node(0);
		node.next = head;
	    Node cur = node;
	    //go through each element in list
	    while (cur.next != null) 
	    {
	    	//check data in each element and if equal to number inputted, delete instance
	        if (cur.next.data() == x)
	        {
	        	cur.next = cur.next.next;
	        } 
	        //otherwise keep going through the elements
	        else 
	        {
	        	cur = cur.next;
	        }
	    }
	    //change the head
	    head = node.next;
	}
	
	public int sum(){
		//calculate sum of values in the list
		//variable to add all elements together
		int add = 0;
		Node node = head;
		while(node != null)
		{
			//add elements together
			add += node.data();
			node = node.next;
		}
		return add;
	}
	
	public int sumEven(){
		//calculate sum of even values in the list
		int count = 0;
		Node node = head;
		while(node != null)
		{
			//check if elements are even
			if(node.data() % 2 == 0) {
				//if even add together
				count += node.data();
				//go to next element
				node = node.next;
			}
			//otherwise go to next element
			else
				node = node.next;
		}
		return count;
	}
	
	public int count(int x){
		//count number of occurrences of x in list
		Node node = head;
	    int count = 0;
	    while (node != null) {
	    	//check if element in list is same as parameter
	        if (node.data() == x) {
	        	//if it is then the amount increases
	        	count++;
	        	//go to next element
	        	node = node.next;
	        } 
	        //otherwise just go to the next element
	        else {
	        	node = node.next;
	        }
	    }
	    return count;
	}
	
	public void addTail(LinkedListHT lst){
    	//add given list to tail of existing list
		
		Node node1 = head;
		Node node2 = lst.head;
		//go to the end of the list
		while(node1.next != null)
		{
			node1 = node1.next;
		}
		//while there are elements in second list
		while(node2 != null)
		{
			//set next node
			node1.setNext(node2);
			//go to next element in second list
			node2 = node2.next;
			//go to next spot in first list
			node1 = node1.next;
		}
	} 
	
	public int[] toArray(){
    //return int array of list values
		int llSize = size();
		Node node = head;
		//array the same size as the list
		int[] arr = new int[llSize];
		for(int i = 0; i < llSize; i++)
		{
			//add the element to array index i
			arr[i] = node.data;
			//continue to next element
			node = node.next;
		}
		return arr;
	}
	
	public void reverse(){
		//reverse the order of the lements in the list
		Node node = head;
		Node prevNode = null;
		Node nextNode = null;
		while(node != null)
		{
			//store next node
			nextNode = node.next;
			//set the next node with previous node that has been stored
			node.next = prevNode;
			//store the current node
			prevNode = node;
			//set the current node to next node
			node = nextNode;
		}
		//once the list is reversed, have head equal to correct element
		head = prevNode;
	}
	
	public boolean equals(Object ob){
	  // method to test this list with another list for equality
	  // Two lists equal if they have the same size and corresponding 
	  // values are equal
		//check that the object is a linkedlist
		if(!(ob instanceof LinkedListHT))
		{
			return false;
		}
		//create list from object
		LinkedListHT t1 = (LinkedListHT)ob;
		//get the size of list
		int n = size();
		//compare the sizes of both lists, if they aren't the same it automatically means the lists aren't equal
		if(n == t1.size())
		{
			Node node1 = head;
			Node node2 = t1.head;
			//compare until the end of the list
			while(node1 != null)
			{
				//if an element of first list is not the same as second, end method
				if(node1.data != node2.data)
				{
					return false;
				}
				//otherwise continue through the lists until all elements compared
				node1 = node1.next;
				node2 = node2.next;
			}
			//if all elements are same return true
			return true;
		}
		//if 2 lists are not the same size, return false
		else
		{
			return false;
		}
	}
	
	public boolean contains(int x){
		Node k = head;
		boolean found = false;
		while(k != null && !found){
			if(k.data() == x) found = true;
			else k = k.next();
		}
		return found;
	}
	
	public void remove(int x){
		Node k = head; Node bk = head;
		boolean found = false;
		while(k != null && !found){
			if(k.data() == x) found = true;
			else{ bk = k; k = k.next();}
		}
		if(found){
			if(k == head)
				head = k.next();
			else if(k == tail){
			   bk.setNext(null);
			   tail = bk;
			}
			else
				bk.setNext(k.next());
		}
	}
	
	public String toString(){
		if(head == null) return "[]";
		String s = "[";
		Node k = head;
		while(k.next() != null){
			s = s + k.data()+", ";
			k = k.next();
		}
		s = s + k.data()+"]";
		return s;
	}
	private class Node{
		int data;
		Node next;
		public Node(int x){
			data = x; next = null;
		}
		public Node next(){return next;}
		public void setNext(Node p){
			next = p;
		}
		public void set(int x){data = x;}
		public int data(){return data;}
	}
}

