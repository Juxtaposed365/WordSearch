import java.util.Arrays;
//This program will search a matrix for words and tell you which words
// were found

//By: Aaja Christie
public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("Test Reverse: ____________________________________");
//		String s = "apple";
//		String t = reverse(s);
//		for(int i = 0; i < t.length(); i++) {
//			System.out.println(t.charAt(i));
//		}
//		
//		System.out.println("Test Sort: _______________________________________");
//		String[] words = {"hi", "hello", "dog", "cat", "catty", "doggy", "doggo"};
//		Arrays.sort(words);
//		System.out.println(Arrays.toString(words));
		
		//System.out.println("Test Matrix: _____________________________________");
		char[][] wordSearch = {{'h','y','b','b','k','l'},{'e','t','c','a','t','a'},
		{'l','t','y','i','h','b'},{'l','a','d','o','g','o'},{'k','c','b','h','b','r'}, {'h', 'a', 'p','p','y','p'}};
		//printMatrix(wordSearch);
		System.out.println("Matrix: ___________________________________________");
		for(int i = 0; i < wordSearch[0].length; i++) {
			for(int j = 0; j < wordSearch[0].length; j++) {
				System.out.print(wordSearch[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("Test findWords: ___________________________________");
		String[] list = {"catty", "cat", "dog", "hello", "kayak", "hi", "boy", "yob", "ayak", "labor", "happy"};
		
		findWords(wordSearch, list);

	}
	
	public static void findWords(char[][] matrix, String[] words) {
		Arrays.sort(words);
		//going through the list of words
		for(int i = words.length - 1; i >= 0; i--) {
			if(traverse(matrix, words[i])==true) {
				System.out.println(words[i] + " Was Found");
			}else {
				System.out.println(words[i] + " Was NOT Found");
			}
		}
	}
	public static boolean traverse(char[][] matrix, String word) {
		//searching the matrix
		String backwards = reverse(word);
		String forwards = word;
		for(int i = 0; i < matrix[0].length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] == forwards.charAt(0)) {
					//If there isn't enough room don't check
					if ((matrix.length - j) >= forwards.length()) {
						//check right
						if(checkRight(matrix, forwards, i, j) == true)
							return true;
					}
					
					if ((matrix.length - i) >= forwards.length()) {
						//check down
						if(checkDown(matrix, forwards, i, j) == true)
							return true;
					}
					
					if((matrix.length - i) >= forwards.length() && (matrix.length - j) >= forwards.length()) {
						//check down diagonal right 
						if(checkDiagonalRight(matrix, forwards, i, j) == true)
							return true;
					}
					
					if((matrix.length - i) >= forwards.length() && j+1 >= forwards.length()) {
						//check down diagonal left 
						if(checkDiagonalLeft(matrix, forwards, i, j))
							return true;
					}
				}
				
				if(matrix[i][j] == backwards.charAt(0)) {
					//If there isn't enough room don't check
					if ((matrix.length - j) >= backwards.length()) {
						//check right
						if(checkRight(matrix, backwards, i, j) == true)
							return true;
					}
					
					if ((matrix.length - i) >= backwards.length()) {
						//check down
						if(checkDown(matrix, backwards, i, j))
							return true;
					}
					
					if((matrix.length - i) >= backwards.length() && (matrix.length - j) >= backwards.length()) {
						//check down diagonal right 
						if(checkDiagonalRight(matrix, backwards, i, j))
							return true;
					}
					
					if((matrix.length - i) >= backwards.length() && j+1 >= backwards.length()) {
						
						//check down diagonal left 
						if(checkDiagonalLeft(matrix, backwards, i, j))
							return true;
					}
				}
			}
		}
		return false;
	}
	//helper methods for searching
	public static boolean checkDown(char[][] matrix, String word, int a, int b) {
		int i = a + 1; 
		int j = b;
		for(int x = 1; x < word.length(); x++) {
				if(word.charAt(x) != matrix[i][j]) {
					return false;
				}
				i++;
		}
		return true;
	}
	
	public static boolean checkRight(char[][] matrix, String word, int a, int b) {
		int i = a; 
		int j = b + 1;
		for(int x = 1; x < word.length(); x++) {
				if(word.charAt(x) != matrix[i][j]) {
					return false;
				}
				j++;
		}
		return true;
	}
	
	public static boolean checkDiagonalLeft(char[][] matrix, String word, int a, int b) {
		int i = a + 1; 
		int j = b - 1;
		for(int x = 1; x < word.length(); x++) {
				if(word.charAt(x) != matrix[i][j]) {
					return false;
				}
				j--;
				i++;
		}
		return true;
	}
	
	public static boolean checkDiagonalRight(char[][] matrix, String word, int a, int b) {
		int i = a + 1; 
		int j = b + 1;
		for(int x = 1; x < word.length(); x++) {
				if(word.charAt(x) != matrix[i][j]) {
					return false;
				}
				j++;
				i++;
		}
		return true;
	}
	
	//Reverse a word
	public static String reverse(String str) {
		String newStr = "";
		for(int i =  str.length()-1; i >= 0; i--) {
			newStr += "" +str.charAt(i);
		}
		return newStr;
	}
	//must be n by n (a square) 
	public static void printMatrix(char[][] matrix) {
		for(int i = 0; i < matrix[0].length;i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}

}
