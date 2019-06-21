package com.bobroccoli.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QueueReconstructionByHeight {
	public int[][] reconstructQueue(int[][] people) {
		// [7,0] [7,1] [6,1] [5,0] [5,2] [4,4]
		//Insertion sort, first sort ppl by height, tallest person arrange first
		// [5,0] [7,0] [5,2] [6,1] [4,4] [7,1]
		if (people == null || people.length == 0)
			return new int[0][0];
		Arrays.sort(people, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[0] == b[0])
					return a[1] - b[1];
				return b[0] - a[0];
			}
		});
		List<int[]> list = new ArrayList<int[]>();
		for (int i = 0; i < people.length; i++) {
			list.add(people[i][1], people[i]);
		}
		int[][] res = new int[people.length][2];
		for (int j = 0; j < people.length; j++) {
			res[j] = list.get(j);
		}
		return res;
	}
}
