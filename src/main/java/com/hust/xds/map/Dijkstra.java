package com.hust.xds.map;

import java.util.Stack;

/**
 * dijkstra的java实现
 *
 * @author Deshan Xiao
 */
public class Dijkstra {

	/**
	 * @param sp
	 *            源点
	 * @param dp
	 *            目的点
	 * @param graph
	 *            邻接矩阵
	 */
	public static int dijkstra(int sp, int dp, int[][] graph) {
		// 点的个数
		int pNum = graph.length;
		boolean visit[] = new boolean[pNum];
		int distance[] = new int[pNum];
		int pre[] = new int[pNum];
		boolean finished = false;

		distance[sp] = 0;
		pre[sp] = sp;

		for (int i = 0; i < pNum; i++) {
			visit[i] = false;
			if (graph[sp][i] == -1) {
				distance[i] = Integer.MAX_VALUE;
			} else {
				distance[i] = graph[sp][i];
			}
		}

		visit[sp] = true;

		for (int i = 1; i < pNum && !finished; i++) {
			/* 找出当前点集里面没有访问的并且距离最短的那个点 */
			int minDistance = Integer.MAX_VALUE;
			int minPoint = -1;

			for (int j = 0; j < pNum; j++) {
				if (!visit[j] && distance[j] < minDistance) {
					minPoint = j;
					minDistance = distance[j];
				}
			}

			if (minPoint == -1) {
				throw new RuntimeException("图不为连通图！");
			}
			
			visit[minPoint] = true;

			for (int k = 0; k < pNum; k++) {
				if (!visit[k] && graph[minPoint][k] != -1 && graph[minPoint][k] + minDistance < distance[k]) {
					distance[k] = graph[minPoint][k] + minDistance;

					pre[k] = minPoint;
					
					if(k == dp) {
						finished = true;
						break;
					}
				}
			}
		}

		int temp = dp;

		Stack<Integer> stack = new Stack<Integer>();
		//stack.push(dp);
		while (pre[temp] != temp) {
			stack.push(temp);
			temp = pre[temp];
		}
		stack.push(sp);
		System.out.print(sp);
		stack.pop();
		while (!stack.isEmpty()) {
			System.out.print("->" + stack.pop());
		}
		System.out.println("");
		return distance[dp];
	}
}
