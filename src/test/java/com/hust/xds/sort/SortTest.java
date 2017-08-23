package com.hust.xds.sort;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

/**
 * 堆排序测试类
 *
 * @author Deshan Xiao
 */
public class SortTest {

	private int[] data = new int[100000000];

	@Before
	public void crateData() {
		Random random = new Random();

		for (int i = 0; i < data.length; i++) {
			data[i] = random.nextInt(100000000);
		}
		
		System.out.println("hhh");
	}

	@Test
	public void testAllSort() {
		testSort(new HeapSort(), data);
		// testSort(new InsertSort());
		testSort(new MergeSort(), data);
		testSort(new QuickSort(), data);
		testSort(new ShellSort(), data);
	}

	@Test
	public void testHeapSort() {
		testSort(new HeapSort(), data);
	}

	@Test
	public void testMergeSort() {
		testSort(new MergeSort(), data);
	}

	@Test
	public void testQuickSort() {
		testSort(new QuickSort(), data);
	}

	@Test
	public void testShellSort() {
		testSort(new ShellSort(), data);
	}

	public void testSort(Sortable sortable, int arr[]) {
		int temp[] = new int[arr.length];
		System.arraycopy(arr, 0, temp, 0, arr.length);

		sortable.sort(temp);

		for (int i = 0; i < temp.length; i++) {
			if (i != 0)
				assert temp[i] >= temp[i - 1];
			// System.out.println(arr[i]);
		}
	}
}
