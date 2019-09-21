package leetcode.leetcode1_499;

import java.util.*;

/**
 * Created by libin on 2019/3/3.
 */
public class leet51 {

    int N=0;
   // int sum=0;
    List<List<String>> result=new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {
        int []x=new int[n];
        N=n;
        dfs(0,x);
        //System.out.println(sum);
        return result;
    }

    void dfs(int t,int x[]){
        //到达底部
        if (t >= N) {
     // sum++;
            String [] s=new String[N];
            for (int i=0;i<N;i++){
                 s[x[i]]=constructQStirng(i);
            }
            result.add(Arrays.asList(s));
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

     String constructQStirng(int index){
       StringBuilder sb=new StringBuilder();
       for(int i=0;i<N;i++){
           if(index==i) sb.append("Q");
           else sb.append(".");
       }
       return sb.toString();
    }

/*
    //set做法
    private Set<Integer> col = new HashSet<Integer>();
    private Set<Integer> diag1 = new HashSet<Integer>();
    private Set<Integer> diag2 = new HashSet<Integer>();

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(res,new ArrayList<String>(), 0, n);
        return res;
    }
    private void dfs(List<List<String>> res, List<String> list, int row, int n){
        if (row == n){
            res.add(new ArrayList<String>(list));
            return;
        }
        for (int i = 0; i < n; i++){
            if (col.contains(i) || diag1.contains(row + i) || diag2.contains(row - i)) continue;

            char[] charArray = new char[n];
            Arrays.fill(charArray, '.');
            charArray[i] = 'Q';
            String rowString = new String(charArray);

            list.add(rowString);
            col.add(i);
            diag1.add(row + i);
            diag2.add(row - i);

            dfs(res, list, row + 1, n);

            list.remove(list.size() - 1);
            col.remove(i);
            diag1.remove(row + i);
            diag2.remove(row - i);
        }
    }*/
}
