//Sarah Brennan 2962279
public class Question2 {

	
	public int factorial(int a)
	{
		int factorial = 1;
		//for loop to multiply the number given by each number below that number
		for(int k = 1; k <= a; k++)
		{
			factorial = factorial * k;
		}
		//return a value for factorial
		return factorial;
	}
	
	public int power(int a, int b)
	{
		//for loop to multiply a by itself b times
		int power = 1;
		for(int k = 1; k <= b; k++)
		{
			power = power * a;
		}
		//return a value for power
		return power;
	}
	
	public int linearSearch(int [] a, int n, int q)
	{
		int i = 0;
		//make sure that index is within the array
		while(i < n)
		{
			//check if the index has reached array end
			if(i == n && a[i] != q)
				return -1;
			//if the item being searched is in the array, return the position 
			else if(a[i] == q)
			{
				return i+1;
			}
			//otherwise just continue to next item in array
			else
				i++;
		}
		//if the index is greater than the array, return not found
		return -1;
	}
}
