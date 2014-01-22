package exercise.sort;

import java.util.Random;
import datastructure.sort.SortClass;

public class SortMain {
	public static void main(String[] args) {
		int[] arr = new int[20];
		Random random = new Random();
		for(int i=0; i<arr.length; i++) {
			arr[i] = random.nextInt(20);
		}
		//arr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		SortClass.radixSort(arr, 2);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
