package com.bobroccoli.unionfind;

/*
 * Same as DFS, but use Union find data structure
 */
public class FriendCircles547 {
	class UnionFind {
		public int count;
		public int[] father;

		public UnionFind(int count) {
			this.count = count;
			father = new int[count];
			for(int i = 0; i < count; i++)
				father[i] = i;
		}

		public void union(int i, int j) {
			int rootI = find(i);
			int rootJ = find(j);
			if(rootI == rootJ)
				return;
			if (rootI < rootJ) {
				father[rootJ] = rootI;
			}
			if(rootI > rootJ) {
				father[rootI] = rootJ;
			}
			--count;
		}

		public int find(int child) {
			while (child != father[child]) {
				child = father[child];
			}
			return child;
		}
	}

	public int findCircleNum(int[][] M) {
		if(M == null || M.length == 0 || M[0].length == 0)
            return 0;
		UnionFind uf = new UnionFind(M.length);
		for(int i = 0; i < M.length; i++) {
			for(int j = 0; j < M.length; j++) {
				if(i < j && M[i][j] == 1)
					uf.union(i, j);
			}
		}
		return uf.count;
	}
}
