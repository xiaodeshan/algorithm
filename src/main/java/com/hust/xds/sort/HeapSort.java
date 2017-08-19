package com.hust.xds.sort;

/**
 * 构造大根堆实现堆排序
 * 
 * @author Deshan Xiao
 */
public class HeapSort {

	/**
	 * 保持arr在pos上的堆的性质
	 * @param pos
	 * 		待調整的位置
	 * @param arr
	 * 		待調整的數組
	 */
	private static void adjustHeap(int pos, int arr[], int len) {		
		int max = arr[pos];
		int nextPos = pos;
		
		int leftChild = pos * 2 + 1;
		int rightChild = pos * 2 + 2;
		if(leftChild < len && arr[leftChild] > max) {
			max = arr[leftChild];
			nextPos = leftChild;
		}
		if(rightChild < len && arr[rightChild] > max) {
			max = arr[rightChild];
			nextPos = rightChild;
		}
		
		if(nextPos != pos) {
			swap(arr, pos, nextPos);
			adjustHeap(nextPos, arr, len);
		}
	}

	public static void sort(int[] arr) {
		int len = arr.length;
		
		for(int i = (len / 2) - 1; i >= 0; i--) {
			adjustHeap(i, arr, len);
		}
		
		for(int i = len - 1; i > 0; i--) {
			swap(arr, 0, i);
			adjustHeap(0, arr, i);
		}
	}

	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

}
