/*
Code by  : Shahid Dhariwala
LinkedIn : https://www.linkedin.com/in/shahiddhariwala/
Twitter  : https://twitter.com/shahiddhariwala
*/
package divideAndConquer;

public class DNC_Longest_Common_Subsequence
{
	public static int getLCS(String s1, String s2, int index1,int index2)
	{
		if(index1>=s1.length() || index2>=s2.length())
		{
			return 0;
		}
		else
		{
			int cost1=0;
			if(s1.charAt(index1)==s2.charAt(index2))
			{
				cost1 =1+getLCS(s1, s2, index1+1, index2+1);
			}
			int cost2=getLCS(s1, s2, index1+1, index2);
			int cost3=getLCS(s1, s2, index1, index2+1);
			
			return Math.max(cost1, Math.max(cost2,cost3));
		}
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println("Welcome to Longest Commmon Subsequence Problem");
		String s1="shahid";
		String s2="sidhahid";
		System.out.printf("Longest Common Susbequnce between\n'%s' and '%s' is of %d letters",s1,s2,getLCS(s1,s2,0,0));
	}
}
