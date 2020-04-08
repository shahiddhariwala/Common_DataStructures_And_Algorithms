/*
Code by  : Shahid Dhariwala
LinkedIn : https://www.linkedin.com/in/shahiddhariwala/
Twitter  : https://twitter.com/shahiddhariwala
*/
package divideAndConquer;

public class DNC_Fibonacci
{
	public  static int getFibonacci(int n)
	{
		if(n==0)
			return 0;
		else if(n==1)
			return 1;
		else 
			return getFibonacci(n-1)+getFibonacci(n-2);
	}
	public static void main(String[] args) {
		
		long startTime = System.nanoTime()/1000;
		for (int i = 0; i < 15; i++)
		{
			int num = i;
			System.out.println("Fibonacci Number at Position " + (num + 1) + " is " + getFibonacci(num));
		}
		long endTime = System.nanoTime()/1000;
		System.out.println("Time taken to exceute is "+(endTime-startTime)+"  micro  seconds");
		
	}
}
