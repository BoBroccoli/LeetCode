package com.bobroccoli.dynamic;

import java.util.ArrayList;
import java.util.List;

public class OnlineStockSpan901 {
	class StockSpanner {
		private List<Integer> prices = null;
		private List<Integer> count = null;
		
		public StockSpanner() {
			prices = new ArrayList<Integer>();
			count = new ArrayList<Integer>();
		}

		public int next(int price) {
			prices.add(price);
			count.add(1);
			int index = prices.size()-1, update = index;
			while(index-1 >= 0 && prices.get(index-1) <= price) {
				count.set(update, count.get(update)+count.get(index-1));
				index -= count.get(index-1);
			}
			return count.get(update);
		}
	}
}
