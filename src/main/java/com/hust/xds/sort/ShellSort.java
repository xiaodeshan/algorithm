package com.hust.xds.sort;

import com.hust.xds.util.Utils;

/**
 * 希尔排序java实现
 *
 * @author Deshan Xiao
 */
public class ShellSort implements Sortable{

	public void sort(int[] arr) {
		int len = arr.length;

		for (int grap = (len >> 1); grap > 0; grap = (grap >> 1)) {
			for (int i = grap; i < len; i++) {
				for (int j = i - grap; j >= 0 && arr[j] > arr[j + grap]; j -= grap) {
					Utils.swap(arr, j, j + grap);
				}
			}
		}
	}

}
