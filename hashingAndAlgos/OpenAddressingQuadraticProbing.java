/*
Code by  : Shahid Dhariwala
LinkedIn : https://www.linkedin.com/in/shahiddhariwala/
Twitter  : https://twitter.com/shahiddhariwala
*/
package hashingAndAlgos;

import java.util.ArrayList;

public class OpenAddressingQuadraticProbing
{
	int noOfCellUsed;
	String hashTable[];

	public OpenAddressingQuadraticProbing(int size)
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
			System.out.printf("\nCollision Occured at %d for '%s' Applying Quadratic probing\n", hashValue,word);
			System.out.print("Checking ==>\n ");
			int i=0;
			while(true) {
				
				int index  = (hashValue + (i*i)) % hashTable.length;
				System.out.printf("for %d + %d^2 index = %d\n ",hashValue,i,index);
				if (hashTable[index] == null)
				{
					hashTable[index] = word;
					System.out.printf("%s Inserted at %d\n", word, index);
					return;
				}
				i++;
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
				System.out.printf("%s not found at %d Searching in Linear Way...\n",word,hashValue);
				for (int i = hashValue + 1; i < hashValue + hashTable.length; i++)
				{
					
					i = i % (hashTable.length);
					System.out.println("Checking " + i);
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
		System.out.println("========Quadratic Probing===========");
		int sizeOfHashTable = 11;
		OpenAddressingQuadraticProbing qh = new OpenAddressingQuadraticProbing(sizeOfHashTable);
		qh.insertWord("Shahid");
		qh.insertWord("Shah");
		qh.insertWord("Shid");
		qh.insertWord("ahid");
		qh.insertWord("Shahid");
		qh.insertWord("Shid");
		qh.insertWord("dZain");
		qh.printTable();
		qh.insertWord("Naruto");
		qh.insertWord("Boruto");
		qh.insertWord("Goku");
		qh.insertWord("Super Shenron");
		qh.deleteWord("ahid");
		qh.printTable();
	}
}
