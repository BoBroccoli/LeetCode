package com.bobroccoli.dfs;

public class FriendCircles547 {
	public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0 || M[0].length == 0)
            return 0;
        boolean[] visited = new boolean[M.length];
        int count = 0;
        for(int i = 0; i < M.length; i++) {
        	if(!visited[i]) {
        		dfs(M, visited, i);
        		count++;
        	}
        }
        return count;
	}

	public void dfs(int[][] m, boolean[] visited, int i) {
		visited[i] = true;
		for(int j = 0; j < m[i].length; j++) {
			if(!visited[j] && m[i][j] == 1)
				dfs(m, visited, j);
		}
	}
}
