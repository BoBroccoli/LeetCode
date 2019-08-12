package com.bobroccoli.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MinimumHeightTrees310 {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> res = new ArrayList();
		if (n == 1) {
			res.add(0);
			return res;
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		Map<Integer, ArrayList<Integer>> map = new HashMap();
		int[] degree = new int[n];
		for (int i = 0; i < edges.length; ++i) {
			ArrayList<Integer> list = map.getOrDefault(edges[i][0], new ArrayList<Integer>());
			list.add(edges[i][1]);
			map.put(edges[i][0], list);
			list = map.getOrDefault(edges[i][1], new ArrayList<Integer>());
			list.add(edges[i][0]);
			map.put(edges[i][1], list);
			++degree[edges[i][0]];
			++degree[edges[i][1]];
		}
		// System.out.println(degree[1]);
		for (int i = 0; i < n; ++i) {
			if (degree[i] == 1) {
				queue.offer(i);
				--degree[i];
			}
		}

		while (!queue.isEmpty()) {
			int size = queue.size();
			res = new ArrayList<Integer>();
			while (size > 0) {
				int top = queue.poll();
				res.add(top);
				for (int i = 0; i < map.get(top).size(); ++i) {
					int next = map.get(top).get(i);
					if (degree[next] == 0)
						continue;
					if (degree[next] == 2) {
						queue.offer(next);
					}
					degree[next]--;
				}
				size--;
			}
		}
		// System.out.println(Arrays.toString(degree));
		return res;
	}
}
