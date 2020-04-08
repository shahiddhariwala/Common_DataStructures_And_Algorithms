/*
Code by  : Shahid Dhariwala
LinkedIn : https://www.linkedin.com/in/shahiddhariwala/
Twitter  : https://twitter.com/shahiddhariwala
*/
package divideAndConquer;

public class DNC_Longest_Palindromic_Subsequence
{
	public static int getLPS(String str, int startindex, int endIndex)
	{
		// base case
		if (startindex > endIndex)
			return 0;
		else if (startindex == endIndex)
		{
			// single character is palindrome itself
			return 1;
		}
		// 3 option
		// if same +2 s+1 and e-1
		// if not same s+1,e or s,e-1
		int len3 = 0;
		if (str.charAt(startindex) == str.charAt(endIndex))
		{
			len3 = 2 + getLPS(str, startindex + 1, endIndex - 1);
		}
		int len1 = getLPS(str, startindex + 1, endIndex);
		int len2 = getLPS(str, startindex, endIndex - 1);
		return Math.max(len3, Math.max(len1, len2));
	}

	public static void main(String[] args)
	{
		System.out.println("====Welcome to Longest palindromic Subsequence Problem====");
		String str = "ELRMENMET";
		System.out.println("String is " + str);
		System.out.println("Length of Longest Palindromic Subsequence is => " + getLPS(str, 0, str.length() - 1));
	}
}
