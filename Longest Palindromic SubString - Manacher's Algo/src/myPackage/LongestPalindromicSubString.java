package myPackage;

import java.util.Scanner;

public class LongestPalindromicSubString {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the String");
		char[] str = insertHashValues(in.nextLine().toCharArray());
		printLongestPalindromicSubString(str);
		in.close();
	}
	private static void printLongestPalindromicSubString(char[] str){
		int[] result = new int[str.length];
		int C = 0, R = 0;
		for(int i = 1;  i < str.length; i++){
			int mirror = (2*C) - i;
			if(i < R)
				result[i] = Math.min(R-i, result[mirror]);
			int nextPossible = i + (1 + result[i]);
			int prevPossible = i - (1 + result[i]);
			while(prevPossible >= 0 && prevPossible < str.length && nextPossible >= 0 && nextPossible < str.length && str[prevPossible] == str[nextPossible]){
				result[i]++;
				prevPossible = i - (1 + result[i]);
				nextPossible = i + (1 + result[i]);
			}
			if(i+result[i] > R){
				C = i;
				R = i + result[i];
			}
		}
		int maxLength = 0,maxCenter = -1;
		for(int i = 1;  i < result.length-1; i++){
			if(result[i] > maxLength){
				maxLength = result[i];
				maxCenter = i;
			}
		}
		System.out.println("Longest Palindromic SubString length is : "+ maxLength);
		int start = (maxCenter - maxLength) + 1;
		int end = (maxCenter + maxLength) - 1;
		while(start <= end){
			System.out.print(str[start]);
			start= start+2;
		}
	}
	private static char[] insertHashValues(char[] str){
		char[] hashInsertedStr = new char[2*str.length+3];
		
		hashInsertedStr[0] = '$';
		hashInsertedStr[hashInsertedStr.length-1] = '@';
		for(int i = 1; i < hashInsertedStr.length-1; i++){
			if(i%2 == 0){
				int index = (i/2)-1;
				hashInsertedStr[i] = str[index];
			}
			else
				hashInsertedStr[i] = '#';
		}
		return hashInsertedStr;
	}
}
