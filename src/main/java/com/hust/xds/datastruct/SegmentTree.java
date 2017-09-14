package com.hust.xds.datastruct;

/**
 * java线段树的实现。 这里的线段树保存的是区间的和信息。 节点的编号从0开始
 *
 * @author Deshan Xiao
 */
public class SegmentTree {

	/**
	 * 节点编号对应的区间和
	 */
	private int sum[];

	/**
	 * 在节点编号为curr上创建区间[left,right]的线段树 申请数组内存，委托给buildTree0实现
	 * 
	 * @param left
	 * @param right
	 * @param curr
	 * @param data
	 */
	public void buildTree(int left, int right, int curr, int data[]) {
		int size = right - left + 1;
		sum = new int[2 * size - 1];

		buildTree0(left, right, curr, data);
	}

	/**
	 * 在节点编号为curr上创建区间[left,right]的线段树
	 * 
	 * @param left
	 * @param right
	 * @param curr
	 */
	private void buildTree0(int left, int right, int curr, int data[]) {
		/* 当左右区间相同的时候，将区间和记为当前区间左（右）端点的值 */
		if (left == right) {
			sum[curr] = data[left];
			return;
		}

		/* 递归创建左右子树 */
		int mid = (left + right) >> 1;
		buildTree0(left, mid, curr * 2 + 1, data);
		buildTree0(mid + 1, right, curr * 2 + 2, data);
		/* 更新节点信息 */
		pushUp(curr);
	}

	/**
	 * 更新节点信息，这里是和信息
	 * 
	 * @param curr
	 */
	public void pushUp(int curr) {
		sum[curr] = sum[2 * curr + 1] + sum[2 * curr + 2];
	}

	// l,r表示当前节点区间，rt表示当前节点编号
	/**
	 * 线段树点修改
	 * 
	 * @param L
	 *            修改点的位置
	 * @param C
	 *            修改点的增量
	 * @param left
	 *            左区间
	 * @param right
	 *            右区间
	 * @param curr
	 *            起始节点编号
	 */
	void Update(int L, int C, int left, int right, int curr) {
		if (left == right) {
			sum[curr] += C;
			return;
		}

		int mid = (left + right) >> 1;
		/* 根据修改点的位置，找到对应的区间 */
		if (L <= mid) {
			Update(L, C, left, mid, curr * 2 + 1);
		} else {
			Update(L, C, mid + 1, right, curr * 2 + 2);
		}
		/* 更新新的节点和 */
		pushUp(curr);
	}
}
