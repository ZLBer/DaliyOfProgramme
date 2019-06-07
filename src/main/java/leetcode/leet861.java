package leetcode;

public class leet861 {
    //mine 确实对 但是总是不太理解
    public int matrixScore(int[][] A) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < A[0].length; j++) {
                    A[i][j] = 1 - A[i][j];
                }
            }
        }

        result += (1 << (A[0].length - 1)) * A.length;

        for (int i = 1; i < A[0].length; i++) {
            int count = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j][i] == 1) count++;
            }
            if (count <=A.length / 2) count = A.length - count;
            result += (1 << (A[0].length - i - 1)) * count;
            System.out.println(result+"  "+count);
        }
        return result;
    }
}
