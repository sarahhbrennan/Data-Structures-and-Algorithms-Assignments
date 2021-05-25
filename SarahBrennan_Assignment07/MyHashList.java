/**
 * student name: Sarah Brennan
 * student number: 2962279
 */
import java.util.*;
import java.util.function.*;
class MyHashList<E> implements Iterable<E>{
	private ArrayList<LinkedList<E>> table;

	public MyHashList(int n){
		// n = the number of lists to create -
		// it does NOT limit the number of elements in the table
		table = new ArrayList<>();
		for(int j = 0; j < n; j++)
			table.add(new LinkedList<>());
	}

	private int hashC(E x){
		int k = x.hashCode();
		//an alternative is to mask the minus using
		//int k = x.hashCode() & 0x7fffffff;
		int h = Math.abs(k % table.size());
		return(h);
	}

	public void add(E x){
		int index = hashC(x);
		table.get(index).addFirst(x);
	}

	public boolean contains(E x){
		int index = hashC(x);
		return(table.get(index).contains(x));
	}

	public boolean remove(E x){
		int index = hashC(x);
		return table.get(index).remove(x);
	}

	public int size(){
		int count = 0;
		for(int j = 0; j < table.size();j++) {
			count += table.get(j).size();
		}
		return count;
	}

	// Assignment Methods Start

	public LinkedList<E> getList(E x) {
		 //Insert code here
		//create list to return
		LinkedList<E> list = new LinkedList<E>();
		//this iterates through the table
		for (E p : this)
		{
			//compare hashcodes
			if(x.hashCode() == p.hashCode())
			{
				//add elements with same hashcode to list to be returned
				list.add(p);
			}
		}
		return list;
	}

	public void remove(List<E> ls) {
		 //Insert code here
		//iterate through table
		for(E x : this)
		{
			//iterate through list in parameter
			for(E y : ls)
			{
				//check if elements are the same
				if(x == y)
				{
					int index = hashC(x);
					//remove elements if they are the same
					table.get(index).remove(y);
				}
			}
		}
		
	}

	List<E> get(Predicate<E> pr) {
		// insert code here
		//create list of elements to be returned
		List<E> tmp = new LinkedList<>();
		//iterate through table 
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
	 * Created percentUsed, largestBucket, smallestBucket, listSizes and empty for Question 1
	 * */
	public double percentUsed()
	{
		int count = 0;
		for(int i = 0; i < table.size(); i++)
		{
			if(table.get(i).size() > 0)
				count ++;
		}
		double p = count * 100/table.size();
		return p;
	}
	
	public int largestBucket(){
		int max = 0;
		for(int j = 0; j < table.size(); j++)
			if(table.get(j).size() > max) 
				max = table.get(j).size();
		return max;
	}

	public int smallestBucket(){
		int min = table.get(0).size();
		for(int j = 1; j < table.size(); j++)
			if(table.get(j).size() < min) 
				min = table.get(j).size();
		return min;
	}

	public int[] listSizes(){
		int n = largestBucket();
		int d[] = new int[n+1];
		for(int j = 0; j < d.length; j++) d[j] = 0;
		for(int j = 0; j < table.size(); j++){
			int m = table.get(j).size();
			d[m] = d[m] + 1;
		}return d;
	}
	
	public int empty(){
		int count = 0;
		for(int j = 0; j < table.size(); j++)
			if(table.get(j).size() == 0) count++;
		return count;
	}



	// Assignment Methods End

	public Iterator<E> iterator(){
		ArrayList<E> items = new ArrayList<E>();
		int ind = 0;
		while(ind < table.size()){
			Iterator<E> it = table.get(ind).iterator();
			while(it.hasNext()) items.add(it.next());
			ind++;
		}
		return items.iterator();
	}

	public String toString(){
		return table.toString();
	}
}