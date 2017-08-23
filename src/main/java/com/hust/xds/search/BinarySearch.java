package com.hust.xds.search;

public class BinarySearch {
	static int binarySerach(int[] array, int key) {
		int left = 0;
		int right = array.length - 1;
		int mid = 0;

		/* 这里必须有等号，比如{1,3,4} key = 4 */
		while (left <= right) {
			mid = (left + right) >> 1;
			if (array[mid] < key) {
				left = mid + 1;
			} else if (array[mid] > key) {
				right = mid - 1;
			} else {
				return mid;
			}
		}

		return -1;
	}
}
