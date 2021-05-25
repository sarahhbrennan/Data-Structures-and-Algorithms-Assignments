/*
 * Assignment 08
 *
 * Name:
 * Student Number:
 *
 */

import java.io.*;
import java.util.*;
import java.util.function.Predicate;
class BinarySearchTree<E extends Comparable<E>> implements Iterable<E>{
	private BNode<E> root;
	private int count;

	public BinarySearchTree(){
		root = null;
		count = 0;
	}
	public BinarySearchTree(Collection <? extends E> ls){
		root = null;
		count = 0;
		for(E x : ls) {
			this.add(x);
		}
	}
	public void add(E x){
	  root = add(root,x);
	}
	private BNode<E> add(BNode<E> rt, E x){
		if(x == null)
			return rt; //do not allow null values

		if(rt == null){
			count++;
			return new BNode<E>(x);
		}
		else if(x.compareTo(rt.data()) < 0){
			BNode<E> p = add(rt.left(), x);
			rt.setLeft(p);
			return rt;
		}
		else if(x.compareTo(rt.data()) > 0){
			BNode<E> p = add(rt.right(), x);
			rt.setRight(p);
			return rt;
		}
		else // x already present, so no change
			return rt;
	}

	public boolean contains(E x){
		return contains(root, x);
	}

	private boolean contains(BNode<E> rt, E x){
		if(rt == null)
			return false;
		else{
			if(rt.data().equals(x)) return true;
			else if(x.compareTo(rt.data()) < 0)
				return contains(rt.left(),x);
			else
				return contains(rt.right(), x);
		}
	}

	public int size(){
		return count;
	}

	public void remove(E x){
		BNode<E> ptr = null; BNode<E> parentPtr = null;
		if(root != null){
			ptr = root; parentPtr = root;
			boolean found = false;
			while(ptr != null && !found){
				if(ptr.data().equals(x))
					found = true;
				else{
					parentPtr = ptr;
					if(x.compareTo(ptr.data()) < 0)
						ptr = ptr.left();
					else
						ptr = ptr.right();
				}
			}
			if(found){
				count--;
				if(ptr == root){
					root = removeNode(root);
				}
				else{
					if(x.compareTo(parentPtr.data()) < 0){
						BNode<E> n = removeNode(parentPtr.left());
						parentPtr.setLeft(n);
					}
					else{
						BNode<E> n = removeNode(parentPtr.right());
						parentPtr.setRight(n);
					}
				}
			}
		}
	}

	private BNode<E> removeNode(BNode<E> rt){
		if(rt == null)
			return null;
		else if (rt.left() == null && rt.right() == null)
			return null;
		else if(rt.left() == null)
			return rt.right();
		else if(rt.right() == null){
			return rt.left();
		}
		else{
			BNode<E> ptr = rt.left();
			BNode<E> parentPtr = null;
			while(ptr.right() != null){
				parentPtr = ptr;
				ptr = ptr.right();
			}
			rt.set(ptr.data());
			if(parentPtr == null)
				rt.setLeft(ptr.left());
			else
				parentPtr.setRight(ptr.left());
			return rt;
		}
	}

	public int height(){
		return height(root);
	}

	private int height(BNode<E> rt){
		if(rt == null) return -1;
		else{
			return 1 + max(height(rt.left()),height(rt.right()));
		}
	}

	private int max(int a,int b){
		return a >= b? a:b;
	}

	public ArrayList<E> inOrder(){
		ArrayList<E> lst = new ArrayList<E>();
		inOrder(root,lst);
		return lst;
	}

	private void inOrder(BNode<E> rt, ArrayList<E> lst){
		if(rt != null){
			inOrder(rt.left(), lst);
			lst.add(rt.data());
			inOrder(rt.right(),lst);
		}
	}

	public ArrayList<E> preOrder(){
		ArrayList<E> lst = new ArrayList<E>();
		preOrder(root,lst);
		return lst;
	}

	private void preOrder(BNode<E> rt, ArrayList<E> lst){
		if(rt != null){
			lst.add(rt.data());
			preOrder(rt.left(), lst);
			preOrder(rt.right(),lst);
		 }
	}

	public ArrayList<E> postOrder(){
		ArrayList<E> lst = new ArrayList<E>();
		postOrder(root,lst);
		return lst;
	}

	private void postOrder(BNode<E> rt, ArrayList<E> lst){
		if(rt != null){
			postOrder(rt.left(), lst);
			postOrder(rt.right(),lst);
			lst.add(rt.data());
		 }
	}
	
	/*
	 * 
	 * Question 2
	 * 
	 */
	
	public E maxElement()
	{
		E max;
		BNode<E> node = root.right();
		//loops stops once the farthest right element is reached
		while(node.right() != null)
		{
			//if not at farthest right, go to the next element in right
			node = node.right();
		}
		//max is farthest right element
		max = node.data();
		return max;
	}
	
	public ArrayList<E> leafNodes()
	{
		//check if there is root
		if(root == null)
		{
			return null;
		}
		//create new list to return
		ArrayList<E> leaves = new ArrayList<E>();
		//create stack to put elements into
		Stack<BNode<E>> stack = new Stack<>();
		//add root into stack
		stack.push(root);
		while(!stack.isEmpty())
		{
			//get element in stack
			BNode<E> node = stack.pop();
			//check if it's leaf node
			if(node.right() == null && node.left() == null)
			{
				leaves.add(node.data());
			}
			//if there are elements farther along in tree, go to these elements until no more children after element
			if(node.right() != null)
			{
				stack.add(node.right());
			}
			if(node.left() != null)
			{
				stack.add(node.left());
			}
		}
		return leaves;	
	}

	public List<E> get(Predicate<E> pr)
	{
		List<E> tmp = new LinkedList<>();
		//iterate through tree 
		for(E x : this)
		{
			//check the test that is in the main method
			if(pr.test(x))
			//add elements that are true to test into list to be returned
			tmp.add(x);
		}
		return tmp;		
	}
	
	/*
	 * 
	 * End of Question 2
	 * 
	 */

	public Iterator<E> iterator(){
		ArrayList<E> ls = this.inOrder();
		return ls.iterator();
	}
	public String toString(){
		return this.inOrder().toString();
	}

	private class BNode<E extends Comparable<E>>{
	 	private E data;
	 	private BNode<E> left;
		private BNode<E> right;

		public BNode(E d){
			data = d;
			left = null;
			right = null;
		}

		public E data(){
			return data;
		}

		public void set(E x){
			data = x;
		}

		public BNode<E> left(){
			return left;
		}

		public BNode<E> right(){
			return right;
		}

		public void setLeft(BNode<E> k){
			left = k;
		}

		public void setRight(BNode<E> k){
			right =k;
		}
	}

}
