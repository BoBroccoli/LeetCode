package com.bobroccoli;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DistantBarcodes1054 {
	public int[] rearrangeBarcodes(int[] barcodes) {
		if(barcodes.length <= 2)
			return barcodes;
		int[] res = new int[barcodes.length];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i : barcodes)
			map.put(i, map.getOrDefault(i, 0)+1);
		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer,Integer>>(
				(a, b)-> b.getValue() - a.getValue());
		for(Map.Entry<Integer, Integer> entry : map.entrySet())
			pq.add(entry);
		int index = 0;
		while (!pq.isEmpty()) {
			Map.Entry<Integer, Integer> entry = pq.poll();
			for(int i = 0; i < entry.getValue(); i++) {
				if(index > barcodes.length-1)
					index = 1;
				res[index] = entry.getKey();
				index += 2;
			}
		}
		return res;
	}
}
