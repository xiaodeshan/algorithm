package com.hust.xds.sort;

import com.hust.xds.util.Utils;

/**
 * 直接插入排序java实现
 *
 * @author Deshan Xiao
 */
public class InsertSort implements Sortable{
	public void sort(int[] arr) {
		int len = arr.length;

		for (int i = 1; i < len; i++) {
			int data = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j] > data) {
				Utils.swap(arr, j, j + 1);
				--j;
			}
		}
	}
}
