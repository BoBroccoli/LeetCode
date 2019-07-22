package com.bobroccoli.unionfind;

public class SatisfiabilityofEqualityEquations990 {
	//Two pass, first set the constrains then check violation.
	public boolean equationsPossible(String[] equations) {
		int[] father = new int[26];
		for (int i = 0; i < 26; ++i)
			father[i] = i;
		for (int i = 0; i < equations.length; ++i) {
			char[] chars = equations[i].toCharArray();
			if (chars[1] == '=') {
				int left = chars[0] - 'a', right = chars[3] - 'a';
				union(father, left, right);
			}
		}
		for (int i = 0; i < equations.length; ++i) {
			char[] chars = equations[i].toCharArray();
			if (chars[1] == '!') {
				int left = find(father, chars[0] - 'a'), right = find(father, chars[3] - 'a');
				if (left == right)
					return false;
			}
		}
		return true;
	}

	public void union(int[] father, int a, int b) {
		int roota = find(father, a), rootb = find(father, b);
		if (roota == rootb)
			return;
		else if (roota < rootb)
			father[rootb] = roota;
		else
			father[roota] = rootb;
	}

	public int find(int[] father, int index) {
		while (index != father[index]) {
			father[index] = father[father[index]];
			index = father[index];
		}
		return index;
	}
}
