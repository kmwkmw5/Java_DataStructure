package datastructure.search;

public class SearchClass {
	public static int binarySearch(int[] arr, int target) {
		return binarySearch(arr, 0, arr.length-1, target);
	}
	public static int binarySearch(int[] arr, int first, int last, int target) {
		if(arr[first] > target || arr[last] < target)
			return -1;
		
		int mid = (first+last) / 2;
		
		if(arr[mid] == target)
			return mid;
		else if(target < arr[mid])
			return binarySearch(arr, first, mid-1, target);
		else
			return binarySearch(arr, mid+1, last, target);
	}
	
	public static int interpolSearch(int[] arr, int target) {
		return interpolSearch(arr, 0, arr.length-1, target);
	}
	public static int interpolSearch(int[] arr, int first, int last, int target) {
		if(arr[first] > target || arr[last] < target)
			return -1;
		
		int mid = (int)(((double)(target-arr[first]) / (arr[last]-arr[first]) * (last-first)) + first);
		
		if(arr[mid] == target)
			return mid;
		else if(target < arr[mid])
			return interpolSearch(arr, first, mid-1, target);
		else
			return interpolSearch(arr, mid+1, last, target);
	}
}
