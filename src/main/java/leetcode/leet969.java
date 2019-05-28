package leetcode;

import java.util.LinkedList;
import java.util.List;

public class leet969 {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> result = new LinkedList<>();
        int max = A.length;
        while (max > 0) {
            int maxIndex = findMax(A, max);
            flip(A, maxIndex);
            flip(A, max);

            result.add(maxIndex);
            result.add(max);
            max--;
        }
        return result;
    }


    int findMax(int[] A, int max) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == max) return i+1;
        }
        return -1;
    }


    void flip(int[] A, int index) {
        index--;
        int i = 0;
        while (i < index) {
            int temp = A[i];
            A[i] = A[index];
            A[index] = temp;
            i++;
            index--;
        }

    }
}
