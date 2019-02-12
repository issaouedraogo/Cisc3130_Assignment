						/**
						 * Issa Ouedraogo
						 * Cisc 3130: Data Structure and Algorithm
						 * Prof. Katherine Chuang
						 * Assignment #1
						 */
 /*
 * This program is design to read a text file and check to see
 * if the charathere consisting each word are are Unique 
 * the Program also return the sorted word of each word read
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class UniqChara_Sort {

	public static void main(String[] args) throws FileNotFoundException {
 		
		// local variable;
		String line;
		//creating a File object 
		File dbFile = new File("input.txt");
		// a Scanner Object to move to the 
		Scanner sc = new Scanner(dbFile);
		//Scan through the file until there is not line
		while(sc.hasNext()) {
			line = sc.nextLine();
			// report whether or not s has all unique chars then show the sorted version of s
			System.out.print(isUniqueChar(line)+ " "+ sortWord(line));
			System.out.println();
		}
		sc.close();
	}
	
	/**
	 * Method isUniqueChar()
	 * input: 
	 * * line: String representing the word to check
	 * Process:
	 * * Turn the word into an array of charactheres 
	 * * then match each char with the others 
	 * output
	 * * the boolean variable result is turn to false if identical char is found
	 * * return true is word is Unique char else return false
	 */
	public static boolean isUniqueChar(String line) {
		
		boolean result=true;
		char[] charArray = line.toCharArray();
			
		for (int i = 0;i<charArray.length-1;i++) {
			for(int j=i+1;j<charArray.length;j++) {
				if(charArray[i]==charArray[j]) {
					result = false;
				}
			}
		}
		return result;
		
	}
	/** Method sortWord()
	 * input:
	 * 		line: a String representing of the word
	 * Process:
	 * 		turn the word to lower case 
	 * 		Use the insertSort to sort the word 
	 * 		and return the sorted Word in lower case
	 * Output:
	 * 		return the sorted word in lower case
	 */
	public static String sortWord(String line) {
		// convert the string to lowercase 
		line = line.toLowerCase();
		// then break it into a char array
		char[] c = line.toCharArray();
		// sort c
        insertionSort(c);
        //return the char array as a new String
        return new String(c);
	}
	
	
	/** Method insertionSort()
	 *	input:
	 *		word: an array of charatere 
	 *	Process
	 *		if the array append to be empty then nothing is done
	 *		else take an array of caratere and sort it in the alphabetical order 
	 *		using the insertion technique
	 *	output:
	 *		the array of char is sorted
	*/	
	public static void insertionSort(char[] word) {
        if (word == null || word.length == 0) {
        	return;
        }
            
        for (int i=0; i<word.length; i++) {
            char temp = word[i];
            int j = i;
            while (j>0 && word[j-1]>temp) {
                word[j] = word[j-1];
                j--;
            }
            word[j] = temp;
        }
        return ;
    }

}
