package com.hust.xds.sort;

import java.util.Random;

import org.junit.Test;

public class ShellSortTest {
	@Test
	public void testShellSort() {
		int randomNum = 10000;
		Random random = new Random();

		int arr[] = new int[randomNum];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(randomNum << 2);
		}
		ShellSort.sort(arr);

		for (int i = 0; i < arr.length; i++) {
			if (i != 0)
				assert arr[i] >= arr[i - 1];
			System.out.println(arr[i]);
		}
	}
}
