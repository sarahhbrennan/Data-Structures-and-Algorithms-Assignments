import java.util.Arrays;

//Sarah Brennan 2962279
public class Question4 {

	static void fibSequence(int i, int n, int f[])
	{
		//end sequence
		if(i == n)
			return;
		//if index is 0 or 1, the number is always 1
		if(i == 0 || i == 1)
		{
			f[i] = 1;
		}
		//otherwise add the previous 2 numbers together
		else
		{
			f[i] = f[i-1] + f[i-2];
		}
		//continue through sequence
		fibSequence(i+1, n, f);
	}
	
	//main method
	public static void main(String[] args) {
		int[] fibNum = new int[10];		
		fibSequence(0,10,fibNum);
		System.out.println(Arrays.toString(fibNum));
	}
}
