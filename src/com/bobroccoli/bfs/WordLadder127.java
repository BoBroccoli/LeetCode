package com.bobroccoli.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
