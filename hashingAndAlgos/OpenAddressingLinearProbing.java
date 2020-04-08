/*
Code by  : Shahid Dhariwala
LinkedIn : https://www.linkedin.com/in/shahiddhariwala/
Twitter  : https://twitter.com/shahiddhariwala
*/
package hashingAndAlgos;

import java.util.ArrayList;

public class OpenAddressingLinearProbing
{
	int noOfCellUsed;
	String hashTable[];

	public OpenAddressingLinearProbing(int size)
	{
		hashTable = new String[size];
		noOfCellUsed = 0;
	}

	// insertKey
	private void insertWord(String word)
	{
		int loadFactor = this.getLoadFactorPercent();
		if (loadFactor > 75)
		{
			System.out.println("Hash is almost full, rehashing table");
			this.rehashTable(word);
			return;
		} else
		{
			noOfCellUsed++;
			int hashValue = getHashValue(word);
			if (hashTable[hashValue] == null)
			{
				// if hash is empty insert the value
				hashTable[hashValue] = word;
				System.out.printf("%s Inserted at %d\n", word, hashValue);
				return;
			}
			System.out.printf("Collision Occured at %d Applying linear probing\n", hashValue);
			System.out.print("Checking ==> ");
			for (int i = hashValue + 1; i < hashValue + hashTable.length; i++)
			{
				i = i % (hashTable.length);
				System.out.print(" " + i);
				if (hashTable[i] == null)
				{
					hashTable[i] = word;
					System.out.printf("\n%s Inserted at %d\n", word, i);
					return;
				}
			}
		}
	}

	// deleteKey
	private void deleteWord(String word)
	{
		int hashValue = getHashValue(word);
		if (hashTable[hashValue] != null)
		{
			if (hashTable[hashValue].equals(word))
			{
				System.out.printf("%s Found, and Deleted\n", word);
				hashTable[hashValue] = null;
				return;
			} else
			{
				System.out.println("Searching in Linear Probing Way...");
				for (int i = hashValue + 1; i < hashValue + hashTable.length; i++)
				{
					System.out.println("Checking " + i);
					i = i % (hashTable.length);
					if (hashTable[i].equals(word))
					{
						System.out.printf("%s Found, and Deleted\n", word);
						hashTable[i] = null;
						noOfCellUsed--;
						return;
					}
				}
				System.out.println("Word Does Not Exist !!");
			}
		}
	}

	// rehashTabble
	private void rehashTable(String word)
	{
		ArrayList<String> temp = new ArrayList<>();
		
		for (int i = 0; i < hashTable.length; i++)
		{
			if (hashTable[i] != null)
				temp.add(hashTable[i]);
		}
		// reassigning values in hashtable
		hashTable = new String[hashTable.length * 2];
		noOfCellUsed=0;
		System.out.println("Table Size Increased to " + (hashTable.length-1));
		temp.add(word);
		for (String s : temp)
			this.insertWord(s);
		

	}

	// hashing function
	private int getHashValue(String word)
	{
		int size = hashTable.length;
		char[] arr = word.toCharArray();
		int sum = 0;
		for (char c : arr)
			sum += c;
		return sum % size;
	}
	// getLoadfactor

	private int getLoadFactorPercent()
	{
		return (noOfCellUsed * 100) / hashTable.length;
	}

	private void printTable()
	{
		System.out.println("@@@@\tPrinting Hash Table\t@@@@");
		System.out.println("=================================");
		System.out.printf("Location%-16sWord\n", "");
		System.out.println("=================================");
		for (int i = 0; i < hashTable.length; i++)
		{
			if (hashTable[i] != null)
				System.out.printf("%-20d\t%s\n", i, hashTable[i]);
		}
	}

	public static void main(String[] args)
	{
		System.out.println("Welcome to Open Addressing Hashing");
		System.out.println("========Linear Probing===========");
		int sizeOfHashTable = 11;
		OpenAddressingLinearProbing lh = new OpenAddressingLinearProbing(sizeOfHashTable);
		lh.insertWord("Shahid");
		lh.insertWord("Shah");
		lh.insertWord("Shid");
		lh.insertWord("ahid");
		lh.insertWord("Shahid");
		lh.insertWord("Shid");
		lh.insertWord("dZain");
		lh.insertWord("ahid");
		lh.insertWord("Shahid");
		lh.insertWord("Shid");
		lh.insertWord("dZain");
		lh.printTable();
		lh.deleteWord("dZain");
		lh.printTable();
	}
}
