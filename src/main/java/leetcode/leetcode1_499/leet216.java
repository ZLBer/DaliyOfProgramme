package leetcode.leetcode1_499;

import java.util.ArrayList;
import java.util.List;

public class leet216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
    helper(k,n,new ArrayList<>(),0);
    return res;
    }


   List<List<Integer>> res=new ArrayList<>();
  void helper(int k,int n,List<Integer> list,int pre){
    if(k==0&&n==0){
    res.add(new ArrayList<>(list));
    }
   if(k<=0||n<=0){
       return;
   }

  for(int i=pre+1;i<=9;i++){
     list.add(i);
     helper(k-1,n-i,list,i);
     list.remove(list.size()-1);
  }
  }



  //可以进行枚举 然后检查状态
/*
  List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        //所有的都遍历
        for (int mask = 0; mask < (1 << 9); ++mask) {
            if (check(mask, k, n)) {
                ans.add(new ArrayList<Integer>(temp));
            }
        }
        return ans;
    }

    public boolean check(int mask, int k, int n) {
        temp.clear();
        for (int i = 0; i < 9; ++i) {
            if (((1 << i) & mask) != 0) {
                temp.add(i + 1);
            }
        }
        if (temp.size() != k) {
            return false;
        }
        int sum = 0;
        for (int num : temp) {
            sum += num;
        }
        return sum == n;
    }
*/


}
