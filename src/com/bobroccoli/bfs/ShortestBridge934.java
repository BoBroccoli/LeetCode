package com.bobroccoli.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge934 {
	public int shortestBridge(int[][] A) {
        Queue<Integer> qx = new LinkedList<Integer>();
        Queue<Integer> qy = new LinkedList<Integer>();
        int res = 0, r = A.length, c = A[0].length;
        int[] dx = new int[]{0,0,-1,1};
        int[] dy = new int[]{1,-1,0,0};
        boolean[][] visited = new boolean[r][c];
        int startx = 0, starty = 0;
        outerloop:
        for(int i = 0; i < A.length; ++i){
            for(int j = 0; j < A[0].length; ++j){
                if(A[i][j] == 1){
                    startx = i;
                    starty = j;
                    break outerloop;
                }
            }
        }
        dfs(qx, qy, A, visited, startx, starty);
        while(!qx.isEmpty()){
            ++res;
            int size = qx.size();
            for(int i = 0; i < size; ++i){
                int x = qx.poll(), y = qy.poll();
                for(int j = 0; j < 4; ++j){
                    if(x+dx[j] >= 0 && x+dx[j] < r && y+dy[j] >=0 && y+dy[j] < c && A[x+dx[j]][y+dy[j]] == 1 && !visited[x+dx[j]][y+dy[j]])
                        return res-1;
                    if(x+dx[j] >= 0 && x+dx[j] < r && y+dy[j] >=0 && y+dy[j] < c && A[x+dx[j]][y+dy[j]] == 0){
                        A[x+dx[j]][y+dy[j]] = 1;
                        qx.offer(x+dx[j]);
                        qy.offer(y+dy[j]);
                        visited[x+dx[j]][y+dy[j]] = true;
                    }
                }
            }
        }
        return 0;
    }
    public void dfs(Queue<Integer> qx, Queue<Integer> qy, int[][] A, boolean[][]visited, int x, int y){
        if(x >= 0 && x < visited.length && y >= 0 && y < visited[0].length && !visited[x][y] && A[x][y] == 1){
            visited[x][y] = true;
            qx.offer(x);
            qy.offer(y);
            //System.out.println(x + " " +y);
            dfs(qx, qy, A, visited, x+1, y);
            dfs(qx, qy, A, visited, x-1, y);
            dfs(qx, qy, A, visited, x, y+1);
            dfs(qx, qy, A, visited, x, y-1);
        }
    }
    
}
