/*
Code by  : Shahid Dhariwala
LinkedIn : https://www.linkedin.com/in/shahiddhariwala/
Twitter  : https://twitter.com/shahiddhariwala
*/
package informationRetrievalSearchTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class DSTrie
{
	private TrieNode root;

	class TrieNode
	{
		boolean endOfWord;
		Map<Character, TrieNode> children;

		public TrieNode()
		{
			children = new HashMap<Character, TrieNode>();
			endOfWord = false;
		}
	}

	// insert a word
	private void insertWord(TrieNode node, String word)
	{
		//
		for (int i = 0; i < word.length(); i++)
		{
			char ch = word.charAt(i);
			TrieNode currentNode = node.children.get(ch);
			if (currentNode == null)
			{
				// if character is not present
				currentNode = new TrieNode();
				node.children.put(ch, currentNode);
			}
			node = currentNode;
		}
		node.endOfWord = true;
		System.out.printf("Word %s Inserted sucesfully", word);
	}

	private void searchNode(TrieNode node, String word)
	{
		// case 1 : There is no value
		if (node == null)
		{
			System.out.println("Trie is empty !!");
			return;
		}
		for (int i = 0; i < word.length(); i++)
		{
			char ch = word.charAt(i);
			TrieNode currentNode = node.children.get(ch);
			if (currentNode == null)
			{
				// case 2 : if after some character match we get no match
				// no match
				System.out.println("Sorry Word Not Found !!!");
				return;
			}
			node = currentNode;
		}
		if (node.endOfWord == true)
		{
			// case 3 : Word exists
			System.out.println("Word Found :: " + word);
		} else
		{
			// case 4: prefix of words exists like BCDE but word was not their actual word
			// present is BCDEK
			System.out.println("Word " + word + " not found");
		}
		return;
	}

	// delete a word from trie
	private boolean deleteWord(TrieNode node, String word, int index)
	{
		// case 1: Some other words has same prefix as this one (BCG,BCD)
		// case 2: Some other words has exact prefix as this word BCDE and BCDEK
		// case 3: Some other word is prefix of this word like BC of BCDE
		// case 4: Nothing is dependent we can delete it
		char ch = word.charAt(index);
		TrieNode currentNode = node.children.get(ch);
		boolean canThisNodeBeDeleted;
		if (currentNode.children.size() > 1)
		{
			System.out.println("Entering Case 1");
			deleteWord(currentNode, word, index + 1);
			return false;
		}
		// check if word has reach its end case 2
		if (index == word.length() - 1)
		{
			System.out.println("Entering case 2");
			if (currentNode.children.size() >= 1)
			{
				// since size can only be greater than or equal 1 when there is some other
				// dependent node
				// on this
				// we can make endOfWord here to false;
				// its is same as removing the word
				currentNode.endOfWord = false;
				return false;
			} else
			{
				System.out.println("Character ch ->" + ch + " has no dependency deleting it from last");
				node.children.remove(ch);
				return true;
				// this true will be foundation for our case 4
			}
		}
		// case 3: check if some nodes endofWord flag is true,
		// if true it means some other word is prefix of our word to be deleted
		if (currentNode.endOfWord == true)
		{
			System.out.println("Entering case 3");
			deleteWord(currentNode, word, index + 1);
			return false;
		}
		// entering case 4
		System.out.println("Entering case 4");
		// case 4 : Nothing is dependent we can delete it,when we receive true
		canThisNodeBeDeleted = deleteWord(currentNode, word, index + 1);
		if (canThisNodeBeDeleted == true)
		{
			System.out.println("Character ch ->" + ch + " has no dependency deleting it");
			node.children.remove(ch);
			// current node can be deleted
			return true;
		} else
		{
			return false;
		}
	}

	// trying to print triee
	private void printTrie(TrieNode node, String str)
	{
		String tillNow = str;
		// There is no value after this
		if (node.endOfWord == true && node.children.size() == 0)
		{
			System.out.println(str);
			return;
		} else
		{
			//if some prefix is a word
			if (node.endOfWord == true)
				System.out.println(str);
			
			// Getting an iterator i
			Iterator hmIterator = node.children.entrySet().iterator();
			// Iterate through the hashmap
			while (hmIterator.hasNext())
			{
				Map.Entry mapElement = (Map.Entry) hmIterator.next();
				char ch = (char) mapElement.getKey();
				// tillNow += ch;
				TrieNode currentNode = (TrieNode) mapElement.getValue();
				printTrie(currentNode, tillNow + ch);
			}
		}
		return;
	}

	public DSTrie()
	{
		root = new TrieNode();
		System.out.println("Trie Created Succesfully");
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader kin = new BufferedReader(new InputStreamReader(System.in));
		DSTrie tt = null;
		int option = 0;
		do
		{
			System.out.println("\n===============Trie===============");
			System.out.println("1. Create Trie");
			System.out.println("2. Insert a Word");
			System.out.println("3. Search a Word");
			System.out.println("4. Delete a Word");
			System.out.println("5. Print Trie");
			System.out.println("6. Delete Trie");
			System.out.println("7. Exit");
			try
			{
				option = Integer.parseInt(kin.readLine());
				switch (option) {
				case 1:
					if (tt == null)
						tt = new DSTrie();
					else
						System.out.println("Trie already exist, try deleting it first");
					break;
				case 2:
					System.out.println("Enter a word to be inserted");
					String wrd = kin.readLine();
					tt.insertWord(tt.root, wrd);
					break;
				case 3:
					System.out.println("Enter a word to search?");
					String srch = kin.readLine();
					tt.searchNode(tt.root, srch);
					break;
				case 4:
					System.out.println("Enter a word to be deleted");
					String del = kin.readLine();
					tt.deleteWord(tt.root, del, 0);
					break;
				case 5:
					tt.printTrie(tt.root, "");
					break;
				case 6:
					tt.root = null;
					tt = null;
					break;
				default:
					System.out.println("Bruh choose right option");
					break;
				}
			} catch (Exception e)
			{
				System.out.println(e);
				option = 333;
			}
		} while (option != 7);
	}
}
