/*
Code by  : Shahid Dhariwala
LinkedIn : https://www.linkedin.com/in/shahiddhariwala/
Twitter  : https://twitter.com/shahiddhariwala
*/
package hashingAndAlgos;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;

public class DirectChainingHashing
{
	LinkedList<String>[] hashTable;

	public DirectChainingHashing(int size)
	{
		hashTable = new LinkedList[size + 1];
		// initialise the hashtable
	}

	//hashing function
	private int getHashValue(String word,int size)
	{
		char[] arr = word.toCharArray();
		int sum=0;
		for(char c : arr)
			sum+= c ;
		
		return sum%size;
		
	}
	//print hashtable
	private void printHashTable()
	{
		System.out.println("\n==============Printing Hash Table=============");
		System.out.printf("Word%-16s\tLoc\tNode\n","");
		for(int i=0;i<hashTable.length;i++)
		{
			if(hashTable[i]!=null)
			{
				int chainCount=1;
				for(String s : hashTable[i])
				{
					//System.out.println(s+" at location =>"+i+" Node : "+chainCount);
					System.out.printf("%-20s\t%d\t%d\n",s,i,chainCount++);
				}
			}
		}
	}

	//insert Word
	private void insertWord(String word)
	{
		int hashValue = getHashValue(word,hashTable.length);
		if(hashTable[hashValue] == null)
		{
			//System.out.println("Found Empty Space in HashTable at "+hashValue+" inserting....");
			hashTable[hashValue]=new LinkedList<String>();
			hashTable[hashValue].add(word);
			System.out.println(word+" Inserted succesfully :))) ");
		}
		else
		{
			System.out.printf("Collision Ocurred ");
			System.out.println("Making chain at "+hashValue);
			hashTable[hashValue].add(word);
			System.out.println(word+" Inserted succesfully :') ");
		}
	}
	//delete word
	private void deleteWord(String word)
	{
		int hashValue = getHashValue(word,hashTable.length);
		if(hashTable[hashValue] == null)
		{
			System.out.println("No such word in hash 1");
			return;
		}
		else
		{
			if(!hashTable[hashValue].contains(word))
			{
				System.out.println("No such word in hash & chains");
				return;
			}
			
			System.out.println("Word Found In Hash Table");
			hashTable[hashValue].remove(word);
			System.out.println("Word Deleted from Hash Table");
			System.out.println("Table Updated");
			this.printHashTable();
		}
	}
	
	
	public static void main(String[] args) throws IOException
	{
		System.out.println("Welcome to Direct Chaining ");
		int size=10;
		DirectChainingHashing dc = new DirectChainingHashing(size);
		//dc.printHashTable();
		//System.out.println(dc.getHashValue("Shahid",size));
		dc.insertWord("Shahid");
		dc.insertWord("Shahid123");
		dc.insertWord("World");
		dc.insertWord("row");
		dc.insertWord("POwor");
		dc.printHashTable();	
		dc.deleteWord("wor");
		
			
	}
}