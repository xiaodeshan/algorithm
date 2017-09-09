package com.hust.xds.shuffle;

import java.util.Random;

/**
 * 对数组的元素进行shuffle,时间复杂度O(n), 空间复杂度O(n)
 *
 * @author Deshan Xiao
 */
public class ShuffleUtil {
	/**
	 * 每次随机生成(0 ~ len)随机数，将索引元素与最后一个元素交换，将总长度减少1
	 * 
	 * @param array
	 */
	public static void shuffle(Object[] array) {
		int len = array.length;
		Random random = new Random();

		for (int i = len - 1; i > 0; i--) {
			int randomIndex = random.nextInt(i);

			Object tempT = array[randomIndex];
			array[randomIndex] = array[i];
			array[i] = tempT;
		}
	}
}
