package com.bobroccoli;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<String> res = new ArrayList<String>();
        for(int i = 0; i <= s.length()-10; i++){
            String sub = s.substring(i, i+10);
            map.put(sub, map.getOrDefault(sub, 0)+1);
        }
        for(Map.Entry<String, Integer> e : map.entrySet()){
            if(e.getValue() > 1)
                res.add(e.getKey());
        }
        return res;
    }
}
