package leetcode.leetcode1000_1499;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leet1424 {

    //Tle 其实不需要全部遍历
    //优化之后可以过了
/*    public int[] findDiagonalOrder(List<List<Integer>> nums) {
    List<Integer> res=new ArrayList<>();
    int diagonal=0;
    boolean flag=true;
    int end=0;
    boolean []arr=new boolean[nums.size()];
    while (flag==true){
       flag=false;
        for (int i = Math.min(diagonal,nums.size()-1); i>=end; i--) {
            if(arr[i]==true) continue;
           int index=diagonal-i;
           if(index>=nums.get(i).size()){
               arr[i]=true;
               continue;
           }
           res.add(nums.get(i).get(index));
           flag=true;
        }
        diagonal++;
        while (end<arr.length&&arr[end]==true){
            end++;
        }
    }
    int []r=new int[res.size()];
        for (int i = 0; i < r.length; i++) {
            r[i]=res.get(i);
        }
        return r;
    }*/



    //可以直接从下往上遍历
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
    Map<Integer,List<Integer>> map=new HashMap<>();
    int count=0;
    int maxKey=0;
        for (int row = nums.size() - 1; row >= 0; row--) {
           for(int col=0;col<nums.get(row).size();col++){
               if(!map.containsKey(row+col)) map.put(row+col,new ArrayList<>());
               map.get(row+col).add(nums.get(row).get(col));
               maxKey=Math.max(maxKey,row+col);
               count++;
           }
        }

        int []res=new int[count];
        int i=0;
      for(int k=0;k<=maxKey;k++){
          List<Integer> list=map.get(k);
          for (Integer integer : list) {
              res[i++]=integer;
          }
      }
      return res;
    }
}
