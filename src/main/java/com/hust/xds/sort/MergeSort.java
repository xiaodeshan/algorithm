package com.hust.xds.sort;

/**
 * 归并排序
 *
 * @author Deshan Xiao
 */
public class MergeSort implements Sortable{

	public int temp[];

	public void merge(int[] arr, int beg, int end, int mid) {
		/* 左序列索引 */
		int index1 = beg;
		/* 右序列索引 */
		int index2 = mid + 1;
		int indexTemp = beg;

		while (index1 <= mid && index2 <= end) {
			if (arr[index1] < arr[index2]) {
				temp[indexTemp++] = arr[index1];
				++index1;
			} else {
				temp[indexTemp++] = arr[index2];
				++index2;
			}
		}

		while (index1 <= mid) {
			temp[indexTemp++] = arr[index1];
			++index1;
		}

		while (index2 <= end) {
			temp[indexTemp++] = arr[index2];
			++index2;
		}

		for (int i = beg; i <= end; i++) {
			arr[i] = temp[i];
		}
	}

	public void mergeSort(int[] arr, int beg, int end) {
		if (beg >= end)
			return;
		int mid = (beg + end) >> 1;
		mergeSort(arr, beg, mid);
		mergeSort(arr, mid + 1, end);
		merge(arr, beg, end, mid);
	}

	public void sort(int[] arr) {
		temp = new int[arr.length];

		mergeSort(arr, 0, arr.length - 1);
	}
}
