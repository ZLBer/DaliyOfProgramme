package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leet113 {


    //mine  就简单的回溯就好了
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        helper(root,new ArrayList<>(),0,sum);
        return res;
    }

    List<List<Integer>> res=new ArrayList<>();
    void helper(TreeNode node,List<Integer> list,int sum,int taget){
        if(node==null) return;

        list.add(node.val);
        sum+=node.val;
        if(node.left==null&&node.right==null){
            if(sum==taget){
                res.add(new ArrayList<>(list));
            }
            //别忘了这里也要回溯
            list.remove(list.size()-1);
            return;
        }
        helper(node.left,list,sum,taget);

        helper(node.right,list,sum,taget);

        list.remove(list.size()-1);
        sum-=node.val; //其实没必要

    }
}

