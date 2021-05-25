/**
 * @(#)Assignment03.java
 *
 *
 * @author Sarah Brennan 2962279
 * @version 1.00
 */


public class Assignment03 {

	public static void main(String[]args)
	{
		Assignment03 a3 = new Assignment03();

	    //System.out.print("Before: ");		printArray(arr);
     	a3.testSpeed(10);
     	//System.out.print("After: ");		

		//printArray(arr);
     	a3.testSpeed(99);
		//System.out.print("After: ");		printArray(arr);

		//printArray(arr);
     	a3.testSpeed(100);
     	//System.out.print("After: ");		printArray(arr);

		//printArray(arr);
     	a3.testSpeed(101);
		//System.out.print("After: ");		printArray(arr);

		//printArray(arr);
     	a3.testSpeed(500);
		//System.out.print("After: ");		printArray(arr);
     	
     	a3.testSpeed(5000);
	}

	void testSpeed(int size)
	{
		double[] arr = createArray(size);
		long start = System.nanoTime();
		mergeInsertSort(arr,0,arr.length);
		long end = System.nanoTime();
		long timeToRun = end-start;
		System.out.println("Time in nanoseconds for array size "+size+": "+timeToRun);

		checkSort(arr); // If array is not sorted it will print an error
		//if (arr.length<102)	printArray(arr);
	}

	public double[] createArray(int numElements)
	{
		double[] myArray = new double[numElements];
	    for(int i=0;i<numElements;i++){
		    myArray[i] = Math.random()*100;
		}
		return myArray;
	}

	public double[] checkSort(double[] arr)
	{
		//if (arr.length<102)	printArray(arr);
	    for(int i=0; i<arr.length-1; i++){
		    if (arr[i] > arr[i+1])
		    {
		    	/*for(int j=0; j<arr.length; j++){
		    		if (j==i)System.out.print("###");
		    		if (j==i+2)System.out.print("###");
		    		System.out.print(arr[j] + " ");
		    	}*/
		    	System.out.println();
		    	System.out.println();
		    	System.out.printf("!!!!! Array is not sorted, value at index %d is bigger than the next value\n", i);
		    	System.out.println();
		    	break;
		    }
		}
		return arr;
	}

	public void printArray(double[] myArray)
	{
		for(int j=0;j<myArray.length;j++){
			System.out.print(myArray[j]+" ");
		}
		System.out.println();
	}
	
	//combination of merge and insertion sort
	public void mergeInsertSort(double[] arr, int lb, int ub) {
		// implement code here
		//checks size of array, if less than or equal to 100 will do insertion sort
		if(ub - lb <= 100)
		{
			insertSort(arr, lb, arr.length);
		}
		
		//otherwise will do merge sort until array is smaller than 101
		else
		{
			int mid = (lb + ub)/2;
			//merge splits the array in 2 until the array size is 100 or less
			mergeInsertSort(arr, lb, mid);
			mergeInsertSort(arr, mid, ub);
			//call merge method
			merge(arr, lb, mid, ub);
			
		}
		
	}

	//merge sort splits the array into two separate arrays until the array size is >= 100
	public void merge(double[] arr, int lo, int mid, int hi) {
		//implement code here
		int i = lo;
		int j = mid;
		
		//get the mid size of array
		double temp[] = new double[hi - lo];
		int t = 0;
		
		while(i < mid && j < hi)
		{
			//compare items in array and swap if item at i > j
			if(arr[i] <= arr[j])
			{
				temp[t] = arr[i];
				i++;
				t++;
			}
			else
			{
				temp[t] = arr[j];
				j++;
				t++;
			}		
		}
		
		while(i < mid)
		{
			temp[t] = arr[i];
			i++;
			t++;
		}
		
		while(j < hi)
		{
			temp[t] = arr[j];
			j++;
			t++;
		}
		
		i = lo;
		t = 0;
		
		while (t < temp.length)
		{
			arr[i] = temp[t];
			i++;
			t++;
		}
	}

	//compares the next item in array with previous items, if bigger, stays the same, if smaller inserts before each item it is smaller than
	public void insertSort(double[] arr, int start, int end) {
		// implement code here
		int j = start + 1;
		while(j < end)
		{
			int i = j;
			while(i > 0 && arr[i] < arr[i-1])
			{
				double temp = arr[i];
				arr[i] = arr[i-1];
				arr[i-1] = temp;
				i--;
			}
			j++;
		}
	}
}