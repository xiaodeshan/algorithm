package com.hust.xds.sort;

import com.hust.xds.util.Utils;

/**
 * 构造大根堆实现堆排序
 * 
 * @author Deshan Xiao
 */
public class HeapSort implements Sortable {

	/**
	 * 保持arr在pos上的堆的性质
	 * 
	 * @param pos
	 *            待調整的位置
	 * @param arr
	 *            待調整的數組
	 */
	private void adjustHeap(int pos, int arr[], int len) {
		int max = arr[pos];
		int nextPos = pos;

		int leftChild = pos * 2 + 1;
		int rightChild = pos * 2 + 2;
		if (leftChild < len && arr[leftChild] > max) {
			max = arr[leftChild];
			nextPos = leftChild;
		}
		if (rightChild < len && arr[rightChild] > max) {
			max = arr[rightChild];
			nextPos = rightChild;
		}

		if (nextPos != pos) {
			Utils.swap(arr, pos, nextPos);
			adjustHeap(nextPos, arr, len);
		}
	}

	public void sort(int[] arr) {
		int len = arr.length;

		for (int i = (len / 2) - 1; i >= 0; i--) {
			adjustHeap(i, arr, len);
		}

		for (int i = len - 1; i > 0; i--) {
			Utils.swap(arr, 0, i);
			adjustHeap(0, arr, i);
		}
	}

}
