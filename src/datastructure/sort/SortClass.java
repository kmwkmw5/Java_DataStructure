package datastructure.sort;

import datastructure.tree.Heap;
import datastructure.queue.ListQueue;

public class SortClass {
	public static void heapSort(int[] arr) {
		Heap<Integer> heap = new Heap<Integer>();
		for(int i=0; i<arr.length; i++) {
			heap.insert(arr[i], arr[i]);
		}
		for(int i=0; i<arr.length; i++) {
			arr[i] = heap.delete();
		}
	}
	
	private static void mergeTwoArea(int[] arr, int left, int mid, int right) {
		int leftIdx = left;
		int rightIdx = mid+1;
		int sortIdx = left;
		int[] sortArr = new int[right+1];
		
		while(leftIdx<=mid && rightIdx<=right) {
			int sortData = (arr[leftIdx] < arr[rightIdx]) ? arr[leftIdx++] : arr[rightIdx++];
			sortArr[sortIdx++] = sortData;
		}
		
		if(leftIdx > mid)
			while(rightIdx<=right)
				sortArr[sortIdx++] = arr[rightIdx++];
		else
			while(leftIdx<=mid)
				sortArr[sortIdx++] = arr[leftIdx++];
		
		for(int i=left; i<=right; i++)
			arr[i] = sortArr[i];
	}
	public static void mergeSort(int[] arr) {
		mergeSort(arr, 0, arr.length-1);
	}
	public static void mergeSort(int[] arr, int left, int right) {
		if(left<right) {
			int mid = (left + right) / 2;
			
			mergeSort(arr, left, mid);
			mergeSort(arr, mid+1, right);
			
			mergeTwoArea(arr, left, mid, right);
		}
	}
	
	private static void swapValueWithIndex(int[] arr, int idx1, int idx2) {
		int temp;
		temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}
	private static void setPivotAtFirstIndex(int[] arr, int left, int right) {
		int[] idxArr = new int[]{left, (left+right)/2, right};
		if(arr[idxArr[0]] > arr[idxArr[1]]) {
			swapValueWithIndex(idxArr, 0, 1);
		}
		if(arr[idxArr[1]] > arr[idxArr[2]]) {
			swapValueWithIndex(idxArr, 1, 2);
		}
		if(arr[idxArr[0]] > arr[idxArr[1]]) {
			swapValueWithIndex(idxArr, 0, 1);
		}
		swapValueWithIndex(arr, left, idxArr[1]);
	}
	private static int partition(int[] arr, int left, int right) {
		setPivotAtFirstIndex(arr, left, right);
		int pivot = arr[left];
		int low = left + 1;
		int high = right;
		//System.out.println("피벗 : " + pivot + ", 로우 : " + low + ", 하이 : " + high);
		while(low<=high) {
			while(low <= right && arr[low] <= pivot)
				low++;
			
			while(high >= left+1 && arr[high] >= pivot)
				high--;
			
			if(low<=high)
				swapValueWithIndex(arr, low, high);
		}
		swapValueWithIndex(arr, left, high);
		return high;
	}
	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length-1);
	}
	public static void quickSort(int[] arr, int left, int right) {
		if(left<right) {
			int pivot = partition(arr, left, right);
			quickSort(arr, left, pivot-1);
			quickSort(arr, pivot+1, right);
		}
	}
	
	private static final int BUCKET_NUM = 10;
	public static void radixSort(int[] arr, int maxLen) {
		@SuppressWarnings("unchecked")
		ListQueue<Integer>[] buckets = new ListQueue[10];
		for(int i=0; i<buckets.length; i++) {
			buckets[i] = new ListQueue<Integer>();
		}
		
		int divfac = 1;
		
		for(int pos=0; pos<maxLen; pos++) {
			for(int di=0; di<arr.length; di++) {
				int radix = (arr[di] / divfac) % 10;
				buckets[radix].enqueue(arr[di]);
			}
			
			for(int bi=0, di=0; bi<BUCKET_NUM; bi++)
				while(!buckets[bi].isEmpty())
					arr[di++] = buckets[bi].dequeue();
			
			divfac *= 10;
		}
	}
}
