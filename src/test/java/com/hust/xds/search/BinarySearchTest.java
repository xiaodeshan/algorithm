package com.hust.xds.search;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.hust.xds.sort.QuickSort;

public class BinarySearchTest {
	public static final int size = 10000000;
	
	private int[] data = new int[size];

	@Before
	public void crateData() {
		Random random = new Random();

		for (int i = 0; i < data.length; i++) {
			data[i] = random.nextInt(size);
		}

		new QuickSort().sort(data);
		System.out.println("start..");
	}

	@Test
	public void testBinarySearch() {
		/* 测试的次数 */
		int times = 1000;

		Random random = new Random();

		while (times-- != 0) {
			int key = random.nextInt(size);

			int pos = BinarySearch.binarySerach(data, key);

			if (pos == -1) {
				for (int i = 0; i < data.length; i++) {
					if (data[i] == key) {
						assert false;
					}
				}
			} else {
				assert data[pos] == key;
			}
		}
	}
}
