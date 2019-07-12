package com.bobroccoli.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadderTwo126 {
	private boolean found = false;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    	List<List<String>> res = new ArrayList<List<String>>();
    	Map<String, List<String>> graph = new HashMap<String, List<String>>();
    	Set<String> words = new HashSet<String>();
    	
    	for(String string : wordList)
    		words.add(string);
    	bfs(beginWord, endWord, graph, words);
    	if(!found)
    		return res;
    	List<String> path = new ArrayList<String>();
    	dfs(graph, path, beginWord, endWord, res);
    	return res;
    }

	private void dfs(Map<String, List<String>> graph, List<String> path, String beginWord, String endWord, List<List<String>> res) {
		if(beginWord.equals(endWord)) {
			res.add(new ArrayList<String>(path));
			return;
		}
		for(String child : graph.get(beginWord)) {
			path.add(child);
			dfs(graph, path, child, endWord, res);
			path.remove(path.size()-1);
		}
	}

	private void bfs(String beginWord, String endWord, Map<String, List<String>> graph, Set<String> words) {
		Queue<String> queue = new LinkedList<String>();
		queue.offer(beginWord);
		Set<String> visited = new HashSet<String>();
		Set<String> nextVisit = new HashSet<String>();
		nextVisit.add(beginWord);
		while (!queue.isEmpty()) {
			int size = queue.size();
			visited.addAll(nextVisit);
			nextVisit.clear();
			for(int i = 0; i < size; ++i) {
				String top = queue.poll();
				List<String> children = getNext(top, words);
				for(String child: children) {
					if(!visited.contains(child)) {
						if(child.equals(endWord))
							found=true;
						List<String> list = graph.getOrDefault(top, new ArrayList<String>());
						list.add(child);
						graph.put(top, list);
					}
					if(!visited.contains(child) && !nextVisit.contains(child)) {
						queue.offer(child);
						nextVisit.add(child);
					}
				}
			}
			if(found)
				return;
		}
	}

	private List<String> getNext(String top, Set<String> words) {
		List<String> list = new ArrayList<String>();
		for(int i = 0; i < top.length(); ++i) {
			char[] chars = top.toCharArray();
			char old = chars[i];
			for(char j = 'a'; j<='z'; ++j) {
				chars[i] = j;
				if(words.contains(new String(chars)))
					list.add(new String(chars));
			}
			chars[i] = old;
		}
		return list;
	}
}
