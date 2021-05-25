import java.util.Scanner;

//Sarah Brennan 2962279
public class Question1 {
	
	static void multipleThree(Scanner in)
	{
		//recursion ends
		int sentinel = -1;
		//get numbers from user
		int numIn = in.nextInt();
		//check if number from user is to end program
		if(numIn == sentinel)
			return;
		//check if number entered is multiple of three
		else if(numIn % 3 == 0 && numIn != 0){
			multipleThree(in);
			//once program has ended, print out multiples
			System.out.printf("%3d", numIn);
		}
		//otherwise continue through numbers entered
		else
			multipleThree(in);			
	}
	
	//main method
	public static void main(String[] args) {
		System.out.println("Enter numbers ending at -1");
		Scanner in = new Scanner(System.in);
		multipleThree(in);
	}
}
