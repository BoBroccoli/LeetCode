package com.bobroccoli.cornercase;

public class ValidWordAbbreviationLint637 {
	public boolean validWordAbbreviation(String word, String abbr) {
		if(word == null || word.length()==0)
			return false;
		int index = 0;
		char[] wordChars = word.toCharArray();
		char[] abbrChars = abbr.toCharArray();
		for(int i = 0; i < abbrChars.length; i++) {
			if(abbrChars[i]-'0' < 0 || abbrChars[i]-'0'>9) {
				if(wordChars[index] != abbrChars[i])
					return false;
				index++;//*********when increment the index, be careful*******
				if(index > wordChars.length)
					return false;
				continue;
			}
			String integer = "";
			if(abbrChars[i]-'0' >= 0 && abbrChars[i]-'0' <= 9) {
				while(abbrChars[i]-'0' >= 0 && abbrChars[i]-'0' <= 9) {
					integer += abbrChars[i];
					i++;//*********when increment the i, be careful*******
					if(i == abbrChars.length)
						break;
				}
				i--;
				if(integer.charAt(0) == 0)
					return false;
				index += Integer.parseInt(integer);//**when increment the index, be careful**
				if(index > wordChars.length)
					return false;
			}
		}
		return true;
	}
}
