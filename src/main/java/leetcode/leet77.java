package leetcode;

import java.util.*;

public class leet77 {
    //mine
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
          helper(1,n,new ArrayList<>(),k);
          return result;
    }


    void helper(int cur,int n,List<Integer> list,int k){
       if(list.size()==k){
           //复制一个 防止之后篡改
           result.add(new ArrayList<>(list));
           return;
       }
       if(cur>n) return;
      if(n-cur+1<k-list.size()) return;  //在下面启发下加的剪枝，瞬间快乐
       helper(cur+1,n,list,k);
       list.add(cur);
       helper(cur+1,n,list,k);
       list.remove(list.size()-1);
    }



    //Backtracking  居然没我的快？

  /*  public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<List<Integer>>();
        combine(combs, new ArrayList<Integer>(), 1, n, k);
        return combs;
    }
    public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
        if(k==0) {
            combs.add(new ArrayList<Integer>(comb));
            return;
        }

        //用for貌似可以省去很多递归

        //很棒的优化 省去一些不可能的情况  就是说剩下的数不足以拼成k个  相当于剪枝了
        for (int i = start; i <= n-k + 1 ; i++) {

     //   for(int i=start;i<=n;i++) {
            comb.add(i);
            combine(combs, comb, i+1, n, k-1);
            comb.remove(comb.size()-1);
        }
    }*/


// C(n,k)=C(n-1,k-1)+C(n-1,k).
    // 这个是从n到1遍历
/*
    public List<List<Integer>> combine(int n, int k) {
        //剩下的不能组成
        if (k == n || k == 0) {
            List<Integer> row = new LinkedList<>();
            for (int i = 1; i <= k; ++i) {
                row.add(i);
            }
            //返回一个结果的组合
            return new LinkedList<>(Arrays.asList(row));
        }
        //表示已经选中了n 从 n - 1 里边选 k - 1 个，然后每个结果加上 n
        List<List<Integer>> result = this.combine(n - 1, k - 1);
        result.forEach(e -> e.add(n));
        //没有选中n  从 n - 1 个里边直接选 k 个。
        result.addAll(this.combine(n - 1, k));
        return result;
    }
*/


    //遍历  确实慢 ，涉及到太多次遍历
 /*   public List<List<Integer>> combine(int n, int k) {
        if (k == 0 || n == 0 || k > n) return Collections.emptyList();
        //结果列表
        List<List<Integer>> combs = new ArrayList<>();
        //把所有数字都塞进去
        for (int i = 1; i <= n; i++) combs.add(Arrays.asList(i));
        //从2到k
        //其实每次都把长度不够都会淘汰掉了
        for (int i = 2; i <= k; i++) {
            List<List<Integer>> newCombs = new ArrayList<>();
            //只和它后面的数字交流
            for (int j = i; j <= n; j++) {
                for (List<Integer> comb : combs) {
                    if (comb.get(comb.size()-1) < j) {
                        //复制一个新的 并塞进去j
                        List<Integer> newComb = new ArrayList<>(comb);
                        newComb.add(j);
                        newCombs.add(newComb);
                    }
                }
            }
            //替换
            combs = newCombs;
        }
        return combs;
    }*/
}
