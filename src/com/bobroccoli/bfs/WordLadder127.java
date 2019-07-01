package com.bobroccoli.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder127 {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		int res = 0;
		if (wordList == null || wordList.size() == 0)
			return res;
		Queue<String> queue = new LinkedList<String>();
		queue.offer(beginWord);
		boolean[] visited = new boolean[wordList.size()];
		boolean found = false;
		while (!queue.isEmpty()) {
			int iter = queue.size();
			for (int i = 0; i < iter; i++) {
				String top = queue.poll();
				if (top.equals(endWord)) {
					found = true;
					break;
				}
				for (int j = 0; j < wordList.size(); j++) {
					if (!visited[j] && oneDistance(wordList.get(j), top)) {
						queue.offer(wordList.get(j));
						visited[j] = true;
					}
				}
			}
			++res;
			if (found)
				return res;
		}
		if (!found)
			return 0;
		return res;
	}
	//double ended BST
	public int ladderLengthTwo(String beginWord, String endWord, List<String> wordList) {
		int res = 1;
        Set<String> start = new HashSet<String>();
        Set<String> end = new HashSet<String>();
        start.add(beginWord);
        end.add(endWord);
        Set<String> visited = new HashSet<String>();
        Set<String> wordSet = new HashSet<String>();
        
        for(String string : wordList)
            wordSet.add(string);
        if(!wordSet.contains(endWord))
            return 0;
        while(!start.isEmpty() && !end.isEmpty()){
            if(start.size() > end.size()){
                Set<String> temp = start;
                start = end;
                end = temp;
            }
            Set<String> temp = new HashSet<String>();
            for(String string : start){
                char[] chars = string.toCharArray();
                for(int i = 0; i < chars.length; ++i){
                    for(char c = 'a'; c <= 'z'; ++c){
                        char oldC = chars[i];
                        chars[i] = c;
                        String permute = new String(chars);
                        
                        if(end.contains(permute))
                            return res+1;
                        if(!visited.contains(permute) && wordSet.contains(permute)){
                            temp.add(permute);
                            visited.add(permute);
                        }
                        chars[i] = oldC;
                    }
                }
            }
            start = temp;
            ++res;
        }
        return 0;
	}
	public boolean oneDistance(String a, String b) {
		if (a.length() != b.length())
			return false;
		char[] chara = a.toCharArray();
		char[] charb = b.toCharArray();
		int count = 0;
		for (int i = 0; i < chara.length; i++) {
			if (chara[i] != charb[i])
				++count;
			if (count > 1)
				return false;
		}
		return true;
	}
}
