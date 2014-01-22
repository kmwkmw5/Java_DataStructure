package exercise.sort;

import java.util.Random;

import datastructure.search.SearchClass;
import datastructure.sort.SortClass;

public class SearchMain {
	public static void main(String[] args) {
		Random random = new Random();
		int[] arr = new int[50];
		
		for(int i=0; i<arr.length; i++)
			arr[i] = random.nextInt(50) + 1;
		SortClass.quickSort(arr);
		
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		
		System.out.println();
		System.out.println(SearchClass.binarySearch(arr, 5));
		System.out.println(SearchClass.interpolSearch(arr, 5));
	}
}
