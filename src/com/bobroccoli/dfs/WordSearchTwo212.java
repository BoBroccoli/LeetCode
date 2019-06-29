package com.bobroccoli.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchTwo212 {
	class TrieNode{
		public TrieNode[] nodes;
		public String word;
		public TrieNode() {
			nodes = new TrieNode [26];
		}
	}
    public List<String> findWords(char[][] board, String[] words) {
    	Set<String> list = new HashSet<>();
        if(words == null || words.length == 0)
        	return new ArrayList(list);
        TrieNode root = new TrieNode();
        buildTrie(root, words);
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; ++i) {
        	for(int j = 0; j < board[0].length; j++) {
        		if(root.nodes[board[i][j]-'a'] != null)
        			dfs(i, j, board,visited, list, root);
        	}
        }
        return new ArrayList(list);
    }
	private void dfs(int i, int j, char[][] board,boolean[][] visited, Set<String> list, TrieNode root) {
		if(i >= 0 && j >= 0 && i < board.length && j < board[0].length && !visited[i][j] && root.nodes[board[i][j]-'a'] != null) {
			visited[i][j] = true;
			TrieNode cur = root.nodes[board[i][j]-'a'];
			if(cur.word!=null)
				list.add(cur.word);
			dfs(i-1, j, board, visited, list, cur);
			dfs(i+1, j, board, visited, list, cur);
			dfs(i, j-1, board, visited, list, cur);
			dfs(i, j+1, board, visited, list, cur);
			visited[i][j] = false;
		}
	}
	private void buildTrie(TrieNode root, String[] words) {
		for(String string : words) {
			TrieNode cur = root;
			char[] chars = string.toCharArray();
			for(int i = 0; i < chars.length; i++) {
				int index = chars[i]-'a';
				if(cur.nodes[index] == null)
					cur.nodes[index] = new TrieNode();
				cur = cur.nodes[index];
			}
			cur.word = string;
		}
	}
}
