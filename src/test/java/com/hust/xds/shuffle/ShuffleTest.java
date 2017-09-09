package com.hust.xds.shuffle;

import org.junit.Test;

public class ShuffleTest {
	@Test
	public void testShuffle() {
		Integer[] x = { 1, 2, 3, 4, 5 };
		ShuffleUtil.shuffle(x);
		
		for(int i = 0; i < x.length; i++) {
			System.out.println(x[i]);
		}
	}
}
