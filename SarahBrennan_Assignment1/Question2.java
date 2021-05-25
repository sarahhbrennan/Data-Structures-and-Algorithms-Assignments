//Sarah Brennan 2962279
public class Question2 {

	//counts amount of times 0 appears in array
	private static int count = 0;
	static int freq(int arr[], int n, int x)
	{
		//check if at end of array and return amount of 0s
		if(n == arr.length)
			return count;
		else
		{
			//check if number in array = 0 and if does, increase counter
			if(arr[n] == x)
			{
				count++;
				return freq(arr, n+1, x);
			}
			//continue through recursion
			else
				return freq(arr, n+1, x);
		}
	}
	
	//main method
	public static void main(String[] args) {
		int arr[] = {0,1,2,3,0,12,10,8,9,6,0,0,0,0};
		System.out.println(freq(arr, 0, 0));
	}
}
