package com.bobroccoli;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wordbreak139 {
	//recursive solution bad performance
	public boolean wordBreakRecersive(String s, List<String> wordDict) {
        if(s==null)
            return true;
        return wordBreakHelper(s, wordDict, 0);
    }
    
    public boolean wordBreakHelper(String s, List<String> wordDict, int start){
        if(start == s.length())
            return true;
        if(start > s.length())
        	return false;
        for(int i = 0; i < wordDict.size(); i++){
            if(wordDict.get(i).length() <= s.substring(start, s.length()).length()
            		&& s.substring(start, start + wordDict.get(i).length()).equals(wordDict.get(i))){
                if(wordBreakHelper(s, wordDict, start+wordDict.get(i).length()))
                    return true;
            }
        }
        return false;
    }
    //Solution with HashSet
    public boolean wordBreaKImprove(String s, List<String> wordDict) {
    	if(s.length()==0)
    		return true;
    	Set<String> set = new HashSet<String>();
		for (String string : wordDict) {
			set.add(string);
		}
		for(int i = 1; i <= s.length(); i++) {
			if(set.contains(s.substring(0, i)) 
					&& wordBreaKImprove(s.substring(i, s.length()), wordDict))
				return true;
		}
		return false;
    }
    // DP solution
    public boolean wordBreak(String s, List<String> wordList) {
		Set<String> set = new HashSet<String>();
		for (String string : wordList) {
			set.add(string);
		}
		boolean[] dp = new boolean[s.length()+1];
		dp[0] = true;
		for(int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if(dp[j] == true && set.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[dp.length-1];
	}
}
