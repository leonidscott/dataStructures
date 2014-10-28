// Lenny Scott, Tyler Lemke, Ryan McArthur: Lab 8!
package lab8;

import java.util.concurrent.CountDownLatch;

public class SortingMethods {
	/*
	 * sorts an array using insertion sort
	 */
	public static void insertionSort(Comparable[] arr) {
		
		for (int i = 1; i < arr.length; i++) {
			Comparable nextItem = arr[i];
			
			int j = i;
			while (j > 0 && nextItem.compareTo(arr[j - 1]) < 0) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = nextItem; 
		}
	}


	/*
	 * sorts an array using merge sort. The method is recursive. 
	 */
	public static void mergeSort(Comparable[] arr) {
		if (arr.length <= 1) {
			return;
		}
		
		Comparable[] leftHalf = new Comparable[arr.length / 2];
		Comparable[] rightHalf = new Comparable[arr.length - leftHalf.length];		
		
		// copying arrays into halves
		for (int i = 0; i < leftHalf.length; i++) {
			leftHalf[i] = arr[i];
		}
		
		for (int i = leftHalf.length; i < arr.length; i++) {
			rightHalf[i - leftHalf.length] = arr[i];
		}
		
		// sort two halves
		mergeSort(leftHalf);
		mergeSort(rightHalf);
		
		int arrIndex = 0;
		int leftIndex = 0;
		int rightIndex = 0;

		while (arrIndex < arr.length) {
			//this if compares the current indexes to see if the left half is smaller or equal.
			if (leftHalf[leftIndex].compareTo(rightHalf[rightIndex]) <= 0){
				arr[arrIndex] = leftHalf[leftIndex];
				arrIndex++;
				leftIndex++;
				//if the left half is empty then we put the remaining elements of the right half into the main array.
				if (leftIndex == leftHalf.length){
					while (rightIndex < rightHalf.length){
						arr[arrIndex] = rightHalf[rightIndex];
						rightIndex++;
						arrIndex++;
					}
				}
			}
			//this if compares the current indexes to see if the right half is smaller.
			else if (leftHalf[leftIndex].compareTo(rightHalf[rightIndex]) > 0){
				arr[arrIndex] = rightHalf[rightIndex];
				arrIndex++;
				rightIndex++;
				//if the right half is empty then we put the remaining elements of the left half into the main array.
				if (rightIndex == rightHalf.length){
					while (leftIndex < leftHalf.length) {
						arr[arrIndex] = leftHalf[leftIndex];
						leftIndex++;
						arrIndex++;
					}
				}
			}
		}
	}
}
