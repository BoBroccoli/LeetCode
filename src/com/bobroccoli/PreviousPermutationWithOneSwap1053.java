package com.bobroccoli;

public class PreviousPermutationWithOneSwap1053 {
	public int[] prevPermOpt1(int[] A) {
		int i = A.length-1;
        while(i-1 >= 0){
            if(A[i-1] > A[i]){
                //swap the one just smaller than i-1
                int index = i;
				//find the number just smaller than i-1
                while(index < A.length && A[index] < A[i-1])
                    index++;
				//special case for equal, if equals, swap with the first
                while(A[index-1] == A[index-2])
                    index--;
                swap(A, i-1, index-1);
                return A;
            }
            else
                i--;
        }
        return A;
    }
    
    public void swap(int[] A, int a, int b){
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}
