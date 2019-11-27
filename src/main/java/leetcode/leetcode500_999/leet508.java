package leetcode.leetcode500_999;


import java.util.*;

public class leet508 {


    Map<Integer,Integer> map=new HashMap<>();
    int max=0;
    public int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        helper(root);
        for(int key:map.keySet()){
            if(map.get(key)==max)
                list.add(key);
        }
        int []result=new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i]=list.get(i);
        }
        return result;


        // return res.stream().mapToInt(i->i).toArray();
    }
    int helper(TreeNode node){
        if(node==null) return 0;
        int subtreeSum=node.val+helper(node.left)+helper(node.right);
    int value=map.getOrDefault(subtreeSum,0)+1;
         map.put(subtreeSum,value);
         max=Math.max(max,value);
         return subtreeSum;
    }
}
