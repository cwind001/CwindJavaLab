package com.cwind.algorithm.sort;

public class BubbleSort {
	
	public static void bubbleSort(int[] array) {
		for(int i=0; i<array.length-1; i++){
			for(int j=0; j<array.length-i-1; j++){
				if(array[j]>array[j+1]){
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}

	public static void printArray(int[] array) {
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}
	
	public static void main(String[] args) {
		int[] array = {2, 1, 3, 5, 6, 7, 0, 4, 9, 8};
		bubbleSort(array);
		printArray(array);

	}
}
