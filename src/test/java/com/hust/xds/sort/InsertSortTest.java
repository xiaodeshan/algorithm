package com.hust.xds.sort;

import java.util.Random;

import org.junit.Test;

/**
 * 直接插入排序测试类
 *
 * @author Deshan Xiao
 */
public class InsertSortTest {
	@Test
	public void testInsertSort() {
		int randomNum = 10000;
		Random random = new Random();

		int arr[] = new int[randomNum];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(randomNum << 2);
		}
		InsertSort.sort(arr);

		for (int i = 0; i < arr.length; i++) {
			if (i != 0)
				assert arr[i] >= arr[i - 1];
			System.out.println(arr[i]);
		}
	}
}
