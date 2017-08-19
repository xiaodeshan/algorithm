package com.hust.xds.sort;

import org.junit.Test;

public class HeapSortTest {
	@Test
	public void testHeapSort() {
		int array[] = { 3, 4, 2, 4, 6, 2, 7, 5, 6, 3, 5, 5, 3, 4, 5, 6, 7, 8, 4, 3, 2, 5 };

		HeapSort.sort(array);

		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
