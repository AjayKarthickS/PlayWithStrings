package myPackage;

import java.util.Scanner;

public class PalindromeSubString {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the String");
		char[] str = in.nextLine().toCharArray();
		//char[] str = in.nextLine().toLowerCase().toCharArray();  -- Use this if case insensitive
		printSubStringPalindrome(str);
		in.close();
	}
	private static void printSubStringPalindrome(char[] str){
		int length = str.length;
		for(int l = 1; l <= length;l++){
			for(int start = 0; start < length; start++){
				int end = start + l -1;
				char[] subStr = new char[end - start + 1];
				for(int current = start, x = 0; current <= end && current < length && x < subStr.length; x++,current++){
					subStr[x] = str[current];
				}
				if(isPalindrome(subStr)){
					for(int i = 0; i <subStr.length; i++ ){
						System.out.print(subStr[i]);
					}
					System.out.println();
				}
			}
		}
	}
	private static boolean isPalindrome(char[] subStr){
		int start = 0;
		int end = subStr.length-1;
		int mid = subStr.length / 2;
		for(int i = start, j = end; i <= mid && j >= mid; i++,j--)
			if(subStr[i] != subStr[j])
				return false;
		return true;
	}

}
