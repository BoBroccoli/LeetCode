package com.bobroccoli.unionfind;

public class RedundantConnection684 {
	public int[] findRedundantConnection(int[][] edges) {
        if(edges == null || edges.length == 0 || edges[0].length == 0)
            return new int[2];
        int len = edges.length;
        int[] father = new int [len];
        for(int i = 0; i < len; i++){
            father[i] = i;
        }
        for(int j = 0; j < len; j++){
            int roota = find(father, edges[j][0]-1);
            int rootb = find(father, edges[j][1]-1);
            if(roota != rootb)
                union(father, edges[j][0]-1, edges[j][1]-1);
            else
                return new int[] {edges[j][0], edges[j][1]};
        }
        return new int[2];
    }

	private void union(int[] father, int i, int j) {
		int rooti = find(father,i), rootj = find(father, j);//call find function inorder to get the root of the tree!!~!!!!!!
		if(rooti == rootj)
			return;
		if(rooti > rootj)
			father[rooti] = rootj;
		else
			father[rootj] = rooti;
	}

	private int find(int[] father, int i) {
		while(i != father[i])
			i = father[i];
		return i;
	}
}
