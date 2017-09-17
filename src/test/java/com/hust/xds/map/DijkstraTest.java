package com.hust.xds.map;

import org.junit.Test;

public class DijkstraTest {
	public static int N = -1;
	
	@Test
	public void testDijkstra() {
	   int[][] graph = {
	            { 0, N, 5, N, N, N, N, N, N },
	            { N, N, N, N, N, N, N, N, N },
	            { 5, N, 0, N, 1, 7, N, N, N },
	            { N, N, N, 0, 2, N, 3, N, N },
	            { N, N, 1, 2, 0, 3, 6, 9, N },
	            { N, N, 7, N, 3, 0, N, 5, N },
	            { N, N, N, 3, 6, N, 0, 2, 7 },
	            { N, N, N, N, 9, 5, 2, 0, 4 },
	            { N, N, N, N, N, N, 7, 4, 0 } };
	   
	   //18
	   int distance = Dijkstra.dijkstra(0, 8, graph);
	   System.out.println(distance);
	   
	   //error
	   distance = Dijkstra.dijkstra(0, 1, graph);
	   System.out.println(distance);	   
	}
}
