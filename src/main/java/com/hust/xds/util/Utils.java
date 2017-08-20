package com.hust.xds.util;

public class Utils {
	/**
	 * 交换数组两个索引对应的值
	 */
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
