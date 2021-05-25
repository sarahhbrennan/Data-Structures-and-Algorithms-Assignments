//Sarah Brennan 2962279
public class Question3 {

	static void binary(int dec)
	{
		//if decimal is 0, binary will be 0
		if(dec < 0)
		{
			System.out.println(0);
		}
		//get binary of decimal
		else if(dec > 0)
		{
			binary(dec/2);
			System.out.print(dec%2);
		}
	}
	
	//main method
	public static void main(String[] args) {
		int decimal = 10;
		binary(decimal);
		System.out.println();
	}
}

