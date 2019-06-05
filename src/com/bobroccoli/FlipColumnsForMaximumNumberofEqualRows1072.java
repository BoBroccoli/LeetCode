package com.bobroccoli;

import java.util.HashMap;
import java.util.Map;

public class FlipColumnsForMaximumNumberofEqualRows1072 {
	public int maxEqualRowsAfterFlips(int[][] matrix) {
        int res = 0;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < matrix.length; i++){
            String row = toString(matrix[i]);
            map.put(row, map.getOrDefault(row, 0)+1);
        }
        for(int j = 0; j < matrix.length; j++){
            String row = toString(matrix[j]);
            int count = map.getOrDefault(row,0) + map.getOrDefault(toString(invert(matrix[j])), 0);
            res = Math.max(count, res);
        }
        return res;
    }
    public int[] invert(int[] col){
        int[] invert = new int [col.length];
        for(int i = 0; i < col.length; i++)
            invert[i] = col[i] == 0 ? 1 : 0;
        return invert;
    }
    public String toString(int[] col){
        StringBuilder sb = new StringBuilder();
        for(int i : col){
            sb.append(i);
        }
        return sb.toString();
    }
}
