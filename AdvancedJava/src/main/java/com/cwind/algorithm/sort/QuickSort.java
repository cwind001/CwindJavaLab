package com.cwind.algorithm.sort;

public class QuickSort {
	
	public static void quickSort(int[] array, int low, int high) {
		if(low>=high){
			return;
		}
		
		int paviot = array[low];
		int l = low+1, h = high;
		while(l<h){
			while(array[h]>paviot && l<h){
				h--;
			}
			while(array[l]<paviot && l<h){
				l++;
			}
			if(l<h){
				int tmp = array[l];
				array[l] = array[h];
				array[h] = tmp;
			}
		}
		if(array[low]>array[l]){
			array[low] = array[l];
			array[l] = paviot;	
		}
		quickSort(array, low, l-1);
		quickSort(array, l+1, high);
		
	}

	public static void printArray(int[] array) {
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}
	
	public static void main(String[] args) {
		int[] array = {2, 1, 3, 5, 6, 7, 0, 4, 9, 8};
		quickSort(array, 0, array.length-1);
		printArray(array);

	}
}
