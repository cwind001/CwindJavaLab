package com.cwind.test;

// http://community.topcoder.com/stat?c=problem_statement&pm=1259&rd=4493

public class ZigZagSequenceTest {
	
	public int longestZigZag(int[] sequence){
		if (sequence.length<=2){
			return sequence.length;
		}
		int maxLen = 2;
		int mask = sequence[0] - sequence[1];
		
		for(int i=1;i<sequence.length-1;){
			int cur = sequence[i];
			for(int j=i;j<sequence.length;j++){
				if(mask*(cur-sequence[j])>=0){
					cur=sequence[j];
					i=j;
					continue;
				}else{
					maxLen++;
					mask = cur - sequence[j];
					i = j;
					break;
				}
			}
		}
		return maxLen;
	}
	
	public static void main(String[] args) {
//		int[] seq = { 1, 7, 4, 9, 2, 5 };
//		int[] seq = { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 };
//		int[] seq = { 44 };
//		int[] seq = { 1, 2, 3, 4, 5, 6, 7, 8, 9 } ;
//		int[] seq = { 70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32 };
		int[] seq = { 374, 40, 854, 203, 203, 156, 362, 279, 812, 955, 
				600, 947, 978, 46, 100, 953, 670, 862, 568, 188, 
				67, 669, 810, 704, 52, 861, 49, 640, 370, 908, 
				477, 245, 413, 109, 659, 401, 483, 308, 609, 120, 
				249, 22, 176, 279, 23, 22, 617, 462, 459, 244 };
//		int[] seq = { 2, 3, 5, 4 };
		System.out.println((new ZigZagSequenceTest()).longestZigZag(seq));
	}
}
