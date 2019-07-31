package com.bobroccoli.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementinaSortedMatrix378 {
	class Tuple {
		int x, y, val;

		public Tuple(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}

	public int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>(new Comparator<Tuple>() {
			public int compare(Tuple a, Tuple b) {
				return a.val - b.val;
			}
		});
		int row = matrix.length, col = matrix[0].length;
		boolean[][] visited = new boolean[row][col];
		pq.offer(new Tuple(0, 0, matrix[0][0]));
		while (k > 1) {
			Tuple smallest = pq.poll();
			int x = smallest.x, y = smallest.y;
			if (x + 1 < row && !visited[x + 1][y]) {
				pq.offer(new Tuple(x + 1, y, matrix[x + 1][y]));
				visited[x + 1][y] = true;
			}
			if (y + 1 < col && !visited[x][y + 1]) {
				pq.offer(new Tuple(x, y + 1, matrix[x][y + 1]));
				visited[x][y + 1] = true;
			}
			--k;
		}
		return pq.poll().val;
	}
}
