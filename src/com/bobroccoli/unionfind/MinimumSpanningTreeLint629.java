package com.bobroccoli.unionfind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumSpanningTreeLint629 {

	class Connection {
		public String city1, city2;
		public int cost;

		public Connection(String city1, String city2, int cost) {
			this.city1 = city1;
			this.city2 = city2;
			this.cost = cost;
		}
	}

	public List<Connection> lowestCost(List<Connection> connections) {
		List<Connection> res = new ArrayList<Connection>();
        if(connections == null || connections.size() == 0)
            return res;
        Collections.sort(connections, new Comparator<Connection>() {
        	@Override
        	public int compare(Connection o1, Connection o2) {
        		if(o1.cost != o2.cost)
        			return o1.cost-o2.cost;
        		if(!o1.city1.equals(o2.city1))
        			return o1.city1.compareTo(o2.city1);
        		return o1.city2.compareTo(o2.city2);
        	}
		});
        int num = 0;
        Map<String, Integer> map = new HashMap<>();
        for(Connection c: connections) {
        	if(!map.containsKey(c.city1))
        		map.put(c.city1, num++);
        	if(!map.containsKey(c.city2))
        		map.put(c.city2, num++);
        }
        int[] father = new int[num];
        for(int j = 0; j < num; j++)
        	father[j] = j;
        for(Connection c : connections) {
        	if(root(map.get(c.city1), father) != root(map.get(c.city2), father)) {
        		union(map.get(c.city1), map.get(c.city2),father);
        		res.add(c);
        	}
        }
        if(res.size() != num-1)
        	return new ArrayList<>();
        return res;
	}

	private void union(int i, int j, int[] father) {
		int rooti = root(i, father);
		int rootj = root(j, father);
		if(rooti == rootj)
			return;
		if(rooti < rootj)
			//************************************be careful, should build the relationship with rooti and rootj************
			father[rootj] = rooti;
		else
			//************************************be careful, should build the relationship with rooti and rootj************
			father[rooti] = rootj;
	}

	private int root(int integer, int[] father) {
		while(integer != father[integer])
			integer = father[integer];
		return integer;
	}
}
