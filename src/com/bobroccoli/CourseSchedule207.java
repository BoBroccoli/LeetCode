package com.bobroccoli;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule207 {
	class Solution {
	    public boolean canFinish(int numCourses, int[][] prerequisites) {
	        //[1,0][1,2][3,0]
	        int[] numPrereq = new int[numCourses];
	        Map<Integer, List<Integer>> map = new HashMap();
	        for(int i = 0; i < prerequisites.length; i++){
	            numPrereq[prerequisites[i][0]]++;
	            List<Integer> values = map.getOrDefault(prerequisites[i][1], new ArrayList<Integer>());
	            values.add(prerequisites[i][0]);
	            map.put(prerequisites[i][1], values);
	        }
	        bfs(numPrereq, map);
	        for(int i : numPrereq){
	            if(i > 0)
	                return false;
	        }
	        return true;
	    }
	    
	    public void bfs(int[] numPrereq, Map<Integer, List<Integer>> map){
	        Queue<Integer> queue = new LinkedList<Integer>();
	        for(int i = 0; i < numPrereq.length; i++){
	            if(numPrereq[i] == 0){
	                queue.add(i);
	            }
	        }
	        while(!queue.isEmpty()){
	            int top = queue.poll();
	            System.out.println(top);
	            List<Integer> values = map.get(top);
	            if(values == null)
	                continue;
	            for(int i : values){
	                numPrereq[i]--;
	                if(numPrereq[i] == 0)
	                    queue.add(i);
	            }
	        }
	    }
	}
}
