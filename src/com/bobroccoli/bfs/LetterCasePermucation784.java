package com.bobroccoli.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCasePermucation784 {
	public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<String>();
        if(S == null || S.length() == 0)
            return res;
        Queue<String> queue = new LinkedList<>();
        queue.add(S);
        char[] chars = S.toCharArray();
        for(int i = 0; i < chars.length; i++) {
        	if(Character.isLetter(chars[i])) {
        		int size = queue.size();
        		while(size > 0) {
        			String string = queue.poll();
        			char[] charString = string.toCharArray();
        			charString[i] = Character.toUpperCase(charString[i]);
        			queue.add(new String(charString));
        			charString[i] = Character.toLowerCase(charString[i]);
        			queue.add(new String(charString));
        			--size;
        		}
        	}
        }
        return new LinkedList<>(queue);
    }
}
