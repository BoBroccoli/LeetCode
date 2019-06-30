package com.bobroccoli.trie;

import java.util.List;

public class ReplaceWords {
	class TrieNode{
		public String word;
		public TrieNode[] children;
		public TrieNode() {
			children = new TrieNode[26];
		}
	}
    public String replaceWords(List<String> dict, String sentence) {
        TrieNode root = new TrieNode();
    	buildTrie(root, dict);
    	String[] strings = sentence.split(" ");
    	for(String string : strings) {
    		TrieNode cur = root;
    		char[] chars = string.toCharArray();
    		for(int i = 0; i < chars.length; ++i) {
    			if(cur.children[chars[i]-'a'] == null || cur.word != null)
    				break;
    		}
    		string = cur.word == null ? string : cur.word;
    	}
    	StringBuilder sBuilder = new StringBuilder();
    	for(String string : strings) {
    		sBuilder.append(string);
    		sBuilder.append(" ");
    	}
    	return sBuilder.toString().trim();
    }
    
	private void buildTrie(TrieNode root, List<String> dict) {
		for(String string : dict) {
			char[] chars = string.toCharArray();
			TrieNode cur = root;
			for(int i = 0; i < chars.length; ++i) {
				if(cur.children[chars[i]-'a'] == null) {
					cur.children[chars[i]-'a'] = new TrieNode();
				}					
				cur = cur.children[chars[i]-'a'];
			}
			cur.word = string;
		}
	}
}
