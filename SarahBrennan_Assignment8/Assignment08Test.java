/*
 * Assignment 08
 *
 * Name:
 * Student Number:
 *
 */

import java.io.*;
import java.util.*;
public class Assignment08Test {
	public static void main(String[] args) {
		
		/*
		 * 
		 * Question 1 
		 * 
		 */
		
		System.out.println();
		System.out.println("~~~ Testing Question 1 ~~~");
		//create new words
		Word w1 = new Word("Hello");
		Word w2 = new Word("Goodbye");
		Word w3 = new Word("Of");
		Word w4 = new Word("No");
		Word w5 = new Word("Binary");
		Word w6 = new Word("Search");
		Word w7 = new Word("Tree");
		Word w8 = new Word("Child");
		Word w9 = new Word("Parent");
		Word w10 = new Word("On");
		Word w11 = new Word("Moodle");
		Word w12 = new Word("By");
		Word w13 = new Word("Creating");
		Word w14 = new Word("A");
		Word w15 = new Word("Yes");
		Word w16 = new Word("Word");
		Word w17 = new Word("Values");
		Word w18 = new Word("Class");
		Word w19 = new Word("Given");
		Word w20 = new Word("Defined");
		
		//add words to array to easily add to binarysearchtree
		Word[] word = new Word[] {w1,w2,w3,w4,w5,w6,w7,w8,w9,w10,w11,w12,w13,w14,w15,w16,w17,w18,w19,w20};
		
		//create binarysearchtree		
		BinarySearchTree<Word> bTree = new BinarySearchTree<Word>();
		
		//add words to bTree
		for(Word w:word) {
			bTree.add(w);
		}

		//remove certain word from bTree
		bTree.remove(w14);
				
		//print items in preOrder i.e. root, left sub-tree, right sub-tree.
		System.out.println(bTree.preOrder());

		//print items in inOrder i.e. left sub-tree, root, right sub-tree. This is in alphabetical order
		System.out.println(bTree.inOrder());

		//print items in postOrder i.e. left sub-tree, right sub-tree, root.
		System.out.println(bTree.postOrder());
		
		System.out.println(bTree.height());
		
		//check for certain words in array
		System.out.println(bTree.contains(w14));
		System.out.println(bTree.contains(w13));
		
		//print out array
		System.out.println(bTree.toString());
		
		/*
		 * 
		 * Question 2
		 * 
		 */

		System.out.println();
		System.out.println("~~~ Testing Question 2 ~~~");
		
		//prints out the largest element in bTree
		System.out.println(bTree.maxElement());
		//gets list of leaf nodes
		ArrayList<Word> leafArray = new ArrayList<Word>();
		leafArray = bTree.leafNodes();
		System.out.println(leafArray.toString());
		
		//prints out if item in 
		System.out.println(bTree.get(x-> x.equals(w3)));
		System.out.println(bTree.get(x-> x.equals(w14)));
	}
}