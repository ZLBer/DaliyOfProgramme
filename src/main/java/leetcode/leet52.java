package leetcode;

import java.util.*;

/**
 * Created by libin on 2019/3/3.
 */
public class leet52 {
    int N=0;
  int sum=0;
    public int totalNQueens(int n) {
        int []x=new int[n];
        N=n;
        dfs(0,x);
        return sum;
    }

    void dfs(int t,int x[]){
        //到达底部
        if (t >= N) {
           sum++;

        }
        else {
            for(int i=0;i<N;i++){
                x[t]=i;
                if(isPlace(t,x)) dfs(t+1,x);
            }
        }

    }

    boolean isPlace(int t,int x[]){
        for(int i=0;i<t;i++){
            if(Math.abs(t-i)==Math.abs(x[i]-x[t])||(x[i]==x[t]))
                return false;
        }
        return true;
    }

/*

    *//**
     * don't need to actually place the queen,
     * instead, for each row, try to place without violation on
     * col/ diagonal1/ diagnol2.
     * trick: to detect whether 2 positions sit on the same diagnol:
     * if delta(col, row) equals, same diagnol1;
     * if sum(col, row) equals, same diagnal2.
     *//*
//用set来来保存列号和斜率
    //列号
    private final Set<Integer> occupiedCols = new HashSet<Integer>();
    //斜率为负对角线
    private final Set<Integer> occupiedDiag1s = new HashSet<Integer>();
    //斜率为正对角线
    private final Set<Integer> occupiedDiag2s = new HashSet<Integer>();
    public int totalNQueens(int n) {
        return totalNQueensHelper(0, 0, n);
    }

    private int totalNQueensHelper(int row, int count, int n) {
        for (int col = 0; col < n; col++) {
            if (occupiedCols.contains(col))
                continue;
            int diag1 = row - col;
            if (occupiedDiag1s.contains(diag1))
                continue;
            int diag2 = row + col;
            if (occupiedDiag2s.contains(diag2))
                continue;
            // we can now place a queen here
            if (row == n-1)
                count++;
            else {
                occupiedCols.add(col);
                occupiedDiag1s.add(diag1);
                occupiedDiag2s.add(diag2);
                count = totalNQueensHelper(row+1, count, n);
                // recover
                occupiedCols.remove(col);
                occupiedDiag1s.remove(diag1);
                occupiedDiag2s.remove(diag2);
            }
        }

        return count;
    }*/
}
