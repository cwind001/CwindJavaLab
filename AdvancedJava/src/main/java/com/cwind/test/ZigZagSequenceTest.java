package com.cwind.test;

public class ZigZagSequenceTest {
	
	public static int longestZigZag(int[] sequence){
		if (sequence.length<=2){
			return sequence.length;
		}
		int maxLen = 2;
		int mask = sequence[0] - sequence[1];
		
		for(int i=1;i<sequence.length-1;){
			int cur = sequence[i];
		}
		return maxLen;
	}
	
	public static void main(String[] args) {
//		int[] seq = { 1, 7, 4, 9, 2, 5 };
		int[] seq = { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 };
//		int[] seq = { 1, 7, 4, 9, 2, 5 };
//		int[] seq = { 1, 7, 4, 9, 2, 5 };
		System.out.println(longestZigZag(seq));
	}
}
