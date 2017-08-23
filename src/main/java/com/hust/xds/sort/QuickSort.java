package com.hust.xds.sort;

import com.hust.xds.util.Utils;

/**
 * 快排java实现
 * 
 * @author Deshan Xiao
 */
public class QuickSort implements Sortable {

	/**
	 * 使用最后一个元素作为基准元素，将比基准元素小的放在数组左边，大的放在右边
	 * 
	 * @return 调整之后的基准元素索引
	 */
	private int partition(int[] arr, int beg, int end) {
		/* 始终指向第一个大于等于基准元素 */
		int ans = beg;
		/* 基准元素设置为最后一个元素 */
		int baseElemet = arr[end];

		for (int i = beg; i < end; i++) {
			int data = arr[i];

			if (data < baseElemet) {
				Utils.swap(arr, i, ans);
				++ans;
			}
		}

		Utils.swap(arr, ans, end);
		return ans;
	}

	/**
	 * 使用快排，排序数组arr索引从beg-end的元素
	 */
	private void sort0(int[] arr, int beg, int end) {
		if (end > beg) {
			int part = partition(arr, beg, end);
			sort0(arr, beg, part - 1);
			sort0(arr, part + 1, end);
		}
	}

	public void sort(int[] arr) {
		sort0(arr, 0, arr.length - 1);
	}

}
