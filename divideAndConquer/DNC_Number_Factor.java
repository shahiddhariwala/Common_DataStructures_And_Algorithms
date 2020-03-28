package divideAndConquer;

public class DNC_Number_Factor
{
	public static int getNumberFactor(int num)
	{
		if (num == 1 || num == 0 || num == 2)
			return 1;
		else if (num == 3)
			return 2;// {1,1,1,}{3};
		else
		{
			int num1 = getNumberFactor(num-1);
			int num3 = getNumberFactor(num-3);;
			int num4 = getNumberFactor(num-4);
			return num1+num3+num4;
		}
	}

	public static void main(String[] args)
	{
		// Given N. count the number of ways to express N as sum of 1,3, and 4;
		System.out.println("\n=======Welcome To Number Factor Problem====\n");
		int factorArray[] =
		{ 1, 3, 4 };
		int num = 5;
		for(int i=1;i<=10;i++)
			System.out.println("Number of ways to represent "+i+" is " + getNumberFactor(i));
	}
}
